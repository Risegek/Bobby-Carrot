package Blocks;

import javax.swing.*;
import java.awt.*;

public class WallBlock extends Block {
    public static Image LEFT_AND_RIGHT_TYPE = new ImageIcon("src/image/Other/LEFT_AND_RIGHT_WALLBLOCK.png").getImage();
    public static Image TOP_AND_DOWN_TYPE = new ImageIcon("src/image/Other/UP_ADN_DOWN_WALLBLOCK.png").getImage();
    public static Image RIGHT_AND_TOP_TYPE = new ImageIcon("src/image/Other/RIGHT_AND_TOP_WALLBLOCK.png").getImage();
    public static Image RIGHT_AND_DOWN_TYPE = new ImageIcon("src/image/Other/RIGHT_AND_DOWN_WALLBLOCK.png").getImage();
    public static Image LEFT_AND_TOP_TYPE = new ImageIcon("src/image/Other/LEFT_AND_TOP_WALLBLOCK.png").getImage();
    public static Image LEFT_AND_DOWN_TYPE = new ImageIcon("src/image/Other/LEFT_AND_DOWN_WALLBLOCK.png").getImage();


    public WallBlock(int i, int j, Image TYPE) {
        super(i, j);
        img = TYPE;
    }

    @Override
    public int activate() {
        if (LEFT_AND_RIGHT_TYPE.equals(img)) {
            img = TOP_AND_DOWN_TYPE;
        } else if (TOP_AND_DOWN_TYPE.equals(img)) {
            img = LEFT_AND_RIGHT_TYPE;
        } else if (RIGHT_AND_TOP_TYPE.equals(img)) {
            img = LEFT_AND_TOP_TYPE;
        } else if (RIGHT_AND_DOWN_TYPE.equals(img)) {
            img = RIGHT_AND_TOP_TYPE;
        } else if (LEFT_AND_TOP_TYPE.equals(img)) {
            img = LEFT_AND_DOWN_TYPE;
        } else if (LEFT_AND_DOWN_TYPE.equals(img)) {
            img = RIGHT_AND_DOWN_TYPE;
        }
        return super.activate();
    }


}
