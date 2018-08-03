package algorithms;

import models.Color;
import models.Brique;
import models.Location;
import models.Position;
import java.io.Serializable;

/**
 *
 * @author medaimane
 */
public class BabylonαβPosition extends Position implements Cloneable, Serializable {

    private static final long serialVersionUID = 9127758009562326281L;

    public Brique[][] briques;

    public BabylonαβPosition() {
        briques = new Brique[12][12];
        for (int i = 0; i < briques.length; i++) {
            for (int j = 0; j < briques[i].length; j++) {
                briques[i][j] = new Brique(new Location(i, j), new Color("BLANK"));
            }
        }
        briques[briques.length - 1][0].getColor().setName("RED");
        briques[briques.length - 1][0].setTop(true);
        briques[briques.length - 1][1].getColor().setName("RED");
        briques[briques.length - 1][1].setTop(true);
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

    /**
     *
     * @param briques
     */
    public BabylonαβPosition(Brique[][] briques) {
        this.briques = briques;
    }

    public void print() {
        for (int i = 0; i < briques.length; i++) {
            for (int j = 0; j < briques[i].length; j++) {
                String caractere;
                switch (briques[i][j].getColor().getName()) {
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

    /**
     *
     * @return @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        BabylonαβPosition p = new BabylonαβPosition();
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
