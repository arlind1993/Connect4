package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Game {
    JFrame frame;
    int width;
    int height;

    static int size=50;
    int posX=0;
    int posY=0;
    int offSize=0;

    Cell[][] cells;
    JButton[] buttons;

    public Game(){
        width=Field.width;
        height=Field.height;
        initialize();
    }

    public void initialize(){
        frame = new JFrame("4 in a row");
        frame.setSize(50*width+15, 50*height+100+40);
        frame.setLayout(null);
        cells=new Cell[height][width];

        posY+=30;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.println(posX+" "+posY+" "+i+" "+j);

                cells[i][j]=new Cell(i,j,posX,posY);

                frame.add(cells[i][j].getLabel());

                posX+=size+offSize;
            }
            posX=0;
            posY+=size+offSize;
        }
        posY+=10;

        buttons=new JButton[width];

        for(int i = 0; i < width; i++) {
            buttons[i]=new JButton();

            buttons[i].setBounds(posX,posY,size,size);
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            buttons[i].setName(String.valueOf(i));
            buttons[i].addActionListener(new MouseListener(cells,buttons[i]));

            frame.add(buttons[i]);

            posX+=size+offSize;
        }


        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
