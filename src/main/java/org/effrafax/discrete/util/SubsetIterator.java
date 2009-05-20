/**
 * 
 */
package org.effrafax.discrete.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author dwanrooy
 *
 */
public class SubsetIterator<E> implements Iterator<List<E>> {
	
	private Iterator<List<E>> iterator = null;
	private Collection<E> original = null;
	private int k = 0;
	
	/**
	 * Constructor for InSubsetIterator.
	 * 
	 * @param maximum 
	 */
	public SubsetIterator(Collection<E> collection) {
		
		if (collection == null) {
			
			throw new IllegalArgumentException("original should not be null.");
		}
		
		original = collection;
		iterator = new KSubsetIterator<E>(original, this.k);
	}
	
	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		
		if (!iterator.hasNext()) {

			if (k < original.size()) {
				
				k++;
				iterator = new KSubsetIterator<E>(original, k);
			}
		}
		
		return iterator.hasNext();
	}
	
	/* (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	public List<E> next() {
		
		return iterator.next();
	}
	
	/* (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
		
		throw new UnsupportedOperationException();
	}
}
