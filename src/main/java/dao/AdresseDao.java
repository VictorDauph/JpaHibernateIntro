/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import helper.SessionHelper;
import java.util.List;
import javax.persistence.*;
import model.Adresse;
import model.Utilisateur;

/**
 *
 * @author Victor
 */
public class AdresseDao {
    private EntityManager entityManager = SessionHelper.getEntityManager();
    
    public void createAdresse(Adresse newAdresse){

        EntityTransaction trans = null;
        try{
            trans= entityManager.getTransaction();
            trans.begin();
                entityManager.persist(newAdresse);
            trans.commit();
        }catch(Exception e){
            if (trans != null) trans.rollback();
        }
    }
    
    
    public List<Adresse> findByUtilisateur(Utilisateur utilisateurToFind){
        //long userId= utilisateur.getId_utilisateur() ;
        Query findByUserQuery = entityManager.createQuery("select a from Adresse a where a.utilisateur = :utilisateurToFind ")
        .setParameter("utilisateurToFind",utilisateurToFind) ;
        
        return findByUserQuery.getResultList() ;
        
    }
    
    
}
