package Blocks;

import javax.swing.*;
import java.awt.*;

public class Grass extends Block {
    public static Image GRASS_TYPE_LEFT = new ImageIcon("src/image/Grass/leftGrass.png").getImage();
    public static Image GRASS_TYPE_RIGHT = new ImageIcon("src/image/Grass/RightGrass.png").getImage();
    public static Image GRASS_TYPE_LEFT_AND_TOP = new ImageIcon("src/image/Grass/leftAndTopGrass.png").getImage();
    public static Image GRASS_TYPE_MIDLE = new ImageIcon("src/image/Grass/MidleGrass.png").getImage();
    public static Image GRASS_TYPE_RIGHT_AND_DOWN = new ImageIcon("src/image/Grass/rightAndDownGrass.png").getImage();
    public static Image GRASS_TYPE_RIGHT_AND_TOP = new ImageIcon("src/image/Grass/rightAndTopGrass.png").getImage();
    public static Image GRASS_TYPE_TOP = new ImageIcon("src/image/Grass/TopGrass.png").getImage();
    public static Image GRASS_TYPE_DOWN = new ImageIcon("src/image/Grass/DownGrass.png").getImage();

    public Grass(int i, int j, Image GRASS_TYPE){
        super(i, j);
        img = GRASS_TYPE;
    }


    @Override
    public int activate() {
        super.activate();
        return -1;
    }


}
