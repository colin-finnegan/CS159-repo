package hws.hw7;

import java.util.ArrayList;

import edu.princeton.cs.introcs.StdDraw;

/**
 * Use the Picture hierarchy to display a wall of pictures.
 *
 * @author CS159 Faculty
 * @version 3/15/2024
 */
public class Gallery {

    public static final int WALL_SCALE = 512;

    /**
     * Demonstrate the use of the Picture inheritance hierarchy.
     *
     * @param args command line arguments not used
     */
    public static void main(String[] args) {

        ArrayList<Picture> mypics = new ArrayList<Picture>();

        Picture jmuCS = new Picture(512, 256, 350, 200, WALL_SCALE,
                "hws/hw7/img/JMU-CS.png");

        ArrayList<String> seasonPics = new ArrayList<String>();
        seasonPics.add("hws/hw7/img/Spring.jpg");
        seasonPics.add("hws/hw7/img/Summer.jpg");
        seasonPics.add("hws/hw7/img/Fall.jpg");
        seasonPics.add("hws/hw7/img/Winter.jpg");
        SlideShow seasons = new SlideShow(200, 256, 200, 150, WALL_SCALE,
                seasonPics);

        TitledPicture tpic1 = new TitledPicture(800, 256, 75, 75, WALL_SCALE,
                "hws/hw7/img/Weikle.jpg", "Weikle");

        TitledPicture tpic2 = new TitledPicture(800, 384, 75, 75, WALL_SCALE,
                "hws/hw7/img/Mayfield.jpg", "Mayfield");

        TitledPicture tpic3 = new TitledPicture(800, 128, 75, 75, WALL_SCALE,
                "hws/hw7/img/Shrestha.png", "Shrestha");

        TitledPicture tpic4 = new TitledPicture(925, 320, 75, 75, WALL_SCALE,
                "hws/hw7/img/Wang.png", "Wang");

        TitledPicture tpic5 = new TitledPicture(925, 192, 75, 75, WALL_SCALE,
                "hws/hw7/img/Duan.png", "Duan");

        mypics.add(jmuCS);
        mypics.add(seasons);
        mypics.add(tpic1);
        mypics.add(tpic2);
        mypics.add(tpic3);
        mypics.add(tpic4);
        mypics.add(tpic5);

        // print out the inventory in mypics
        System.out.println();
        System.out.println("Gallery Inventory");
        System.out.println();
        for (Picture pic: mypics) {
            System.out.println(pic);
            System.out.println();
        }

        // initialize the wall Canvas
        StdDraw.setTitle("Wonder Wall");
        StdDraw.setCanvasSize(Wall.WALL_WIDTH, Wall.WALL_HEIGHT);
        StdDraw.setXscale(0, Wall.WALL_WIDTH);
        StdDraw.setYscale(0, Wall.WALL_HEIGHT);
        StdDraw.enableDoubleBuffering();

        // display the wall
        Wall wall = new Wall(mypics);
        while (true) {
            wall.display();
            StdDraw.show();
            StdDraw.pause(SlideShow.SLIDE_SHOW_PAUSE);
            StdDraw.clear();
        }
    }

}
