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
@SuppressWarnings("serial")
public class StandardKalaha extends AbstractKalaha {

	public StandardKalaha() {
		
		/* default constructor provided for the service loader */
	}


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
	public boolean receiveHeap(Heap heap) {
		
		assert(heap.countStones() > 0);
		
		if (getOwner().equals(heap.getOwner())) {
			
			heap.removeStone();
			getHeap().addStone();
		}
		
		if (heap.countStones() > 0) {
			
			return getNextBowl().receiveHeap(heap);
		}
		
		return true;
	}	
}
