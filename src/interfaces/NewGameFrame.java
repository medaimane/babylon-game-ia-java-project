package interfaces;

import algorithms.GameJFrameαβ;
import algorithms.GameJFrameMinMax;
import java.io.IOException;

import javax.swing.JOptionPane;

import serialize.Identify;
import serialize.Session;

/**
 *
 * @author medaimane
 */
public class NewGameFrame extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    public NewGameFrame() {
        this.initComponents();
        this.setInit();
    }

    private void setInit() {
        this.setLocationRelativeTo(null);
    }

    private boolean checkData() {
        return (modebuttonGroup.isSelected(mode1jRadioButton.getModel()) || modebuttonGroup.isSelected(mode2jRadioButton.getModel()))
                && (algobuttonGroup.isSelected(algo1jRadioButton.getModel()) || algobuttonGroup.isSelected(algo2jRadioButton.getModel()))
                && (orderbuttonGroup.isSelected(order1jRadioButton.getModel()) || orderbuttonGroup.isSelected(order2jRadioButton.getModel()) || orderbuttonGroup.isSelected(order3jRadioButton.getModel()))
                && (!player1jTextField.getText().equalsIgnoreCase(""));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modebuttonGroup = new javax.swing.ButtonGroup();
        algobuttonGroup = new javax.swing.ButtonGroup();
        orderbuttonGroup = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        mode1jRadioButton = new javax.swing.JRadioButton();
        mode2jRadioButton = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        player1jTextField = new javax.swing.JTextField();
        player1jLabel = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        algo1jRadioButton = new javax.swing.JRadioButton();
        algo2jRadioButton = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        order2jRadioButton = new javax.swing.JRadioButton();
        order3jRadioButton = new javax.swing.JRadioButton();
        order1jRadioButton = new javax.swing.JRadioButton();
        navigationjPanel = new javax.swing.JPanel();
        exitjButton = new javax.swing.JButton();
        returnejButton = new javax.swing.JButton();
        startjButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setForeground(new java.awt.Color(51, 0, 51));

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("New Game");

        mode1jRadioButton.setBackground(new java.awt.Color(51, 0, 51));
        modebuttonGroup.add(mode1jRadioButton);
        mode1jRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        mode1jRadioButton.setText("Player vs Algorithm");
        mode1jRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mode1jRadioButtonActionPerformed(evt);
            }
        });

        mode2jRadioButton.setBackground(new java.awt.Color(51, 0, 51));
        modebuttonGroup.add(mode2jRadioButton);
        mode2jRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        mode2jRadioButton.setText("Player 1 vs Player 2");
        mode2jRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mode2jRadioButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Game Mode :");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Session Name :");

        player1jLabel.setForeground(new java.awt.Color(255, 255, 255));
        player1jLabel.setText("Identify :");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Algorithm :");

        algo1jRadioButton.setBackground(new java.awt.Color(51, 0, 51));
        algobuttonGroup.add(algo1jRadioButton);
        algo1jRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        algo1jRadioButton.setText(" α-β");
        algo1jRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                algo1jRadioButtonActionPerformed(evt);
            }
        });

        algo2jRadioButton.setBackground(new java.awt.Color(51, 0, 51));
        algobuttonGroup.add(algo2jRadioButton);
        algo2jRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        algo2jRadioButton.setText("Min Max");
        algo2jRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                algo2jRadioButtonActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Or");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Who played first :");

        order2jRadioButton.setBackground(new java.awt.Color(51, 0, 51));
        orderbuttonGroup.add(order2jRadioButton);
        order2jRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        order2jRadioButton.setText("Player 1");
        order2jRadioButton.setEnabled(false);
        order2jRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order2jRadioButtonActionPerformed(evt);
            }
        });

        order3jRadioButton.setBackground(new java.awt.Color(51, 0, 51));
        orderbuttonGroup.add(order3jRadioButton);
        order3jRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        order3jRadioButton.setText("Player 2");
        order3jRadioButton.setEnabled(false);

        order1jRadioButton.setBackground(new java.awt.Color(51, 0, 51));
        orderbuttonGroup.add(order1jRadioButton);
        order1jRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        order1jRadioButton.setText("Algo");
        order1jRadioButton.setEnabled(false);
        order1jRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order1jRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(mode1jRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(mode2jRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator4)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator5)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(algo1jRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(algo2jRadioButton))
                                        .addComponent(jSeparator6)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(player1jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(player1jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(order1jRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(order2jRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(order3jRadioButton))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mode1jRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mode2jRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(algo1jRadioButton)
                    .addComponent(algo2jRadioButton)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(order2jRadioButton)
                    .addComponent(order3jRadioButton)
                    .addComponent(order1jRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player1jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player1jLabel))
                .addContainerGap())
        );

        navigationjPanel.setBackground(new java.awt.Color(0, 0, 51));

        exitjButton.setBackground(new java.awt.Color(255, 255, 204));
        exitjButton.setText("Exit");
        exitjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitjButtonActionPerformed(evt);
            }
        });

        returnejButton.setBackground(new java.awt.Color(255, 255, 204));
        returnejButton.setText("Returne");
        returnejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnejButtonActionPerformed(evt);
            }
        });

        startjButton.setBackground(new java.awt.Color(0, 153, 255));
        startjButton.setForeground(new java.awt.Color(255, 255, 255));
        startjButton.setText("Start");
        startjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navigationjPanelLayout = new javax.swing.GroupLayout(navigationjPanel);
        navigationjPanel.setLayout(navigationjPanelLayout);
        navigationjPanelLayout.setHorizontalGroup(
            navigationjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigationjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(returnejButton, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        navigationjPanelLayout.setVerticalGroup(
            navigationjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigationjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navigationjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitjButton)
                    .addComponent(returnejButton)
                    .addComponent(startjButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(navigationjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navigationjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitjButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exitjButtonActionPerformed
        int confirmation = JOptionPane.showConfirmDialog(null, "Exit!", "Confirmation", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (confirmation == JOptionPane.YES_OPTION) {
            this.dispose();
            System.exit(0);
        }
    }// GEN-LAST:event_exitjButtonActionPerformed

    private void returnejButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_returnejButtonActionPerformed
        StartGameFrame start = new StartGameFrame();
        this.dispose();
        start.setVisible(true);
    }// GEN-LAST:event_returnejButtonActionPerformed

    private void startjButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (checkData()) {
            Identify id = new Identify();
            if (this.player1jTextField.getText().equalsIgnoreCase("")) {
                id.setNameSession("new-session");
            } else {
                id.setNameSession(this.player1jTextField.getText());
            }
            if (modebuttonGroup.isSelected(this.mode1jRadioButton.getModel())) {
                id.setTypemode("player-vs-algo");
            } else if (modebuttonGroup.isSelected(this.mode2jRadioButton.getModel())) {
                id.setTypemode("player-vs-player");
            }

            if (orderbuttonGroup.isSelected(this.order1jRadioButton.getModel())) {
                id.setPlayerOrder(false);
            } else if (orderbuttonGroup.isSelected(this.order2jRadioButton.getModel())) {
                id.setPlayerOrder(true);
            }

            if (algobuttonGroup.isSelected(this.algo1jRadioButton.getModel())) {
                id.setTypeAlgo("α-β");
            } else if (algobuttonGroup.isSelected(this.algo2jRadioButton.getModel())) {
                id.setTypeAlgo("MinMax");
            }
            System.out.println("" + id.toString());
            if (id.getTypemode().equalsIgnoreCase("player-vs-player")) {
                
                if (id.getTypeAlgo().equalsIgnoreCase("MinMax")) {
                    java.awt.EventQueue.invokeLater(() -> {
                        Thread t = new Thread(() -> {
                            try {
                                GameJFrameMinMax.session = new Session(id);
                                GameJFrameMinMax.session.startSession();
                            } catch (IOException e) {
                                System.out.println(e);
                            }
                        });
                        this.setVisible(false);
                        t.start();
                        this.dispose();
                    });
                } else {
                    java.awt.EventQueue.invokeLater(() -> {
                        Thread t = new Thread(() -> {
                            try {
                                GameJFrameαβ.session = new Session(id);
                                GameJFrameαβ.session.startSession();
                            } catch (IOException e) {
                                System.out.println(e);
                            }
                        });
                        this.setVisible(false);
                        t.start();
                        this.dispose();
                    });
                }
            } else {
                if (id.getTypeAlgo().equalsIgnoreCase("MinMax")) {
                    java.awt.EventQueue.invokeLater(() -> {
                        Thread t = new Thread(() -> {
                            try {
                                GameJFrameMinMax.session = new Session(id);
                                GameJFrameMinMax.session.startSession();
                            } catch (IOException e) {
                                System.out.println(e);
                            }
                        });
                        this.setVisible(false);
                        t.start();
                        this.dispose();
                    });
                } else {
                    java.awt.EventQueue.invokeLater(() -> {
                        Thread t = new Thread(() -> {
                            try {
                                GameJFrameαβ.session = new Session(id);
                                GameJFrameαβ.session.startSession();
                            } catch (IOException e) {
                                System.out.println(e);
                            }
                        });
                        this.setVisible(false);
                        t.start();
                        this.dispose();
                    });
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please choose all choices, Try agiane!");
        }
    }// GEN-LAST:event_startjButtonActionPerformed

    private void algo1jRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_algo1jRadioButtonActionPerformed
        if (this.algobuttonGroup.isSelected(this.algo1jRadioButton.getModel())) {

        }
    }// GEN-LAST:event_algo1jRadioButtonActionPerformed

    private void algo2jRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_algo2jRadioButtonActionPerformed
        if (this.algobuttonGroup.isSelected(this.algo2jRadioButton.getModel())) {

        }
    }// GEN-LAST:event_algo2jRadioButtonActionPerformed

    private void order1jRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_order1jRadioButtonActionPerformed
        if (this.orderbuttonGroup.isSelected(this.order1jRadioButton.getModel())) {

        }
    }// GEN-LAST:event_order1jRadioButtonActionPerformed

    private void order2jRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_order2jRadioButtonActionPerformed
        if (this.orderbuttonGroup.isSelected(this.order2jRadioButton.getModel())) {

        }
    }// GEN-LAST:event_order2jRadioButtonActionPerformed

    private void mode2jRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_mode2jRadioButtonActionPerformed

        this.order3jRadioButton.setEnabled(true);
        this.order1jRadioButton.setEnabled(false);
        this.order2jRadioButton.setEnabled(true);

        if (this.modebuttonGroup.isSelected(this.mode2jRadioButton.getModel())) {

        }
    }// GEN-LAST:event_mode2jRadioButtonActionPerformed

    private void mode1jRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_mode1jRadioButtonActionPerformed

        this.order3jRadioButton.setEnabled(false);
        this.order1jRadioButton.setEnabled(true);
        this.order2jRadioButton.setEnabled(true);

        if (this.modebuttonGroup.isSelected(this.mode1jRadioButton.getModel())) {
        }
    }// GEN-LAST:event_mode1jRadioButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton algo1jRadioButton;
    private javax.swing.JRadioButton algo2jRadioButton;
    private javax.swing.ButtonGroup algobuttonGroup;
    private javax.swing.JButton exitjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JRadioButton mode1jRadioButton;
    private javax.swing.JRadioButton mode2jRadioButton;
    private javax.swing.ButtonGroup modebuttonGroup;
    private javax.swing.JPanel navigationjPanel;
    private javax.swing.JRadioButton order1jRadioButton;
    private javax.swing.JRadioButton order2jRadioButton;
    private javax.swing.JRadioButton order3jRadioButton;
    private javax.swing.ButtonGroup orderbuttonGroup;
    private javax.swing.JLabel player1jLabel;
    private javax.swing.JTextField player1jTextField;
    private javax.swing.JButton returnejButton;
    private javax.swing.JButton startjButton;
    // End of variables declaration//GEN-END:variables
}
