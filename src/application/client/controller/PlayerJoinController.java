package application.client.controller;

import application.client.view.PlayGroundView;
import application.network.JoinGameMessage;
import application.network.PlayerJoinedMessage;
import application.network.ServerProxyStub;
import network.Message;
import network.client.ClientApplicationInterface;
import network.client.ServerProxy;

public class PlayerJoinController implements MessageReceiverInterface, PlayerJoinControllerInterface{
	
	private ClientApplicationInterface messageHandler = new MessageHandler();
	private ServerProxy serverProxy = new ServerProxyStub(messageHandler);
	PlayGroundView playGroundView;

	public PlayerJoinController() {
		((MessageHandler) messageHandler).register(this);
		playGroundView = new PlayGroundView(this);
	}
	
	@Override
	public void joinGame(String playerName) {
		Message joinGameMessage = new JoinGameMessage(playerName);
		serverProxy.send(joinGameMessage);
	}
	
	@Override
	public void playerJoined(String otherPlayerName, int positionX, int positionY) {
		playGroundView.getGameLog().setText(playGroundView.getGameLog().getText()+ "User "+ otherPlayerName  +" has joined Game \n");
		playGroundView.update();
	}
	
	@Override
	public void startGame(String[][] labyrinth) { 
		// TODO handleMessage

	}
	
	@Override
	public void error(String errorMsg) { 
		// TODO handleMessage

	}

	@Override
	public void handleMessage(Message msg) {
		if (msg instanceof PlayerJoinedMessage){
			PlayerJoinedMessage playerJoinedMsg = (PlayerJoinedMessage) msg;
			playerJoined(playerJoinedMsg.getPlayerName(), playerJoinedMsg.getPositionX(), playerJoinedMsg.getPositionY());
		}
		
	}
}
