/**
 * 
 */
package org.effrafax.discrete.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.effrafax.test.ExceptionInvoker;
import org.effrafax.test.ExceptionTester;
import org.junit.Test;


/**
 * @author dwanrooy
 *
 */
public class PermutationIteratorTest {

	@Test
	public void testInitialisationFailure() {
		
		ExceptionTester.testForException(
			IllegalArgumentException.class, 
			new ExceptionInvoker() {

				@Override
				public void invoke() throws Exception {
					
					new PermutationIterator<Integer>(null);
				}					
			}
		);
	}
	
	@Test
	public void testEmptyCollection() {
		
		Collection<Integer> testCollection = Collections.emptyList();
		
		Iterator<List<Integer>> iterator = 
			new PermutationIterator<Integer>(testCollection);
		
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void testSingletonCollection() {
		
		Collection<Integer> testCollection = Collections.singleton(0);
		
		Iterator<List<Integer>> iterator = 
			new PermutationIterator<Integer>(testCollection);
		
		assertTrue(iterator.hasNext());

		List<Integer> list = iterator.next();
		assertEquals(1, list.size());
		assertEquals(0, (int)list.get(0));
		
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void testSimpleCollection() {
		
		Collection<Integer> testCollection = Arrays.asList(0, 1);
		
		Iterator<List<Integer>> iterator = 
			new PermutationIterator<Integer>(testCollection);
		
		assertTrue(iterator.hasNext());

		List<Integer> list = iterator.next();
		assertEquals(2, list.size());
		assertEquals(0, (int)list.get(0));
		assertEquals(1, (int)list.get(1));

		assertTrue(iterator.hasNext());

		list = iterator.next();
		assertEquals(2, list.size());
		assertEquals(1, (int)list.get(0));
		assertEquals(0, (int)list.get(1));

		assertFalse(iterator.hasNext());
	}
	
}
