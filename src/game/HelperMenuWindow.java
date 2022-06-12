package game;

import movement.GameFrame;

public class HelperMenuWindow extends javax.swing.JFrame {

    OptionsWindow currentGameFrame;
    
    public HelperMenuWindow(OptionsWindow currentGameFrame) {
        initComponents();
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

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/a-key.png"))); // NOI18N
        lblA.setMaximumSize(new java.awt.Dimension(524, 504));

        lblD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/d-key.png"))); // NOI18N

        lblW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/w-key.png"))); // NOI18N

        lblJump.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblJump.setText("Jump");

        lblLeft.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblLeft.setText("Left");

        lblRight.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblRight.setText("Right");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblD)
                            .addComponent(lblW))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblJump)
                                .addGap(13, 124, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLeft)
                                    .addComponent(lblRight))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblW)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblJump)
                        .addGap(14, 14, 14)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lblD)
                        .addGap(0, 51, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lblLeft)
                        .addGap(49, 49, 49)
                        .addComponent(lblRight)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // changes windows
        currentGameFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblA;
    private javax.swing.JLabel lblD;
    private javax.swing.JLabel lblJump;
    private javax.swing.JLabel lblLeft;
    private javax.swing.JLabel lblRight;
    private javax.swing.JLabel lblW;
    // End of variables declaration//GEN-END:variables
}
