package hws.hw7;

import java.awt.Color;

/**
 * This class represents a the picture frame.
 *
 * @author Colin Finnegan
 * @version 3/21/2024
 */
public class Frame {

    public static final Color JMU_PURPLE = new Color(69, 0, 132);
    public static final Color JMU_GOLD = new Color(203, 182, 119);
    public static final double INNER_RADIUS = 0.01;
    public static final double OUTER_RADIUS = 0.02;
    private Color outerColor;
    private Color innerColor;

    /**
     * Default constructor.
     */

    public Frame() {
        this.innerColor = JMU_GOLD;
        this.outerColor = JMU_PURPLE;
    }

    /**
     * Construct a frame given two colors.
     *
     * @param innerColor the inner color of the frame
     * @param outerColor the outer color of the frame
     */
    public Frame(Color innerColor, Color outerColor) {
        this.innerColor = innerColor;
        this.outerColor = outerColor;
    }

    public Color getInnerColor() {
        return innerColor;
    }

    public void setInnerColor(Color innerColor) {
        this.innerColor = innerColor;
    }

    public Color getOuterColor() {
        return outerColor;
    }

    public void setOuterColor(Color outerColor) {
        this.outerColor = outerColor;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Frame) {
            Frame frame = (Frame) obj;
            return this.innerColor == frame.innerColor
                    && this.outerColor == frame.outerColor;
        }
        return false;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Frame [outerColor=" + outerColor.toString() + ", innerColor="
                + innerColor.toString() + "]";
    }
}
