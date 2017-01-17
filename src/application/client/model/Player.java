package application.client.model;

public class Player {

	private String playerName;
	private int positionX;
	private int positionY;
	
	public Player(String playerName, int positionX, int positionY) {
		this.playerName = playerName;
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
}
