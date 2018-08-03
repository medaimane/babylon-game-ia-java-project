package algorithms;

import models.Brique;
import models.Move;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import serialize.Identify;

/**
 *
 * @author medaimane
 */
public class GameSearchMinMax {

    Brique[][] computersMove = new Brique[12][12];
    public static boolean PROGRAM = false;
    public static boolean HUMAN = true;
    Random rand = new Random();
    GameJFrameMinMax ui;
    int i = 0;

    public static boolean DonotPlay = false;

    private static boolean computerPlay = true;
    
    public int minimax(int depth, BabylonMinMaxPosition p, boolean plyer) {
        if (p.win() && plyer == false) {
            return +1;
        }
        if (p.win() && plyer == true) {
            return -1;
        }

        List<BabylonMinMaxPosition> pointsAvailable = p.getAvailableStates();
        if (pointsAvailable.isEmpty()) {
            return 0;
        }
        BabylonMinMaxPosition b = new BabylonMinMaxPosition();
        try {
            b = (BabylonMinMaxPosition) p.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println(ex.getMessage());
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < pointsAvailable.size(); ++i) {
            BabylonMinMaxPosition point = pointsAvailable.get(i);
            if (plyer == false) {
                p.placeAMove(point);
                int currentScore = minimax(depth + 1, p, true);
                max = Math.max(currentScore, max);

                if (depth == 0) {
                    System.out.println("Score for position " + (i + 1) + " = " + currentScore);
                }
                if (currentScore >= 0) {
                    if (depth == 0) {
                        computersMove = point.briques;
                    }
                }
                if (currentScore == 1) {
                    p.briques = b.briques;
                    break;
                }
                if (i == pointsAvailable.size() - 1 && max < 0) {
                    if (depth == 0) {
                        computersMove = point.briques;
                    }
                }
            } else if (plyer == true) {
                p.placeAMove(point);
                int currentScore = minimax(depth + 1, p, false);
                min = Math.min(currentScore, min);
                if (min == -1) {
                    p.briques = b.briques;
                    break;
                }
            }
            p.briques = b.briques;
        }
        return plyer == false ? max : min;
    }
    
    
    /*Game play*/
    public void playGame(Identify id, boolean newgame) {

        boolean playerVsplayer = id.getTypemode().equalsIgnoreCase("player-vs-player");

        if (id.isPlayerOrder() == false && newgame == false && playerVsplayer == false) {
            ui = new GameJFrameMinMax();

            if (id.getTotalNumOfAides() == 0) {
                GameJFrameMinMax.getHelpjButton.setEnabled(false);
            }
            // computer playes after restored game
            if (!ui.isAide()) {
                ui.reffresh((BabylonMinMaxPosition) id.getPosition());
                ((BabylonMinMaxPosition) id.getPosition()).print();
                id.setPosition(Computer((BabylonMinMaxPosition) id.getPosition()));
                ui.reffresh((BabylonMinMaxPosition) id.getPosition());
                ui.setStartingPosition((BabylonMinMaxPosition) id.getPosition());
            }

        } else if (id.isPlayerOrder() == false && newgame == true && playerVsplayer == false) {
            ui = new GameJFrameMinMax();

            //computer playes after new game
            ui.reffresh((BabylonMinMaxPosition) id.getPosition());
            ((BabylonMinMaxPosition) id.getPosition()).print();
            id.setPosition(Computer((BabylonMinMaxPosition) id.getPosition()));
            ui.reffresh((BabylonMinMaxPosition) id.getPosition());
            ui.setStartingPosition((BabylonMinMaxPosition) id.getPosition());
        }
        
        //!!!
        if (playerVsplayer == true) {
            ui = new GameJFrameMinMax(true);
        } else {
            ui = new GameJFrameMinMax();
        }

        while (true) {
            if (id.getPosition() != null) {
                System.out.println(""+ui.isAide());
                if (!ui.isAide()) {
                    ((BabylonMinMaxPosition) id.getPosition()).print();
                    ui.reffresh((BabylonMinMaxPosition) id.getPosition());
                    ui.setStartingPosition((BabylonMinMaxPosition) id.getPosition());
                }
                if (ui.isAide()) {
                    System.out.println("Enter to Aide");
                    JOptionPane.showMessageDialog(null, "YOU HAVE : "+id.getTotalNumOfAides()+" COMPUTER HELP!");
                    id.setPosition(Computer((BabylonMinMaxPosition) id.getPosition()));
                    ((BabylonMinMaxPosition) id.getPosition()).print();
                    ui.reffresh((BabylonMinMaxPosition) id.getPosition());
                    ui.setStartingPosition((BabylonMinMaxPosition) id.getPosition());
                    ui.setAide(false);
                }
            }

            if (playerVsplayer && ((BabylonMinMaxPosition) id.getPosition()).win()) {
                JOptionPane.showMessageDialog(null, "Player 2 WON");
                GameJFrameMinMax.restartjButton.doClick();
                break;
            } else {
                if (((BabylonMinMaxPosition) id.getPosition()).win()) {
                    JOptionPane.showMessageDialog(null, "PROGRAM WON");
                    GameJFrameMinMax.restartjButton.doClick();
                    break;
                }
            }
            /*
            
                HUMAIN TURN
            
             */
            if (playerVsplayer) {
                JOptionPane.showMessageDialog(null, "Player 1 Turn");
                if (id.getPlayer1aide() == 0) {
                    GameJFrameMinMax.getHelpjButton.setEnabled(false);
                } else {
                    GameJFrameMinMax.getHelpjButton.setEnabled(true);
                }
                id = Humain(id, 1);
            } else {
                JOptionPane.showMessageDialog(null, "YOUR TURN");
                id = Humain(id, 0);
            }
            ((BabylonMinMaxPosition) id.getPosition()).print();
            ui.reffresh(((BabylonMinMaxPosition) id.getPosition()));
            ui.setStartingPosition(((BabylonMinMaxPosition) id.getPosition()));
            if (playerVsplayer && ((BabylonMinMaxPosition) id.getPosition()).win()) {
                JOptionPane.showMessageDialog(null, "Player 1 WON");
                break;
            } else {
                if (((BabylonMinMaxPosition) id.getPosition()).win()) {
                    JOptionPane.showMessageDialog(null, "Player 2 WON");
                    break;
                }
            }

            /*
            
                COMPUTER TURN
            
             */
            if (playerVsplayer) {
                if (id.getPlayer2aide() == 0) {
                    GameJFrameMinMax.getHelpjButton.setEnabled(false);
                } else {
                    GameJFrameMinMax.getHelpjButton.setEnabled(true);
                }
                JOptionPane.showMessageDialog(null, "Player 2 Turn");
                id = Humain(id, 2);
                ((BabylonMinMaxPosition) id.getPosition()).print();
                ui.reffresh(((BabylonMinMaxPosition) id.getPosition()));
                ui.setStartingPosition(((BabylonMinMaxPosition) id.getPosition()));
            } else {
                JOptionPane.showMessageDialog(null, "COMPUTER TURN");
                id.setPosition(Computer(((BabylonMinMaxPosition) id.getPosition())));
                ui.setStartingPosition(((BabylonMinMaxPosition) id.getPosition()));
            }

        }
    }

    private BabylonMinMaxPosition Computer(BabylonMinMaxPosition startingPosition) {
        if (i > 3) {
            minimax(0, startingPosition, PROGRAM);
            startingPosition.briques = computersMove;
        } else {
            i++;
            int size = startingPosition.getAvailableStates().size();
            startingPosition = startingPosition.getAvailableStates().get(rand.nextInt(size - 1));
            System.out.println("i : " + i);
        }
        return startingPosition;
    }
    
    public Identify Humain(Identify id, Integer player) {

        Move move = ((BabylonMinMaxPosition) id.getPosition()).createMove(((BabylonMinMaxPosition) id.getPosition()));
        if (move == null) {
            System.out.println("aide");
            id.setPosition(Computer(((BabylonMinMaxPosition) id.getPosition())));
            GameJFrameMinMax.aide = false;
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
            GameJFrameMinMax.setGameRestarted(false);
            id.setPosition(new BabylonMinMaxPosition());
            computerPlay = false;
            return id;

        } else {
            id.setPosition(((BabylonMinMaxPosition) id.getPosition()).move(((BabylonMinMaxPosition) id.getPosition()), HUMAN, move));
        }
        return id;

    }
}
