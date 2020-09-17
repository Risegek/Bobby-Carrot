package com.company;

import Blocks.*;
import com.sun.xml.internal.ws.client.SenderException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Level extends Thread {
    Habitat habitat = null;
    Rabbit rabbit = null;
    JFrame window = null;
    JPanel mainPanel = null;
    JPanel infoPanel = null;

    private long timeFromStart = 0;
    private int selectedLvl = 1;

    private Block[][] mas = null;
    private Block[][] camera = new Block[10][7];
    boolean isGoing = false;
    JLabel infLabel = new JLabel();

    private int sizeofBlock = 80;

    Level(Habitat habitat) {
        this.habitat = habitat;
    }

    public Block[][] getMas() {
        return mas;
    }

    public void setSelectedLvl(int selectedLvl) {
        this.selectedLvl = selectedLvl;
    }

    private void level_1() {
        if (mas != null)
            mas = null;

        mas = new Block[10][7];

        mas[0][0] = new Grass(0, 0, Grass.GRASS_TYPE_DOWN);
        mas[0][1] = new Grass(0, 1, Grass.GRASS_TYPE_RIGHT_AND_DOWN);
        mas[0][2] = new Sand(0, 2);
        mas[0][3] = new Sand(0, 3);
        mas[0][4] = new Sand(0, 4);
        mas[0][5] = new Grass(0, 5, Grass.GRASS_TYPE_LEFT);
        mas[0][6] = new Grass(0, 6, Grass.GRASS_TYPE_MIDLE);

        mas[1][0] = new Sand(1, 0);
        mas[1][1] = new Sand(1, 1);
        mas[1][2] = new Sand(1, 2);
        mas[1][3] = new Exit(1, 3);
        mas[1][4] = new Sand(1, 4);
        mas[1][5] = new Sand(1, 5);
        mas[1][6] = new Sand(1, 6);

        mas[2][0] = new Sand(2, 0);
        mas[2][1] = new Zabor(2, 1, Zabor.RIGHT);
        mas[2][2] = new Zabor(2, 2, Zabor.LEFT_AND_RIGHT);
        mas[2][3] = new Zabor(2, 3, Zabor.LEFT_AND_RIGHT);
        mas[2][4] = new Zabor(2, 4, Zabor.LEFT_AND_RIGHT);
        mas[2][5] = new Zabor(2, 5, Zabor.LEFT);
        mas[2][6] = new Sand(2, 6);

        mas[3][0] = new Sand(3, 0);
        mas[3][1] = new Zabor(3, 1, Zabor.VERTICAL);
        mas[3][2] = new Carrot(3, 2);
        mas[3][3] = new Carrot(3, 3);
        mas[3][4] = new Carrot(3, 4);
        mas[3][5] = new Zabor(3, 5, Zabor.VERTICAL);
        mas[3][6] = new Sand(3, 6);

        mas[4][0] = new Sand(4, 0);
        mas[4][1] = new Zabor(4, 1, Zabor.VERTICAL);
        mas[4][2] = new Carrot(4, 2);
        mas[4][3] = new Carrot(4, 3);
        mas[4][4] = new Carrot(4, 4);
        mas[4][5] = new Zabor(4, 5, Zabor.VERTICAL);
        mas[4][6] = new Sand(4, 6);

        mas[5][0] = new Sand(5, 0);
        mas[5][1] = new Zabor(5, 1, Zabor.VERTICAL);
        mas[5][2] = new Carrot(5, 2);
        mas[5][3] = new Carrot(5, 3);
        mas[5][4] = new Carrot(5, 4);
        mas[5][5] = new Zabor(5, 5, Zabor.VERTICAL);
        mas[5][6] = new Sand(5, 6);

        mas[6][0] = new Sand(6, 0);
        mas[6][1] = new Zabor(6, 1, Zabor.RIGHT);
        mas[6][2] = new Zabor(6, 2, Zabor.LEFT);
        mas[6][3] = new Sand(6, 3);
        mas[6][4] = new Zabor(6, 4, Zabor.RIGHT);
        mas[6][5] = new Zabor(6, 5, Zabor.LEFT);
        mas[6][6] = new Sand(6, 6);

        mas[7][0] = new Sand(7, 0);
        mas[7][1] = new Sand(7, 1);
        mas[7][2] = new Sand(7, 2);
        mas[7][3] = new Sand(7, 3);
        mas[7][4] = new Sand(7, 4);
        mas[7][5] = new Sand(7, 5);
        mas[7][6] = new Sand(7, 6);

        mas[8][0] = new Sand(8, 0);
        mas[8][1] = new Sand(8, 1);
        mas[8][2] = new Sand(8, 2);
        mas[8][3] = new Start(8, 3);
        rabbit = new Rabbit(8, 3, habitat.rabbitSkin);
        mas[8][4] = new Sand(8, 4);
        mas[8][5] = new Sand(8, 5);
        mas[8][6] = new Sand(8, 6);

        mas[9][0] = new Grass(9, 0, Grass.GRASS_TYPE_TOP);
        mas[9][1] = new Grass(9, 1, Grass.GRASS_TYPE_RIGHT_AND_TOP);
        mas[9][2] = new Sand(9, 2);
        mas[9][3] = new Sand(9, 3);
        mas[9][4] = new Sand(9, 4);
        mas[9][5] = new Grass(9, 5, Grass.GRASS_TYPE_LEFT_AND_TOP);
        mas[9][6] = new Grass(9, 6, Grass.GRASS_TYPE_TOP);

    }

    private void level_2() {
        if (mas != null)
            mas = null;

        mas = new Block[13][7];

        mas[0][0] = new Grass(0, 0, Grass.GRASS_TYPE_MIDLE);
        mas[0][1] = new Grass(0, 1, Grass.GRASS_TYPE_MIDLE);
        mas[0][2] = new Grass(0, 2, Grass.GRASS_TYPE_DOWN);
        mas[0][3] = new Grass(0, 3, Grass.GRASS_TYPE_DOWN);
        mas[0][4] = new Grass(0, 4, Grass.GRASS_TYPE_DOWN);
        mas[0][5] = new Grass(0, 5, Grass.GRASS_TYPE_MIDLE);
        mas[0][6] = new Grass(0, 6, Grass.GRASS_TYPE_MIDLE);

        mas[1][0] = new Grass(1, 0, Grass.GRASS_TYPE_DOWN);
        mas[1][1] = new Grass(1, 1, Grass.GRASS_TYPE_RIGHT_AND_DOWN);
        mas[1][2] = new Sand(1, 2);
        mas[1][3] = new Exit(1, 3);
        mas[1][4] = new Sand(1, 4);
        mas[1][5] = new Grass(1, 5, Grass.GRASS_TYPE_LEFT);
        mas[1][6] = new Grass(1, 6, Grass.GRASS_TYPE_MIDLE);

        mas[2][0] = new Sand(2, 0);
        mas[2][1] = new Sand(2, 1);
        mas[2][2] = new Sand(2, 2);
        mas[2][3] = new Sand(2, 3);
        mas[2][4] = new Sand(2, 4);
        mas[2][5] = new Sand(2, 5);
        mas[2][6] = new Sand(2, 6);

        mas[3][0] = new Zabor(3, 0, Zabor.RIGHT);
        mas[3][1] = new Zabor(3, 1, Zabor.LEFT_AND_RIGHT);
        mas[3][2] = new Zabor(3, 2, Zabor.LEFT);
        mas[3][3] = new Trap(3, 3);
        mas[3][4] = new Zabor(3, 4, Zabor.RIGHT);
        mas[3][5] = new Zabor(3, 5, Zabor.LEFT_AND_RIGHT);
        mas[3][6] = new Zabor(3, 6, Zabor.LEFT);

        mas[4][0] = new Zabor(4, 0, Zabor.VERTICAL);
        mas[4][1] = new Carrot(4, 1);
        mas[4][2] = new Carrot(4, 2);
        mas[4][3] = new Carrot(4, 3);
        mas[4][4] = new Carrot(4, 4);
        mas[4][5] = new Carrot(4, 5);
        mas[4][6] = new Zabor(4, 6, Zabor.VERTICAL);

        mas[5][0] = new Zabor(5, 0, Zabor.VERTICAL);
        mas[5][1] = new Carrot(5, 1);
        mas[5][2] = new Sand(5, 2);
        mas[5][3] = new Carrot(5, 3);
        mas[5][4] = new Sand(5, 4);
        mas[5][5] = new Carrot(5, 5);
        mas[5][6] = new Zabor(5, 6, Zabor.VERTICAL);

        mas[6][0] = new Zabor(6, 0, Zabor.VERTICAL);
        mas[6][1] = new Carrot(6, 1);
        mas[6][2] = new Carrot(6, 2);
        mas[6][3] = new Carrot(6, 3);
        mas[6][4] = new Carrot(6, 4);
        mas[6][5] = new Carrot(6, 5);
        mas[6][6] = new Zabor(6, 6, Zabor.VERTICAL);

        mas[7][0] = new Zabor(7, 0, Zabor.RIGHT);
        mas[7][1] = new Zabor(7, 1, Zabor.LEFT_AND_RIGHT);
        mas[7][2] = new Zabor(7, 2, Zabor.LEFT);
        mas[7][3] = new Trap(7, 3);
        mas[7][4] = new Zabor(7, 4, Zabor.RIGHT);
        mas[7][5] = new Zabor(7, 5, Zabor.LEFT_AND_RIGHT);
        mas[7][6] = new Zabor(7, 6, Zabor.LEFT);

        mas[8][0] = new Sand(8, 0);
        mas[8][1] = new Sand(8, 1);
        mas[8][2] = new Sand(8, 2);
        mas[8][3] = new Sand(8, 3);
        mas[8][4] = new Sand(8, 4);
        mas[8][5] = new Sand(8, 5);
        mas[8][6] = new Sand(8, 6);

        mas[9][0] = new Grass(9, 0, Grass.GRASS_TYPE_TOP);
        mas[9][1] = new Grass(9, 1, Grass.GRASS_TYPE_RIGHT_AND_TOP);
        mas[9][2] = new Sand(9, 2);
        mas[9][3] = new Sand(9, 3);
        mas[9][4] = new Sand(9, 4);
        mas[9][5] = new Grass(9, 5, Grass.GRASS_TYPE_LEFT_AND_TOP);
        mas[9][6] = new Grass(9, 6, Grass.GRASS_TYPE_TOP);

        mas[10][0] = new Grass(10, 0, Grass.GRASS_TYPE_MIDLE);
        mas[10][1] = new Grass(10, 1, Grass.GRASS_TYPE_RIGHT);
        mas[10][2] = new Sand(10, 2);
        mas[10][3] = new Start(10, 3);
        rabbit = new Rabbit(10, 3, habitat.rabbitSkin);
        mas[10][4] = new Sand(10, 4);
        mas[10][5] = new Grass(10, 5, Grass.GRASS_TYPE_LEFT);
        mas[10][6] = new Grass(10, 6, Grass.GRASS_TYPE_MIDLE);

        mas[11][0] = new Grass(11, 0, Grass.GRASS_TYPE_MIDLE);
        mas[11][1] = new Grass(11, 1, Grass.GRASS_TYPE_RIGHT);
        mas[11][2] = new Sand(11, 2);
        mas[11][3] = new Sand(11, 3);
        mas[11][4] = new Sand(11, 4);
        mas[11][5] = new Grass(11, 5, Grass.GRASS_TYPE_LEFT);
        mas[11][6] = new Grass(11, 6, Grass.GRASS_TYPE_MIDLE);

        mas[12][0] = new Grass(12, 0, Grass.GRASS_TYPE_MIDLE);
        mas[12][1] = new Grass(12, 1, Grass.GRASS_TYPE_MIDLE);
        mas[12][2] = new Grass(12, 2, Grass.GRASS_TYPE_TOP);
        mas[12][3] = new Grass(12, 3, Grass.GRASS_TYPE_TOP);
        mas[12][4] = new Grass(12, 4, Grass.GRASS_TYPE_TOP);
        mas[12][5] = new Grass(12, 5, Grass.GRASS_TYPE_MIDLE);
        mas[12][6] = new Grass(12, 6, Grass.GRASS_TYPE_MIDLE);

    }

    private void level_3() {
        if (mas != null)
            mas = null;

        mas = new Block[13][7];

        mas[0][0] = new Grass(0, 0, Grass.GRASS_TYPE_MIDLE);
        mas[0][1] = new Grass(0, 1, Grass.GRASS_TYPE_MIDLE);
        mas[0][2] = new Grass(0, 2, Grass.GRASS_TYPE_DOWN);
        mas[0][3] = new Grass(0, 3, Grass.GRASS_TYPE_DOWN);
        mas[0][4] = new Grass(0, 4, Grass.GRASS_TYPE_DOWN);
        mas[0][5] = new Grass(0, 5, Grass.GRASS_TYPE_MIDLE);
        mas[0][6] = new Grass(0, 6, Grass.GRASS_TYPE_MIDLE);

        mas[1][0] = new Grass(1, 0, Grass.GRASS_TYPE_DOWN);
        mas[1][1] = new Grass(1, 1, Grass.GRASS_TYPE_RIGHT_AND_DOWN);
        mas[1][2] = new Sand(1, 2);
        mas[1][3] = new Exit(1, 3);
        mas[1][4] = new Sand(1, 4);
        mas[1][5] = new Grass(1, 5, Grass.GRASS_TYPE_LEFT);
        mas[1][6] = new Grass(1, 6, Grass.GRASS_TYPE_MIDLE);

        mas[2][0] = new Sand(2, 0);
        mas[2][1] = new Sand(2, 1);
        mas[2][2] = new Sand(2, 2);
        mas[2][3] = new Sand(2, 3);
        mas[2][4] = new Sand(2, 4);
        mas[2][5] = new Sand(2, 5);
        mas[2][6] = new Sand(2, 6);

        mas[3][0] = new Grass(3, 0, Grass.GRASS_TYPE_TOP);
        mas[3][1] = new Grass(3, 1, Grass.GRASS_TYPE_TOP);
        mas[3][2] = new Grass(3, 2, Grass.GRASS_TYPE_RIGHT_AND_TOP);
        mas[3][3] = new Sand(3, 3);
        mas[3][4] = new Grass(3, 4, Grass.GRASS_TYPE_LEFT_AND_TOP);
        mas[3][5] = new Grass(3, 5, Grass.GRASS_TYPE_TOP);
        mas[3][6] = new Grass(3, 6, Grass.GRASS_TYPE_TOP);

        mas[4][0] = new Grass(4, 0, Grass.GRASS_TYPE_RIGHT);
        mas[4][1] = new Carrot(4, 1);
        mas[4][2] = new Carrot(4, 2);
        mas[4][3] = new Trap(4, 3);
        mas[4][4] = new Carrot(4, 4);
        mas[4][5] = new Carrot(4, 5);
        mas[4][6] = new Grass(4, 6, Grass.GRASS_TYPE_LEFT);

        mas[5][0] = new Grass(5, 0, Grass.GRASS_TYPE_RIGHT);
        mas[5][1] = new Carrot(5, 1);
        mas[5][2] = new Carrot(5, 2);
        mas[5][3] = new Trap(5, 3);
        mas[5][4] = new Carrot(5, 4);
        mas[5][5] = new Carrot(5, 5);
        mas[5][6] = new Grass(5, 6, Grass.GRASS_TYPE_LEFT);

        mas[6][0] = new Grass(6, 0, Grass.GRASS_TYPE_RIGHT);
        mas[6][1] = new Carrot(6, 1);
        mas[6][2] = new Carrot(6, 2);
        mas[6][3] = new Trap(6, 3);
        mas[6][4] = new Carrot(6, 4);
        mas[6][5] = new Carrot(6, 5);
        mas[6][6] = new Grass(6, 6, Grass.GRASS_TYPE_LEFT);

        mas[7][0] = new Grass(7, 0, Grass.GRASS_TYPE_MIDLE);
        mas[7][1] = new Grass(7, 1, Grass.GRASS_TYPE_TOP);
        mas[7][2] = new Grass(7, 2, Grass.GRASS_TYPE_RIGHT_AND_TOP);
        mas[7][3] = new Sand(7, 3);
        mas[7][4] = new Grass(7, 4, Grass.GRASS_TYPE_LEFT_AND_TOP);
        mas[7][5] = new Grass(7, 5, Grass.GRASS_TYPE_TOP);
        mas[7][6] = new Grass(7, 6, Grass.GRASS_TYPE_MIDLE);

        mas[8][0] = new Grass(8, 0, Grass.GRASS_TYPE_MIDLE);
        mas[8][1] = new Grass(8, 1, Grass.GRASS_TYPE_MIDLE);
        mas[8][2] = new Grass(8, 2, Grass.GRASS_TYPE_RIGHT_AND_DOWN);
        mas[8][3] = new Sand(8, 3);
        mas[8][4] = new Grass(8, 4, Grass.GRASS_TYPE_LEFT);
        mas[8][5] = new Grass(8, 5, Grass.GRASS_TYPE_MIDLE);
        mas[8][6] = new Grass(8, 6, Grass.GRASS_TYPE_MIDLE);

        mas[9][0] = new Grass(9, 0, Grass.GRASS_TYPE_MIDLE);
        mas[9][1] = new Grass(9, 1, Grass.GRASS_TYPE_RIGHT);
        mas[9][2] = new Sand(9, 2);
        mas[9][3] = new Sand(9, 3);
        mas[9][4] = new Sand(9, 4);
        mas[9][5] = new Grass(9, 5, Grass.GRASS_TYPE_LEFT);
        mas[9][6] = new Grass(9, 6, Grass.GRASS_TYPE_MIDLE);

        mas[10][0] = new Grass(10, 0, Grass.GRASS_TYPE_MIDLE);
        mas[10][1] = new Grass(10, 1, Grass.GRASS_TYPE_RIGHT);
        mas[10][2] = new Sand(10, 2);
        mas[10][3] = new Start(10, 3);
        rabbit = new Rabbit(10, 3, habitat.rabbitSkin);
        mas[10][4] = new Sand(10, 4);
        mas[10][5] = new Grass(10, 5, Grass.GRASS_TYPE_LEFT);
        mas[10][6] = new Grass(10, 6, Grass.GRASS_TYPE_MIDLE);

        mas[11][0] = new Grass(11, 0, Grass.GRASS_TYPE_MIDLE);
        mas[11][1] = new Grass(11, 1, Grass.GRASS_TYPE_RIGHT);
        mas[11][2] = new Sand(11, 2);
        mas[11][3] = new Sand(11, 3);
        mas[11][4] = new Sand(11, 4);
        mas[11][5] = new Grass(11, 5, Grass.GRASS_TYPE_LEFT);
        mas[11][6] = new Grass(11, 5, Grass.GRASS_TYPE_MIDLE);

        mas[12][0] = new Grass(12, 0, Grass.GRASS_TYPE_MIDLE);
        mas[12][1] = new Grass(12, 1, Grass.GRASS_TYPE_MIDLE);
        mas[12][2] = new Grass(12, 2, Grass.GRASS_TYPE_TOP);
        mas[12][3] = new Grass(12, 3, Grass.GRASS_TYPE_TOP);
        mas[12][4] = new Grass(12, 4, Grass.GRASS_TYPE_TOP);
        mas[12][5] = new Grass(12, 5, Grass.GRASS_TYPE_MIDLE);
        mas[12][6] = new Grass(12, 6, Grass.GRASS_TYPE_MIDLE);
        ;

    }

    private void level_4() {
        if (mas != null)
            mas = null;
        mas = new Block[9][13];
//
        mas[0][0] = new Grass(0, 0, Grass.GRASS_TYPE_MIDLE);
        mas[0][1] = new Grass(0, 1, Grass.GRASS_TYPE_RIGHT);
        mas[0][2] = new Sand(0, 2);
        mas[0][3] = new Zabor(0, 3, Zabor.RIGHT);
        mas[0][4] = new Zabor(0, 4, Zabor.LEFT_AND_RIGHT);
        mas[0][5] = new Zabor(0, 5, Zabor.LEFT_AND_RIGHT);
        mas[0][6] = new Zabor(0, 6, Zabor.LEFT_AND_RIGHT);
        mas[0][7] = new Zabor(0, 7, Zabor.LEFT_AND_RIGHT);
        mas[0][8] = new Zabor(0, 8, Zabor.LEFT_AND_RIGHT);
        mas[0][9] = new Zabor(0, 9, Zabor.LEFT_AND_RIGHT);
        mas[0][10] = new Zabor(0, 10, Zabor.LEFT_AND_RIGHT);
        mas[0][11] = new Zabor(0, 11, Zabor.LEFT);
        mas[0][12] = new Grass(0, 12, Grass.GRASS_TYPE_LEFT);
//
        mas[1][0] = new Grass(1, 0, Grass.GRASS_TYPE_MIDLE);
        mas[1][1] = new Grass(1, 1, Grass.GRASS_TYPE_RIGHT);
        mas[1][2] = new Sand(1, 2);
        mas[1][3] = new Zabor(1, 3, Zabor.VERTICAL);
        mas[1][4] = new Carrot(1, 4);
        mas[1][5] = new Carrot(1, 5);
        mas[1][6] = new Carrot(1, 6);
        mas[1][7] = new Zabor(1, 7, Zabor.VERTICAL);
        mas[1][8] = new Carrot(1, 8);
        mas[1][9] = new Carrot(1, 9);
        mas[1][10] = new Carrot(1, 10);
        mas[1][11] = new Zabor(1, 11, Zabor.VERTICAL);
        mas[1][12] = new Grass(1, 12, Grass.GRASS_TYPE_LEFT);
//
        mas[2][0] = new Grass(2, 0, Grass.GRASS_TYPE_MIDLE);
        mas[2][1] = new Grass(2, 1, Grass.GRASS_TYPE_RIGHT);
        mas[2][2] = new Sand(2, 2);
        mas[2][3] = new Trap(2, 3);
        mas[2][4] = new Carrot(2, 4);
        mas[2][5] = new Carrot(2, 5);
        mas[2][6] = new Carrot(2, 6);
        mas[2][7] = new Trap(2, 7);
        mas[2][8] = new Carrot(2, 8);
        mas[2][9] = new Carrot(2, 9);
        mas[2][10] = new Carrot(2, 10);
        mas[2][11] = new Zabor(2, 11, Zabor.VERTICAL);
        mas[2][12] = new Grass(2, 12, Grass.GRASS_TYPE_LEFT);
//
        mas[3][0] = new Grass(3, 0, Grass.GRASS_TYPE_MIDLE);
        mas[3][1] = new Grass(3, 1, Grass.GRASS_TYPE_RIGHT);
        mas[3][2] = new Sand(3, 2);
        mas[3][3] = new Zabor(3, 3, Zabor.VERTICAL);
        mas[3][4] = new Carrot(3, 4);
        mas[3][5] = new Carrot(3, 5);
        mas[3][6] = new Carrot(3, 6);
        mas[3][7] = new Zabor(3, 7, Zabor.VERTICAL);
        mas[3][8] = new Carrot(3, 8);
        mas[3][9] = new Carrot(3, 9);
        mas[3][10] = new Carrot(3, 10);
        mas[3][11] = new Zabor(3, 11, Zabor.VERTICAL);
        mas[3][12] = new Grass(3, 12, Grass.GRASS_TYPE_LEFT);
//
        mas[4][0] = new Grass(4, 0, Grass.GRASS_TYPE_DOWN);
        mas[4][1] = new Grass(4, 1, Grass.GRASS_TYPE_RIGHT_AND_DOWN);
        mas[4][2] = new Sand(4, 2);
        mas[4][3] = new Zabor(4, 3, Zabor.RIGHT);
        mas[4][4] = new Zabor(4, 4, Zabor.LEFT_AND_RIGHT);
        mas[4][5] = new Zabor(4, 5, Zabor.LEFT_AND_RIGHT);
        mas[4][6] = new Zabor(4, 6, Zabor.LEFT_AND_RIGHT);
        mas[4][7] = new Zabor(4, 7, Zabor.LEFT_AND_RIGHT);
        mas[4][8] = new Zabor(4, 8, Zabor.LEFT_AND_RIGHT);
        mas[4][9] = new Trap(4, 9);
        mas[4][10] = new Zabor(4, 10, Zabor.LEFT_AND_RIGHT);
        mas[4][11] = new Zabor(4, 11, Zabor.LEFT);
        mas[4][12] = new Grass(4, 12, Grass.GRASS_TYPE_LEFT);
//
        mas[5][0] = new Sand(5, 0);
        mas[5][1] = new Sand(5, 1);
        mas[5][2] = new Sand(5, 2);
        mas[5][3] = new Zabor(5, 3, Zabor.VERTICAL);
        mas[5][4] = new Carrot(5, 4);
        mas[5][5] = new Carrot(5, 5);
        mas[5][6] = new Carrot(5, 6);
        mas[5][7] = new Zabor(5, 7, Zabor.VERTICAL);
        mas[5][8] = new Carrot(5, 8);
        mas[5][9] = new Carrot(5, 9);
        mas[5][10] = new Carrot(5, 10);
        mas[5][11] = new Zabor(5, 11, Zabor.VERTICAL);
        mas[5][12] = new Grass(5, 12, Grass.GRASS_TYPE_LEFT);
//
        mas[6][0] = new Sand(6, 0);
        mas[6][1] = new Start(6, 1);
        rabbit = new Rabbit(6, 1, habitat.rabbitSkin);
        mas[6][2] = new Sand(6, 2);
        mas[6][3] = new Trap(6, 3);
        mas[6][4] = new Carrot(6, 4);
        mas[6][5] = new Exit(6, 5);
        mas[6][6] = new Carrot(6, 6);
        mas[6][7] = new Trap(6, 7);
        mas[6][8] = new Carrot(6, 8);
        mas[6][9] = new Carrot(6, 9);
        mas[6][10] = new Carrot(6, 10);
        mas[6][11] = new Zabor(6, 11, Zabor.VERTICAL);
        mas[6][12] = new Grass(6, 12, Grass.GRASS_TYPE_LEFT);
//
        mas[7][0] = new Sand(7, 0);
        mas[7][1] = new Sand(7, 1);
        mas[7][2] = new Sand(7, 2);
        mas[7][3] = new Zabor(7, 3, Zabor.VERTICAL);
        mas[7][4] = new Carrot(7, 4);
        mas[7][5] = new Carrot(7, 5);
        mas[7][6] = new Carrot(7, 6);
        mas[7][7] = new Zabor(7, 7, Zabor.VERTICAL);
        mas[7][8] = new Carrot(7, 8);
        mas[7][9] = new Carrot(7, 9);
        mas[7][10] = new Carrot(7, 10);
        mas[7][11] = new Zabor(7, 11, Zabor.VERTICAL);
        mas[7][12] = new Grass(7, 12, Grass.GRASS_TYPE_LEFT);

        mas[8][0] = new Grass(8, 0, Grass.GRASS_TYPE_TOP);
        mas[8][1] = new Grass(8, 1, Grass.GRASS_TYPE_RIGHT_AND_TOP);
        mas[8][2] = new Sand(8, 2);
        mas[8][3] = new Zabor(8, 3, Zabor.RIGHT);
        mas[8][4] = new Zabor(8, 4, Zabor.LEFT_AND_RIGHT);
        mas[8][5] = new Zabor(8, 5, Zabor.LEFT_AND_RIGHT);
        mas[8][6] = new Zabor(8, 6, Zabor.LEFT_AND_RIGHT);
        mas[8][7] = new Zabor(8, 7, Zabor.LEFT_AND_RIGHT);
        mas[8][8] = new Zabor(8, 8, Zabor.LEFT_AND_RIGHT);
        mas[8][9] = new Zabor(8, 9, Zabor.LEFT_AND_RIGHT);
        mas[8][10] = new Zabor(8, 10, Zabor.LEFT_AND_RIGHT);
        mas[8][11] = new Zabor(8, 11, Zabor.LEFT);
        mas[8][12] = new Grass(8, 12, Grass.GRASS_TYPE_LEFT);

    }

    private void level_5() {
        if (mas != null)
            mas = null;

        mas = new Block[11][7];

        mas[0][0] = new Grass(0, 0, Grass.GRASS_TYPE_MIDLE);
        mas[0][1] = new Grass(0, 1, Grass.GRASS_TYPE_DOWN);
        mas[0][2] = new Grass(0, 2, Grass.GRASS_TYPE_DOWN);
        mas[0][3] = new Grass(0, 3, Grass.GRASS_TYPE_DOWN);
        mas[0][4] = new Grass(0, 4, Grass.GRASS_TYPE_DOWN);
        mas[0][5] = new Grass(0, 5, Grass.GRASS_TYPE_DOWN);
        mas[0][6] = new Grass(0, 6, Grass.GRASS_TYPE_MIDLE);

        mas[1][0] = new Grass(1, 0, Grass.GRASS_TYPE_RIGHT);
        mas[1][1] = new Sand(1, 1);
        mas[1][2] = new Sand(1, 2);
        mas[1][3] = new Sand(1, 3);
        mas[1][4] = new Sand(1, 4);
        mas[1][5] = new Sand(1, 5);
        mas[1][6] = new Grass(1, 6, Grass.GRASS_TYPE_LEFT);

        mas[2][0] = new Grass(2, 0, Grass.GRASS_TYPE_RIGHT);
        mas[2][1] = new Sand(2, 1);
        mas[2][2] = new Sand(2, 2);
        mas[2][3] = new Start(2, 3);
        rabbit = new Rabbit(2, 3, habitat.rabbitSkin);
        mas[2][4] = new Sand(2, 4);
        mas[2][5] = new Sand(2, 5);
        mas[2][6] = new Grass(2, 6, Grass.GRASS_TYPE_LEFT);

        mas[3][0] = new Grass(3, 0, Grass.GRASS_TYPE_RIGHT);
        mas[3][1] = new Sand(3, 1);
        mas[3][2] = new Sand(3, 2);
        mas[3][3] = new Sand(3, 3);
        mas[3][4] = new Sand(3, 4);
        mas[3][5] = new Sand(3, 5);
        mas[3][6] = new Grass(3, 6, Grass.GRASS_TYPE_LEFT);

        mas[4][0] = new Grass(4, 0, Grass.GRASS_TYPE_RIGHT);
        mas[4][1] = new Trap(4, 1);
        mas[4][2] = new Carrot(4, 2);
        mas[4][3] = new Trap(4, 3);
        mas[4][4] = new Carrot(4, 4);
        mas[4][5] = new Trap(4, 5);
        mas[4][6] = new Grass(4, 6, Grass.GRASS_TYPE_LEFT);

        mas[5][0] = new Grass(5, 0, Grass.GRASS_TYPE_RIGHT);
        mas[5][1] = new Carrot(5, 1);
        mas[5][2] = new Trap(5, 2);
        mas[5][3] = new Carrot(5, 3);
        mas[5][4] = new Trap(5, 4);
        mas[5][5] = new Carrot(5, 5);
        mas[5][6] = new Grass(5, 6, Grass.GRASS_TYPE_LEFT);

        mas[6][0] = new Grass(6, 0, Grass.GRASS_TYPE_RIGHT);
        mas[6][1] = new Trap(6, 1);
        mas[6][2] = new Carrot(6, 2);
        mas[6][3] = new Trap(6, 3);
        mas[6][4] = new Carrot(6, 4);
        mas[6][5] = new Trap(6, 5);
        mas[6][6] = new Grass(6, 6, Grass.GRASS_TYPE_LEFT);

        mas[7][0] = new Grass(7, 0, Grass.GRASS_TYPE_RIGHT);
        mas[7][1] = new Sand(7, 1);
        mas[7][2] = new Sand(7, 2);
        mas[7][3] = new Sand(7, 3);
        mas[7][4] = new Sand(7, 4);
        mas[7][5] = new Sand(7, 5);
        mas[7][6] = new Grass(7, 6, Grass.GRASS_TYPE_LEFT);

        mas[8][0] = new Grass(8, 0, Grass.GRASS_TYPE_RIGHT);
        mas[8][1] = new Sand(8, 1);
        mas[8][2] = new Sand(8, 2);
        mas[8][3] = new Exit(8, 3);
        mas[8][4] = new Sand(8, 4);
        mas[8][5] = new Sand(8, 5);
        mas[8][6] = new Grass(8, 6, Grass.GRASS_TYPE_LEFT);

        mas[9][0] = new Grass(9, 0, Grass.GRASS_TYPE_RIGHT);
        mas[9][1] = new Sand(9, 1);
        mas[9][2] = new Sand(9, 2);
        mas[9][3] = new Sand(9, 3);
        mas[9][4] = new Sand(9, 4);
        mas[9][5] = new Sand(9, 5);
        mas[9][6] = new Grass(9, 6, Grass.GRASS_TYPE_LEFT);

        mas[10][0] = new Grass(10, 0, Grass.GRASS_TYPE_MIDLE);
        mas[10][1] = new Grass(10, 1, Grass.GRASS_TYPE_TOP);
        mas[10][2] = new Grass(10, 2, Grass.GRASS_TYPE_TOP);
        mas[10][3] = new Grass(10, 3, Grass.GRASS_TYPE_TOP);
        mas[10][4] = new Grass(10, 4, Grass.GRASS_TYPE_TOP);
        mas[10][5] = new Grass(10, 5, Grass.GRASS_TYPE_TOP);
        mas[10][6] = new Grass(10, 6, Grass.GRASS_TYPE_MIDLE);
    }

    private void level_7() {
        if (mas != null)
            mas = null;

        mas = new Block[3][11];

        mas[0][0] = new Grass(0, 0, Grass.GRASS_TYPE_MIDLE);
        mas[0][1] = new Grass(0, 1, Grass.GRASS_TYPE_DOWN);
        mas[0][2] = new Grass(0, 2, Grass.GRASS_TYPE_DOWN);
        mas[0][3] = new Grass(0, 3, Grass.GRASS_TYPE_DOWN);
        mas[0][4] = new Grass(0, 4, Grass.GRASS_TYPE_MIDLE);
        mas[0][5] = new Grass(0, 5, Grass.GRASS_TYPE_MIDLE);
        mas[0][6] = new Grass(0, 6, Grass.GRASS_TYPE_MIDLE);
        mas[0][7] = new Grass(0, 7, Grass.GRASS_TYPE_DOWN);
        mas[0][8] = new Grass(0, 8, Grass.GRASS_TYPE_DOWN);
        mas[0][9] = new Grass(0, 9, Grass.GRASS_TYPE_DOWN);
        mas[0][10] = new Grass(0, 10, Grass.GRASS_TYPE_MIDLE);

        mas[1][0] = new Grass(1, 0, Grass.GRASS_TYPE_RIGHT);
        mas[1][1] = new Sand(1, 1);
        mas[1][2] = new Sand(1, 2);
        mas[1][3] = new Sand(1, 3);
        mas[1][4] = new WallBlock(1, 4, WallBlock.LEFT_AND_DOWN_TYPE);
        mas[1][5] = new WallBlock(1, 5, WallBlock.RIGHT_AND_DOWN_TYPE);
        mas[1][6] = new WallBlock(1, 6, WallBlock.TOP_AND_DOWN_TYPE);
        mas[1][7] = new Sand(1, 7);
        mas[1][8] = new Sand(1, 8);
        mas[1][9] = new Sand(1, 9);
        mas[1][10] = new Grass(1, 10, Grass.GRASS_TYPE_LEFT);

        mas[2][0] = new Grass(2, 0, Grass.GRASS_TYPE_RIGHT);
        mas[2][1] = new Sand(2, 1);
        mas[2][2] = new WallBlock(2, 2, WallBlock.RIGHT_AND_TOP_TYPE);
        mas[2][3] = new WallBlock(2, 3, WallBlock.LEFT_AND_TOP_TYPE);
        mas[2][4] = new Sand(2, 4);
        mas[2][5] = new Sand(2, 5);
        mas[2][6] = new Sand(2, 6);
        mas[2][7] = new Start(2, 7);
        rabbit = new Rabbit(2, 7, habitat.rabbitSkin);
        mas[2][8] = new Carrot(2, 8);
        mas[2][9] = new Exit(2, 9);
        mas[2][10] = new Grass(2, 10, Grass.GRASS_TYPE_LEFT);


    }

    private void level_6() {
        if (mas != null)
            mas = null;

        mas = new Block[10][11];

        mas[0][0] = new Grass(0, 0, Grass.GRASS_TYPE_MIDLE);
        mas[0][1] = new Grass(0, 1, Grass.GRASS_TYPE_DOWN);
        mas[0][2] = new Grass(0, 2, Grass.GRASS_TYPE_DOWN);
        mas[0][3] = new Grass(0, 3, Grass.GRASS_TYPE_DOWN);
        mas[0][4] = new Grass(0, 4, Grass.GRASS_TYPE_MIDLE);
        mas[0][5] = new Grass(0, 5, Grass.GRASS_TYPE_MIDLE);
        mas[0][6] = new Grass(0, 6, Grass.GRASS_TYPE_MIDLE);
        mas[0][7] = new Grass(0, 7, Grass.GRASS_TYPE_DOWN);
        mas[0][8] = new Grass(0, 8, Grass.GRASS_TYPE_DOWN);
        mas[0][9] = new Grass(0, 9, Grass.GRASS_TYPE_DOWN);
        mas[0][10] = new Grass(0, 10, Grass.GRASS_TYPE_MIDLE);

        mas[1][0] = new Grass(1, 0, Grass.GRASS_TYPE_RIGHT);
        mas[1][1] = new Carrot(1, 1);
        mas[1][2] = new Carrot(1, 2);
        mas[1][3] = new Carrot(1, 3);
        mas[1][4] = new Grass(1, 4, Grass.GRASS_TYPE_LEFT);
        mas[1][5] = new Grass(1, 5, Grass.GRASS_TYPE_MIDLE);
        mas[1][6] = new Grass(1, 6, Grass.GRASS_TYPE_RIGHT);
        mas[1][7] = new Carrot(1, 7);
        mas[1][8] = new Carrot(1, 8);
        mas[1][9] = new Carrot(1, 9);
        mas[1][10] = new Grass(1, 10, Grass.GRASS_TYPE_LEFT);

        mas[2][0] = new Grass(2, 0, Grass.GRASS_TYPE_RIGHT);
        mas[2][1] = new Carrot(2, 1);
        mas[2][2] = new Start(2, 2);
        rabbit = new Rabbit(2, 2, habitat.rabbitSkin);
        mas[2][3] = new Carrot(2, 3);
        mas[2][4] = new Line(2, 4, Line.RIGHT);
        mas[2][5] = new Line(2, 5, Line.RIGHT);
        mas[2][6] = new Line(2, 6, Line.RIGHT);
        mas[2][7] = new Carrot(2, 7);
        mas[2][8] = new Carrot(2, 8);
        mas[2][9] = new Carrot(2, 9);
        mas[2][10] = new Grass(2, 10, Grass.GRASS_TYPE_LEFT);

        mas[3][0] = new Grass(3, 0, Grass.GRASS_TYPE_RIGHT);
        mas[3][1] = new Carrot(3, 1);
        mas[3][2] = new Carrot(3, 2);
        mas[3][3] = new Carrot(3, 3);
        mas[3][4] = new Grass(3, 4, Grass.GRASS_TYPE_LEFT);
        mas[3][5] = new Grass(3, 5, Grass.GRASS_TYPE_MIDLE);
        mas[3][6] = new Grass(3, 6, Grass.GRASS_TYPE_RIGHT);
        mas[3][7] = new Carrot(3, 7);
        mas[3][8] = new Carrot(3, 8);
        mas[3][9] = new Carrot(3, 9);
        mas[3][10] = new Grass(3, 10, Grass.GRASS_TYPE_LEFT);

        mas[4][0] = new Grass(4, 0, Grass.GRASS_TYPE_MIDLE);
        mas[4][1] = new Grass(4, 1, Grass.GRASS_TYPE_TOP);
        mas[4][2] = new Line(4, 2, Line.DOWN);
        mas[4][3] = new Grass(4, 3, Grass.GRASS_TYPE_TOP);
        mas[4][4] = new Grass(4, 4, Grass.GRASS_TYPE_MIDLE);
        mas[4][5] = new Grass(4, 5, Grass.GRASS_TYPE_MIDLE);
        mas[4][6] = new Grass(4, 6, Grass.GRASS_TYPE_MIDLE);
        mas[4][7] = new Grass(4, 7, Grass.GRASS_TYPE_RIGHT_AND_TOP);
        mas[4][8] = new Sand(4, 8);
        mas[4][9] = new Grass(4, 9, Grass.GRASS_TYPE_LEFT_AND_TOP);
        mas[4][10] = new Grass(4, 10, Grass.GRASS_TYPE_MIDLE);

        mas[5][0] = new Grass(5, 0, Grass.GRASS_TYPE_MIDLE);
        mas[5][1] = new Grass(5, 1, Grass.GRASS_TYPE_DOWN);
        mas[5][2] = new Line(5, 2, Line.DOWN);
        mas[5][3] = new Grass(5, 3, Grass.GRASS_TYPE_DOWN);
        mas[5][4] = new Grass(5, 4, Grass.GRASS_TYPE_MIDLE);
        mas[5][5] = new Grass(5, 5, Grass.GRASS_TYPE_MIDLE);
        mas[5][6] = new Grass(5, 6, Grass.GRASS_TYPE_MIDLE);
        mas[5][7] = new Grass(5, 7, Grass.GRASS_TYPE_RIGHT_AND_DOWN);
        mas[5][8] = new Sand(5, 8);
        mas[5][9] = new Grass(5, 9, Grass.GRASS_TYPE_LEFT);
        mas[5][10] = new Grass(5, 10, Grass.GRASS_TYPE_MIDLE);

        mas[6][0] = new Grass(6, 0, Grass.GRASS_TYPE_RIGHT);
        mas[6][1] = new Sand(6, 1);
        mas[6][2] = new Sand(6, 2);
        mas[6][3] = new Sand(6, 3);
        mas[6][4] = new Grass(6, 4, Grass.GRASS_TYPE_LEFT);
        mas[6][5] = new Grass(6, 5, Grass.GRASS_TYPE_MIDLE);
        mas[6][6] = new Grass(6, 6, Grass.GRASS_TYPE_RIGHT);
        mas[6][7] = new Carrot(6, 7);
        mas[6][8] = new Carrot(6, 8);
        mas[6][9] = new Carrot(6, 9);
        mas[6][10] = new Grass(6, 10, Grass.GRASS_TYPE_LEFT);

        mas[7][0] = new Grass(7, 0, Grass.GRASS_TYPE_RIGHT);
        mas[7][1] = new Sand(7, 1);
        mas[7][2] = new Exit(7, 2);
        mas[7][3] = new Sand(7, 3);
        mas[7][4] = new Line(7, 4, Line.LEFT);
        mas[7][5] = new Line(7, 5, Line.LEFT);
        mas[7][6] = new Line(7, 6, Line.LEFT);
        mas[7][7] = new Carrot(7, 7);
        mas[7][8] = new Carrot(7, 8);
        mas[7][9] = new Carrot(7, 9);
        mas[7][10] = new Grass(7, 10, Grass.GRASS_TYPE_LEFT);

        mas[8][0] = new Grass(8, 0, Grass.GRASS_TYPE_RIGHT);
        mas[8][1] = new Sand(8, 1);
        mas[8][2] = new Sand(8, 2);
        mas[8][3] = new Sand(8, 3);
        mas[8][4] = new Grass(8, 4, Grass.GRASS_TYPE_LEFT);
        mas[8][5] = new Grass(8, 5, Grass.GRASS_TYPE_MIDLE);
        mas[8][6] = new Grass(8, 6, Grass.GRASS_TYPE_RIGHT);
        mas[8][7] = new Carrot(8, 7);
        mas[8][8] = new Carrot(8, 8);
        mas[8][9] = new Carrot(8, 9);
        mas[8][10] = new Grass(8, 10, Grass.GRASS_TYPE_LEFT);

        mas[9][0] = new Grass(9, 0, Grass.GRASS_TYPE_MIDLE);
        mas[9][1] = new Grass(9, 1, Grass.GRASS_TYPE_TOP);
        mas[9][2] = new Grass(9, 2, Grass.GRASS_TYPE_TOP);
        mas[9][3] = new Grass(9, 3, Grass.GRASS_TYPE_TOP);
        mas[9][4] = new Grass(9, 4, Grass.GRASS_TYPE_MIDLE);
        mas[9][5] = new Grass(9, 5, Grass.GRASS_TYPE_MIDLE);
        mas[9][6] = new Grass(9, 6, Grass.GRASS_TYPE_MIDLE);
        mas[9][7] = new Grass(9, 7, Grass.GRASS_TYPE_TOP);
        mas[9][8] = new Grass(9, 8, Grass.GRASS_TYPE_TOP);
        mas[9][9] = new Grass(9, 9, Grass.GRASS_TYPE_TOP);
        mas[9][10] = new Grass(9, 10, Grass.GRASS_TYPE_MIDLE);

    }

    public void startGame() {
        isGoing = true;
        window = new JFrame("Level " + selectedLvl);
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        infoPanel = new JPanel();
        infoPanel.setLayout(null);

        JButton mainMenu = new JButton("Main menu");
        switch (selectedLvl) {
            case 1: {
                level_1();
                break;
            }
            case 2: {
                level_2();
                break;
            }
            case 3: {
                level_3();
                break;
            }
            case 4: {
                level_4();
                break;
            }
            case 5: {
                level_5();
                break;
            }
            case 6: {
                level_6();
                break;
            }
            case 7: {
                level_7();
                break;
            }
        }
        window.setBounds(200, 0, sizeofBlock * mas[0].length + 20, sizeofBlock * mas.length + 80);
        window.setIconImage(new ImageIcon("src/image/Other/icon.png").getImage());
        infoPanel.setBounds(0, 0, window.getWidth(), 40);
        mainPanel.setBounds(0, 40, window.getWidth(), window.getHeight() - 80);

        infLabel.setFont(new Font("TimesRoman", Font.ITALIC, 40));
        infLabel.setBounds(0, 0, window.getWidth(), infoPanel.getHeight());
        infLabel.setForeground(Color.black);
        infLabel.setVisible(true);
        infoPanel.add(infLabel);


        Timer startTime = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeFromStart++;
            }
        });

        startTime.start();

        mainMenu.setBounds(infoPanel.getWidth() - 150, 5, 100, 30);
        mainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
                window.transferFocus();

            }
        });

        infoPanel.add(mainMenu);

        window.add(infoPanel);
        window.add(mainPanel);

        mainMenu.setFocusable(false);
        window.transferFocus();
        window.setVisible(true);

        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_A: {
                    }
                    case KeyEvent.VK_LEFT: {
                        if (rabbit.j != 0)
                            rabbit.moveLeft();
                        else break;

                        if (!(mas[rabbit.i][rabbit.j] instanceof Trap) && !(mas[rabbit.i][rabbit.j] instanceof WallBlock))
                            if (mas[rabbit.i][rabbit.j].activate() == -1) {
                                rabbit.moveRight();
                                break;
                            }

                        if ((mas[rabbit.i][rabbit.j] instanceof Line))
                            if (mas[rabbit.i][rabbit.j].activate() != Line.LEFT) {
                                rabbit.moveRight();
                                break;
                            }

                        if ((mas[rabbit.i][rabbit.j] instanceof WallBlock))
                            if (mas[rabbit.i][rabbit.j].getImg() != WallBlock.LEFT_AND_RIGHT_TYPE && mas[rabbit.i][rabbit.j].getImg() != WallBlock.LEFT_AND_DOWN_TYPE && mas[rabbit.i][rabbit.j].getImg() != WallBlock.LEFT_AND_TOP_TYPE) {
                                rabbit.moveRight();
                                break;
                            }
                        if (rabbit.j + 1 != mas[0].length && mas[rabbit.i][rabbit.j + 1] instanceof WallBlock)
                            if (mas[rabbit.i][rabbit.j + 1].getImg() == WallBlock.LEFT_AND_TOP_TYPE || mas[rabbit.i][rabbit.j + 1].getImg() == WallBlock.LEFT_AND_DOWN_TYPE || mas[rabbit.i][rabbit.j + 1].getImg() == WallBlock.TOP_AND_DOWN_TYPE) {
                                rabbit.moveRight();
                                break;
                            }

                        if (rabbit.j + 1 != mas[0].length && mas[rabbit.i][rabbit.j + 1] instanceof Trap || rabbit.j + 1 != mas[0].length && mas[rabbit.i][rabbit.j + 1] instanceof WallBlock)
                            mas[rabbit.i][rabbit.j + 1].activate();

                        checkBlocks(rabbit.i, rabbit.j);
                        break;
                    }
                    case KeyEvent.VK_D: {
                    }
                    case KeyEvent.VK_RIGHT: {
                        if (rabbit.j != mas[rabbit.i].length - 1)
                            rabbit.moveRight();
                        else break;

                        if (!(mas[rabbit.i][rabbit.j] instanceof Trap) && !(mas[rabbit.i][rabbit.j] instanceof WallBlock))
                            if (mas[rabbit.i][rabbit.j].activate() == -1) {
                                rabbit.moveLeft();
                                break;
                            }

                        if ((mas[rabbit.i][rabbit.j] instanceof Line))
                            if (mas[rabbit.i][rabbit.j].activate() != Line.RIGHT) {
                                rabbit.moveLeft();
                                break;
                            }

                        if ((mas[rabbit.i][rabbit.j] instanceof WallBlock))
                            if (mas[rabbit.i][rabbit.j].getImg() != WallBlock.LEFT_AND_RIGHT_TYPE && mas[rabbit.i][rabbit.j].getImg() != WallBlock.RIGHT_AND_DOWN_TYPE && mas[rabbit.i][rabbit.j].getImg() != WallBlock.RIGHT_AND_TOP_TYPE) {
                                rabbit.moveLeft();
                                break;
                            }

                        if (rabbit.j - 1 != mas[0].length && mas[rabbit.i][rabbit.j - 1] instanceof WallBlock)
                            if (mas[rabbit.i][rabbit.j - 1].getImg() == WallBlock.RIGHT_AND_TOP_TYPE || mas[rabbit.i][rabbit.j - 1].getImg() == WallBlock.RIGHT_AND_DOWN_TYPE || mas[rabbit.i][rabbit.j - 1].getImg() == WallBlock.TOP_AND_DOWN_TYPE) {
                                rabbit.moveLeft();
                                break;
                            }
                        if (rabbit.j - 1 != -1 && mas[rabbit.i][rabbit.j - 1] instanceof Trap || rabbit.j - 1 != -1 && mas[rabbit.i][rabbit.j - 1] instanceof WallBlock)
                            mas[rabbit.i][rabbit.j - 1].activate();

                        checkBlocks(rabbit.i, rabbit.j);
                        break;
                    }
                    case KeyEvent.VK_W: {
                    }
                    case KeyEvent.VK_UP: {
                        if (rabbit.i != 0)
                            rabbit.moveTop();
                        else break;
                        if (!(mas[rabbit.i][rabbit.j] instanceof Trap) && !(mas[rabbit.i][rabbit.j] instanceof WallBlock))
                            if (mas[rabbit.i][rabbit.j].activate() == -1) {
                                rabbit.moveDown();
                                break;
                            }
                        if ((mas[rabbit.i][rabbit.j] instanceof Line))
                            if (mas[rabbit.i][rabbit.j].activate() != Line.UP) {
                                rabbit.moveDown();
                                break;
                            }

                        if ((mas[rabbit.i][rabbit.j] instanceof WallBlock))
                            if (mas[rabbit.i][rabbit.j].getImg() != WallBlock.TOP_AND_DOWN_TYPE && mas[rabbit.i][rabbit.j].getImg() != WallBlock.LEFT_AND_DOWN_TYPE && mas[rabbit.i][rabbit.j].getImg() != WallBlock.RIGHT_AND_DOWN_TYPE) {
                                rabbit.moveDown();
                                break;
                            }

                        if (rabbit.i + 1 != mas.length && mas[rabbit.i + 1][rabbit.j] instanceof WallBlock)
                            if (mas[rabbit.i + 1][rabbit.j].getImg() == WallBlock.LEFT_AND_DOWN_TYPE || mas[rabbit.i + 1][rabbit.j].getImg() == WallBlock.RIGHT_AND_DOWN_TYPE || mas[rabbit.i + 1][rabbit.j].getImg() == WallBlock.LEFT_AND_RIGHT_TYPE) {
                                rabbit.moveDown();
                                break;
                            }

                        if ((rabbit.i + 1 != mas.length && mas[rabbit.i + 1][rabbit.j] instanceof Trap) || (rabbit.i + 1 != mas.length && mas[rabbit.i + 1][rabbit.j] instanceof WallBlock)) {
                            mas[rabbit.i + 1][rabbit.j].activate();
                        }

                        checkBlocks(rabbit.i, rabbit.j);
                        break;
                    }
                    case KeyEvent.VK_S: {
                    }
                    case KeyEvent.VK_DOWN: {
                        if (rabbit.i != mas.length - 1)
                            rabbit.moveDown();
                        else break;

                        if (!(mas[rabbit.i][rabbit.j] instanceof Trap) && !(mas[rabbit.i][rabbit.j] instanceof WallBlock))
                            if (mas[rabbit.i][rabbit.j].activate() == -1) {
                                rabbit.moveTop();
                                break;
                            }

                        if ((mas[rabbit.i][rabbit.j] instanceof Line))
                            if (mas[rabbit.i][rabbit.j].activate() != Line.DOWN) {
                                rabbit.moveTop();
                                break;
                            }
                        if ((mas[rabbit.i][rabbit.j] instanceof WallBlock))
                            if (mas[rabbit.i][rabbit.j].getImg() != WallBlock.TOP_AND_DOWN_TYPE && mas[rabbit.i][rabbit.j].getImg() != WallBlock.RIGHT_AND_TOP_TYPE && mas[rabbit.i][rabbit.j].getImg() != WallBlock.LEFT_AND_TOP_TYPE) {
                                rabbit.moveTop();
                                break;
                            }

                        if (rabbit.i - 1 != mas.length && mas[rabbit.i - 1][rabbit.j] instanceof WallBlock)
                            if (mas[rabbit.i - 1][rabbit.j].getImg() == WallBlock.LEFT_AND_TOP_TYPE || mas[rabbit.i - 1][rabbit.j].getImg() == WallBlock.RIGHT_AND_TOP_TYPE || mas[rabbit.i - 1][rabbit.j].getImg() == WallBlock.LEFT_AND_RIGHT_TYPE) {
                                rabbit.moveTop();
                                break;
                            }

                        if (rabbit.i - 1 != -1 && mas[rabbit.i - 1][rabbit.j] instanceof Trap || rabbit.i - 1 != -1 && mas[rabbit.i - 1][rabbit.j] instanceof WallBlock)
                            mas[rabbit.i - 1][rabbit.j].activate();

                        checkBlocks(rabbit.i, rabbit.j);
                        break;
                    }
                }

            }
        });

        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                isGoing = false;
                startTime.stop();
                Carrot.count = 0;
                mas = null;
                habitat.window.setVisible(true);
            }
        });


        this.start();
    }

    //public void changeCamera() {
    //    if (rabbit.i > 4 && this.getMas()[0][rabbit.i + 4] != null) {
    //        for (int i = 0; i < 9; i++) {
    //            for (int j = 0; j < 6; j++) {
    //                camera[i][j] = camera[i + 1][j + 1];
    //            }
    //        }
    //        for (int i = 0; i < 10; i++) {
    //            camera[i][9] = mas[i][rabbit.i + 4];
    //        }
    //    }
    //    if (rabbit.j > 7 && this.getMas()[rabbit.j + 7][0] != null) {
    //        for (int i = 0; i < 9; i++) {
    //            for (int j = 0; j < 6; j++) {
    //                camera[i][j] = camera[i + 1][j + 1];
    //            }
    //        }
    //        for (int i = 0; i < 7; i++) {
    //            camera[i][9] = mas[i][rabbit.i + 4];
    //        }
    //    }
