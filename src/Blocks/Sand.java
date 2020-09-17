package Blocks;

import javax.swing.*;

public class Sand extends  Block {

    public Sand(int i, int j) {
        super(i, j);
        img = new ImageIcon("src/image/Other/Sand.png").getImage();
    }

    @Override
    public int activate() {
        return super.activate();
    }
}
