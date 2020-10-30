/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frames;

import com.DAO.PermissionDAO;
import com.DAO.RoleDAO;
import com.DAO.RolePermissionDAO;
import com.DAOImpl.PermissionDAOImpl;
import com.DAOImpl.RoleDAOImpl;
import com.DAOImpl.RolePermissionDAOImpl;
import static com.frames.NewJDialog.myDialog;
import com.pojos.Permission;
import com.pojos.Role;
import com.pojos.User;
import java.awt.Dialog;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Turab Bajeer
 */
public class HomeFrame extends javax.swing.JFrame {

    /**
     * Creates new form HomeFrame
     */
    RoleDAO roleDAOImpl = new RoleDAOImpl();
    User u = LogInFrame.getUser();
    Role r = roleDAOImpl.getRoleById(u.getRole().getRoleId());
    
    public HomeFrame() {
        initComponents();
        setLocation(150, 30);
        
        
        
        userLabel.setText(r.getRoleName()+"");
        if(r.getRoleName().equalsIgnoreCase("admin")){
        
            assignPermissionButton.setEnabled(true);
        }else{
        
            assignPermissionButton.setEnabled(false);
        }
        
    }
    static Dialog myDialog1 = null;
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        myAccountButton = new javax.swing.JButton();
        batchButton = new javax.swing.JButton();
        userButton = new javax.swing.JButton();
        feesButton = new javax.swing.JButton();
        weekButton = new javax.swing.JButton();
        studentButton = new javax.swing.JButton();
        roleButton = new javax.swing.JButton();
        assignPermissionButton = new javax.swing.JButton();
        userLabel = new javax.swing.JLabel();
        permissionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1341, 811));

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/management_100px.png"))); // NOI18N
        jLabel1.setText("Fees Management System");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/home_48px.png"))); // NOI18N
        jLabel2.setText("Home");

        myAccountButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        myAccountButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/user_50px.png"))); // NOI18N
        myAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myAccountButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(499, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(myAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(myAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );

        batchButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        batchButton.setText("Batch");
        batchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchButtonActionPerformed(evt);
            }
        });

        userButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        userButton.setText("User");
        userButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userButtonActionPerformed(evt);
            }
        });

        feesButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        feesButton.setText("Fees");
        feesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feesButtonActionPerformed(evt);
            }
        });

        weekButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        weekButton.setText("Week");
        weekButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weekButtonActionPerformed(evt);
            }
        });

        studentButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        studentButton.setText("Student");
        studentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentButtonActionPerformed(evt);
            }
        });

        roleButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        roleButton.setText("Role");
        roleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleButtonActionPerformed(evt);
            }
        });

        assignPermissionButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        assignPermissionButton.setText("User Permission");
        assignPermissionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignPermissionButtonActionPerformed(evt);
            }
        });

        userLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        permissionButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        permissionButton.setText("Permission");
        permissionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permissionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(userButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(roleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(studentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(batchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(feesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(permissionButton)
                        .addGap(71, 71, 71)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(weekButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assignPermissionButton))
                .addGap(303, 303, 303))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(weekButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(batchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(feesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(studentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(permissionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assignPermissionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(185, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void batchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchButtonActionPerformed
        this.dispose();
        new BatchFrame().setVisible(true);
       
    }//GEN-LAST:event_batchButtonActionPerformed

    private void feesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feesButtonActionPerformed
        this.dispose();
        new FeesFrame().setVisible(true);
        
    }//GEN-LAST:event_feesButtonActionPerformed

    private void weekButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weekButtonActionPerformed
       this.dispose();
        new WeekFrame().setVisible(true);
       
    }//GEN-LAST:event_weekButtonActionPerformed

    private void studentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentButtonActionPerformed
       this.dispose();
        new StudentFrame().setVisible(true);
       
    }//GEN-LAST:event_studentButtonActionPerformed

    private void userButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userButtonActionPerformed
       this.dispose();
        new UserFrame().setVisible(true);
       
    }//GEN-LAST:event_userButtonActionPerformed

    private void roleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleButtonActionPerformed
      this.dispose();
        new RoleFrame().setVisible(true);
      
    }//GEN-LAST:event_roleButtonActionPerformed

    private void assignPermissionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignPermissionButtonActionPerformed
       this.dispose();
        new AssignPermissionFrame().setVisible(true);
       
    }//GEN-LAST:event_assignPermissionButtonActionPerformed

    private void permissionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permissionButtonActionPerformed
        this.dispose();
        new PermissionFrame().setVisible(true);
       
    }//GEN-LAST:event_permissionButtonActionPerformed

    private void myAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myAccountButtonActionPerformed
       //JOptionPane.showMessageDialog(null, evt, "Hello", JOptionPane.INFORMATION_MESSAGE);
      NewJDialog myDialog = (NewJDialog) NewJDialog.getMyAccountFrame();
      myDialog1 = myDialog;
      myDialog.setVisible(true);
       
    }//GEN-LAST:event_myAccountButtonActionPerformed

    
    public static Dialog getDialog(){
    
        return myDialog1;
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
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignPermissionButton;
    private javax.swing.JButton batchButton;
    private javax.swing.JButton feesButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton myAccountButton;
    private javax.swing.JButton permissionButton;
    private javax.swing.JButton roleButton;
    private javax.swing.JButton studentButton;
    private javax.swing.JButton userButton;
    private javax.swing.JLabel userLabel;
    private javax.swing.JButton weekButton;
    // End of variables declaration//GEN-END:variables
}