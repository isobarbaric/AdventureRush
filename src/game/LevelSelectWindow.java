package game;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import level.Level1;
import level.Level2;
import level.Level3;
import level.Level4;
import level.Level5;
import level.Level7;
import level.Level8;
import level.Level9;
import mainmenu.MainMenuWindow;

public class LevelSelectWindow extends javax.swing.JFrame {

    private final MainMenuWindow previousWindow;
    private final Level1 firstLevel;
    private final Level2 secondLevel;
    private final Level3 thirdLevel;
    private final Level4 fourthLevel;
    private final Level5 fifthLevel;
    private final Level7 seventhLevel;
    private final Level8 eighthLevel;
    private final Level9 ninthLevel;
    private Music themeMusic;

    public LevelSelectWindow(MainMenuWindow previousWindow) {
        initComponents();
        this.previousWindow = previousWindow;
        System.out.println(previousWindow.getCurrentUser().getDefaultSprite());
        this.firstLevel = new Level1(this, previousWindow.getCurrentUser().getDefaultSprite(), false);
        this.secondLevel = new Level2(this, previousWindow.getCurrentUser().getDefaultSprite(), false);
        this.thirdLevel = new Level3(this, previousWindow.getCurrentUser().getDefaultSprite(), false);
        // true is for seeing the color change thing work, remove later 
        this.fourthLevel = new Level4(this, previousWindow.getCurrentUser().getDefaultSprite(), true);
        this.fifthLevel = new Level5(this, previousWindow.getCurrentUser().getDefaultSprite(), true);
        this.seventhLevel = new Level7(this, previousWindow.getCurrentUser().getDefaultSprite(), false);
        this.eighthLevel = new Level8(this, previousWindow.getCurrentUser().getDefaultSprite(), false);
        this.ninthLevel = new Level9(this, previousWindow.getCurrentUser().getDefaultSprite(), false);

        updateButtonColors();
    }

    // add getters and setters for everything
    public MainMenuWindow getMainMenuWindow() {
        return previousWindow;
    }

    public Level1 getFirstLevel() {
        return firstLevel;
    }

    public Level4 getSecondLevel() {
        return fourthLevel;
    }

    public Level7 getSeventhLevel() {
        return seventhLevel;
    }

    //USE THESE "METHODS", THE SETBACKROUND IN END()
    public void updateButtonColors() {
        if (firstLevel.getLevelCompleted()) {

            level1Btn.setBackground(Color.green);
        } else {

            level1Btn.setBackground(Color.red);
        }

        if (fourthLevel.getLevelCompleted()) {

            level2Btn.setBackground(Color.green);
        } else {
            level2Btn.setBackground(Color.red);
        }

        if (seventhLevel.getLevelCompleted()) {

            level3Btn.setBackground(Color.green);
        } else {
            level3Btn.setBackground(Color.red);
        }

    }

    /**
     * When the user completes a level
     */
    public void end() {

        stop(); //Stops the music

        //Give the user coins
        //Change button colours
        //Rewrite in data file
    }

    public void stop() {

        try {
            themeMusic.stop();
        } catch (IOException e) {
            e.printStackTrace();
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
        returnBtn = new javax.swing.JToggleButton();
        level4Btn = new javax.swing.JToggleButton();
        level5Btn = new javax.swing.JToggleButton();
        level6Btn = new javax.swing.JToggleButton();
        level7Btn = new javax.swing.JToggleButton();
        level8Btn = new javax.swing.JToggleButton();
        level9Btn = new javax.swing.JToggleButton();
        level3Btn = new javax.swing.JButton();

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

        returnBtn.setText("Return");
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });

