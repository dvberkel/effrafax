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
	
	protected Mancala getMancala() {
		
		Mancala mancala = ((MancalaSession) getSession()).getMancala();
		
		return mancala;
	}

	/* (non-Javadoc)
	 * @see org.apache.wicket.Component#isVersioned()
	 */
	@Override
	public boolean isVersioned() {
		
		return false;
	}
	
	
}
