package org.example;

public class Difficulty {

    private final String name;
    private final int rows;
    private final int cols;
    private final int mineCount;

    public Difficulty(String name, int rows, int cols, int mineCount) {
        this.name = name;
        this.rows = rows;
        this.cols = cols;
        this.mineCount = mineCount;
    }



    public String getName() { return name; }
    public int getRows() { return rows; }
    public int getCols() { return cols; }
    public int getMineCount() { return mineCount; }


    public static  Difficulty EASY = new Difficulty("Easy", 9, 9, 10);
    public static  Difficulty MEDIUM = new Difficulty("Medium", 16, 16, 40);
    public static  Difficulty HARD = new Difficulty("Hard", 16, 30, 99);
}