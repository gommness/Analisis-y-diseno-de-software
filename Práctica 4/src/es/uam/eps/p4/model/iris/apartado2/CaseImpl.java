package es.uam.eps.p4.model.iris.apartado2;

import es.uam.eps.p4.model.Case;
import es.uam.eps.p4.model.Instance;

/**
 * Esta clase implementa el caso
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 * @param <T> el tipo de caso
 */
public class CaseImpl<T> implements Case<T> {
	private Instance<T> inst;
	private String clase;

	/**
	 * @param inst
	 *            la instancia del caso
	 * @param clase
	 *            la clase del caso
	 */
	public CaseImpl(Instance<T> inst, String clase) {
		this.inst = inst;
		this.clase = clase;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uam.eps.p4.model.Case#getInstance()
	 */
	@Override
	public Instance<T> getInstance() {
		return inst;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uam.eps.p4.model.Case#getClassName()
	 */
	@Override
	public String getClassName() {
		return clase;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return inst + " Es de la clase: " + clase;
	}

}
