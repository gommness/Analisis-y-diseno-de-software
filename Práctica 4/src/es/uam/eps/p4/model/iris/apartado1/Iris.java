package es.uam.eps.p4.model.iris.apartado1;

import java.util.*;

import es.uam.eps.p4.exception.InvalidValuesException;
import es.uam.eps.p4.model.Attribute;
import es.uam.eps.p4.model.Instance;
import es.uam.eps.p4.model.Type;

/**
 * Esta clase Iris implementa Type
 * 
 * @author Javier Gomez &lt;javier.gomezmartinez@estudiante.uam.es&gt;
 * @author Carlos Li &lt;carlos.li@estudiante.uam.es&gt;
 */
public class Iris implements Type<Iris> {
	private List<Attribute<Iris>> attr;
	private List<String> classes;

	/**
	 * Esta clase inicializa los datos iniciales de la clase
	 */
	public Iris() {
		this.attr = new ArrayList<Attribute<Iris>>();
		this.attr.add(new AttributeImpl<Iris>(0, "sepal length"));
		this.attr.add(new AttributeImpl<Iris>(1, "sepal width"));
		this.attr.add(new AttributeImpl<Iris>(2, "petal length"));
		this.attr.add(new AttributeImpl<Iris>(3, "petal width"));

		this.classes = new ArrayList<String>();
		this.classes.add("Iris-setosa");
		this.classes.add("Iris-versicolor");
		this.classes.add("Iris-virginica");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uam.eps.p4.model.Type#getAttributes()
	 */
	@Override
	public List<Attribute<Iris>> getAttributes() {
		return this.attr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uam.eps.p4.model.Type#newInstance(java.util.List)
	 */
	@Override
	public Instance<Iris> newInstance(List<String> values) throws InvalidValuesException {
		if (values
				.size() != 4) /*
								 * compruebo que el numero de valores es correcto
								 */
			throw new InvalidValuesException();

		return new InstanceImpl<Iris>(values, new Iris());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.uam.eps.p4.model.Type#getClasses()
	 */
	@Override
	public List<String> getClasses() {
		return this.classes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		return this instanceof Iris;
	}

}
