/**
 * 
 */
package org.effrafax.util.observer.implementations;

import java.util.HashMap;
import java.util.Map;

import org.effrafax.util.observer.interfaces.PublicationAspect;
import org.effrafax.util.observer.interfaces.PublicationHandler;
import org.effrafax.util.observer.interfaces.Publisher;
import org.effrafax.util.observer.interfaces.Subscriber;

/**
 * @author dwanrooy
 *
 */
public abstract class AbstractSubscriber implements Subscriber {
	
	private Map<PublicationAspect, PublicationHandler> aspectToHandler = null;
	
	private Subscriber subscriber = null;
	
	public AbstractSubscriber() {
		
		aspectToHandler = new HashMap<PublicationAspect, PublicationHandler>();
		setSubscriber(this);
	}
	
	/**
	 * Setter for subscriber.
	 */
	protected void setSubscriber(Subscriber subscriber) {
		
		if (subscriber == null) {
			
			throw new IllegalArgumentException("subscriber should not be null");
		}
		
		this.subscriber = subscriber;
	}
	
	/* (non-Javadoc)
	 * @see org.effrafax.util.observer.interfaces.Subscriber#registerHandler(org.effrafax.util.observer.interfaces.PublicationHandler, org.effrafax.util.observer.interfaces.PublicationAspect)
	 */
	@Override
	public void registerHandler(
			PublicationAspect aspect,
			PublicationHandler handler
	) {
		
		if (aspect == null) {
			
			throw new IllegalArgumentException("aspect should not be null");
		}
		
		aspectToHandler.put(aspect, handler);		
	}

	/* (non-Javadoc)
	 * @see org.effrafax.util.observer.interfaces.Subscriber#update(org.effrafax.util.observer.interfaces.Publisher, org.effrafax.util.observer.interfaces.PublicationAspect)
	 */
	@Override
	public void update(Publisher publisher, PublicationAspect aspect) {
		
		if (publisher == null) {
			
			throw new IllegalArgumentException("publisher should not be null");
		}
		if (aspect == null) {
			
			throw new IllegalArgumentException("aspect should not be null");
		}
		if (
			!aspectToHandler.containsKey(aspect) || 
			aspectToHandler.get(aspect) == null
		) {
			
			throw new IllegalStateException(
				"no handler is registered for aspect" + aspect
			);
		}
		
		aspectToHandler.get(aspect).handlePublication(publisher, subscriber);
	}
}
