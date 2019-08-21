package es.uam.eps.p4.apartado5;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import es.uam.eps.p4.exception.AttributeFormatException;
import es.uam.eps.p4.exception.InvalidValuesException;
import es.uam.eps.p4.model.Case;
import es.uam.eps.p4.model.iris.apartado1.Iris;
import es.uam.eps.p4.model.iris.apartado2.CSVCaseReader;

public class TestSistemaExpertoAvanzado {

	public static void main(String[] args) {

		Iris iris = new Iris();

		try {
			SistemaExpertoAvanzado<Iris> s = new SistemaExpertoAvanzado<Iris>(iris);
			/*
			 * probamos los pesos que nos recomiendan y comprobamos que salen
			 * pocos fallos
			 */
			s.setPesos(0.1, 0.025, 0.55, 0.325);
			List<Case<Iris>> casos = CSVCaseReader.<Iris> leer("txt/bezdekIris.data",
					",", "UTF-8", iris);
			Collections.shuffle(casos);

			int size = casos.size()
					/ 2; /* tamaño de la mitad de la lista de casos */
			int i, aciertos = 0,
					fallos = 0; /*
								 * aciertos y fallos nos contabilizan el numero
								 * de veces que la clasificación ha sido
								 * correcta
								 */
			for (i = 0; i < size; i++) /*
										 * la primera mitad de los casos los
										 * añado
										 */
				s.addCase(casos.get(i));

			for (; i < casos.size(); i++) { /*
											 * compruebo los valores para ver si
											 * los ha clasificado correctamente
											 */
				String clase = s.testInstance(casos.get(i).getInstance());
				if (casos.get(i).getClassName().equals(clase))
					aciertos++;
				else
					fallos++;
			}
			double porcentajeFallos = fallos * 100 / (aciertos + fallos);
			System.out.println("Ha habido " + aciertos + " aciertos y " + porcentajeFallos + "% fallos");
		} catch (AttributeFormatException | IOException | InvalidValuesException e) {
			e.printStackTrace();
		}
	}

}
