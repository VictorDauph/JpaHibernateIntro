/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.*;

/**
 *
 * @author Victor
 */

@Entity
@Table(name="adresses")
public class Adresse {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY )
    private long id_adresse;
    
    @Column(
        length=100
    )
    private String codePostal;
    
    @Column(
        length=100
    )
    private String pays;
    
    @Column(
        columnDefinition="tinyint(1) DEFAULT 0"
    )
    Boolean principale;
    
    @Column(
        length=100
    )
    private String rue;
    
    @Column(
        length=100
    )
    private String ville;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id",nullable=false)
    private Utilisateur utilisateur;
    
}
