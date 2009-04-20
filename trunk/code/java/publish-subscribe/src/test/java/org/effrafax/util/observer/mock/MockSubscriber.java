/**
 * 
 */
package org.effrafax.util.observer.mock;

import org.effrafax.util.observer.implementations.AbstractSubscriber;

/**
 * @author dwanrooy
 *
 */
public class MockSubscriber extends AbstractSubscriber {
	
	private int numberOfUpdates = 0;
	
	public int getNumberOfUpdates() {
		
		return numberOfUpdates;
	}
	
	public void incrementNumberOfUpdates() {
		
		numberOfUpdates++;
	}
}
