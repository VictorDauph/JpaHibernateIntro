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
        
    public List<Adresse> findByUtilisateur(Utilisateur utilisateurToFind){
        //long userId= utilisateur.getId_utilisateur() ;
        Query findByUserQuery = entityManager.createQuery("select a from Adresse a where a.utilisateur = :utilisateurToFind ")
        .setParameter("utilisateurToFind",utilisateurToFind) ;
        
        return findByUserQuery.getResultList() ;
        
    }
    
    
    public void create(Adresse adresseToCreate) {

        // On vérifie les données que l'on reçoit en paramètre

        if (adresseToCreate == null) {
            System.out.println("L'objet adresse ne peut pas être null");
            return;

        }

        // On déclare notre transaction avec pour valeur par défaut null
        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.persist(adresseToCreate);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la création");
            if (tx != null) {
                // Une erreur est survenue, on discard les actions entamés dans la transaction
                tx.rollback();
            }

        }
    }
}
