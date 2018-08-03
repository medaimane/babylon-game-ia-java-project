package algorithms;

import models.Color;
import models.Brique;
import models.Location;
import models.Move;
import models.Position;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author medaimane
 */
public class BabylonMinMaxPosition extends Position implements Serializable {

    public Brique[][] briques;

    public BabylonMinMaxPosition() {
        briques = new Brique[12][12];
        for (int i = 0; i < briques.length; i++) {
            for (int j = 0; j < briques[i].length; j++) {
                briques[i][j] = new Brique(new Location(i, j), new Color("BLANK"));
            }
        }

        briques[briques.length - 1][0].getColor().setName("RED");
        briques[briques.length - 1][0].setTop(true);
        briques[briques.length - 1][1].getColor().setName("RED");
        briques[briques.length - 1][1].setTop(false);
        briques[briques.length - 1][2].getColor().setName("RED");
        briques[briques.length - 1][2].setTop(true);
        briques[briques.length - 1][3].getColor().setName("BLUE");
        briques[briques.length - 1][3].setTop(true);
        briques[briques.length - 1][4].getColor().setName("BLUE");
        briques[briques.length - 1][4].setTop(true);
        briques[briques.length - 1][5].getColor().setName("BLUE");
        briques[briques.length - 1][5].setTop(true);
        briques[briques.length - 1][6].getColor().setName("YELLOW");
        briques[briques.length - 1][6].setTop(true);
        briques[briques.length - 1][7].getColor().setName("YELLOW");
        briques[briques.length - 1][7].setTop(true);
        briques[briques.length - 1][8].getColor().setName("YELLOW");
        briques[briques.length - 1][8].setTop(true);
        briques[briques.length - 1][9].getColor().setName("GREEN");
        briques[briques.length - 1][9].setTop(true);
        briques[briques.length - 1][10].getColor().setName("GREEN");
        briques[briques.length - 1][10].setTop(true);
        briques[briques.length - 1][11].getColor().setName("GREEN");
        briques[briques.length - 1][11].setTop(true);
    }

    public BabylonMinMaxPosition(Brique[][] board) {
        this.briques = board;
    }

    public Brique[] getTops() {
        ArrayList<Brique> pos = new ArrayList<>();

        for (int i = 0; i < briques.length; i++) {
            for (int j = 0; j < briques[i].length; j++) {
                if (briques[i][j].isTop()) {
                    pos.add(briques[i][j]);
                }
            }
        }

        if (!pos.isEmpty()) {
            Brique[] Briques = new Brique[pos.size()];
            Briques = pos.toArray(Briques);
            return Briques;
        } else {
            return null;
        }
    }

    public boolean win() {
        return getAvailableStates() == null;
    }

    public List<BabylonMinMaxPosition> getAvailableStates() {
        BabylonMinMaxPosition pos = this;
        ArrayList<BabylonMinMaxPosition> positions = new ArrayList<>();
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
                            positions.add(new BabylonMinMaxPosition(moveE((BabylonMinMaxPosition) pos.clone(), brique[i], brique[j])));
                        } catch (CloneNotSupportedException ex) {
                            System.out.println(ex);
                        }
                    } else if (brique[i].getColor().getName().equals(brique[j].getColor().getName())
                            && brique[i].getLocation().getX() > brique[j].getLocation().getX()) {
                        try {
                            positions.add(new BabylonMinMaxPosition(moveE((BabylonMinMaxPosition) pos.clone(), brique[i], brique[j])));
                        } catch (CloneNotSupportedException ex) {
                            System.out.println(ex);
                        }
                    }
                }

            }
        }

        if (!positions.isEmpty()) {
            return positions;
        } else {
            return null;
        }
    }

    public BabylonMinMaxPosition move(BabylonMinMaxPosition p, boolean player, Move move) {
        BabylonMinMaxPosition pos = p;
        BabylonMove m = (BabylonMove) move;
        return new BabylonMinMaxPosition(moveEx(pos, m.brique, new Brique(m.to, new Color())));
    }

    private Brique[][] moveE(BabylonMinMaxPosition pos, Brique from, Brique to) {

        BabylonMinMaxPosition p = new BabylonMinMaxPosition(pos.briques.clone());

        String color = from.getColor().getName();

        Brique[][] b = new Brique[12][12];

        b = p.briques.clone();

        b[from.getLocation().getX()][from.getLocation().getY()].getColor().setName("BLANK");

        b[from.getLocation().getX()][from.getLocation().getY()].setTop(false);

        b[to.getLocation().getX() - 1][to.getLocation().getY()].getColor().setName(color);

        b[to.getLocation().getX() - 1][to.getLocation().getY()].setTop(true);

        return b;
    }

    private Brique[][] moveEx(BabylonMinMaxPosition pos, Brique from, Brique to) {

        BabylonMinMaxPosition p = new BabylonMinMaxPosition(pos.briques.clone());

        String color = from.getColor().getName();

        Brique[][] b = new Brique[12][12];

        b = p.briques.clone();

        b[from.getLocation().getX()][from.getLocation().getY()].getColor().setName("BLANK");

        b[from.getLocation().getX()][from.getLocation().getY()].setTop(false);

        b[to.getLocation().getX()][to.getLocation().getY()].getColor().setName(color);

        b[to.getLocation().getX()][to.getLocation().getY()].setTop(true);

        return b;
    }

    public void placeAMove(BabylonMinMaxPosition point) {
        this.briques = point.briques;
    }

    public static boolean play = false;

    public Move createMove(Position startingPosition) {
        BabylonMinMaxPosition pos = (BabylonMinMaxPosition) startingPosition;

        BabylonMove mm = new BabylonMove();

        while (!play) {
            try {
                if (GameJFrameMinMax.aide == true) {
                    return null;
                } else if (GameJFrameMinMax.isGameRestarted()) {
                    GameSearchMinMax.DonotPlay = true;
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
        int i = GameJFrameMinMax.firstClick.getX();
        int j = GameJFrameMinMax.firstClick.getY();

        System.out.println("Fisrt deplacement i=" + i + " j=" + j);
        String color = pos.briques[i][j].getColor().getName();

        mm.brique = new Brique(new Location(i, j), new Color(color));

        int x = GameJFrameMinMax.secondClick.getX();
        int y = GameJFrameMinMax.secondClick.getY();

        mm.to = new Location(x, y);

        play = false;
        print();
        return mm;
    }

    public void print() {
        for (Brique[] brique : briques) {
            for (Brique brique1 : brique) {
                String caractere;
                switch (brique1.getColor().getName()) {
                    case "BLANK":
                        caractere = " * ";
                        break;
                    case "RED":
                        caractere = " R ";
                        break;
                    case "BLUE":
                        caractere = " B ";
                        break;
                    case "YELLOW":
                        caractere = " Y ";
                        break;
                    case "GREEN":
                        caractere = " G ";
                        break;
                    default:
                        caractere = "   ";
                        break;
                }
                System.out.print(caractere + " ");
            }
            System.out.println("");
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        BabylonMinMaxPosition p = new BabylonMinMaxPosition();
        for (int i = 0; i < briques.length; i++) {

            for (int j = 0; j < briques[i].length; j++) {

                int x = this.briques[i][j].getLocation().getX();
                int y = this.briques[i][j].getLocation().getY();
                String color = this.briques[i][j].getColor().getName();

                p.briques[i][j] = new Brique(new Location(x, y), new Color(color));

            }

        }
        return p;
    }
}
