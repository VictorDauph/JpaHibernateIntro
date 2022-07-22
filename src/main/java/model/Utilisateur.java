/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.google.protobuf.TextFormat;
import com.google.protobuf.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author Victor
 */

@Entity
@Table(name="utilisateurs")
public class Utilisateur {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY )
    private long id_utilisateur;
    
    @Column(
        columnDefinition="tinyint(1) DEFAULT 1"
    )
    private boolean actif;
    
    @Column(
        length=100
    )
    private String civilite;
    
    @Column(
        columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"

    ) 
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date dateCreation;
    
    @Column(
        columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )  
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date dateModification;
    
    @Column(
        columnDefinition = "TIMESTAMP"
    ) 
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;
    
    @Column(
        length=100
    )
    private String identifiant;

    @Column(
        columnDefinition="tinyint(1) DEFAULT 0"
    )
    private boolean marquer_effacer;
    
    @Column(
        length=100
    )
    private String mot_passe;
    
    @Column(
        length=100
    )
    private String nom;
    
    @Column(
        length=100
    )
    private String prenom;
    
    @ManyToOne
    @JoinColumn(name = "role_id",nullable=false)
    private Role role;

    @OneToMany(mappedBy = "utilisateur", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, orphanRemoval = true)
    @OnDelete(action=OnDeleteAction.CASCADE )
    private List<Adresse> adresses;

    //Constructeur avec Date
    public Utilisateur(String civilite, String dateNaissance, String identifiant, String mot_passe, String nom, String prenom, Role role) {
        this.civilite = civilite;
        this.actif=true;
        this.marquer_effacer=false;

        this.identifiant = identifiant;
        this.mot_passe = mot_passe;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        
        this.dateNaissance = createBirthDate(dateNaissance);
        
        
    }
    //Constructeur sans date
    public Utilisateur(String civilite, String identifiant, String mot_passe, String nom, String prenom, Role role) {
        this.civilite = civilite;
        this.actif=true;
        this.marquer_effacer=false;
        this.identifiant = identifiant;
        this.mot_passe = mot_passe;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }
    
    //Méthodes
    @Override
    public String toString() {
        return String.format("utilisateur : "+ nom+" "+prenom+" "+" identifiant : "+identifiant+" role_id : "+ role.getId_role());
    }
    
    //stringifiedDate pattern : "dd-MM-yyyy"
    public Date createBirthDate(String stringifiedDate){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date formattedDate = sdf.parse(stringifiedDate);
            return formattedDate;
        } catch (ParseException ex) {

        }
        return null;
    }
    

    // getters/Setters

    public long getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(long id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public boolean isMarquer_effacer() {
        return marquer_effacer;
    }

    public void setMarquer_effacer(boolean marquer_effacer) {
        this.marquer_effacer = marquer_effacer;
    }

    public String getMot_passe() {
        return mot_passe;
    }

    public void setMot_passe(String mot_passe) {
        this.mot_passe = mot_passe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    
}
