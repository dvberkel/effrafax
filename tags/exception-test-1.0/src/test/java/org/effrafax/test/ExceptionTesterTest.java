/**
 * 
 */
package org.effrafax.test;

import static junit.framework.Assert.fail;

import junit.framework.AssertionFailedError;

import org.junit.Test;

/**
 * @author dwanrooy
 *
 */
public class ExceptionTesterTest {
	
	@Test
	public void positiveTest() {
		
		ExceptionTester.testForException(
			IllegalArgumentException.class, 
			new ExceptionInvoker() {

				@Override
				public void invoke() throws Exception {
					
					throw new IllegalArgumentException();					
				}				
			}
		);
	}
	
	@Test
	public void negativeTest() {
		
		try {
			ExceptionTester.testForException(
				IllegalStateException.class, 
				new ExceptionInvoker() {
	
					@Override
					public void invoke() throws Exception {
						
						throw new IllegalArgumentException();					
					}				
				}
			);
			fail();
		} catch(AssertionFailedError afe) {
			
			/*
			 * The above try block should fail with an AssertionFailedError. 
			 */
		}
	}
	
	@Test
	public void testSelfFirstArgument() {
		
		ExceptionTester.testForException(
			IllegalArgumentException.class, 
			new ExceptionInvoker() {

				@Override
				public void invoke() throws Exception {
					
					ExceptionTester.testForException(null, null);					
				}				
			}
		);
	}
	
	@Test
	public void testSecondFirstArgument() {
		
		ExceptionTester.testForException(
			IllegalArgumentException.class, 
			new ExceptionInvoker() {

				@Override
				public void invoke() throws Exception {
					
					ExceptionTester.testForException(
						IllegalStateException.class, 
						null
					);					
				}				
			}
		);
	}
}
