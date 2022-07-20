/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Victor
 */
public class SessionHelper {
    static EntityManager entityManager;
    
    public static EntityManager getEntityManager(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("test_jpa");        
        
        if (entityManager==null){
            entityManager = emf.createEntityManager();
            
        }
        
        return entityManager;
    }
}


