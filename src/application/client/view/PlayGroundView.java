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

public class PlayGroundView {
	private JButton loginButton;
	private JFrame playGroundFrame;
	private JTextArea gameLog;
	private JScrollPane scrollPane;
	private JScrollPane labyrinthScrollPane;
	private JTextField loginField;
	private LabyrinthPanel labyrinthPanel;
	private PlayerJoinControllerInterface playerJoinControllerInterface;
	private BombControllerInterface bombControllerinterface;
	
	public JButton getLoginButton() {
		return loginButton;
	}

	public LabyrinthPanel getLabyrinthPanel() {
		return labyrinthPanel;
	}

	public void setLabyrinthPanel(LabyrinthPanel labyrinthPanel) {
		this.labyrinthPanel = labyrinthPanel;
	}

	public PlayGroundView(PlayerJoinControllerInterface playerJoinControllerInterface, BombControllerInterface bombControllerinterface){
		super();
		this.playerJoinControllerInterface = playerJoinControllerInterface;
		this.bombControllerinterface = bombControllerinterface;
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
        
        
        loginButton = new JButton("Anmelden");
        loginButton.setBounds(450, 50, 200, 40);//x axis, y axis, width, height  
        loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				playerJoinControllerInterface.joinGame(loginField.getText());
			}
		});  
        
        loginField = new JTextField();
        loginField.setBounds(150, 50, 200, 40);//x axis, y axis, width, height  
        
        gameLog = new JTextArea();
        gameLog.setEditable(false);
        scrollPane = new JScrollPane(gameLog); 
        scrollPane.setBounds(0, 620, 800, 180);
        
        this.labyrinthPanel = new LabyrinthPanel(this, bombControllerinterface);
        
        labyrinthScrollPane = new JScrollPane(labyrinthPanel); 
        labyrinthScrollPane.setBounds(150, 100, 500, 500);
        
        playGroundFrame.add(labyrinthScrollPane);
        playGroundFrame.add(loginField);
        playGroundFrame.add(loginButton);
        playGroundFrame.add(scrollPane);

        playGroundFrame.setVisible(true);
        
    }
	
	public void update(){
		scrollPane.removeAll();
		scrollPane.add(gameLog);
		playGroundFrame.add(scrollPane);
		playGroundFrame.setVisible(true);
	}

	public JTextArea getGameLog() {
		return gameLog;
	}

	public void setGameLog(JTextArea gameLog) {
		this.gameLog = gameLog;
	}

	public JTextField getLoginField() {
		return loginField;
	}

	public void setLoginField(JTextField loginField) {
		this.loginField = loginField;
	}
}
