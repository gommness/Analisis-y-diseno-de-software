package element;

import matrix.IMatrixExp;

public class FactoryElementImpl<T> implements IFactoryElement<T>{

	private IMatrixExp<T> matrix;
	
	/* (non-Javadoc)
	 * @see element.IFactoryElement#setMatrix(matrix.IMatrixExp)
	 */
	@Override
	public void setMatrix(IMatrixExp<T> m) {
		this.matrix = m;
	}

	/* (non-Javadoc)
	 * @see element.IFactoryElement#getMatrix()
	 */
	@Override
	public IMatrixExp<T> getMatrix() {
		return this.matrix;
	}

	/* (non-Javadoc)
	 * @see element.IFactoryElement#giveVirtualElem(int, int)
	 */
	@Override
	public IMatrixElement<T> giveVirtualElem(int i, int j) {
		return new VirtualMatrixElementImpl<T>(i,j,this.matrix);
	}

	/* (non-Javadoc)
	 * @see element.IFactoryElement#giveElem(int, int, java.lang.Object)
	 */
	@Override
	public IMatrixElement<T> giveElem(int i, int j, T elem) {
		return new MatrixElementImpl<T>(i, j, elem);
	}
	
	/* (non-Javadoc)
	 * @see element.IFactoryElement#copy()
	 */
	public IFactoryElement<T> copy(){
		return new FactoryElementImpl<T>();
	}

}
