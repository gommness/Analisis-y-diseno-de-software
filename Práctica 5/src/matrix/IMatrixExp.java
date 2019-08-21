package matrix;

import element.IFactoryElement;

public interface IMatrixExp<T> extends IMatrix<T>{

	/**
	 * asigna una factoria a la matriz
	 * @param fact la factoria a asignar
	 */
	public void setFactory(IFactoryElement<T> fact);
	
	/**
	 * @return devuelve la factoria asignada a la matriz
	 */
	public IFactoryElement<T> getFactory();
	
	/**
	 * @return una copia de la matriz actual
	 */
	public IMatrix<T> copy();
	
}
