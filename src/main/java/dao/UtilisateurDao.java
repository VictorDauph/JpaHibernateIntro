/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.google.protobuf.TextFormat.ParseException;
import helper.SessionHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import model.Role;
import model.Utilisateur;

/**
 *
 * @author Victor
 */
public class UtilisateurDao {
    private EntityManager entityManager = SessionHelper.getEntityManager();
    Utilisateur utilisateur;
    
    public List<Utilisateur> findAll(){
        Query findAllQuery = entityManager.createQuery("select u from Utilisateur u");
        return findAllQuery.getResultList();
    }
    
    public Utilisateur findById(long id){
        utilisateur = entityManager.find(Utilisateur.class, id);        
        return utilisateur;
    }
    
    public void createUtilisateur(Utilisateur newUtilisateur){
        EntityTransaction trans = null;
        try{
            trans= entityManager.getTransaction();
            trans.begin();
                entityManager.persist(newUtilisateur);
            trans.commit();
        }catch(Exception e){
            if (trans != null) trans.rollback();
        }
    }

    public void updateRoleDescription(Utilisateur utilisateur){
        EntityTransaction trans = null;
        try{
            trans= entityManager.getTransaction();
            trans.begin();
              Utilisateur utilisateurToUpdate=findById(utilisateur.getId_utilisateur());
              Utilisateur newUtilisateur = entityManager.merge(utilisateurToUpdate);
            trans.commit();
        }catch(Exception e){
            if (trans != null) trans.rollback();
        }
    }
    
    public void deleteUtilisateur(long id){

        EntityTransaction trans = null;
        try{
            trans= entityManager.getTransaction();
            trans.begin();
            Utilisateur toDelete= findById(id);       
            entityManager.remove(toDelete);
            trans.commit();
        }catch(Exception e){
            if (trans != null) trans.rollback();
        }
    }
    

}
