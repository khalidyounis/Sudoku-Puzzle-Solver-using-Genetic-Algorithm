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
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JDialog;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Notification extends javax.swing.JComponent {

    private JDialog dialog;
    private Animator animator;
    private final Frame fram;
    private boolean showing;
    private Thread thread;
    private int animate = 10;
    private BufferedImage imageShadow;
    private int shadowSize = 6;
    private Type type;
    private Location location;
    int xmouse;
    int ymouse;

    public Notification(Frame fram, Type type, Location location, String message) {
        this.fram = fram;
        this.type = type;
        this.location = location;
        initComponents();
        init(message);
        initAnimator();
    }

    private void init(String message) {
        setBackground(Color.WHITE);
        dialog = new JDialog(fram);
        dialog.setUndecorated(true);
        dialog.setFocusableWindowState(false);
        dialog.setBackground(new Color(0, 0, 0, 0));
        dialog.add(this);
        dialog.setSize(getPreferredSize());
        switch (type) {
            case SUCCESS -> {
                lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/success-48.png")));
                lbMessage.setText("Success");
            }
            case INFO -> {
                lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/info-48.png")));
                lbMessage.setText("Info");
            }
            case WARNING -> {
                lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/warning-48.png")));
                lbMessage.setText("Warning");
            }
        }

        lbMessageText.setText(message);
    }

    private void initAnimator() {
        TimingTarget target = new TimingTargetAdapter() {
            private int x;
            private int top;
            private boolean top_to_bot;

            @Override
            public void timingEvent(float fraction) {
                if (showing) {
                    float alpha = 1f - fraction;
                    int y = (int) ((1f - fraction) * animate);
                    if (top_to_bot) {
                        dialog.setLocation(x, top + y);
                    } else {
                        dialog.setLocation(x, top - y);
                    }
                    dialog.setOpacity(alpha);
                } else {
                    float alpha = fraction;
                    int y = (int) (fraction * animate);
                    if (top_to_bot) {
                        dialog.setLocation(x, top + y);
                    } else {
                        dialog.setLocation(x, top - y);
                    }
                    dialog.setOpacity(alpha);
                }
            }

            @Override
            public void begin() {
                if (!showing) {
                    dialog.setOpacity(0f);
                    int margin = 10;
                    int y = 0;
                    if (location == Location.TOP_CENTER) {
                        x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
                        y = fram.getY();
                        top_to_bot = true;
                    } else if (location == Location.TOP_RIGHT) {
                        x = fram.getX() + fram.getWidth() - dialog.getWidth() - margin;
                        y = fram.getY();
                        top_to_bot = true;
                    } else if (location == Location.TOP_LEFT) {
                        x = fram.getX() + margin;
                        y = fram.getY();
                        top_to_bot = true;
                    } else if (location == Location.BOTTOM_CENTER) {
                        x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
                        y = fram.getY() + fram.getHeight() - dialog.getHeight();
                        top_to_bot = false;
                    } else if (location == Location.BOTTOM_RIGHT) {
                        x = fram.getX() + fram.getWidth() - dialog.getWidth() - margin;
                        y = fram.getY() + fram.getHeight() - dialog.getHeight();
                        top_to_bot = false;
                    } else if (location == Location.BOTTOM_LEFT) {
                        x = fram.getX() + margin;
                        y = fram.getY() + fram.getHeight() - dialog.getHeight();
                        top_to_bot = false;
                    } else {
                        x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
                        y = fram.getY() + ((fram.getHeight() - dialog.getHeight()) / 2);
                        top_to_bot = true;
                    }
                    top = y;
                    dialog.setLocation(x, y);
                    dialog.setVisible(true);
                }
            }

            @Override
            public void end() {
                showing = !showing;
                if (showing) {
                    thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            sleep();
                            closeNotification();
                        }
                    });
                    thread.start();
                } else {
                    dialog.dispose();
                }
            }
        };
        animator = new Animator(500, target);
        animator.setResolution(5);
    }

    public void showNotification() {
        animator.start();
    }

    private void closeNotification() {
        if (thread != null && thread.isAlive()) {
            thread.interrupt();
        }
        if (animator.isRunning()) {
            if (!showing) {
                animator.stop();
                showing = true;
                animator.start();
            }
        } else {
            showing = true;
            animator.start();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.drawImage(imageShadow, 0, 0, null);
        int x = shadowSize;
        int y = shadowSize;
        int width = getWidth() - shadowSize * 2;
        int height = getHeight() - shadowSize * 2;
        g2.fillRect(x, y, width, height);
        switch (type) {
            case SUCCESS ->
                g2.setColor(new Color(18, 163, 24));
            case WARNING ->
                g2.setColor(new Color(249, 170, 51));
            case INFO ->
                g2.setColor(new Color(15, 82, 186));
        }
        g2.fillRect(6, 5, 5, getHeight() - shadowSize * 2 + 1);
        g2.dispose();
        super.paint(grphcs);
    }

    @Override
    public void setBounds(int i, int i1, int i2, int i3) {
        super.setBounds(i, i1, i2, i3);
        createImageShadow();
    }

    private void createImageShadow() {
        imageShadow = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = imageShadow.createGraphics();
        g2.drawImage(createShadow(), 0, 0, null);
        g2.dispose();
    }

    private BufferedImage createShadow() {
        BufferedImage img = new BufferedImage(getWidth() - shadowSize * 2, getHeight() - shadowSize * 2, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.fillRect(0, 0, img.getWidth(), img.getHeight());
        g2.dispose();
        return new ShadowRenderer(shadowSize, 0.3f, new Color(100, 100, 100)).createShadow(img);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        lbMessage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbMessageText = new javax.swing.JTextArea();
        cmdClose = new javax.swing.JButton();

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/success-48.png"))); // NOI18N

        panel.setOpaque(false);

        lbMessage.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(38, 38, 38));
        lbMessage.setText("Message");

        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        lbMessageText.setEditable(false);
        lbMessageText.setColumns(20);
        lbMessageText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbMessageText.setLineWrap(true);
        lbMessageText.setRows(5);
        lbMessageText.setText("Message");
        lbMessageText.setWrapStyleWord(true);
        lbMessageText.setBorder(null);
        jScrollPane1.setViewportView(lbMessageText);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMessage))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbMessage)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cmdClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close.png"))); // NOI18N
        cmdClose.setBorder(null);
        cmdClose.setContentAreaFilled(false);
        cmdClose.setFocusable(false);
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lbIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        closeNotification();
    }//GEN-LAST:event_cmdCloseActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x - this.xmouse, y - this.ymouse);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        this.xmouse = evt.getX();
        this.ymouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    public static enum Type {
        SUCCESS, INFO, WARNING
    }

    public static enum Location {
        TOP_CENTER, TOP_RIGHT, TOP_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT, BOTTOM_LEFT, CENTER
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton cmdClose;
    private static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lbIcon;
    private static javax.swing.JLabel lbMessage;
    private static javax.swing.JTextArea lbMessageText;
    public static javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
