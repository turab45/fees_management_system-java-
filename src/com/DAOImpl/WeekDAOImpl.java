/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAOImpl;

import com.DAO.WeekDAO;
import com.dbmanager.DBConnection;
import com.pojos.Week;
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
public class WeekDAOImpl implements WeekDAO{
    
    private static final String TABLE_WEEK = "week";
    private static final String COLUMN_ID = "week_id";
    private static final String COLUMN_NAME = "week";
    private static final String COLUMN_CREATED_BY = "created_by";
    private static final String COLUMN_CREATED_DATE = "created_date";
    private static final String COLUMN_MODIFIED_BY = "modified_by";
    private static final String COLUMN_MODIFIED_DATE = "modified_date";
    
    
    // Queries
    //Query for inserting a student
    private static final String INSERT_WEEK_QUERY = "insert into "+TABLE_WEEK+" ("+COLUMN_NAME+","+COLUMN_CREATED_DATE+","+COLUMN_CREATED_BY+") values(?,?,?)";
    
    // Query for updating a student
    private static final String UPDATE_WEEK_QUERY = "update "+TABLE_WEEK+" set "+COLUMN_NAME+" =?,"+COLUMN_CREATED_DATE+"=?,"+COLUMN_CREATED_BY+" where "+COLUMN_ID+" = ?";
    // Query for deleting a student
    private static final String DELETE_WEEK_QUERY = "delete from "+TABLE_WEEK+" where "+COLUMN_ID+" = ?";
    // Querry for searching/getting a particular student
    private static final String GET_WEEK_QUERY = "select * from "+TABLE_WEEK+" where "+COLUMN_ID+" =?";
    
    // Query for getting all student
    private static final String GET_ALL_WEEK_QUERY = "select * from "+TABLE_WEEK;
    
    
    Connection conn = DBConnection.getConnection();

    @Override
    public Integer addWeek(Week week) {
        Integer row = null;
        try {
            
            java.sql.Date createdDate = new Date(week.getCreatedDate().getTime());
            
            PreparedStatement pstmt = conn.prepareStatement(INSERT_WEEK_QUERY);
            pstmt.setString(1, week.getWeekName());
            pstmt.setDate(2, createdDate);
            pstmt.setString(3, week.getCreatedBy());
            
            row = pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;
        
        
    }

    @Override
    public Integer updateWeek(Week week) {
        Integer row = null;
        try {
            
            java.sql.Date createdDate = new Date(week.getModifiedDate().getTime());
            
            PreparedStatement pstmt = conn.prepareStatement(UPDATE_WEEK_QUERY);
            pstmt.setString(1, week.getWeekName());
            pstmt.setDate(2, createdDate);
            pstmt.setString(3, week.getModifiedBy());
            pstmt.setInt(4, week.getWeekId());
            
            row = pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteWeek(Integer id) {
        Integer row = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(DELETE_WEEK_QUERY);
            pstmt.setInt(1, id);
            
            row = pstmt.executeUpdate();
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return row;

    }

    @Override
    public Week getWeekById(Integer id) {
        Week week = null;
        ResultSet rs = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(GET_WEEK_QUERY);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            if(rs.next()){
            
                week = new Week();
                week.setWeekId(rs.getInt(COLUMN_ID));
                week.setWeekName(rs.getString(COLUMN_NAME));
            }
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return week;
    }

    @Override
    public List<Week> getAllWeek() {
        List<Week> allWeeks = new ArrayList<>();
        ResultSet rs = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(GET_ALL_WEEK_QUERY);
            
            
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                Week week = new Week();
                
                week.setWeekId(rs.getInt(COLUMN_ID));
                week.setWeekName(rs.getString(COLUMN_NAME));
                week.setCreatedDate(rs.getDate(COLUMN_CREATED_DATE));
                week.setCreatedBy(rs.getString(COLUMN_CREATED_BY));
                week.setModifiedDate(rs.getDate(COLUMN_MODIFIED_DATE));
                week.setModifiedBy(rs.getString(COLUMN_MODIFIED_BY));
                
                allWeeks.add(week);
            }
            
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            ex.printStackTrace();
        }
        return allWeeks;
    }
    
}
