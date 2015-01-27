/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author it
 */
public class UserData {

    Connection con;
    public Vector<Contact> userContacts = new Vector<Contact>();
    public Vector<Room> userRooms = new Vector<Room>();
    /* IUser user;
     IRoom room;
     IContact contact;*/

    public UserData() {
        /*  user = new User();
         room = new Room();
         contact = new Contact(null, null, null, null, null);*/
    }

    public void connect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
        } catch (SQLException ex) {
            //System.out.println("error");
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean InsertUser(User user) {
        boolean flag = false;
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
            if (pst.execute()== false ) {
                System.out.println("insert success");
                flag = true;
            } else {
                System.out.println("insert failled");
                flag = false;
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
            // ex.printStackTrace();
            flag = false;
        }
        return flag;
    }

    public User selectUser(String mail) {
        boolean flag = true;
        User user = new User();
        try {
            PreparedStatement pst = con.prepareStatement("select * from User_Table where user_Email=?");
            pst.setString(1, mail);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                user.setUserEmail(rs.getString(1));
                user.setUserName(rs.getString(2));
                user.setUserPassword(rs.getString(3));
                user.setUserGender(rs.getString(4));
                user.setUserStatus(rs.getString(5));
            }
        } catch (SQLException ex) {
            flag = false;
        }
        if (flag == true) {
            return user;
        } else {
            System.out.println("not found ");
            return null;
        }
    }
//Radwa

//Radwa

//bishoy

//bishoy

//Aliaa

//Aliaa

//Sarah
    
    public void changeStatus(User user){
        //implementation
        try {
            connect();
            String query = "UPDATE User_Table SET status = ? where user_Email = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(5,user.getUserStatus()); 
            preparedStmt.setString(1, user.getUserEmail());
            preparedStmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//Sarah


//Jihad
    
  
    public boolean acceptContact(String userEmail,String friendEmail) {
        boolean flag = true;
        try {
            connect();
            
          
            PreparedStatement stmt1 = con.prepareStatement("insert into user_list_table values(?,?)");

            stmt1.setString(1,friendEmail );
            stmt1.setString(2, userEmail);
            stmt1.executeUpdate();
            PreparedStatement pst = con.prepareStatement("DELETE FROM user_request_table WHERE user_Email=? and receiver_Email=?");

            pst.setString(1, userEmail);
            pst.setString(2, friendEmail);
            pst.executeUpdate();
        } catch (SQLException ex) {
             flag = false;
        }
           
       return flag;
}
     public boolean rejectContact(String userEmail,String friendEmail) {
        boolean flag = true;
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM user_request_table WHERE user_Email=? and receiver_Email=?");

            pst.setString(1, userEmail);
            pst.setString(2, friendEmail);
            pst.executeUpdate();
           
        } catch (SQLException ex) {
            flag = false;
        }
       return flag;
}
    public Contact selectContact(String mail) {
        boolean flag = true;
        Contact contact=null;
        try {
            PreparedStatement pst = con.prepareStatement("select * from User_Table where user_Email=?");
            pst.setString(1, mail);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                contact=new Contact(rs.getString(1),rs.getString(2),rs.getString(5),null,1);
            }
        } catch (SQLException ex) {
            flag = false;
        }
        if (flag == true) {
            return contact;
        } else {
            System.out.println("not found ");
            return null;
        }
    }
//Jihad
    
    
    
    
}

//Radwa

//Radwa

//bishoy

//bishoy

//Aliaa

//Aliaa

//Sarah

//Sarah

//Jihad
    
  
//    public boolean acceptContact(String userEmail,String friendEmail) {
//        boolean flag = true;
//        try {
//            connect();
//            PreparedStatement pst = con.prepareStatement("DELETE FROM user_request_table WHERE user_Email=? and receiver_Email=?");
//
//            stmt1.setString(1, userEmail);
//            stmt1.setString(2, friendEmail);
//           stmt1.executeUpdate();
//            
//        } catch (SQLException ex) {
//            flag = false;
//        }
//       return flag;
//}
//     public boolean rejectContact(String userEmail,String friendEmail) {
//        boolean flag = true;
//        try {
//            PreparedStatement pst = con.prepareStatement("select * from User_Table where user_Email=?");
//            pst.setString(1, mail);
//            ResultSet rs = pst.executeQuery();
//            while (rs.next()) {
//                user.setUserEmail(rs.getString(1));
//                user.setUserName(rs.getString(2));
//                user.setUserPassword(rs.getString(3));
//                user.setUserGender(rs.getString(4));
//                user.setUserStatus(rs.getString(5));
//            }
//        } catch (SQLException ex) {
//            flag = false;
//        }
//       return flag;
//}

//Jihad
