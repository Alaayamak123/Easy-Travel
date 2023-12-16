/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager_ui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author EASY LIFE
 */
public class Offer {
int OSQ=0;
double price;
String descrption;
String Date_to;
String Date_from;
String to_des;
String from_des;
String Img="C:\\travelingImages\\offer.png";
String Aname;
String classd;
String hname;
String room_type;
File ImgFile=new File("C:\\travelingImages\\offer.png");
public Offer(int OSQ,String descrption,String Date_to,String Date_from,String to_des,String from_des, String Img,String Aname,String classd,String hname,String room_type){
this.OSQ=OSQ;
this.descrption=descrption;
this.Date_to=Date_to;
this.Date_from=Date_from;
this.to_des=to_des;
this.from_des=from_des;
this. Img= Img;
this.room_type=room_type;
this.hname=hname;
this.classd=classd;
this.Aname=Aname;
}
public Offer(){}
public void setImageFile(File f){

ImgFile=f;
}

public void setOSQ(int OSQ){this.OSQ=OSQ;}
public void setdescription(String description){this.descrption=descrption;}
public void setDate_to(String Date_to){this.Date_to=Date_to.replace('/', '-');}
public void setDate_from(String Date_from){this.Date_from=Date_from.replace('/', '-');}
public void setroom_type(String room_type){this.room_type=room_type;}
public void sethname(String hname){this.hname=hname;}
public void setclassd(String classd){this.classd=classd;}
public void setAname(String Aname){this.Aname=Aname;}
public void setfrom_des(String from_des){this.from_des=from_des;}
public void setto_des(String to_des){this.to_des=to_des;}
//public void set(){}
public void generateImg(){
    try {
        InputStream is=null;
        is = new FileInputStream(ImgFile);
        BufferedImage bf = ImageIO.read(is);
        String fileName = ImgFile.toString();
        int index = fileName.lastIndexOf('.');
        String extension ="jpg";
        if(index > 0) {
            
            extension = fileName.substring(index + 1);  }
     
 
ImageIO.write(bf,extension ,new File("C:\\travelingImages\\"+OSQ+"."+extension));

Img="C:\\travelingImages\\"+OSQ+"."+extension;  
    } catch (Exception ex) {
        Logger.getLogger(Offer.class.getName()).log(Level.SEVERE, null, ex);
    }
        
}

public String toString(){
return this.OSQ+" "+this.from_des+" "+this.to_des+" "+this.Date_from+" "+this.Date_to+" "+this.classd+" "+this.hname+" "+this.room_type+" "+this.Aname+" "+this.Img;
}
}


