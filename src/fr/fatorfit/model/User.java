/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.fatorfit.model;
import java.sql.Date;

/**
 *
 * @author Joel B
 */
public class User {
    private int id;
    private String sexe;
    private String nom;
    private String prenom;
    private String mail;
    private int taille;
    private String motDePasse;
    private Date dateDeNaissance;
    private Date derniereConnexion;
    
    public User() {
    }

    public User(String nom, String prenom, String mail, String motDePasse, int taille, String sexe, Date ddn) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.motDePasse = motDePasse;
        this.taille = taille;
        dateDeNaissance = ddn;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }  

    public Date getDerniereConnexion() {
        return derniereConnexion;
    }

    public void setDerniereConnexion(Date derniereConnexion) {
        this.derniereConnexion = derniereConnexion;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
    
    
    public String getSexe() {
        return sexe;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public int getTaille() {
        return taille;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }
    
    
}
