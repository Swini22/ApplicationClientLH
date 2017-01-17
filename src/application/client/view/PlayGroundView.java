package application.client.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import application.client.controller.BombControllerInterface;
import application.client.controller.PlayerJoinControllerInterface;
import application.client.controller.PlayerMoveControllerInterface;
import application.client.model.Player;

public class PlayGroundView {
	private JButton loginButton;
	private JFrame playGroundFrame;
	private JTextArea gameLog;
	private JScrollPane scrollPane;
	private JScrollPane labyrinthScrollPane;
	private JTextField loginField;
	private LabyrinthPanel labyrinthPanel;
	private PlayerJoinControllerInterface playerJoinController;
	private BombControllerInterface bombControllerinterface;
	private PlayerMoveControllerInterface playerMoveController;
	
	public JButton getLoginButton() {
		return loginButton;
	}

	public LabyrinthPanel getLabyrinthPanel() {
		return labyrinthPanel;
	}

	public void setLabyrinthPanel(LabyrinthPanel labyrinthPanel) {
		this.labyrinthPanel = labyrinthPanel;
	}

	public PlayGroundView(PlayerJoinControllerInterface playerJoinController, BombControllerInterface bombControllerinterface, PlayerMoveControllerInterface playerMoveController){
		super();
		this.playerJoinController = playerJoinController;
		this.bombControllerinterface = bombControllerinterface;
		this.playerMoveController = playerMoveController;
		initializeGUI();
	}
	
	private void initializeGUI() {
		playGroundFrame = new JFrame();
		playGroundFrame.setTitle("Bomberman");
		playGroundFrame.setSize(800, 800);
		playGroundFrame.setLocationRelativeTo(null);
		playGroundFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playGroundFrame.setResizable(false);
		playGroundFrame.setLayout(null);
        
        createLoginArea();
        createGameLog();
        createLabyrinthPanel();
        
        playGroundFrame.add(labyrinthScrollPane);
        playGroundFrame.add(loginField);
        playGroundFrame.add(loginButton);
        playGroundFrame.add(scrollPane);

        playGroundFrame.setVisible(true);
    }

	private void createLabyrinthPanel() {
		labyrinthPanel = new LabyrinthPanel(this, bombControllerinterface, playerMoveController);
        
        labyrinthScrollPane = new JScrollPane(labyrinthPanel); 
        labyrinthScrollPane.setBounds(150, 100, 500, 500);
	}

	private void createLoginArea() {
		loginButton = new JButton("Anmelden");
		loginButton.setBounds(450, 50, 200, 40);//x axis, y axis, width, height  
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				playerJoinController.joinGame(loginField.getText());
			}
		});  
		
		loginField = new JTextField();
		loginField.setBounds(150, 50, 200, 40);//x axis, y axis, width, height  
	}
	
	private void createGameLog() {
		gameLog = new JTextArea();
        gameLog.setEditable(false);
        scrollPane = new JScrollPane(gameLog); 
        scrollPane.setBounds(0, 620, 800, 180);
	}

	public void update(){
		scrollPane.removeAll();
		scrollPane.add(gameLog);
		playGroundFrame.add(scrollPane);
		playGroundFrame.setVisible(true);
	}

	public void setNewPlayer(Player player) {
		gameLog.setText(gameLog.getText()+ "User "+ player.getPlayerName()+" has joined Game \n");
		update();
		loginField.setEditable(false);
		loginButton.setEnabled(false);
	}

	public JTextField getLoginField() {
		return loginField;
	}

	public JTextArea getGameLog() {
		return gameLog;
	}

	public void setGameLog(JTextArea gameLog) {
		this.gameLog = gameLog;
	}
	
}

