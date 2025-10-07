package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class DiffMenu extends JFrame {

    private final Consumer<Difficulty> onDifficultySelected;

    public DiffMenu(Consumer<Difficulty> onDifficultySelected) {
        this.onDifficultySelected = onDifficultySelected;
        setupUI();
    }
    public void setupUI() {
        setTitle("Choose difficulty");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));
        addDifficultyButton(Difficulty.EASY);
        addDifficultyButton(Difficulty.MEDIUM);
        addDifficultyButton(Difficulty.HARD);
    }
    private void addDifficultyButton(Difficulty difficulty) {
        String buttonText = String.format("%s (%dx%d, %d bombs)",
                difficulty.getName(),
                difficulty.getRows(),
                difficulty.getCols(),
                difficulty.getMineCount());

        JButton button = new JButton(buttonText);
        button.addActionListener(e -> selectDifficulty(difficulty));
        add(button);
    }

    private void selectDifficulty(Difficulty difficulty) {
        this.setVisible(false);
        SwingUtilities.invokeLater(() -> onDifficultySelected.accept(difficulty));
        this.dispose();
    }
}

