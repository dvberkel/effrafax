/**
 * 
 */
package org.effrafax.game.mancala.domain;

/**
 * This class represents a bowl in the mancala game.
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
	public Bowl nextBowl();
	
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
