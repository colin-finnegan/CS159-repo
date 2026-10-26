package hws.hw7;

import java.util.ArrayList;

/**
 * This represents the SlideShow class, which will
 * change pictures depending on the pause speed.
 *
 * @author Colin Finnegan
 * @version 3/22/2024
 */

public class SlideShow extends Picture {

    public static final int SLIDE_SHOW_PAUSE = 2000;
    private ArrayList<String> picFiles;
    private int currentPic;

    /**
     * Constructs a slideshow.
     *
     * @param x integer
     * @param y integer
     * @param width integer
     * @param height integer
     * @param scale double
     * @param picFiles ArrayList of Strings
     */
    public SlideShow(int x, int y, int width, int height,
        double scale, ArrayList<String> picFiles) {
        super(x, y, width, height, scale, picFiles.get(0));
        this.picFiles = new ArrayList<String>(picFiles.size());
        this.currentPic = 0;
        for (String s: picFiles) {
            this.picFiles.add(s);
        }


    }

    public int getCurrentPic() {
        return currentPic;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SlideShow) {
            SlideShow ss = (SlideShow) obj;
            return this.picFiles.equals(ss.picFiles);
        }
        return false;
    }

    /**
     * Draws a picture exactly as done in the Picture class.
     */
    public void draw() {
        super.draw();
        if (currentPic >= picFiles.size() - 1) {
            currentPic = 0;
        } else {
            currentPic++;
        }
        setFilename(picFiles.get(currentPic));
    }

    @Override
    public String toString() {
        String s = "";
        for (int x = 0; x < picFiles.size(); x++) {
            s += "\n" + picFiles.get(x);
        }
        return super.toString() + s;
    }
}
