package algorithms;

import models.Color;
import models.Brique;
import models.Location;
import models.Move;
import models.Position;
import java.util.ArrayList;

/**
 *
 * @author medaimane
 */
public class Babylon extends GameSearchαβ {

    @Override
    public boolean drawnPosition(Position p) {
        return possibleMoves(p, true) == null || possibleMoves(p, false) == null;
    }

    @Override
    public boolean wonPosition(Position p, boolean player) {
        return possibleMoves(p, player) == null;
    }

    @Override
    public float positionEvaluation(Position p, boolean player) {
        float base = 1.0f;
        if (player) {
            base += 0.4f;
        }
        if (!player) {
            base -= 0.4f;
        }
        float ret = (base - 1.0f);
        if (wonPosition(p, player)) {
            return base + 1.0f;
        }
        if (wonPosition(p, !player)) {
            return -(base + 1.0f);
        }
        return ret;
    }

    @Override
    public void printPosition(Position p) {
        BabylonαβPosition pos = (BabylonαβPosition) p;
        pos.print();
    }

    @Override
    public Position[] possibleMoves(Position p, boolean player) {

        BabylonαβPosition pos = (BabylonαβPosition) p;
        if (pos == null) {
            return null;
        }

        ArrayList<Position> positions = new ArrayList<>();

        ArrayList<Brique> briquesTop = new ArrayList<>();

        for (int i = 0; i < pos.briques.length; i++) {

            for (int j = 0; j < pos.briques[i].length; j++) {

                pos.briques[i][j].setTop(false);

            }

        }

        for (int i = 0; i < pos.briques.length; i++) {

            for (int j = 0; j < pos.briques[i].length; j++) {
                if (!pos.briques[j][i].getColor().getName().equals("BLANK")) {
                    pos.briques[j][i].setTop(true);
                    briquesTop.add(pos.briques[j][i]);
                    break;
                }
            }

        }

        Brique[] brique = null;

        if (!briquesTop.isEmpty()) {
            brique = new Brique[briquesTop.size()];
            brique = briquesTop.toArray(brique);
        }

        if (brique == null) {
            return null;
        }

        for (int i = 0; i < brique.length; i++) {

            for (int j = 0; j < brique.length; j++) {

                if (i != j && !brique[i].getColor().getName().equals("BLANK")) {
                    if (brique[i].getLocation().getX() == brique[j].getLocation().getX()
                            && brique[j].getLocation().getX() != 0) {
                        try {
                            Brique destination = (Brique) brique[j].clone();
                            destination.getLocation().setX(destination.getLocation().getX() - 1);
                            positions.add(new BabylonαβPosition(moveBrique((BabylonαβPosition) pos.clone(), brique[i], destination)));
                        } catch (CloneNotSupportedException ex) {
                            System.out.println(ex);
                        }
                    } else if (brique[i].getColor().getName().equals(brique[j].getColor().getName())
                            && brique[i].getLocation().getX() > brique[j].getLocation().getX()) {
                        try {
                            Brique destination = (Brique) brique[j].clone();
                            destination.getLocation().setX(destination.getLocation().getX() - 1);
                            positions.add(new BabylonαβPosition(moveBrique((BabylonαβPosition) pos.clone(), brique[i], destination)));
                        } catch (CloneNotSupportedException ex) {
                            System.out.println(ex);
                        }
                    }
                }

            }
        }

        if (!positions.isEmpty()) {
            Position[] poses = new Position[positions.size()];
            poses = positions.toArray(poses);

            return poses;
        } else {
            return null;
        }

    }

    @Override
    public Position makeMove(Position p, boolean player, Move move) {

        BabylonαβPosition pos = (BabylonαβPosition) p;

        BabylonMove m = (BabylonMove) move;

        return new BabylonαβPosition(moveBrique(pos, m.brique, new Brique(m.to, new Color())));

    }

    @Override
    public boolean reachedMaxDepth(Position p, int depth) {
        boolean ret = false;
        if (depth >= 2) {
            ret = true;
        } else if (wonPosition(p, false)) {
            ret = true;
        } else if (wonPosition(p, true)) {
            ret = true;
        } else if (drawnPosition(p)) {
            ret = true;
        }
        if (GameSearchαβ.DEBUG) {
            System.out.println("reachedMaxDepth: pos=" + p.toString() + ", depth=" + depth
                    + ", ret=" + ret);
        }
        return ret;
    }

    public static boolean play = false;

    @Override
    public Move createMove(Position startingPosition) {
        if (GameSearchαβ.DEBUG) {
            System.out.println("Enter blank square index [0,8]:");
        }

        BabylonαβPosition pos = (BabylonαβPosition) startingPosition;

        BabylonMove mm = new BabylonMove();

        while (!play) {
            try {
                if (GameJFrameαβ.aide == true) {
                    return null;
                } else if (GameJFrameαβ.isGameRestarted()) {
                    GameSearchαβ.DonotPlay = true;
                    int x = 0;
                    int y = 0;
                    mm.to = new Location(x, y);
                    return mm;
                }
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        int i = GameJFrameαβ.firstClick.getX();
        int j = GameJFrameαβ.firstClick.getY();

        System.out.println("Fisrt deplacement i=" + i + " j=" + j);
        String color = pos.briques[i][j].getColor().getName();

        mm.brique = new Brique(new Location(i, j), new Color(color));

        int x = GameJFrameαβ.secondClick.getX();
        int y = GameJFrameαβ.secondClick.getY();

        mm.to = new Location(x, y);

        Babylon.play = false;
        printPosition(startingPosition);
        return mm;
    }

    private Brique[][] moveBrique(BabylonαβPosition pos, Brique from, Brique to) {

        BabylonαβPosition p = new BabylonαβPosition(pos.briques.clone());

        String color = from.getColor().getName();

        Brique[][] b = new Brique[12][12];

        b = p.briques.clone();

        b[from.getLocation().getX()][from.getLocation().getY()].getColor().setName("BLANK");

        b[from.getLocation().getX()][from.getLocation().getY()].setTop(false);

        b[to.getLocation().getX()][to.getLocation().getY()].getColor().setName(color);

        b[to.getLocation().getX()][to.getLocation().getY()].setTop(true);

        return b;
    }

}
