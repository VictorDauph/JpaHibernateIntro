/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import helper.SessionHelper;
import javax.persistence.*;
import model.Role;
/**
 *
 * @author Victor
 */
public class RoleDao {
    
    private EntityManager entityManager = SessionHelper.getEntityManager();
    Role role;
    
    public Role findById(Long id){
        role = entityManager.find(Role.class, id);        
        return role;
    }
    
    public void createRole(Role role){
        EntityTransaction trans = null;
        try{
            trans= entityManager.getTransaction();
            trans.begin();
                entityManager.persist(role);
            trans.commit();
        }catch(Exception e){
            if (trans != null) trans.rollback();
        }
    }
    
    public void updateRoleDescription(Role role, String description){
        EntityTransaction trans = null;
        try{
            trans= entityManager.getTransaction();
            trans.begin();
              Role newRole = entityManager.merge(role);
              newRole.setDescription(description);
            trans.commit();
        }catch(Exception e){
            if (trans != null) trans.rollback();
        }
    }
}
