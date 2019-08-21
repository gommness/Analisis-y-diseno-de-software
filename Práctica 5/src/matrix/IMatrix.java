package matrix;

import java.util.*;

import element.IMatrixElement;
import exception.IllegalPositionException;

public interface IMatrix <T> {
	/**
	 * @return el numero de columnas de la matriz
	 */
	int getCols();

	/**
	 * @return el numero de filas de la matriz
	 */
	int getRows();

	/**
	 * comprueba si una posicion es lega o no
	 * @param i la coordenada i de la posicion
	 * @param j la coodenada j de la posicion
	 * @return true si es legal, false si no lo es
	 */
	boolean isLegalPosition(int i, int j);

	/**
	 * añade un elemento a la matriz
	 * @param element el elemento a añadir
	 * @throws IllegalPositionException
	 */
	void addElement(IMatrixElement<T> element) throws IllegalPositionException;

	/**
	 * devuelve un elemento de la matriz en la posicion especificada
	 * @param i la coordenada i
	 * @param j la coordenada j
	 * @return el elemento que se encontraba en esas coordenadas
	 * @throws IllegalPositionException
	 */
	IMatrixElement<T> getElementAt(int i, int j) throws IllegalPositionException;

	/**
	 * devuelve una lista con los elementos al rededor del elemento con la posicion especificada
	 * @param i la coordenada i
	 * @param j la coordenada j
	 * @return la lista con los elementos vecinos
	 * @throws IllegalPositionException
	 */
	List<IMatrixElement<T>> getNeighboursAt(int i, int j) throws IllegalPositionException;

	/**
	 * @return la matriz como si fuera una lista
	 */
	List<IMatrixElement<T>> asList();
	
	/**
	 * @param c el patron de ordenacion
	 * @return la matriz como si fuera una lista, ordenada segun el patron especificado
	 */
	List<IMatrixElement<T>> asListSortedBy(Comparator<IMatrixElement<T>> c);
}
