package algorithms;

import models.Brique;
import models.Location;
import models.Move;

/**
 *
 * @author medaimane
 */
public class BabylonMove extends Move {

    Brique brique;
    Location to;

    public BabylonMove() {
    }

    public BabylonMove(Brique brique, Location to) {
        this.brique = brique;
        this.to = to;
    }

    public Brique getBrique() {
        return brique;
    }

    public void setBrique(Brique brique) {
        this.brique = brique;
    }

    public Location getTo() {
        return to;
    }

    public void setTo(Location to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "BabylonMove{" + "brique=" + brique + ", to=" + to + '}';
    }
}
