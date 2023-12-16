/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package manager_ui;
import javax.imageio.ImageIO;
import java.sql.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListDataListener;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.text.DateFormatter;
import org.jdatepicker.DateModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


/**
 *
 * @author pc
 */
public class manager_page extends javax.swing.JFrame {

    /**
     * Creates new form manager_page
     */
    
 static JFrame myeditOffer;
     boolean a = true;
     Offer newOffer;
    Offer ToEditOffer;
     Vector<String> hotelsNames=new Vector<String>();
     Vector<String> hotelsRoomsTypes=new Vector<String>();
      Vector<String> AirportNames=new Vector<String>();
       Vector<String> AirportClass=new Vector<String>();
     
    public manager_page() {
        initComponents();
         //dateToText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("DD-MM-YYYY"))));
        //dateFromText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-mm-yyyy"))));
        myComponents();
         myeditOffer=  editOffer;
      displayOffers();
 
    }
    
  /* javax.swing.JLabel generalPrice1;********
     javax.swing.JLabel from1;
     javax.swing.JLabel   dateFrom1;
     javax.swing.JLabel hotelAddress1;**********
     javax.swing.JLabel airlineName1;***********
     javax.swing.JLabel flightClass1;************
    javax.swing.JTextArea offerDescriptionText1;
    javax.swing.JScrollPane jScrollPane8;
    javax.swing.JLabel  destination1;
    javax.swing.JLabel dateTo1;
    javax.swing.JLabel hotelName1;*********
    javax.swing.JLabel roomType1;********
    **********javax.swing.JLabel flightPrice1;*/  

       
    public void displayOffers() {
  offerGroup2.removeAll();
    offerGroup3.removeAll();
     try {
         java.sql.ResultSet rs = MangerFuctions .showAllOffers();
         int count=0;
         while(rs.next() && count<3){
             
             OfferPanel Myoffer=new OfferPanel(rs.getInt(1),this);
             Myoffer.currOffer.OSQ=rs.getInt(1);
             Myoffer.from1.setText(rs.getString(6));
             Myoffer.currOffer.setfrom_des(rs.getString(6));
             Myoffer.dateFrom1.setText(rs.getDate(3).toString());
              Myoffer.currOffer.Date_to=rs.getDate(3).toString();
             Myoffer.offerDescriptionText1.setText(rs.getString(2));
              Myoffer.currOffer.descrption=rs.getString(2);
             Myoffer.destination1.setText(rs.getString(5));
             Myoffer.currOffer.to_des=rs.getString(5);
             Myoffer.dateTo1.setText(rs.getDate(4).toString());
             Myoffer.currOffer.Date_from=rs.getDate(4).toString();
             ResultSet hotel=MangerFuctions.getHotelInfo(rs.getInt(1));
             hotel.next();
             Myoffer.hotelAddress1.setText(hotel.getString(2));
             Myoffer.hotelName1.setText(hotel.getString(1));
              Myoffer.currOffer.hname=hotel.getString(1);
             Myoffer.roomType1.setText(hotel.getString(6));
              Myoffer.currOffer.room_type=hotel.getString(6);
             ResultSet airport=MangerFuctions.getAirInfo(rs.getInt(1));
             airport.next();
             
             Myoffer.airlineName1.setText(airport.getString(1));
             Myoffer.currOffer.Aname=airport.getString(1);
             Myoffer.flightClass1.setText(Integer.toString(airport.getInt(5)));
             Myoffer.currOffer.classd=Integer.toString(airport.getInt(5));
             double generalPrice= airport.getInt(4)+hotel.getInt(5)+airport.getInt(4)+ hotel.getInt(5) *0.1;
              Myoffer.currOffer.price=generalPrice;
            // Myoffer.flightPrice1.setText(Integer.toString(airport.getInt(4)));
            Myoffer.generalPrice1.setText(Double.toString(generalPrice)+" $");
                Myoffer.jLabel17.setIcon(new javax.swing.ImageIcon(rs.getString(7)));
                 Myoffer.currOffer.Img=rs.getString(7);
             offerGroup2.add(Myoffer.scroll1);
             
         count++;
         }
         while(rs.next() && count<6){
               
             OfferPanel Myoffer=new OfferPanel(rs.getInt(1),this);
             Myoffer.currOffer.OSQ=rs.getInt(1);
             Myoffer.from1.setText(rs.getString(6));
             Myoffer.currOffer.setfrom_des(rs.getString(6));
             Myoffer.dateFrom1.setText(rs.getDate(3).toString());
              Myoffer.currOffer.Date_to=rs.getDate(3).toString();
             Myoffer.offerDescriptionText1.setText(rs.getString(2));
              Myoffer.currOffer.descrption=rs.getString(2);
             Myoffer.destination1.setText(rs.getString(5));
             Myoffer.currOffer.to_des=rs.getString(5);
             Myoffer.dateTo1.setText(rs.getDate(4).toString());
               Myoffer.currOffer.Date_from=rs.getDate(4).toString();
             ResultSet hotel=MangerFuctions.getHotelInfo(rs.getInt(1));
             hotel.next();
             Myoffer.hotelAddress1.setText(hotel.getString(2));
             Myoffer.hotelName1.setText(hotel.getString(1));
              Myoffer.currOffer.hname=hotel.getString(1);
             Myoffer.roomType1.setText(hotel.getString(6));
              Myoffer.currOffer.room_type=hotel.getString(6);
             ResultSet airport=MangerFuctions.getAirInfo(rs.getInt(1));
             airport.next();
             
             Myoffer.airlineName1.setText(airport.getString(1));
             Myoffer.currOffer.Aname=airport.getString(1);
             Myoffer.flightClass1.setText(Integer.toString(airport.getInt(5)));
             Myoffer.currOffer.classd=Integer.toString(airport.getInt(5));
             double generalPrice= airport.getInt(4)+hotel.getInt(5)+airport.getInt(4)+ hotel.getInt(5) *0.1;
              Myoffer.currOffer.price=generalPrice;
            // Myoffer.flightPrice1.setText(Integer.toString(airport.getInt(4)));
            Myoffer.generalPrice1.setText(Double.toString(generalPrice)+" $");
                Myoffer.jLabel17.setIcon(new javax.swing.ImageIcon(rs.getString(7)));
                 Myoffer.currOffer.Img=rs.getString(7);
             offerGroup3.add(Myoffer.scroll1);
         count++;
         }
         
         MangerFuctions.closeConn();
     } catch (Exception ex) {
         Logger.getLogger(manager_page.class.getName()).log(Level.SEVERE, null, ex);
     }
    } 
   
