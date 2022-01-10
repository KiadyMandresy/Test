package Entity;

import java.sql.Timestamp;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.Statement;
public class SignalementCorbeille {
    
    /*id int primary key not null AUTO_INCREMENT,
     idSign int,
     dateS DATETIME, */

     int id;
     int idSign;
     Timestamp dateS;
 
     public int getId(){
         return id;
     }
     public void setId(int i){
         this.id=i;
     }
     public int getIdSign(){
         return this.idSign;
     }
     public void setIdSign(int i){
         this.idSign=i;
     }
     public Timestamp getDateS(){
         return dateS;
     }
     public void setPhotos(Timestamp p){
         this.dateS=p;
     }
 
     public SignalementCorbeille(int i,int ii,Timestamp p){
         this.id=i;
         this.idSign=ii;
         this.dateS=p;
     }
     public SignalementCorbeille(){
         
     }
     public void insert()
     {
        String req="INSERT INTO SignalementCorbeille(idsign,dateS) VALUES("+this.idSign+",now())";
        try{
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            Statement st=con.createStatement();
            st.executeUpdate(req);
            con.commit();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
     }
}
