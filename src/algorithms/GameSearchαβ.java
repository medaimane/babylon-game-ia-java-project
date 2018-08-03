package algorithms;

import models.Move;
import models.Position;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JOptionPane;
import serialize.Identify;


/**
 *
 * @author medaimane
 */
public abstract class GameSearchαβ {

    public static final boolean DEBUG = false;

    public static boolean PROGRAM = false;
    public static boolean HUMAN = true;

    public static boolean DonotPlay = false;

    private static boolean computerPlay = true;

    public abstract boolean drawnPosition(Position p);

    public abstract boolean wonPosition(Position p, boolean player);

    public abstract float positionEvaluation(Position p, boolean player);

    public abstract void printPosition(Position p);

    public abstract Position[] possibleMoves(Position p, boolean player);

    public abstract Position makeMove(Position p, boolean player, Move move);

    public abstract boolean reachedMaxDepth(Position p, int depth);

    public abstract Move createMove(Position startingPosition);

    protected Vector alphaBeta(int depth, Position p, boolean player) {
        Vector v = alphaBetaHelper(depth, p, player, 1000000.0f, -1000000.0f);
        System.out.println("^^ v(0): " + v.elementAt(0) + ", v(1): " + v.elementAt(1));
        return v;
    }

    protected Vector alphaBetaHelper(int depth, Position p, boolean player, float alpha, float beta) {
        if (GameSearchαβ.DEBUG) {
            System.out.println("alphaBetaHelper(" + depth + "," + p + "," + alpha + "," + beta + ")");
        }
        if (reachedMaxDepth(p, depth)) {
            Vector v = new Vector(2);
            float value = positionEvaluation(p, player);
            v.addElement(new Float(value));
            v.addElement(null);
            if (GameSearchαβ.DEBUG) {
                System.out.println(" alphaBetaHelper: mx depth at " + depth
                        + ", value=" + value);
            }
            return v;
        }
        Vector best = new Vector();
        Position[] moves = possibleMoves(p, player);
        for (int i = 0; i < moves.length; i++) {
            Vector v2 = alphaBetaHelper(depth + 1, moves[i], !player, -beta, -alpha);
            //if (v2 == null || v2.size() < 1) continue; 
            float value = -((Float) v2.elementAt(0)).floatValue();
            if (value > beta) {
                if (GameSearchαβ.DEBUG) {
                    System.out.println(" ! ! ! value=" + value + ", beta=" + beta);
                }
                beta = value;
                best = new Vector();
                best.addElement(moves[i]);
                Enumeration enum2 = v2.elements();
                enum2.nextElement(); // skip previous value
                while (enum2.hasMoreElements()) {
                    Object o = enum2.nextElement();
                    if (o != null) {
                        best.addElement(o);
                    }
                }
            }
            /**
             * Use the alpha-beta cutoff test to abort search if we found a move
             * that proves that the previous move in the move chain was dubious
             */
            if (beta >= alpha) {
                break;
            }
        }
        Vector v3 = new Vector();
        v3.addElement(new Float(beta));
        Enumeration enum2 = best.elements();
        while (enum2.hasMoreElements()) {
            v3.addElement(enum2.nextElement());
        }
        return v3;
    }
    
    GameJFrameαβ ui;
    
