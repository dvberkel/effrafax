/**
 * 
 */
package org.effrafax.util.observer;

import junit.framework.Assert;

import org.effrafax.util.observer.implementations.AbstractPublicationAspect;
import org.effrafax.util.observer.interfaces.PublicationAspect;
import org.effrafax.util.observer.interfaces.PublicationHandler;
import org.effrafax.util.observer.interfaces.Publisher;
import org.effrafax.util.observer.interfaces.Subscriber;
import org.effrafax.util.observer.mock.ASubAspect;
import org.effrafax.util.observer.mock.MockPublisher;
import org.effrafax.util.observer.mock.MockSubscriber;
import org.junit.Before;
import org.junit.Test;


/**
 * @author dwanrooy
 *
 */
public class PublishingTest {
	
	private MockPublisher publisher = null;
	private MockSubscriber subscriber = null;
	private PublicationAspect aspect = null;
	private PublicationHandler handler = null;
	
	@Before
	public void createInstances() {
		
		publisher = new MockPublisher();
		subscriber = new MockSubscriber(){};
		
		aspect = new AbstractPublicationAspect() {};
		handler = new PublicationHandler() {

			@Override
			public void handlePublication(
				Publisher publisher,
				Subscriber subscriber)
			{
				
				MockSubscriber mockSubscriber = (MockSubscriber) subscriber;
				mockSubscriber.incrementNumberOfUpdates();
			}			
		};
	}
	
	@Test
	public void testPublish() {
		
		subscriber.registerHandler(aspect, handler);
		publisher.publish(aspect);
		
		Assert.assertEquals(0, subscriber.getNumberOfUpdates());
		
		publisher.attach(aspect, subscriber);
		publisher.publish(aspect);
		
		Assert.assertEquals(1, subscriber.getNumberOfUpdates());
		
		publisher.detach(aspect, subscriber);
		publisher.publish(aspect);
	
		Assert.assertEquals(1, subscriber.getNumberOfUpdates());
		
	}
	
	@Test
	public void testSuperPublish() {
		
		PublicationAspect aSubAspect = new ASubAspect();
		PublicationAspect anAspect = aSubAspect.getSuperAspect();
		
		subscriber.registerHandler(anAspect, handler);
		publisher.publish(aSubAspect);
		
		Assert.assertEquals(0, subscriber.getNumberOfUpdates());
		
		publisher.attach(anAspect, subscriber);
		publisher.publish(aSubAspect);
		
		Assert.assertEquals(1, subscriber.getNumberOfUpdates());
		
		publisher.detach(anAspect, subscriber);
		publisher.publish(aSubAspect);
	
		Assert.assertEquals(1, subscriber.getNumberOfUpdates());		
	}
	
	@Test
	public void testMultipleAttachments() {
		
		
		subscriber.registerHandler(aspect, handler);
		publisher.publish(aspect);
		
		Assert.assertEquals(0, subscriber.getNumberOfUpdates());
		
		publisher.attach(aspect, subscriber);
		publisher.attach(aspect, subscriber);
		publisher.publish(aspect);
		
		Assert.assertEquals(2, subscriber.getNumberOfUpdates());
		
		publisher.detach(aspect, subscriber);
		publisher.publish(aspect);
	
		Assert.assertEquals(3, subscriber.getNumberOfUpdates());
		
		publisher.detach(aspect, subscriber);
		publisher.publish(aspect);
	
		Assert.assertEquals(3, subscriber.getNumberOfUpdates());
		
	}
}
