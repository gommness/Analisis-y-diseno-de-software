package es.uam.eps.p4.test;

import es.uam.eps.p4.exception.AttributeFormatException;
import es.uam.eps.p4.exception.InvalidValuesException;
import es.uam.eps.p4.model.Attribute;
import es.uam.eps.p4.model.Instance;
import es.uam.eps.p4.model.iris.apartado1.Iris;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mora on 9/03/16.
 */
public class TestIrisModel2 {
	private Iris iris;
	private List<Attribute<Iris>> attr;
	private List<String> classes;

	@Before
	public void setup() {
		iris = new Iris();
		attr = iris.getAttributes();
		classes = iris.getClasses();
	}

	@Test
	public void testAttributeList() throws AttributeFormatException {
		assertTrue(attr.size() == 4);
		assertEquals("sepal length", attr.get(0).getName());
		assertEquals("sepal width", attr.get(1).getName());
		assertEquals("petal length", attr.get(2).getName());
		assertEquals("petal width", attr.get(3).getName());
	}

	@Test
	public void testClasses() {
		assertTrue(classes.size() == 3);
		assertEquals("Iris-setosa", classes.get(0));
		assertEquals("Iris-versicolor", classes.get(1));
		assertEquals("Iris-virginica", classes.get(2));
	}

	@Test
	public void testAttributeConvOK() throws AttributeFormatException {
		double v = attr.get(0).fromString("3.1");
		assertTrue(v == 3.1);
	}

	@Test(expected = AttributeFormatException.class)
	public void testAttributeConvError() throws AttributeFormatException {
		double v = attr.get(0).fromString("3,1");
	}

	@Test
	public void testInstance() throws InvalidValuesException {
		Instance<Iris> instance = iris.newInstance(Arrays.asList("2.1", "3.2", "4.5", "2.0"));
		assertEquals(instance.getType(), iris);
		assertTrue(instance.getValue(attr.get(0)) == 2.1);
		assertTrue(instance.getValue(attr.get(1)) == 3.2);
		assertTrue(instance.getValue(attr.get(2)) == 4.5);
		assertTrue(instance.getValue(attr.get(3)) == 2.0);
	}

	@Test(expected = InvalidValuesException.class)
	public void testInstanceError1() throws InvalidValuesException {
		Instance<Iris> instance = iris.newInstance(Arrays.asList("2.1", "3.2", "-4,5", "2.0"));
	}

	@Test(expected = InvalidValuesException.class)
	public void testInstanceError2() throws InvalidValuesException {
		Instance<Iris> instance = iris.newInstance(Arrays.asList("2.1", "3.2"));
	}

	@Test(expected = InvalidValuesException.class)
	public void testInstanceError3() throws InvalidValuesException {
		Instance<Iris> instance = iris.newInstance(Arrays.asList("2.1", "3.2", "4", "5", "6"));
	}

}
