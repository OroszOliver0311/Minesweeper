package org.example;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        setupUI();
    }

    private void setupUI() {
        setTitle("MineSweeper");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1));

        JButton newGameButton = new JButton("New Game");
        JButton exitButton = new JButton("Exit");

        add(newGameButton);
        add(exitButton);

        newGameButton.addActionListener(_ -> showDifficultyMenu());
        exitButton.addActionListener(_ -> System.exit(0));
    }

    private void showDifficultyMenu() {
        SwingUtilities.invokeLater(() -> {
            DiffMenu diffMenu = new DiffMenu(this::startGame);
            diffMenu.setVisible(true);
            this.dispose();
        });
    }

    private void startGame(Difficulty difficulty) {
        IGameEngine engine = GameEngineFactory.createGameEngine(difficulty);
        new GameUI(difficulty, this::showMainMenu, engine);
    }

    private void showMainMenu() {
        SwingUtilities.invokeLater(() -> {
            MainMenu menu = new MainMenu();
            menu.setVisible(true);
        });
    }
}