    private void myComponents(){
   
    searchAbout.setBackground(Color.white);
    Border border = new LineBorder(Color.getHSBColor(88, 88, 88), 2, true);
     searchAbout.setBorder(border);
     
     //add offer frame style
     airportNameList.setBorder(null);
     airportNameList.setBackground(Color.white);
     
     hotelNameList.setBorder(null);
     hotelNameList.setBackground(Color.white);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        closePanel = new javax.swing.JPanel();
        close = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        AdditionalserviceidText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dateToText = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        DestinationText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dateFromText = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        FromText = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        airportNameList = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        hotelNameList = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        offerDescriptionTextArea = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        addofferPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        addOfferUploadImage = new javax.swing.JButton();
        addHotelFrame = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        closePanel1 = new javax.swing.JPanel();
        close1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        hotelNameText = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        starsText = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        roomTypeText = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        addHotelPanel1 = new javax.swing.JPanel();
        addHotelButton = new javax.swing.JLabel();
        hotelAdderssText = new javax.swing.JTextField();
        hotelPriceText = new javax.swing.JTextField();
        SSQ1Text = new javax.swing.JTextField();
        addAirportFrame = new javax.swing.JFrame();
        jPanel11 = new javax.swing.JPanel();
        closePanel2 = new javax.swing.JPanel();
        close2 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        airportNameText = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        ticketPriceText = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        SSQ2Text = new javax.swing.JTextField();
        addAirportPanel1 = new javax.swing.JPanel();
        addAirportButton1 = new javax.swing.JLabel();
        airportAddressText = new javax.swing.JTextField();
        ticketClassText = new javax.swing.JTextField();
        editOffer = new javax.swing.JFrame();
        jPanel151 = new javax.swing.JPanel();
        closePanel3 = new javax.swing.JPanel();
        close3 = new javax.swing.JLabel();
        jPanel152 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        offerDescriptionTextArea1 = new javax.swing.JTextArea();
        jLabel113 = new javax.swing.JLabel();
        editOfferPanel = new javax.swing.JPanel();
        editOfferButton = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel115 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        FromText2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        DestinationText2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        dateFromText2 = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        dateToText2 = new javax.swing.JFormattedTextField();
        jLabel31 = new javax.swing.JLabel();
        AdditionalserviceidText2 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        airportNameList2 = new javax.swing.JComboBox<>();
        hotelNameList2 = new javax.swing.JComboBox<>();
        header = new javax.swing.JPanel();
        minMaxCloseIcon = new javax.swing.JPanel();
        minButton = new javax.swing.JPanel();
        minIcon = new javax.swing.JLabel();
        maxButton = new javax.swing.JPanel();
        maxIcone = new javax.swing.JLabel();
        closeButton = new javax.swing.JPanel();
        closeIcon = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        menuIcon = new javax.swing.JPanel();
        linemenu = new javax.swing.JPanel();
        menuback = new javax.swing.JPanel();
        IconMenu = new javax.swing.JLabel();
        menuHide = new javax.swing.JPanel();
        prfileInfo = new javax.swing.JPanel();
        profilepiclayout = new javax.swing.JPanel();
        profilePicpanel = new javax.swing.JPanel();
        profilePicIcon = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        userName = new javax.swing.JLabel();
        massegesAndButtons = new javax.swing.JPanel();
        showProfileAndAddOffer = new javax.swing.JPanel();
        showProfilePanel = new javax.swing.JPanel();
        ShowProfileButton = new javax.swing.JLabel();
        addOfferPanel = new javax.swing.JPanel();
        addOfferButton = new javax.swing.JLabel();
        addHotelPanel = new javax.swing.JPanel();
        addHotelButon = new javax.swing.JLabel();
        addAirportPanel = new javax.swing.JPanel();
        addAirportButton = new javax.swing.JLabel();
        masseges = new javax.swing.JPanel();
        main = new javax.swing.JPanel();
        headerForMain = new javax.swing.JPanel();
        searchPosition = new javax.swing.JPanel();
        searchLayout = new javax.swing.JPanel();
        searchText = new javax.swing.JTextField();
        submitSearch = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        searchAbout = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        offersPanel = new javax.swing.JPanel();
        phrase = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        offerGroup2 = new javax.swing.JPanel();
        offerGroup3 = new javax.swing.JPanel();

        jFrame1.setAlwaysOnTop(true);
        jFrame1.setMinimumSize(new java.awt.Dimension(500, 500));
        jFrame1.setUndecorated(true);
        jFrame1.setResizable(false);

        jPanel2.setBackground(new java.awt.Color(44, 159, 186));
        jPanel2.setPreferredSize(new java.awt.Dimension(476, 30));
        jPanel2.setLayout(new java.awt.BorderLayout());

        closePanel.setBackground(new java.awt.Color(44, 159, 186));
        closePanel.setPreferredSize(new java.awt.Dimension(30, 30));
        closePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design_imgs/close.png"))); // NOI18N
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeMouseExited(evt);
            }
        });
        closePanel.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jPanel2.add(closePanel, java.awt.BorderLayout.LINE_END);

        jFrame1.getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Additional service id:");

        AdditionalserviceidText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        AdditionalserviceidText.setPreferredSize(new java.awt.Dimension(100, 30));
        AdditionalserviceidText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdditionalserviceidTextActionPerformed(evt);
            }
        });

        jLabel5.setText("Date to:");

        dateToText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        dateToText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("22/12/2022"))));
        dateToText.setMinimumSize(new java.awt.Dimension(100, 30));
        dateToText.setPreferredSize(new java.awt.Dimension(100, 30));
        dateToText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateToTextActionPerformed(evt);
            }
        });

        jLabel6.setText("Destination:");

        DestinationText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        DestinationText.setMinimumSize(new java.awt.Dimension(100, 30));
        DestinationText.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel7.setText("Date From:");

        dateFromText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        dateFromText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("22/12/2022"))));
        dateFromText.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel8.setText("From:");

        FromText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        FromText.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel9.setText("Airport Name   &");

        airportNameList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        airportNameList.setBorder(null);
        airportNameList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airportNameListActionPerformed(evt);
            }
        });

        jLabel10.setText("Flight class");

        jLabel11.setText("Hotel name    & ");

        hotelNameList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("Room type");

        offerDescriptionTextArea.setColumns(20);
        offerDescriptionTextArea.setRows(5);
        offerDescriptionTextArea.setPreferredSize(new java.awt.Dimension(150, 84));
        jScrollPane1.setViewportView(offerDescriptionTextArea);

        jLabel13.setText("Offer description");

        addofferPanel.setBackground(new java.awt.Color(44, 159, 186));
        addofferPanel.setPreferredSize(new java.awt.Dimension(150, 30));
        addofferPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addofferPanelMouseClicked(evt);
            }
        });
        addofferPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton.setBackground(new java.awt.Color(141, 221, 210));
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design_imgs/icons8-add-new-32.png"))); // NOI18N
        addButton.setText("        Add offer  ");
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addButtonMouseExited(evt);
            }
        });
        addofferPanel.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, -1));

        jLabel116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design_imgs/offer.png"))); // NOI18N
        jLabel116.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel116.setMaximumSize(new java.awt.Dimension(1000, 1000));
        jLabel116.setMinimumSize(new java.awt.Dimension(100, 100));
        jLabel116.setPreferredSize(new java.awt.Dimension(200, 200));

        addOfferUploadImage.setText("upload Image");
        addOfferUploadImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOfferUploadImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addOfferUploadImage)
                .addGap(70, 70, 70))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(addofferPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel8Layout.createSequentialGroup()
                                                    .addComponent(jLabel7)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(dateFromText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel8Layout.createSequentialGroup()
                                                    .addComponent(jLabel4)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(AdditionalserviceidText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(dateToText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(94, 94, 94)
                                            .addComponent(FromText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(DestinationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(airportNameList, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(23, 23, 23)
                                                .addComponent(jLabel10))
                                            .addComponent(jLabel13))
                                        .addGap(68, 68, 68)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(hotelNameList, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel12)))))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(DestinationText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(FromText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(dateToText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFromText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdditionalserviceidText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(5, 5, 5)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hotelNameList, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(airportNameList, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addOfferUploadImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(addofferPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jFrame1.getContentPane().add(jPanel8, java.awt.BorderLayout.CENTER);

        addHotelFrame.setMinimumSize(new java.awt.Dimension(476, 222));
        addHotelFrame.setUndecorated(true);
        addHotelFrame.setResizable(false);

        jPanel3.setBackground(new java.awt.Color(44, 159, 186));
        jPanel3.setPreferredSize(new java.awt.Dimension(476, 30));
        jPanel3.setLayout(new java.awt.BorderLayout());

        closePanel1.setBackground(new java.awt.Color(44, 159, 186));
        closePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design_imgs/close.png"))); // NOI18N
        close1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                close1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                close1MouseExited(evt);
            }
        });
        closePanel1.add(close1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jPanel3.add(closePanel1, java.awt.BorderLayout.LINE_END);

        addHotelFrame.getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setText("Hotel Name:");

        hotelNameText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        hotelNameText.setPreferredSize(new java.awt.Dimension(100, 30));
        hotelNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hotelNameTextActionPerformed(evt);
            }
        });

        jLabel19.setText("Hotel Address:");

        jLabel20.setText("Stars:");

        starsText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        starsText.setMinimumSize(new java.awt.Dimension(100, 30));
        starsText.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel21.setText("Hotel Price:");

        jLabel22.setText("Room Type:");

        roomTypeText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        roomTypeText.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel23.setText("SSQ1:");

        addHotelPanel1.setBackground(new java.awt.Color(44, 159, 186));
        addHotelPanel1.setPreferredSize(new java.awt.Dimension(150, 30));
        addHotelPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addHotelButton.setBackground(new java.awt.Color(141, 221, 210));
        addHotelButton.setForeground(new java.awt.Color(255, 255, 255));
        addHotelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design_imgs/icons8-add-new-32.png"))); // NOI18N
        addHotelButton.setText("        Add Hotel  ");
        addHotelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addHotelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addHotelButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addHotelButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addHotelButtonMouseExited(evt);
            }
        });
        addHotelPanel1.add(addHotelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 32));

        hotelAdderssText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        hotelAdderssText.setPreferredSize(new java.awt.Dimension(100, 30));
        hotelAdderssText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hotelAdderssTextActionPerformed(evt);
            }
        });

        hotelPriceText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        hotelPriceText.setPreferredSize(new java.awt.Dimension(100, 30));

        SSQ1Text.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        SSQ1Text.setPreferredSize(new java.awt.Dimension(100, 30));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hotelNameText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(starsText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(roomTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hotelAdderssText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hotelPriceText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SSQ1Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addHotelPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(hotelNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(hotelAdderssText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(starsText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(hotelPriceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(roomTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(SSQ1Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(addHotelPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        addHotelFrame.getContentPane().add(jPanel9, java.awt.BorderLayout.CENTER);

        addAirportFrame.setMinimumSize(new java.awt.Dimension(476, 222));
        addAirportFrame.setUndecorated(true);
        addAirportFrame.setResizable(false);

        jPanel11.setBackground(new java.awt.Color(44, 159, 186));
        jPanel11.setPreferredSize(new java.awt.Dimension(476, 30));
        jPanel11.setLayout(new java.awt.BorderLayout());

        closePanel2.setBackground(new java.awt.Color(44, 159, 186));
        closePanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design_imgs/close.png"))); // NOI18N
        close2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                close2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                close2MouseExited(evt);
            }
        });
        closePanel2.add(close2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jPanel11.add(closePanel2, java.awt.BorderLayout.LINE_END);

        addAirportFrame.getContentPane().add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setText("Airport name:");

        airportNameText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        airportNameText.setPreferredSize(new java.awt.Dimension(100, 30));
        airportNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airportNameTextActionPerformed(evt);
            }
        });

        jLabel27.setText("Airport Address:");

        jLabel28.setText("Ticket Price:");

        ticketPriceText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        ticketPriceText.setMinimumSize(new java.awt.Dimension(100, 30));
        ticketPriceText.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel29.setText("Ticket Class:");

        jLabel30.setText("SSQ2");

        SSQ2Text.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        SSQ2Text.setPreferredSize(new java.awt.Dimension(100, 30));

        addAirportPanel1.setBackground(new java.awt.Color(44, 159, 186));
        addAirportPanel1.setPreferredSize(new java.awt.Dimension(150, 30));
        addAirportPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addAirportButton1.setBackground(new java.awt.Color(141, 221, 210));
        addAirportButton1.setForeground(new java.awt.Color(255, 255, 255));
        addAirportButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design_imgs/icons8-add-new-32.png"))); // NOI18N
        addAirportButton1.setText("        Add Airport  ");
        addAirportButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addAirportButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addAirportButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addAirportButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addAirportButton1MouseExited(evt);
            }
        });
        addAirportPanel1.add(addAirportButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 32));

        airportAddressText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        airportAddressText.setPreferredSize(new java.awt.Dimension(100, 30));
        airportAddressText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airportAddressTextActionPerformed(evt);
            }
        });

        ticketClassText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        ticketClassText.setPreferredSize(new java.awt.Dimension(100, 30));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel26)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(airportNameText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ticketPriceText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel29)))
                    .addComponent(SSQ2Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(airportAddressText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ticketClassText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addAirportPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(airportNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(airportAddressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(ticketPriceText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(ticketClassText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(SSQ2Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(addAirportPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        addAirportFrame.getContentPane().add(jPanel12, java.awt.BorderLayout.CENTER);

        editOffer.setAlwaysOnTop(true);
        editOffer.setMinimumSize(new java.awt.Dimension(500, 500));
        editOffer.setUndecorated(true);
        editOffer.setResizable(false);

        jPanel151.setBackground(new java.awt.Color(44, 159, 186));
        jPanel151.setPreferredSize(new java.awt.Dimension(476, 30));
        jPanel151.setLayout(new java.awt.BorderLayout());

        closePanel3.setBackground(new java.awt.Color(44, 159, 186));
        closePanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design_imgs/close.png"))); // NOI18N
        close3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                close3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                close3MouseExited(evt);
            }
        });
        closePanel3.add(close3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jPanel151.add(closePanel3, java.awt.BorderLayout.LINE_END);

        editOffer.getContentPane().add(jPanel151, java.awt.BorderLayout.PAGE_START);

        jPanel152.setBackground(new java.awt.Color(255, 255, 255));

        offerDescriptionTextArea1.setColumns(20);
        offerDescriptionTextArea1.setRows(5);
        jScrollPane2.setViewportView(offerDescriptionTextArea1);

        jLabel113.setText("Offer description");

        editOfferPanel.setBackground(new java.awt.Color(44, 159, 186));
        editOfferPanel.setPreferredSize(new java.awt.Dimension(150, 30));
        editOfferPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editOfferPanelMouseClicked(evt);
            }
        });
        editOfferPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editOfferButton.setBackground(new java.awt.Color(141, 221, 210));
        editOfferButton.setForeground(new java.awt.Color(255, 255, 255));
        editOfferButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design_imgs/icons8-add-new-32.png"))); // NOI18N
        editOfferButton.setText("        Edit Offer");
        editOfferButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editOfferButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editOfferButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editOfferButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editOfferButtonMouseExited(evt);
            }
        });
        editOfferPanel.add(editOfferButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, -1));

        jButton1.setText("upload image");

        jLabel115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design_imgs/offer.png"))); // NOI18N
        jLabel115.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel115.setMaximumSize(new java.awt.Dimension(1000, 1000));
        jLabel115.setMinimumSize(new java.awt.Dimension(265, 200));
        jLabel115.setPreferredSize(new java.awt.Dimension(265, 200));

        jLabel14.setText("From:");

        FromText2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        FromText2.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel15.setText("Destination:");

        DestinationText2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        DestinationText2.setMinimumSize(new java.awt.Dimension(100, 30));
        DestinationText2.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel16.setText("Date From:");

        dateFromText2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        dateFromText2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("22/12/2022"))));
        dateFromText2.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel17.setText("Date to:");

        dateToText2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        dateToText2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("22/12/2022"))));
        dateToText2.setMinimumSize(new java.awt.Dimension(100, 30));
        dateToText2.setPreferredSize(new java.awt.Dimension(100, 30));
        dateToText2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateToText2ActionPerformed(evt);
            }
        });

        jLabel31.setText("Additional service id:");

        AdditionalserviceidText2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        AdditionalserviceidText2.setPreferredSize(new java.awt.Dimension(100, 30));
        AdditionalserviceidText2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdditionalserviceidText2ActionPerformed(evt);
            }
        });

        jLabel32.setText("Airport Name   &");

        jLabel33.setText("Flight class");

        jLabel34.setText("Hotel name    & ");

        jLabel35.setText("Room type");

        airportNameList2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        airportNameList2.setBorder(null);
        airportNameList2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airportNameList2ActionPerformed(evt);
            }
        });

        hotelNameList2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel152Layout = new javax.swing.GroupLayout(jPanel152);
        jPanel152.setLayout(jPanel152Layout);
        jPanel152Layout.setHorizontalGroup(
            jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel152Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(57, 57, 57))
            .addGroup(jPanel152Layout.createSequentialGroup()
                .addGroup(jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel152Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel152Layout.createSequentialGroup()
                                .addGroup(jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel113)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanel152Layout.createSequentialGroup()
                                .addGroup(jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel152Layout.createSequentialGroup()
                                            .addGroup(jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel152Layout.createSequentialGroup()
                                                    .addComponent(jLabel16)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(dateFromText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel152Layout.createSequentialGroup()
                                                    .addComponent(jLabel31)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(AdditionalserviceidText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel17)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(dateToText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel152Layout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addGap(94, 94, 94)
                                            .addComponent(FromText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel15)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(DestinationText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel152Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(airportNameList2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel152Layout.createSequentialGroup()
                                                .addComponent(jLabel32)
                                                .addGap(23, 23, 23)
                                                .addComponent(jLabel33)))
                                        .addGap(68, 68, 68)
                                        .addGroup(jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(hotelNameList2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel152Layout.createSequentialGroup()
                                                .addComponent(jLabel34)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel35)))))
                                .addGap(0, 23, Short.MAX_VALUE))))
                    .addGroup(jPanel152Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(editOfferPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel152Layout.setVerticalGroup(
            jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel152Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(DestinationText2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(FromText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(dateToText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFromText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdditionalserviceidText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGroup(jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel152Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel152Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35))
                        .addGap(5, 5, 5)))
                .addGroup(jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hotelNameList2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(airportNameList2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel113)
                .addGroup(jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel152Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel152Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(15, 15, 15)
                .addComponent(editOfferPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        editOffer.getContentPane().add(jPanel152, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 700));

        header.setBackground(new java.awt.Color(44, 159, 186));
        header.setPreferredSize(new java.awt.Dimension(576, 50));
        header.setLayout(new java.awt.BorderLayout());

        minMaxCloseIcon.setBackground(new java.awt.Color(141, 221, 210));
        minMaxCloseIcon.setPreferredSize(new java.awt.Dimension(150, 50));
        minMaxCloseIcon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minButton.setBackground(new java.awt.Color(44, 159, 186));

        minIcon.setBackground(new java.awt.Color(44, 159, 186));
        minIcon.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout minButtonLayout = new javax.swing.GroupLayout(minButton);
        minButton.setLayout(minButtonLayout);
        minButtonLayout.setHorizontalGroup(
            minButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(minButtonLayout.createSequentialGroup()
                .addComponent(minIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        minButtonLayout.setVerticalGroup(
            minButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(minButtonLayout.createSequentialGroup()
                .addComponent(minIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        minMaxCloseIcon.add(minButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        maxButton.setBackground(new java.awt.Color(44, 159, 186));

        maxIcone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design_imgs/full_screen_32px.png"))); // NOI18N
        maxIcone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        maxIcone.setPreferredSize(new java.awt.Dimension(50, 50));
        maxIcone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maxIconeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                maxIconeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                maxIconeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout maxButtonLayout = new javax.swing.GroupLayout(maxButton);
        maxButton.setLayout(maxButtonLayout);
        maxButtonLayout.setHorizontalGroup(
            maxButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, maxButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(maxIcone, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
        );
        maxButtonLayout.setVerticalGroup(
            maxButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, maxButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(maxIcone, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
        );

        minMaxCloseIcon.add(maxButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 50, 50));

        closeButton.setBackground(new java.awt.Color(44, 159, 186));

        closeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design_imgs/close.png"))); // NOI18N
        closeIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeIconMouseExited(evt);
            }
        });

        javax.swing.GroupLayout closeButtonLayout = new javax.swing.GroupLayout(closeButton);
        closeButton.setLayout(closeButtonLayout);
        closeButtonLayout.setHorizontalGroup(
            closeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(closeButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        closeButtonLayout.setVerticalGroup(
            closeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, closeButtonLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        minMaxCloseIcon.add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 50, 50));

        header.add(minMaxCloseIcon, java.awt.BorderLayout.LINE_END);

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        menu.setBackground(new java.awt.Color(141, 221, 210));
        menu.setPreferredSize(new java.awt.Dimension(250, 501));
        menu.setLayout(new java.awt.BorderLayout());

        menuIcon.setBackground(new java.awt.Color(44, 159, 186));
        menuIcon.setPreferredSize(new java.awt.Dimension(50, 493));
        menuIcon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        linemenu.setBackground(new java.awt.Color(44, 159, 186));
        linemenu.setPreferredSize(new java.awt.Dimension(50, 5));

        javax.swing.GroupLayout linemenuLayout = new javax.swing.GroupLayout(linemenu);
        linemenu.setLayout(linemenuLayout);
        linemenuLayout.setHorizontalGroup(
            linemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        linemenuLayout.setVerticalGroup(
            linemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        menuIcon.add(linemenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 5));

        menuback.setBackground(new java.awt.Color(44, 159, 186));
        menuback.setLayout(new java.awt.BorderLayout());

        IconMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design_imgs/back_32px.png"))); // NOI18N
        IconMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IconMenu.setMaximumSize(new java.awt.Dimension(100, 100));
        IconMenu.setName(""); // NOI18N
        IconMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IconMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                IconMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                IconMenuMouseExited(evt);
            }
        });
        menuback.add(IconMenu, java.awt.BorderLayout.CENTER);

        menuIcon.add(menuback, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 50, 50));

        menu.add(menuIcon, java.awt.BorderLayout.LINE_START);

        menuHide.setBackground(new java.awt.Color(141, 221, 210));
        menuHide.setLayout(new java.awt.BorderLayout());

        prfileInfo.setBackground(new java.awt.Color(141, 221, 210));
        prfileInfo.setPreferredSize(new java.awt.Dimension(200, 160));
        prfileInfo.setLayout(new java.awt.BorderLayout());

        profilepiclayout.setBackground(new java.awt.Color(44, 159, 186));
        profilepiclayout.setPreferredSize(new java.awt.Dimension(198, 130));
        profilepiclayout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profilePicpanel.setBackground(new java.awt.Color(44, 159, 186));
        profilePicpanel.setPreferredSize(new java.awt.Dimension(126, 126));

        profilePicIcon.setBackground(new java.awt.Color(141, 221, 210));
        profilePicIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design_imgs/Capture5.PNG"))); // NOI18N
        profilePicIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profilePicIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profilePicIconMouseExited(evt);
            }
        });

        javax.swing.GroupLayout profilePicpanelLayout = new javax.swing.GroupLayout(profilePicpanel);
        profilePicpanel.setLayout(profilePicpanelLayout);
        profilePicpanelLayout.setHorizontalGroup(
            profilePicpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profilePicIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );
        profilePicpanelLayout.setVerticalGroup(
            profilePicpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePicpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profilePicIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );

        profilepiclayout.add(profilePicpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, -1));

        prfileInfo.add(profilepiclayout, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(44, 159, 186));

        userName.setBackground(new java.awt.Color(255, 255, 255));
        userName.setForeground(new java.awt.Color(255, 255, 255));
        userName.setText("Mohamad Isa Moghrabi");
        jPanel1.add(userName);

        prfileInfo.add(jPanel1, java.awt.BorderLayout.CENTER);

        menuHide.add(prfileInfo, java.awt.BorderLayout.PAGE_START);

        massegesAndButtons.setBackground(new java.awt.Color(44, 159, 186));
        massegesAndButtons.setLayout(new java.awt.BorderLayout());

        showProfileAndAddOffer.setBackground(new java.awt.Color(44, 159, 186));
        showProfileAndAddOffer.setPreferredSize(new java.awt.Dimension(200, 200));
        showProfileAndAddOffer.setLayout(new java.awt.GridLayout(4, 0, 0, 10));

        showProfilePanel.setBackground(new java.awt.Color(162, 194, 215));
        showProfilePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 159, 186), 2));
        showProfilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ShowProfileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design_imgs/icons8-user-menu-female-32.png"))); // NOI18N
        ShowProfileButton.setText("            Show Profile");
        ShowProfileButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ShowProfileButton.setPreferredSize(new java.awt.Dimension(200, 45));
        ShowProfileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ShowProfileButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ShowProfileButtonMouseExited(evt);
            }
        });
        showProfilePanel.add(ShowProfileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        showProfileAndAddOffer.add(showProfilePanel);

        addOfferPanel.setBackground(new java.awt.Color(162, 194, 215));
        addOfferPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 159, 186), 2));
        addOfferPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addOfferButton.setBackground(new java.awt.Color(255, 255, 255));
        addOfferButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design_imgs/icons8-add-new-32.png"))); // NOI18N
        addOfferButton.setText("            Add Offer");
        addOfferButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addOfferButton.setPreferredSize(new java.awt.Dimension(200, 45));
        addOfferButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addOfferButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addOfferButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addOfferButtonMouseExited(evt);
            }
        });
        addOfferPanel.add(addOfferButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        showProfileAndAddOffer.add(addOfferPanel);

        addHotelPanel.setBackground(new java.awt.Color(162, 194, 215));
        addHotelPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 159, 186), 2));
        addHotelPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addHotelButon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design_imgs/icons8-add-new-32.png"))); // NOI18N
        addHotelButon.setText("            Add Hotel");
        addHotelButon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addHotelButon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addHotelButonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addHotelButonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addHotelButonMouseExited(evt);
            }
        });
        addHotelPanel.add(addHotelButon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 200, 50));

        showProfileAndAddOffer.add(addHotelPanel);

        addAirportPanel.setBackground(new java.awt.Color(162, 194, 215));
        addAirportPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 159, 186), 2));
        addAirportPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addAirportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design_imgs/icons8-add-new-32.png"))); // NOI18N
        addAirportButton.setText("           Add Airport");
        addAirportButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addAirportButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addAirportButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addAirportButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addAirportButtonMouseExited(evt);
            }
        });
        addAirportPanel.add(addAirportButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, 200, 40));

        showProfileAndAddOffer.add(addAirportPanel);

        massegesAndButtons.add(showProfileAndAddOffer, java.awt.BorderLayout.PAGE_START);

        masseges.setBackground(new java.awt.Color(44, 159, 186));

        javax.swing.GroupLayout massegesLayout = new javax.swing.GroupLayout(masseges);
        masseges.setLayout(massegesLayout);
        massegesLayout.setHorizontalGroup(
            massegesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        massegesLayout.setVerticalGroup(
            massegesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
        );

        massegesAndButtons.add(masseges, java.awt.BorderLayout.CENTER);

        menuHide.add(massegesAndButtons, java.awt.BorderLayout.CENTER);

        menu.add(menuHide, java.awt.BorderLayout.CENTER);

        getContentPane().add(menu, java.awt.BorderLayout.LINE_START);

        main.setBackground(new java.awt.Color(51, 102, 255));
        main.setLayout(new java.awt.BorderLayout());

        headerForMain.setBackground(new java.awt.Color(51, 102, 255));
        headerForMain.setPreferredSize(new java.awt.Dimension(485, 150));
        headerForMain.setLayout(new java.awt.BorderLayout());

        searchPosition.setBackground(new java.awt.Color(255, 255, 255));
        searchPosition.setPreferredSize(new java.awt.Dimension(485, 50));

        searchLayout.setBackground(new java.awt.Color(255, 255, 255));
        searchLayout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        searchLayout.setPreferredSize(new java.awt.Dimension(402, 45));
        searchLayout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchText.setBorder(null);
        searchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextActionPerformed(evt);
            }
        });
        searchLayout.add(searchText, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 240, 40));

        submitSearch.setBackground(new java.awt.Color(204, 204, 204));
        submitSearch.setPreferredSize(new java.awt.Dimension(60, 60));
        submitSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                submitSearchMouseExited(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design_imgs/icons8-search-30.png"))); // NOI18N
        jLabel3.setToolTipText("");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout submitSearchLayout = new javax.swing.GroupLayout(submitSearch);
        submitSearch.setLayout(submitSearchLayout);
        submitSearchLayout.setHorizontalGroup(
            submitSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        submitSearchLayout.setVerticalGroup(
            submitSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, submitSearchLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        searchLayout.add(submitSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, -20, 50, 70));

        searchAbout.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Date", "From", "To", "Travelling Way", "Price" }));
        searchAbout.setBorder(null);
        searchAbout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchAbout.setPreferredSize(new java.awt.Dimension(10, 20));
        searchAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAboutActionPerformed(evt);
            }
        });
        searchLayout.add(searchAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -10, 110, 70));

        searchPosition.add(searchLayout);

        headerForMain.add(searchPosition, java.awt.BorderLayout.PAGE_END);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.GridLayout(3, 0));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 797, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel5);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setMinimumSize(new java.awt.Dimension(235, 65));

        jLabel2.setFont(new java.awt.Font("Stencil", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(88, 88, 88));
        jLabel2.setText("Easy Travel");
        jLabel2.setPreferredSize(new java.awt.Dimension(225, 40));
        jPanel7.add(jLabel2);

        jPanel6.add(jPanel7);

        headerForMain.add(jPanel6, java.awt.BorderLayout.CENTER);

        main.add(headerForMain, java.awt.BorderLayout.PAGE_START);

        offersPanel.setBackground(new java.awt.Color(255, 255, 255));
        offersPanel.setLayout(new java.awt.GridLayout(3, 0, 10, 10));

        phrase.setBackground(new java.awt.Color(255, 255, 255));
        phrase.setLayout(new java.awt.GridLayout(2, 0));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setFont(new java.awt.Font("Segoe Print", 0, 24)); // NOI18N
        jLabel24.setText("For Easy And Affordable Travelling");
        jPanel4.add(jLabel24);

        phrase.add(jPanel4);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setFont(new java.awt.Font("Segoe Print", 0, 24)); // NOI18N
        jLabel25.setText("With All The Transportation Available");
        jPanel10.add(jLabel25);

        phrase.add(jPanel10);

        offersPanel.add(phrase);

        offerGroup2.setBackground(new java.awt.Color(255, 255, 255));
        offerGroup2.setLayout(new java.awt.GridLayout(0, 3, 10, 0));
        offersPanel.add(offerGroup2);

        offerGroup3.setBackground(new java.awt.Color(255, 255, 255));
        offerGroup3.setLayout(new java.awt.GridLayout(0, 3, 10, 0));
        offersPanel.add(offerGroup3);

        main.add(offersPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(main, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void changecolor(JPanel hover, Color rand){
        hover.setBackground(rand);
    }
    
    public void clickmenu(JPanel h1, int numberbool){
        if(numberbool == 1){
            h1.setBackground(new Color(44,159,186));
            
        }
        else{
            h1.setBackground(new Color(44,159,186));
        }
    }
    
    public void changeimage(JLabel button, String resourcheimg){
        ImageIcon aimg = new ImageIcon(getClass().getResource(resourcheimg));
        button.setIcon(aimg);
    }
    
    public void hideshow(JPanel menushowhide, boolean dashboard, JLabel Button){
        if(dashboard == true){
            menushowhide.setPreferredSize(new Dimension(50, menushowhide.getHeight()));
            changeimage(Button,"/design_imgs/menu_32px.png");
        }
        else{
            menushowhide.setPreferredSize(new Dimension(270, menushowhide.getHeight()));
            changeimage(Button,"/design_imgs/back_32px.png");
        }
        
    }
    
    private void closeIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeIconMouseEntered
       changecolor(closeButton, new Color(255,0,0));
    }//GEN-LAST:event_closeIconMouseEntered

    private void closeIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeIconMouseExited
        changecolor(closeButton, new Color(44,159,186));
    }//GEN-LAST:event_closeIconMouseExited

    private void closeIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeIconMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeIconMouseClicked

    private void maxIconeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maxIconeMouseClicked
        if(this.getExtendedState()!= manager_page.MAXIMIZED_BOTH){
          this.setExtendedState(manager_page.MAXIMIZED_BOTH);
        }
        else{
            this.setExtendedState(manager_page.NORMAL);
        }
        
    }//GEN-LAST:event_maxIconeMouseClicked

    private void maxIconeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maxIconeMouseEntered
         changecolor(maxButton, new Color(153,153,153));
    }//GEN-LAST:event_maxIconeMouseEntered

    private void maxIconeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maxIconeMouseExited
        changecolor(maxButton, new Color(44,159,186));
    }//GEN-LAST:event_maxIconeMouseExited

    private void IconMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IconMenuMouseClicked
         clickmenu(menuback,1);
       
        //create void for methode hide and show panel menu
        if(a==true){
          hideshow(menu, a ,IconMenu);
          SwingUtilities.updateComponentTreeUI(this);
         
          a=false;
        }
        else{
            hideshow(menu, a ,IconMenu);
            SwingUtilities.updateComponentTreeUI(this);
         
            a=true;
        }
        searchText.setBorder(null);
       
    }//GEN-LAST:event_IconMenuMouseClicked

    private void IconMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IconMenuMouseEntered
        changecolor(linemenu, new Color(153,153,153));
        
    }//GEN-LAST:event_IconMenuMouseEntered

    private void IconMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IconMenuMouseExited
         changecolor(linemenu, new Color(44,159,186));
    }//GEN-LAST:event_IconMenuMouseExited

    private void submitSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitSearchMouseEntered
        changecolor(submitSearch, new Color(204,204,255));
    }//GEN-LAST:event_submitSearchMouseEntered

    private void submitSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitSearchMouseExited
        changecolor(submitSearch, new Color(204,204,204));
    }//GEN-LAST:event_submitSearchMouseExited

    private void searchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextActionPerformed

    private void profilePicIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePicIconMouseEntered
       
    }//GEN-LAST:event_profilePicIconMouseEntered

    private void profilePicIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePicIconMouseExited
        
    }//GEN-LAST:event_profilePicIconMouseExited

    private void searchAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchAboutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchAboutActionPerformed

    private void ShowProfileButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowProfileButtonMouseEntered
         changecolor(showProfilePanel, new Color(204,204,204));
    }//GEN-LAST:event_ShowProfileButtonMouseEntered

    private void ShowProfileButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowProfileButtonMouseExited
        changecolor(showProfilePanel, new Color(162,194,215));
    }//GEN-LAST:event_ShowProfileButtonMouseExited

    private void addOfferButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addOfferButtonMouseEntered
        changecolor(addOfferPanel, new Color(204,204,204));
    }//GEN-LAST:event_addOfferButtonMouseEntered

    private void addOfferButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addOfferButtonMouseExited
        changecolor(addOfferPanel, new Color(162,194,215));
    }//GEN-LAST:event_addOfferButtonMouseExited

    private void addOfferButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addOfferButtonMouseClicked
     try {
         newOffer=new Offer();
         airportNameList.removeAllItems();
        hotelNameList.removeAllItems();
         AirportClass.removeAllElements();
          AirportNames.removeAllElements();
          hotelsNames.removeAllElements();
          hotelsRoomsTypes.removeAllElements();
      
         ResultSet airports=MangerFuctions.getAirInfo(0);
         ResultSet hotels=MangerFuctions.getHotelInfo(0);
         while(airports.next()){
        airportNameList.addItem(airports.getString(1)+" , class:"+Integer.toString(airports.getInt(5)));
        AirportNames.add(airports.getString(1));
        AirportClass.add(Integer.toString(airports.getInt(5)));
        
         }
         while(hotels.next()){
             hotelNameList.addItem(hotels.getString(1)+" , room:"+hotels.getString(6));
            hotelsNames.add(hotels.getString(1));
            hotelsRoomsTypes.add(hotels.getString(6));
             
         }
         
          
         jFrame1.setVisible(true);
         addHotelFrame.setVisible(false);
         addAirportFrame.setVisible(false);
         jFrame1.setLocationRelativeTo(null);
     } catch (SQLException ex) {
         Logger.getLogger(manager_page.class.getName()).log(Level.SEVERE, null, ex);
     }
        
    }//GEN-LAST:event_addOfferButtonMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
         jFrame1.setVisible(false);
    }//GEN-LAST:event_closeMouseClicked

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        changecolor(closePanel, new Color(255,0,0));
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        changecolor(closePanel, new Color(44,159,186));
    }//GEN-LAST:event_closeMouseExited

    private void close1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1MouseClicked
        addHotelFrame.setVisible(false);
    }//GEN-LAST:event_close1MouseClicked

    private void close1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1MouseEntered
       changecolor(closePanel1, new Color(255,0,0));
    }//GEN-LAST:event_close1MouseEntered

    private void close1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1MouseExited
        changecolor(closePanel1, new Color(44,159,186));
    }//GEN-LAST:event_close1MouseExited

    private void hotelNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hotelNameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hotelNameTextActionPerformed

    private void addHotelButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addHotelButtonMouseEntered
        changecolor(addHotelPanel1, new Color(204,204,204));
    }//GEN-LAST:event_addHotelButtonMouseEntered

    private void addHotelButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addHotelButtonMouseExited
        changecolor(addHotelPanel1, new Color(44,159,186));
    }//GEN-LAST:event_addHotelButtonMouseExited

    private void hotelAdderssTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hotelAdderssTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hotelAdderssTextActionPerformed

    private void addHotelButonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addHotelButonMouseEntered
        changecolor(addHotelPanel, new Color(204,204,204));
    }//GEN-LAST:event_addHotelButonMouseEntered

    private void addHotelButonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addHotelButonMouseExited
        changecolor(addHotelPanel, new Color(162,194,215));
    }//GEN-LAST:event_addHotelButonMouseExited

    private void addHotelButonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addHotelButonMouseClicked
        addHotelFrame.setVisible(true);
        addAirportFrame.setVisible(false);
        jFrame1.setVisible(false);
        addHotelFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_addHotelButonMouseClicked

    private void close2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close2MouseClicked
        addAirportFrame.setVisible(false);
        addAirportFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_close2MouseClicked

    private void close2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close2MouseEntered
        changecolor(closePanel2, new Color(255,0,0));
    }//GEN-LAST:event_close2MouseEntered

    private void close2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close2MouseExited
        changecolor(closePanel2, new Color(44,159,186));
    }//GEN-LAST:event_close2MouseExited

    private void airportNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airportNameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_airportNameTextActionPerformed

    private void addAirportButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addAirportButton1MouseEntered
        changecolor(addAirportPanel1, new Color(204,204,204));
    }//GEN-LAST:event_addAirportButton1MouseEntered

    private void addAirportButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addAirportButton1MouseExited
        changecolor(addAirportPanel1, new Color(44,159,186));
    }//GEN-LAST:event_addAirportButton1MouseExited

    private void airportAddressTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airportAddressTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_airportAddressTextActionPerformed

    private void addAirportButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addAirportButtonMouseEntered
        changecolor(addAirportPanel, new Color(204,204,204));
    }//GEN-LAST:event_addAirportButtonMouseEntered

    private void addAirportButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addAirportButtonMouseExited
        changecolor(addAirportPanel, new Color(162,194,215));
    }//GEN-LAST:event_addAirportButtonMouseExited

    private void addAirportButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addAirportButtonMouseClicked
        addAirportFrame.setVisible(true);
        addHotelFrame.setVisible(false);
        jFrame1.setVisible(false);
        addAirportFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_addAirportButtonMouseClicked

    private void close3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close3MouseClicked
        editOffer.setVisible(false);
    }//GEN-LAST:event_close3MouseClicked

    private void close3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close3MouseEntered
        changecolor(closePanel3, new Color(255,0,0));
        
    }//GEN-LAST:event_close3MouseEntered

    private void close3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close3MouseExited
        changecolor(closePanel3, new Color(44,159,186));
    }//GEN-LAST:event_close3MouseExited

    private void addOfferUploadImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOfferUploadImageActionPerformed

        try {
            File f=null;
            final JFileChooser fc = new JFileChooser();
            JFileChooser  f1=new JFileChooser ();
            f1.showOpenDialog(this.getContentPane());
            f= f1.getSelectedFile();
            jLabel116.setIcon(new javax.swing.ImageIcon(f.getAbsolutePath()));
            newOffer.setImageFile(f);

        } catch (Exception ex) {
            Logger.getLogger(manager_page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addOfferUploadImageActionPerformed

    private void addofferPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addofferPanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addofferPanelMouseClicked

    private void addButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseExited
        changecolor(addofferPanel, new Color(44,159,186));
    }//GEN-LAST:event_addButtonMouseExited

    private void addButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseEntered
        changecolor(addofferPanel, new Color(204,204,204));
    }//GEN-LAST:event_addButtonMouseEntered

    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked
         
           newOffer.setOSQ(MangerFuctions.getOfferSeq());
           newOffer.setdescription(offerDescriptionTextArea.getText());
           newOffer.setDate_to(dateToText.getText());
           newOffer.setDate_from(dateFromText.getText());
           newOffer.setclassd(AirportClass.get(airportNameList.getSelectedIndex()));
           newOffer.sethname(hotelsNames.get(hotelNameList.getSelectedIndex()));
           newOffer.setroom_type(hotelsRoomsTypes.get(hotelNameList.getSelectedIndex()));
           newOffer.setAname(AirportNames.get(airportNameList.getSelectedIndex()));
           newOffer.setfrom_des(FromText.getText());
           newOffer.setto_des(DestinationText.getText());
           MangerFuctions.AddNewOffer(newOffer);
         newOffer.generateImg();
         displayOffers();
    }//GEN-LAST:event_addButtonMouseClicked

    private void dateToTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateToTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateToTextActionPerformed

    private void AdditionalserviceidTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdditionalserviceidTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdditionalserviceidTextActionPerformed

    private void airportNameListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airportNameListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_airportNameListActionPerformed

    private void addHotelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addHotelButtonMouseClicked
         MangerFuctions.AddHotel(hotelNameText.getText(),hotelAdderssText.getText(),Integer.parseInt(starsText.getText()),Integer.parseInt(hotelPriceText.getText()),roomTypeText.getText());
  
    }//GEN-LAST:event_addHotelButtonMouseClicked

    private void addAirportButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addAirportButton1MouseClicked
         MangerFuctions.AddAirport (airportNameText.getText(),airportAddressText.getText(),Integer.parseInt(ticketPriceText.getText()),Integer.parseInt(ticketClassText.getText()));
   
    }//GEN-LAST:event_addAirportButton1MouseClicked

    private void editOfferPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editOfferPanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_editOfferPanelMouseClicked

    private void editOfferButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editOfferButtonMouseExited
        changecolor(editOfferPanel, new Color(44,159,186));
    }//GEN-LAST:event_editOfferButtonMouseExited

    private void editOfferButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editOfferButtonMouseEntered
        changecolor(editOfferPanel, new Color(204,204,204));
    }//GEN-LAST:event_editOfferButtonMouseEntered

    private void dateToText2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateToText2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateToText2ActionPerformed

    private void AdditionalserviceidText2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdditionalserviceidText2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdditionalserviceidText2ActionPerformed

    private void airportNameList2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airportNameList2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_airportNameList2ActionPerformed

    private void editOfferButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editOfferButtonMouseClicked
        //ToEditOffer
      
           ToEditOffer.setdescription(offerDescriptionTextArea1.getText());
           ToEditOffer.setDate_to(dateToText2.getText());
           ToEditOffer.setDate_from(dateFromText2.getText());
           ToEditOffer.setclassd(AirportClass.get(airportNameList2.getSelectedIndex()));
           ToEditOffer.sethname(hotelsNames.get(hotelNameList2.getSelectedIndex()));
           ToEditOffer.setroom_type(hotelsRoomsTypes.get(hotelNameList2.getSelectedIndex()));
          ToEditOffer.setAname(AirportNames.get(airportNameList2.getSelectedIndex()));
          ToEditOffer.setfrom_des(FromText2.getText());
            ToEditOffer.setto_des(DestinationText2.getText());
           //MangerFuctions.AddNewOffer(newOffer);
          ToEditOffer.generateImg();
         MangerFuctions.UpdateOffer( ToEditOffer);
         displayOffers();
    
    }//GEN-LAST:event_editOfferButtonMouseClicked


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           try {
            File f=null;
            final JFileChooser fc = new JFileChooser();
            JFileChooser  f1=new JFileChooser ();
            f1.showOpenDialog(this.getContentPane());
            f= f1.getSelectedFile();
            jLabel115.setIcon(new javax.swing.ImageIcon(f.getAbsolutePath()));
            ToEditOffer.setImageFile(f);

        } catch (Exception ex) {
            Logger.getLogger(manager_page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(manager_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manager_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manager_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manager_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manager_page().setVisible(true);
                
            }
        });
    }
    /*
         try {
         newOffer=new Offer();
         airportNameList.removeAllItems();
        hotelNameList.removeAllItems();
         AirportClass.removeAllElements();
          AirportNames.removeAllElements();
          hotelsNames.removeAllElements();
          hotelsRoomsTypes.removeAllElements();
      
         ResultSet airports=MangerFuctions.getAirInfo(0);
         ResultSet hotels=MangerFuctions.getHotelInfo(0);
         while(airports.next()){
        airportNameList.addItem(airports.getString(1)+" , class:"+Integer.toString(airports.getInt(5)));
        AirportNames.add(airports.getString(1));
        AirportClass.add(Integer.toString(airports.getInt(5)));
        
         }
         while(hotels.next()){
             hotelNameList.addItem(hotels.getString(1)+" , room:"+hotels.getString(6));
            hotelsNames.add(hotels.getString(1));
            hotelsRoomsTypes.add(hotels.getString(6));
             
         }
         
          
         jFrame1.setVisible(true);
         addHotelFrame.setVisible(false);
         addAirportFrame.setVisible(false);
         jFrame1.setLocationRelativeTo(null);
     } catch (SQLException ex) {
         Logger.getLogger(manager_page.class.getName()).log(Level.SEVERE, null, ex);
     }*/
    public  void initEditPage(Offer toEditOffer){
        ToEditOffer=toEditOffer;
     try {
         //********************************************************************************************************************
         FromText2.setText(toEditOffer.from_des);
         DestinationText2.setText(toEditOffer.to_des);
         dateFromText2.setText(toEditOffer.Date_from);
         dateToText2.setText(toEditOffer.Date_to);
         offerDescriptionTextArea1.setText(toEditOffer.descrption);
         jLabel115.setIcon(new javax.swing.ImageIcon(toEditOffer.Img));
         airportNameList2.removeAllItems();
         hotelNameList2.removeAllItems();
         AirportClass.removeAllElements();
         AirportNames.removeAllElements();
         hotelsNames.removeAllElements();
         hotelsRoomsTypes.removeAllElements();
         
         ResultSet airports=MangerFuctions.getAirInfo(0);
         ResultSet hotels=MangerFuctions.getHotelInfo(0);
         while(airports.next()){
             airportNameList2.addItem(airports.getString(1)+" , class:"+Integer.toString(airports.getInt(5)));
             AirportNames.add(airports.getString(1));
             AirportClass.add(Integer.toString(airports.getInt(5)));
             
         }
         airportNameList2.setSelectedItem(toEditOffer.Aname+" , class:"+toEditOffer.classd);
         while(hotels.next()){
             hotelNameList2.addItem(hotels.getString(1)+" , room:"+hotels.getString(6));
             
             hotelsNames.add(hotels.getString(1));
             hotelsRoomsTypes.add(hotels.getString(6));
             
         }
         hotelNameList2.setSelectedItem(toEditOffer.hname+" , room:"+toEditOffer.room_type);
     } catch (SQLException ex) {
         Logger.getLogger(manager_page.class.getName()).log(Level.SEVERE, null, ex);
     }
         
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AdditionalserviceidText;
    private javax.swing.JTextField AdditionalserviceidText2;
    private javax.swing.JTextField DestinationText;
    private javax.swing.JTextField DestinationText2;
    private javax.swing.JTextField FromText;
    private javax.swing.JTextField FromText2;
    private javax.swing.JLabel IconMenu;
    private javax.swing.JTextField SSQ1Text;
    private javax.swing.JTextField SSQ2Text;
    private javax.swing.JLabel ShowProfileButton;
    private javax.swing.JLabel addAirportButton;
    private javax.swing.JLabel addAirportButton1;
    private javax.swing.JFrame addAirportFrame;
    private javax.swing.JPanel addAirportPanel;
    private javax.swing.JPanel addAirportPanel1;
    private javax.swing.JLabel addButton;
    private javax.swing.JLabel addHotelButon;
    private javax.swing.JLabel addHotelButton;
    private javax.swing.JFrame addHotelFrame;
    private javax.swing.JPanel addHotelPanel;
    private javax.swing.JPanel addHotelPanel1;
    private javax.swing.JLabel addOfferButton;
    private javax.swing.JPanel addOfferPanel;
    private javax.swing.JButton addOfferUploadImage;
    private javax.swing.JPanel addofferPanel;
    private javax.swing.JTextField airportAddressText;
    private javax.swing.JComboBox<String> airportNameList;
    private javax.swing.JComboBox<String> airportNameList2;
    private javax.swing.JTextField airportNameText;
    private javax.swing.JLabel close;
    private javax.swing.JLabel close1;
    private javax.swing.JLabel close2;
    private javax.swing.JLabel close3;
    private javax.swing.JPanel closeButton;
    private javax.swing.JLabel closeIcon;
    private javax.swing.JPanel closePanel;
    private javax.swing.JPanel closePanel1;
    private javax.swing.JPanel closePanel2;
    private javax.swing.JPanel closePanel3;
    private javax.swing.JFormattedTextField dateFromText;
    private javax.swing.JFormattedTextField dateFromText2;
    private javax.swing.JFormattedTextField dateToText;
    private javax.swing.JFormattedTextField dateToText2;
    private javax.swing.JFrame editOffer;
    private javax.swing.JLabel editOfferButton;
    private javax.swing.JPanel editOfferPanel;
    private javax.swing.JPanel header;
    private javax.swing.JPanel headerForMain;
    private javax.swing.JTextField hotelAdderssText;
    private javax.swing.JComboBox<String> hotelNameList;
    private javax.swing.JComboBox<String> hotelNameList2;
    private javax.swing.JTextField hotelNameText;
    private javax.swing.JTextField hotelPriceText;
    private javax.swing.JButton jButton1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel151;
    private javax.swing.JPanel jPanel152;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel linemenu;
    private javax.swing.JPanel main;
    private javax.swing.JPanel masseges;
    private javax.swing.JPanel massegesAndButtons;
    private javax.swing.JPanel maxButton;
    private javax.swing.JLabel maxIcone;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel menuHide;
    private javax.swing.JPanel menuIcon;
    private javax.swing.JPanel menuback;
    private javax.swing.JPanel minButton;
    private javax.swing.JLabel minIcon;
    private javax.swing.JPanel minMaxCloseIcon;
    private javax.swing.JTextArea offerDescriptionTextArea;
    private javax.swing.JTextArea offerDescriptionTextArea1;
    private javax.swing.JPanel offerGroup2;
    private javax.swing.JPanel offerGroup3;
    private javax.swing.JPanel offersPanel;
    private javax.swing.JPanel phrase;
    private javax.swing.JPanel prfileInfo;
    private javax.swing.JLabel profilePicIcon;
    private javax.swing.JPanel profilePicpanel;
    private javax.swing.JPanel profilepiclayout;
    private javax.swing.JTextField roomTypeText;
    private javax.swing.JComboBox<String> searchAbout;
    private javax.swing.JPanel searchLayout;
    private javax.swing.JPanel searchPosition;
    private javax.swing.JTextField searchText;
    private javax.swing.JPanel showProfileAndAddOffer;
    private javax.swing.JPanel showProfilePanel;
    private javax.swing.JTextField starsText;
    private javax.swing.JPanel submitSearch;
    private javax.swing.JTextField ticketClassText;
    private javax.swing.JTextField ticketPriceText;
    private javax.swing.JLabel userName;
    // End of variables declaration//GEN-END:variables

    
}
