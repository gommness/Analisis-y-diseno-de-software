package es.uam.eps.p4.model.iris.apartado1;

import es.uam.eps.p4.exception.AttributeFormatException;
import es.uam.eps.p4.model.Attribute;

/**
 * Esta clase implementa el atributo
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class AttributeImpl<T> implements Attribute<T> {
	private int ordinal;
	private String name;

	/**
	 * @param ordinal
	 *            el ordinal que se le asocia
	 * @param string
	 *            el nombre del atributo
	 */
	public AttributeImpl(int ordinal, String string) {
		this.ordinal = ordinal;
		this.name = string;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uam.eps.p4.model.Attribute#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uam.eps.p4.model.Attribute#fromString(java.lang.String)
	 */
	@Override
	public double fromString(String v) throws AttributeFormatException {
		try {
			return Double.parseDouble(v);
		} catch (NumberFormatException e) {
			throw new AttributeFormatException();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uam.eps.p4.model.Attribute#getOrdinal()
	 */
	@Override
	public int getOrdinal() {
		return this.ordinal;
	}

}
