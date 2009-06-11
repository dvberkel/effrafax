/**
 * 
 */
package org.effrafax.math.grouptheory;

import static org.junit.Assert.*;

import org.effrafax.test.ExceptionInvoker;
import org.effrafax.test.ExceptionTester;
import org.junit.Test;

/**
 * @author dwanrooy
 * 
 */
public class PermutationTest {

	@Test
	public void testShouldCreateSwap() {

		Permutation swap = new Permutation(new int[] { 1, 0 });

		assertEquals(1, swap.mapsTo(0));
		assertEquals(0, swap.mapsTo(1));
		
		assertEquals(2, swap.getDegree());
	}

	@Test
	public void testShouldFailOnCreation() {

		ExceptionTester.testForException(IllegalArgumentException.class,
				new ExceptionInvoker() {

			@Override
			public void invoke() throws Exception {
				
				new Permutation(new int[] {0,2});
			}
		});
	}

	@Test
	public void testShouldProduce123() {

		Permutation swap12 = new Permutation(new int[] { 1, 0, 2 });
		Permutation swap13 = new Permutation(new int[] { 2, 1, 0 });
		
		Permutation result = swap12.multiply(swap13);
		
		assertEquals(1, result.mapsTo(0));
		assertEquals(2, result.mapsTo(1));
		assertEquals(0, result.mapsTo(2));
	}


	@Test
	public void testShouldFailWithDifferentDegree() {

		ExceptionTester.testForException(IllegalArgumentException.class,
				new ExceptionInvoker() {

			@Override
			public void invoke() throws Exception {
				
				Permutation a = new Permutation(new int[] {0,1});
				Permutation b = new Permutation(new int[] {0,1,3});
				
				a.multiply(b);
			}
		});
	}
	
	@Test
	public void testShouldDetermineCorrectInput() {
		
		assertTrue(Permutation.isPermutation(new int[] {0,1}));
		
		assertFalse(Permutation.isPermutation(new int[] {0,2}));
		
		assertFalse(Permutation.isPermutation(new int[] {0,-1}));
		
		assertFalse(Permutation.isPermutation(new int[] {1,2}));
	}
	
	@Test 
	public void testShouldproduceDifferentTranspositions() {
		
		Permutation swap = Permutation.swap(2, 0, 1);

		assertEquals(1, swap.mapsTo(0));
		assertEquals(0, swap.mapsTo(1));
		
		assertEquals(2, swap.getDegree());
				
	}

}
