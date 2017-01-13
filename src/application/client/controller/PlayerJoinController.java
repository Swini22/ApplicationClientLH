package application.client.controller;

import application.client.view.PlayGroundView;
import application.network.JoinGameMessage;
import application.network.PlayerJoinedMessage;
import application.network.ServerProxyStub;
import application.network.StartGameMessage;
import network.Message;
import network.client.ClientApplicationInterface;
import network.client.ServerProxy;

public class PlayerJoinController implements MessageReceiverInterface, PlayerJoinControllerInterface{
	
	private ClientApplicationInterface messageHandler = new MessageHandler();
	private ServerProxy serverProxy = new ServerProxyStub(messageHandler);
	private PlayGroundView playGroundView;

	public PlayerJoinController() {
		((MessageHandler) messageHandler).register(this);
		BombControllerInterface bombController = new BombController();
		playGroundView = new PlayGroundView(this, bombController);
		bombController.setPlayGroundView(playGroundView);
	}
	
	@Override
	public void joinGame(String playerName) {
		//send
		Message joinGameMessage = new JoinGameMessage(playerName);
		serverProxy.send(joinGameMessage);
	}
	
	@Override
	public void playerJoined(String otherPlayerName, int positionX, int positionY) {
		//handleMessage
		playGroundView.getGameLog().setText(playGroundView.getGameLog().getText()+ "User "+ otherPlayerName  +" has joined Game \n");
		playGroundView.update();
		playGroundView.getLoginField().setEditable(false);
		playGroundView.getLoginButton().setEnabled(false);

		Message startGameMessage = new StartGameMessage();
		serverProxy.send(startGameMessage);
	}
	
	@Override
	public void startGame(String[][] labyrinth) {
		//handleMessage
		playGroundView.getLabyrinthPanel().update(labyrinth);
		playGroundView.update();
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
		if (msg instanceof StartGameMessage){
			StartGameMessage startGameMessage = (StartGameMessage) msg;
			startGame(startGameMessage.getLabyrinthData());
		}
	}
}