    public void playGame(Identify id, boolean newgame) throws IOException {
        
        boolean playerVsplayer = id.getTypemode().equalsIgnoreCase("player-vs-player");
        
        if (id.isPlayerOrder() == false && newgame == false && playerVsplayer == false) {
            ui = new GameJFrameαβ();

            if (id.getTotalNumOfAides() == 0) {
                GameJFrameαβ.getHelpjButton.setEnabled(false);
            }
            // computer playes after restored game
            if (!ui.isAide()) {
                ui.reffresh((BabylonαβPosition) id.getPosition());
                printPosition(id.getPosition());
                id.setPosition(Computer(id.getPosition()));
                ui.reffresh((BabylonαβPosition) id.getPosition());
                ui.setStartingPosition(id.getPosition());
            }

        } else if (id.isPlayerOrder() == false && newgame == true && playerVsplayer == false) {
            ui = new GameJFrameαβ();

            //computer playes after new game
            ui.reffresh((BabylonαβPosition) id.getPosition());
            printPosition(id.getPosition());
            id.setPosition(Computer(id.getPosition()));
            ui.reffresh((BabylonαβPosition) id.getPosition());
            ui.setStartingPosition(id.getPosition());
        } else if (playerVsplayer == true) {
            ui = new GameJFrameαβ(true);
        } else {
            ui = new GameJFrameαβ();
        }

        while (true) {
            if (id.getPosition() != null) {
                if (!ui.isAide()) {
                    printPosition(id.getPosition());
                    ui.reffresh((BabylonαβPosition) id.getPosition());
                    ui.setStartingPosition(id.getPosition());
                }
                if (ui.isAide()) {
                    JOptionPane.showMessageDialog(null, "YOU HAVE : "+id.getTotalNumOfAides()+" COMPUTER HELP!");
                    id.setPosition(Computer(id.getPosition()));
                    printPosition(id.getPosition());
                    ui.reffresh((BabylonαβPosition) id.getPosition());
                    ui.setStartingPosition(id.getPosition());
                    ui.setAide(false);
                }
            }
            if (playerVsplayer && wonPosition(id.getPosition(), HUMAN)) {
                JOptionPane.showMessageDialog(null, "Player 2 WON!");
                GameJFrameαβ.restartjButton.doClick();
                break;
            } else {
                if (wonPosition(id.getPosition(), PROGRAM)) {
                    JOptionPane.showMessageDialog(null, "PROGRAM WON!");
                    GameJFrameαβ.restartjButton.doClick();
                    break;
                }
            }

            /*
            
                HUMAIN TURN
            
             */
            if (playerVsplayer) {
                if (id.getPlayer1aide() == 0) {
                    GameJFrameαβ.getHelpjButton.setEnabled(false);
                } else {
                    GameJFrameαβ.getHelpjButton.setEnabled(true);
                }
                JOptionPane.showMessageDialog(null, "Player 1 Turn");
                id = (Humain(id, 1));
            } else {
                JOptionPane.showMessageDialog(null, "YOUR TURN");
                id = (Humain(id, 0));
            }

            printPosition(id.getPosition());
            ui.reffresh((BabylonαβPosition) id.getPosition());
            ui.setStartingPosition(id.getPosition());
            if (playerVsplayer && wonPosition(id.getPosition(), HUMAN)) {
                JOptionPane.showMessageDialog(null, "Player 1 WON!");
                GameJFrameαβ.restartjButton.doClick();
                break;
            } else {
                if (wonPosition(id.getPosition(), HUMAN)) {
                    JOptionPane.showMessageDialog(null, "Player WON!");
                    GameJFrameαβ.restartjButton.doClick();
                    break;
                }
            }
            /*
            
                COMPUTER TURN
            
             */
            if (playerVsplayer) {
                if (id.getPlayer2aide() == 0) {
                    GameJFrameαβ.getHelpjButton.setEnabled(false);
                } else {
                    GameJFrameαβ.getHelpjButton.setEnabled(true);
                }
                JOptionPane.showMessageDialog(null, "Player 2 Turn");
                id = Humain(id, 2);
                printPosition(id.getPosition());
                ui.reffresh((BabylonαβPosition) id.getPosition());
                ui.setStartingPosition(id.getPosition());
            } else {
                JOptionPane.showMessageDialog(null, "COMPUTER TURN");
                id.setPosition(Computer(id.getPosition()));
                ui.setStartingPosition(id.getPosition());
            }
        }
    }

    private Position Computer(Position startingPosition) {
        Vector v = alphaBeta(0, startingPosition, PROGRAM);
        Enumeration enum2 = v.elements();
        while (enum2.hasMoreElements()) {
            System.out.println(" next element: " + enum2.nextElement());
        }

        return (Position) v.elementAt(1);
    }
    
    private Identify Humain(Identify id, Integer player) {
        Move move = createMove(id.getPosition());
        if (move == null) {
            GameJFrameαβ.aide = false;
            id.setPosition(Computer(id.getPosition()));
            if (player == 1) {
                int i = id.getPlayer1aide();
                i--;
                id.setPlayer1aide(i);
            } else if (player == 2) {
                int i = id.getPlayer2aide();
                i--;
                id.setPlayer2aide(i);
            }
        } else if (DonotPlay) {
            DonotPlay = false;
            GameJFrameαβ.setGameRestarted(false);
            //BabylonPosition restartposition = new BabylonαβPosition();
            id.setPosition(new BabylonαβPosition());
            computerPlay = false;
            return id;

        } else {
            id.setPosition(makeMove(id.getPosition(), HUMAN, move));
        }
        return id;
    }
}
