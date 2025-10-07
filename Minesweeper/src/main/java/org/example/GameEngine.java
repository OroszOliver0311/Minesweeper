package org.example;

import java.util.Random;

public class GameEngine implements IGameEngine {

    Random rand = new Random();
    private final Map map;
    private boolean end = false;

    public GameEngine(int rows, int cols, int mineCount) {
        this.map = new Map(rows, cols, mineCount);
    }

    public void setMines() {
        int mineLeft = map.getMineCount();
        while (mineLeft > 0) {
            int row = rand.nextInt(map.getNumRows());
            int col = rand.nextInt(map.getNumCols());

            MineTile tile = map.getBoard()[row][col];
            if (!map.getMineList().contains(tile)) {
                map.getMineList().add(tile);
                tile.setType("B");
                mineLeft --;
            }
        }
    }



    public void gameLogic(int row, int col) {
        if ( row < 0 || row >= map.getNumRows() || col < 0 || col >= map.getNumCols()) {
            return;
        }
        MineTile tile = map.getBoard()[row][col];
        if (!tile.isEnabled()) {
            return;
        }
        tile.setEnabled(false);
        int minesFound = 0;

        //top 3
        minesFound += countMine(row - 1, col - 1);  //top left
        minesFound += countMine(row - 1, col);    //top
        minesFound += countMine(row - 1, col + 1);  //top right

        //left and right
        minesFound += countMine(row, col - 1);    //left
        minesFound += countMine(row, col + 1);    //right

        //bottom 3
        minesFound += countMine(row + 1, col - 1);  //bottom left
        minesFound += countMine(row + 1, col);    //bottom
        minesFound += countMine(row + 1, col + 1);  //bottom right

        if (minesFound > 0) {
            tile.setText(Integer.toString(minesFound));

        } else {

            //top 3
            gameLogic(row - 1, col - 1);    //top left
            gameLogic(row - 1, col);      //top
            gameLogic(row - 1, col + 1);    //top right

            //left and right
            gameLogic(row, col - 1);      //left
            gameLogic(row, col + 1);      //right

            //bottom 3
            gameLogic(row + 1, col - 1);    //bottom left
            gameLogic(row + 1, col);      //bottom
            gameLogic(row + 1, col + 1);    //bottom right
        }

    }


    public int countMine(int row, int col) {
        if (row < 0 || row >= map.getNumRows() || col < 0 || col >= map.getNumCols()) {
            return 0;
        }
        if (map.getMineList().contains(map.getBoard()[row][col])) {
            return 1;
        }
        return 0;
    }
    public boolean checkWin() {
        int totalTiles = map.getNumRows() * map.getNumCols();
        int mineTiles = map.getMineCount();
        int safeTiles = totalTiles - mineTiles;

        int revealedTiles = 0;
        for (int row = 0; row < map.getNumRows(); row++) {
            for (int col = 0; col < map.getNumCols(); col++) {
                MineTile tile = map.getBoard()[row][col];

                if (!tile.isEnabled() && !map.getMineList().contains(tile)) {
                    revealedTiles++;
                }
            }
        }

        return revealedTiles == safeTiles;
    }

    public boolean gameOver() {return end;}
    public void setGameOver(boolean state) {this.end = state;}
    public Map getMap() { return map; }


}
