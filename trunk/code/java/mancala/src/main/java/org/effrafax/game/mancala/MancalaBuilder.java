/**
 * 
 */
package org.effrafax.game.mancala;

import org.effrafax.game.mancala.domain.Player;

/**
 * This class is used in the construction of the a mancala game.
 * 
 * @author dwanrooy
 *
 */
public class MancalaBuilder {
	
	private static final String EXCEPTION_NONPOSITIVE =
		"the argument should be greater then zero";
	private static final String EXCEPTION_NONNULL =
		"the argument should be non-null";
	
	/**
	 * Default values for a MancalaBuilder
	 */
	private int numberOfBowls = 6;
	private int numberOfStones = 4;
	private Player startPlayer = Player.white;
	
	/**
	 * @return the numberOfBowls
	 */
	public int getNumberOfBowls() {
		
		return numberOfBowls;
	}
	
	/**
	 * @param numberOfBowls the numberOfBowls to set
	 * @throws IllegalArgumentException if {@code numberOfBowls} is less then
	 * 			one.
	 */
	public MancalaBuilder setNumberOfBowls(int numberOfBowls)
			throws IllegalArgumentException {
		
		if (numberOfBowls < 1) {
			
			throw new IllegalArgumentException(EXCEPTION_NONPOSITIVE);
		}
		
		this.numberOfBowls = numberOfBowls;
		
		return this;
	}
	
	/**
	 * @return the numberOfStones
	 */
	public int getNumberOfStones() {
		return numberOfStones;
	}
	
	/**
	 * @param numberOfStones the numberOfStones to set
	 * @throws IllegalArgumentException if {@code numberOfBowls} is less then
	 * 			one.
	 */
	public MancalaBuilder setNumberOfStones(int numberOfStones) 
			throws IllegalArgumentException {
		
		if (numberOfStones < 1) {
			
			throw new IllegalArgumentException(EXCEPTION_NONPOSITIVE);
		}
		
		this.numberOfStones = numberOfStones;
		
		return this;
	}

	/**
	 * @return the startPlayer
	 */
	public Player getStartPlayer() {
		return startPlayer;
	}

	/**
	 * @param startPlayer the startPlayer to set
	 * @throws IllegalArgumentException if {@code startPlayer} is {@code null}.
	 */
	public MancalaBuilder setStartPlayer(Player startPlayer) {
		
		if (startPlayer == null) {
			
			throw new IllegalArgumentException(EXCEPTION_NONNULL);
		}
		
		this.startPlayer = startPlayer;
		
		return this;
	}
}
