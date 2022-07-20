/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m2i.jpahibernateintro;

import dao.RoleDao;
import model.Role;


/**
 *
 * @author Victor
 */
public class JpasHibernateIntro {
    public static void main(String[] args) {
        

        Role role1 = new Role("petit comique","fait des blagues au lieu de bosser");        
        RoleDao roleDao= new RoleDao();
        
        roleDao.createRole(role1);
        System.out.println(roleDao.findById(  1L ) ); 
        
        roleDao.updateRoleDescription(role1,"fait de bonnes blagues, tout en bossant");
        System.out.println(roleDao.findById(  1L ) ); 

    }
}
