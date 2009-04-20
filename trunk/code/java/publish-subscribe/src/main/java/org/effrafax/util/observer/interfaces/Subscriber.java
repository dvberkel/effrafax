package org.effrafax.util.observer.interfaces;

public interface Subscriber {
	
	public void registerHandler(
		PublicationAspect aspect,
		PublicationHandler handler 
	);
	
	public void update(Publisher publisher, PublicationAspect aspect);
}
