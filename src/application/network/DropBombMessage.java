package application.network;

import network.Message;

public class DropBombMessage implements Message {
	
	private String playerName;
	private int positionX;
	private int positionY;
	
	public DropBombMessage(String playerName, int positionX, int positionY) {
		super();
		this.playerName = playerName;
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
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
