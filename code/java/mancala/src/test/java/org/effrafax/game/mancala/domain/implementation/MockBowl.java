/**
 * 
 */
package org.effrafax.game.mancala.domain.implementation;

import org.effrafax.game.mancala.domain.Heap;
import org.effrafax.game.mancala.domain.Player;

/**
 * @author dwanrooy
 *
 */
public class MockBowl extends AbstractBowl {

	public MockBowl() {
		
		/* Parameterless constructor provided for the service loader */		
	}
	
	public MockBowl(Player owner) {
		
		super(owner);
	}

	public MockBowl(Player owner, int numberOfStones) {

		super(owner,numberOfStones);
	}

	@Override
	public void receiveHeap(Heap heap) {
		
		/* This method is should not be tested so leave it out. */
	}
}
