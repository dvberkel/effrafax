/**
 * 
 */
package org.effrafax.game.mancala.domain;

/**
 * This class represents all the heaps of stones in the mancala game.
 * 
 * @author dwanrooy
 * 
 */
public class Heap {
	
	private static final String EXCEPTION_NONNEGATIVE = 
		"The number of stones should be non-negative.";
	private static final String EXCEPTION_TOFEW = 
		"This heap does not contain enough stones.";
	private static final String EXCEPTION_NONNULL = 
		"owner should be non null";
	
	private int numberOfStones = 0;
	private Player owner = null;
	
	/**
	 * Returns an empty {@code Heap}.
	 * 
	 * @param player The owner of this {@code Heap}.
	 */
	public Heap(Player player) {
		
		this.setOwner(player);
	}
	
	/**
	 * Returns a {@code Heap} with a preset number of stones. The preset number of
	 * stones should be non-negative, otherwise an IllegalArgumentException is 
	 * thrown.
	 *  
	 * @param player The owner of this {@code Heap}.
	 * @param numberOfStones The preset number of stones.
	 * @throws IllegalArgumentException if {@code numberOfStones} is negative.
	 */
	public Heap(Player player, int numberOfStones) throws IllegalArgumentException {
		
		this(player);
		this.addStone(numberOfStones);
	}
	
	/**
	 * Counts the number of stones in this {@code Heap}.
	 * 
	 * @return The number of stones in this {@code Heap}.
	 */
	public int countStones() {

		return numberOfStones;
	}

	/**
	 * Adds a number of stones to this {@code Heap}. The amount added should be
	 * non-negative or else an exception is thrown.
	 * 
	 * @param numberOfStones
	 *            The number of stones added to this {@code Heap}.
	 * @throws IllegalArgumentException
	 *             if {@code numberOfStones} is negative.
	 */
	public void addStone(int numberOfStones) throws IllegalArgumentException {

		if (numberOfStones < 0) {

			throw new IllegalArgumentException(Heap.EXCEPTION_NONNEGATIVE);
		}

		this.numberOfStones += numberOfStones;
	}

	/**
	 * Adds one stone to this {@code Heap}. If you want to add multiple stones
	 * in one go, see {@code addStone(int)}.
	 * 
	 * @see org.effrafax.game.mancala.domain.Heap.addStone(int)
	 */
	public void addStone() {

		addStone(1);
	}
	
	/**
	 * Adds all the stones of {@code heap} to this {@code Heap}.
	 * 
	 * @param heap The heap which stones get added to this {@code Heap}.
	 */
	public void addStone(Heap heap) {
		
		int numberOfStones = heap.countStones();
		heap.removeStone(numberOfStones);
		
		this.addStone(numberOfStones);
	}
	
	/**
	 * Removes a number of stones from this {@code Heap}. An exception is thrown in
	 * the following circumstances:
	 * <ul>
	 * 	<li>The number of stones is negative.</li>
	 *	<li>This {@code Heap} does not contain the said number of stones.</li>
	 * </ul>
	 * 
	 * @param numberOfStones The number of stones removed from this {@code Heap}.
	 * @throws IllegalArgumentException if {@code numberOfStones} is negative.
	 * @throws IllegalStateException if this {@code Heap} does not contain at least 
	 * 		{@code numberOfStones} stones.
	 */
	public void removeStone(int numberOfStones)
			throws IllegalArgumentException, IllegalStateException {
		
		if (numberOfStones < 0) {
			
			throw new IllegalArgumentException(EXCEPTION_NONNEGATIVE);
		}
		if (this.countStones() < numberOfStones) {
			
			throw new IllegalStateException(EXCEPTION_TOFEW);
		}
		
		this.numberOfStones -= numberOfStones;
	}
	
	/**
	 * Removes one stone from this {@code Heap}. An IllegalStateException is thrown
	 * if this {@Heap} does not contain one stone.
	 * 
	 * @throws IllegalStateException If this {@code Heap} does not contain one stone.
	 */
	public void removeStone() throws IllegalStateException {
		
		removeStone(1);
	}

	/**
	 * @return the owner
	 */
	public Player getOwner() {
		
		return owner;
	}

	/**
	 * Setter for the owner of this {@code Heap}. An exception is thrown if 
	 * {@code owner} is null.
	 * 
	 * @param owner the owner to set
	 * @throws IllegalArgumentException if {@code owner} is null.
	 */
	public void setOwner(Player owner) throws IllegalArgumentException {
		
		if (owner == null) {
			
			throw new IllegalArgumentException(EXCEPTION_NONNULL);
		}
		
		this.owner = owner;
	}
	
	/**
	 * Changes the ownership of this {@code Heap} to the opponent of the current owner.
	 */
	public void changeOwner() {
		
		setOwner(getOwner().opponent());
	}
}
