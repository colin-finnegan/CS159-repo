package hws.hw7;

import edu.princeton.cs.introcs.StdDraw;

/**
 * This represents the TitledPicture class. It creates a photo and puts a title
 * on it.
 *
 * @author Colin Finnegan
 * @version 3/22/2024
 */
public class TitledPicture extends Picture {

    public static final int TEXT_HEIGHT = 12;
    public static final int CHAR_WIDTH = 4;
    public static final int PIC_NUM_CHARS = 4;
    private String title;

    /**
     * This will construct a Picture with Titles.
     *
     * @param x integer
     * @param y integer
     * @param width integer
     * @param height integer
     * @param scale double
     * @param filename String
     * @param title String
     */
    public TitledPicture(int x, int y, int width, int height, double scale,
            String filename, String title) {
        super(x, y, width, height, scale, filename);
        this.title = title;
    }

    /**
     * This method will draw a picture.
     */
    public void draw() {
        super.draw();
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledRectangle(getX(),
                (getY() - (getHeight() / 2)) + getFwidth(),
                (title.length() + PIC_NUM_CHARS) * CHAR_WIDTH, TEXT_HEIGHT);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(getX(), (getY() - (getHeight() / 2)) + getFwidth(),
                super.getPicNum() + ": " + title);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Title: " + title;
    }
}
