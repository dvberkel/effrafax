/**
 * 
 */
package org.effrafax.game.mancala.view.wicket;

import java.util.Map;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.effrafax.game.mancala.Mancala;
import org.effrafax.game.mancala.domain.Player;

/**
 * @author dwanrooy
 *
 */
public class Result extends MancalaPage {
	
	private static final String VICTORY_MESSAGE = "The game is won by ";
	private static final String CONNECTIVE = " with ";
	private static final String STONES = " stones.";
	private static final String DRAW_MESSAGE = "The game ended in a draw.";
	
	/**
	 * Constructor
	 */
	@SuppressWarnings("serial")
	public Result() {
		
		Mancala mancala = getMancala();
		Map<Player, Integer> score = mancala.score();
		
		Integer whiteScore = score.get(Player.white);
		Integer blackScore = score.get(Player.black);
		
		String result;
		if (blackScore < whiteScore) {
			
			result = victoryMessage(Player.white, whiteScore - blackScore);
		} else if (whiteScore < blackScore) {
			
			result = victoryMessage(Player.black, blackScore - whiteScore);
		} else {
			
			result = drawMessage();
		}
		
		add(new Label("result", result));
		
		add(new Link("start") {

			/* (non-Javadoc)
			 * @see org.apache.wicket.markup.html.link.Link#onClick()
			 */
			@Override
			public void onClick() {
				
				newMancala();
				setResponsePage(Status.class);
			}			
		});
	}
	
	/**
	 * Returns a message that announces that {@code winner} won the game by 
	 * {@code stones} stones.
	 *   
	 * @param winner The {@code Player} who won the game.
	 * @param stones The number of stones the {@code winner} won.
	 * @return A victory message.
	 */
	protected String victoryMessage(Player winner, Integer stones) {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(VICTORY_MESSAGE);
		stringBuilder.append(winner);
		
		stringBuilder.append(CONNECTIVE);
		stringBuilder.append(stones);
		stringBuilder.append(STONES);
		
		return stringBuilder.toString();
	}
	
	/**
	 * Returns a message to reflect the game ended in a draw.
	 * 
	 * @return A draw message.
	 */
	protected String drawMessage() {
		
		return DRAW_MESSAGE;
	}
}
