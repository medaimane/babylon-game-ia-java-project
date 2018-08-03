package models;

import java.io.Serializable;


/**
 *
 * @author medaimane
 */
public class Location implements Serializable, Cloneable {

    private static final long serialVersionUID = -6600099139724913381L;
    private int x;
    private int y;

    public Location() {
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Location{" + "x=" + x + ", y=" + y + '}';
    }
}
