package org.example;

import javax.swing.*;

public class MineTile extends JButton {

    private String type;
    private final int rowPosition;
    private final int colPosition;

    public MineTile(int rowP, int colP) {
        this.rowPosition = rowP;
        this.colPosition = colP;
        type = "";
    }

    public int getRowPosition() {
        return rowPosition;
    }

    public int getColPosition() {
        return colPosition;
    }

    public void setType(String type) {
        this.type = type;
    }

}