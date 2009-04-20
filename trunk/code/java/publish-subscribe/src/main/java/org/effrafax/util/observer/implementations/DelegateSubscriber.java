/**
 * 
 */
package org.effrafax.util.observer.implementations;

import org.effrafax.util.observer.interfaces.Subscriber;

/**
 * @author dwanrooy
 *
 */
public class DelegateSubscriber extends AbstractSubscriber {
	
	public DelegateSubscriber(Subscriber subscriber) {
		
		setSubscriber(subscriber);
	}
}
