/**
 * 
 */
package org.effrafax.game.mancala.view.wicket;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

/**
 * @author dwanrooy
 *
 */
public class Welcome extends MancalaPage {
	
	@SuppressWarnings("serial")
	public Welcome() {
		
		add(new Label("greeting", "Welcome to the Mancala Game"));
		
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

}
