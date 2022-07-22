/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



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

    @JoinColumn(name = "id_utilisateur", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Utilisateur utilisateur;

    public Adresse(String codePostal, String pays, Boolean principale, String rue, String ville, Utilisateur utilisateur) {
        this.codePostal = codePostal;
        this.pays = pays;
        this.principale = principale;
        this.rue = rue;
        this.ville = ville;
        this.utilisateur = utilisateur;
    }

    public long getId_adresse() {
        return id_adresse;
    }

    public void setId_adresse(long id_adresse) {
        this.id_adresse = id_adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Boolean getPrincipale() {
        return principale;
    }

    public void setPrincipale(Boolean principale) {
        this.principale = principale;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    @Override
    public String toString() {
        return String.format("ville : "+ville+ " rue : "+rue+ "principale : "+principale + " utilisateurId : "+ utilisateur.getId_utilisateur() );
    }
    
}
