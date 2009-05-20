package org.effrafax.discrete;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.effrafax.discrete.util.KSubsetIterator;
import org.effrafax.discrete.util.PermutationIterator;
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
	 * Returns an int array of length {@code k}. The array is filled with the 
	 * ints 0 through k-1.
	 * 
	 * @param k The length of the returned array.
	 * @return An int array filled with 0, 1, 2, ..., {@code k - 1} 
	 */
	public static int[] range(int k) {
		
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
	public static <E> List<E> collect(List<E> collection, int[] indices) {
	
		List<E> subset = new ArrayList<E>();
		for (int index : indices) {
			
			subset.add(collection.get(index));
		}
		
		return subset;
	}

	
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
	
	public static <E> Iterable<List<E>> permutationsOf(final Collection<E> collection) {
		
		if (collection == null) {
			
			throw new IllegalArgumentException("collection should not be null");
		}
		
		return new Iterable<List<E>>() {

			@Override
			public Iterator<List<E>> iterator() {
				
				return new PermutationIterator<E>(collection);
			}			
		};
	} 
}
