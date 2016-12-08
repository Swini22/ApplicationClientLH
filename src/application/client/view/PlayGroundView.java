package application.client.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import application.client.controller.Command;
import application.client.controller.LoginCommand;

public class PlayGroundView {
	JButton loginButton;
	JFrame playGroundFrame;
	JTextArea gameLog;
	PlayGroundView playGroundView;
	JScrollPane scrollPane;
	JTextField loginField;
	
	public PlayGroundView(){
		super();
		playGroundView = this;
		initializeGUI();
	}
	
	private void initializeGUI() {
		playGroundFrame = new JFrame();
		playGroundFrame.setTitle("Bomberman");
		playGroundFrame.setSize(800, 800);
		playGroundFrame.setLocationRelativeTo(null);
		playGroundFrame.setDefaultCloseOperation(playGroundFrame.EXIT_ON_CLOSE);
		playGroundFrame.setLayout(null);
        
        
        loginButton = new JButton("Anmelden");
        loginButton.setBounds(50, 100, 150, 50);//x axis, y axis, width, height  
        loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Command loginCommand = new LoginCommand(playGroundView);
				loginCommand.doCommand();
			}
		});  
        
        loginField = new JTextField();
        loginField.setBounds(250, 100, 150, 50);//x axis, y axis, width, height  
        
        gameLog = new JTextArea();
        gameLog.setEditable(false);
        scrollPane = new JScrollPane(gameLog); 
        scrollPane.setBounds(0, 600, 800, 200);
        
        playGroundFrame.add(loginField);
        playGroundFrame.add(loginButton);
        playGroundFrame.add(scrollPane);

        playGroundFrame.setVisible(true);
        
    }
	
	public void updatePlayGroundView(){
		scrollPane.removeAll();
		scrollPane.add(gameLog);
		playGroundFrame.add(loginButton);
		playGroundFrame.add(scrollPane);
		playGroundFrame.setVisible(true);
	}

	public JButton getAnmeldenButton() {
		return loginButton;
	}

	public JTextArea getGameLog() {
		return gameLog;
	}
	
	public JTextField getLoginField() {
		return loginField;
	}



	
}
