package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MouseListener implements ActionListener {
    static boolean p1Turn = true;//p1-red, p2-yellow
    Cell[][] cells;
    JButton actBut;
    public MouseListener(Cell[][] cells, JButton actBut){
        this.cells=cells;
        this.actBut=actBut;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int inputX = Integer.parseInt(actBut.getName());
        System.out.println(inputX);

        int maxY=5;
        int lowestMostAvailiblePosY=0;
        boolean actionCanHappenInThisRow=false;
        while (maxY>=0){
            if (cells[maxY][inputX].getType()==0){
                System.out.println("c"+maxY);
                lowestMostAvailiblePosY = maxY;
                actionCanHappenInThisRow=true;
                break;
            }
            maxY--;
        }
        if (actionCanHappenInThisRow) {
            if (p1Turn){
                cells[lowestMostAvailiblePosY][inputX].setType(1);
            }else {
                cells[lowestMostAvailiblePosY][inputX].setType(2);
            }
            int checkRes=checkWin();
            boolean checkDraw=checkDraw();
            System.out.println("Check Result: "+checkRes);
            System.out.println("Check Draw: "+checkDraw);

            if (checkRes==1){
                Endscreen endscreen= new Endscreen(1);
                System.out.println("Red wins");
            }
            if (checkRes==2){
                Endscreen endscreen= new Endscreen(1);
                System.out.println("Yellow wins");
            }
            if (checkDraw){
                Endscreen endscreen= new Endscreen(3);
                System.out.println("Draw");
            }

            p1Turn = !p1Turn;

        }
    }

    private boolean checkDraw() {
        int isfilled=0;
        for (int i = 0; i < Field.height; i++) {
            for (int j = 0; j < Field.width; j++) {
                if (cells[i][j].getType()!=0){
                    isfilled++;
                }
            }
        }
        return isfilled==(Field.height*Field.width);
    }

    public int checkWin(){
        int res=0;

        // horizontalCheck
        for (int i = 0; i < Field.height-3 ; i++){
            for (int j = 0; j<Field.width; j++){
                System.out.println(i);
                if(
                        cells[i][j].getType()==1&&
                        cells[i+1][j].getType()==1&&
                        cells[i+2][j].getType()==1&&
                        cells[i+3][j].getType()==1
                ){
                    res=1;
                    break;
                }else if (
                        cells[i][j].getType()==2&&
                        cells[i+1][j].getType()==2&&
                        cells[i+2][j].getType()==2&&
                        cells[i+3][j].getType()==2
                ){
                    res=2;
                    break;
                }
            }
        }
        // verticalCheck
        for (int i = 0; i<Field.height; i++){
            for (int j = 0; j<Field.width-3; j++){
                if(
                        cells[i][j].getType()==1&&
                        cells[i][j+1].getType()==1&&
                        cells[i][j+2].getType()==1&&
                        cells[i][j+3].getType()==1
                ){
                    res=1;
                    break;
                }else if (
                        cells[i][j].getType()==2&&
                        cells[i][j+1].getType()==2&&
                        cells[i][j+2].getType()==2&&
                        cells[i][j+3].getType()==2
                ){
                    res=2;
                    break;
                }
            }
        }
        // descendingRightDiagonalCheck
        for (int i = 0; i<Field.height-3; i++){
            for (int j = 0; j<Field.width-3; j++){
                if(
                        cells[i][j].getType()==1&&
                        cells[i+1][j+1].getType()==1&&
                        cells[i+2][j+2].getType()==1&&
                        cells[i+3][j+3].getType()==1
                ){
                    res=1;
                    break;
                }else if (
                        cells[i][j].getType()==2&&
                        cells[i+1][j+1].getType()==2&&
                        cells[i+2][j+2].getType()==2&&
                        cells[i+3][j+3].getType()==2
                ){
                    res=2;
                    break;
                }
            }
        }
        // descendingLeftDiagonalCheck
        for (int i = 0; i<Field.height-3; i++){
            for (int j = 3; j<Field.width; j++){
                if(
                        cells[i][j].getType()==1&&
                        cells[i+1][j-1].getType()==1&&
                        cells[i+2][j-2].getType()==1&&
                        cells[i+3][j-3].getType()==1
                ){
                    res=1;
                    break;
                }else if (
                        cells[i][j].getType()==2&&
                        cells[i+1][j-1].getType()==2&&
                        cells[i+2][j-2].getType()==2&&
                        cells[i+3][j-3].getType()==2
                ){
                    res=2;
                    break;
                }
            }
        }
        return res;
    }


}
