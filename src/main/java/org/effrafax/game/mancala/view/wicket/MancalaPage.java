/**
 * 
 */
package org.effrafax.game.mancala.view.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.effrafax.game.mancala.Mancala;

/**
 * @author dwanrooy
 *
 */
public abstract class MancalaPage extends WebPage {
	
	/**
	 * Returns the {@code Mancala} game referenced by the session.
	 * 
	 * @return The current {@code Mancala} game.
	 */
	protected Mancala getMancala() {
		
		Mancala mancala = ((MancalaSession) getSession()).getMancala();
		
		return mancala;
	}
	
	/**
	 * Resets the {@code Mancala} game referenced by the session.
	 */
	protected void newMancala() {
	
		((MancalaSession) getSession()).newMancala();
	}

	/* (non-Javadoc)
	 * @see org.apache.wicket.Component#isVersioned()
	 */
	@Override
	public boolean isVersioned() {
		
		return false;
	}
	
	
}
