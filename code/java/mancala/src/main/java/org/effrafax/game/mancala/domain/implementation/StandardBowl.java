/**
 * 
 */
package org.effrafax.game.mancala.domain.implementation;

import org.effrafax.game.mancala.domain.Heap;
import org.effrafax.game.mancala.domain.Player;

/**
 * This class represent a bowl following the standard rule set.
 * 
 * @author dwanrooy
 *
 */
public class StandardBowl extends AbstractBowl {

	public StandardBowl(Player owner) {

		super(owner);
	}

	public StandardBowl(Player owner, int numberOfStones) {

		super(owner, numberOfStones);
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.implementation.AbstractBowl#receiveHeap(org.effrafax.game.mancala.domain.Heap)
	 */
	@Override
	public boolean receiveHeap(Heap heap) {
		
		assert(heap.countStones() > 0);
		
		heap.removeStone();
		getHeap().addStone();
		
		if (heap.countStones() > 0) {
			
			return getNextBowl().receiveHeap(heap);
		} else {
			
			if (this.countStones() == 1) {
				
				Heap capturedHeap = getOppositeBowl().captureHeap();
				capturedHeap.addStone(getHeap());
				
				collectHeap(capturedHeap);
			}
		}
		
		return false;
	}
	
}
