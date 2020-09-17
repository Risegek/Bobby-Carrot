package com.company;

import javax.swing.*;
import java.awt.*;

public class Rabbit {
    int i, j;
    private Image img;

    public static Image SKIN_1 = new ImageIcon("src/image/Rabbits/Rabbit_skin1.png").getImage();
    public static Image SKIN_2 = new ImageIcon("src/image/Rabbits/Rabbit_skin2.png").getImage();
    public static Image SKIN_3 = new ImageIcon("src/image/Rabbits/Rabbit_skin3.png").getImage();
    public static Image SKIN_4 = new ImageIcon("src/image/Rabbits/Rabbit_skin4.png").getImage();
    public static Image SKIN_5 = new ImageIcon("src/image/Rabbits/Rabbit_skin5.png").getImage();
    public static Image SKIN_6 = new ImageIcon("src/image/Rabbits/Rabbit_skin6.png").getImage();

    Rabbit(int i, int j, int skin) {
        this.i = i;
        this.j = j;

        switch (skin) {
            case 1: {
                img = Rabbit.SKIN_1;
                break;
            }
            case 2: {
                img = Rabbit.SKIN_2;
                break;
            }
            case 3: {
                img = Rabbit.SKIN_3;
                break;
            }
            case 4: {
                img = Rabbit.SKIN_4;
                break;
            }
            case 5: {
                img = Rabbit.SKIN_5;
                break;
            }
            case 6: {
                img = Rabbit.SKIN_6;
                break;
            }
        }


    }

    public void moveLeft() {
        this.j--;
    }

    public void moveRight() {
        this.j++;

    }

    public void moveTop() {
        this.i--;

    }

    public void moveDown() {
        this.i++;

    }

    public Image getImg() {
        return img;
    }


}
