/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAOImpl;

import com.DAO.StudentDAO;
import com.dbmanager.DBConnection;
import com.pojos.Batch;
import com.pojos.Fees;
import com.pojos.Student;
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
public class StudentDAOImpl implements StudentDAO {
    
    private static final String TABLE_STUDENT = "student";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DEPARTMENT = "department";
    private static final String COLUMN_PHONE_NUMBER = "phone_number";
    private static final String COLUMN_DATE = "date_of_admission";
    private static final String COLUMN_BATCH_ID = "batch_id";
    private static final String COLUMN_FEES_ID = "fees_id";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_CREATED_BY = "created_by";
    private static final String COLUMN_CREATED_DATE = "created_date";
    private static final String COLUMN_MODIFIED_BY = "modified_by";
    private static final String COLUMN_MODIFIED_DATE = "modified_date";
    private static final String COLUMN_STATUS = "status";
    
    // Queries
    //Query for inserting a student
    private static final String INSERT_STUDENT_QUERY = "insert into "+TABLE_STUDENT+" ("+COLUMN_NAME+","+COLUMN_DEPARTMENT+","+COLUMN_PHONE_NUMBER
                    +","+COLUMN_DATE+","+COLUMN_BATCH_ID+","+COLUMN_FEES_ID+","+COLUMN_ADDRESS+","+COLUMN_CREATED_DATE+","+COLUMN_CREATED_BY+","+COLUMN_STATUS+") values(?,?,?,?,?,?,?,?,?,1)";
    
    // Query for updating a student
    private static final String UPDATE_STUDENT_QUERY = "update "+TABLE_STUDENT+" set "+COLUMN_NAME+" =? ,"+COLUMN_DEPARTMENT+" =? ,"+COLUMN_PHONE_NUMBER+""
                    + " =? ,"+COLUMN_DATE+" =? ,"+COLUMN_BATCH_ID+" =? ,"+COLUMN_FEES_ID+" =? ,"+COLUMN_ADDRESS+"=? ,"+COLUMN_STATUS+"=1,"+COLUMN_MODIFIED_DATE+" =?,"+COLUMN_MODIFIED_BY+"=? where "+COLUMN_ID+" = ?";
    // Query for deleting a student
    private static final String DELETE_STUDENT_QUERY = "update "+TABLE_STUDENT+" set "+COLUMN_STATUS+" =0 where "+COLUMN_ID+" = ?";
    // Querry for searching/getting a particular student
    private static final String GET_STUDENT_QUERY = "select * from "+TABLE_STUDENT+" where "+COLUMN_ID+" =? and "+COLUMN_STATUS+" =1";
    
    // Query for getting all student
    private static final String GET_ALL_STUDENT_QUERY = "select * from "+TABLE_STUDENT+" where "+COLUMN_STATUS+" =1";
    
    private static final String GET_STUDENT_ID_BY_NAME = "select "+COLUMN_ID+" from "+TABLE_STUDENT+" where "+COLUMN_NAME+" =? and "+COLUMN_STATUS+" =1";
    
    Connection conn = DBConnection.getConnection();

