/**
 * 
 */
package org.effrafax.game.mancala.view.wicket;

import java.util.Map;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.PageLink;
import org.effrafax.game.mancala.Mancala;
import org.effrafax.game.mancala.MancalaBuilder;
import org.effrafax.game.mancala.domain.Player;

/**
 * @author dwanrooy
 *
 */
public class Result extends WebPage {
	
	private static final String VICTORY_MESSAGE = "The game is won by ";
	private static final String CONNECTIVE = " with ";
	private static final String STONES = " stones.";
	private static final String DRAW_MESSAGE = "The game ended in a draw.";
	
	/**
	 * Constructor
	 */
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
		
		add(new PageLink("start", Status.class));
	}
	
	/**
	 * Returns the current mancala game.
	 * 
	 * @return the current mancala game.
	 */
	public Mancala getMancala() {
		
		MancalaBuilder builder = new MancalaBuilder();
		builder.setStartPlayer(Player.white);
		builder.setNumberOfBowls(6);
		builder.setNumberOfStones(4);
		
		return new Mancala(builder);
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
