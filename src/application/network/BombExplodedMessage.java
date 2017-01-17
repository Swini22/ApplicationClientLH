package application.network;

import network.Message;

public class BombExplodedMessage implements Message {

	//TODO statische id entfernen!
	private int id=1;

	public BombExplodedMessage(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
