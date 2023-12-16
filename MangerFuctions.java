/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager_ui;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author EASY LIFE
 */
public class MangerFuctions {
    
      static String  url="jdbc:oracle:thin:@Localhost:1521:orcl";
      static  String user="c##fanan2";
      static  String password="0000";
         static Connection conn=null;
        
    static  ResultSet  showAllOffers(){
    
        ResultSet rs=null;
 
        try {
            conn = DriverManager.getConnection(url,user,password);
       
        conn.setAutoCommit(false);
        Statement st=conn.createStatement();
        String s="Select * from offer";
      rs=st.executeQuery(s);
    /*  while(rs.next()){
          System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDate(3)+" "+rs.getDate(4)+" "+rs.getString(5)+" "+rs.getString(6));
      }*/
 
        //conn.close();
         } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(MangerFuctions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    static ResultSet getHotelInfo(int offerID){
          
        ResultSet rs=null;
 
        try {
            conn = DriverManager.getConnection(url,user,password);
         String s;
        conn.setAutoCommit(false);
        Statement st=conn.createStatement();
        if(offerID==0){
              s="Select * from hotel";
              rs=st.executeQuery(s);
              return rs;
        }
        if(offerID>0){
        s="Select * from hotoffer where ido="+offerID;
       // String s="Select * from hotoffer";
        rs=st.executeQuery(s);
        rs.next(); 
   
       s="Select * from hotel where hname='"+rs.getString(2)+"' AND room_type='"+rs.getString(3) +"'";
        rs=st.executeQuery(s);
     
        }
         } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(MangerFuctions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return rs;
    }
    
       static ResultSet getAirInfo(int offerID){
          
        ResultSet rs=null;
 
        try {
            String s;
            conn = DriverManager.getConnection(url,user,password);
       
        conn.setAutoCommit(false);
        Statement st=conn.createStatement();
        if(offerID==0){ s="Select * from airport ";
        rs=st.executeQuery(s);
        return rs;
        }
        if(offerID>0){
         s="Select * from airoffer where ido="+offerID;
       // String s="Select * from airoffer ";
        rs=st.executeQuery(s);
        
     rs.next(); 
   
       s="Select * from airport where aname='"+rs.getString(2)+"' AND classd="+rs.getInt(3);
        rs=st.executeQuery(s);
        }
         } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(MangerFuctions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    static void closeConn(){
          try {
              conn.close();
          } catch (SQLException ex) {
              java.util.logging.Logger.getLogger(MangerFuctions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
}
    
        static void  AddNewOffer(Offer newOffer){
            System.out.println(newOffer.toString());
        String url,user,password;
        url="jdbc:oracle:thin:@Localhost:1521:orcl";
        user="c##fanan2";
        password="0000";
    Connection conn;
             try {
            conn = DriverManager.getConnection(url,user,password);
    conn.setAutoCommit(false);
        Statement st=conn.createStatement();
        String s="insert into offer values("+newOffer.OSQ+",'"+newOffer.descrption+"',"+"TO_DATE('"+newOffer.Date_to+"','dd/mm/yyyy')"+","+"TO_DATE('"+newOffer.Date_from+"','dd/mm/yyyy')"+",'"+newOffer.to_des+"','"+newOffer.from_des+"','"+newOffer.Img+"')";//nfyhjukiolikujyhtgfrdeswertyuioiujyhtgfrdesderftgyhuji
        String hotOffer="insert into hotoffer values("+newOffer.OSQ+",'"+newOffer.hname+"','"+newOffer.room_type+"')";
        String airoffer="insert into airoffer values("+newOffer.OSQ+",'"+newOffer.Aname+"',"+newOffer.classd+")";
       
        
     st.execute(s);
      conn.commit();
     st.execute(hotOffer);
      conn.commit();
     st.execute(airoffer);
     conn.commit();
JOptionPane.showMessageDialog(null, "Offer Added");  
        
         
 
 conn.close();
         } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(MangerFuctions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(null, "Offer not Added");  

         }
    }
    
        
         static void  AddHotel(String hname,String hAddress,int stars,int hotelPrice,String roomTypes){
            
        String url,user,password;
        url="jdbc:oracle:thin:@Localhost:1521:orcl";
        user="c##fanan2";
        password="0000";
    Connection conn;
        try {
            conn = DriverManager.getConnection(url,user,password);
       
        conn.setAutoCommit(false);
        Statement st=conn.createStatement();
        String s="insert into hotel values('"+hname+"','"+hAddress+"',"+stars+","+"1"+","+hotelPrice+",'"+roomTypes+"')";
       
        try{
     st.execute(s);
JOptionPane.showMessageDialog(null, "Hotel "+hname+" was added sucssesfuly!\nYou can use it in making any offer  to the users");   }   
  catch(SQLException ex)  { 
  JOptionPane.showMessageDialog(null, "Hotel "+hname+" wasn't added \nTry again");      }
 conn.commit();
        conn.close();
         } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(MangerFuctions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
         
       static int getOfferSeq(){
       int seq=0;
              ResultSet rs=null;
 
        try {
            conn = DriverManager.getConnection(url,user,password);
       
        conn.setAutoCommit(false);
        Statement st=conn.createStatement();
        String s="Select OSQ.nextval from DUAL";
      rs=st.executeQuery(s);
       rs.next();
 seq=rs.getInt(1);
        //conn.close();
         } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(MangerFuctions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
       return seq;
       }  
 static void  AddAirport (String aname,String aAddress,int TicketPrice,int classs){
      
      String  url="jdbc:oracle:thin:@Localhost:1521:orcl";
      String  user="c##fanan2";
      String  password="0000";
    Connection conn;
    
        try {
            conn = DriverManager.getConnection(url,user,password);
       
        conn.setAutoCommit(false);
        Statement st=conn.createStatement();
        String s="insert into airport values('"+aname+"','"+aAddress+"',2"+","+TicketPrice+","+classs+")";
       
        try{
     st.execute(s);
JOptionPane.showMessageDialog(null, "Airport "+aname+" was added sucssesfuly!\nYou can use it in making any offer  to the users");   }   
  catch(SQLException ex)  { 
  JOptionPane.showMessageDialog(null, "Airport "+aname+" wasn't added \nTry again");      }
 conn.commit();
        conn.close();
         } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(MangerFuctions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }       

    }
 
 
         static void  UpdateOffer(Offer newOffer){
            System.out.println(newOffer.toString());
        String url,user,password;
        url="jdbc:oracle:thin:@Localhost:1521:orcl";
        user="c##fanan2";
        password="0000";
    Connection conn;
             try {
            conn = DriverManager.getConnection(url,user,password);
    conn.setAutoCommit(false);
        Statement st=conn.createStatement();
   String s="update offer set OSQ="+newOffer.OSQ+",DESCRIPTION='"+newOffer.descrption+"',DATE_TO="+"TO_DATE('"+newOffer.Date_to+"','dd/mm/yyyy')"+",DATE_FROM="+"TO_DATE('"+newOffer.Date_from+"','dd/mm/yyyy')"+",TO_DES='"+newOffer.to_des+"',FROM_DES='"+newOffer.from_des+"',IMG='"+newOffer.Img+"' where OSQ="+newOffer.OSQ;//nfyhjukiolikujyhtgfrdeswertyuioiujyhtgfrdesderftgyhuji
        String hotOffer="update hotoffer set hname='"+newOffer.hname+"',room_type='"+newOffer.room_type+"' where IDO="+newOffer.OSQ;
        String airoffer="update airoffer set aname='"+newOffer.Aname+"',classd="+newOffer.classd+" where IDO="+newOffer.OSQ;
       
     
     st.executeUpdate(s);
     conn.commit();
     st.executeUpdate(hotOffer);
      conn.commit();
     st.executeUpdate(airoffer);
     conn.commit();
JOptionPane.showMessageDialog(null, "Offer updated");  
        
         
 
 conn.close();
         } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(MangerFuctions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(null, "Offer not updated");  

         }
    }
         
                 static void  DeleteOffer(Offer newOffer){
            System.out.println(newOffer.toString());
        String url,user,password;
        url="jdbc:oracle:thin:@Localhost:1521:orcl";
        user="c##fanan2";
        password="0000";
    Connection conn;
             try {
            conn = DriverManager.getConnection(url,user,password);
    conn.setAutoCommit(false);
        Statement st=conn.createStatement();
        String s="delete from offer where OSQ="+newOffer.OSQ;//nfyhjukiolikujyhtgfrdeswertyuioiujyhtgfrdesderftgyhuji
        String hotOffer="delete from hotoffer where IDO="+newOffer.OSQ;
        String airoffer="DELETE FROM airoffer WHERE IDO="+newOffer.OSQ;
       
        
     
     st.executeUpdate(hotOffer);
      conn.commit();
     st.executeUpdate(airoffer);
     conn.commit();
     st.executeUpdate(s);
     conn.commit();
JOptionPane.showMessageDialog(null, "Offer deleted");  
        
         
 
 conn.close();
         } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(MangerFuctions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(null, "Offer not deleted");  

         }
    }
}
