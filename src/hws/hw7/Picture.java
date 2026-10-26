package hws.hw7;

import edu.princeton.cs.introcs.StdDraw;

/**
 * Framed picture using StdDraw.
 *
 * @author CS159 Faculty
 * @version 3/12/2024
 */
public class Picture {

    private static int picCount;

    private int x;
    private int y;
    private int width;
    private int height;
    private double scale;
    private String filename;

    private Frame frame;
    private double fwidth; // frame width
    private int picNum;

    /**
     * Explicit value constructor.
     *
     * @param x position of picture on Canvas
     * @param y position of picture on Canvas
     * @param width desired width of picture on Canvas
     * @param height desired height of picture on Canvas
     * @param scale the scale used for the picture on Canvas
     * @param filename filename of picture to display
     */
    public Picture(int x, int y, int width, int height, double scale,
            String filename) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.scale = scale;
        this.filename = filename;

        // compute the frame width
        frame = new Frame();
        fwidth = Frame.INNER_RADIUS;
        fwidth += Frame.OUTER_RADIUS;
        fwidth = fwidth * this.scale;

        // set the next picture number
        picNum = picCount;
        picCount++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getScale() {
        return scale;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Frame getFrame() {
        return frame;
    }

    public double getFwidth() {
        return fwidth;
    }

    public int getPicNum() {
        return picNum;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Picture) {
            Picture pic = (Picture) obj;
            return this.filename.equals(pic.filename);
        }
        return false;
    }

    /**
     * Draw the picture with its Frame.
     */
    public void draw() {
        StdDraw.picture(x, y, filename, width, height);

        // Draw the inner frame
        StdDraw.setPenColor(frame.getInnerColor());
        StdDraw.setPenRadius(Frame.INNER_RADIUS);
        StdDraw.rectangle(x, y, width / 2, height / 2);

        // Draw the outer frame, outside of inner frame
        StdDraw.setPenColor(frame.getOuterColor());
        StdDraw.setPenRadius(Frame.OUTER_RADIUS);
        StdDraw.rectangle(x, y, (width + fwidth) / 2, (height + fwidth) / 2);

        // reset the pen color and size to defaults
        StdDraw.setPenColor();
        StdDraw.setPenRadius();
    }

    @Override
    public String toString() {
        return "Picture: " + picNum + " " + filename + " at " + x + ", " + y
                + " size: " + width + " by " + height + "\n" + frame.toString();
    }

}
