/**
 * 
 */
package org.effrafax.game.mancala.view.wicket;


import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.settings.IResourceSettings;

/**
 * @author dwanrooy
 *
 */
public class MancalaApplication extends WebApplication {

	/* (non-Javadoc)
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<?> getHomePage() {

		return Welcome.class;
	}

	/* (non-Javadoc)
	 * @see org.apache.wicket.protocol.http.WebApplication#init()
	 */
	@Override
	protected void init() {

		super.init();

		IResourceSettings resourceSettings = getResourceSettings();
		resourceSettings.addResourceFolder("src/main/html"); //this path should be changed
		resourceSettings.setResourceStreamLocator(new AnnotatedLocator());

	}

	/* (non-Javadoc)
	 * @see org.apache.wicket.protocol.http.WebApplication#newSession(org.apache.wicket.Request, org.apache.wicket.Response)
	 */
	@Override
	public Session newSession(Request request, Response response) {

		return new MancalaSession(request);
	}	

}
