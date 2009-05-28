/**
 * 
 */
package org.effrafax.game.mancala.domain.implementation;

import org.effrafax.game.mancala.domain.Bowl;
import org.effrafax.game.mancala.domain.Heap;
import org.effrafax.game.mancala.domain.Kalaha;
import org.effrafax.game.mancala.domain.Player;

/**
 * This abstract class provides a almost complete implementation of the {@code Bowl}
 * interface.
 * @author dwanrooy
 *
 */
public abstract class AbstractBowl implements Bowl {
	
	private static final String EXCEPTION_BOWLASSIGNED = 
		"this bowl is already assigned.";
	private static final String EXCEPTION_BOWLNULL = 
		"this bowl should be non-null.";
	private static final String EXCEPTION_OWNERASSIGNED = 
		"the owner is already assigned.";
	private static final String EXCEPTION_OWNERNULL = 
		"owner should be non-null.";
	
	private Heap heap = null;
	private Player owner = null;
	private Bowl nextBowl = null;
	private Bowl oppositeBowl = null;
	
	public AbstractBowl() {
		
		/* This constructor is provided for the serviceloader. */
	}
	
	public AbstractBowl(Player owner) {
		
		this(owner, 0);
	}
	
	public AbstractBowl(Player owner, int numberOfStones) {
		
		initialize(owner, numberOfStones);
	}
	

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.Bowl#initialize(org.effrafax.game.mancala.domain.Player, int)
	 */
	@Override
	public void initialize(Player owner, int numberOfStones) {
		
		setOwner(owner);
		setHeap(new Heap(owner, numberOfStones));
	}
	
	/**
	 * Sets the owner of this {@code AbstractBowl}. An exception is thrown if
	 * the owner is already set or {@code owner} is null.
	 * 
	 * @param owner The {@code Player} who will own this {@code AbstractBowl}.
	 * @throws IllegalArgumentException if the {@code owner} is {@code null}.
	 * @throws IllegalStateException if the owner is already set.
	 */
	protected void setOwner(Player owner)
			throws IllegalArgumentException, IllegalStateException {
		
		if (owner == null) {
		
			throw new IllegalArgumentException(EXCEPTION_OWNERNULL);
		}
		if (this.owner != null) {
			
			throw new IllegalStateException(EXCEPTION_OWNERASSIGNED);
		}
		
		this.owner = owner;
	}
	
	/**
	 * Sets the heap of this {@code AbstractBowl}.
	 * 
	 * @param heap The {@code Heap} used to set this {@code AbstractBowl} with.
	 */
	protected void setHeap(Heap heap) {
		
		this.heap = heap;
	}
	
	/**
	 * Returns this {@code AbstractBowl}s {@code Heap}.
	 * 
	 * @return The {@code Heap} of this {@code AbstractBowl}.
	 */
	protected Heap getHeap() {
		
		return heap;
	}
	
	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.Bowl#captureHeap()
	 */
	@Override
	public Heap captureHeap() {
		
		Heap capturedHeap = heap;
		capturedHeap.changeOwner();
		
		heap = new Heap(getOwner());
		
		return capturedHeap;
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.Bowl#collectHeap(org.effrafax.game.mancala.domain.Heap)
	 */
	@Override
	public void collectHeap(Heap heap) {
		
		getNextBowl().collectHeap(heap);
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.Bowl#countStones()
	 */
	@Override
	public int countStones() {

		return heap.countStones();
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.Bowl#getKahala()
	 */
	@Override
	public Kalaha getKahala() {

		return getNextBowl().getKahala();
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.Bowl#getOwner()
	 */
	@Override
	public Player getOwner() {

		return owner;
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.Bowl#assignNextBowl()
	 */
	@Override
	public void setNextBowl(Bowl nextBowl) 
			throws IllegalArgumentException, IllegalStateException {
		
		if (nextBowl == null) {
			
			throw new IllegalArgumentException(EXCEPTION_BOWLNULL);
		}		
		if (this.nextBowl != null) {
			
			throw new IllegalStateException(EXCEPTION_BOWLASSIGNED);
		}
		
		this.nextBowl = nextBowl;
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.Bowl#getNextBowl()
	 */
	@Override
	public Bowl getNextBowl() {

		return nextBowl;
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.Bowl#getOppositeBowl()
	 */
	@Override
	public Bowl getOppositeBowl() {

		return oppositeBowl;
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.Bowl#setOppositeBowl(org.effrafax.game.mancala.domain.Bowl)
	 */
	@Override
	public void setOppositeBowl(Bowl oppositeBowl) 
			throws IllegalArgumentException, IllegalStateException {
		
		
		if (oppositeBowl == null) {
			
			throw new IllegalArgumentException(EXCEPTION_BOWLNULL);
		}		
		if (this.oppositeBowl != null) {
			
			throw new IllegalStateException(EXCEPTION_BOWLASSIGNED);
		}
		
		this.oppositeBowl = oppositeBowl;
	}

	/* (non-Javadoc)
	 * @see org.effrafax.game.mancala.domain.Bowl#play()
	 */
	@Override
	public boolean play() {
		
		Heap playingHeap = heap;
		heap = new Heap(owner,0);
		
		return getNextBowl().receiveHeap(playingHeap);
	}	
}
