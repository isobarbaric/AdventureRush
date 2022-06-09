package game;

import java.awt.Color;
import java.awt.Rectangle;
import level.Level1;
import level.Level2;
import level.Level7;
import level.Level8;
import level.Level9;
import mainmenu.MainMenuWindow;

public class LevelSelectWindow extends javax.swing.JFrame {

    private final MainMenuWindow previousWindow;
    private final Level1 firstLevel;
    private final Level2 secondLevel;
    private final Level7 seventhLevel;
    private final Level8 eighthLevel;
    private final Level9 ninthLevel;
    
    public LevelSelectWindow(MainMenuWindow previousWindow) {
        initComponents();
        this.previousWindow = previousWindow;        
        this.firstLevel = new Level1(this, previousWindow.getCurrentUser().getDefaultSprite(), false);
        // true is for seeing the color change thing work, remove later 
        this.secondLevel = new Level2(this, previousWindow.getCurrentUser().getDefaultSprite(), true);
        this.seventhLevel = new Level7(this, previousWindow.getCurrentUser().getDefaultSprite(), false);
        this.eighthLevel = new Level8(this, previousWindow.getCurrentUser().getDefaultSprite(), false);
        this.ninthLevel = new Level9(this, previousWindow.getCurrentUser().getDefaultSprite(), false);
        updateButtonColors();
    }
    
    public MainMenuWindow getMainMenuWindow() {
        return previousWindow;
    }
    
    public Level1 getFirstLevel() {
        return firstLevel;
    }
    
    public Level2 getSecondLevel() {
        return secondLevel;
    }
    
    public Level7 getSeventhLevel() {
        return seventhLevel;
    }
    
    public void updateButtonColors() {
        if (firstLevel.getLevelCompleted()) {
//            level1Btn.setContentAreaFilled(false);
//            level1Btn.setOpaque(true);
            level1Btn.setBackground(Color.green);
        } else {
            level1Btn.setBackground(Color.red);
        }
        
        if (secondLevel.getLevelCompleted()) {
//            level2Btn.setContentAreaFilled(false);
//            level2Btn.setOpaque(true);
            level2Btn.setBackground(Color.green);
        } else {
            level2Btn.setBackground(Color.red);
        }
        
        if (seventhLevel.getLevelCompleted()) {
//            level3Btn.setContentAreaFilled(false);
//            level3Btn.setOpaque(true);
            level3Btn.setBackground(Color.green);
        } else {
            level3Btn.setBackground(Color.red);
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

        level1Btn = new javax.swing.JToggleButton();
        level2Btn = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        level3Btn = new javax.swing.JToggleButton();
        returnBtn = new javax.swing.JToggleButton();
        level4Btn = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        level7Btn = new javax.swing.JToggleButton();
        level8Btn = new javax.swing.JToggleButton();
        level9Btn = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        level1Btn.setText("Level 1");
        level1Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level1BtnActionPerformed(evt);
            }
        });

        level2Btn.setText("Level 2");
        level2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level2BtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 22)); // NOI18N
        jLabel1.setText("Level Select");

        level3Btn.setText("Level 3");

        returnBtn.setText("Return");
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });

        level4Btn.setText("Level 4");

        jToggleButton1.setText("Level 5");

        jToggleButton2.setText("Level 6");

        level7Btn.setText("Level 7");
        level7Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level7BtnActionPerformed(evt);
            }
        });

        level8Btn.setText("Level 8");
        level8Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level8BtnActionPerformed(evt);
            }
        });

        level9Btn.setText("Level 9");
        level9Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level9BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(returnBtn)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(level1Btn)
                        .addGap(18, 18, 18)
                        .addComponent(level2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(level3Btn)
                        .addGap(18, 18, 18)
                        .addComponent(level4Btn)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jToggleButton2)
                                .addGap(18, 18, 18)
                                .addComponent(level7Btn)
                                .addGap(18, 18, 18)
                                .addComponent(level8Btn)
                                .addGap(18, 18, 18)
                                .addComponent(level9Btn)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(returnBtn)
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(level4Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(level1Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(level2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(level3Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(level7Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(level8Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(level9Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        setVisible(false);
        // captures the location of the current window using a Rectangle object        
        final Rectangle bounds = this.getBounds();
        // set the location of the previousWindow to be consistent with the location of the current window
        previousWindow.setLocation(bounds.x, bounds.y);
        // set this window to be false so that the previousWindow will be the only frame visible
        previousWindow.setVisible(true);
    }//GEN-LAST:event_returnBtnActionPerformed

    private void level1BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level1BtnActionPerformed
        this.setVisible(false);
        firstLevel.setGameFrameLocation(this.getBounds());
        firstLevel.setGameFrameVisible(true);
    }//GEN-LAST:event_level1BtnActionPerformed

    private void level2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level2BtnActionPerformed
        this.setVisible(false);
        secondLevel.setGameFrameLocation(this.getBounds());
        secondLevel.setGameFrameVisible(true);
    }//GEN-LAST:event_level2BtnActionPerformed

    private void level7BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level7BtnActionPerformed
        this.setVisible(false);
        seventhLevel.setGameFrameLocation(this.getBounds());
        seventhLevel.setGameFrameVisible(true);
    }//GEN-LAST:event_level7BtnActionPerformed

    private void level8BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level8BtnActionPerformed
        this.setVisible(false);
        eighthLevel.setGameFrameLocation(this.getBounds());
        eighthLevel.setGameFrameVisible(true);
    }//GEN-LAST:event_level8BtnActionPerformed

    private void level9BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level9BtnActionPerformed
        this.setVisible(false);
        ninthLevel.setGameFrameLocation(this.getBounds());
        ninthLevel.setGameFrameVisible(true);
    }//GEN-LAST:event_level9BtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton level1Btn;
    private javax.swing.JToggleButton level2Btn;
    private javax.swing.JToggleButton level3Btn;
    private javax.swing.JToggleButton level4Btn;
    private javax.swing.JToggleButton level7Btn;
    private javax.swing.JToggleButton level8Btn;
    private javax.swing.JToggleButton level9Btn;
    private javax.swing.JToggleButton returnBtn;
    // End of variables declaration//GEN-END:variables
}