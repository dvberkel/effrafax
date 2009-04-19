package org.effrafax.util.observer.implementations;

/**
 * {@code DelegatePublicationAspect} is an implementation of 
 * {@code PublicationAspect}. This class can be used as a delegate for 
 * {@code PublicationAspect} calls.
 *
 * @see org.effrafax.util.observer.interfaces.PublicationAspect
 */
public abstract class DelegatePublicationAspect 
	extends AbstractPublicationAspect 
{
	
	public DelegatePublicationAspect(Class<?> declaringClass) {
		
		/* @see org.effrafax.util.observer.interfaces.PublicationAspect#setDeclaringClass */
		setDeclaringClass(declaringClass);
	}
	
}
