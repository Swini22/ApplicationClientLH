package application.client.controller;

import network.Message;
import network.client.ServerProxy;
import application.network.ServerProxyStub;

public class BombController implements MessageReceiverInterface, BombControllerInterface{
	private MessageHandler messageHandler;
	private ServerProxy serverProxy = new ServerProxyStub(messageHandler);

	public BombController() {
		((MessageHandler) messageHandler).register(this);
	}
	
	@Override
	public void dropBomb(String playerName, int positionX, int positionY) {
		// TODO send

	}
	
	@Override
	public void bombDropped(int id, int positionX, int positionY) {
		// TODO handleMessage

	}
	
	@Override
	public void bombExploded(int id) {
		// TODO handleMessage

	}

	@Override
	public void handleMessage(Message msg) {
		// TODO Auto-generated method stub
		
	}
}
 