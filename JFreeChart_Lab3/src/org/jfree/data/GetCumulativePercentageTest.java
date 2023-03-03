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
	@Test(expected = IllegalArgumentException.class)
	public void nulldataTest() throws IllegalArgumentException{
		DataUtilities.getCumulativePercentages(null);
	}
	
	// This test covers for valid data
	@Test
	public void validDataObject() {
		DefaultKeyedValues values = new DefaultKeyedValues();
		double nums[] = {0.0, 1.0, 2.0, 3.0, 4.0};
//		double keys[] = {0, 1, 2, 3, 4};
		values.setValue(new Double(0), nums[0]);
		values.setValue(new Double(1), nums[1]);
		values.setValue(new Double(2), nums[2]);
		values.setValue(new Double(3), nums[3]);
		values.setValue(new Double(4), nums[4]);
		
//		Mockery mockingContext = new Mockery();
//	    values = mockingContext.mock(KeyedValues.class);
//	    mockingContext.checking(new Expectations() {
//	        {
//	        	for(int i = 0; i < 5; i++) {
//	        		allowing(values).getKey(i);
//	        		will(returnValue(i));
//	        		allowing(values).getValue(i);
//	        		will(returnValue(i));
//	        	}
//	        	allowing(values).getItemCount();
//	        	will(returnValue(5));
//	        }
//	    });
	    KeyedValues actual = getCumulativePercentages(values);
		double expected[] = {0.0, 0.1, 0.3, 0.6, 1.0};
		for(int i = 0; i < 5; i++) {
			System.out.println(actual.getValue(i));
			assertEquals(expected[i], actual.getValue(i));
		}
	}
	
	// This test covers for invalid data
//	@Test(expected = InvalidParameterException.class)
//	public void invalidDataObject() throws InvalidParameterException{
//		mockingContext = new Mockery();
//		values = mockingContext.mock(KeyedValues.class);
//		mockingContext.checking(new Expectations() {
//			{
//				for(int i = 0; i < 3; i++) {
//	        		allowing(values).getKey(i);
//	        		will(returnValue(i));
//	        		allowing(values).getValue(i);
//	        		will(returnValue("3"));
//	        	}
//	        	allowing(values).getItemCount();
//	        	will(returnValue(3));
//				
//			}
//		});
//		getCumulativePercentages(values);
//	}
	
	@Test
	public void nullValueInKeyedValuesTest() {
		DefaultKeyedValues values = new DefaultKeyedValues();
		double nums[] = {0.0, 1.0, 2.0, 3.0, 4.0};
		values.setValue(new Double(0), null);
		values.setValue(new Double(1), nums[1]);
		values.setValue(new Double(2), nums[2]);
		values.setValue(new Double(3), nums[3]);
		values.setValue(new Double(4), nums[4]);
		KeyedValues actual = getCumulativePercentages(values);
		double expected[] = {0.0, 0.1, 0.3, 0.6, 1.0};
		for(int i = 0; i < 5; i++) {
			System.out.println(actual.getValue(i));
			assertEquals(expected[i], actual.getValue(i));
		}
	}
	
	
	@After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }


}
