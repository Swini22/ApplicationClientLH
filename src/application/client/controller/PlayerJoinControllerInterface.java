package application.client.controller;

public interface PlayerJoinControllerInterface {
	
	public void joinGame(String playerName);
	
	public void playerJoined(String otherPlayerName, int positionX, int positionY);
	
	public void startGame(String[][] labyrinth);
	
	public void error(String errorMsg);
}
