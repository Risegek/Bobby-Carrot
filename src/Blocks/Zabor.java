package Blocks;

import javax.swing.*;
import java.awt.*;

public class Zabor extends Block {
    public static final Image VERTICAL = new ImageIcon("src/image/Other/VerticalZabor.png").getImage();
    public static final Image RIGHT = new ImageIcon("src/image/Other/RightZabor.png").getImage();
    public static final Image LEFT = new ImageIcon("src/image/Other/LeftZabor.png").getImage();
    public static final Image LEFT_AND_RIGHT = new ImageIcon("src/image/Other/LeftAndRightZabor.png").getImage();

    public Zabor(int i, int j, Image ZABOR_TYPE) {
        super(i, j);
        img = ZABOR_TYPE;
    }

    @Override
    public int activate() {
        super.activate();
        return -1;
    }
}
