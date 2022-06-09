package mainmenu;

import adventurerush.User;
import game.LevelSelectWindow;
import game.Store;
import game.StoreWindowFrame;
import java.awt.Rectangle;
import loginportal.LoginPortalPrimaryWindow;

public class MainMenuWindow extends javax.swing.JFrame {
    
    // declared attributes of a MainMenuWindow
    private Store currentStore;
    private User currentUser; 
    private MainMenu mainMenu;

    // declared attributes for the JFrames connected to this JFrame
    private final LoginPortalPrimaryWindow previousWindow;
    private StoreWindowFrame storeWindow;
    // private final GameFrameV2 movingBall;
    private LevelSelectWindow nextWindow;
    
    /**
     * Creates new form MainMenuWindow
     * @param previousWindow
     * @param currentStore
     */
    public MainMenuWindow(LoginPortalPrimaryWindow previousWindow, Store currentStore) {
        // call the initComponents method to set up the GUI for this frame
        initComponents();
        // initialize previousWindow attribute with parameter provided
        this.previousWindow = previousWindow;
        // initialize currentStore attribute with parameter provided
        this.currentStore = currentStore;   
        // get currentuser with call to a getter with the previousWindow attribute
        currentUser = previousWindow.getLoginSession();

        nextWindow = new LevelSelectWindow(this);

        if (currentUser.getLastLevel() == 0) {
            loadBtn.setEnabled(false);
        }
        
        updateLabels();
    }
    
    /**
     * Accessor for the currentStore attribute 
     * @return currentStore
     */
    public Store getCurrentStore() {
        return currentStore;
    }
    
    /**
     * Mutator for the currentStore attribute
     * @param currentStore 
     */
    public void setCurrentStore(Store currentStore) {
        this.currentStore = currentStore;
    }
    
    /**
     * Accessor for the currentUser attribute 
     * @return currentUser
     */
    public User getCurrentUser() {
        return currentUser;
    }
    
    /**
     * Mutator for the currentUser attribute
     * @param currentUser 
     */
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    
    /**
     * Accessor for the mainMenu attribute
     * @return mainMenu
     */
    public MainMenu getMainMenu() {
        return mainMenu;
    }
    
    /**
     * Mutator for the mainMenu attribute
     * @param mainMenu 
     */
    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }
    
    public void updateLabels() {
        currencyLabel.setText(Integer.toString(currentUser.getCurrencyPossessed()));
        usernameLabel.setText(currentUser.getUsername());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        newBtn = new javax.swing.JButton();
        loadBtn = new javax.swing.JButton();
        optionsBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        storeBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        currencyLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        titleLabel.setText("Adventure Rush");
        titleLabel.setToolTipText("");

        newBtn.setText("New Game");
        newBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBtnActionPerformed(evt);
            }
        });

        loadBtn.setText("Load Game");

        optionsBtn.setText("Options");

        exitBtn.setText("Log Out");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        storeBtn.setText("Store");
        storeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storeBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("coins");

        currencyLabel.setText("jLabel2");

        jLabel2.setText("Welcome, ");

        usernameLabel.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(titleLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(newBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loadBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(optionsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameLabel)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(currencyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addComponent(storeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(currencyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(usernameLabel))
                .addGap(22, 22, 22)
                .addComponent(titleLabel)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(optionsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(storeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // todo: add actions to enable the user's information being updated in the text file storing their information
        // empty the contents of the text fields on the previous JFrame with a call to the emptyFields method
        previousWindow.emptyFields();
        // captures the location of the current window using a Rectangle object
        final Rectangle bounds = this.getBounds();
        // set the location of the previousWindow window to be consistent with the location of the current window
        previousWindow.setLocation(bounds.x, bounds.y);
        // set this window to be false so that the previousWindow will be the only frame visible
        this.setVisible(false);
        // set the previousWindow object to be visible to the user        
        previousWindow.setVisible(true);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void storeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storeBtnActionPerformed
        // if the storeWindow object hasn't been initialized yet, initialize it
        if (storeWindow == null) {
            // initialize the store if not done already 
            // initializes the storeWindow object according to its type and necessary parameters for its constructor
            storeWindow = new StoreWindowFrame(this);
        }
        // captures the location of the current window using a Rectangle object        
        final Rectangle bounds = this.getBounds();
        // set the location of the storeWindow to be consistent with the location of the current window
        storeWindow.setLocation(bounds.x, bounds.y);
        // set this window to be false so that the storeWindow will be the only frame visible
        this.setVisible(false);
        // set the storeWindow object to be visible to the user                
        storeWindow.setVisible(true);
    }//GEN-LAST:event_storeBtnActionPerformed

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
        this.setVisible(false);
        // movingBall.setVisible(true);
        final Rectangle bounds = this.getBounds();
        // set the location of the nextWindow to be consistent with the location of the current window
        nextWindow.setLocation(bounds.x, bounds.y);
        // set this window to be false so that the nextWindow will be the only frame visible
        nextWindow.setVisible(true);
    }//GEN-LAST:event_newBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel currencyLabel;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loadBtn;
    private javax.swing.JButton newBtn;
    private javax.swing.JButton optionsBtn;
    private javax.swing.JButton storeBtn;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables

}
