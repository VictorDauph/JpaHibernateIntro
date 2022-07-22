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
@Table(name="produits")
public class Produit {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY )
    private long id_produit;
    
    @Column(
        columnDefinition="tinyint(1) DEFAULT 1"
    )
    Boolean active;
    
    @Column(
        columnDefinition = "text"
    )
    private String description;
    
    @Column(
        length=100
    )
    private String nom;
    
    @Column
    private float prix;
    
    @Column(
        length=100
    )
    private String reference;
    
    @Column
    private int stock;

    public Produit(String description, String nom, float prix, String reference, int stock) {
        this.description = description;
        this.nom = nom;
        this.prix = prix;
        this.reference = reference;
        this.stock = stock;
        this.active=true;
    }

    public long getId_produit() {
        return id_produit;
    }

    public void setId_produit(long id_produit) {
        this.id_produit = id_produit;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    @Override
    public String toString() {
        return String.format("produit : "+ nom+ " description : "+description+" id_produit : "+ id_produit);
    }
    
    
}
