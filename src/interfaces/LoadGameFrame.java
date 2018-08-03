package interfaces;

import algorithms.GameJFrameαβ;
import algorithms.GameJFrameMinMax;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import serialize.Identify;
import serialize.Session;

/**
 *
 * @author medaimane
 */
public class LoadGameFrame extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    public LoadGameFrame() {
        initComponents();
        this.setInit();

    }

    private void setInit() {
        this.setLocationRelativeTo(null);
        this.addRowsToTable();
    }

    private void addRowsToTable() {
        DefaultTableModel modele = (DefaultTableModel) jTable1.getModel();
        Object rowdata[] = new Object[3];

        Identify id = new Identify();

        File datalist = new File("data");
        File[] listFile = datalist.listFiles();

        if (listFile.length != 0) {
            for (File file1 : listFile) {

                try {
                    FileInputStream fileIn = new FileInputStream(file1);
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    id = (Identify) in.readObject();

                } catch (FileNotFoundException ex) {
                    System.out.println("" + ex.getMessage());
                } catch (IOException | ClassNotFoundException ex) {
                    System.out.println("" + ex.getMessage());
                } finally {
                }

                rowdata[0] = id.getNameSession();
                rowdata[1] = id.getTypemode();
                rowdata[2] = id.getTypeAlgo();
                modele.addRow(rowdata);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        loadGamejButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        returnejButton = new javax.swing.JButton();
        exitjButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        navigationjPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));

        loadGamejButton.setBackground(new java.awt.Color(0, 153, 255));
        loadGamejButton.setForeground(new java.awt.Color(255, 255, 255));
        loadGamejButton.setText("Load");
        loadGamejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadGamejButtonActionPerformed(evt);
            }
        });

        returnejButton.setBackground(new java.awt.Color(255, 255, 204));
        returnejButton.setText("Returne");
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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Load Game");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Saved sessions :");

        jTable1.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(51, 0, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identify", "Mode", "Algo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(loadGamejButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addComponent(returnejButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exitjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 130, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(jSeparator3))
                .addGap(116, 116, 116))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadGamejButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(returnejButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitjButton)
                .addContainerGap())
        );

        navigationjPanel.setBackground(new java.awt.Color(0, 0, 51));

        javax.swing.GroupLayout navigationjPanelLayout = new javax.swing.GroupLayout(navigationjPanel);
        navigationjPanel.setLayout(navigationjPanelLayout);
        navigationjPanelLayout.setHorizontalGroup(
            navigationjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );
        navigationjPanelLayout.setVerticalGroup(
            navigationjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(navigationjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navigationjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadGamejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadGamejButtonActionPerformed

        String file = "";
        File datalist = new File("data");
        File[] list = datalist.listFiles();

        int index = jTable1.getSelectedRow();

        if (list.length != 0) {
            for (int i = 0; i < list.length; i++) {
                if (index == i) {
                    file = list[i].getName();
                }
            }
        }

        System.out.println("" + file);

        try {
            FileInputStream fileIn = new FileInputStream("data/" + file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Identify id = (Identify) in.readObject();
            if (id != null) {
                if (id.getTypeAlgo().equals("MinMax")) {
                    java.awt.EventQueue.invokeLater(() -> {
                        Thread t = new Thread(() -> {
                            try {
                                GameJFrameMinMax.session = new Session(id);
                                GameJFrameMinMax.session.loadSession();
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
                                GameJFrameαβ.session.loadSession();
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
        } catch (FileNotFoundException ex) {
            System.out.println("" + ex.getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("" + ex.getMessage());
        } finally {
        }
    }//GEN-LAST:event_loadGamejButtonActionPerformed

    private void returnejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnejButtonActionPerformed
        StartGameFrame start = new StartGameFrame();
        this.dispose();
        start.setVisible(true);
    }//GEN-LAST:event_returnejButtonActionPerformed

    private void exitjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitjButtonActionPerformed
        int confirmation = JOptionPane.showConfirmDialog(null, "Exit!", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirmation == JOptionPane.YES_OPTION) {
            this.dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_exitjButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton loadGamejButton;
    private javax.swing.JPanel navigationjPanel;
    private javax.swing.JButton returnejButton;
    // End of variables declaration//GEN-END:variables
}