        level4Btn.setText("Level 4");
        level4Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level4BtnActionPerformed(evt);
            }
        });

        level5Btn.setText("Level 5");
        level5Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level5BtnActionPerformed(evt);
            }
        });

        level6Btn.setText("Level 6");

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

        level3Btn.setText("Level 3");
        level3Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level3BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(level8Btn, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addComponent(level7Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(level6Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(level5Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(level3Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(level2Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(level1Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(level4Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(level9Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(returnBtn)
                .addGap(193, 193, 193))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(level1Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(level2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(level3Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(level4Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(level5Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(level6Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(level7Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(level8Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(level9Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(returnBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        setVisible(false);
        // captures the location of the current window using a Rectangle object        
        final Rectangle bounds = this.getBounds();
        // set the location of the previousWindow to be consistent with the location of the current window
        previousWindow.setLocation(bounds.x, bounds.y);
        
        previousWindow.updateLabels();
        
        // set this window to be false so that the previousWindow will be the only frame visible
        previousWindow.setVisible(true);
    }//GEN-LAST:event_returnBtnActionPerformed

    private void level1BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level1BtnActionPerformed
        this.setVisible(false);
        firstLevel.setCurrentSprite(previousWindow.getCurrentUser().getDefaultSprite());
        firstLevel.setGameFrameLocation(this.getBounds());
        firstLevel.setGameFrameVisible(true);
        playMusic(); //Plays the music
    }//GEN-LAST:event_level1BtnActionPerformed

    private void level2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level2BtnActionPerformed
        this.setVisible(false);
        secondLevel.setCurrentSprite(previousWindow.getCurrentUser().getDefaultSprite());
        secondLevel.setGameFrameLocation(this.getBounds());
        secondLevel.setGameFrameVisible(true);
        playMusic(); //Plays the music
    }//GEN-LAST:event_level2BtnActionPerformed

    private void level7BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level7BtnActionPerformed
        this.setVisible(false);
        seventhLevel.setCurrentSprite(previousWindow.getCurrentUser().getDefaultSprite());
        seventhLevel.setGameFrameLocation(this.getBounds());
        seventhLevel.setGameFrameVisible(true);
        playMusic(); //Plays the music
    }//GEN-LAST:event_level7BtnActionPerformed

    private void level8BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level8BtnActionPerformed
        this.setVisible(false);   
        eighthLevel.setCurrentSprite(previousWindow.getCurrentUser().getDefaultSprite());
        eighthLevel.setGameFrameLocation(this.getBounds());
        eighthLevel.setGameFrameVisible(true);
        playMusic(); //Plays the music
    }//GEN-LAST:event_level8BtnActionPerformed

    private void level9BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level9BtnActionPerformed
        this.setVisible(false);
        ninthLevel.setCurrentSprite(previousWindow.getCurrentUser().getDefaultSprite());     
        ninthLevel.setGameFrameLocation(this.getBounds());
        ninthLevel.setGameFrameVisible(true);
        playMusicLast(); //Plays the "special" music
    }//GEN-LAST:event_level9BtnActionPerformed

    private void level5BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level5BtnActionPerformed
        this.setVisible(false);
        fifthLevel.setCurrentSprite(previousWindow.getCurrentUser().getDefaultSprite());
        fifthLevel.setGameFrameLocation(this.getBounds());
        fifthLevel.setGameFrameVisible(true);
        playMusic(); //Plays the music
    }//GEN-LAST:event_level5BtnActionPerformed

    private void level3BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level3BtnActionPerformed
        this.setVisible(false);
        thirdLevel.setCurrentSprite(previousWindow.getCurrentUser().getDefaultSprite());
        thirdLevel.setGameFrameLocation(this.getBounds());
        thirdLevel.setGameFrameVisible(true);
        playMusic(); //Plays the music
    }//GEN-LAST:event_level3BtnActionPerformed

    private void level4BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level4BtnActionPerformed
        this.setVisible(false);
        fourthLevel.setCurrentSprite(previousWindow.getCurrentUser().getDefaultSprite());
        fourthLevel.setGameFrameLocation(this.getBounds());
        fourthLevel.setGameFrameVisible(true);
        playMusic(); //Plays the music
    }//GEN-LAST:event_level4BtnActionPerformed

    /**
     * Plays music for the levels
     */
    public void playMusic() {
        //Instantiating the music object
        themeMusic = new Music("src/assets/main-music.wav");
        themeMusic.play(); //Plays the music
    }

    /**
     * Plays the annoying music for the last level
     */
    public void playMusicLast() {
        //Instantiating the music object
        themeMusic = new Music("src/assets/plate-sound.wav");
        themeMusic.play(); //Plays the music
    }

    /**
     * Music class for every game level Reference:
     * https://www.codespeedy.com/how-to-add-audio-on-jswing-in-java/
     */
    public class Music {

        // declaring the attributes
        private String name;
        private Clip clip;
        private AudioInputStream sound;

        /**
         * Primary Constructor
         */
        public Music() {
            name = new String();
        }

        /**
         * Secondary Constructor - Must have a music file name
         *
         * @param name
         */
        public Music(String name) {
            this(); //Primary chaining
            this.name = name;
            setFile();
        }

        /**
         *
         */
        public void setFile() {
            try {
                File file = new File(name);
                System.out.println();
                sound = AudioSystem.getAudioInputStream(file);
                //System.out.println(sound.toString());
                clip = AudioSystem.getClip();
                //System.out.println(clip.toString());
                clip.open(sound);
            } catch (Exception e) {
                //Displays an error message
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }
        }

        /**
         * Plays the music
         */
        public void play() {
            clip.start();
        }

        /**
         * Stops the music
         *
         * @throws IOException - Throws an error
         */
        public void stop() throws IOException {
            sound.close();
            clip.close();
            clip.stop();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton level1Btn;
    private javax.swing.JToggleButton level2Btn;
    private javax.swing.JButton level3Btn;
    private javax.swing.JToggleButton level4Btn;
    private javax.swing.JToggleButton level5Btn;
    private javax.swing.JToggleButton level6Btn;
    private javax.swing.JToggleButton level7Btn;
    private javax.swing.JToggleButton level8Btn;
    private javax.swing.JToggleButton level9Btn;
    private javax.swing.JToggleButton returnBtn;
    // End of variables declaration//GEN-END:variables
}
