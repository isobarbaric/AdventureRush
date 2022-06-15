package game;

import java.awt.Rectangle;
import mainmenu.MainMenuWindow;

public class OptionsWindow extends javax.swing.JFrame {

    // attributes of a OptionsWindow object
    private HelperMenuWindow controlWindow;
    private Credits otherWindow;
    private MainMenuWindow firstWindow;
    
    /**
     * Primary constructor
     * @param firstWindow 
     */
    public OptionsWindow(MainMenuWindow firstWindow) {
        // setting up the GUI with a call to the initComponents method
        initComponents();

        // initializing firstWindow with the given parameter firstWindow
        this.firstWindow = firstWindow;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnControls = new javax.swing.JButton();
        lblCredits = new javax.swing.JLabel();
        btnCredits = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnControls.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnControls.setText("Controls");
        btnControls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlsActionPerformed(evt);
            }
        });

        lblCredits.setFont(new java.awt.Font("Helvetica Neue", 1, 22)); // NOI18N
        lblCredits.setText("Options");

        btnCredits.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnCredits.setText("Credits");
        btnCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditsActionPerformed(evt);
            }
        });

        btnMenu.setText("Return");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCredits)
                .addGap(80, 80, 80)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnControls, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnMenu)))
                .addGap(29, 29, 29)
                .addComponent(btnControls, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditsActionPerformed
        // initializing the otherWindow attribute if not done already
        if (otherWindow == null) {

            // initializing the otherWindow attribute
            otherWindow = new Credits(this);
        }

        // setting the credits window to be invisible
        this.setVisible(false);

        // captures the location of the current window using a Rectangle object        
        final Rectangle bounds = this.getBounds();

        // set the location of the storeWindow to be consistent with the location of the current window
        otherWindow.setLocation(bounds.x, bounds.y);

        // set this window to be false so that the storeWindow will be the only frame visible
        this.setVisible(false);

        // set the storeWindow object to be visible to the user                
        otherWindow.setVisible(true);        
    }//GEN-LAST:event_btnCreditsActionPerformed

    private void btnControlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControlsActionPerformed
        // initializing the controlWindow attribute if not done already
        if (controlWindow == null) {

            // initializing the controlWindow attribute
            controlWindow = new HelperMenuWindow(this);
        }

        // setting the credits window to be invisible
        this.setVisible(false);

        // captures the location of the current window using a Rectangle object        
        final Rectangle bounds = this.getBounds();

        // set the location of the storeWindow to be consistent with the location of the current window
        controlWindow.setLocation(bounds.x, bounds.y);

        // set this window to be false so that the storeWindow will be the only frame visible
        this.setVisible(false);

        // set the storeWindow object to be visible to the user                
        controlWindow.setVisible(true);
    }//GEN-LAST:event_btnControlsActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // setting the OptionsWindow to be invisible
        this.setVisible(false); 

        // captures the location of the current window using a Rectangle object                
        Rectangle bounds = this.getBounds();

        // set the location of the firstWindow to be consistent with the location of the current window
        firstWindow.setLocation(bounds.x, bounds.y);

        // set the firstWindow object to be visible to the user                
        firstWindow.setVisible(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnControls;
    private javax.swing.JButton btnCredits;
    private javax.swing.JButton btnMenu;
    private javax.swing.JLabel lblCredits;
    // End of variables declaration//GEN-END:variables
}
