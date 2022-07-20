/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.mysql.cj.protocol.ColumnDefinition;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Victor
 */

@Entity
@Table(name="roles")
public class Role {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY )
    private long id_role;
    
    @Column(
        length=50
    )
    private String identifiant;
    
    @Column(
        columnDefinition = "text"
    )
    private String description;
    

    
    //constructor

    public Role( String identifiant, String description) {

        this.identifiant = identifiant;
        this.description = description;
        
    }

    //méthodes
    @Override
    public String toString() {
        return String.format("[idRole=%s, identifiant=%s, description=%s]", id_role, identifiant, description);
    }
    
    //getters/setters
    public Long getId_role() {
        return id_role;
    }

    public void setId_role(Long id_role) {
        this.id_role = id_role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
    
    
    
}
