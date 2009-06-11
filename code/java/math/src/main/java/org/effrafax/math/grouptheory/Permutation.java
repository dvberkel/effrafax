/**
 * 
 */
package org.effrafax.math.grouptheory;

import java.util.Arrays;

/**
 * @author dwanrooy
 * 
 */
public class Permutation {

	private int[] permutation;
	
	/**
	 * Constructor
	 * 
	 * @param image An {@code int[]} which specifies the images.
	 * @throws IllegalArgumentException if {@code image} is not a valid image of
	 * a permutation.
	 */
	public Permutation(int[] image) throws IllegalArgumentException {
		
		if (! isPermutation(image)) {
			
			throw new IllegalArgumentException("image is not a permutation");
		}
		
		setPermutation(image);
	}
	
	/**
	 * Returns the degree of this permutation.  The degree is the smallest 
	 * integer greater then the integer which gets mapped by this 
	 * {@code Permutation}.
	 * 
	 * @return The degree of this {@code Permutation}.
	 */
	public int getDegree() {

		return getPermutation().length;
	}
	
	/**
	 * Determines to which image this {@code Permutation} maps an {@code element}.
	 * 
	 * @param element The integer which gets mapped.
	 * @return The image to which {@code element} gets mapped.
	 * @throws IllegalArgumentException if the element is not mapped by this
	 * 		{@code Permutation}.
	 */
	public int mapsTo(int element) throws IllegalArgumentException {
		
		if (! (0 <= element && element < this.getDegree()) ) {
			
			throw new IllegalArgumentException("element is not mapped");
		}
		
		return this.getPermutation()[element];
	}
	
	/**
	 * Multiplies a {@code Permutation} with this {@code Permutation}. Notice
	 * that multiplication is from the left so <br>
	 * (1,2) * (1,3) = (1,2,3) instead of (1,3,2).
	 * 
	 * @param permution The {@code Permutation} which is this {
	 * 		@code Permutation} is multiplied with. 
	 * @return The resulting {@code Permutation}.
	 * @throws IllegalArgumentException If the {@code Permutation} have 
	 * 		different degrees.
	 */
	public Permutation multiply(Permutation permution)
			throws IllegalArgumentException {

		if (this.getDegree() != permution.getDegree()) {
			
			throw new IllegalArgumentException("permutation degree differ");
		}
		
		int[] result = new int[this.getDegree()];
		for (int index = 0; index < this.getDegree(); index++) {
			
			result[index] = permution.mapsTo(this.mapsTo(index)); 
		}
		
		return new Permutation(result);
	}

	/**
	 * @return the permutation
	 */
	private int[] getPermutation() {

		return permutation;
	}

	/**
	 * @param permutation
	 *            the permutation to set
	 */
	private void setPermutation(int[] permutation) {

		this.permutation = permutation;
	}
	
	/**
	 * A static method which assert if a certain integer array can be used
	 * in the constructor of {@code Permutation}.
	 * 
	 * @param permutation The {@code int[]} under scrutiny.
	 * @return {@code true} if {@code permutation} can be used in 
	 * 		{@code Permutation}'s constructor, {@code false} otherwise.
	 */
	public static boolean isPermutation(int[] permutation) {
		
		int degree = permutation.length;
		int[] elementCount = new int[degree];
		Arrays.fill(elementCount, 0);
		
		for (int element : permutation) {
			
			if (! (0 <= element && element < degree)) {
				
				return false;
			}
			
			elementCount[element]++;
		}
		
		int[] expected = new int[degree];
		Arrays.fill(expected, 1);
		
		if (Arrays.equals(expected, elementCount)) {
			
			return true;
		} else {
			
			return false;
		}
	}
}
