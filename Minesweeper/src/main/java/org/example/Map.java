package org.example;

import java.util.ArrayList;

public class Map {


    private final int numRows;
    private final int numCols;
    private final MineTile[][] board;
    private final int mineCount;
    private final ArrayList<MineTile> mineList;

public Map(int numRows, int numCols, int mines) {
    this.numRows = numRows;
    this.numCols = numCols;
    this.mineCount = mines;
    board = new MineTile[numRows][numCols];
    mineList = new ArrayList<>();
}

    public  ArrayList<MineTile> getMineList() { return mineList; }
    public int getNumCols() { return numCols; }
    public int getNumRows() { return numRows; }
    public MineTile[][] getBoard() { return board; }
    public int getMineCount() { return mineCount; }

}
