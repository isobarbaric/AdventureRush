package loginportal;

import mainmenu.MainMenuWindow;
import adventurerush.User;
import game.Sprite;
import game.Store;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import movement.GameFrame;

public final class LoginPortalPrimaryWindow extends javax.swing.JFrame {

    // declared attributes of a LoginPortalPrimaryWindow
    private LoginPortal loginPortal;
    private boolean updatedAnything;
    private User loginSession;
    private int index = 0;

    // declared attributes for the JFrames connected to this JFrame
    private LoginPortalSecondaryWindow secondWindow;
    private MainMenuWindow followingWindow;

    // declared a static variable to keep all the game sprites 
    private static ArrayList<Sprite> gameSprites;

    //Declaring static variables to keep the price of the sprites
    private static int p1 = 5;
    private static int p2 = 10;
    private static int p3 = 15;
    private static int p4 = 20;

    /**
     * Creates new form LoginPortalPrimaryWindow frame
     */
    public LoginPortalPrimaryWindow() {
        // initialize a LoginPortal object of the LoginPortal class
        loginPortal = new LoginPortal();
        // initialize a boolean variable to keep track of changes to the game's user credentials
        updatedAnything = false;
        // call the initComponents method to set up the GUI for this frame
        initComponents();
        // call the loadSprites method to initialize the gameSprites ArrayList if it hasn't been done already
        if (gameSprites == null) {
            loadSprites();
        }
        // load the registered users of this 
        loadRegisteredUsers();
        // set this window to be visible to the user
        this.setVisible(true);
    }

    /**
     * Accessor for the loginPortal attribute
     *
     * @return loginPortal the login portal for the GUI window
     */
    public LoginPortal getLoginPortal() {
        return loginPortal;
    }

    /**
     * Mutator for the loginPortal attribute
     *
     * @param loginPortal the login portal for the GUI window
     */
    public void setLoginPortal(LoginPortal loginPortal) {
        this.loginPortal = loginPortal.clone();
    }

    public ArrayList<Sprite> getGameSprite() {
        return gameSprites;
    }

    public void setGameSprite(ArrayList<Sprite> gameSprites) {
        this.gameSprites = gameSprites;
    }

    /**
     * Accessor for the loginSession attribute
     *
     * @return loginSession a User object representing the currentUser involved
     */
    public User getLoginSession() {
        return loginSession;
    }

    /**
     * Mutator for the loginSession attribute
     *
     * @param loginSession a User object representing the currentUser involved
     */
    public void setLoginSession(User loginSession) {
        this.loginSession = loginSession;
    }

    /**
     * Loads the sprites in this game into the global gameSprites ArrayList
     */
    public void loadSprites() {
        // initializing the gameSprites to a new ArrayList to create a fresh ArrayList OR refresh previous contents
        gameSprites = new ArrayList();

        //Loads the sprites into the array list
        loadArray("src/assets/boy_up_2.png");
        loadArray("src/assets/boy_up_1.png");
        loadArray("src/assets/boy_right_2.png");
    }

    /**
     * Loads the array list with the sprites
     *
     * @param path
     */
    public void loadArray(String path) {
        ///Declaring the variables
        int price;

        //The index equals 0
        if (index == 0) {

            price = p1; //The price of the sprite equals the cost of p1

            //The index equals 1
        } else if (index == 1) {

            price = p2; //The price of the sprite equals the cost of p2

            //The index equals 2
        } else {

            price = p3; //The price of the sprite equals the cost of p3

        }

        //Creates a temporary sprite object and sends the file path
        Sprite temp = new Sprite(path, price);

        //Adds the sprite to the array list
        gameSprites.add(temp);

        index++; //Increases the index
    }

