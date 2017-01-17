package application.client.controller;

public interface GameControllerInterface {

    public void playerHit(String playerName);

    public void update(String[][] labyrinth);

    public void gameOver(String winnerName, String[] highscooreList);
}
