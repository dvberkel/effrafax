/**
 * 
 */
package org.effrafax.util.observer.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.effrafax.util.observer.interfaces.PublicationAspect;
import org.effrafax.util.observer.interfaces.Publisher;
import org.effrafax.util.observer.interfaces.Subscriber;

/**
 * @author dwanrooy
 *
 */
public abstract class AbstractPublisher implements Publisher {
	
	private Map<PublicationAspect, List<Subscriber>> aspectToSubscribers = null;
	
	/* A reference to the publisher of the publications. */
	private Publisher publisher = null;
	
	public AbstractPublisher() {
		
		aspectToSubscribers = new HashMap<PublicationAspect, List<Subscriber>>();
		this.setPublisher(publisher);
	}
	
	protected void setPublisher(Publisher publisher) {
		
		if (publisher == null) {
			
			throw new IllegalArgumentException("publisher should not be null");
		}
		
		this.publisher = publisher;
	}
	
	/* (non-Javadoc)
	 * @see org.effrafax.util.observer.interfaces.Publisher#attach(org.effrafax.util.observer.interfaces.PublicationAspect, org.effrafax.util.observer.interfaces.Subscriber)
	 */
	@Override
	public void attach(PublicationAspect aspect, Subscriber subscriber) {
		
		if (aspect == null) {
			
			throw new IllegalArgumentException("aspect should not be null");
		}
		if (subscriber == null) {
			
			throw new IllegalArgumentException("subscriber should not be null");
		}
		
		if (! aspectToSubscribers.containsKey(aspect)) {
			
			aspectToSubscribers.put(aspect, new ArrayList<Subscriber>());
		}
		
		aspectToSubscribers.get(aspect).add(subscriber);
	}

	/* (non-Javadoc)
	 * @see org.effrafax.util.observer.interfaces.Publisher#detach(org.effrafax.util.observer.interfaces.PublicationAspect, org.effrafax.util.observer.interfaces.Subscriber)
	 */
	@Override
	public void detach(PublicationAspect aspect, Subscriber subscriber) {
		
		if (aspect == null) {
			
			throw new IllegalArgumentException("aspect should not be null");
		}
		if (subscriber == null) {
			
			throw new IllegalArgumentException("subscriber should not be null");
		}
		
		if (aspectToSubscribers.containsKey(aspect)) {
			
			aspectToSubscribers.get(aspect).remove(subscriber);
		}
	}

	/* (non-Javadoc)
	 * @see org.effrafax.util.observer.interfaces.Publisher#publish(org.effrafax.util.observer.interfaces.PublicationAspect)
	 */
	@Override
	public void publish(PublicationAspect aspect) {
		
		if (aspect == null) {
			
			throw new IllegalArgumentException("aspect should not be null");			
		}
		
		if (aspectToSubscribers.containsKey(aspect)) {
			
			for (Subscriber subscriber : aspectToSubscribers.get(aspect)) {
			
				subscriber.update(publisher, aspect);
			}
		}
	}

}
