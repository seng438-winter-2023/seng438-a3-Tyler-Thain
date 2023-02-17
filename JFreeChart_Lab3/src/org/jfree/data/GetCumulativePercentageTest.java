package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;
import org.junit.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;

public class GetCumulativePercentageTest extends DataUtilities {
	Mockery mockingContext;
	KeyedValues values;
	
	@BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception {
    	
    }
	
	// This test covers when data is null
	@Test(expected = InvalidParameterException.class)
	public void nulldataTest() throws InvalidParameterException{
		DataUtilities.getCumulativePercentages(null);
	}
	
	// This test covers for valid data
	@Test
	public void validDataObject() {
		Mockery mockingContext = new Mockery();
	    values = mockingContext.mock(KeyedValues.class);
	    mockingContext.checking(new Expectations() {
	        {
	        	for(int i = 0; i < 5; i++) {
	        		allowing(values).getKey(i);
	        		will(returnValue(i));
	        		allowing(values).getValue(i);
	        		will(returnValue(i));
	        	}
	        	allowing(values).getItemCount();
	        	will(returnValue(5));
	        }
	    });
	    KeyedValues actual = getCumulativePercentages(values);
		double expected[] = {0.0, 0.1, 0.3, 0.6, 1.0};
		for(int i = 0; i < 5; i++) {
			assertEquals(expected[i], actual.getValue(i));
		}
	}
	
	// This test covers for invalid data
	@Test(expected = InvalidParameterException.class)
	public void invalidDataObject() throws InvalidParameterException{
		mockingContext = new Mockery();
		values = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				for(int i = 0; i < 3; i++) {
	        		allowing(values).getKey(i);
	        		will(returnValue(i));
	        		allowing(values).getValue(i);
	        		will(returnValue("3"));
	        	}
	        	allowing(values).getItemCount();
	        	will(returnValue(3));
				
			}
		});
		getCumulativePercentages(values);
	}
	
	
	@After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }


}
