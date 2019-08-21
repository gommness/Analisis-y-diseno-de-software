
package es.uam.eps.p4.model.iris.apartado1;

import java.util.*;

import es.uam.eps.p4.exception.AttributeFormatException;
import es.uam.eps.p4.exception.InvalidValuesException;
import es.uam.eps.p4.model.Attribute;
import es.uam.eps.p4.model.Instance;
import es.uam.eps.p4.model.Type;

/**
 * Esta clase implementa Instance
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class InstanceImpl<T> implements Instance<T> {
	private List<String> values;
	private Type<T> type;

	/**
	 * @param values
	 *            los valores de la instancia
	 * @param type
	 *            el tipo de la instancia
	 * @throws InvalidValuesException la excepcion
	 */
	public InstanceImpl(List<String> values, Type<T> type) throws InvalidValuesException {
		this.values = new ArrayList<String>();
		try {
			for (int i = 0; i < values.size(); i++) {
				if (Double.parseDouble(
						values.get(i)) < 0) /*
											 * compruebo que no hay ningun valor
											 * negativo antes de añadirlos
											 */
					throw new InvalidValuesException();
			}
			this.values.addAll(values);
			this.type = type;
		} catch (NumberFormatException e) {
			throw new InvalidValuesException();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uam.eps.p4.model.Instance#getValue(es.uam.eps.p4.model.Attribute)
	 */
	public double getValue(Attribute<T> a) {
		try {
			return a.fromString(this.values.get(a.getOrdinal()));
		} catch (AttributeFormatException e) {
			e.printStackTrace();
			return -1;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uam.eps.p4.model.Instance#getType()
	 */
	public Type<T> getType() {
		return type;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return values.toString();
	}
}
