/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.fatorfit.dao;

import fr.fatorfit.model.ObjectifSemaine;
import fr.fatorfit.model.Poids;
import fr.fatorfit.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ESIC
 */
public class UserDao {
    public static User getByLoginPass(String login, String mdp) throws SQLException {
        User u = null;
        String sql = "select * from user where mail=? AND motdepasse=?";
        Connection connexion = ConnectDb.getConnection();
        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setString(1, login);
        requete.setString(2, mdp);
        
        ResultSet rs = requete.executeQuery();
        
        if(rs.next()){
                u = new User();
                u.setId(rs.getInt("iduser"));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                u.setDateDeNaissance(rs.getDate("date_de_naissance"));
                u.setSexe(rs.getString("sexe"));
                u.setTaille(rs.getInt("taille"));
        }
        
        return u;
    }
    
    public static java.util.Date dateSql2Java(java.sql.Date dateSql){
        java.util.Date dateJava;
        if (dateSql==null)
             dateJava = null;
        else{
            dateJava = new java.util.Date(dateSql.getTime());
        }
        return dateJava;
    }
    
    public static String currentDateTimeJava2Sql(){
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        return currentTime;
    }
    
    public static String DateTimeJava2Sql(java.util.Date dt){
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = sdf.format(dt);
        return dateTime;
    }
    
    public static String DateJava2Sql(java.util.Date dt){
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dt);
        return date;
    }
    
    public static String currentDateJava2Sql(){
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String currentTime = sdf.format(dt);
        return currentTime;
    }
    
    public static void deconnexion(User u) throws SQLException{
        
        String sql = "UPDATE fatorfit.user SET derniereconnexion = CURRENT_TIMESTAMP WHERE (iduser = ?)";
        Connection connexion = ConnectDb.getConnection();
        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setInt(1, u.getId());
        requete.executeQuery();
        
    }
    
    public static java.util.Date getDerniereConnexion(User u) throws SQLException{
        String sql = "select derniereconnexion from user WHERE iduser = ?";
        Connection connexion = ConnectDb.getConnection();
        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setInt(1, u.getId());
        ResultSet rs = requete.executeQuery();
        
        java.sql.Date dateSql = rs.getDate("derniereconnexion");
        java.util.Date dateJava;
        dateJava = dateSql2Java(dateSql);
        return(dateJava);
    }
    
    public static int getIdCategorie(String libele)throws SQLException{
        String sql = "SELECT idcategorie FROM categorie WHERE libele = ?";
        Connection connexion = ConnectDb.getConnection();
        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setString(1, libele);
        ResultSet rs = requete.executeQuery(sql);
        return(rs.getInt("idcatgorie"));
    }
    
    public static void insertUser(User u) throws SQLException{
        String sql = "insert into user (nom, prenom, mail, motdepasse, sexe) VALUES (?,?,?,?)";
        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requete = connexion.prepareStatement(sql);
        
        requete.setString(1, u.getNom());
        requete.setString(2, u.getPrenom());
        requete.setString(3, u.getMail());
        requete.setString(4, u.getMotDePasse());
        requete.setString(5, u.getSexe());
        
        requete.execute();
        
        int taille = u.getTaille();
        if (taille>=0){
            sql = "UPDATE fatorfit.user SET taille=? WHERE (iduser = ?)";   
            requete = connexion.prepareStatement(sql);
            requete.setInt(1, u.getTaille());
            requete.setInt(2, u.getId());
            requete.execute();
        }
        
        if (u.getDateDeNaissance()!= null){
            sql = "UPDATE fatorfit.user SET date_de_naissance=? WHERE (iduser = ?)"; 
            requete = connexion.prepareStatement(sql);
            requete.setString(1, DateJava2Sql(u.getDateDeNaissance())); 
            requete.setInt(2, u.getId());
            requete.execute();
        }
    }
    
    public static void insertPoids(Poids p) throws SQLException{
        String sql = "insert into poids (poids, user_iduser) VALUES (?,?)";
        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requete = connexion.prepareStatement(sql);
        
        requete.setDouble(1, p.getValeur());
        requete.setInt(2, p.getIdUser());
        
        requete.execute();
        
    }
    
    public static double getCurrentPoids(User user) throws SQLException{
        Poids p = null;
        int iduser = user.getId();
        String sql = "select valeur from poids where datepoids>=ALL(select valeur from poids where user_iduser=?)";
         Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requete = connexion.prepareStatement(sql);
        
         requete.setInt(1, iduser);
        
        ResultSet rs = requete.executeQuery();
           if(rs.next()){
                p = new Poids();
                p.setValeur(rs.getDouble("valeur"));
                p.setId(rs.getInt("idpoids"));
                p.setDateAjout(rs.getDate("datepoids"));
                p.setIdUser(rs.getInt(iduser));
             
        }
        
        return p.getValeur();
    }
    
    public static int getLastIdUser() throws SQLException{
        String sql = "SELECT iduser FROM user WHERE iduser = LAST_INSERT_ID()";
        Connection connexion = ConnectDb.getConnection();
        Statement requete = connexion.createStatement();
        ResultSet rs = requete.executeQuery(sql);
        return(rs.getInt("iduser"));
    }

    
    public static List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connexion = ConnectDb.getConnection();
        String sql = "select * from user";
        Statement requette = connexion.createStatement();
        ResultSet rs = requette.executeQuery(sql);
        
        
        while(rs.next()){
            User u = new User();
            u.setId(rs.getInt("iduser"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setMail(rs.getString("mail"));
            users.add(u);
        }
        return users;
    }
    
    public static void insertObjectifSemaine(ObjectifSemaine Os, User u) throws SQLException{
        int iduser = u.getId();
        String sql = "insert into objectifsemaine (valeur, datedebut, datefin) VALUES (?,?,?) WHERE user_iduser=?";
        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requete = connexion.prepareStatement(sql);
        
        requete.setDouble(1, Os.getValeur());
        requete.setDate(2, Os.getDatedebut());
        requete.setDate(3, Os.getDatefin());
         requete.setInt(4, iduser);
        
        requete.execute();
        
        
    }
}
