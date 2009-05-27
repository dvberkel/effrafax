/**
 * 
 */
package org.effrafax.game.mancala.domain.implementation;

import org.effrafax.game.mancala.domain.Heap;
import org.effrafax.game.mancala.domain.Player;

/**
 * This class represent a kalaha following the standard rule set.
 * 
 * @author dwanrooy
 *
 */
public class StandardKalaha extends AbstractKalaha {
	
	public StandardKalaha(Player owner) {
		
		super(owner);
	}
	
	public StandardKalaha(Player owner, int numberOfStones) {

		super(owner, numberOfStones);
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.implementation.AbstractKalaha#receiveHeap(org.effrafax.game.mancala.domain.Heap)
	 */
	@Override
	public void receiveHeap(Heap heap) {
		
		assert(heap.countStones() > 0);
		
		if (getOwner().equals(heap.getOwner())) {
			
			heap.removeStone();
			getHeap().addStone();
		}
		
		if (heap.countStones() > 0) {
			
			getNextBowl().receiveHeap(heap);
		}
	}	
}