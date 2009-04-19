package org.effrafax.util.observer.interfaces;

public interface Publisher {
	
	public void attach(Subscriber subscriber);
	
	public void detach(Subscriber subscriber);
	
	public void publish();
}
