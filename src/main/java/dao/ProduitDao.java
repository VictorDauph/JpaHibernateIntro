/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import helper.SessionHelper;
import java.util.List;
import javax.persistence.*;
import model.Produit;


/**
 *
 * @author Victor
 */
public class ProduitDao {
    
    private EntityManager entityManager = SessionHelper.getEntityManager();
    
    public List<Produit> findAll(){
        Query findAllQuery = entityManager.createQuery("select p from Produit p");
        return findAllQuery.getResultList();
    }
    
    public Produit findById(long id){
        Produit produit = entityManager.find(Produit.class, id);        
        return produit;
    }    
    
    public Produit findByMostQuantity(){
        Query findByMostQuantityQuery = entityManager.createQuery("select p from Produit p where stock in (select MAX(p.stock) from Produit p)");
        return (Produit)findByMostQuantityQuery.getSingleResult() ;
    }    
    
    public List<Produit> findByNom(String nom){
        Query findByNomQuery = entityManager.createQuery("select p from Produit p where p.nom = :nom ")
        .setParameter("nom",nom) ;
        return findByNomQuery.getResultList();
    } 
    
    public List<Produit>findByReference(String reference){
        Query findByReferenceQuery = entityManager.createQuery("select p from Produit p where p.reference = :reference ")
        .setParameter("reference",reference);
        return findByReferenceQuery.getResultList();
    } 
    
    public List<Produit> findByDescription(String description){
        Query findByDescriptionQuery = entityManager.createQuery("select p from Produit p where p.description = :description ")
        .setParameter("description",description) ;
        return findByDescriptionQuery.getResultList();
    } 
    
    public List<Produit> findByPrix(float prix){
        Query findByDescriptionQuery = entityManager.createQuery("select p from Produit p where p.prix- :prix <0.01 AND p.prix - :prix > -0.01  ")
        .setParameter("prix",prix) ;
        return findByDescriptionQuery.getResultList();
    } 
    
    
    
    public void createProduit(Produit produit){
        EntityTransaction trans = null;
        try{
            trans= entityManager.getTransaction();
            trans.begin();
                entityManager.persist(produit);
            trans.commit();
        }catch(Exception e){
            if (trans != null) trans.rollback();
        }
    }
    
    public void update(Produit produit){
        EntityTransaction trans = null;
        try{
            trans= entityManager.getTransaction();
            trans.begin();
              Produit produitToUpdate=findById(produit.getId_produit() );
              entityManager.merge(produitToUpdate);
            trans.commit();
        }catch(Exception e){
            if (trans != null) trans.rollback();
        }
    }

    public void deleteProduit(long id){

        EntityTransaction trans = null;
        try{
            trans= entityManager.getTransaction();
            trans.begin();
            Produit toDelete= findById(id);       
            entityManager.remove(toDelete);
            trans.commit();
        }catch(Exception e){
            if (trans != null) trans.rollback();
        }
    }
}
