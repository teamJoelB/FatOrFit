/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.fatorfit.dao;

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
                u.setSexe(rs.getBoolean("sexe"));
                u.setTaille(rs.getInt("taille"));
        }
        
        return u;
    }
    
    public static void insert(User u) throws SQLException{
        String sql = "insert into user (nom, prenom, mail, motdepasse, taille, date_de_naissance,sexe) VALUES (?,?,?,?)";
        Connection connexion = ConnectDb.getConnection();
        
        PreparedStatement requete = connexion.prepareStatement(sql);
        
        requete.setString(1, u.getNom());
        requete.setString(2, u.getPrenom());
        requete.setString(3, u.getMail());
        requete.setString(4, u.getMotDePasse());
        requete.setInt(6, u.getTaille());
        requete.setDate(7, u.getDateDeNaissance());  // controler la conversion de date
        requete.setBoolean(8, u.isSexe());
        
        // ajouter un poids a l'utilisateur, pensez a voir si l'user a deja un id
        String sql2 = "insert into poids (valeur, user_iduser) VALUES (?,?)";
        PreparedStatement requete2 = connexion.prepareStatement(sql2);
        requete2.setString(1, u.getNom());
        requete2.setInt(2, u.getId());
        
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
