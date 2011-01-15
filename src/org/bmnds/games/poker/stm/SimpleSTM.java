package org.bmnds.games.poker.stm;

import static org.bmnds.games.poker.stm.PlayerState.*;
import static org.bmnds.games.poker.stm.TableState.*;

public class SimpleSTM {
	private GameState game;
	
	public SimpleSTM(GameState game) {
		this.game = game;
	}
	
	public void changeState() {
		switch (game.getTableState()) {
		case INIT:
			//TODO collect small and big blinds
			System.out.println("Collecting blind bets");
			//TODO collect blind bets
			game.setTableState(HOLE);
			game.setPlayerState(DRAWING);
			break;
		case HOLE:
			switch (game.getPlayerState()) {
			case DRAWING:
				System.out.println("Player in DRAWING - HOLE CARDS");
				//TODO give hole cards to all players
				game.setPlayerState(BETTING);
				break;
			case BETTING:
				System.out.println("Player in BETTING - HOLE CARDS");
				//TODO collect bets from all players
				game.setTableState(FLOP);
				game.setPlayerState(DRAWING);
				break;
			}
			break;
		case FLOP:
			System.out.println("Table in PREFLOP");
			switch (game.getPlayerState()) {
			case DRAWING:
				System.out.println("Player in DRAWING - FLOP CARDS");
				//TODO draw 3 community cards (FLOP)
				game.setPlayerState(BETTING);
				break;
			case BETTING:
				System.out.println("Player in BETTING - HOLE CARDS");
				//TODO collect bets from all players
				game.setTableState(TURN);
				game.setPlayerState(DRAWING);
				break;
			}
			break;
		case TURN:
			System.out.println("Table in PRETURN");
			switch (game.getPlayerState()) {
			case DRAWING:
				System.out.println("Player in DRAWING");
				//TODO draw 1 community card (TURN)
				game.setPlayerState(BETTING);
				break;
			case BETTING:
				System.out.println("Player in BETTING");
				//TODO collect bets from all players
				game.setTableState(RIVER);
				game.setPlayerState(DRAWING);
				break;
			}
			break;
		case RIVER:
			System.out.println("Table in PRERIVER");
			switch (game.getPlayerState()) {
			case DRAWING:
				System.out.println("Player in DRAWING");
				//TODO draw 1 community card (RIVER)
				game.setPlayerState(BETTING);
				break;
			case BETTING:
				System.out.println("Player in BETTING");
				//TODO collect bets from all players
				game.setTableState(SHOWDOWN);
				break;
			}
			break;
		case SHOWDOWN:
			System.out.println("Table in SHOWDOWN");
			//TODO evaluate all hands and declare the winner(s)
			game.setTableState(INIT);
			break;
		}
	}
	
	public GameState getGameState() {
		return game;
	}
}
