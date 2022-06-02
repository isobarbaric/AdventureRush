package game;

import adventurerush.User;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JLabel;
import mainmenu.MainMenuWindow;

public class StoreWindowFrame extends javax.swing.JFrame {

    private MainMenuWindow mainWindow;
    private int currentIndex;
    private User currentUser;
    private ArrayList<Sprite> spriteStore;
    private Store currentStore;

    
    /**
     * Creates new form StoreWindowFrame
     * @param mainWindow
     * @param currentStore
     */
    public StoreWindowFrame(MainMenuWindow mainWindow, Store currentStore) {
        initComponents();
        this.mainWindow = mainWindow;
        final Rectangle bounds = mainWindow.getBounds();
        this.setLocation(bounds.x, bounds.y);
        currentIndex = 0;
        currentUser = mainWindow.getCurrentUser();
        currentStore = new Store();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        prevBtn = new javax.swing.JToggleButton();
        nextBtn = new javax.swing.JToggleButton();
        buyBtn = new javax.swing.JToggleButton();
        leaveBtn = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        imgLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        prevBtn.setText("Previous Sprite");
        prevBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevBtnActionPerformed(evt);
            }
        });

        nextBtn.setText("Next Sprite");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        buyBtn.setText("Buy");

        leaveBtn.setText("Leave Store");
        leaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 22)); // NOI18N
        jLabel1.setText("Store");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jLabel3.setText("Cost:");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jLabel4.setText("Purchased Already:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(prevBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nextBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(leaveBtn)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(121, 121, 121))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(buyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(343, 343, 343)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(imgLabel))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(leaveBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(prevBtn)
                        .addGap(22, 22, 22)
                        .addComponent(imgLabel)
                        .addGap(35, 35, 35)
                        .addComponent(nextBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(104, 104, 104)
                        .addComponent(jLabel4)))
                .addGap(82, 82, 82)
                .addComponent(buyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prevBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevBtnActionPerformed
        currentIndex--;
        if (currentIndex < 0) {
            currentIndex = 2;
        }
        updateStatus();
        loadSpecificSprite();
    }//GEN-LAST:event_prevBtnActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        currentIndex++;
        if (currentIndex > 2) {
            currentIndex = 0;
        }
        updateStatus();
        loadSpecificSprite();
    }//GEN-LAST:event_nextBtnActionPerformed

    private void leaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveBtnActionPerformed
        mainWindow.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_leaveBtnActionPerformed

    public void loadSpecificSprite() {
        imgLabel = new JLabel(currentStore.getSpecificStoreItem(currentIndex).getSpriteCharacter());
    }
    
    public void updateStatus() {
        // if the sprite is purchased
        if (currentStore.getSpecificStoreItem(currentIndex).getPurchasedAlready()) {
            buyBtn.setEnabled(false); //Disables the button
            buyBtn.setText("true");
        } else {  // if the sprite isn't purchased
            // don't have enough money
            if (currentUser.getCurrencyPossessed() < currentStore.getSpecificStoreItem(currentIndex).getCostToPurchase()) {
                return;
            }    
            buyBtn.setEnabled(true); //Enables the button
            buyBtn.setText(Integer.toString(currentStore.getSpecificStoreItem(currentIndex).getCostToPurchase())); //Displays the cost of the sprite
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton buyBtn;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JToggleButton leaveBtn;
    private javax.swing.JToggleButton nextBtn;
    private javax.swing.JToggleButton prevBtn;
    // End of variables declaration//GEN-END:variables
}
