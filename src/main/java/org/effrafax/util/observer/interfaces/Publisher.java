package org.effrafax.util.observer.interfaces;

public interface Publisher {
	
	public void attach(PublicationAspect aspect, Subscriber subscriber);
	
	public void detach(PublicationAspect aspect, Subscriber subscriber);
	
	public void publish(PublicationAspect aspect);
}
