/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.fatorfit.model;

import java.sql.Date;

/**
 *
 * @author ESIC
 */
public class Poids {
    private int id;
    private double valeur;
    private Date dateAjout;
    private int idUser;

    public Poids(double valeur, int iduser) {
        this.valeur = valeur;
        this.idUser = iduser;
    }

    public Poids() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public double getValeur() {
        return valeur;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public void setIdUser(int iduser) {
        this.idUser = iduser;
    }
    
}
