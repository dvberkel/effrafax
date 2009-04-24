/**
 * 
 */
package org.effrafax.discrete;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.List;

import org.effrafax.test.ExceptionInvoker;
import org.effrafax.test.ExceptionTester;
import org.junit.Test;


/**
 * @author dwanrooy
 *
 */
public class SubsetTest {
	
	@Test
	public void testKSubsetFailureFirstArgument() {
		
		ExceptionTester.testForException(
			IllegalArgumentException.class, 
			new ExceptionInvoker() {

				@Override
				public void invoke() throws Exception {
					
					Subsets.kSubsetsOf(null, 0);
				}				
			}
		);
	}
	
	@Test
	public void testKSubsetFailureSecondArgument() {
		
		final List<Integer> testCollecion = Collections.emptyList();
		
		ExceptionTester.testForException(
			IllegalArgumentException.class, 
			new ExceptionInvoker() {

				@Override
				public void invoke() throws Exception {
					
					Subsets.kSubsetsOf(testCollecion, -1);
				}				
			}
		);
		
		ExceptionTester.testForException(
			IllegalArgumentException.class, 
			new ExceptionInvoker() {

				@Override
				public void invoke() throws Exception {
					
					Subsets.kSubsetsOf(testCollecion, 1);
				}				
			}
		);
	}
	
	@Test
	public void testSubsetFailure() {
		
		ExceptionTester.testForException(
			IllegalArgumentException.class, 
			new ExceptionInvoker() {

				@Override
				public void invoke() throws Exception {
					
					Subsets.subsetsOf(null);
				}				
			}
		);
	}
	
	@Test
	public void testEmptyKSubset() {
		
		final List<Integer> testCollection = Collections.emptyList();
		
		int count = 0;
		for (List<Integer> subset : Subsets.kSubsetsOf(testCollection, 0)) {
			
			count++;
			assertEquals(subset, testCollection);
		}
		
		if (count != 1) {
			
			fail();
		}
	}
	
	@Test
	public void testEmptySubset() {
		
		final List<Integer> testCollection = Collections.emptyList();
		
		int count = 0;
		for (List<Integer> subset : Subsets.subsetsOf(testCollection)) {
			
			count++;
			assertEquals(subset, testCollection);
		}
		
		if (count != 1) {
			
			fail();
		}
	}
	
	@Test
	public void testSingletonKSubset() {
		
		final List<Integer> emptyCollection = Collections.emptyList();
		final List<Integer> testCollection = Collections.singletonList(0);
		
		int count = 0;
		for (List<Integer> subset : Subsets.kSubsetsOf(testCollection, 0)) {
			
			count++;

			assertEquals(subset, emptyCollection);
		}
		
		if (count != 1) {
			
			fail();
		}

		count = 0;
		for (List<Integer> subset : Subsets.kSubsetsOf(testCollection, 1)) {
			
			count++;

			assertEquals(subset, testCollection);
		}
		
		if (count != 1) {
			
			fail();
		}
	}
	
	@Test
	public void testSingletonSubset() {
		
		final List<Integer> emptyCollection = Collections.emptyList();
		final List<Integer> testCollection = Collections.singletonList(0);
		
		int count = 0;
		for (List<Integer> subset : Subsets.subsetsOf(testCollection)) {
			
			count++;
			if (subset.size() == 0) {
				
				assertEquals(subset, emptyCollection);
			} else {
				
				assertEquals(subset, testCollection);
			}
		}
		
		if (count != 2) {
			
			fail();
		}
	}
}
