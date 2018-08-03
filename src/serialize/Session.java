package serialize;

import algorithms.Babylon;
import algorithms.BabylonαβPosition;
import algorithms.BabylonMinMaxPosition;
import algorithms.GameSearchMinMax;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author medaimane
 */
public class Session {

    Identify id;

    public Session() {
        this.id = new Identify();
    }

    public Session(Identify id) {
        this.id = id;
    }

    public void startSession() throws IOException {
        if (id.getTypeAlgo().equals("MinMax")) {
            id.setPosition(new BabylonMinMaxPosition());
            GameSearchMinMax ttt = new GameSearchMinMax(); //MinMax
            ttt.playGame(id, true);
            System.out.println("start minmax" + id.toString());

        } else {
            id.setPosition(new BabylonαβPosition());
            Babylon ttt = new Babylon(); //alphaBeta
            ttt.playGame(id, true);
            System.out.println("start else" + id.toString());
        }
    }

    public void saveSession() {
        System.out.println("save" + id.toString());
        try {
            try (FileOutputStream fileOut = new FileOutputStream("data/" + id.getNameSession() + ".ser"); ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(id);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("" + ex.getMessage());
        }
    }

    public void loadSession() throws IOException {
        if (id.getTypeAlgo().equals("MinMax")) {
            GameSearchMinMax ttt = new GameSearchMinMax();
            ttt.playGame(id, false);
        } else {
            Babylon ttt = new Babylon();
            ttt.playGame(id, false);
        }
    }

    public Identify getId() {
        return id;
    }

    public void setId(Identify id) {
        this.id = id;
    }
}
