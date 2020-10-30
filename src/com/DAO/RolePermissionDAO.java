/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.pojos.Permission;
import com.pojos.Role;

/**
 *
 * @author Turab Bajeer
 */
public interface RolePermissionDAO {
    public Integer addRollPermission(Role r, Permission p);
    public Integer deleteRollPermission(Integer id);
    public Integer getRolePermissionId(Role r, Permission p);
    
}
