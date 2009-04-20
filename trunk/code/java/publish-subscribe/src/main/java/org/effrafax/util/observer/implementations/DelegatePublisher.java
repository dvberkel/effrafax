/**
 * 
 */
package org.effrafax.util.observer.implementations;

import org.effrafax.util.observer.interfaces.Publisher;

/**
 * @author dwanrooy
 *
 */
public class DelegatePublisher extends AbstractPublisher {
	
	public DelegatePublisher(Publisher publisher) {
		
		setPublisher(publisher);
	}
}
