package org.effrafax.util.observer.implementations;

import java.lang.InstantiationException;
import java.lang.IllegalAccessException;
import java.lang.IllegalArgumentException;

import org.effrafax.util.observer.interfaces.PublicationAspect;

/**
 * {@code AbstractPublicationAspect} is an implementation of 
 * {@code PublicationAspect}. This class can be extended to create a chain of 
 * {@code PublicationAspect}s.
 *
 * @see org.effrafax.util.observer.interfaces.PublicationAspect
 */
public abstract class AbstractPublicationAspect implements PublicationAspect {
	
	/* Flags if the getSuperAspect method is invoked already. */
	private boolean alreadyInvoked = false;
	
	/* A reference to the determined super PublicationAspect */
	private PublicationAspect superAspect = null;
	
	/* A reference to the base class. */
	private Class<?> declaringClass = null;
	
	public AbstractPublicationAspect() {
		
		setDeclaringClass(this.getClass());
	}
	
	/**
	 * Setter for declaringClass.
	 */
	protected void setDeclaringClass(Class<?> declaringClass) {
		
		if (declaringClass == null) {
		
			throw new IllegalArgumentException("declaringClass should not be null");
		}
		
		this.declaringClass = declaringClass;
	}
	
	/*
	 * @see org.effrafax.util.observer.interfaces.PublicationAspect#getSuperAspect
	 */
	@Override
	public PublicationAspect getSuperAspect() {
		
		if (! alreadyInvoked) {
			
			alreadyInvoked = true;
			
			Class<?> superClass = declaringClass.getSuperclass();
			if (
				superClass != null && 
				superClass != AbstractPublicationAspect.class
			) {
				
				Class<?>[] interfaces = superClass.getInterfaces();
				for (Class<?> aInterface : interfaces) {
					
					if (aInterface.equals(PublicationAspect.class)) { 
						
						try {
							
							superAspect = 
								(PublicationAspect) superClass.newInstance();
						} catch(InstantiationException ie) {
							
							/*
							 * This code block should be unreachable because of
							 * the following argument:
							 *
							 * The implicite contract of the PublicationAspect
							 * does not allow for interfaces or abstract classes
							 * to extend or implement PublicationAspect.
							 */
							assert false;
						} catch(IllegalAccessException iae) {
							
							/*
							 * This code block should be unreachable because of
							 * the following argument:
							 *
							 * The implicite contract of the PublicationAspect
							 * does stipulates that there exist a public no-args
							 * constructor.
							 */
							assert false;
						} catch(IllegalArgumentException iae) {
							
							/*
							 * This code block should be unreachable because of
							 * the following argument:
							 *
							 * The implicite contract of the PublicationAspect
							 * does stipulates that there exist a public no-args
							 * constructor.
							 */
							assert false;
						}
						
						/* breaks the for loop over the interfaces. */
						break;
					}
				}
			}
		}
		
		return superAspect;		
	}
}
