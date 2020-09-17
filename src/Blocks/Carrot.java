package Blocks;

import javax.swing.*;

public class Carrot extends Block {

    public static int count = 0;

    public Carrot(int i, int j) {
        super(i, j);
        count++;
        img = new ImageIcon("src/image/Other/Carrot.png").getImage();
    }

    public int activate() {
        if (!isActivated) {
            this.img = new ImageIcon("src/image/Other/CarrotActive.png").getImage();
            isActivated = true;
            count--;
        }
        return 0;
    }


}
