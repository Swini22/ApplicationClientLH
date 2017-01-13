package application.client.controller;

import application.client.model.Bomb;
import application.client.view.PlayGroundView;
import application.network.BombDroppedMessage;
import application.network.BombExplodedMessage;
import application.network.DropBombMessage;
import application.network.ServerProxyStub;
import network.Message;
import network.client.ClientApplicationInterface;
import network.client.ServerProxy;

public class BombController implements MessageReceiverInterface, BombControllerInterface{
	
	private ClientApplicationInterface messageHandler = new MessageHandler();
	private ServerProxy serverProxy = new ServerProxyStub(messageHandler);
	private PlayGroundView playGroundView;

	public BombController() {
		((MessageHandler) messageHandler).register(this);
	}
	
	@Override
	public void dropBomb(String playerName, int positionX, int positionY) {
		//send
		Message dropBombMessage = new DropBombMessage(playerName, positionX, positionY);
		serverProxy.send(dropBombMessage);
	}
	
	@Override
	public void bombDropped(int id, int positionX, int positionY) {
		Bomb bomb = new Bomb(id, positionX, positionY);
		playGroundView.getLabyrinthPanel().setBomb(bomb);
		playGroundView.update();
	}
	
	@Override
	public void bombExploded(int id) {
		// TODO handleMessage
	}

	@Override
	public void handleMessage(Message msg) {
		if (msg instanceof BombDroppedMessage){
			BombDroppedMessage bombDroppedMsg = (BombDroppedMessage) msg;
			bombDropped(bombDroppedMsg.getId(), bombDroppedMsg.getPositionX(), bombDroppedMsg.getPositionY());
		}
		if(msg instanceof BombExplodedMessage){
			BombExplodedMessage bombExplodeMsg = (BombExplodedMessage) msg;
			bombExploded(bombExplodeMsg.getId());
		}
	}

	@Override
	public void setPlayGroundView(PlayGroundView playGroundView) {
		this.playGroundView = playGroundView;
	}
}
 