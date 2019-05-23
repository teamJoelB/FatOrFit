/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.fatorfit.dao;

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
            sql = "insert into user (taille) VALUES (?)";   
            requete = connexion.prepareStatement(sql);
            requete.setInt(1, u.getTaille());
            requete.execute();
        }
        
        requete.setDate(1, u.getDateDeNaissance());  // controler la conversion de date
        
    }
    
    public static void insertPoids(Poids p) throws SQLException{
        String sql = "insert into poids (poids, user_iduser) VALUES (?,?)";
        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requete = connexion.prepareStatement(sql);
        
        requete.setDouble(1, p.getValeur());
        requete.setInt(2, p.getIdUser());
        
        requete.execute();
        
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
}
