/**
 * 
 */
package org.effrafax.discrete.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author dwanrooy
 *
 */
public class KSubsetIterator<E> implements Iterator<List<E>> {

	private List<E> original = null;
	private int[] current = null;
	
	/**
	 * Constructor for KIntSubsetIterator.
	 * 
	 * @param maximum The maximum of the number occurring in the subsets.
	 * @param k The length of the subsets.
	 */
	public KSubsetIterator(Collection<E> collection, int k) {
		
		if (collection == null) {
			
			throw new IllegalArgumentException("collection should not be null");
		}
		if (k < 0 || collection.size() < k) {
			
			throw new IllegalArgumentException("k should be in the range 0 <= k <= collection.size()");
		}
		original = new ArrayList<E>();
		original.addAll(collection);
		
		this.current = range(k);
	}
	
	/**
	 * Returns an int array of length {@code k}. The array is filled with the 
	 * ints 0 through k-1.
	 * 
	 * @param k The length of the returned array.
	 * @return An int array filled with 0, 1, 2, ..., {@code k - 1} 
	 */
	private int[] range(int k) {
		
		int[] range = new int[k];
		
		for (int index = 0; index < k; index++) {
			
			range[index] = index;
		}
		
		return range;
	}
	
	/**
	 * Creates a subset of the original collection. Only and all the elements with 
	 * the corresponding {@code indices} will be in the subset.
	 * 
	 * @param indices The {@code indices} to be selected.
	 * @return The subset of the original collection.
	 */
	private List<E> collectSubset(int[] indices) {
	
		List<E> subset = new ArrayList<E>();
		for (int index : indices) {
			
			subset.add(original.get(index));
		}
		
		return subset;
	}
	
	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		
		return current != null;
	}
	
	/* (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	public List<E> next() {

		int[] copy = Arrays.copyOf(current, current.length);

		int start = current.length - 1;
		int index = start;
		while (
			index >= 0 && 
			current[index] == (original.size()-1) - (start - index)
		) {
			
			index--;				
		}
		
		if (index >= 0) {
			
			current[index] = current[index] + 1;
			
			index++;
			while (index < current.length) {

				current[index] = current[index - 1] + 1;
				index++;
			}
		} else {
			
			current = null;
		}
		
		return collectSubset(copy);
	}
	
	/* (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
		
		throw new UnsupportedOperationException();
	}
}
