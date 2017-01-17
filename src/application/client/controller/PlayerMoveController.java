package application.client.controller;

import network.Message;
import network.client.ServerProxy;
import application.network.ServerProxyStub;

public class PlayerMoveController implements MessageReceiverInterface, PlayerMoveControllerInterface {

	private MessageHandler messageHandler;
	private ServerProxy serverProxy = new ServerProxyStub(messageHandler);

	public PlayerMoveController() {
		((MessageHandler) messageHandler).register(this);
	}
	
	@Override
	public void movePlayer(String playerName, String direction) {
		// TODO send

	}
	
	@Override
	public void playerMoved(String playerName, String direction) {
		// TODO handleMessage

	}

	@Override
	public void handleMessage(Message msg) {
		
	}
}
