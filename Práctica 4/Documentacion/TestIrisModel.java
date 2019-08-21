package es.uam.eps.p4.test;

import es.uam.eps.p4.exception.AttributeFormatException;
import es.uam.eps.p4.exception.InvalidValuesException;
import es.uam.eps.p4.model.Attribute;
import es.uam.eps.p4.model.Instance;
import es.uam.eps.p4.model.iris.Iris;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mora on 9/03/16.
 */
public class TestIrisModel {
    private Iris iris;
    private List<Attribute<Iris>> attr;
    private List<String> classes;
    @Before
    public void setup(){
        iris=new Iris();
        attr=iris.getAttributes();
        classes=iris.getClasses();
    }

    @Test
    public void testAttributeList() throws AttributeFormatException {
        assertTrue(attr.size()==4);
        assertEquals(attr.get(0).getName(), "sepal length");
        assertEquals(attr.get(1).getName(), "sepal width");
        assertEquals(attr.get(2).getName(), "petal length");
        assertEquals(attr.get(3).getName(), "petal width");
    }

    @Test
    public void testClasses(){
        assertTrue(classes.size()==3);
        assertEquals(classes.get(0), "Iris-setosa");
        assertEquals(classes.get(1), "Iris-versicolor");
        assertEquals(classes.get(2), "Iris-virginica");
    }

    @Test
    public void testAttributeConvOK() throws AttributeFormatException {
        double v=attr.get(0).fromString("3.1");
        assertTrue(v==3.1);
    }

    @Test(expected=AttributeFormatException.class)
    public void testAttributeConvError() throws AttributeFormatException {
        double v=attr.get(0).fromString("3,1");
    }

    @Test
    public void testInstance() throws InvalidValuesException {
        Instance<Iris> instance= iris.newInstance(Arrays.asList("2.1", "3.2", "4.5", "2.0"));
        assertEquals(instance.getType(), iris);
        assertTrue(instance.getValue(attr.get(0)) == 2.1);
        assertTrue(instance.getValue(attr.get(1)) == 3.2);
        assertTrue(instance.getValue(attr.get(2)) == 4.5);
        assertTrue(instance.getValue(attr.get(3)) == 2.0);
    }

    @Test(expected = InvalidValuesException.class)
    public void testInstanceError1() throws InvalidValuesException{
        Instance<Iris> instance= iris.newInstance(Arrays.asList("2.1", "3.2", "-4,5", "2.0"));
    }

    @Test(expected = InvalidValuesException.class)
    public void testInstanceError2() throws InvalidValuesException{
        Instance<Iris> instance= iris.newInstance(Arrays.asList("2.1", "3.2"));
    }

    @Test(expected = InvalidValuesException.class)
    public void testInstanceError3() throws InvalidValuesException{
        Instance<Iris> instance= iris.newInstance(Arrays.asList("2.1", "3.2", "4", "5", "6"));
    }

}
