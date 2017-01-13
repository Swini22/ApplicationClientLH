package application.network;

import java.util.Random;

import network.Message;

public class StartGameMessage implements Message {

	private String[][] labyrinthData;
	private Random random = new Random();

	public StartGameMessage() {
		super();
		labyrinthData = new String[13][13];
		
		for (int i = 0; i < 13 ; i++){			
			for (int j = 0; j < 13 ; j++){
				if (i%2 != 0 && j%2 != 0){
					labyrinthData[i][j] = "SB";
				}else{
					labyrinthData[i][j] = fillInTestData();
				}
			}
		}
			labyrinthData[0][0] = "PL";
			labyrinthData[0][12] = "PL";
			labyrinthData[12][0] = "PL";
			labyrinthData[12][12] = "PL";
	}

	public String[][] getLabyrinthData() {
		return labyrinthData;
	}
	
	private String fillInTestData(){
		String[] testData = {"NB","",};
		return testData[random.nextInt(testData.length)];
	}
}
