package org.example;

public class GameController {
    private final IGameEngine engine;
    private final IGameView view;

    public GameController(IGameEngine engine, IGameView view) {
        this.engine = engine;
        this.view = view;
    }

    public void initializeGame() {
        engine.setMines();
    }

    public void tileClick(int row, int col) {
        if (engine.gameOver()) {
            return;
        }

        MineTile tile = engine.getMap().getBoard()[row][col];

        if (tile.getText().isEmpty()) {
            if (engine.getMap().getMineList().contains(tile)) {
                view.revealMines();
                engine.setGameOver(true);
            } else {
                engine.gameLogic(row, col);
                gameState();
            }
        }
    }

    public void rightClick(int row, int col) {
        if (engine.gameOver()) {
            return;
        }

        MineTile tile = engine.getMap().getBoard()[row][col];

        if (tile.getText().isEmpty() && tile.isEnabled()) {
            tile.setType("F");
            tile.setText("F");
        } else if (tile.getText().equals("F")) {
            tile.setType("");
            tile.setText("");
            gameState();
        }

    }
    private void gameState() {
        if (engine.checkWin()) {
            engine.setGameOver(true);
            view.showVictory();
        }
    }
    public IGameEngine getEngine() {
        return engine;
    }
}