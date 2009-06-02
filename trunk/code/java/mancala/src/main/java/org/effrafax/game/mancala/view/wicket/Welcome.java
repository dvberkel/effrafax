/**
 * 
 */
package org.effrafax.game.mancala.view.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.PageLink;

/**
 * @author dwanrooy
 *
 */
public class Welcome extends WebPage {
	
	public Welcome() {
		
		add(new Label("greeting", "Welcome to the Mancala Game"));
		
		add(new PageLink("start", Status.class));
	}

}
