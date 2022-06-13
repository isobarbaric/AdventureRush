package game;

import java.awt.Rectangle;
import mainmenu.MainMenuWindow;

public class OptionsWindow extends javax.swing.JFrame {

    private HelperMenuWindow controlWindow;
    private Credits otherWindow;
    private MainMenuWindow firstWindow;
    
    public OptionsWindow(MainMenuWindow firstWindow) {
        this.firstWindow = firstWindow;
        initComponents();
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

        btnMenu.setText("Main Menu");
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
                .addGap(211, 211, 211)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnControls, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lblCredits))
                    .addComponent(btnCredits, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(225, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMenu)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(btnControls, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnMenu)
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditsActionPerformed
        if (otherWindow == null) {
            otherWindow = new Credits(this);
        }
        Rectangle bounds = this.getBounds();
        otherWindow.setLocation(bounds.x, bounds.y);
        this.setVisible(false);
        otherWindow.setVisible(true);
    }//GEN-LAST:event_btnCreditsActionPerformed

    private void btnControlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControlsActionPerformed
        if (controlWindow == null) {
            controlWindow = new HelperMenuWindow(this);
        }
        Rectangle bounds = this.getBounds();
        controlWindow.setLocation(bounds.x, bounds.y);
        this.setVisible(false);
        controlWindow.setVisible(true);
    }//GEN-LAST:event_btnControlsActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        Rectangle bounds = this.getBounds();
        this.setVisible(false); 
        firstWindow.setLocation(bounds.x, bounds.y);
        firstWindow.setVisible(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnControls;
    private javax.swing.JButton btnCredits;
    private javax.swing.JButton btnMenu;
    private javax.swing.JLabel lblCredits;
    // End of variables declaration//GEN-END:variables
}