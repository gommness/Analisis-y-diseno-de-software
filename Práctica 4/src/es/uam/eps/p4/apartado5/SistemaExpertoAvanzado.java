package es.uam.eps.p4.apartado5;

import es.uam.eps.p4.estadistica.*;
import es.uam.eps.p4.exception.AttributeFormatException;

import java.io.InvalidClassException;
import java.util.*;

import es.uam.eps.p4.apartado4.*;
import es.uam.eps.p4.model.*;

/**
 * Esta clase es un sistema experto avanzado que extiende del normal y en el que
 * se tiene en cuenta la desviacion tipica a la hora de clasificar las
 * instancias
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 * @param <T> el tipo de sistema experto avanzado
 */
public class SistemaExpertoAvanzado<T> extends SistemaExperto<T> {

	private Map<Attribute<T>, CaseEstadistico> mapaAvanzado; /*
																 * Añado un
																 * nuevo mapa en
																 * el que
																 * almaceno los
																 * atributos
																 * junto a su
																 * Mean y su
																 * StdDev
																 */
	private List<Double> pesos;

	/**
	 * @param type
	 *            el tipo de problema
	 */
	public SistemaExpertoAvanzado(Type<T> type) {
		super(type);
		mapaAvanzado = new LinkedHashMap<>();
		for (Attribute<T> a : this.attr) {
			mapaAvanzado.put(a, new CaseEstadistico(new Mean(), new StdDev()));
		}
		this.pesos = new ArrayList<>();
	}

	/**
	 * @param pesos
	 *            a poner
	 * @throws AttributeFormatException la excepcion
	 */
	public void setPesos(double... pesos) throws AttributeFormatException {
		if (pesos.length != this.attr.size())
			throw new AttributeFormatException();
		for (double p : pesos)
			this.pesos.add(p);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uam.eps.p4.apartado4.SistemaExperto#addCase(es.uam.eps.p4.model.
	 * Instance, java.lang.String)
	 */
	@Override
	public void addCase(Instance<T> instace, String aClass) throws InvalidClassException {
		super.addCase(instace, aClass);
		/*
		 * Ademas de modificar los campos anteriores, debemos modificar el nuevo
		 * mapa
		 */
		for (Attribute<T> a : mapaAvanzado.keySet()) {
			mapaAvanzado.get(a).getMedia().addValue(instace.getValue(a));
			mapaAvanzado.get(a).getDesviacion().addValue(instace.getValue(a));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.uam.eps.p4.apartado4.SistemaExperto#testInstance(es.uam.eps.p4.model.
	 * Instance)
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
				double v1, v2;
				/*
				 * Aplico la formula a los componentes del vector de instancia y
				 * de clase
				 */
				if (mapaAvanzado.get(this.attr.get(i)).getDesviacion().getResult() != 0) {

					v1 = (valores.get(i) - mapaAvanzado.get(this.attr.get(i)).getMedia().getResult())
							/ mapaAvanzado.get(this.attr.get(i)).getDesviacion().getResult();
					v2 = (mapa.get(s).get(i).getResult() - mapaAvanzado.get(this.attr.get(i)).getMedia().getResult())
							/ mapaAvanzado.get(this.attr.get(i)).getDesviacion().getResult();
				} else {/* si la desviacion tipica es 0 ambos valen 0 */
					v1 = 0;
					v2 = 0;
				}
				/* le aplico los pesos a cada uno de los atributos */
				distancia += this.pesos.get(i) * Math.pow(v1 - v2, 2);
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
