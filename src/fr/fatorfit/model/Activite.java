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
public class Activite {
    private int id;
    private int duree;
    private Date datedebut;
    private int idUser;
    private int idCategorie;

    public Activite( int id, int duree, Date datedebut,int idUser,int idCategorie ) {
        this.id = id;
        this.duree = duree;
        this.datedebut = datedebut;
        this.idUser = idUser;
        this.idCategorie = idCategorie;
    }

     
    public Activite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public int getDuree() {
        return duree;
    }

    public Date getDateDebut() {
        return datedebut;
    }

    public int getIdUser() {
        return idUser;
    }
     public int getIdCategorie() {
        return idCategorie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setDateDebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public void setIdUser(int iduser) {
        this.idUser = iduser;
    }
    
    public void setIdCategorie(int idcategorie) {
        this.idCategorie = idCategorie;
    }
    
}
