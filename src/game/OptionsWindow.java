/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package game;

import mainmenu.MainMenuWindow;

/**
 *
 * @author Christopher
 */
public class OptionsWindow extends javax.swing.JFrame {

    private HelperMenuWindow controls;
    private Credits otherWindow;
    private MainMenuWindow firstWindow;
    
    public OptionsWindow(MainMenuWindow m) {
        initComponents();
        
        firstWindow = m;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnControls = new javax.swing.JButton();
        lblCredits = new javax.swing.JLabel();
        btnCredits = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnControls.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnControls.setText("Controls");
        btnControls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlsActionPerformed(evt);
            }
        });

        lblCredits.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblCredits.setText("Options");

        btnCredits.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCredits)))
                .addContainerGap(258, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMenu)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnControls, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btnCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(btnMenu)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditsActionPerformed
      
        if (otherWindow == null) {
            
            otherWindow = new Credits(this);
        }
        
        otherWindow.setVisible(true);
        
        this.setVisible(false);
        
    }//GEN-LAST:event_btnCreditsActionPerformed

    private void btnControlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControlsActionPerformed
        
        if (controls == null) {
            
            controls = new HelperMenuWindow(this);
        }
        
        controls.setVisible(true);
        
        this.setVisible(false);
        
        
    }//GEN-LAST:event_btnControlsActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        
        firstWindow.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnMenuActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnControls;
    private javax.swing.JButton btnCredits;
    private javax.swing.JButton btnMenu;
    private javax.swing.JLabel lblCredits;
    // End of variables declaration//GEN-END:variables
}
