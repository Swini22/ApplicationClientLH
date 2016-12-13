package application.client.controller;

public interface PlayerMoveControllerInterface {

	public void movePlayer(String playerName, String direction);
	
	public void playerMoved(String playerName, String direction);
}
