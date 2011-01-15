package org.bmnds.games.poker.stm;

public class GameState {
	TableState table;
	PlayerState player;
	
	public GameState() {
		this.table = TableState.HOLE;
		this.player = PlayerState.DRAWING;
	}
	
	public GameState(TableState table, PlayerState player) {
		this.table = table;
		this.player = player;
	}
	
	public TableState getTableState() {
		return table;
	}
	
	public void setTableState(TableState table) {
		this.table = table;
	}
	
	public PlayerState getPlayerState() {
		return player;
	}
	
	public void setPlayerState(PlayerState player) {
		this.player = player;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof GameState) {
			GameState game = (GameState) obj;
			return table.equals(game.getTableState()) &&
					player.equals(game.getPlayerState());
		}
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		return "{"+table+","+player+"}";
	}
}
