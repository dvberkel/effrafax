/**
 * 
 */
package org.effrafax.util.observer;

import org.effrafax.test.ExceptionInvoker;
import org.effrafax.test.ExceptionTester;
import org.effrafax.util.observer.implementations.AbstractSubscriber;
import org.effrafax.util.observer.interfaces.PublicationAspect;
import org.effrafax.util.observer.interfaces.Publisher;
import org.effrafax.util.observer.interfaces.Subscriber;
import org.junit.Test;

/**
 * @author dwanrooy
 *
 */
public class AbstractSubscriberTest {
	
	@Test
	public void testHandlerRegistrationFailure() {
		
		ExceptionTester.testForException(
			IllegalArgumentException.class, 
			new ExceptionInvoker() {

				@Override
				public void invoke() throws Exception {
					
					/* Notice the anonymous class instantiation */
					Subscriber subscriber = new AbstractSubscriber() {};
					
					subscriber.registerHandler(null, null);
				}				
			}
		);
	}
	
	@Test
	public void testUpdateFailureFirstArgument() {
		
		ExceptionTester.testForException(
			IllegalArgumentException.class, 
			new ExceptionInvoker() {

				@Override
				public void invoke() throws Exception {
					
					/* Notice the anonymous class instantiation */
					Subscriber subscriber = new AbstractSubscriber() {};
					
					subscriber.update(
						null, 
						null
					);
				}				
			}
		);
	}
	
	@Test
	public void testUpdateFailureSecondArgument() {
		
		ExceptionTester.testForException(
			IllegalArgumentException.class, 
			new ExceptionInvoker() {

				@Override
				public void invoke() throws Exception {
					
					/* Notice the anonymous class instantiation */
					Subscriber subscriber = new AbstractSubscriber() {};
					
					subscriber.update(
						new Publisher() {

							@Override
							public void attach(
								PublicationAspect aspect,
								Subscriber subscriber
							) {
								
								/* This stub is for testing only */
							}

							@Override
							public void detach(
									PublicationAspect aspect,
									Subscriber subscriber
								) {
								
								/* This stub is for testing only */
							}

							@Override
							public void publish(PublicationAspect aspect) {
								
								/* This stub is for testing only */
							}
							
						}, 
						null
					);
				}				
			}
		);
	}
}
