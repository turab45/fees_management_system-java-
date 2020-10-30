/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.pojos.Week;
import java.util.List;

/**
 *
 * @author Turab Bajeer
 */
public interface WeekDAO {
    public Integer addWeek(Week week);
    public Integer updateWeek(Week week);
    public Integer deleteWeek(Integer id);
    public Week getWeekById(Integer id);
    public List<Week> getAllWeek();
    
}
