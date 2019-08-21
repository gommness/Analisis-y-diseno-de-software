package main;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import element.FactoryElementImpl;
import element.IMatrixElement;
import element.MatrixElementImpl;
import exception.IllegalPositionException;
import matrix.MatrixImpl;

public class ImplementationTest {
	
	static final int STRROWS = 4;
	static final int STRCOLS = 8;
	static final int INTROWS = 6;
	static final int INTCOLS = 7;

	private MatrixImpl<String> strMatrix = new MatrixImpl<String>(STRROWS,STRCOLS, new FactoryElementImpl<String>());
	private MatrixImpl<Integer> intMatrix = new MatrixImpl<Integer>(INTROWS,INTCOLS, new FactoryElementImpl<Integer>());
	
	private MatrixElementImpl<String> str1;
	private MatrixElementImpl<String> str2;
	private MatrixElementImpl<String> str3;
	private MatrixElementImpl<String> str4;
	private MatrixElementImpl<String> str5;
	
	private MatrixElementImpl<Integer> int1;
	private MatrixElementImpl<Integer> int2;
	private MatrixElementImpl<Integer> int3;
	private MatrixElementImpl<Integer> int4;
	private MatrixElementImpl<Integer> int5;
	
    @Before
    public void setup() throws IllegalPositionException{
    	str1 = new MatrixElementImpl<>(0,0,"esquina sup izda");
    	str2 = new MatrixElementImpl<>(3,7,"esquina inf dcha");
    	str3 = new MatrixElementImpl<>(0,7,"esquina inf izda");
    	str4 = new MatrixElementImpl<>(3,0,"esquina sup dcha");
    	str5 = new MatrixElementImpl<>(1,1,"elemento centrado");
    	
    	int1 = new MatrixElementImpl<>(0,0,1);
    	int2 = new MatrixElementImpl<>(5,6,2);
    	int3 = new MatrixElementImpl<>(0,6,3);
    	int4 = new MatrixElementImpl<>(5,0,4);
    	int5 = new MatrixElementImpl<>(1,1,5);
    	
		strMatrix.addElement(str1);
		strMatrix.addElement(str2);
		strMatrix.addElement(str3);
		
		intMatrix.addElement(int1);
		intMatrix.addElement(int2);
		intMatrix.addElement(int3);
    }
    
    @Test
    public void testGetCols(){
    	assertEquals(strMatrix.getCols(),STRCOLS);
    	assertEquals(intMatrix.getCols(),INTCOLS);
    }
    
    @Test
    public void testGetRows(){
    	assertEquals(strMatrix.getRows(),STRROWS);
    	assertEquals(intMatrix.getRows(),INTROWS);
    }
    
    @Test
    public void testIsLegalPosition(){
    	assertTrue(strMatrix.isLegalPosition(1, 1));
    	assertFalse(strMatrix.isLegalPosition(-1, 1));
    	assertFalse(strMatrix.isLegalPosition(1, -1));
    	assertFalse(strMatrix.isLegalPosition(-1, -1));
    	assertFalse(strMatrix.isLegalPosition(STRROWS, 1));
    	assertFalse(strMatrix.isLegalPosition(1, STRCOLS));
    	
    	assertTrue(intMatrix.isLegalPosition(1, 1));
    	assertFalse(intMatrix.isLegalPosition(-1, 1));
    	assertFalse(intMatrix.isLegalPosition(1, -1));
    	assertFalse(intMatrix.isLegalPosition(-1, -1));
    	assertFalse(intMatrix.isLegalPosition(INTROWS, 1));
    	assertFalse(intMatrix.isLegalPosition(1, INTCOLS));
    }

    @Test
    public void testAddElement(){
    	boolean flag = false;// este flag me servira para detectar que las excepciones se lanzan correctamente
    	
    	MatrixElementImpl<Integer> intError = new MatrixElementImpl<>(-1,-1,27);// necesitare elementos de posiciones ilegales
    	MatrixElementImpl<String> strError = new MatrixElementImpl<>(-1,-1,"I am Error");
    	
    	try{// trato de insertar elementos normales
    		strMatrix.addElement(str4);
    		strMatrix.addElement(str5);
    	}
    	catch(IllegalPositionException e){
    		assertTrue(false);
    	}
    	try{// trato de insertar elementos normales
    		intMatrix.addElement(int4);
    		intMatrix.addElement(int5);
    	}
    	catch(IllegalPositionException e){
    		assertTrue(false);
    	}
    	try{//trato de insertar elemento en posicion ilegal
    		strMatrix.addElement(strError);
    	}
    	catch (IllegalPositionException e){
    		flag = true;// si capturo la excepcion, todo ha ido como esperaba
    	}
    	assertTrue(flag);
    	
    	flag = false;
    	try{//trato de insertar elemento en posicion ilegal
    		intMatrix.addElement(intError);
    	}
    	catch (IllegalPositionException e){
    		flag = true;// si capturo la excepcion, todo ha ido como esperaba
    	}
    	assertTrue(flag);
    }
    
