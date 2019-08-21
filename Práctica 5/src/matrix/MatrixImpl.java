package matrix;

import java.util.*;

import element.IFactoryElement;
import element.IMatrixElement;
import exception.IllegalPositionException;

public class MatrixImpl<T> implements IMatrixExp<T> {

	private IFactoryElement<T> factory;
	private int cols;
	private int rows;
	private HashMap<Coordinate, IMatrixElement<T>> matriz = new HashMap<>();

	/**
	 * constructor de la matriz
	 * @param rows el numero de filas de la matriz
	 * @param cols el numero de columnas de la matriz
	 * @param factory la factoria de la matriz
	 */
	public MatrixImpl(int rows, int cols, IFactoryElement<T> factory) {
		this.cols = cols;
		this.rows = rows;
		this.factory = factory;
		this.factory.setMatrix(this);
	}

	/* (non-Javadoc)
	 * @see matrix.IMatrix#getCols()
	 */
	@Override
	public int getCols() {
		return this.cols;
	}

	/* (non-Javadoc)
	 * @see matrix.IMatrix#getRows()
	 */
	@Override
	public int getRows() {
		return this.rows;
	}

	/* (non-Javadoc)
	 * @see matrix.IMatrix#isLegalPosition(int, int)
	 */
	@Override
	public boolean isLegalPosition(int i, int j) {
		return !(i < 0 || j < 0 || i >= this.rows || j >= this.cols);
	}

	/* (non-Javadoc)
	 * @see matrix.IMatrix#addElement(element.IMatrixElement)
	 */
	@Override
	public void addElement(IMatrixElement<T> element) throws IllegalPositionException {
		if (!this.isLegalPosition(element.getI(), element.getJ()))
			throw new IllegalPositionException();
		this.matriz.put(new Coordinate(element.getI(), element.getJ()), element);
	}

	/* (non-Javadoc)
	 * @see matrix.IMatrix#getElementAt(int, int)
	 */
	@Override
	public IMatrixElement<T> getElementAt(int i, int j) throws IllegalPositionException {
		if (!this.isLegalPosition(i, j))
			throw new IllegalPositionException();
		IMatrixElement<T> out = this.matriz.get(new Coordinate(i, j));
		if (out == null)
			return this.factory.giveVirtualElem(i, j);
		return out;
	}

	/* (non-Javadoc)
	 * @see matrix.IMatrix#getNeighboursAt(int, int)
	 */
	@Override
	public List<IMatrixElement<T>> getNeighboursAt(int i, int j) throws IllegalPositionException {
		int k;
		int p;
		if (!this.isLegalPosition(i, j))
			throw new IllegalPositionException();
		List<IMatrixElement<T>> output = new ArrayList<IMatrixElement<T>>();
		IMatrixElement<T> neighboor;
		for (k = -1; k < 2; k++) {
			for (p = -1; p < 2; p++) {
				try {
					neighboor = this.getElementAt((i + k + this.getRows()) % this.getRows(),
							(j + p + this.getCols()) % this.getCols());
				} catch (IllegalPositionException e) {
					neighboor = null;
				}
				if (neighboor != null && (k != 0 || p != 0))
					output.add(neighboor);
			}
		}
		return output;
	}

	/* (non-Javadoc)
	 * @see matrix.IMatrix#asList()
	 */
	@Override
	public List<IMatrixElement<T>> asList() {
		return new ArrayList<>(this.matriz.values());
	}

