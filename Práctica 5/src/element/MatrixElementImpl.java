package element;

public class MatrixElementImpl<T> implements IMatrixElement<T> {
	
	private int i;
	private int j;
	private T element;
	
	/**
	 * El constructor del elemento
	 * @param i la posicion i
	 * @param j la posicion j
	 * @param element el contenido a asignar
	 */
	public MatrixElementImpl(int i, int j, T element) {
		this.i = i;
		this.j = j;
		this.element = element;
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
		return this.element;
	}

	/* (non-Javadoc)
	 * @see element.IMatrixElement#setElement(java.lang.Object)
	 */
	@Override
	public void setElement(T element) {
		this.element = element;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override public boolean equals(Object o){
		if(!(o instanceof MatrixElementImpl))
			return false;
		MatrixElementImpl<?> other = (MatrixElementImpl<?>) o;
		return this.element.equals(other.element);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override public int hashCode(){
		return this.element.hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override public String toString(){
		return this.element.toString();
	}

}
