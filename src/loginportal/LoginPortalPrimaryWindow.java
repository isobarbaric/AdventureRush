package loginportal;

import mainmenu.MainMenuWindow;
import adventurerush.User;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public final class LoginPortalPrimaryWindow extends javax.swing.JFrame {

    // attributes of a LoginPortalTemp object
    private ArrayList<User> userCredentials;
    private LoginPortalSecondaryWindow secondWindow;
    private MainMenuWindow followingWindow;
    private boolean updatedAnything;

    /**
     * Creates new form LoginPortalFrame
     */
    public LoginPortalPrimaryWindow() {
        userCredentials = new ArrayList();
        updatedAnything = false;
        loadRegisteredUsers();
        initComponents();
        this.setVisible(true);
    }

    // getters 
    
    public ArrayList<User> getUserCredentials() {
        return userCredentials;
    }
    
    public User getSpecificUserCredentials(int userIndex) {
        return userCredentials.get(userIndex);
    }

    // setters
    
    public void setUserCredentials(ArrayList<User> userCredentials) {
        this.userCredentials = userCredentials;
    }

    public void setSpecificUserCredentials(User currentUser, int userIndex) {
        userCredentials.set(userIndex, currentUser);
    }
    
    // behavior 
    
    public void loadRegisteredUsers() {
        userCredentials.clear();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/adventurerush/loginDetails.txt"));
        } catch (FileNotFoundException e) {
            // change this to some sort of graphical thing later on
            System.out.println("Invalid file path for the file containing information about the users. Please correct this file path and then try running the program again.");
            return;
        }
        while (scanner.hasNextLine()) {
            String username = scanner.nextLine();
            String password = scanner.nextLine();
            int lastLevel = Integer.parseInt(scanner.nextLine());
            int currencyPossessed = Integer.parseInt(scanner.nextLine());
            User currentUser = new User(username, password, lastLevel, currencyPossessed);
            userCredentials.add(currentUser);
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
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(signUpLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(signInBtn)))
                        .addGap(18, 18, 18)
                        .addComponent(signUpBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(signInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(usernameTextField))))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitBtn)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signUpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signUpBtn))
                .addGap(38, 38, 38))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInBtnActionPerformed
        if (updatedAnything) {
            loadRegisteredUsers();
            updatedAnything = false;
        }
        
        usernameStatusLabel.setText("");
        passwordStatusLabel.setText("");
        
        String usernameEntered = usernameTextField.getText().trim();
        String passwordEntered = passwordTextField.getText().trim();

        if (usernameEntered.length() == 0 || passwordEntered.length() == 0) {
            if (usernameEntered.length() == 0) {
                usernameStatusLabel.setText("Enter a valid username!");
            } else { // passwordEntered.length() == 0
                passwordStatusLabel.setText("Enter a valid password!");
            }
            return;
        }
        
        usernameStatusLabel.setText("");
        passwordStatusLabel.setText("");
        
        int userIndex = findUser(usernameEntered);
        if (userIndex == -1) {
            // user not found
            usernameTextField.setText("");
            passwordTextField.setText("");
            usernameStatusLabel.setText("User not found!");
        } else {
            boolean loginProcedure = validateCredentials(userIndex, passwordEntered);
            if (loginProcedure) {
                // user found and correct password
                loginTransition();
            } else {
                // user found, but incorrect password
                passwordStatusLabel.setText("Incorrect password!");
                passwordTextField.setText("");
            }
        }

    }//GEN-LAST:event_signInBtnActionPerformed

    private void loginTransition() {
        if (followingWindow == null) {
            followingWindow = new MainMenuWindow();
        }
        final Rectangle bounds = this.getBounds();
        followingWindow.setLocation(bounds.x, bounds.y);
        followingWindow.setVisible(true);
        this.setVisible(false);
    }
    
    private void signUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpBtnActionPerformed
        if (secondWindow == null) {
            secondWindow = new LoginPortalSecondaryWindow(this);
        }
        usernameStatusLabel.setText("");
        passwordStatusLabel.setText("");
        secondWindow.setVisible(true);
        this.setVisible(false);
        updatedAnything = true;
    }//GEN-LAST:event_signUpBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitBtnActionPerformed

    private int findUser(String usernameEntered) {
        for (int i = 0; i < userCredentials.size(); i++) {
            if (userCredentials.get(i).getUsername().equals(usernameEntered)) {
                return i;
            }
        }
        return -1;
    }

    private boolean validateCredentials(int userIndex, String passwordEntered) {
        return userCredentials.get(userIndex).getPassword().equals(passwordEntered);
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
