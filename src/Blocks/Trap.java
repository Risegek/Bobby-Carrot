package Blocks;

import javax.swing.*;

public class Trap extends Block {

    public Trap(int i, int j) {
        super(i, j);
        img = new ImageIcon("src/image/Other/trap.png").getImage();
    }

    @Override
    public int activate() {
        super.activate();
        if (!isActivated) {
            this.img = new ImageIcon("src/image/Other/activeTrap.JPG").getImage();
            isActivated = true;
        }
        return 0;
    }
}
