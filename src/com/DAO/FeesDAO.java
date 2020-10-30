/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.pojos.Fees;
import java.util.List;

/**
 *
 * @author Turab Bajeer
 */
public interface FeesDAO {
    public Integer addFees(Fees fees);
    public Integer updateFees(Fees fees);
    public Integer deleteFees(Integer id);
    public Fees getFeesById(Integer id);
    public List<Fees> getAllFees();
    public Integer getfeesIdByAmount(Double amount);
    
}
