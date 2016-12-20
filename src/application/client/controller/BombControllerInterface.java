package application.client.controller;

public interface BombControllerInterface {

	public void dropBomb(String playerName, int positionX, int positionY);
	
	public void bombDropped(int id, int positionX, int positionY);
	
	public void bombExploded(int id);
}
