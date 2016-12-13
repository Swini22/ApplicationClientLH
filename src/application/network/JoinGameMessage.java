package application.network;

import network.Message;

public class JoinGameMessage implements Message {

    private String playerName;

    public JoinGameMessage(String playerName) {
        super();
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
