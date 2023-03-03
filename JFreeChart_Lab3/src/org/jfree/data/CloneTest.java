package org.jfree.data;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class CloneTest {

	@Before
	public void setUp() throws Exception {
	}

//	@Test
//	public void sourceContainsNullTest() {
//		double[][] source = {null, {0.1}};
//		double[][] clone = DataUtilities.clone(source);
//		assertFalse("Should not be equal", Arrays.deepEquals(source, clone));
//	}
	
	@Test
	public void notNullTest() {
		double[][] source = {{0.0}, {0.1}};
		double[][] clone = DataUtilities.clone(source);
		assertTrue("Arrays should be equal", Arrays.deepEquals(source, clone));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nullSourceTest() {
		double[][] source = null;
		double[][] clone = DataUtilities.clone(source);
	}

}
