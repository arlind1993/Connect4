package com.company;

import javax.swing.*;
import java.awt.*;

public class Cell {
    JLabel label;
    int type;//0-empty, 1-red, 2-yellow

    public Cell(int i, int j, int posX, int posY){
        label=new JLabel();
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setBounds(posX,posY,Game.size,Game.size);

        label.setBackground(Color.LIGHT_GRAY);
        label.setOpaque(true);
    }

    public JLabel getLabel() {
        return label;
    }
    public int getType() {
        return type;
    }
    public void setLabel(JLabel label) {
        this.label = label;
    }

    public void setType(int type) {
        switch (type){
            case 0:
                label.setBackground(Color.LIGHT_GRAY);
                break;
            case 1:
                label.setBackground(Color.RED);
                break;
            case 2:
                label.setBackground(Color.YELLOW);
                break;
            default:
                System.out.println("Err");
                break;
        }
        this.type = type;
    }
}
