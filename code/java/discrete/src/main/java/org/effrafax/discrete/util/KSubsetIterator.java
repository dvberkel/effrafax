/**
 * 
 */
package org.effrafax.discrete.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.effrafax.discrete.Subsets;

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
		
		this.current = Subsets.range(k);
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
		
		return Subsets.collect(original, copy);
	}
	
	/* (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
		
		throw new UnsupportedOperationException();
	}
}
