package org.effrafax.game.mancala.view.cli;

import java.util.Map;
import java.util.List;

import org.effrafax.game.mancala.Mancala;
import org.effrafax.game.mancala.MancalaBuilder;
import org.effrafax.game.mancala.domain.Player;

public class StartGame {
	
	private MancalaBuilder builder = new MancalaBuilder();
	private Mancala mancala = null;
	private boolean finished = false;
	
	public static void main(String[] args) {
		
		StartGame game = new StartGame();
		game.processArguments(args);
				
		while (! game.isFinished()) {
			
			game.showStatus();			
			game.finished();
		}
	}
	
	/**
	 * Fills the {@code MancalaBuilder} of this {@code StartGame} with options
	 * from to command line. Valid options are:
	 * <ul>
	 *	<li>player:white|black</li>
	 * 	<li>bowls:m</li>
	 * 	<li>stones:n</li>
	 * <ul>
	 * where m and n are positive integers.
	 *
	 * @param args A array of commandline options.
	 */
	private void processArguments(String[] args) {
		
		for (String argument : args) {
			
			String[] part = argument.toLowerCase().split(":");

			String option = part[0];			
			if (option.equals("player")) {
				
				try {
					
					Player player = Enum.valueOf(Player.class, part[1]);
					setStartPlayer(player);
				} catch (IllegalArgumentException iae) {
					
					System.out.println("player value should be white or black");
					finished();
					break;
				}			
			} else if (option.equals("bowls")) {
				
				try {
					
					int numberOfBowls = Integer.parseInt(part[1]);
					setNumberOfBowls(numberOfBowls);					
				} catch (NumberFormatException nfe) {
					
					System.out.println("bowls value should be a number");
					finished();
					break;
				} catch (IllegalArgumentException iae) {

					System.out.println("bowls value should be a positive number");
					finished();
					break;
				}
			} else if (option.equals("stones")) {
				
				try {
					
					int numberOfStones = Integer.parseInt(part[1]);
					setNumberOfStones(numberOfStones);					
				} catch (NumberFormatException nfe) {
					
					System.out.println("stones value should be a number");
					finished();
					break;
				} catch (IllegalArgumentException iae) {

					System.out.println("Stones value should be a positive number");
					finished();
					break;
				}
			} else {
				
				System.out.println("unrecognized argument: " + argument );
				finished();
				break;
			}
		}
	}
	
	/**
	 * Outputs a representation of the current status to the standard out.
	 */
	private void showStatus() {

		showCurrentPlayer();
		showBoard();
		showOptions();
	}
	
	/**
	 * Outputs the current {@code Player} to the standard out.
	 */
	private void showCurrentPlayer() {
		
		System.out.printf("Current player: %s%n%n", 
				getMancala().getCurrentPlayer()
		);
	}
	
	/**
	 * Outputs the current board to the standard out.
	 */
	private void showBoard() {
		
		Map<Player, List<Integer>> stonesPerPlayer = 
				getMancala().getStonesPerPlayer();
		
		int size = stonesPerPlayer.get(Player.white).size();
		
		System.out.printf("   (%9d)%n", 
				stonesPerPlayer.get(Player.black).get(size-1)
		);
		for (int index = 0; index < size - 1; index++) {
			
			/* 
			 * The reversed index. Counting backwards from the black players
			 * kalaha. 
			 */
			int xedni = size - 2 - index;
			
			String format;
			if (getMancala().getCurrentPlayer().equals(Player.white)) {
				
				format = "%3$2d [%-3d] [%3d]%n";
			} else {
				
				format = "   [%-3d] [%3d] %4$-2d%n";
			}
			
			System.out.printf(format,
					stonesPerPlayer.get(Player.white).get(index),
					stonesPerPlayer.get(Player.black).get(size - 2 - index),
					index,
					xedni
			);
		}
		System.out.printf("   (%-9d)%n%n", 
				stonesPerPlayer.get(Player.white).get(size-1)
		);
	}
	
	/**
	 * Outputs the playable options to the standard out.
	 */
	private void showOptions() {
		
		List<Integer> options = getMancala().options();
		
		System.out.println("Playable bowls are at the indices:");
		System.out.printf("%d", options.get(0));
		for (Integer index : options.subList(1, options.size())) {
			
			System.out.printf(", %d", index);
		}
		System.out.println(); /* Newline after the options. */
	}
		
	/**
	 * Returns if the game is finished occording to this {@code StartGame}.
	 *
	 * @return {@code true} if the game is finished, {@code false} otherwise.
	 */
	private boolean isFinished() {
		
		return finished;
	}
	
	/**
	 * Turns the {@code finished} flag for this {@code StartGame} up. The game
	 * is now finished according to this {@code StartGame}.
	 */
	private void finished() {
		
		this.finished = true;
	}
	
	/**
	 * Returns the {@code MancalaBuilder} of this {@code StartGame}.
	 *
	 * @return The {@code MancalaBuilder} of this {@code StartGame}.
	 */
	private MancalaBuilder getMancalaBuilder() {
		
		return builder;
	}
	
	/**
	 * Sets the start {@code Player} for this game.
	 */
	private void setStartPlayer(Player player) {
		
		getMancalaBuilder().setStartPlayer(player);
	}
	
	/**
	 * Sets the number of {@code Bowl}s for this game.
	 */
	private void setNumberOfBowls(int numberOfBowls) {
		
		getMancalaBuilder().setNumberOfBowls(numberOfBowls);
	}
	
	/**
	 * Sets the number of stones in each {@code Bowl} for this game.
	 */
	private void setNumberOfStones(int numberOfStones) {
		
		getMancalaBuilder().setNumberOfStones(numberOfStones);
	}
	
	/**
	 * Returns the {@code Mancala} which is governed by this {@code StartGame}.
	 * 
	 * @return The {@code Mancala} which is governed by this {@code StartGame}.
	 */
	private Mancala getMancala() {
		
		if (mancala == null) {
			
			mancala = new Mancala(getMancalaBuilder());
		}
		
		return mancala;
	}
}
