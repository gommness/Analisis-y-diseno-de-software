package element;

import matrix.IMatrixExp;

public interface IFactoryElement<T> {

	/**
	 * le asigna una matrix a la factoria
	 * @param m la matriz a asignar
	 */
	public void setMatrix(IMatrixExp<T> m);
	
	/**
	 * devuelve la matriz a la que pertenece la factoria
	 * @return la matriz a la que pertenece la factoria
	 */
	public IMatrixExp<T> getMatrix();
	
	/**
	 * devuelve un elemento virtual
	 * @param i la posicion i del elemento
	 * @param j la posicion j del elemento
	 * @return el elemento virtual
	 */
	public IMatrixElement<T> giveVirtualElem(int i, int j);
	
	/**
	 * devuelve un elemento nuevo
	 * @param i la posicion i del elemento
	 * @param j la posicion j del elemento
	 * @param elem el contenido del elemento
	 * @return el nuevo elemento
	 */
	public IMatrixElement<T> giveElem(int i, int j, T elem);
	
	/**
	 * @return una copia de la factoria
	 */
	public IFactoryElement<T> copy();
	
}
