package Entity;

import java.sql.Timestamp;

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
}
