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
public class ObjectifSemaine {
    private int id;
    private double valeur;
    private Date datedebut;
    private Date datefin;
    private int idUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public ObjectifSemaine() {
    }

    public ObjectifSemaine(int id, double valeur, Date datedebut, Date datefin, int idUser) {
        this.id = id;
        this.valeur = valeur;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.idUser = idUser;
    }
}
