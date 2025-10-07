package org.example;

public interface IGameEngine {
    void setMines();
    void gameLogic(int row, int col);
    int countMine(int row, int col);
    boolean gameOver();
    void setGameOver(boolean state);
    Map getMap();
    boolean checkWin();
}