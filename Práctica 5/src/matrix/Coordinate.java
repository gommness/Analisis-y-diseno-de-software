package matrix;

import java.util.*;

import exception.DimensionException;

public class Coordinate {
	int dim;
	List<Integer> coords;

	/**
	 * constructor de coordenadas
	 * @param dim la dimension de las coordenadas
	 */
	public Coordinate(int dim){
		this.dim = dim;
		this.coords = new ArrayList<Integer>();
	}
	
	/**
	 * crea una coordenada
	 * @param a un array de coordenadas
	 */
	public Coordinate(Integer ... a){
		this.dim = a.length;
		this.coords = new ArrayList<Integer>(Arrays.asList(a));
	}
	
	/**
	 * devuelve el valor de la coordenada numero "num" 
	 * @param num empezando por 0, el �ndice de la coordenada a devolver
	 * @return el valor de la coordenada especificada
	 * @throws DimensionException en caso de que la dimension sea invalida
	 */
	public int getCoord(int num) throws DimensionException{
		if(num>this.dim || num < 0) throw new DimensionException();
		return this.coords.get(num);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override public boolean equals(Object o){
		if(!(o instanceof Coordinate))return false;
		Coordinate other = (Coordinate) o;
		if (other.dim != this.dim) return false;
		for(int i = 0; i<this.dim; i++){
			if(!(this.coords.get(i).equals(other.coords.get(i))))
				return false;
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override public int hashCode(){
		int hash;
		hash = 2*this.dim;
		for(int i = 0; i<this.dim; i++)
			try {
				hash += ((Math.sqrt(2)*Math.pow(10, i))%10)*this.getCoord(i);//el decimal i-esimo de la raiz de dos multiplicado por la coordenada i-esima
			} catch (DimensionException e) {
				hash += i;
			}
		return hash;
	}
	
}
