package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameUI implements IGameView {
    private static final int BUTTON_SIZE = 50;

    private final JFrame frame = new JFrame("Minesweeper");
    private final JLabel textLabel = new JLabel();
    private final JPanel textPanel = new JPanel();
    private final JPanel boardPanel = new JPanel();
    private final int mapWidth;
    private final int mapHeight;
    private final Runnable backToMenu;

    private final GameController controller;

    public GameUI(Difficulty difficulty, Runnable backToMenu, IGameEngine engine) {
        this.mapWidth = difficulty.getRows();
        this.mapHeight = difficulty.getCols();
        this.backToMenu = backToMenu;

        this.controller = new GameController(engine, (IGameView) this);
        setupUI();
    }

    private void setupUI() {
        setupFrame();
        setupTextPanel();
        setupBoardPanel();
        setupBottomPanel();

        controller.initializeGame();
        frame.setVisible(true);
    }

    private void setupBoardPanel() {
        boardPanel.setLayout(new GridLayout(this.mapWidth, this.mapHeight));
        frame.add(boardPanel);

        for (int row = 0; row < controller.getEngine().getMap().getNumRows(); row++) {
            for (int col = 0; col < controller.getEngine().getMap().getNumCols(); col++) {
                MineTile tile = new MineTile(row, col);
                controller.getEngine().getMap().getBoard()[row][col] = tile;

                configureTile(tile);
                boardPanel.add(tile);
            }
        }
    }

    private void setupFrame() {
        frame.setSize(this.mapWidth * BUTTON_SIZE, this.mapHeight * BUTTON_SIZE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    }

    private void setupTextPanel() {
        textLabel.setFont(new Font("Arial", Font.BOLD, 25));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Minesweeper");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);
    }

    private void configureTile(MineTile tile) {
        tile.setFocusable(false);
        tile.setMargin(new Insets(0, 0, 0, 0));
        tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));

        tile.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                MineTile clickedTile = (MineTile) e.getSource();

                if (e.getButton() == MouseEvent.BUTTON1) {
                    controller.tileClick(
                            clickedTile.getRowPosition(),
                            clickedTile.getColPosition()
                    );
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                     controller.rightClick(
                            clickedTile.getRowPosition(),
                            clickedTile.getColPosition()
                    );
                }
            }
        });
    }

    private void setupBottomPanel() {
        JButton backButton = new JButton("Back to Menu");
        backButton.addActionListener(e -> {
            frame.dispose();
            backToMenu.run();
        });
        backButton.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void revealMines() {
        for (MineTile tile : controller.getEngine().getMap().getMineList()) {
            tile.setText("B");
        }
        updateGameStatus("Game Over!");
    }

    public void updateGameStatus(String message) {
        textLabel.setText(message);
    }
    public void showVictory() {
        updateGameStatus("You Win!");

    }
}





