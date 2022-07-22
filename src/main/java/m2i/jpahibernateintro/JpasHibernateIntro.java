/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m2i.jpahibernateintro;

import dao.AdresseDao;
import dao.ProduitDao;
import dao.RoleDao;
import dao.UtilisateurDao;
import helper.SessionHelper;
import javax.persistence.EntityManager;
import model.Adresse;
import model.Produit;
import model.Role;
import model.Utilisateur;


/**
 *
 * @author Victor
 */
public class JpasHibernateIntro {
    
    private static EntityManager entityManager = SessionHelper.getEntityManager();
    
    public static void main(String[] args) {
        
      /*  

        Role role1 = new Role("petit comique","fait des blagues nulles au lieu de bosser");        
        RoleDao roleDao= new RoleDao();
        UtilisateurDao utilisateurDao= new UtilisateurDao();
        Role role2 = new Role("petit comique2","fait des blagues nulles au lieu de bosser");        
        Role role3= new Role("Boss","Boss final des internets");
        
        roleDao.createRole(role1);
        roleDao.createRole(role2);
        roleDao.createRole(role3);
        //System.out.println(roleDao.findById(  1 ) ); 
        
        //roleDao.updateRoleDescription(1,"fait de bonnes blagues, tout en bossant bien");
        //System.out.println(roleDao.findById(  1 ) );
        
        System.out.println("début affichage liste");

        System.out.println(roleDao.findAll());
        
        Utilisateur utilisateur1 = new Utilisateur("Mr","Macbool","Pass","Dauphin","Victor",role3);
        utilisateurDao.createUtilisateur(utilisateur1);

        Utilisateur utilisateur2 = new Utilisateur("Mr","MacDeletebool","Pass","Dauphin","Victor",role3);
        utilisateurDao.createUtilisateur(utilisateur2);
        
        //utilisation du constructeur avec date de naissance
        Utilisateur utilisateur3 = new Utilisateur("Mr","25-03-1988","MacDatebool","Pass","Dauphin","Victor",role3);
        utilisateurDao.createUtilisateur(utilisateur3);
        
        utilisateur1.setIdentifiant("MacBoolModified");
        System.out.println(utilisateurDao.findAll());
        
        
        
        Adresse adresse1 = new Adresse("01100","France",true,"av Clemenceau","Oyoyo",utilisateur1);
        Adresse adresse2 = new Adresse("01100","France",false,"av Clemenssa","Oyoyo",utilisateur1);
        Adresse adresse3 = new Adresse("01100","France",false,"av Clemenssb","Oyoyo",utilisateur1);
        Adresse adresse4 = new Adresse("01100","France",true,"av Clemenss2","Oyoyo",utilisateur2);
        
        AdresseDao adresseDao= new AdresseDao();
        
        adresseDao.create(adresse1);
        adresseDao.create(adresse2);
        adresseDao.create(adresse3);
        adresseDao.create(adresse4);
        
        System.out.println("liste adresses utilisateur 1 : "+adresseDao.findByUtilisateur(utilisateur1));  
        System.out.println("liste adresses utilisateur 2 : "+adresseDao.findByUtilisateur(utilisateur2)); 
        System.out.println("liste adresses utilisateur 3 : "+adresseDao.findByUtilisateur(utilisateur3)); 
        
        utilisateurDao.deleteUtilisateur(1);
        */
      
      ProduitDao produitDao= new ProduitDao();
      
      Produit produit1 = new Produit("très beau","canape", (float) 5000.99,"AAA",5);
      Produit produit2 = new Produit("très moyen","canape", (float) 4000.99,"AAB",5);
      Produit produit3 = new Produit("très chère","cafetière", (float) 4000.99,"ABB",15);
      produitDao.createProduit(produit1);
      produitDao.createProduit(produit2);
      produitDao.createProduit(produit3);
      
         
        System.out.println("canapes : "+produitDao.findByNom("canape"));
        System.out.println("très moyen : "+produitDao.findByDescription("très moyen"));
        System.out.println("4000 balles : "+produitDao.findByPrix((float)4000.99));
        System.out.println("4001 balles : "+produitDao.findByPrix((float)4001.00));
        
      Produit produit1modif = produit1;
      produit1modif.setDescription("vraiment très beau");
      produit1modif.setNom("canape 2000");
      produitDao.update(produit1modif);
      
        System.out.println(produitDao.findById(1));
        
        produitDao.deleteProduit(1);
        
        System.out.println(" stock max : "+ produitDao.findByMostQuantity() );
        
        System.out.println("ref AAB : "+ produitDao.findByReference("AAB"));
    
    entityManager.close();
        
        
    }
}
