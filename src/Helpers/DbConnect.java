/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Entity.capsule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author MAHDIJAGHAM
 */
public class DbConnect {
    
        private static String HOST = "127.0.0.1";
        private static int PORT = 3306;
        private static String DB_NAME = "mahdi";
        private static String USERNAME = "root";
        private static String PASSWORD = "";
        private static Connection connection ;
        
        
        public static Connection getConnect (){
        try {
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST,PORT,DB_NAME),USERNAME,PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return  connection;
        }


        public static ObservableList<capsule> getDatausers(){
        Connection conn = getConnect();
        ObservableList<capsule> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from capsule");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new capsule(Integer.parseInt(rs.getString("id")), rs.getString("nomcapsule"), rs.getString("typecapsule"), rs.getString("longcapsule"), rs.getString("programmecapsule"), rs.getString("chemincapsule"), rs.getString("cible"), rs.getString("image")));
            }
        } catch (Exception e) {
        }
        return list;
    }




}
