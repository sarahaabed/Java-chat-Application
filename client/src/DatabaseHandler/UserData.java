/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author it
 */
public class UserData {

    Connection con;
    public void connect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb", "root", "root");
        } catch (SQLException ex) {
            //System.out.println("error");
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void InsertUser(User user) {
        try {
            connect();
            //Statement stmt = con.createStatement();
            /*String queryString = new String("select * from User_Table");
             ResultSet rs = stmt.executeQuery(queryString);
             while (rs.next()) {
             System.out.println(rs.getString(1));
             }*/
            /*String insertString = new String("UPDATE tab SET id=35 WHERE id =3");
             stmt.executeUpdate(insertString);*/
            
            /* String deleteString = new String("DELETE FROM tab WHERE id ='2' ");
             stmt.executeUpdate(deleteString);*/
            String insertString = new String("INSERT INTO User_Table (user_Email,user_Name,password,gender) VALUES(?,?,?,?) ");
            PreparedStatement pst = con.prepareStatement(insertString);
            //pst.setInt(1, id);
            pst.setString(1, user.getUserEmail());
            pst.setString(2, user.getUserName());
            pst.setString(3, user.getUserPassword());
            pst.setString(4, user.getUserGender());
            if (pst.execute()) {
                System.out.println("ensert success");
            }
            /*else{
                System.out.println("Not Inserted");
            }*/
            /* PreparedStatement pst = con.prepareStatement("select * from tab where id=?");
             //String queryString = new String("select * from tab");
             pst.setInt(1, 2);
             ResultSet rs = pst.executeQuery();
             while (rs.next()) {
             System.out.println(rs.getString(2));
             }*/
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
