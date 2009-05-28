/**
 * 
 */
package org.effrafax.game.mancala;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.effrafax.game.mancala.domain.Bowl;
import org.effrafax.game.mancala.domain.Player;
import org.effrafax.game.mancala.message.ExceptionMessage;

/**
 * @author dwanrooy
 *
 */
public class Mancala {
	
	private Player currentPlayer = null;
	Map<Player, Bowl> startBowlMap = null;
	
	public Mancala(MancalaBuilder builder) {
		
		setCurrentPlayer(builder.getStartPlayer());
		setStartBowlMap(BoardFactory.createBoard(builder));
	}
	
	/**
	 * @return the currentPlayer
	 */
	public Player getCurrentPlayer() {
		
		return currentPlayer;
	}

	/**
	 * Ends a turn for the current player. The opponent will become the 
	 * current player and take a turn.
	 */
	public void endTurn() {
		
		setCurrentPlayer(getCurrentPlayer().opponent());
	}
	
	/**
	 * @param currentPlayer the currentPlayer to set
	 */
	private void setCurrentPlayer(Player currentPlayer) {
	
		this.currentPlayer = currentPlayer;
	}

	/**
	 * @return the startBowlMap
	 */
	private Map<Player, Bowl> getStartBowlMap() {
		
		return startBowlMap;
	}

	/**
	 * @param startBowlMap the startBowlMap to set
	 */
	private void setStartBowlMap(Map<Player, Bowl> startBowlMap) {
		
		this.startBowlMap = startBowlMap;
	}
	
	/**
	 * Returns the start {@code Bowl} of chain owned by the current 
	 * {@code Player}.
	 * 
	 * @return The start {@code Bowl} owned by the current {@code Player}.
	 */
	private Bowl getStartBowlCurrentPlayer() {

		return getStartBowlMap().get(getCurrentPlayer());		
	}
	
	/**
	 * Returns if a {@code Bowl} is playable by the current player.
	 *  
	 * @param bowl The {@code Bowl} under scrutiny.
	 * @return {@code true} if the player owns {@code bowl} and {@code bowl} is
	 * 		playable, {@code false} otherwise. 
	 */
	private boolean playable(Bowl bowl) {
		
		return bowl.getOwner().equals(getCurrentPlayer()) && bowl.playable();
	}
	
	/**
	 * Returns the indices of playable {@code Bowl}s for the current 
	 * {@code Player}. The start {@code Bowl} gets index 0 and every skip
	 * increments the index.
	 * 
	 * @return A {@code List<Integer>} of indices of playable {@code Bowl}s.
	 */
	public List<Integer> options() {
		
		List<Integer> options = new ArrayList<Integer>();
		
		Bowl bowl = getStartBowlCurrentPlayer();
		
		Integer index = 0;
		while (bowl.getOwner().equals(getCurrentPlayer())) {
			
			if (playable(bowl)) {
				
				options.add(index);
			}
			
			bowl = bowl.getNextBowl();
			index++;
		}
		
		return options;
	}
	
	/**
	 * Returns the bowl {@code index} skips away from the start 
	 * {@code Bowl} of the current {@code Player}. An 
	 * {@code IllegalArgumentException} is thrown when {@code index} is 
	 * {@code null} or negative.
	 * 
	 * @param index The number of skips to perform from the start {@code Bowl}.
	 * @return The {@code Bowl} reached after {@code index} skips.
	 * @throws IllegalArgumentException if {@code index} is {@code null} or
	 * 		negative.
	 */
	private Bowl getBowlAtIndex(Integer index) 
			throws IllegalArgumentException {
		
		if (index == null || index < 0) {
			
			throw new IllegalArgumentException(
					ExceptionMessage.NON_NULL_NEGATIVE.toString()
			);
		}
		
		Bowl bowl = getStartBowlCurrentPlayer();
		while (index > 0) {
			
			bowl = bowl.getNextBowl();
			index--;
		}
		
		return bowl;
	}
	
	/**
	 * Plays the {@code Bowl} {@code index} skips from the start {@code Bowl}
	 * from the current {@code Player}. An {@code IllegalArgumentException} is
	 * thrown if that {@code Bowl} is not playable.
	 * 
	 * @param index The number of skips to perform from the start {@code Bowl}.
	 * @throws IllegalArgumentException if the {@code Bowl} after 
	 * 		{@code index} skips is not playable.
	 */
	public void play(Integer index) throws IllegalArgumentException {
		
		Bowl bowl = getBowlAtIndex(index);
		
		if (! playable(bowl)) {
			
			throw new  IllegalStateException(ExceptionMessage.NOT_PLAYABLE.toString());
		}
		
		if (! bowl.play()) {
			
			/* We do not get to take another turn */
			endTurn();
		}
	}	
}
