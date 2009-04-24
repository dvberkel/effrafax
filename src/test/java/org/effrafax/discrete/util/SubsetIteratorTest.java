/**
 * 
 */
package org.effrafax.discrete.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.effrafax.discrete.util.SubsetIterator;
import org.effrafax.test.ExceptionInvoker;
import org.effrafax.test.ExceptionTester;
import org.junit.Test;


/**
 * @author dwanrooy
 *
 */
public class SubsetIteratorTest {
	
	@Test
	public void testInstantiationFailure() {

		ExceptionTester.testForException(IllegalArgumentException.class,
			new ExceptionInvoker() {

				@Override
				public void invoke() throws Exception {

					new SubsetIterator<Integer>(null);
				}
			}
		);
	}
	
	@Test 
	public void testRemoveFailure() {
		
		ExceptionTester.testForException(UnsupportedOperationException.class,
			new ExceptionInvoker() {

				@Override
				public void invoke() throws Exception {
					
					Collection<Integer> collection = Collections.emptyList();
					SubsetIterator<Integer> iterator = new SubsetIterator<Integer>(collection);
					
					iterator.remove();
				}
			}
		);
	}

	@Test
	public void testEmptyCollection() {

		Collection<Integer> testCollection = Collections.emptyList();
		
		Iterator<List<Integer>> iterator = 
			new SubsetIterator<Integer>(testCollection);
		
		assertTrue(iterator.hasNext());
		assertEquals(0, iterator.next().size());
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void testSingletonCollection() {

		Collection<Integer> testCollection = Collections.singleton(0);
		
		Iterator<List<Integer>> iterator = 
			new SubsetIterator<Integer>(testCollection);
		
		assertTrue(iterator.hasNext());
		assertEquals(0, iterator.next().size());

		assertTrue(iterator.hasNext());
		List<Integer> list = iterator.next();
		assertEquals(1, list.size());
		assertEquals(0, (int)list.get(0));
		
		assertFalse(iterator.hasNext());
	}

}
