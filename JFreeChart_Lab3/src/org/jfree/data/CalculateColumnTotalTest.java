package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;
import org.junit.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;

public class CalculateColumnTotalTest extends DataUtilities {
	Values2D values;
	Mockery mockingContext;
	
	@BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception {
    	
    }
    
	// This test is for when data is null
    @Test (expected = InvalidParameterException.class)
	public void DataIsNull() throws InvalidParameterException { 
		DataUtilities.calculateColumnTotal(null, 0);
	} 
    
	// This test is for when data is positive and the column is 0
	@Test
	public void posDataValidColumn() {
	    mockingContext = new Mockery();
	    values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(3));
	            one(values).getValue(1, 0);
	            will(returnValue(6));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals(9.0, result, .000000001d);
	}
	
	// This test is for when data is negative and the column is valid
	@Test
	public void negDataValidColumn() {
		mockingContext = new Mockery();
	    values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 1);
	            will(returnValue(3));
	            one(values).getValue(1, 1);
	            will(returnValue(-6));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 1);
	    assertEquals(-3.0, result, .000000001d);
	}
	
	// This test is for when data is valid and the column is < 0
	@Test
	public void negCol() {
		mockingContext = new Mockery(); 
		values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() { 
			{
				one(values).getRowCount(); 
				will(returnValue(3));
				one(values).getValue(0, -1);
				will(throwException(new IndexOutOfBoundsException()));
				

			} 
		});
		assertEquals(0.0, DataUtilities.calculateColumnTotal(values, -1), .000000001d);
	}
	
	// This test is for when data values are null and the column is valid
	@Test
	public void nullValueDataValidColumn() {
		mockingContext = new Mockery(); 
		values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() { 
			{
				one(values).getRowCount(); 
				will(returnValue(2));
				one(values).getValue(0, 1);
				will(returnValue(null));
				one(values).getValue(1, 1); 
				will(returnValue(null));
				
			} 
		});		
		assertEquals(0.0, DataUtilities.calculateColumnTotal(values, 1), .000000001d);
	}
	
	@After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
