/**
 * 
 */
package org.effrafax.game.mancala.view.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/**
 * @author dwanrooy
 *
 */
public class Welcome extends WebPage {
	
	public Welcome() {
		
		add(new Label("greeting", "Welcome to the Mancala Game"));
	}

}
