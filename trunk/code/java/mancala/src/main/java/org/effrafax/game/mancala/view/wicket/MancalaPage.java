/**
 * 
 */
package org.effrafax.game.mancala.view.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.effrafax.game.mancala.Mancala;
import org.effrafax.game.mancala.MancalaBuilder;
import org.effrafax.game.mancala.domain.Player;

/**
 * @author dwanrooy
 *
 */
public abstract class MancalaPage extends WebPage {
	
	private Mancala mancala = null;
	
	protected Mancala getMancala() {
		
		// TODO Use a session to retrieve the current mancala
		if (mancala == null) {
			
			MancalaBuilder builder = new MancalaBuilder();
			builder.setNumberOfBowls(6);
			builder.setNumberOfStones(5);
			builder.setStartPlayer(Player.white);
			
			mancala = new Mancala(builder);
		}
		
		return mancala;
	}
}
