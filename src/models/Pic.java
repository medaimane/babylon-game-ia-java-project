package models;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author medaimane
 */
public class Pic extends JButton {

    Location location;

    public Pic() {
        location = new Location();
        this.setFocusPainted(false);
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new java.awt.Color(189, 189, 189), 3),
                BorderFactory.createEmptyBorder(7, 7, 10, 10)));
    }

    public Pic(Location location) {
        super();
        this.location = location;
    }

    public Location getLocal() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Tile{" + "location=" + location + '}';
    }
}
