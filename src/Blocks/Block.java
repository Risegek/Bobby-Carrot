package Blocks;

import java.awt.*;

public abstract class Block {
    private int i, j;
    protected Image img;
    public boolean isActivated = false;

    Block() {
    }

    public Block(int i, int j) {
        this.i = i;
        this.j = j;
    }


    public Image getImg() {
        return img;
    }

    public int activate() {
        return 0;
    }

}
