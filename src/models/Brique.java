package models;

import java.io.Serializable;

/**
 *
 * @author medaimane
 */
public class Brique implements Cloneable, Serializable {

    private static final long serialVersionUID = -7781752714348214533L;
    private Location location;
    private Color color;
    private boolean top;

    public Brique() {
        this.top = false;
    }

    public Brique(Location location, Color color) {
        this.location = location;
        this.color = color;
        this.top = false;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    @Override
    public String toString() {
        return "Brique{" + "location=" + location + ", color=" + color + '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Brique b = new Brique();
        b.setColor(this.getColor());
        b.setLocation((Location) this.location.clone());
        return b;
    }
}
