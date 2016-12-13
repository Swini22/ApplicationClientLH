package application.client.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import application.client.controller.PlayerJoinControllerInterface;

public class PlayGroundView {
    JButton loginButton;
    JFrame playGroundFrame;
    JTextArea gameLog;
    PlayGroundView playGroundView;
    JScrollPane scrollPane;
    JTextField loginField;
    JPanel labyrinthView;
    JPanel labyrinthPanel;
    GridLayout gridLayout;
    PlayerJoinControllerInterface playerJoinControllerInterface;

    public PlayGroundView(PlayerJoinControllerInterface playerJoinControllerInterface) {
        super();
        this.playerJoinControllerInterface = playerJoinControllerInterface;
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
        playGroundFrame.setResizable(false);


        loginButton = new JButton("Anmelden");
        loginButton.setBounds(10, 10, 150, 30);//x axis, y axis, width, height
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerJoinControllerInterface.joinGame(loginField.getText());
            }
        });

        loginField = new JTextField();
        loginField.setBounds(175, 10, 150, 30);//x axis, y axis, width, height

        gameLog = new JTextArea();
        gameLog.setEditable(false);
        scrollPane = new JScrollPane(gameLog);
        scrollPane.setBounds(0, 600, 800, 200);

        labyrinthView = new JPanel();
        labyrinthView.setBounds(10, 10, 10,10);
        labyrinthView.add(labyrinthPanel = new LabyrinthPanel());

        playGroundFrame.add(loginField);
        playGroundFrame.add(loginButton);
        playGroundFrame.add(scrollPane);
        playGroundFrame.add(labyrinthView);

        playGroundFrame.setVisible(true);

    }

    public void update() {
        scrollPane.removeAll();
        scrollPane.add(gameLog);
        playGroundFrame.add(loginButton);
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
