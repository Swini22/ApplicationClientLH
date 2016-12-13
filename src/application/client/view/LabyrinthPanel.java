package application.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.VK_SPACE;

public class LabyrinthPanel extends JPanel {
    int gridHeight;
    int gridWidth;

    JPanel labView;
    GridLayout gridLayout;

    public LabyrinthPanel() {
        initializeLabyrinth();
    }

    private void initializeLabyrinth() {
        setLayout(gridLayout);
        setBackground(Color.PINK);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case VK_SPACE: //TODO: Drop Bomb
                }

            }
        });
    }

    private void update() {

    }

}
