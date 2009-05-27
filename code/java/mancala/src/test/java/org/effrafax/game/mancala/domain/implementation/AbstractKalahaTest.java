/**
 * 
 */
package org.effrafax.game.mancala.domain.implementation;

import static org.junit.Assert.*;

import org.effrafax.game.mancala.domain.Heap;
import org.effrafax.game.mancala.domain.Player;
import org.junit.Test;


/**
 * @author dwanrooy
 *
 */
public class AbstractKalahaTest {
	
	@Test
	public void testUnimplementedFailure() {
		
		AbstractKalaha kalaha = new MockKalaha(Player.white,4);
		
		try {
			
			kalaha.captureHeap();
			fail();
		} catch (IllegalStateException ise) {
			
			/* This is the expected behavior. */
		}
		
		try {
			
			kalaha.getOppositeBowl();
			fail();
		} catch (IllegalStateException ise) {
			
			/* This is the expected behavior. */
		}
	}
}

class MockKalaha extends AbstractKalaha {

	public MockKalaha(Player owner) {
		
		super(owner);
	}

	public MockKalaha(Player owner, int numberOfStones) {
		
		super(owner, numberOfStones);
	}

	@Override
	public void receiveHeap(Heap heap) {
		
		/* This method is not tested so no implementation is given. */
		
	}
}