	/* (non-Javadoc)
	 * @see matrix.IMatrix#asListSortedBy(java.util.Comparator)
	 */
	@Override
	public List<IMatrixElement<T>> asListSortedBy(Comparator<IMatrixElement<T>> c) {
		List<IMatrixElement<T>> list = this.asList();
		Collections.sort(list, c);
		return list;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof MatrixImpl))
			return false;
		MatrixImpl<?> other = (MatrixImpl<?>) o;
		if (this.cols != other.cols || this.rows != other.rows)
			return false;
		return this.asList().equals(other.asList());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hash;
		IMatrixElement<T> elem;
		int i, j;
		hash = 2 * this.cols + 3 * this.rows;
		for (i = 0; i < this.rows; i++) {
			for (j = 0; j < this.cols; j++) {
				try {
					elem = this.getElementAt(i, j);
				} catch (IllegalPositionException e) {
					elem = null;
				}
				if (elem != null) {
					hash += elem.hashCode() + Math.sqrt(2) * Math.pow(10, i) * i + Math.sqrt(3) * Math.pow(10, j) * j;
				}
			}
		}
		return hash;
	}

	/**
	 * clase que contiene un metodo de ordenacion por columnas
	 */
	public static class ColumnSort<T> implements Comparator<IMatrixElement<T>> {
		@Override
		public int compare(IMatrixElement<T> o1, IMatrixElement<T> o2) {
			int colDif = o1.getJ() - o2.getJ();
			if (colDif != 0)
				return colDif;
			else
				return o1.getI() - o2.getI();
		}
	}

	/**
	 * clase que contiene un metodo de ordenacion por filas
	 */
	public static class RowSort<T> implements Comparator<IMatrixElement<T>> {
		@Override
		public int compare(IMatrixElement<T> o1, IMatrixElement<T> o2) {
			int rowDif = o1.getI() - o2.getI();
			if (rowDif != 0)
				return rowDif;
			else
				return o1.getJ() - o2.getJ();
		}
	}

	/**
	 * clase que contiene un metodo de ordenacion por numeros pares
	 */
	public static class EvenSort implements Comparator<IMatrixElement<Integer>> {
		@Override
		public int compare(IMatrixElement<Integer> o1, IMatrixElement<Integer> o2) {
			if ((o1.getElement() % 2 == 0 && o2.getElement() % 2 == 0)
					|| (o1.getElement() % 2 == 1 && o2.getElement() % 2 == 1))// if
																				// both
																				// are
																				// even
																				// or
																				// both
																				// are
																				// odd
				return o2.getElement() - o1.getElement();// depends on bigger
															// number
			else
				return o2.getElement() * ((o2.getElement() + 1) % 2) - o1.getElement() * ((o1.getElement() + 1) % 2);// depends
																														// on
																														// which
																														// is
																														// even
			// being n a natural number: n*((n+1)%2) will be either 0 if the
			// number is odd or n if the number is even
		}
	}

	/**
	 * clase que contiene un metodo de ordenacion por numeros impares
	 */
	public static class OddSort implements Comparator<IMatrixElement<Integer>> {
		@Override
		public int compare(IMatrixElement<Integer> o1, IMatrixElement<Integer> o2) {
			if ((o1.getElement() % 2 == 0 && o2.getElement() % 2 == 0)
					|| (o1.getElement() % 2 == 1 && o2.getElement() % 2 == 1))// if
																				// both
																				// are
																				// even
																				// or
																				// both
																				// are
																				// odd
				return o2.getElement() - o1.getElement();// depends on bigger
															// number
			else
				return o2.getElement() * ((o2.getElement()) % 2) - o1.getElement() * ((o1.getElement()) % 2);// depends
																												// on
																												// which
																												// is
																												// odd
			// being n a natural number: n*((n)%2) will be either n if the
			// number is odd or 0 if the number is even
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String output = "";
		int i;
		int j;
		for (i = 0; i < this.rows; i++) {
			for (j = 0; j < this.cols; j++) {
				try {
					output += this.getElementAt(i, j).toString() + "|";
				} catch (IllegalPositionException e) {
					output += "-|";
				}
			}
			output += "\n";
		}
		return output;
	}

	/* (non-Javadoc)
	 * @see matrix.IMatrixExp#setFactory(element.IFactoryElement)
	 */
	@Override
	public void setFactory(IFactoryElement<T> fact) {
		this.factory = fact;
	}

	/* (non-Javadoc)
	 * @see matrix.IMatrixExp#getFactory()
	 */
	@Override
	public IFactoryElement<T> getFactory() {
		return this.factory;
	}
	
	/* (non-Javadoc)
	 * @see matrix.IMatrixExp#copy()
	 */
	public IMatrix<T> copy(){
		IMatrixElement<T> ele;
		IMatrixElement<T> copy;
		T content;
		int i,j;
		MatrixImpl<T> other = new MatrixImpl<T>(this.rows, this.cols, this.factory.copy());
		for(i=0; i<this.rows;i++){
			for(j=0;j<this.cols;j++){
				try {
					ele = this.getElementAt(i, j);
					content = ele.getElement();
					if(content != null){
						copy = this.factory.giveElem(i, j, content);
						other.addElement(copy);
					}
				} catch (IllegalPositionException e) {
					ele = null;
				}
			}
		}
		return other;
	}

}
