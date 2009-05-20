package org.effrafax.util.observer.interfaces;

public interface PublicationHandler {

	public void handlePublication(
		Publisher publisher, 
		Subscriber subscriber
	);	
}
