package application.client.model;

public class Bomb {

	private int id;
	private int positionX;
	private int positionY;
	
	public Bomb(int id, int positionX, int positionY) {
		super();
		this.id = id;
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public int getId() {
		return id;
	}
	
	public int getPositionX() {
		return positionX;
	}
	
	public int getPositionY() {
		return positionY;
	}
}