//
    //}

    public synchronized void draw(JComponent g) {
        int w = g.getWidth(), h = g.getHeight();
        BufferedImage fieldImage;
        fieldImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics fieldImageGraphics = fieldImage.getGraphics();
        for (int i = 0; i < this.getMas().length; i++)
            for (int j = 0; j < this.getMas()[i].length; j++) {
                try {
                    fieldImageGraphics.drawImage(this.getMas()[i][j].getImg(), j * sizeofBlock, i * sizeofBlock, sizeofBlock, sizeofBlock, null);

                } catch (Exception e) {
                    System.out.println(i + "  " + j);

                }
            }
        fieldImageGraphics.drawImage(rabbit.getImg(), rabbit.j * sizeofBlock, rabbit.i * sizeofBlock, sizeofBlock, sizeofBlock, null);
        g.getGraphics().drawImage(fieldImage, 0, infoPanel.getHeight(), w, h, null);
    }

    @Override
    public void run() {
        super.run();
        while (isGoing) {
            infLabel.setText("Carrot: " + Carrot.count + "          " + timeFromStart / 60 + ":" + ((timeFromStart % 60 < 10) ? "0" : "") + timeFromStart % 60);

            draw(mainPanel);
            try {
                this.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void death() {
        Carrot.count = 0;
        switch (selectedLvl) {
            case 1: {
                try {
                    this.sleep(100);
                    level_1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 2: {
                try {
                    this.sleep(100);
                    level_2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 3: {
                try {
                    this.sleep(100);
                    level_3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 4: {
                try {
                    this.sleep(100);
                    level_4();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 5: {
                try {
                    this.sleep(100);
                    level_5();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    private void exit() {
        if (Carrot.count == 0) {
            switch (selectedLvl) {
                case 1: {
                    habitat.isLevel1Complite = true;
                    habitat.complete_levels(1);
                    if (habitat.client != null) habitat.client.passLvl(1, (int) timeFromStart);
                    break;
                }
                case 2: {
                    habitat.isLevel2Complite = true;
                    habitat.complete_levels(2);
                    if (habitat.client != null) habitat.client.passLvl(2, (int) timeFromStart);
                    break;
                }
                case 3: {
                    habitat.isLevel3Complite = true;
                    habitat.complete_levels(3);
                    if (habitat.client != null) habitat.client.passLvl(3, (int) timeFromStart);
                    break;
                }
                case 4: {
                    habitat.isLevel4Complite = true;
                    habitat.complete_levels(4);
                    if (habitat.client != null) habitat.client.passLvl(4, (int) timeFromStart);
                    break;
                }
                case 5: {
                    habitat.isLevel5Complite = true;
                    habitat.complete_levels(5);
                    if (habitat.client != null) habitat.client.passLvl(5, (int) timeFromStart);
                    break;
                }
                case 6: {
                    habitat.isLevel5Complite = true;
                    habitat.complete_levels(6);
                    if (habitat.client != null) habitat.client.passLvl(6, (int) timeFromStart);
                    break;
                }
                case 7: {
                    habitat.isLevel5Complite = true;
                    habitat.complete_levels(7);
                    if (habitat.client != null) habitat.client.passLvl(7, (int) timeFromStart);
                    break;
                }
            }
            window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
        }
    }

    private void checkBlocks(int i, int j) {
        if (mas[rabbit.i][rabbit.j] instanceof Trap) {
            if (mas[rabbit.i][rabbit.j].isActivated) {
                death();
            }
        }

        if (mas[rabbit.i][rabbit.j] instanceof Exit) {
            exit();
        }

    }

}
