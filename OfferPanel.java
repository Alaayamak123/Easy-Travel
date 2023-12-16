/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager_ui;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.*;

/**
 *
 * @author EASY LIFE
 */
public class OfferPanel {
    int offerId;
    Offer currOffer=new Offer();
     javax.swing.JScrollPane scroll1 = new javax.swing.JScrollPane();
     javax.swing.JLabel generalPrice1;
     javax.swing.JLabel from1;
     javax.swing.JLabel   dateFrom1;
     javax.swing.JLabel hotelAddress1;
     javax.swing.JLabel airlineName1;
     javax.swing.JLabel flightClass1;
    javax.swing.JTextArea offerDescriptionText1;
    javax.swing.JScrollPane jScrollPane8;
    javax.swing.JLabel  destination1;
    javax.swing.JLabel dateTo1;
    javax.swing.JLabel hotelName1;
    javax.swing.JLabel roomType1;
    //javax.swing.JLabel flightPrice1;
    javax.swing.JLabel deleteButton;
    javax.swing.JLabel editButton;
    
    private javax.swing.JPanel offer1;
    private javax.swing.JPanel jPanel13;
   javax.swing.JLabel  jLabel17=new  javax.swing.JLabel ();
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel20; 
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JLabel jLabel15;
    
    private javax.swing.JPanel jPanel22;
    private javax.swing.JLabel jLabel31;
    
    private javax.swing.JPanel jPanel23;
    private javax.swing.JLabel jLabel33;

    private javax.swing.JPanel jPanel24;
    private javax.swing.JLabel jLabel35;
   
    private javax.swing.JPanel jPanel15;
    private javax.swing.JLabel jLabel1;
    
    private javax.swing.JLabel jLabel47;
 
    private javax.swing.JLabel jLabel45;
   
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JLabel jLabel37;
    
    private javax.swing.JPanel jPanel27;
    private javax.swing.JLabel jLabel39;
    
    private javax.swing.JPanel jPanel28;
    private javax.swing.JLabel jLabel41;
    
    private javax.swing.JPanel jPanel29;
    private javax.swing.JLabel jLabel43;
    
    private javax.swing.JPanel jPanel33;
    private javax.swing.JLabel jLabel49;
     
    private javax.swing.JPanel jPanel30;
    manager_page page;
    
            
          
 
 //offerGroup2.add(scroll1);
    
