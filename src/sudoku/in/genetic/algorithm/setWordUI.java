/*

Sudoku Puzzle Solver using Genetic Algorithm
Developed by Group A
University of Liverpool
Master of Computer Science
CSCK502 Reasoning and Intelligent Systems October 2022

MIT License

Copyright (c) 2022 Khalid Younis
Copyright (c) 2022 Jose Roberto Mora Martinez
Copyright (c) 2022 Ghafer Khan

 */

package sudoku.in.genetic.algorithm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author khalid.kareem
 */
public class setWordUI extends javax.swing.JFrame {

    /**
     * Creates new form SudokuGeneticAlgorithmUI
     */
    int xmouse;
    int ymouse;
    Properties prop = new Properties();
    public static String puzzleWord = "";
    static boolean userInput = false;

    public setWordUI() throws IOException {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        int x = (screenSize.width - frameSize.width) / 2;
        int y = (screenSize.height - frameSize.height) / 2;
        setLocation(x, y);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/app_icon.png")));
        String fileName = "app.config";
        try ( FileInputStream fis = new FileInputStream(fileName)) {
            prop.load(fis);
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        puzzleWordInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        proceedButton = new com.k33ptoo.components.KButton();
        skipButton = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(236, 239, 241));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 71, 79), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(430, 350));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel24.setBackground(new java.awt.Color(50, 71, 79));
        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("＿");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel24.setOpaque(true);
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });

        jLabel25.setBackground(new java.awt.Color(204, 0, 0));
        jLabel25.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("✕");
        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel25.setOpaque(true);
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });

        puzzleWordInput.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Border rounded = new LineBorder(new Color(240, 168, 59), 1, true);
        Border empty = new EmptyBorder(0, 5, 0, 0);
        Border border = new CompoundBorder(rounded, empty);
        puzzleWordInput.setBorder(border);
        puzzleWordInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                puzzleWordInputMouseClicked(evt);
            }
        });
        puzzleWordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puzzleWordInputActionPerformed(evt);
            }
        });
        puzzleWordInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                puzzleWordInputKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                puzzleWordInputKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(50, 71, 79));
        jLabel2.setText("Enter the puzzle word (4 unique letters)");

        proceedButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        proceedButton.setText("Proceed");
        proceedButton.setFont(new java.awt.Font("SansSerif", 0, 22)); // NOI18N
        proceedButton.setkBackGroundColor(new java.awt.Color(247, 170, 53));
        proceedButton.setkEndColor(new java.awt.Color(249, 170, 51));
        proceedButton.setkForeGround(new java.awt.Color(51, 51, 51));
        proceedButton.setkHoverEndColor(new java.awt.Color(240, 168, 59));
        proceedButton.setkHoverForeGround(new java.awt.Color(51, 51, 51));
        proceedButton.setkHoverStartColor(new java.awt.Color(240, 168, 59));
        proceedButton.setkSelectedColor(new java.awt.Color(240, 168, 59));
        proceedButton.setkStartColor(new java.awt.Color(249, 170, 51));
        proceedButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proceedButtonMouseClicked(evt);
            }
        });
        proceedButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                proceedButtonKeyPressed(evt);
            }
        });

        skipButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        skipButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Grey"));
        skipButton.setText("Skip");
        skipButton.setFont(new java.awt.Font("SansSerif", 0, 22)); // NOI18N
        skipButton.setkAllowTab(true);
        skipButton.setkBackGroundColor(new java.awt.Color(102, 102, 102));
        skipButton.setkEndColor(new java.awt.Color(102, 102, 102));
        skipButton.setkHoverEndColor(new java.awt.Color(51, 51, 51));
        skipButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        skipButton.setkHoverStartColor(new java.awt.Color(51, 51, 51));
        skipButton.setkSelectedColor(new java.awt.Color(51, 51, 51));
        skipButton.setkStartColor(new java.awt.Color(102, 102, 102));
        skipButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                skipButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(puzzleWordInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(proceedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(skipButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addComponent(puzzleWordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proceedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(skipButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        setState(1);
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x - this.xmouse, y - this.ymouse);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        this.xmouse = evt.getX();
        this.ymouse = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void puzzleWordInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_puzzleWordInputMouseClicked

    }//GEN-LAST:event_puzzleWordInputMouseClicked

    private void puzzleWordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puzzleWordInputActionPerformed

    }//GEN-LAST:event_puzzleWordInputActionPerformed

    private void puzzleWordInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_puzzleWordInputKeyTyped
        if (puzzleWordInput.getText().length() >= 4) {
            evt.consume();
        }
    }//GEN-LAST:event_puzzleWordInputKeyTyped

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void proceedButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proceedButtonMouseClicked
        //Store the entered puzzle word by the user in the puzzleWord variable
        puzzleWord = puzzleWordInput.getText();
        //Inform the application that the user entered the puzzle word
        userInput = true;
        //Store the entered puzzle word to the puzzle word variable in the SudokuGeneticAlgorithmUI
        SudokuGeneticAlgorithmUI.puzzleWord = string2SB(puzzleWord);

        //Check if the puzzle word length is greater than 4
        if (puzzleWordInput.getText().length() >= 4) {
            if (!checkDuplicate(puzzleWordInput.getText())) {
                try {
                    dispose();
                    new SudokuGeneticAlgorithmUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(setWordUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Notification panel = new Notification(setWordUI.this, Notification.Type.WARNING, Notification.Location.CENTER, "The puzzle word should not include duplicated letters");
                panel.showNotification();
            }

        } else {
            Notification panel = new Notification(setWordUI.this, Notification.Type.WARNING, Notification.Location.CENTER, "Set puzzle a word consist of 4 letters with no duplicated letters");
            panel.showNotification();
        }

    }//GEN-LAST:event_proceedButtonMouseClicked

    private void puzzleWordInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_puzzleWordInputKeyPressed
        int key = evt.getKeyCode();
        puzzleWord = puzzleWordInput.getText();
        if (key == KeyEvent.VK_ENTER) {
            if (puzzleWordInput.getText().length() >= 4) {
                try {
                    dispose();
                    new SudokuGeneticAlgorithmUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(setWordUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Notification panel = new Notification(setWordUI.this, Notification.Type.WARNING, Notification.Location.CENTER, "Set puzzle a word consist of 4 letters");
                panel.showNotification();
            }
        }
    }//GEN-LAST:event_puzzleWordInputKeyPressed

    private void skipButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_skipButtonMouseClicked
        try {
            //Inform the application that the user didn't enter the puzzle word
            userInput = false;
            puzzleWord = "";

            //Close the current frame
            dispose();

            //Run the SudokuGeneticAlgorithmUI frame
            new SudokuGeneticAlgorithmUI().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(setWordUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_skipButtonMouseClicked

    private void proceedButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_proceedButtonKeyPressed

    }//GEN-LAST:event_proceedButtonKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.put("JTextField.background", new ColorUIResource(new Color(255, 255, 255)));
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                new setWordUI().setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(setWordUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(setWordUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(setWordUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(setWordUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(setWordUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel1;
    private com.k33ptoo.components.KButton proceedButton;
    public static javax.swing.JTextField puzzleWordInput;
    private com.k33ptoo.components.KButton skipButton;
    // End of variables declaration//GEN-END:variables

    //Check the duplicated characters in a string
    public static boolean checkDuplicate(String s) {
        for (int i = 0; i < (s.length() - 1); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    //Conver String to StringBuilder
    public StringBuilder string2SB(String str) {
        // Creating StringBuilder object
        StringBuilder sb = new StringBuilder();
        /* Using append() method to convert String to StringBuilder */
        sb.append(str);

        return sb;
    }

}
