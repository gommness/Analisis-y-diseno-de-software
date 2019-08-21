package element;

import exception.IllegalPositionException;
import matrix.IMatrixExp;

public class VirtualMatrixElementImpl<T> implements IMatrixElement<T> {
	
	private int i;
	private int j;
	private T element;
	private IMatrixExp<T> master;
	boolean empty = true;
	
	/**
	 * constructor del elemento virtual
	 * @param i la posicion i del elemento
	 * @param j la posicion j del elemento
	 * @param master la matriz a la que pertenece el elemento virtual
	 */
	public VirtualMatrixElementImpl(int i, int j, IMatrixExp<T> master) {
		this.i = i;
		this.j = j;
		this.element = null;
		this.master = master;
	}

	/* (non-Javadoc)
	 * @see element.IMatrixElement#getI()
	 */
	@Override
	public int getI() {
		return this.i;
	}

	/* (non-Javadoc)
	 * @see element.IMatrixElement#getJ()
	 */
	@Override
	public int getJ() {
		return this.j;
	}

	/* (non-Javadoc)
	 * @see element.IMatrixElement#getElement()
	 */
	@Override
	public T getElement() {
		IMatrixElement<T> out = null;
		try {
			out = this.master.getElementAt(this.i, this.j);
		} catch (IllegalPositionException e) {
			return null;
		}
		if(this.equals(out))
			return this.element;
		return out.getElement();
	}

	/* (non-Javadoc)
	 * @see element.IMatrixElement#setElement(java.lang.Object)
	 */
	@Override
	public void setElement(T element) {
		IMatrixElement<T> in = null;
		try {
			in = this.master.getElementAt(this.i, this.j);
			if(this.equals(in))
			{
				//le pido a la factoria de mi maestro que cree un elemento en mi posicion
				this.master.addElement(this.master.getFactory().giveElem(this.i, this.j, element));
				return;
			}
			this.master.getElementAt(this.i, this.j).setElement(element);
		} catch (IllegalPositionException e) {
			return;
		}
		this.empty = false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override public boolean equals(Object o){
		if(!(o instanceof VirtualMatrixElementImpl))
			return false;
		VirtualMatrixElementImpl<?> other = (VirtualMatrixElementImpl<?>) o;
		return this.j == other.j && this.i == other.i && this.empty == other.empty;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override public int hashCode(){
		return this.element.hashCode() + 2*i + 3*j;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override public String toString(){
		if(this.element != null)
			return this.element.toString();
		return "0";
	}

}