 public  OfferPanel(int ID, manager_page page){
     this.page=page;
     offerId=ID;
      editButton = new javax.swing.JLabel();
      jPanel30 = new javax.swing.JPanel();
     deleteButton = new javax.swing.JLabel();
    // flightPrice1 = new javax.swing.JLabel();
         jLabel49 = new javax.swing.JLabel();
     jPanel33 = new javax.swing.JPanel();
      roomType1 = new javax.swing.JLabel();
      jLabel43 = new javax.swing.JLabel();
     jPanel29 = new javax.swing.JPanel();
     hotelName1 = new javax.swing.JLabel();
      jLabel41 = new javax.swing.JLabel();
      jPanel28 = new javax.swing.JPanel();
     dateTo1 = new javax.swing.JLabel();
      jLabel39 = new javax.swing.JLabel();
      offerDescriptionText1 = new javax.swing.JTextArea();
       jPanel27 = new javax.swing.JPanel();
     jLabel45 = new javax.swing.JLabel();
     flightClass1 = new javax.swing.JLabel();
      jLabel1=new javax.swing.JLabel();
      jPanel17 = new javax.swing.JPanel();
      jLabel15 = new javax.swing.JLabel();
       jPanel22 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
           from1 = new javax.swing.JLabel();
           jPanel23 = new javax.swing.JPanel();
           jLabel33 = new javax.swing.JLabel();
             dateFrom1 = new javax.swing.JLabel();
             jPanel24 = new javax.swing.JPanel();
              jLabel35 = new javax.swing.JLabel();
               hotelAddress1 = new javax.swing.JLabel();
               jPanel15 = new javax.swing.JPanel();
                 airlineName1 = new javax.swing.JLabel();
                  jScrollPane8 = new javax.swing.JScrollPane();
                   jPanel26 = new javax.swing.JPanel();
                  jLabel47 = new javax.swing.JLabel();
                  jLabel37 = new javax.swing.JLabel();
                    destination1 = new javax.swing.JLabel();
                    jPanel19=new javax.swing.JPanel();
         jPanel25 = new javax.swing.JPanel();
        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setLayout(new java.awt.GridLayout(5, 0));

     
         jPanel26.setBackground(new java.awt.Color(255, 255, 255));

        jLabel37.setText("destination:");
        jPanel26.add(jLabel37);

        destination1.setText("example");
        jPanel26.add(destination1);

        jLabel37.setText("destination:");
        jPanel26.add(jLabel37);

        destination1.setText("example");
        jPanel26.add(destination1);

        jPanel25.add(jPanel26);

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        jLabel39.setText("Date To:");
        jPanel27.add(jLabel39);

        dateTo1.setText("example");
        jPanel27.add(dateTo1);

        jPanel25.add(jPanel27);

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));

        jLabel41.setText("Hotel Name:");
        jPanel28.add(jLabel41);

        hotelName1.setText("example");
        jPanel28.add(hotelName1);

        jPanel25.add(jPanel28);

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));

        jLabel43.setText("Room Type:");
        jPanel29.add(jLabel43);

        roomType1.setText("example");
        jPanel29.add(roomType1);

        jPanel25.add(jPanel29);

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));

      //  jLabel49.setText("Flight Price:");
      //  jPanel33.add(jLabel49);

      //  flightPrice1.setText("example");
       // jPanel33.add(flightPrice1);

        jPanel25.add(jPanel33);
       jLabel15.setText("Price:");
         generalPrice1 = new javax.swing.JLabel();
     
      jPanel32 = new javax.swing.JPanel();
       jPanel14 = new javax.swing.JPanel();
          jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new java.awt.GridLayout(6, 0));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setText("Price:");
        jPanel17.add(jLabel15);

        generalPrice1.setText("example");
        jPanel17.add(generalPrice1);

        jPanel14.add(jPanel17);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        jLabel31.setText("From:");
        jPanel22.add(jLabel31);

        from1.setText("example");
        jPanel22.add(from1);

        jPanel14.add(jPanel22);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        jLabel33.setText("Date From:");
        jPanel23.add(jLabel33);

        dateFrom1.setText("example");
        jPanel23.add(dateFrom1);

        jPanel14.add(jPanel23);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        jLabel35.setText("Hotel Address:");
        jPanel24.add(jLabel35);

        hotelAddress1.setText("example");
        jPanel24.add(hotelAddress1);

        jPanel14.add(jPanel24);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Airplan Name:");
        jPanel15.add(jLabel1);

        airlineName1.setText("example");
        jPanel15.add(airlineName1);

        jPanel14.add(jPanel15);

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));

        jLabel47.setText("Flight Class:");
        jPanel32.add(jLabel47);

        flightClass1.setText("example");
        jPanel32.add(flightClass1);

        jPanel14.add(jPanel32);

        jPanel19.add(jPanel14);
     jPanel20 = new javax.swing.JPanel();
        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setMinimumSize(new java.awt.Dimension(140, 35));
        jPanel20.setPreferredSize(new java.awt.Dimension(140, 35));

     jPanel34 = new javax.swing.JPanel();
        jPanel34.setBackground(new java.awt.Color(255, 255, 255));

        jLabel45.setText("Offer description");
        jPanel34.add(jLabel45);
            offerDescriptionText1.setColumns(20);
        offerDescriptionText1.setRows(5);
        jScrollPane8.setViewportView(offerDescriptionText1);

        jPanel34.add(jScrollPane8);
         jPanel19 = new javax.swing.JPanel();
          jPanel19.setLayout(new java.awt.GridLayout(1, 2));
          
        jPanel19.add(jPanel14);
           jPanel19.add(jPanel25);
     jPanel21 = new javax.swing.JPanel();
    jPanel31 = new javax.swing.JPanel();
   jPanel31.setBackground(new java.awt.Color(44, 159, 186));
        jPanel31.setMinimumSize(new java.awt.Dimension(100, 30));
        jPanel31.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
  jPanel31.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 1, 100, 30));
   deleteButton.setText("  DELETE OFFER");
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
           
             public void mouseClicked(java.awt.event.MouseEvent evt) {
               deleteButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteButtonMouseExited(evt);
            }
        });
        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setMinimumSize(new java.awt.Dimension(140, 35));
        jPanel21.setPreferredSize(new java.awt.Dimension(140, 35));

       offer1 = new javax.swing.JPanel();
        offer1.setBackground(new java.awt.Color(255, 255, 255));
        offer1.setLayout(new java.awt.BorderLayout());
        scroll1.setViewportView(offer1);
      jPanel13 = new javax.swing.JPanel();
      
        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setMinimumSize(new java.awt.Dimension(100, 200));
         jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design_imgs/france.jpg"))); // NOI18N
        jLabel17.setMaximumSize(new java.awt.Dimension(1000, 1000));
        jLabel17.setMinimumSize(new java.awt.Dimension(265, 200));
        jLabel17.setPreferredSize(new java.awt.Dimension(265, 200));
        jPanel13.add(jLabel17);
        jPanel35 = new javax.swing.JPanel();
         jPanel35.setMinimumSize(new java.awt.Dimension(280, 35));
        jPanel35.setPreferredSize(new java.awt.Dimension(280, 35));
        jPanel35.setLayout(new java.awt.GridLayout(1, 2));
         jPanel35.add(jPanel20);
           jPanel35.add(jPanel21);
 jPanel18 = new javax.swing.JPanel();
 
        jPanel18.setMinimumSize(new java.awt.Dimension(280, 150));
        jPanel18.setPreferredSize(new java.awt.Dimension(280, 150));
        jPanel18.setLayout(new java.awt.BorderLayout());
        offer1.add(jPanel13, java.awt.BorderLayout.PAGE_START);
         jPanel16 = new javax.swing.JPanel();
          jPanel16.setLayout(new java.awt.BorderLayout());
             jPanel31.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 1, 100, 30));

        jPanel21.add(jPanel31);

        jPanel35.add(jPanel21);

        jPanel18.add(jPanel35, java.awt.BorderLayout.CENTER);

        jPanel16.add(jPanel18, java.awt.BorderLayout.PAGE_END);
         jPanel16.add(jPanel19, java.awt.BorderLayout.CENTER);
            jPanel18.add(jPanel34, java.awt.BorderLayout.PAGE_START);
            jPanel18.add(jPanel35, java.awt.BorderLayout.CENTER);
  jPanel21.add(jPanel31);
    jPanel30.setBackground(new java.awt.Color(44, 159, 186));
        jPanel30.setMinimumSize(new java.awt.Dimension(100, 30));
        jPanel30.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
          editButton.setText("     EDIT OFFER");
        editButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editButtonMouseExited(evt);
            }
        });
  jPanel30.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -1, 100, 30));

     jPanel20.add(jPanel30);
        offer1.add(jPanel16, java.awt.BorderLayout.CENTER);
 

 }
 
     private void editButtonMouseClicked(java.awt.event.MouseEvent evt) {                                        
        manager_page.myeditOffer.setVisible(true);
        manager_page.myeditOffer.setLocationRelativeTo(null);
        page.initEditPage(this.currOffer);
        //**********************************************************************
    } 
   private void deleteButtonMouseEntered(java.awt.event.MouseEvent evt) {                                          
        changecolor(jPanel31, new Color(204,204,204));
    }                                         
private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {                                          
       MangerFuctions.DeleteOffer(this.currOffer);
       MangerFuctions.closeConn();
       page.displayOffers();
    } 
    private void deleteButtonMouseExited(java.awt.event.MouseEvent evt) {                                         
        changecolor(jPanel31, new Color(44,159,186));
    }   
  
       private void editButtonMouseEntered(java.awt.event.MouseEvent evt) {                                        
        changecolor(jPanel30, new Color(204,204,204));
    }                                       

    private void editButtonMouseExited(java.awt.event.MouseEvent evt) {                                       
        changecolor(jPanel30, new Color(44,159,186));
    } 
        public void changecolor(JPanel hover, Color rand){
        hover.setBackground(rand);
    }
        
        
}
