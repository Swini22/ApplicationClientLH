package application.client.controller;

import network.Message;
import network.client.ServerProxy;
import application.network.ServerProxyStub;

public class GameController implements MessageReceiverInterface {

	private MessageHandler messageHandler;
	private ServerProxy serverProxy = new ServerProxyStub(messageHandler);

	public GameController() {
		
	}
	
	public void playerHit(String playerName) {
		// TODO handleMessage

	}
	
	public void update(String[][] labyrinth) {
		// TODO handleMessage

	}
	
	public void gameOver(String winnerName, String[] highscooreList) {
		// TODO handleMessage

	}

	@Override
	public void handleMessage(Message msg) {
		// TODO Auto-generated method stub
		
	}
}
