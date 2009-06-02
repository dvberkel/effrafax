/**
 * 
 */
package org.effrafax.game.mancala.view.wicket;

import java.util.List;
import java.util.Map;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.effrafax.game.mancala.Mancala;
import org.effrafax.game.mancala.MancalaBuilder;
import org.effrafax.game.mancala.domain.Player;

/**
 * @author dwanrooy
 *
 */
public class Status extends WebPage {
	
	private static final String BOWL_ID = "BowlNr";
	private static final String KALAHA_ID = "Kalaha";
	
	public Mancala getMancala() {
		
		MancalaBuilder builder = new MancalaBuilder();
		builder.setStartPlayer(Player.white);
		builder.setNumberOfBowls(6);
		builder.setNumberOfStones(4);
		
		return new Mancala(builder);
	}
	
	public Status() {
		
		showStatus();
	}
	
	public void showStatus() {
		
		Mancala mancala = getMancala();
		
		add(new Label("plyCount", "0"));
		add(new Label("currentPlayer", mancala.getCurrentPlayer().toString()));
		
		Map<Player,List<Integer>> stonesPerPlayer = mancala.getStonesPerPlayer();
		Player currentPlayer = mancala.getCurrentPlayer();
		for (Player player : Player.values()) {
			
			List<Integer> stones = stonesPerPlayer.get(player);
			for (int index = 0; index < 6; index++) {
				
				String currentBowlId = player.toString() + BOWL_ID + index;
				
				Integer numberOfStones = stones.get(index);
				if (numberOfStones == 0 || ! player.equals(currentPlayer)) {
					
					/* This bowl is not playable. */
					add(new Label(currentBowlId, stones.get(index).toString()));
				} else {
					
					/* This bowl is playable. */
					add(new Label(currentBowlId, "-" + stones.get(index)));
				}
			}
			
			String kalahaId = player.toString() + KALAHA_ID;
			add(new Label(kalahaId, stones.get(6).toString()));
		}
	}
}
