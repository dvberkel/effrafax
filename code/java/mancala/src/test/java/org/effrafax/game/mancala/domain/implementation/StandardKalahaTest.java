/**
 * 
 */
package org.effrafax.game.mancala.domain.implementation;

import static org.junit.Assert.*;

import org.effrafax.game.mancala.domain.Bowl;
import org.effrafax.game.mancala.domain.Heap;
import org.effrafax.game.mancala.domain.Kalaha;
import org.effrafax.game.mancala.domain.Player;
import org.junit.Test;


/**
 * @author dwanrooy
 *
 */
public class StandardKalahaTest {
	
	@Test
	public void testReceiveHeap() {
		
		Kalaha kalaha = new StandardKalaha(Player.white);
		
		Heap heap = new Heap(Player.white,1);

		kalaha.receiveHeap(heap);
		assertEquals(1,kalaha.countStones());

		Bowl bowl = new AbstractBowl(Player.black, 1) {

			@Override
			public void receiveHeap(Heap heap) {
				
				heap.removeStone();
				getHeap().addStone();
			}			
		};
		kalaha.setNextBowl(bowl);
		
		heap = new Heap(Player.black,1);

		kalaha.receiveHeap(heap);
		assertEquals(1,kalaha.countStones());
		assertEquals(2,bowl.countStones());	
	}
}
