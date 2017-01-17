package application.client.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import application.client.controller.BombControllerInterface;
import application.client.model.Bomb;

@SuppressWarnings("serial")
public class LabyrinthPanel extends JPanel{
	
	private LabyrinthPanel labyrinthPanel;
	private BombControllerInterface bombController;
	private PlayGroundView playGroundView;
	private String[][] labyrinthData;
	
	public LabyrinthPanel(PlayGroundView playGroundView, BombControllerInterface bombController){
		super();
		this.playGroundView = playGroundView;
		this.bombController = bombController;
		labyrinthPanel = this;
		initializeGUI();
	}
	
	private void initializeGUI() {
		labyrinthPanel.setSize(600, 600);
		
		GridLayout grid = new GridLayout(13, 13);
		labyrinthPanel.setLayout(grid);

		addKeyListener();

		labyrinthPanel.setFocusable(true);
		labyrinthPanel.requestFocusInWindow();
	}

	private void addKeyListener() {
		labyrinthPanel.addKeyListener(new KeyListener() 
		{
             @Override
             public void keyTyped(KeyEvent e) {}

             @Override
             public void keyReleased(KeyEvent e) {}

             @Override
             public void keyPressed(KeyEvent e) {
            	 if(e.getKeyCode()==KeyEvent.VK_SPACE){
            		 bombController.dropBomb(playGroundView.getLoginField().getText(), 0, 0);
                }

             }
         });
	}
	
    private void createGrid(String[][] data) {
    	labyrinthData = data;
		for (String[] row : data){
			for (String cell : row){
				JLabel jLabel = new JLabel("", SwingConstants.CENTER);
				switch (cell) {
				case "SB":
					jLabel.setBackground(new Color(32, 32, 32));//Darkgray
					break;
				case "NB":
					jLabel.setBackground(new Color(125, 128, 128));//gray
					break;
				case "PL":
					jLabel.setText("☺");
					jLabel.setBackground(new Color(70, 178, 66));//green
					break;
				case "BO":
					jLabel.setText("☠");
				default:
					jLabel.setBackground(new Color(70, 178, 66));//green
					break;
				}
				jLabel.setFont(jLabel.getFont().deriveFont(24f));
				jLabel.setOpaque(true);
				jLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				this.add(jLabel);
			}
		}
	}
    
	public void update(String[][] labyrinth){
		labyrinthPanel.removeAll();
		GridLayout grid = new GridLayout(13, 13);
		labyrinthPanel.setLayout(grid);
		createGrid(labyrinth);

		labyrinthPanel.setVisible(true);
	}

	public void setBomb(Bomb bomb) {
		labyrinthData[bomb.getPositionX()][bomb.getPositionY()] = "BO";
		update(labyrinthData);
		playGroundView.getGameLog().setText(playGroundView.getGameLog().getText()+ "Bomb " +bomb.getId()+" Dropt! \n");
	}
}
