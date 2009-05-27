/**
 * 
 */
package org.effrafax.game.mancala.domain.implementation;

import org.effrafax.game.mancala.domain.Bowl;
import org.effrafax.game.mancala.domain.Heap;
import org.effrafax.game.mancala.domain.Kalaha;
import org.effrafax.game.mancala.domain.Player;

/**
 * @author dwanrooy
 *
 */
public abstract class AbstractKalaha extends AbstractBowl implements Kalaha {
	
	private static final String EXCEPTION_NOSUCH = 
		"there is no such a thing for a kalaha.";
	
	public AbstractKalaha(Player owner) {
		
		this(owner, 0);
	}
	
	public AbstractKalaha(Player owner, int numberOfStones) {
		
		super(owner, numberOfStones);
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.implementation.AbstractBowl#captureHeap()
	 */
	@Override
	public Heap captureHeap() {
		
		throw new IllegalStateException(EXCEPTION_NOSUCH);
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.implementation.AbstractBowl#collectHeap(org.effrafax.game.mancala.domain.Heap)
	 */
	@Override
	public void collectHeap(Heap heap) {
		
		this.getHeap().addStone(heap);
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.implementation.AbstractBowl#getKahala()
	 */
	@Override
	public Kalaha getKahala() {

		return this;
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.implementation.AbstractBowl#getOppositeBowl()
	 */
	@Override
	public Bowl getOppositeBowl() {
		
		throw new IllegalStateException(EXCEPTION_NOSUCH);
	}
}
