package application.network;

import network.Message;

public class BombDroppedMessage implements Message {
	
	private int id;
	private int positionX;
	private int positionY;
	
	
	public BombDroppedMessage(int id, int positionX, int positionY) {
		super();
		this.id = id;
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
