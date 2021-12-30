package Entity;
import java.sql.Timestamp;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.Statement;
public class SignalementValide {
    /*id int primary key not null AUTO_INCREMENT,
     idSign int,
     idReg int, */
    
    int id;
    int idSign;
    int idReg;

    public int getId(){
        return this.id;
    }
    public void setId(int i){
        this.id=i;
    }
    public int getIdSign(){
        return this.idSign;
    }
    public void setIdSing(int i){
        this.idSign=i;
    }
    public int getIdReg(){
        return this.idReg;
    }
    public void setIdReg(int i){
        this.idReg=i;
    }
    public SignalementValide(int i,int ii,int iii){
        this.id=i;
        this.idSign=ii;
        this.idReg=iii;
    }
    public SignalementValide(){
        
    }
    public void insert()
    {
       String req="INSERT INTO SignalementValide(idSign,idReg) VALUES("+this.idSign+","+this.idReg+")";
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

       }
    }
}