    @Test
    public void testGetElementAt() throws IllegalPositionException{
    	boolean flag = false;
    	
    	assertEquals(strMatrix.getElementAt(0, 0),str1);
    	assertEquals(intMatrix.getElementAt(0, 0),int1);
    	try{
    		strMatrix.getElementAt(-1, 1);
    	} catch(IllegalPositionException e){
    		flag = true;
    	}
    	assertTrue(flag);
    	flag = false;
    	try{
    		intMatrix.getElementAt(-1, 1);
    	} catch(IllegalPositionException e){
    		flag = true;
    	}
    	assertTrue(flag);
    }
    
    @Test
    public void testGetNeighboursAt() throws IllegalPositionException{
		
    	ArrayList<IMatrixElement<String>> strs = new ArrayList<>(strMatrix.getNeighboursAt(0, 0));
    	ArrayList<IMatrixElement<Integer>> ints = new ArrayList<>(intMatrix.getNeighboursAt(0, 0));
    	
    	assertTrue(strs.contains(str2));
    	assertTrue(strs.contains(str3));
    	assertFalse(strs.contains(str1));
    	
    	assertTrue(ints.contains(int2));
    	assertTrue(ints.contains(int3));
    	assertFalse(ints.contains(int1));
    	
    	assertFalse(strMatrix.getNeighboursAt(1, 1).contains(str2));
    	assertFalse(intMatrix.getNeighboursAt(1, 1).contains(int2));
    }
    
    @Test
    public void testAsList() throws IllegalPositionException{
		
		List<MatrixElementImpl<String>> strExpected = new ArrayList<>();
		strExpected.add(str1);
		strExpected.add(str2);
		strExpected.add(str3);
		List<MatrixElementImpl<Integer>> intExpected = new ArrayList<>();
		intExpected.add(int1);
		intExpected.add(int2);
		intExpected.add(int3);
		List<IMatrixElement<String>> strList = strMatrix.asList();
		List<IMatrixElement<Integer>> intList = intMatrix.asList();
		
		for(IMatrixElement<String> e : strList){
			assertTrue(strExpected.contains(e));
		}
		for(IMatrixElement<Integer> e : intList){
			assertTrue(intExpected.contains(e));
		}
		
    }
    
    @Test
    public void testEquality() throws IllegalPositionException{
    	MatrixImpl<String> strExpected = new MatrixImpl<>(STRROWS,STRCOLS,new FactoryElementImpl<String>());
    	MatrixImpl<String> strError = new MatrixImpl<>(STRROWS+1,STRCOLS+1,new FactoryElementImpl<String>());
    	MatrixImpl<Integer> intExpected = new MatrixImpl<>(INTROWS,INTCOLS,new FactoryElementImpl<Integer>());
    	MatrixImpl<Integer> intError = new MatrixImpl<>(INTROWS+1,INTCOLS+1,new FactoryElementImpl<Integer>());
    	
    	strExpected.addElement(str1);
    	strExpected.addElement(str2);
    	strError.addElement(str1);
    	strError.addElement(str2);
    	
    	assertNotEquals(strExpected,strMatrix);
    	
    	strError.addElement(str3);
    	strExpected.addElement(str3);
		
    	intExpected.addElement(int1);
    	intExpected.addElement(int2);
    	intError.addElement(int1);
    	intError.addElement(int2);
    	
    	assertNotEquals(intExpected,strMatrix);
    	
    	intExpected.addElement(int3);
    	intError.addElement(int3);
    	
    	assertEquals(strExpected,strMatrix);
    	assertEquals(intExpected,intMatrix);
    	assertNotEquals(strError,strMatrix);
    	assertNotEquals(intError,strMatrix);
    }
    
    @Test
    public void testSort(){
    	List<MatrixElementImpl<String>> strExpected = new ArrayList<>();
    	strExpected.add(str1);
    	strExpected.add(str3);
    	strExpected.add(str2);
    	assertEquals(strExpected,strMatrix.asListSortedBy(new MatrixImpl.ColumnSort<String>()));
    	assertEquals(strExpected,strMatrix.asListSortedBy(new MatrixImpl.RowSort<String>()));
    	List<MatrixElementImpl<Integer>> intExpected = new ArrayList<>();
    	intExpected.add(int2);
    	intExpected.add(int3);
    	intExpected.add(int1);
    	assertEquals(intExpected,intMatrix.asListSortedBy(new MatrixImpl.EvenSort()));
    	intExpected.clear();
    	intExpected.add(int3);
    	intExpected.add(int1);
    	intExpected.add(int2);
    	assertEquals(intExpected,intMatrix.asListSortedBy(new MatrixImpl.OddSort()));
    }
    
}
