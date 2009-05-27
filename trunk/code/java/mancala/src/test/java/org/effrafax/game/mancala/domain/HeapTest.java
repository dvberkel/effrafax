/**
 * 
 */
package org.effrafax.game.mancala.domain;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * @author dwanrooy
 *
 */
public class HeapTest {
	
	/**
	 * Test the correct construction of {@code Heap}s.
	 */
	@Test
	public void testConstructors() {
		
		int numberOfStones = 1;
		
		assertEquals(0, (new Heap()).countStones());
		
		assertEquals(numberOfStones, (new Heap(numberOfStones)).countStones());
	}
	
	/**
	 * Tests if stones get added correctly.
	 */
	@Test
	public void testAddStone() {
		
		Heap heap = new Heap();
		
		heap.addStone();
		assertEquals(1, heap.countStones());
		
		heap.addStone(2);
		assertEquals(3, heap.countStones());
	}
	
	/**
	 * Test if stones get removed correctly.
	 */
	@Test
	public void testRemoveStone() {
		
		Heap heap = new Heap(3);
		
		heap.removeStone();
		assertEquals(2, heap.countStones());
		
		heap.removeStone(2);
		assertEquals(0, heap.countStones());
	}
	
	/**
	 * Test constructor with illegal arguments.
	 */
	@Test
	public void testConstructionFailure() {
		
		try {
			
			new Heap(-1);
			fail();
		} catch (IllegalArgumentException iae) {
			
			return; /* This exception is expected */
		}
	}
	
	/**
	 * Test {@code addStone(int)} with illegal arguments.
	 */
	@Test
	public void testAddStoneFailure() {
		
		try {
			
			(new Heap()).addStone(-1);
		} catch (IllegalArgumentException iae) {
			
			return; /* This exception is expected */
		}
	}
	
	/**
	 * Test {@code removeStone(int)} with illegal arguments.
	 */
	@Test
	public void testRemoveStoneFailure() {
		
		try {
			
			(new Heap()).removeStone(-1);
		} catch (IllegalArgumentException iae) {
			
			return; /* This exception is expected */
		}
		
		try {
			
			(new Heap()).removeStone(1);
		} catch (IllegalStateException iae) {
			
			return; /* This exception is expected */
		}
	}
}
