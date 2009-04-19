package org.effrafax.util.observer;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import org.junit.Test;

import org.effrafax.util.observer.interfaces.PublicationAspect;
import org.effrafax.util.observer.implementations.AbstractPublicationAspect;

public class AbstractPublicationAspectTest {
	
	@Test
	public void testAbstractAspect() {
		
		/* Notice the anonymous class instantiation */
		PublicationAspect publicationAspect = new AbstractPublicationAspect() {};
		
		assertNull(publicationAspect.getSuperAspect());
	}
	
	@Test
	public void testAspect() {
		
		PublicationAspect anAspect = new AnAspect();
		
		assertNull(anAspect.getSuperAspect());
	}
	
	@Test
	public void testSubAspect() {
		
		PublicationAspect aSubAspect = new ASubAspect();
		
		assertNotNull(aSubAspect.getSuperAspect());
	}
	
	@Test
	public void testSuperAspectIdentity() {
		
		PublicationAspect aSubAspect = new ASubAspect();
		PublicationAspect superAspect = aSubAspect.getSuperAspect();
		
		assertTrue(superAspect == aSubAspect.getSuperAspect());	
	}
	
	private class AnAspect extends AbstractPublicationAspect 
		implements PublicationAspect 
	{
		
		/* Mock implementation of the PublicationAspect interface */
	}
	
	private class ASubAspect extends AnAspect implements PublicationAspect {
		
		/* Mock implementation of the PublicationAspect interface */
	}
}
