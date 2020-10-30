/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAOImpl;

import com.DAO.BatchDAO;
import com.dbmanager.DBConnection;
import com.pojos.Batch;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Turab Bajeer
 */
public class BatchDAOImpl implements BatchDAO{
    
    // Database table and attributes name
    private static final String TABLE_BATCH = "batch";
    private static final String COLUMN_BATCH_ID = "batch_id";
    private static final String COLUMN_BATCH_NAME = "batch_name";
    private static final String COLUMN_CREATED_BY = "created_by";
    private static final String COLUMN_CREATED_DATE = "created_date";
    private static final String COLUMN_MODIFIED_BY = "modified_by";
    private static final String COLUMN_MODIFIED_DATE = "modified_date";
    private static final String COLUMN_STATUS = "status";
    
    // All possible database queries
    private static final String INSERT_BATCH_QUERY = "insert into "+TABLE_BATCH+"("+COLUMN_BATCH_NAME+","+COLUMN_CREATED_DATE+","+COLUMN_CREATED_BY+","+COLUMN_STATUS+") values(?,?,?,1)";
    private static final String UPDATE_BATCH_QUERY = "update "+TABLE_BATCH+" set "+COLUMN_BATCH_NAME+" =? ,"+COLUMN_MODIFIED_DATE+"=?,"+COLUMN_MODIFIED_BY+"=? where "+COLUMN_BATCH_ID+" = ?";
    private static final String DELETE_BATCH_QUERY = "update "+TABLE_BATCH+" set "+COLUMN_STATUS+" = 0 where "+COLUMN_BATCH_ID+" =?";
    private static final String GET_BATCH_BY_ID_QUERY = "select * from "+TABLE_BATCH+" where "+COLUMN_BATCH_ID+" =?";
    private static final String GET_ALL_BATCH_QUERY = "select * from "+TABLE_BATCH+" where "+COLUMN_STATUS+" = 1";
    private static final String GET_BATCH_ID_BY_NAME = "select "+COLUMN_BATCH_ID+" from "+TABLE_BATCH+" where "+COLUMN_BATCH_NAME+" = ?";
    
    
    Connection conn = DBConnection.getConnection();

    @Override
    public Integer addBatch(Batch batch) {
        Integer row = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(INSERT_BATCH_QUERY);
            
            java.sql.Date createdDate = new java.sql.Date(batch.getCreatedDate().getTime());
            
            pstmt.setString(1, batch.getBatchName());
            pstmt.setDate(2, createdDate);
            pstmt.setString(3, batch.getCreatedBy());
            
            
            
            row = pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateBatch(Batch batch) {
        Integer row = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(UPDATE_BATCH_QUERY);
            
            java.sql.Date modifiedDate = new java.sql.Date(batch.getModifiedDate().getTime());
            
            pstmt.setString(1, batch.getBatchName());
            pstmt.setDate(2, modifiedDate);
            pstmt.setString(3, batch.getModifiedBy());
            pstmt.setInt(4, batch.getBatchId());
            
            
            row = pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteBatch(Integer id) {
        Integer row = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(DELETE_BATCH_QUERY);
            pstmt.setInt(1, id);
            
            row = pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;
    }
    

    @Override
    public Batch getBatchById(Integer id) {
        Batch batch = null;
        ResultSet rs = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(GET_BATCH_BY_ID_QUERY);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            if(rs.next()){
                batch = new Batch();
            
                batch.setBatchId(rs.getInt(COLUMN_BATCH_ID));
                batch.setBatchName(rs.getString(COLUMN_BATCH_NAME));
                batch.setCreatedDate(rs.getDate(COLUMN_CREATED_DATE));
                batch.setCreatedBy(rs.getString(COLUMN_CREATED_BY));
                batch.setModifiedDate(rs.getDate(COLUMN_MODIFIED_DATE));
                batch.setModifiedBy(rs.getString(COLUMN_MODIFIED_BY));
               
            }
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return batch;
    }

    @Override
    public List<Batch> getAllBathces() {
        List<Batch> allBatches = new ArrayList<>();
        ResultSet rs = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(GET_ALL_BATCH_QUERY);
            
            
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                Batch batch = new Batch();
                
                batch.setBatchId(rs.getInt(COLUMN_BATCH_ID));
                batch.setBatchName(rs.getString(COLUMN_BATCH_NAME));
                batch.setCreatedDate(rs.getDate(COLUMN_CREATED_DATE));
                batch.setCreatedBy(rs.getString(COLUMN_CREATED_BY));
                batch.setModifiedDate(rs.getDate(COLUMN_MODIFIED_DATE));
                batch.setModifiedBy(rs.getString(COLUMN_MODIFIED_BY));
                
                allBatches.add(batch);
            }
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return allBatches;
    }

    @Override
    public Integer getbatchIdByName(String name) {
        Integer id = null;
        ResultSet rs = null;
        try {
           
            PreparedStatement pstmt = conn.prepareStatement(GET_BATCH_ID_BY_NAME);
            pstmt.setString(1, name);
            
            rs = pstmt.executeQuery();
            while(rs.next()){
            id = rs.getInt("batch_id");
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return id;
    
    }
    
    
    
}
