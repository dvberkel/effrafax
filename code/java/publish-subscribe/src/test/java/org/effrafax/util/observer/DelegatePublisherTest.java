/**
 * 
 */
package org.effrafax.util.observer;

import org.effrafax.test.ExceptionInvoker;
import org.effrafax.test.ExceptionTester;
import org.effrafax.util.observer.implementations.AbstractPublicationAspect;
import org.effrafax.util.observer.implementations.AbstractPublisher;
import org.effrafax.util.observer.implementations.DelegatePublisher;
import org.effrafax.util.observer.interfaces.Publisher;
import org.junit.Test;


/**
 * @author dwanrooy
 *
 */
public class DelegatePublisherTest {

	@Test
	public void testAttachFailureFirstArgument() {
		
		ExceptionTester.testForException(
			IllegalArgumentException.class,
			new ExceptionInvoker() {

				@Override
				public void invoke() throws Exception {
					
					/* Notice the anonymous class instantiation */
					Publisher publisher = new DelegatePublisher(
						new AbstractPublisher() {}
					);
					
					publisher.attach(null, null);
				}				
			}
		);
	}

	@Test
	public void testAttachFailureSecondArgument() {
		
		ExceptionTester.testForException(
			IllegalArgumentException.class,
			new ExceptionInvoker() {

				@Override
				public void invoke() throws Exception {
					
					/* Notice the anonymous class instantiation */
					Publisher publisher = new DelegatePublisher(
						new AbstractPublisher() {}
					);
					
					publisher.attach(new AbstractPublicationAspect() {}, null);
				}				
			}
		);
	}

	@Test
	public void testDetachFailureFirstArgument() {
		
		ExceptionTester.testForException(
			IllegalArgumentException.class,
			new ExceptionInvoker() {

				@Override
				public void invoke() throws Exception {
					
					/* Notice the anonymous class instantiation */
					Publisher publisher = new DelegatePublisher(
						new AbstractPublisher() {}
					);
					
					publisher.detach(null, null);
				}				
			}
		);
	}

	@Test
	public void testDetachFailureSecondArgument() {
		
		ExceptionTester.testForException(
			IllegalArgumentException.class,
			new ExceptionInvoker() {

				@Override
				public void invoke() throws Exception {
					
					/* Notice the anonymous class instantiation */
					Publisher publisher = new DelegatePublisher(
						new AbstractPublisher() {}
					);
					
					publisher.detach(new AbstractPublicationAspect() {}, null);
				}				
			}
		);
	}
	
	@Test
	public void testPublishFailure() {
		
		ExceptionTester.testForException(
			IllegalArgumentException.class,
			new ExceptionInvoker() {

				@Override
				public void invoke() throws Exception {
					
					/* Notice the anonymous class instantiation */
					Publisher publisher = new DelegatePublisher(
						new AbstractPublisher() {}
					);
					
					publisher.publish(null);
				}				
			}
		);
	}

}
