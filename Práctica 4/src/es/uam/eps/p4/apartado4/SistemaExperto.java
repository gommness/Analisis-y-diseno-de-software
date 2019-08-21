package es.uam.eps.p4.apartado4;

import java.io.*;
import java.util.*;
import es.uam.eps.p4.estadistica.*;

import es.uam.eps.p4.model.*;

/**
 * Esta clase implementa la interfaz Expert
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class SistemaExperto<T> implements Expert<T> {
	protected List<Attribute<T>> attr;
	protected Map<String, List<Mean>> mapa; /*
											 * La clave son las clases y los
											 * valores son sus respectivas
											 * medias para cada uno de los
											 * atributos del tipo de problema
											 */

	/**
	 * @param type
	 *            es el tipo de problema
	 */
	public SistemaExperto(Type<T> type) {
		this.attr = type.getAttributes();
		mapa = new LinkedHashMap<String, List<Mean>>();
		for (String s : type.getClasses()) {
			mapa.put(s, new ArrayList<Mean>());
			for (int i = 0; i < attr.size(); i++) {
				mapa.get(s).add(new Mean());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uam.eps.p4.model.Expert#addCase(es.uam.eps.p4.model.Case)
	 */
	@Override
	public void addCase(Case<T> aCase) throws InvalidClassException {
		addCase(aCase.getInstance(), aCase.getClassName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uam.eps.p4.model.Expert#addCase(es.uam.eps.p4.model.Instance,
	 * java.lang.String)
	 */
	@Override
	public void addCase(Instance<T> instace, String aClass) throws InvalidClassException {
		if (!mapa.containsKey(aClass))
			throw new InvalidClassException("La clase no está contenida");
		for (int i = 0; i < attr.size(); i++)
			mapa.get(aClass).get(i).addValue(instace.getValue(attr.get(i)));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.uam.eps.p4.model.Expert#testInstance(es.uam.eps.p4.model.Instance)
	 */
	@Override
	public String testInstance(Instance<T> instance) {
		List<Double> valores = new ArrayList<Double>(); /*
														 * la lista de valores
														 * de la instancia
														 */
		double min = Double.POSITIVE_INFINITY; /*
												 * inicializo la distancia
												 * minima
												 */
		for (Attribute<T> a : attr)
			valores.add(instance.getValue(a));

		int j = 0, imin = 0; /*
								 * imin es el indice de la clase donde la
								 * distancia es minima
								 */
		for (String s : mapa.keySet()) { /* recorro cada una de las clases */
			double distancia = 0;
			for (int i = 0; i < attr
					.size(); i++) { /*
									 * calculo la distancia entre el vector de
									 * valores des la instancia y las medias de
									 * la clase
									 */
				distancia += Math.pow((valores.get(i) - mapa.get(s).get(i).getResult()), 2);
			}
			if (min > distancia) {
				min = distancia; /* cojo la distancia minima */
				imin = j; /*
							 * actualizo el indice de la clase en la cual la
							 * distancia me ha salido minim
							 */
			}
			j++;
		}
		return instance.getType().getClasses().get(imin);
	}
}
