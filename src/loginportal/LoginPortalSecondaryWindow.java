package loginportal;

import mainmenu.User;
import java.awt.Rectangle;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LoginPortalSecondaryWindow extends javax.swing.JFrame {
    
    // declared an attribute for the JFrame connected to this JFrame
    LoginPortalPrimaryWindow mainWindow;

    /**
     * Creates new form LoginPortalCreateAccountFrame
     * @param mainWindow
     */
    public LoginPortalSecondaryWindow(LoginPortalPrimaryWindow mainWindow) {
        // call the initComponents method to set up the GUI for this frame
        initComponents();
        // initialize mainWindow attribute with parameter provided
        this.mainWindow = mainWindow;
        // captures the location of the current window using a Rectangle object
        final Rectangle bounds = mainWindow.getBounds();
        // set the location of the current window to be consistent with the location of the current window
        this.setLocation(bounds.x, bounds.y);
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
        usernameTextField = new javax.swing.JTextField();
        signUpBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        passwordTextField = new javax.swing.JPasswordField();
        signUpStatusLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        signInLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 22)); // NOI18N
        signInLabel.setText("Adventure Rush");

        usernameLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        usernameLabel.setText("Enter your new username:");

        passwordLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        passwordLabel.setText("Enter your new password:");

        signUpBtn.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        signUpBtn.setText("Sign Up!");
        signUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpBtnActionPerformed(evt);
            }
        });

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(signInLabel)
                .addContainerGap(176, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(passwordTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addComponent(usernameLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(signUpStatusLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(passwordLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(signUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(signInLabel)
                .addGap(30, 30, 30)
                .addComponent(signUpStatusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(usernameLabel)
                .addGap(17, 17, 17)
                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(passwordLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(signUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(backBtn)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpBtnActionPerformed
        // resetting the contents of the signUpStatusLabel to create a fresh login experience
        signUpStatusLabel.setText("");
        // taking input of the username that the user entered in the usernameTextField
        String usernameEntered = usernameTextField.getText().trim();
        // taking input of the password that the user entered in the passwordTextField
        String passwordEntered = passwordTextField.getText().trim();
        // if the input the user provided to the program is nothing for either fields, they will be instructed to change this
        if (usernameEntered.length() == 0 || passwordEntered.length() == 0) {
            // accordingly to which username entered is empty, the corresponding label is set to the appropriate status message
            if (usernameEntered.length() == 0) {
                // setting the usernameStatusLabel to an error message
                signUpStatusLabel.setText("Enter a valid username!");
            } else { // passwordEntered.length() is 0
                // setting the passwordStatusLabel to an error message
                signUpStatusLabel.setText("Enter a valid password!");
            }
            // this method is terminated as invalid input was provided
            return;
        }
        // collecting the register of users from the mainWindow that linked to this JFrame initially
        ArrayList<User> existingUsers = mainWindow.getLoginPortal().getUserCredentials();
        // getting the index of the user, if it exists, by a call to the mainWindow's loginPortal object
        int userIndex = mainWindow.getLoginPortal().findUser(usernameEntered);
        // if the username exists, then set the appropriate labels to their error messages and terminate execution
        if (userIndex != -1) {
            // setting the signUpStatusLabel to an error message
            signUpStatusLabel.setText("Username already exists!");
            // refreshing the contents in the usernameTextField
            usernameTextField.setText("");
            // refreshing the contents in the passwordTextField
            passwordTextField.setText("");
            // this method is terminated as invalid input was provided
            return;
        }
        // declaring a FileWriter object to write to a file
        FileWriter writer = null;
        try {
            // providing the appropriate file path for the file containing the register of users
            writer = new FileWriter("src/adventurerush/loginDetails.txt", true);
            // adding the necessary information about the current user into the file with the writer project
            writer.append("\n" + usernameEntered + "\n" + passwordEntered + "\n" + 0 + "\n" + "1000000000");
            // calling the flush() method on the writer object to get its changes onto the 
            writer.flush();
        } catch (IOException e) {
            // change this to some sort of graphical thing later on
            System.out.println("Invalid file path for the file containing information about the users. Please correct this file path and then try running the program again.");
            // TODO: display some kind of error message 
            return;
        }
        // set this window to be false so that the main menu will be the only menu visible
        this.setVisible(false);
        // set the mainWindow object to be visible to the user        
        mainWindow.setVisible(true);
    }//GEN-LAST:event_signUpBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // set this window to be false so that the main menu will be the only menu visible
        this.setVisible(false);
        // set the mainWindow object to be visible to the user        
        mainWindow.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JLabel signInLabel;
    private javax.swing.JButton signUpBtn;
    private javax.swing.JLabel signUpStatusLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
