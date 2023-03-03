package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateColumnTotalWithValidColumnsTest extends DataUtilities {

	@Test
	public void validInputTest() {
		//Tests valid input for calculateColumnTotal
		//Mock does not work with EclEmma so test written with actual dependency 
		DefaultKeyedValues2D values = new DefaultKeyedValues2D();
	    values.setValue(2.5, 0, 0);
	    values.setValue(7.5, 1, 0);
	    values.setValue(1.0, 2, 0);
	    
	    int[] i = {0,2};
	    double result = DataUtilities.calculateColumnTotal(values, 0, i);
		assertEquals("Total should be 3.5 for valid input for index 0", 3.5, result, .000000001d);
	}
	
	@Test
	public void tooManyValidColumnsTest() {
		//Tests what happens if validCols.size() > number of columns in data table for calculateRowTotal
		//Mock does not work with EclEmma so test written with actual dependency 
		DefaultKeyedValues2D values = new DefaultKeyedValues2D();
	    values.setValue(2.5, 0, 0);
	    values.setValue(7.5, 1, 0);
	    values.setValue(1.0, 2, 0);
	    
	    int[] i = {0,1,2,3};
	    double result = DataUtilities.calculateColumnTotal(values, 0, i);
		assertEquals("Total should be 11.0 for valid input for index 0", 11.0, result, .000000001d);
	}

}
