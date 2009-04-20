/**
 * 
 */
package org.effrafax.util.observer.mock;

import org.effrafax.util.observer.implementations.DelegatePublicationAspect;
import org.effrafax.util.observer.interfaces.PublicationAspect;

/**
 * @author dwanrooy
 *
 */
public class AnDelegateAspect implements PublicationAspect {
	
	private DelegatePublicationAspect delegate = null;
	
	public AnDelegateAspect() {
		
		delegate = new DelegatePublicationAspect(this.getClass()); 
	}
	
	/* (non-Javadoc)
	 * @see org.effrafax.util.observer.interfaces.PublicationAspect#getSuperAspect()
	 */
	@Override
	public PublicationAspect getSuperAspect() {
		
		return delegate.getSuperAspect();
	}

}
