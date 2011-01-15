package org.bmnds.games.poker.stm;

import static org.junit.Assert.*;
import static org.bmnds.games.poker.stm.TableState.*;
import static org.bmnds.games.poker.stm.PlayerState.*;

import org.junit.Test;

public class SimpleSTMTest {

	@Test
	public void testInitStateTransition() {
		GameState game;
		SimpleSTM stm;
		
		game = new GameState(INIT, DRAWING);
		stm = new SimpleSTM(game);
		assertEquals(new GameState(INIT, DRAWING), stm.getGameState());
		stm.changeState();
		assertEquals(new GameState(HOLE, DRAWING), stm.getGameState());
		
		game = new GameState(INIT, BETTING);
		stm = new SimpleSTM(game);
		assertEquals(new GameState(INIT, BETTING), stm.getGameState());
		stm.changeState();
		assertEquals(new GameState(HOLE, DRAWING), stm.getGameState());
	}

	@Test
	public void testHoleStateTransition() {
		GameState game;
		SimpleSTM stm;
		
		game = new GameState(HOLE, DRAWING);
		stm = new SimpleSTM(game);
		assertEquals(new GameState(HOLE, DRAWING), stm.getGameState());
		stm.changeState();
		assertEquals(new GameState(HOLE, BETTING), stm.getGameState());
		
		game = new GameState(HOLE, BETTING);
		stm = new SimpleSTM(game);
		assertEquals(new GameState(HOLE, BETTING), stm.getGameState());
		stm.changeState();
		assertEquals(new GameState(FLOP, DRAWING), stm.getGameState());
	}

	@Test
	public void testFlopStateTransition() {
		GameState game;
		SimpleSTM stm;
		
		game = new GameState(FLOP, DRAWING);
		stm = new SimpleSTM(game);
		assertEquals(new GameState(FLOP, DRAWING), stm.getGameState());
		stm.changeState();
		assertEquals(new GameState(FLOP, BETTING), stm.getGameState());
		
		game = new GameState(FLOP, BETTING);
		stm = new SimpleSTM(game);
		assertEquals(new GameState(FLOP, BETTING), stm.getGameState());
		stm.changeState();
		assertEquals(new GameState(TURN, DRAWING), stm.getGameState());
	}

	@Test
	public void testTurnStateTransition() {
		GameState game;
		SimpleSTM stm;
		
		game = new GameState(TURN, DRAWING);
		stm = new SimpleSTM(game);
		assertEquals(new GameState(TURN, DRAWING), stm.getGameState());
		stm.changeState();
		assertEquals(new GameState(TURN, BETTING), stm.getGameState());
		
		game = new GameState(TURN, BETTING);
		stm = new SimpleSTM(game);
		assertEquals(new GameState(TURN, BETTING), stm.getGameState());
		stm.changeState();
		assertEquals(new GameState(RIVER, DRAWING), stm.getGameState());
	}
	
	@Test
	public void testRiverStateTransition() {
		GameState game;
		SimpleSTM stm;
		
		game = new GameState(RIVER, DRAWING);
		stm = new SimpleSTM(game);
		assertEquals(new GameState(RIVER, DRAWING), stm.getGameState());
		stm.changeState();
		assertEquals(new GameState(RIVER, BETTING), stm.getGameState());
		
		game = new GameState(RIVER, BETTING);
		stm = new SimpleSTM(game);
		assertEquals(new GameState(RIVER, BETTING), stm.getGameState());
		stm.changeState();
		assertEquals(new GameState(SHOWDOWN, BETTING), stm.getGameState());
	}

	@Test
	public void testShowdownStateTransition() {
		GameState game;
		SimpleSTM stm;
		
		game = new GameState(SHOWDOWN, DRAWING);
		stm = new SimpleSTM(game);
		assertEquals(new GameState(SHOWDOWN, DRAWING), stm.getGameState());
		stm.changeState();
		assertEquals(new GameState(INIT, DRAWING), stm.getGameState());
		
		game = new GameState(SHOWDOWN, BETTING);
		stm = new SimpleSTM(game);
		assertEquals(new GameState(SHOWDOWN, BETTING), stm.getGameState());
		stm.changeState();
		assertEquals(new GameState(INIT, BETTING), stm.getGameState());
	}

}
