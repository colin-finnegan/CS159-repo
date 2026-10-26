package hws.hw7;

import java.util.ArrayList;

/**
 * This class represents the wall that has all the pictures.
 *
 * @author Colin Finnegan
 * @version 3/21/2024
 */
public class Wall {

    public static final int WALL_WIDTH = 1024;
    public static final int WALL_HEIGHT = 512;
    private ArrayList<Picture> pics;

    /**
     * This constructor will construct a Wall.
     *
     * @param pics ArrayList of Picture Objects
     *
     */
    public Wall(ArrayList<Picture> pics) {
        this.pics = new ArrayList<Picture>(pics.size());
        for (Picture e: pics) {
            this.pics.add(e);
        }
    }

    public ArrayList<Picture> getPics() {
        return pics;
    }

    /**
     * This will display the wall.
     */
    public void display() {
        for (Picture e: pics) {
            e.draw();
        }
    }
}
