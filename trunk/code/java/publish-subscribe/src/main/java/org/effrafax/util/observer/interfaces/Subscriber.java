package org.effrafax.util.observer.interfaces;

public interface Subscriber {
	
	public void registerHandler(
		PublicationHandler handler, 
		PublicationAspect aspect
	);
	
	public void update(Publisher publisher, PublicationAspect aspect);
}
