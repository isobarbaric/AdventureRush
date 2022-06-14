package game;

import assets.ReaderWriter;
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
import level.Level6;
import level.Level7;
import level.Level8;
import level.Level9;
import mainmenu.MainMenuWindow;

public class LevelSelectWindow extends javax.swing.JFrame {

    // attributes of a LevelSelectWindow object
    private final MainMenuWindow previousWindow;
    private Level1 firstLevel;
    private Level2 secondLevel;
    private Level3 thirdLevel;
    private Level4 fourthLevel;
    private Level5 fifthLevel;
    private Level6 sixthLevel;
    private Level7 seventhLevel;
    private Level8 eighthLevel;
    private Level9 ninthLevel;
    private Music themeMusic;
    private ReaderWriter IOHandler;
    
    /**
     * Primary constructor
     * @param previousWindow 
     */
    public LevelSelectWindow(MainMenuWindow previousWindow) {
        initComponents();
        this.previousWindow = previousWindow;
        IOHandler = new ReaderWriter("src/adventurerush/loginDetails.txt");
    }
    
    // getters

    /**
     * Accessor for the previousWindow attribute
     * @return 
     */
    public MainMenuWindow getPreviousWindow() {
        return previousWindow;
    }
    
    /**
     * Accessor for the first level
     * @return the first level
     */
    public Level1 getFirstLevel() {
        return firstLevel;
    }

    /**
     * Accessor for the second level
     * @return the second level
     */
    public Level2 getSecondLevel() {
        return secondLevel;
    }

    /**
     * Accessor for the third level
     * @return the third level
     */
    public Level3 getThirdLevel() {
        return thirdLevel;
    }
    
    /**
     * Accessor for the fourth level
     * @return the third level
     */
    public Level4 getFourthLevel() {
        return fourthLevel;
    }
    
    /**
     * Accessor for the fifth level
     * @return the fifth level
     */
    public Level5 getFifthLevel() {
        return fifthLevel;
    }
    
    /**
     * Accessor for the sixth level
     * @return the sixth level
     */
    public Level6 getSixthLevel() {
        return sixthLevel;
    }
    
    /**
     * Accessor for the seventh level
     * @return the seventh level
     */
    public Level7 getSeventhLevel() {
        return seventhLevel;
    }
    
    /**
     * Accessor for the eighth level
     * @return the eighth level
     */
    public Level8 getEighthLevel() {
        return eighthLevel;
    }
    
    /**
     * Accessor for the ninth level
     * @return the ninth level
     */
    public Level9 getNinthLevel() {
        return ninthLevel;
    }
    
    // setters
    
    /**
     * Mutator for the first level
     * @param firstLevel - the given level
     */
    public void setFirstLevel(Level1 firstLevel) {
       this.firstLevel = firstLevel;
    }

     /**
     * Mutator for the second level
     * @param secondLevel - the given level
     */
    public void setSecondLevel(Level2 secondLevel) {
       this.secondLevel = secondLevel;
    }

     /**
     * Mutator for the third level
     * @param thirdLevel - the given level
     */
    public void setThirdLevel(Level3 thirdLevel) {
       this.thirdLevel = thirdLevel;
    }
    
     /**
     * Mutator for the fourth level
     * @param fourthLevel - the given level
     */
    public void setFourthLevel(Level4 fourthLevel) {
       this.fourthLevel = fourthLevel;
    }
    
     /**
     * Mutator for the fifth level
     * @param fifthLevel - the given level
     */
    public void setFifthLevel(Level5 fifthLevel) {
       this.fifthLevel = fifthLevel;
    }
    
     /**
     * Mutator for the sixth level
     * @param sixthLevel - the given level
     */
    public void setSixthLevel(Level6 sixthLevel) {
       this.sixthLevel = sixthLevel;
    }
    
     /**
     * Mutator for the seventh level
     * @param seventhLevel - the given level
     */
    public void setSeventhLevel(Level7 seventhLevel) {
       this.seventhLevel = seventhLevel;
    }
    
