package game;

import java.awt.Rectangle;

public class HelperMenuWindow extends javax.swing.JFrame {

    // attributes of a HelperMenuWindow object
    OptionsWindow currentGameFrame;
    
    /**
     * Primary constructor
     * @param currentGameFrame 
     */
    public HelperMenuWindow(OptionsWindow currentGameFrame) {
        // setting up the GUI with a call to the initComponents method
        initComponents();
        // initializing the currentGameFrame attribute with the provided currentGameFrame attribute
        this.currentGameFrame = currentGameFrame;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lblA = new javax.swing.JLabel();
        lblD = new javax.swing.JLabel();
        lblW = new javax.swing.JLabel();
        lblJump = new javax.swing.JLabel();
        lblLeft = new javax.swing.JLabel();
        lblRight = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblEsc = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/a-key.png"))); // NOI18N
        lblA.setMaximumSize(new java.awt.Dimension(524, 504));

        lblD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/d-key.png"))); // NOI18N

        lblW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/w-key.png"))); // NOI18N

        lblJump.setFont(new java.awt.Font("Helvetica Neue", 0, 22)); // NOI18N
        lblJump.setText("Jump");

        lblLeft.setFont(new java.awt.Font("Helvetica Neue", 0, 22)); // NOI18N
        lblLeft.setText("Left");

        lblRight.setFont(new java.awt.Font("Helvetica Neue", 0, 22)); // NOI18N
        lblRight.setText("Right");

        btnBack.setText("Return");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 22)); // NOI18N
        jLabel1.setText("Leave a Level");

        lblEsc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/esc key.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblD))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblW)
                        .addGap(1, 1, 1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblEsc)
                        .addGap(85, 85, 85))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblJump)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRight)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLeft)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(47, 47, 47))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lblW)
                .addGap(43, 43, 43)
                .addComponent(lblA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(lblRight)
                        .addGap(75, 75, 75))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblD)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnBack)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblJump)
                        .addGap(75, 75, 75)
                        .addComponent(lblLeft)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(lblEsc, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Provides functionality for when the back button is clicked
     * @param evt the action of clicking the back button
     */    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // setting the HelperMenuWindow to be invisible
        this.setVisible(false);
        // captures the location of the current window using a Rectangle object        
        final Rectangle bounds = this.getBounds();
        // set the location of the currentGameFrame to be consistent with the location of the current window
        currentGameFrame.setLocation(bounds.x, bounds.y);
        // set this window to be false so that the currentGameFrame will be the only frame visible
        this.setVisible(false);
        // set the currentGameFrame object to be visible to the user                
        currentGameFrame.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblA;
    private javax.swing.JLabel lblD;
    private javax.swing.JLabel lblEsc;
    private javax.swing.JLabel lblJump;
    private javax.swing.JLabel lblLeft;
    private javax.swing.JLabel lblRight;
    private javax.swing.JLabel lblW;
    // End of variables declaration//GEN-END:variables
}