    @Override
    public Integer addStudent(Student student) {
        Integer row = null;
        try {
            java.sql.Date sqlDate = new java.sql.Date(student.getDate_of_admission().getTime());
            java.sql.Date createdDate = new java.sql.Date(student.getCreatedDate().getTime());
            
            PreparedStatement pstmt = conn.prepareStatement(INSERT_STUDENT_QUERY);
            pstmt.setString(1, student.getStudentName());
            pstmt.setString(2, student.getDepartment());
            pstmt.setString(3, student.getPhoneNumber());
            pstmt.setDate(4,  sqlDate);
            pstmt.setInt(5, student.getBatch().getBatchId());
            pstmt.setInt(6, student.getFees().getFeesId());
            pstmt.setString(7, student.getAddress());
            pstmt.setDate(8, createdDate);
            pstmt.setString(9, student.getCreatedBy());
            
            row = pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateStudent(Student student) {
        Integer row = null;
        try {
            java.sql.Date sqlDate = new java.sql.Date(student.getDate_of_admission().getTime());
            java.sql.Date modifiedDate = new java.sql.Date(student.getModifiedDate().getTime());
            PreparedStatement pstmt = conn.prepareStatement(UPDATE_STUDENT_QUERY);
            pstmt.setString(1, student.getStudentName());
            pstmt.setString(2, student.getDepartment());
            pstmt.setString(3, student.getPhoneNumber());
            pstmt.setDate(4, sqlDate);
            pstmt.setInt(5, student.getBatch().getBatchId());
            pstmt.setDouble(6, student.getFees().getFeesId());
            pstmt.setString(7, student.getAddress());
            pstmt.setDate(8, modifiedDate);
            pstmt.setString(9, student.getModifiedBy());
            pstmt.setInt(10, student.getStudentId());
            
            row = pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteStudent(Integer id) {
        Integer row = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(DELETE_STUDENT_QUERY);
            pstmt.setInt(1, id);
            
            row = pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Student getStudentById(Integer id) {
        Student student = null;
        ResultSet rs = null;
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(GET_STUDENT_QUERY);
            if(id != null){
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            if(rs.next()){
                student = new Student();
                Batch batch = new Batch();
                batch.setBatchId(rs.getInt(COLUMN_BATCH_ID));
                
                Fees fees = new Fees();
                fees.setFeesId(rs.getInt(COLUMN_FEES_ID));
            
                student.setStudentId(rs.getInt(COLUMN_ID));
                student.setStudentName(rs.getString(COLUMN_NAME));
                student.setDepartment(rs.getString(COLUMN_DEPARTMENT));
                student.setPhoneNumber(rs.getString(COLUMN_PHONE_NUMBER));
                student.setDate_of_admission(rs.getDate(COLUMN_DATE));
                student.setBatch(batch);
                student.setFees(fees);
                student.setAddress(rs.getString(COLUMN_ADDRESS));
                student.setCreatedDate(rs.getDate(COLUMN_CREATED_DATE));
                student.setCreatedBy(rs.getString(COLUMN_CREATED_BY));
                student.setModifiedDate(rs.getDate(COLUMN_MODIFIED_DATE));
                student.setModifiedBy(rs.getString(COLUMN_MODIFIED_BY));
            }
            }

        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        ResultSet rs = null;
        List<Student> allStudents = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(GET_ALL_STUDENT_QUERY);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                java.util.Date utilDate = new java.util.Date(rs.getDate(COLUMN_DATE).getTime());
                Student student = new Student();
                Batch batch = new Batch();
                batch.setBatchId(rs.getInt(COLUMN_BATCH_ID));
                
                Fees fees = new Fees();
                fees.setFeesId(rs.getInt(COLUMN_FEES_ID));
            
                student.setStudentId(rs.getInt(COLUMN_ID));
                student.setStudentName(rs.getString(COLUMN_NAME));
                student.setDepartment(rs.getString(COLUMN_DEPARTMENT));
                student.setPhoneNumber(rs.getString(COLUMN_PHONE_NUMBER));
                student.setDate_of_admission(utilDate);
                student.setBatch(batch);
                student.setFees(fees);
                student.setAddress(rs.getString(COLUMN_ADDRESS));
                student.setCreatedDate(rs.getDate(COLUMN_CREATED_DATE));
                student.setCreatedBy(rs.getString(COLUMN_CREATED_BY));
                student.setModifiedDate(rs.getDate(COLUMN_MODIFIED_DATE));
                student.setModifiedBy(rs.getString(COLUMN_MODIFIED_BY));
                
                allStudents.add(student);
            }

        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
        }
        return allStudents;

    }

    @Override
    public Integer getStudentIdByName(String name) {
        Integer id = null;
        ResultSet rs = null;
        try {
           
            PreparedStatement pstmt = conn.prepareStatement(GET_STUDENT_ID_BY_NAME);
            pstmt.setString(1, name);
            
            rs = pstmt.executeQuery();
            while(rs.next()){
            id = rs.getInt("id");
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return id;
    
    }
    

}
