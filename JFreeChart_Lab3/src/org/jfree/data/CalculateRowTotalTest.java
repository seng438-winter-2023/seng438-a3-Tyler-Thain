package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

public class CalculateRowTotalTest extends DataUtilities{
	
	@Test
	public void validInputTest() {
		// This test covers a valid input for data and row (ECT)
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(0, 1);
	            will(returnValue(2.5));
	        }
	    });
	    double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals("Total should be 10 for valid input for index 0", 10, result, .000000001d);
	}
	
	@Test(expected = InvalidParameterException.class)
	public void nullDataTest() {
		// This test covers an invalid input for data and a valid input for row (ECT)
	    double actual = DataUtilities.calculateRowTotal(null, 1);
	}
	
	@Test
	public void negativeIndexTest() {
		// This test covers an invalid input for row and a valid input for data (BVT)
		Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(-1, 0);
	            will(throwException(new IndexOutOfBoundsException()));
	        }
	    });
		double result = DataUtilities.calculateRowTotal(values, -1);
		assertEquals("Total should be 0 for invalid input for index of -1", 0, result, .000000001d);
	}
	
	@Test
	public void tooLargeIndexTest() {
		// This test covers an invalid input for row and a valid input for data (BVT)
		Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(10, 0);
	            will(throwException(new IndexOutOfBoundsException()));
	        }
	    });
		double result = DataUtilities.calculateRowTotal(values, 10);
		assertEquals("Total should be 0 for invalid input for index greater than the row size", 0, result, .000000001d);
	}
	

}
