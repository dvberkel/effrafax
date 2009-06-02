/**
 * 
 */
package org.effrafax.game.mancala.view.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.effrafax.game.mancala.domain.Player;

/**
 * @author dwanrooy
 *
 */
public class Status extends WebPage {
	
	private static final String BOWL_ID = "BowlNr";
	
	public Status() {
		
		add(new Label("plyCount", "0"));
		add(new Label("currentPlayer", Player.white.toString()));
		
		for (Player player : Player.values()) {
			
			for (int index = 0; index < 6; index++) {
				
				String currentBowlId = player.toString() + BOWL_ID + index;
				
				add(new Label(currentBowlId, "4"));
			}
		}
		add(new Label("whiteKalaha", "0"));
		add(new Label("blackKalaha", "0"));
	}
}
