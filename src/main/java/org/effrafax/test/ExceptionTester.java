package org.effrafax.test;

import java.lang.Exception;

import static junit.framework.Assert.fail;
import static junit.framework.Assert.assertTrue;

public class ExceptionTester {
	
	public static void testForException(
		Class<?> exceptionClass, 
		ExceptionInvoker invoker
	) {
		
		if (exceptionClass == null) {
			
			throw new IllegalArgumentException("exceptionClass should not be null");
		}
		if (invoker == null) {
			
			throw new IllegalArgumentException("invoker should not be null");
		}
		
		try {
			
			invoker.invoke();
			fail();
		} catch (Exception e) {
			
			assertTrue(e.getClass().equals(exceptionClass));
		}		
	}
}