    /**
     * Loads the registered users of the application into the userCredentials
     * attribute
     */
    public void loadRegisteredUsers() {
        // initializing the loginPortal's userCredentials attribute to a new ArrayList to create a fresh ArrayList OR refresh previous contents
        loginPortal.setUserCredentials(new ArrayList());
        // declaring and initializing a Scanner object to a null value 
        Scanner scanner = null;
        try {
            // assigning the Scanner object to the appropriate path containing the 
            scanner = new Scanner(new File("src/adventurerush/loginDetails.txt"));
        } catch (FileNotFoundException e) {
            // change this to some sort of graphical thing later on
            System.out.println("Invalid file path for the file containing information about the users. Please correct this file path and then try running the program again.");
            // returning and stopping execution of the method if the file was not found 
            return;
        }
        // looping over the lines in the file and adding the contents found to the loginPortal's userCredentials attribute
        for (int currentLine = 0; scanner.hasNextLine(); currentLine++) {
            // taking input of the User's username
            String username = scanner.nextLine();
            // taking input of the User's password
            String password = scanner.nextLine();
            // taking input of the last level that the User completed
            int lastLevel = Integer.parseInt(scanner.nextLine());
            // taking input of the currency that the User possesses
            int currencyPossessed = Integer.parseInt(scanner.nextLine());
            // declaring and initializing a new ArrayList to store the Sprites that the User has 
            ArrayList<Sprite> sprites = new ArrayList();
            // taking input of the line containing data about what Sprites the 
            String currentLineData = scanner.nextLine().trim();
            for (int i = 0; i < currentLineData.length(); i++) {
                // if the current character is a '1', indicating that the current User has the 'i'th Sprite, then add this Sprite to their collection
                if (currentLineData.charAt(i) == '1') {
                    // adding the 'i'th sprite to the current User's collection
                    sprites.add(gameSprites.get(i));
                }
            }
            // creating a User object with all of the information just collected about the User
            User currentUser = new User(username, password, currentLine, lastLevel, currencyPossessed, sprites);
            // adding this particular user to the loginPortal's userCredentials attribute by invoking the addUserCredential() method
            loginPortal.addUserCredential(currentUser);
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

        signInLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        usernameTextField = new javax.swing.JTextField();
        signInBtn = new javax.swing.JButton();
        signUpLabel = new javax.swing.JLabel();
        signUpBtn = new javax.swing.JButton();
        usernameStatusLabel = new javax.swing.JLabel();
        passwordStatusLabel = new javax.swing.JLabel();
        exitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        signInLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 22)); // NOI18N
        signInLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signInLabel.setText("Adventure Rush");

        usernameLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        usernameLabel.setText("Username");

        passwordLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        passwordLabel.setText("Password");

