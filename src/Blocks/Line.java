package Blocks;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Line extends Block {
    public static int LEFT = 0;
    public static int RIGHT = 1;
    public static int UP = 2;
    public static int DOWN = 3;

    int type = -1;

    public Line(int i, int j, int TYPE) {
        super(i, j);
        switch (TYPE) {
            case 0: {
                type = 0;
                img = new ImageIcon("src/image/Other/LeftLine.png").getImage();
                break;
            }
            case 1: {
                type = 1;
                img = new ImageIcon("src/image/Other/RightLine.png").getImage();
                break;
            }
            case 2: {
                type = 2;
                img = new ImageIcon("src/image/Other/UpLine.png").getImage();
                break;
            }
            case 3: {
                type = 3;
                img = new ImageIcon("src/image/Other/DownLine.png").getImage();
                break;
            }
        }

    }

    @Override
    public int activate() {
        return type;
    }
}
