/**
 * 
 */
package org.effrafax.util.observer;

import junit.framework.Assert;

import org.effrafax.test.ExceptionInvoker;
import org.effrafax.test.ExceptionTester;
import org.effrafax.util.observer.interfaces.PublicationHandler;
import org.effrafax.util.observer.interfaces.Publisher;
import org.effrafax.util.observer.interfaces.Subscriber;
import org.effrafax.util.observer.mock.MockSubscriber;
import org.junit.Test;


/**
 * @author dwanrooy
 *
 */
public class PublicationHandlerChainTest {
	
	@Test
	public void testInstantiationFailure() {
		
		ExceptionTester.testForException(
			IllegalArgumentException.class, 
			new ExceptionInvoker() {

				@Override
				public void invoke() throws Exception {
					
					new PublicationHandlerChain(null);
				}
				
			}
		);
	}
	
	@Test
	public void testSetNextChainFailure() {
		
		PublicationHandler handler = new PublicationHandler() {

			@Override
			public void handlePublication(Publisher publisher,
					Subscriber subscriber) {
				
				/* 
				 * Do nothing. Do something. I don not care, it is not 
				 * important for this test. 
				 */
			}
			
		};
		final PublicationHandlerChain chain = new PublicationHandlerChain(handler);
		
		
		ExceptionTester.testForException(
			IllegalArgumentException.class, 
			new ExceptionInvoker() {

				@Override
				public void invoke() throws Exception {
					
					chain.setNextPublicationHandlerChain(null);
				}
				
			}
		);
	}
	
	@Test 
	public void testChaining() {
		
		PublicationHandler handler = new PublicationHandler() {

			@Override
			public void handlePublication(Publisher publisher,
					Subscriber subscriber) {
				
				((MockSubscriber) subscriber).incrementNumberOfUpdates();
			}
		};

		PublicationHandlerChain chain = new PublicationHandlerChain(handler);
		chain.addPublicationHandler(handler);
		
		MockSubscriber subscriber = new MockSubscriber();
		
		Assert.assertEquals(0, subscriber.getNumberOfUpdates());
		
		chain.handlePublication(null, subscriber);
		
		Assert.assertEquals(2, subscriber.getNumberOfUpdates());
	}
}
