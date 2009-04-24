package org.effrafax.discrete;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.effrafax.discrete.util.KSubsetIterator;
import org.effrafax.discrete.util.SubsetIterator;


/**
 * This class provides a convenience methods to create iterable forms of various 
 * subset of collections.
 * A subset is a List<E>.
 *  
 * @author dwanrooy
 *
 */
public class Subsets {
	
	/**
	 * Creates an iterable for all the subsets of the {@code collection}.
	 * @param <E> The generic type specifier.
	 * @param collection The collection to form subsets of.
	 * @return An Iterable of subsets of the {@code collection}.
	 */
	public static <E> Iterable<List<E>> subsetsOf(final Collection<E> collection) {
		
		if (collection == null) {
			
			throw new IllegalArgumentException("collection should not be null");
		}
		
		return new Iterable<List<E>>() {

			@Override
			public Iterator<List<E>> iterator() {
				
				return new SubsetIterator<E>(collection);
			}			
		};
	}
	
	
	/**
	 * Creates an iterable for all the subsets of size {@code k} of the 
	 * {@code collection}.
	 * @param <E> The generic type specifier.
	 * @param collection The collection to form subsets of.
	 * @parem k the size of the subsets to return.
	 * @return An Iterable of subsets of size {@code k} of the {@code collection}.
	 */
	public static <E> Iterable<List<E>> kSubsetsOf(final Collection<E> collection, final int k) {
		
		if (collection == null) {
			
			throw new IllegalArgumentException("collection should not be null");
		}
		if (k < 0 || collection.size() < k) {
		
			throw new IllegalArgumentException("k should be in range 0 <= k <= collection.size()");
		}
		
		return new Iterable<List<E>>() {

			@Override
			public Iterator<List<E>> iterator() {
				
				return new KSubsetIterator<E>(collection, k);
			}			
		};
	}
}
