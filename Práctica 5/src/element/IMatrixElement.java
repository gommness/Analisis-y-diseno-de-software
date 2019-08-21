package element;

public interface IMatrixElement <T>{
	/**
	 * devuelve la coordenada i
	 * @return  la coordenada i
	 */
	int getI();
	/**
	 * devuelve la coordenada j
	 * @return la coordenada j
	 */
	int getJ();
	/**
	 * devuelve el contenido del elemento
	 * @return el contenido del elemento
	 */
	T getElement();
	/**
	 * asigna un contenido
	 * @param element el contenido a asignar
	 */
	void setElement(T element);
}
