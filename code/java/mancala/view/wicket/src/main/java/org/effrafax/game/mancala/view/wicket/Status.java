/**
 * 
 */
package org.effrafax.game.mancala.view.wicket;

import java.util.List;
import java.util.Map;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.PageLink;
import org.effrafax.game.mancala.Mancala;
import org.effrafax.game.mancala.domain.Player;

/**
 * @author dwanrooy
 *
 */
public class Status extends MancalaPage {
	
	private static final String BOWL_ID = "BowlNr";
	private static final String STONES_ID = "StonesNr";
	private static final String KALAHA_ID = "Kalaha";

	public Status() {
		
		showStatus();
	}
	
	/**
	 * Shows a representation the current mancala game.
	 */
	public void showStatus() {
		
		Mancala mancala = getMancala();
		
		add(new Label("currentPlayer", mancala.getCurrentPlayer().toString()));
		
		Map<Player,List<Integer>> stonesPerPlayer = mancala.getStonesPerPlayer();
		Player currentPlayer = mancala.getCurrentPlayer();
		for (Player player : Player.values()) {
			
			List<Integer> stones = stonesPerPlayer.get(player);
			for (int index = 0; index < 6; index++) {
				
				Integer numberOfStones = stones.get(index);
				if (numberOfStones > 0 && player.equals(currentPlayer)) {
					
					/* This is a playable bowl. */
					createPlayableLink(player, index, numberOfStones);
				} else {
					
					createLink(player, index, numberOfStones);
				}
			}
			
			String kalahaId = player.toString() + KALAHA_ID;
			add(new Label(kalahaId, stones.get(6).toString()));
		}

		add(new PageLink("quit", Result.class));
	}
	
	/**
	 * Creates a link on a a bowl. This should be used if the 
	 * bowl is playable.
	 * 
	 * @param player The {@code Player} who owns the bowl.
	 * @param index The index of the bowl.
	 * @param numberOfStones The number of stones in this bowl.
	 */
	@SuppressWarnings("serial")
	public void createPlayableLink(
			final Player player, 
			final int index,
			final Integer numberOfStones) {
		
		String bowlId = getBowlId(player, index);
		String stonesId = getStonesId(player, index);
		
		add((new Link(bowlId) {

			/* (non-Javadoc)
			 * @see org.apache.wicket.markup.html.link.Link#onClick()
			 */
			@Override
			public void onClick() {
				
				getMancala().play(index);
				
				if (getMancala().isFinished()) {
					
					setResponsePage(Result.class);
				} else {
					
					setResponsePage(Status.class);
				}
			}
		}).add(new Label(stonesId, numberOfStones.toString())));
	}
	
	/**
	 * Creates a link on a a bowl. This should be used if the 
	 * bowl is not playable.
	 * 
	 * @param player The {@code Player} who owns the bowl.
	 * @param index The index of the bowl.
	 * @param numberOfStones The number of stones in this bowl.
	 */
	@SuppressWarnings("serial")
	public void createLink(
			final Player player, 
			final int index,
			final Integer numberOfStones) {
		
		String bowlId = getBowlId(player, index);
		String stonesId = getStonesId(player, index);
		
		add((new Link(bowlId) {

			/* (non-Javadoc)
			 * @see org.apache.wicket.markup.html.link.Link#onClick()
			 */
			@Override
			public void onClick() {
				
				/* We are not finished so return to this page. */
			}
		}).add(new Label(stonesId, numberOfStones.toString())));
	}
	
	/**
	 * Returns a bowl id given a {@code Player} and a {@code index};
	 * 
	 * @param player The {@code Player} who owns the bowl.
	 * @param index The index of the bowl.
	 * @return
	 */
	private String getBowlId(Player player, int index) {
		
		return player.toString() + BOWL_ID + index;
	}
	
	/**
	 * Returns a stones id given a {@code Player} and a {@code index};
	 * 
	 * @param player The {@code Player} who owns the bowl which holds the 
	 * 		stones.
	 * @param index The index of the bowl which holds the stones.
	 * @return
	 */
	private String getStonesId(Player player, int index) {
		
		return player.toString() + STONES_ID + index;
	}
}
