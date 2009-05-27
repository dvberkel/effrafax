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
public class MockKalaha extends AbstractKalaha {
	
	public MockKalaha() {
		
		/* Parameterless constructor provided for the service loader */
	}
	
	public MockKalaha(Player owner) {

		super(owner);
	}

	public MockKalaha(Player owner, int numberOfStones) {

		super(owner, numberOfStones);
	}

	@Override
	public void receiveHeap(Heap heap) {

		/* This method is should not betested so no implementation is given. */

	}
}
