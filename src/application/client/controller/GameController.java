package application.client.controller;

import network.Message;
import network.client.ServerProxy;
import application.network.ServerProxyStub;

public class GameController implements MessageReceiverInterface, GameControllerInterface {

    private MessageHandler messageHandler;
    private ServerProxy serverProxy = new ServerProxyStub(messageHandler);

    public GameController() {

    }

    @Override
    public void playerHit(String playerName) {
        // TODO handleMessage

    }

    @Override
    public void update(String[][] labyrinth) {
        // TODO handleMessage

    }

    @Override
    public void gameOver(String winnerName, String[] highscooreList) {
        // TODO handleMessage

    }

    @Override
    public void handleMessage(Message msg) {
        // TODO Auto-generated method stub

    }
}
