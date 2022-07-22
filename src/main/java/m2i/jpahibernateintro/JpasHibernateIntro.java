/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m2i.jpahibernateintro;

import dao.AdresseDao;
import dao.RoleDao;
import dao.UtilisateurDao;
import helper.SessionHelper;
import javax.persistence.EntityManager;
import model.Adresse;
import model.Role;
import model.Utilisateur;


/**
 *
 * @author Victor
 */
public class JpasHibernateIntro {
    
    private static EntityManager entityManager = SessionHelper.getEntityManager();
    
    public static void main(String[] args) {
        
        

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
        
        adresseDao.createAdresse(adresse1);
        adresseDao.createAdresse(adresse2);
        adresseDao.createAdresse(adresse3);
        adresseDao.createAdresse(adresse4);
        
        System.out.println("liste adresses utilisateur 1 : "+adresseDao.findByUtilisateur(utilisateur1));  
        System.out.println("liste adresses utilisateur 2 : "+adresseDao.findByUtilisateur(utilisateur2)); 
        System.out.println("liste adresses utilisateur 3 : "+adresseDao.findByUtilisateur(utilisateur3)); 
        
        utilisateurDao.deleteUtilisateur(1);
        
        entityManager.close();
        
        
    }
}
