/**
 * 
 */
package org.effrafax.game.mancala.domain;

/**
 * This interface represents a bowl in the mancala game.
 * 
 * @author dwanrooy
 *
 */
public interface Bowl {
	
	/**
	 * Counts the number of stones in this {@code Bowl}s {@code Heap}.
	 * 
	 * @return The number of stones in the {@code Heap} of this {@code Bowl}.
	 */
	public int countStones();
	
	/**
	 * Returns the owner of this {@code Bowl}.
	 * 
	 * @return The owner of this {@code Bowl}.
	 */	
	public Player getOwner();
	
	/**
	 * Returns the {@code Bowl} which follows this {@code Bowl}.
	 *
	 * @return The {@code Bowl} following this {@code Bowl}.
	 */
	public Bowl getNextBowl();
	
	/**
	 * Sets the next {@code Bowl} for this {@code Bowl}. An exception is thrown
	 * if the next bowl is already set or when {@code nextBowl} is {@code null}.
	 *
	 * @param nextBowl The {@code Bowl} following this {@code Bowl}.
	 * @throws IllegalArgumentException if {@code nextBowl} is {@code null}.
	 * @throws IllegalStateException if the next bowl is already set.
	 */
	public void setNextBowl(Bowl nextBowl) 
			throws IllegalArgumentException, IllegalStateException;
	
	/**
	 * Returns the {@code Bowl} which is opposite to this {@code Bowl}.
	 * 
	 * @return The opposite {@code Bowl}.
	 */
	public Bowl getOppositeBowl();
	
	/**
	 * Sets the opposite {@code Bowl} for this {@code Bowl}. An exception is thrown
	 * if the opposite bowl is already set or when {@code oppositeBowl} is 
	 * {@code null}.
	 * 
	 * @param oppositeBowl The {@code Bowl} opposite to this {@code Bowl}.
	 * @throws IllegalArgumentException if {@code oppositeBowl} is {@code null}.
	 * @throws IllegalStateException if the opposite bowl is already set.
	 */
	public void setOppositeBowl(Bowl oppositeBowl) 
			throws IllegalArgumentException, IllegalStateException;
	
	/**
	 * This method performs the action for this {@code Bowl} when a {@code Heap} is 
	 * distributed across all {@code Bowl}s.
	 * 
	 * @param heap The {@code Heap} that is distributed.
	 */
	public void receiveHeap(Heap heap);
	
	/**
	 * Captures the {@code Heap} of this {@code Bowl}.
	 * 
	 * @return The captured {@code Heap}.
	 */
	public Heap captureHeap();

	/**
	 * Collects a captured {@code Heap}.
	 * 
	 * @param heap The {@code Heap} that is captured.
	 */
	public void collectHeap(Heap heap);
	
	/**
	 * Returns the {@code Kalaha} of the {@code Player} who owns this {@code Bowl}.
	 * 
	 * @return The {@code Kalaha} of the {@code Player} who owns this {@code Bowl}.
	 */
	public Kalaha getKahala();
}
