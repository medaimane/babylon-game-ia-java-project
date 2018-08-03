package algorithms;

import interfaces.StartGameFrame;
import java.awt.Container;
import models.Color;
import models.Brique;
import models.Location;
import models.Position;
import models.Pic;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import serialize.Session;

/**
 *
 * @author medaimane
 */
public class GameJFrameMinMax extends javax.swing.JFrame {

    public static Session session;
    
    private Container game;
    
    private Pic[][] squares = new Pic[12][12];

    public static Location firstClick = new Location();
    public static Location secondClick = new Location();

    private BabylonMove move;
    private BabylonMinMaxPosition p;

    private Position startingPosition;

    public static boolean buttonOneClicked = false;

    private boolean isAide = false;

    public static boolean aide = false;
    public static boolean Multiplayer;

    private static boolean GameRestarted = false;
    
    public GameJFrameMinMax() {
        initComponents();
        this.setInit();
    }

    public GameJFrameMinMax(boolean Multiplayer) {
        initComponents();
        this.setInit();
        GameJFrameMinMax.Multiplayer = Multiplayer;
    }

    private void setInit() {

        isAide = false;
        
        sessionjLabel.setText(session.getId().getNameSession());
        modejLabel.setText(session.getId().getTypemode());
        algojLabel.setText(session.getId().getTypeAlgo());

        deselectedjButton.setEnabled(false);
        
        game = jInternalFrame2.getContentPane();
        game.setLayout(new GridLayout(13, 13));

        p = new BabylonMinMaxPosition();

        for (int i = 0; i < p.briques.length; i++) {
            for (int j = 0; j < p.briques[i].length; j++) {

                squares[i][j] = new Pic();

                String name = p.briques[i][j].getColor().getName();
                switch (name) {
                    case "BLANK":
                        squares[i][j].setBackground(savejButton.getBackground());
                        break;
                    case "RED":
                        squares[i][j].setBackground(restartjButton.getBackground());
                        break;
                    case "BLUE":
                        squares[i][j].setBackground(jPanel2.getBackground());
                        break;
                    case "YELLOW":
                        squares[i][j].setBackground(deselectedjButton.getBackground());
                        break;
                    case "GREEN":
                        squares[i][j].setBackground(jPanel1.getBackground());
                        break;
                    default:
                        squares[i][j].setBackground(java.awt.Color.WHITE);
                        break;
                }
                squares[i][j].setLocation(new Location(i, j));

                squares[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent me) {
                        Pic tile = (Pic) me.getSource();
                        makeMove(tile.getLocal().getX(), tile.getLocal().getY());
                    }
                });

                squares[i][j].addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent ke) {
                        if (ke.getKeyCode() == KeyEvent.VK_S) {
                            buttonOneClicked = false;
                            deselectedjButton.setEnabled(false);
                        }
                    }
                });
                game.add(squares[i][j]);
            }

            move = new BabylonMove();
        }
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        
    }

    public void reffresh(BabylonMinMaxPosition p) {
        isAide = false;
        
        
        game.removeAll();
        game = jInternalFrame2.getContentPane();
        game.setLayout(new GridLayout(13, 13));
        
        this.p = p;
        for (int i = 0; i < this.p.briques.length; i++) {
            for (int j = 0; j < this.p.briques[i].length; j++) {
                String name = this.p.briques[i][j].getColor().getName();
                switch (name) {
                    case "BLANK":
                        squares[i][j].setBackground(savejButton.getBackground());
                        break;
                    case "RED":
                        squares[i][j].setBackground(restartjButton.getBackground());
                        break;
                    case "BLUE":
                        squares[i][j].setBackground(jPanel2.getBackground());
                        break;
                    case "YELLOW":
                        squares[i][j].setBackground(deselectedjButton.getBackground());
                        break;
                    case "GREEN":
                        squares[i][j].setBackground(jPanel1.getBackground());
                        break;
                    default:
                        squares[i][j].setBackground(java.awt.Color.WHITE);
                        break;
                }
                game.add(squares[i][j]);
            }
        }
        game.revalidate();
        game.repaint();
    }

    public Location getFirstClick() {
        return firstClick;
    }

    public void setFirstClick(Location firstClick) {
        GameJFrameMinMax.firstClick = firstClick;
    }

    public Location getSecondClick() {
        return secondClick;
    }

    public void setSecondClick(Location secondClick) {
        GameJFrameMinMax.secondClick = secondClick;
    }
    
    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        GameJFrameαβ.session = session;
    }

    synchronized public void makeMove(int i, int j) {
        if (isValidMove(i, j)) {
            if (buttonOneClicked == false) {
                System.out.println("FIRST CLICK");
                String color;
                if (squares[i][j].getBackground().equals(savejButton.getBackground())) {
                    color = "BLANK";
                } else if (squares[i][j].getBackground().equals(restartjButton.getBackground())) {
                    color = "RED";
                } else if (squares[i][j].getBackground().equals(jPanel2.getBackground())) {
                    color = "BLUE";
                } else if (squares[i][j].getBackground().equals(deselectedjButton.getBackground())) {
                    color = "YELLOW";
                } else if (squares[i][j].getBackground().equals(jPanel1.getBackground())) {
                    color = "GREEN";
                } else {
                    color = "BLANK";
                }
                firstClick.setX(i);
                firstClick.setY(j);
                System.out.println(firstClick);
                move.brique = new Brique(new Location(i, j), new Color(color));
                buttonOneClicked = true;
                deselectedjButton.setEnabled(true);
            } else {
                System.out.println("SECONDE CLICK");
                move.to = new Location(i, j);
                String name = move.brique.getColor().getName();
                switch (name) {
                    case "BLANK":
                        squares[i][j].setBackground(savejButton.getBackground());
                        break;
                    case "RED":
                        squares[i][j].setBackground(restartjButton.getBackground());
                        break;
                    case "BLUE":
                        squares[i][j].setBackground(jPanel2.getBackground());
                        break;
                    case "YELLOW":
                        squares[i][j].setBackground(deselectedjButton.getBackground());
                        break;
                    case "GREEN":
                        squares[i][j].setBackground(jPanel1.getBackground());
                        break;
                    default:
                        squares[i][j].setBackground(java.awt.Color.WHITE);
                        break;
                }
                int x = move.brique.getLocation().getX();
                int y = move.brique.getLocation().getY();
                squares[x][y].setBackground(java.awt.Color.WHITE);

                secondClick.setX(i);
                secondClick.setY(j);
                buttonOneClicked = false;
                deselectedjButton.setEnabled(false);
                System.out.println("" + secondClick);
                BabylonMinMaxPosition.play = true;
            }
        }
    }

    private boolean isValidMove(int i, int j) {

        if (buttonOneClicked == false && p.briques[i][j].isTop()) {
            return !p.briques[i][j].getColor().getName().equals("BLANK");
        }

        if (buttonOneClicked == true) {
            if (p.briques[i - 1][j].isTop()) {
                return false;
            }
            if (p.briques[firstClick.getX()][firstClick.getY()].getLocation().getX() == p.briques[i][j].getLocation().getX()
                    && p.briques[firstClick.getX()][firstClick.getY()].getLocation().getY() == p.briques[i][j].getLocation().getY()) {
                return false;
            }
            if (p.briques[firstClick.getX()][firstClick.getY()].getLocation().getX() == p.briques[i][j].getLocation().getX() + 1
                    && p.briques[firstClick.getX()][firstClick.getY()].getLocation().getY() == p.briques[i][j].getLocation().getY()) {
                return false;
            }

            if ((p.briques[i][j].getColor().getName().equals("BLANK")) && firstClick.getX() - 1 == i) {
                return true;
            }

            if (i < 11 && p.briques[firstClick.getX()][firstClick.getY()].getColor().getName().equals(p.briques[i + 1][j].getColor().getName())) {
                return true;
            }

        }
        return false;
    }

    public Position getStartingPosition() {
        return startingPosition;
    }

    public void setStartingPosition(Position startingPosition) {
        this.startingPosition = startingPosition;
    }

    public boolean isAide() {
        return this.isAide;
    }

    public void setAide(boolean isAide) {
        this.isAide = isAide;
    }

    static void setGameRestarted(boolean gameRefreshed) {
        GameRestarted = gameRefreshed;
    }

    public static boolean isGameRestarted() {
        return GameRestarted;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gamePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        restartjButton = new javax.swing.JButton();
        getHelpjButton = new javax.swing.JButton();
        deselectedjButton = new javax.swing.JButton();
        savejButton = new javax.swing.JButton();
        returnejButton = new javax.swing.JButton();
        exitjButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jCheckBox1 = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        algojLabel = new javax.swing.JLabel();
        modejLabel = new javax.swing.JLabel();
        sessionjLabel = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        gamePanel.setBackground(new java.awt.Color(0, 0, 51));

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(627, 437));

        jPanel3.setPreferredSize(new java.awt.Dimension(459, 50));

        jInternalFrame2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jInternalFrame2.setTitle("Play Babylon");
        jInternalFrame2.setMinimumSize(new java.awt.Dimension(435, 26));
        jInternalFrame2.setPreferredSize(new java.awt.Dimension(435, 26));
        jInternalFrame2.setVisible(true);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, 429, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));

        restartjButton.setBackground(new java.awt.Color(0, 153, 255));
        restartjButton.setForeground(new java.awt.Color(255, 255, 255));
        restartjButton.setText("Restart");
        restartjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartjButtonActionPerformed(evt);
            }
        });

        getHelpjButton.setBackground(new java.awt.Color(51, 51, 255));
        getHelpjButton.setForeground(new java.awt.Color(255, 255, 255));
        getHelpjButton.setText("Get Help");
        getHelpjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getHelpjButtonActionPerformed(evt);
            }
        });

        deselectedjButton.setBackground(new java.awt.Color(51, 51, 255));
        deselectedjButton.setForeground(new java.awt.Color(255, 255, 255));
        deselectedjButton.setText("Deselected");
        deselectedjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deselectedjButtonActionPerformed(evt);
            }
        });

        savejButton.setBackground(new java.awt.Color(255, 255, 204));
        savejButton.setText("Save");
        savejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savejButtonActionPerformed(evt);
            }
        });

        returnejButton.setBackground(new java.awt.Color(255, 255, 204));
        returnejButton.setText("Return");
        returnejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnejButtonActionPerformed(evt);
            }
        });

        exitjButton.setBackground(new java.awt.Color(255, 255, 204));
        exitjButton.setText("Exit");
        exitjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitjButtonActionPerformed(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(51, 0, 51));
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Auto save");

        algojLabel.setForeground(new java.awt.Color(255, 255, 255));
        algojLabel.setText("Algo :");

        modejLabel.setForeground(new java.awt.Color(255, 255, 255));
        modejLabel.setText("Mode :");

        sessionjLabel.setForeground(new java.awt.Color(255, 255, 255));
        sessionjLabel.setText("Session :");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Babylon");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sessionjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(savejButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deselectedjButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(getHelpjButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(restartjButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(algojLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modejLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(returnejButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitjButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sessionjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modejLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(algojLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(restartjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getHelpjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deselectedjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(savejButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(returnejButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitjButton)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deselectedjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deselectedjButtonActionPerformed
        if (buttonOneClicked = true) {
            buttonOneClicked = false;
            deselectedjButton.setEnabled(false);
        }
    }//GEN-LAST:event_deselectedjButtonActionPerformed

    private void getHelpjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getHelpjButtonActionPerformed
        this.isAide = true;
        aide = true;
        int i = session.getId().getTotalNumOfAides();
        i--;
        session.getId().setTotalNumOfAides(i);

        if (!Multiplayer) {
            if (session.getId().getTotalNumOfAides() == 0) {
                getHelpjButton.setEnabled(false);
            }
        }
    }//GEN-LAST:event_getHelpjButtonActionPerformed

    private void savejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savejButtonActionPerformed
        if (session.getId().getPosition() != null) {
            session.saveSession();
            JOptionPane.showMessageDialog(null, "Saved Session In Min Max Frame : " + session.getId().getNameSession());
        }
    }//GEN-LAST:event_savejButtonActionPerformed

    private void exitjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitjButtonActionPerformed
        int confirmation = JOptionPane.showConfirmDialog(null, "Exit!", "Confirmation", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (confirmation == JOptionPane.YES_OPTION) {
            this.dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_exitjButtonActionPerformed

    private void restartjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartjButtonActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Restart?", "Confirmation", dialogButton);
        if (dialogResult == dialogButton) {
            setGameRestarted(true);
            getHelpjButton.setEnabled(true);
            session.getId().setTotalNumOfAides(2);
            session.getId().setPlayer1aide(2);
            session.getId().setPlayer2aide(2);
            this.reffresh(p);
        }
    }//GEN-LAST:event_restartjButtonActionPerformed

    private void returnejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnejButtonActionPerformed
        StartGameFrame start = new StartGameFrame();
        this.dispose();
        start.setVisible(true);
    }//GEN-LAST:event_returnejButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel algojLabel;
    private javax.swing.JButton deselectedjButton;
    private javax.swing.JButton exitjButton;
    private javax.swing.JPanel gamePanel;
    public static javax.swing.JButton getHelpjButton;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel modejLabel;
    public static javax.swing.JButton restartjButton;
    private javax.swing.JButton returnejButton;
    private javax.swing.JButton savejButton;
    private javax.swing.JLabel sessionjLabel;
    // End of variables declaration//GEN-END:variables
}
