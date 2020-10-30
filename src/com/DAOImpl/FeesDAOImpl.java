/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAOImpl;

import com.DAO.FeesDAO;
import com.dbmanager.DBConnection;
import com.pojos.Fees;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Turab Bajeer
 */
public class FeesDAOImpl implements FeesDAO{
    
    // Database table and attributes name
    private static final String TABLE_FEES = "fees";
    private static final String COLUMN_FEES_ID = "fees_id";
    private static final String COLUMN_FEES_AMOUNT = "fees_amount";
    private static final String COLUMN_CREATED_BY = "created_by";
    private static final String COLUMN_CREATED_DATE = "created_date";
    private static final String COLUMN_MODIFIED_BY = "modified_by";
    private static final String COLUMN_MODIFIED_DATE = "modified_date";
    
    // All possible database queries
    private static final String INSERT_FEES_QUERY = "insert into "+TABLE_FEES+"("+COLUMN_FEES_AMOUNT+","+COLUMN_CREATED_DATE+","+COLUMN_CREATED_BY+") values(?,?,?)";
    private static final String UPDATE_FEES_QUERY = "update "+TABLE_FEES+" set "+COLUMN_FEES_AMOUNT+", "+COLUMN_MODIFIED_DATE+","+COLUMN_MODIFIED_BY+" =? where "+COLUMN_FEES_ID+" =?";
    private static final String DELETE_FEES_QUERY = "delete from "+TABLE_FEES+" where "+COLUMN_FEES_ID+" =?";
    private static final String GET_FEES_BY_ID_QUERY = "select * from "+TABLE_FEES+" where "+COLUMN_FEES_ID+" =?";
    private static final String GET_ALL_FEES_QUERY = "select * from "+TABLE_FEES;
    private static final String GET_FEES_ID_BY_AMOUNT = "select "+COLUMN_FEES_ID+" from "+TABLE_FEES+" where "+COLUMN_FEES_AMOUNT+" = ?";

    Connection conn = DBConnection.getConnection();
    
    @Override
    public Integer addFees(Fees fees) {
        Integer row = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(INSERT_FEES_QUERY);
            java.sql.Date sqlDate = new Date(fees.getCreatedDate().getTime());
            pstmt.setInt(1, fees.getFeesAmount());
            pstmt.setDate(2, sqlDate);
            pstmt.setString(3, fees.getModifiedBy());
            
            row = pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateFees(Fees fees) {
         Integer row = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(UPDATE_FEES_QUERY);
            
            java.sql.Date sqlDate = new Date(fees.getModifiedDate().getTime());
            
            pstmt.setInt(1, fees.getFeesAmount());
            pstmt.setDate(2, sqlDate);
            pstmt.setString(3, fees.getModifiedBy());
            pstmt.setInt(4, fees.getFeesId());
            
            row = pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteFees(Integer id) {
        Integer row = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(DELETE_FEES_QUERY);
            pstmt.setInt(1, id);
            
            row = pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;
    }

    @Override
    public Fees getFeesById(Integer id) {
        Fees fees = null;
        ResultSet rs = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(GET_FEES_BY_ID_QUERY);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            if(rs.next()){
            
                fees = new Fees();
                fees.setFeesId(rs.getInt(COLUMN_FEES_ID));
                fees.setFeesAmount(rs.getInt(COLUMN_FEES_AMOUNT));
                fees.setCreatedDate(rs.getDate(COLUMN_CREATED_DATE));
                fees.setCreatedBy(rs.getString(COLUMN_CREATED_BY));
                fees.setModifiedDate(rs.getDate(COLUMN_MODIFIED_DATE));
                fees.setModifiedBy(rs.getString(COLUMN_MODIFIED_BY));
            }
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return fees;
    }

    @Override
    public List<Fees> getAllFees() {
        List<Fees> allFeeses = new ArrayList<>();
        ResultSet rs = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(GET_ALL_FEES_QUERY);
            
            
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                Fees fees = new Fees();
                
                fees.setFeesId(rs.getInt(COLUMN_FEES_ID));
                fees.setFeesAmount(rs.getInt(COLUMN_FEES_AMOUNT));
                fees.setCreatedDate(rs.getDate(COLUMN_CREATED_DATE));
                fees.setCreatedBy(rs.getString(COLUMN_CREATED_BY));
                fees.setModifiedDate(rs.getDate(COLUMN_MODIFIED_DATE));
                fees.setModifiedBy(rs.getString(COLUMN_MODIFIED_BY));
                
                allFeeses.add(fees);
            }
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return allFeeses;
    }

    @Override
    public Integer getfeesIdByAmount(Double amount) {
        Integer id = null;
        ResultSet rs = null;
        try {
           
            PreparedStatement pstmt = conn.prepareStatement(GET_FEES_ID_BY_AMOUNT);
            pstmt.setDouble(1, amount);
            
            rs = pstmt.executeQuery();
            while(rs.next()){
            id = rs.getInt("fees_id");
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return id;
    }
    
    
    
}