        passwordTextField.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        usernameTextField.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        signInBtn.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        signInBtn.setText("Sign In");
        signInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInBtnActionPerformed(evt);
            }
        });

        signUpLabel.setText("Don't have an account? Sign up today!");

        signUpBtn.setText("Create Account");
        signUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpBtnActionPerformed(evt);
            }
        });

        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(signInBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(passwordLabel)
                                .addGap(34, 34, 34)
                                .addComponent(passwordStatusLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(usernameLabel)
                                .addGap(29, 29, 29)
                                .addComponent(usernameStatusLabel))
                            .addComponent(usernameTextField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(signInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(signUpLabel)
                        .addGap(18, 18, 18)
                        .addComponent(signUpBtn))
                    .addComponent(exitBtn))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(exitBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(usernameStatusLabel))
                .addGap(18, 18, 18)
                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordStatusLabel))
                .addGap(18, 18, 18)
                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(signInBtn)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signUpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signUpBtn))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Performs necessary action when the sign-in button is pushed
     *
     * @param evt
     */
    private void signInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInBtnActionPerformed
        // if a new account has been added, then User data needs to be refreshed
        if (updatedAnything) {
            // reloading the register of Users containined by the program
            loadRegisteredUsers();
            // setting the boolean tracking updates to false to indicate that no new changes have been made
            updatedAnything = false;
        }
        // resetting the contents of the usernameStatusLabel to create a fresh login experience
        usernameStatusLabel.setText("");
        // resetting the contents of the passwordStatusLabel to create a fresh login experience
        passwordStatusLabel.setText("");
        // taking input of the username that the user entered in the usernameTextField
        String usernameEntered = usernameTextField.getText().trim();
        // taking input of the password that the user entered in the passwordTextField
        String passwordEntered = passwordTextField.getText().trim();
        // if the input the user provided to the program is nothing for either fields, they will be instructed to change this
        if (usernameEntered.length() == 0 || passwordEntered.length() == 0) {
            // accordingly to which username entered is empty, the corresponding label is set to the appropriate status message
            if (usernameEntered.length() == 0) {
                // setting the usernameStatusLabel to an error message
                usernameStatusLabel.setText("Enter a valid username!");
            } else { // passwordEntered.length() is 0
                // setting the passwordStatusLabel to an error message
                passwordStatusLabel.setText("Enter a valid password!");
            }
            // this method is terminated as invalid input was provided
            return;
        }
        // resetting the contents of the usernameStatusLabel to create a fresh login experience
        usernameStatusLabel.setText("");
        // resetting the contents of the passwordStatusLabel to create a fresh login experience
        passwordStatusLabel.setText("");
        // getting the index of the current user in the global register of users by invoking the findUser method on the loginPortal object
        int userIndex = loginPortal.findUser(usernameEntered);
        // if the user is not found, then display (and refresh) appropriate text fields and label
        if (userIndex == -1) {
            // refreshing the contents in the usernameTextField
            usernameTextField.setText("");
            // refreshing the contents in the passwordTextField
            passwordTextField.setText("");
            // resetting the contents of the usernameStatusLabel to create a fresh login experience           
            usernameStatusLabel.setText("User not found!");
        } else {
            // declaring and initializing a boolean variable to keep track of whether the User entered the correct password as per their identified User 
            boolean loginProcedure = loginPortal.validateCredentials(userIndex, passwordEntered);
            // based on what the status of the login was, appropriate action was taken
            if (loginProcedure) {
                // this section of code represents the scenario where the user was found and the equivalently correct password was entered
                loginSession = loginPortal.getSpecificUserCredentials(userIndex);
                // moving the user onto the game as their login was successful
                loginTransition(userIndex);
            } else {
                // this section of code represents the scenario where the user was found and an incorrect password was entered
                passwordStatusLabel.setText("Incorrect password!");
                // refreshing the contents in the passwordTextField
                passwordTextField.setText("");
            }
        }
    }//GEN-LAST:event_signInBtnActionPerformed

    /**
     * Provides the transition to the subsequent main menu window after a
     * successful login attempt
     *
     * @param userIndex the index of that the user
     */
    private void loginTransition(int userIndex) {
        // if the followingWindow object hasn't been initialized yet, initialize it
        if (followingWindow == null) {
            Store currentStore = new Store("Sprite Shop!");
            currentStore.setStoreItems(gameSprites);
            followingWindow = new MainMenuWindow(this, currentStore);
            followingWindow.updateLabels();
        }
        // captures the location of the current window using a Rectangle object
        final Rectangle bounds = this.getBounds();
        // set the location of the followingWindow to be consistent with the location of the current window
        followingWindow.setLocation(bounds.x, bounds.y);
        // set this window to be false so that the main menu will be the only menu visible
        this.setVisible(false);
        // set the followingWindow object to be visible to the user
        followingWindow.setVisible(true);
    }

    /**
     * Performs necessary action when the user wishes to sign up as a new user
     * for the application
     *
     * @param evt
     */
    private void signUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpBtnActionPerformed
        // if the secondWindow object hasn't been initialized yet, initialize it
        if (secondWindow == null) {
            // initializes the secondWindow object according to its type and necessary parameters for its constructor
            secondWindow = new LoginPortalSecondaryWindow(this);
        }
        // resetting the contents of the usernameStatusLabel to create a fresh login experience
        usernameStatusLabel.setText("");
        // resetting the contents of the passwordStatusLabel to create a fresh login experience
        passwordStatusLabel.setText("");
        // captures the location of the current window using a Rectangle object
        final Rectangle bounds = this.getBounds();
        // set the location of the secondWindow to be consistent with the location of the current window
        secondWindow.setLocation(bounds.x, bounds.y);
        // set this window to be false so that the main menu will be the only menu visible
        this.setVisible(false);
        // set the secondWindow object to be visible to the user        
        secondWindow.setVisible(true);
        // setting the boolean tracking updates to true to indicate that changes have been made
        updatedAnything = true;
    }//GEN-LAST:event_signUpBtnActionPerformed

    /**
     * Exits the application upon prompted by the user by pushing the exit
     * button
     *
     * @param evt
     */
    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // exits the application by using the System.exit() method
        System.exit(0);
    }//GEN-LAST:event_exitBtnActionPerformed

    /**
     * Empties the contents of the text fields for the username and password
     * (enables the clearing of these two fields from another class)
     */
    public void emptyFields() {
        // refreshing the contents in the usernameTextField
        usernameTextField.setText("");
        // refreshing the contents in the passwordTextField
        passwordTextField.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPortalPrimaryWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPortalPrimaryWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPortalPrimaryWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPortalPrimaryWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPortalPrimaryWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordStatusLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JButton signInBtn;
    private javax.swing.JLabel signInLabel;
    private javax.swing.JButton signUpBtn;
    private javax.swing.JLabel signUpLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel usernameStatusLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
