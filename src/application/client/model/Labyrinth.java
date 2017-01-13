package application.client.model;

import java.util.Random;

public class Labyrinth {

	private String[][] labyrinthData;
	private Random random = new Random();

	public Labyrinth() {
		super();
	}

	public String[][] getLabyrinthData() {
		return labyrinthData;
	}

	public void setLabyrinthData(String[][] labyrinthData) {
		this.labyrinthData = labyrinthData;
	}
}
