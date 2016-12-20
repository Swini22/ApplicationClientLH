package application.network;

import network.Message;
import network.client.ClientApplicationInterface;
import network.client.ServerProxy;

public class ServerProxyStub extends ServerProxy {
	
	ClientApplicationInterface clientApplication;

	public ServerProxyStub(ClientApplicationInterface clientApplication) {
		super(clientApplication);
		this.clientApplication = clientApplication;
	}

	@Override
	public void send(Message message) {
		if (message instanceof JoinGameMessage){
			PlayerJoinedMessage playerJoinMessage = new PlayerJoinedMessage(((JoinGameMessage) message).getPlayerName(), 0, 0);
			clientApplication.handleMessage(playerJoinMessage);
		}
		if (message instanceof DropBombMessage){
			BombDroppedMessage bombDroppedMessage = new BombDroppedMessage(1, 0, 0);
			clientApplication.handleMessage(bombDroppedMessage);
		}
	}

}