    /**
     * Mutator for the eighth level
     * @param eighthLevel - the given level
     */
    public void setEighthLevel(Level8 eighthLevel) {
       this.eighthLevel = eighthLevel;
    }
    
     /**
     * Mutator for the ninth level
     * @param ninthLevel - the given level
     */
    public void setNinthLevel(Level9 ninthLevel) {
       this.ninthLevel = ninthLevel;
    }

    // behavior method
    
    /**
     * When the user completes a level
     */
    public void endCurrentLevel() {
        // stops the music as the music being played is over
        stop(); 
        // declare and initialize a variable to keep track of the user's current number of coins
        int currentUserBalance = previousWindow.getCurrentUser().getCurrencyPossessed();
        // increment this number with the same standard number of points assigned to each level
        previousWindow.getCurrentUser().setCurrencyPossessed(currentUserBalance + Level1.numCoinsAssociated);
        // updating the currency count in the data file
        IOHandler.replaceLine(previousWindow.getCurrentUser().getCurrentFileLine()-1, Integer.toString(previousWindow.getCurrentUser().getCurrencyPossessed()));        
    }

    /**
     * Stops the music from playing
     */
    public void stop() {
        try {
            themeMusic.stop();
        } catch (NullPointerException | IOException f) {
            f.printStackTrace();
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
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(level8Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(level7Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(level6Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(level5Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(level3Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(level2Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(level1Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(level4Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(level9Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel1)
                        .addGap(74, 74, 74)))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(returnBtn)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(returnBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(level1Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(level2Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(level3Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(level4Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(level5Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(level6Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(level7Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(level8Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(level9Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Provides functionality for when the return button is clicked
     * @param evt the action of clicking the return button
     */
    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        // setting the LevelSelectWindow to be invisible
        this.setVisible(false);
        // captures the location of the current window using a Rectangle object        
        final Rectangle bounds = this.getBounds();
        // set the location of the previousWindow to be consistent with the location of the current window
        previousWindow.setLocation(bounds.x, bounds.y);
        // updating the labels on the previousWindow 
        previousWindow.updateLabels();
        // set this window to be false so that the previousWindow will be the only frame visible
        previousWindow.setVisible(true);
    }//GEN-LAST:event_returnBtnActionPerformed

    /**
     * Provides functionality for when the level1 button is clicked
     * @param evt the action of clicking the level1 button
     */
    private void level1BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level1BtnActionPerformed
        // setting the LevelSelectWindow to be invisible
        this.setVisible(false);
        // initializing the current Level
        firstLevel = new Level1(this, previousWindow.getCurrentUser().getDefaultSprite(), false);
        // setting the sprite for the currentLevel
        firstLevel.setCurrentSprite(previousWindow.getCurrentUser().getDefaultSprite());
        // captures the location of the current window        
        firstLevel.setGameFrameLocation(this.getBounds());
        // setting the frame for that level to be visible
        firstLevel.setGameFrameVisible(true);
        // plays the music
        playMusic(); 
    }//GEN-LAST:event_level1BtnActionPerformed

    /**
     * Provides functionality for when the level2 button is clicked
     * @param evt the action of clicking the level2 button
     */
    private void level2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level2BtnActionPerformed
        // setting the LevelSelectWindow to be invisible
        this.setVisible(false);
        // initializing the current Level
        secondLevel = new Level2(this, previousWindow.getCurrentUser().getDefaultSprite(), false);
        // setting the sprite for the currentLevel
        secondLevel.setCurrentSprite(previousWindow.getCurrentUser().getDefaultSprite());
        // captures the location of the current window        
        secondLevel.setGameFrameLocation(this.getBounds());
        // setting the frame for that level to be visible
        secondLevel.setGameFrameVisible(true);
        // plays the music
        playMusic(); 
    }//GEN-LAST:event_level2BtnActionPerformed

    /**
     * Provides functionality for when the level7 button is clicked
     * @param evt the action of clicking the level7 button
     */
    private void level7BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level7BtnActionPerformed
        // setting the LevelSelectWindow to be invisible
        this.setVisible(false);
        // initializing the current Level
        seventhLevel = new Level7(this, previousWindow.getCurrentUser().getDefaultSprite(), false);
        // setting the sprite for the currentLevel
        seventhLevel.setCurrentSprite(previousWindow.getCurrentUser().getDefaultSprite());
        // captures the location of the current window        
        seventhLevel.setGameFrameLocation(this.getBounds());
        // setting the frame for that level to be visible
        seventhLevel.setGameFrameVisible(true);
        // plays the music
        playMusic(); 
    }//GEN-LAST:event_level7BtnActionPerformed
    
    /**
     * Provides functionality for when the level8 button is clicked
     * @param evt the action of clicking the level8 button
     */ 
    private void level8BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level8BtnActionPerformed
        // setting the LevelSelectWindow to be invisible
        this.setVisible(false);   
        // initializing the current Level
        eighthLevel = new Level8(this, previousWindow.getCurrentUser().getDefaultSprite(), false);
        // setting the sprite for the currentLevel
        eighthLevel.setCurrentSprite(previousWindow.getCurrentUser().getDefaultSprite());
        // captures the location of the current window        
        eighthLevel.setGameFrameLocation(this.getBounds());
        // setting the frame for that level to be visible
        eighthLevel.setGameFrameVisible(true);
        // plays the music        
        playMusic(); 
    }//GEN-LAST:event_level8BtnActionPerformed

    /**
     * Provides functionality for when the level9 button is clicked
     * @param evt the action of clicking the level9 button
     */
    private void level9BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level9BtnActionPerformed
        // setting the LevelSelectWindow to be invisible
        this.setVisible(false);
        // initializing the current Level
        ninthLevel = new Level9(this, previousWindow.getCurrentUser().getDefaultSprite(), false);
        // setting the sprite for the currentLevel
        ninthLevel.setCurrentSprite(previousWindow.getCurrentUser().getDefaultSprite());     
        // captures the location of the current window        
        ninthLevel.setGameFrameLocation(this.getBounds());
        // setting the frame for that level to be visible
        ninthLevel.setGameFrameVisible(true);
        // plays the music        
        playMusicLast();
    }//GEN-LAST:event_level9BtnActionPerformed

    /**
     * Provides functionality for when the level5 button is clicked
     * @param evt the action of clicking the level5 button
     */
    private void level5BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level5BtnActionPerformed
        // setting the LevelSelectWindow to be invisible
        this.setVisible(false);
        // initializing the current Level
        fifthLevel = new Level5(this, previousWindow.getCurrentUser().getDefaultSprite(), true);
        // setting the sprite for the currentLevel
        fifthLevel.setCurrentSprite(previousWindow.getCurrentUser().getDefaultSprite());
        // captures the location of the current window        
        fifthLevel.setGameFrameLocation(this.getBounds());
        // setting the frame for that level to be visible
        fifthLevel.setGameFrameVisible(true);
        // plays the music        
        playMusic(); 
    }//GEN-LAST:event_level5BtnActionPerformed

    /**
     * Provides functionality for when the level3 button is clicked
     * @param evt the action of clicking the level3 button
     */
    private void level3BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level3BtnActionPerformed
        // setting the LevelSelectWindow to be invisible
        this.setVisible(false);
        // initializing the current Level
        thirdLevel = new Level3(this, previousWindow.getCurrentUser().getDefaultSprite(), false);
        // setting the sprite for the currentLevel
        thirdLevel.setCurrentSprite(previousWindow.getCurrentUser().getDefaultSprite());
        // captures the location of the current window        
        thirdLevel.setGameFrameLocation(this.getBounds());
        // setting the frame for that level to be visible
        thirdLevel.setGameFrameVisible(true);
        // plays the music        
        playMusic();
    }//GEN-LAST:event_level3BtnActionPerformed

    /**
     * Provides functionality for when the level4 button is clicked
     * @param evt the action of clicking the level4 button
     */
    private void level4BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level4BtnActionPerformed
        // setting the LevelSelectWindow to be invisible
        this.setVisible(false);
        // initializing the current Level
        fourthLevel = new Level4(this, previousWindow.getCurrentUser().getDefaultSprite(), true);
        // setting the sprite for the currentLevel
        fourthLevel.setCurrentSprite(previousWindow.getCurrentUser().getDefaultSprite());
        // captures the location of the current window        
        fourthLevel.setGameFrameLocation(this.getBounds());
        // setting the frame for that level to be visible
        fourthLevel.setGameFrameVisible(true);
        // plays the music        
        playMusic();
    }//GEN-LAST:event_level4BtnActionPerformed

    /**
     * Plays music for the levels
     */
    public void playMusic() {
        // instantiating the music object
        themeMusic = new Music("src/assets/main-music.wav");
        // plays the music
        themeMusic.play(); //Plays the music
    }

    /**
     * Plays the annoying music for the last level
     */
    public void playMusicLast() {
        // instantiating the music object
        themeMusic = new Music("src/assets/plate-sound.wav");
        // plays the music
        themeMusic.play(); 
    }

    /**
     * Music class for every GameFrame
     */
    public class Music {

        // declaring the attributes of a Music object
        private String name;
        private Clip clip;
        private AudioInputStream sound;

        /**
         * Primary Constructor
         */
        public Music() {
            // initializing the name attribute         
            name = new String();
        }

        /**
         * Secondary Constructor - Must have a music file name
         * @param name
         */
        public Music(String name) {
            // chaining of constructors
            this();
            // initializing the name attribute with the given name parameters
            this.name = name;
            // calling the setFile method
            setFile();
        }

        /**
         * Sets the audio file up
         */
        public void setFile() {
            // using a try-catch to 
            try {
                File file = new File(name);
                sound = AudioSystem.getAudioInputStream(file);
                //System.out.println(sound.toString());
                clip = AudioSystem.getClip();
                //System.out.println(clip.toString());
                clip.open(sound);
            } catch (Exception e) {
                // displays an error message
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }
        }

        // behavior methods
        
        /**
         * Plays the music
         */
        public void play() {
            // starts the audio clip
            clip.start();
        }

        /**
         * Stops the music
         * @throws IOException - Throws an error
         */
        public void stop() throws IOException {
            // close the sound
            sound.close();
            // close the clip
            clip.close();
            // close the clip
            clip.stop();
        }
        
        // getters

        /**
         * Accessor for the name attribute
         * @return Music name
         */
        public String getName() {
            return name;
        }

        /**
         * Accessor for the clip attribute
         * @return Music clip
         */
        public Clip getClip() {
            return clip;
        }

        /**
         * Accessor for the sound attribute
         * @return Music sound
         */
        public AudioInputStream getSound() {
            return sound;
        }
        
        // setters

        /**
         * Mutator for the name attribute
         * @param name Music name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Mutator for the clip attribute
         * @param clip Music clip
         */
        public void setClip(Clip clip) {
            this.clip = clip;
        }

        /**
         * Mutator for the sound attribute
         * @param sound Music sound
         */
        public void setSound(AudioInputStream sound) {
            this.sound = sound;
        }
        
        // standard methods

        /**
         * Standard Java toString() method
         * @return a String containing information about the Music object
         */
        @Override
        public String toString() {
            return "Music{" + "name=" + name + ", clip=" + clip + ", sound=" + sound + '}';
        }
       
        /**
         * Standard Java equals() method
         * @param otherMusic the other Music object being compared to
         * @return whether the two Music objects are identical or not
         */
        public boolean equals(Music otherMusic) {
            return name.equals(otherMusic.getName());
        }
        
        /**
         * Standard Java clone() method
         * @return a new Music object that is a clone of the current Music object
         */
        public Music clone() {
            return new Music(name);
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
