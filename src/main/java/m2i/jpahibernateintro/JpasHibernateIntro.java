/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m2i.jpahibernateintro;

import dao.RoleDao;
import dao.UtilisateurDao;
import helper.SessionHelper;
import javax.persistence.EntityManager;
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
        /*
        for(int i=0; i<roleDao.findAll().size(); i++){
            System.out.println("found role "+i+" = "+roleDao.findAll().get(i) );
        }
        */
        System.out.println(roleDao.findAll());
        
        Utilisateur utilisateur1 = new Utilisateur("Mr","Macbool","Pass","Dauphin","Victor",role3);
        utilisateurDao.createUtilisateur(utilisateur1);

        Utilisateur utilisateur2 = new Utilisateur("Mr","MacDeletebool","Pass","Dauphin","Victor",role3);
        utilisateurDao.createUtilisateur(utilisateur2);
        
        utilisateur1.setIdentifiant("MacBoolModified");
        System.out.println(utilisateurDao.findAll());
        
        utilisateurDao.deleteUtilisateur(utilisateur2.getId_utilisateur());
        
        entityManager.close();
    }
}
