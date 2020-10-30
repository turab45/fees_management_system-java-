/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAOImpl;

import com.DAO.RolePermissionDAO;
import com.dbmanager.DBConnection;
import com.pojos.Permission;
import com.pojos.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Turab Bajeer
 */
public class RolePermissionDAOImpl implements RolePermissionDAO{
    Connection conn = DBConnection.getConnection();

    @Override
    public Integer addRollPermission(Role r, Permission p) {
        Integer row = null;
        try {
            String query = "insert into role_permission (role_id,permission_id) values(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setInt(1, r.getRoleId());
            pstmt.setInt(2, p.getPermissionId());
            
            row = pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
            e.printStackTrace();
        }
        return row; 
    }

    @Override
    public Integer deleteRollPermission(Integer id) {
        Integer row = null;
        try {
            String query = "delete from  role_permission where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setInt(1, id);
            
            row = pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
            e.printStackTrace();
        }
        return row; 
    }

    @Override
    public Integer getRolePermissionId(Role r, Permission p) {
                Integer id = null;
                ResultSet rs = null;
        try {
            String query = "select id from  role_permission where role_id = ? and permission_id =?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setInt(1, r.getRoleId());
            pstmt.setInt(2, p.getPermissionId());
            
            rs = pstmt.executeQuery();
            
            if(rs.next()){
            
                id = rs.getInt("id");
            }
            
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
            e.printStackTrace();
        }
        return id; 

    }
    
}
