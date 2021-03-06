/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frames;

import com.DAO.PermissionDAO;
import com.DAO.RoleDAO;
import com.DAOImpl.BatchDAOImpl;
import com.DAOImpl.PermissionDAOImpl;
import com.DAOImpl.RoleDAOImpl;
import com.pojos.Batch;
import com.pojos.Permission;
import com.pojos.Role;
import com.pojos.User;
import java.awt.Font;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


/**
 *
 * @author Turab Bajeer
 */


public class BatchFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddStudent
     */
    
    RoleDAO roleDAOImpl = new RoleDAOImpl();
    User u = LogInFrame.getUser();
    Role r = roleDAOImpl.getRoleById(u.getRole().getRoleId());
    PermissionDAO permissionDAO = new PermissionDAOImpl();
    List<Permission> allAssignedPermission = permissionDAO.getPermissionOf(r.getRoleId());
    
    public BatchFrame() {
        initComponents();
        setResizable(true);
        fillTable();
        batchTable.setRowHeight(30);
        JTableHeader header = batchTable.getTableHeader();
        header.setFont(new java.awt.Font("Tahoma", 0, 18));
        
        addButton.setEnabled(false);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);
        
        setLocation(150, 30);
        
        if(r.getRoleName().equalsIgnoreCase("admin")){
        
            addButton.setEnabled(true);
            updateButton.setEnabled(true);
            deleteButton.setEnabled(true);
            resetButton.setEnabled(true);
        
        }else{
        
            checkPermission();
        }
    }
    
    BatchDAOImpl batchDAOImpl = new BatchDAOImpl();
    static Integer id = null;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        batchTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        resetButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("BATCH");

        batchTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        batchTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        batchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        batchTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                batchTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(batchTable);

        backButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Name");

        nameField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        resetButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        resetButton.setText("RESET");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        addButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(resetButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(updateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateButton)
                .addGap(18, 18, 18)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(resetButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        searchButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        searchField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchField)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(386, 386, 386)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(321, 321, 321)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        
        if(nameField.getText().equals("")){
            
            
            JOptionPane.showMessageDialog(null, null, "Please fill the field!", 0);
           
            
        }else{
        
            String name = nameField.getText().toString();
            
            java.util.Date todayDate = Date.valueOf(LocalDate.now());
            Batch b = new Batch();
            b.setBatchName(name);
            b.setCreatedBy(u.getUserName());
            b.setCreatedDate(todayDate);
            int result = batchDAOImpl.addBatch(b);
            
            if(result > 0){
                JOptionPane.showMessageDialog(null, b.getBatchName()+" added successfully!");
                fillTable();
            }else{
                JOptionPane.showMessageDialog(null, null, "Error", 0);
            
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        
        java.util.Date todayDate = Date.valueOf(LocalDate.now());
        
        Batch b = batchDAOImpl.getBatchById(id);
        b.setBatchName(nameField.getText());
        b.setModifiedDate(todayDate);
        b.setModifiedBy(u.getUserName());
        
        int selection = JOptionPane.showConfirmDialog(null, "Do you want to update Batch: " + b.getBatchName() + "?", null, 0);
        if(selection ==0){
            Integer result = batchDAOImpl.updateBatch(b);
        
        if(result > 0){
        
            JOptionPane.showMessageDialog(null, b.getBatchName()+" Updated Successfully!");
            clearFields();
            fillTable();
        }else{
        
            JOptionPane.showMessageDialog(null, null, "Error", 0);
            fillTable();
        }
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void batchTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_batchTableMouseClicked
        
        
        id = (Integer) batchTable.getValueAt(batchTable.getSelectedRow(), 0);
        
        Batch b = batchDAOImpl.getBatchById(id);
        nameField.setText(b.getBatchName());
    }//GEN-LAST:event_batchTableMouseClicked

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        
        Batch b = batchDAOImpl.getBatchById(id);
       int r =  JOptionPane.showConfirmDialog(null, "Do you want to delete "+b.getBatchName()+"?");
       if(r == 0){
        Integer result = batchDAOImpl.deleteBatch(id);
        
        if(result > 0){
        
            JOptionPane.showMessageDialog(null, b.getBatchName()+" Deleted Successfully!");
            clearFields();
            fillTable();
        }else{
        
            JOptionPane.showMessageDialog(null, null, "Error", 0);
        }
       }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
       clearFields();
       fillTable();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        
        
        if(searchField.getText().equals("") || searchField.getText() == null){
            JOptionPane.showMessageDialog(null, "Enter Batch Name to Search", "Not found!", 0);
        }else{
        String name = searchField.getText().toString();
        Batch b = batchDAOImpl.getBatchById(batchDAOImpl.getbatchIdByName(name));
        
        if(b != null){
            Object columns[]={"ID","Name","Created Date","Created By","Modified Date","Modified By"};
            DefaultTableModel model = new DefaultTableModel(columns, 0);
       
            Object rowData[] = {b.getBatchId(),b.getBatchName(),b.getCreatedDate(),b.getCreatedBy(),b.getCreatedDate(),b.getModifiedBy()};
            
            model.addRow(rowData);
            batchTable.setModel(model);
        
        
        
        }else{
            JOptionPane.showMessageDialog(null, name+" not found!", "Not found!", 0);
        
        }
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
       new HomeFrame().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(BatchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BatchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BatchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BatchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BatchFrame().setVisible(true);
            }
        });
    }
    
    public void fillTable(){
    
        Object columns[]={"ID","Name","Created Date","Created By","Modified Date","Modified By"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        List<Batch> allBatches = batchDAOImpl.getAllBathces();
        
        for(Batch b:allBatches){
            
            Object rowData[] = {b.getBatchId(),b.getBatchName(),b.getCreatedDate(),b.getCreatedBy(),b.getModifiedDate(),b.getModifiedBy()};
            
            model.addRow(rowData);
            batchTable.setModel(model);
        
        }
        
        
    }
    
    public void clearFields(){
    
        nameField.setText(null);
       searchField.setText(null);
       updateButton.setEnabled(false);
       deleteButton.setEnabled(false);
    }
    
    public void checkPermission(){
    
        List<Permission> allPErmission = permissionDAO.getAllPermission();
        
        for(int i=0; i<allAssignedPermission.size(); i++){
        
            if(allAssignedPermission.get(i).getPermission().equalsIgnoreCase("Add batch")){
            
                addButton.setEnabled(true);
            }
            if(allAssignedPermission.get(i).getPermission().equalsIgnoreCase("update batch")){updateButton.setEnabled(true);}
            if(allAssignedPermission.get(i).getPermission().equalsIgnoreCase("delete batch")){deleteButton.setEnabled(true); }
            
        }
        
    }
    
    
    
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTable batchTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
