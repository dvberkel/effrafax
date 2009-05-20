/**
 * 
 */
package org.effrafax.util.observer;

import org.effrafax.util.observer.interfaces.PublicationHandler;
import org.effrafax.util.observer.interfaces.Publisher;
import org.effrafax.util.observer.interfaces.Subscriber;

/**
 * @author dwanrooy
 *
 */
public class PublicationHandlerChain implements PublicationHandler {
	
	private PublicationHandler handler = null;
	private PublicationHandlerChain nextChain = null;
	
	public PublicationHandlerChain(PublicationHandler handler) {
		
		setPublicationHandler(handler);
	}
	
	protected void setPublicationHandler(PublicationHandler handler) {
		
		if (handler == null) {
			
			throw new IllegalArgumentException("handler should not be null");
		}
		
		this.handler = handler;
	}
	
	protected void setNextPublicationHandlerChain(PublicationHandlerChain nextChain) {
		
		if (nextChain == null) {
			
			throw new IllegalArgumentException("nextChain should not be null");
		}
		
		this.nextChain = nextChain;
	}
	
	public void addPublicationHandler(PublicationHandler handler) {
		
		if (nextChain != null) {
			
			nextChain.addPublicationHandler(handler);
		} else {
			
			setNextPublicationHandlerChain(new PublicationHandlerChain(handler));
		}
	}
	
	/* (non-Javadoc)
	 * @see org.effrafax.util.observer.interfaces.PublicationHandler#handlePublication(org.effrafax.util.observer.interfaces.Publisher, org.effrafax.util.observer.interfaces.Subscriber)
	 */
	@Override
	public void handlePublication(Publisher publisher, Subscriber subscriber) {
		
		handler.handlePublication(publisher, subscriber);
		
		if (nextChain != null) {
			
			nextChain.handlePublication(publisher, subscriber);
		}
	}

}
