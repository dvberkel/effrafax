/**
 * 
 */
package org.effrafax.util.observer;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

import org.effrafax.util.observer.interfaces.PublicationAspect;
import org.effrafax.util.observer.mock.ADelegateSubAspect;
import org.effrafax.util.observer.mock.AnDelegateAspect;
import org.junit.Test;


/**
 * @author dwanrooy
 *
 */
public class DelegatePublicationAspectTest {
	
	
	@Test
	public void testAspect() {
		
		PublicationAspect anDelegateAspect = new AnDelegateAspect();
		
		assertNull(anDelegateAspect.getSuperAspect());
	}
	
	@Test
	public void testSubAspect() {
		
		PublicationAspect aDelegateSubAspect = new ADelegateSubAspect();
		
		assertNotNull(aDelegateSubAspect.getSuperAspect());
	}
	
	@Test
	public void testSuperAspectIdentity() {
		
		PublicationAspect aDelegateSubAspect = new ADelegateSubAspect();
		PublicationAspect superAspect = aDelegateSubAspect.getSuperAspect();
		
		assertTrue(superAspect == aDelegateSubAspect.getSuperAspect());	
	}
}
