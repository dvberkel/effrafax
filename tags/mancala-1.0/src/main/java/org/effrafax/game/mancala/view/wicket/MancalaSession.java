/**
 * 
 */
package org.effrafax.game.mancala.view.wicket;

import org.apache.wicket.Request;
import org.apache.wicket.protocol.http.WebSession;
import org.effrafax.game.mancala.Mancala;
import org.effrafax.game.mancala.MancalaBuilder;
import org.effrafax.game.mancala.domain.Player;

/**
 * @author dwanrooy
 *
 */
@SuppressWarnings("serial")
public class MancalaSession extends WebSession {

	private Mancala mancala;
	
	/**
	 * Constructor
	 * 
	 * @param request The current request object.
	 */
	public MancalaSession(Request request) {

		super(request);
	}
	
	/**
	 * Returns a {@code Mancala} game.
	 * 
	 * @return A {@code Mancala} game being played.
	 */
	public Mancala getMancala() {
		
		if (mancala == null) {
			
			MancalaBuilder builder = new MancalaBuilder();
			builder.setStartPlayer(Player.white);
			builder.setNumberOfBowls(6);
			builder.setNumberOfStones(4);
			
			mancala = new Mancala(builder);
		}
		
		return mancala;
	}
	
	/**
	 * Resets the reference to the {@code Mancala} game.
	 */
	public void newMancala() {
		
		mancala = null;
	}
}
