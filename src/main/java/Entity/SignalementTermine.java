package Entity;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;

public class SignalementTermine {
    /*id int primary key not null AUTO_INCREMENT,
     idSignV int,
     dateS DATETIME,
     budget float, */

    int id;
    int idSignV;
    Timestamp dateS;
    double budget;

    public int getId(){
        return this.id;
    }
    public void setId(int i){
        this.id=i;
    }
    public int getIdSignV(){
        return this.id;
    }
    public void setIdSignV(int i){
        this.idSignV=i;
    }
    public Timestamp getDateS(){
        return this.dateS;
    }
    public void setDateS(Timestamp d){
        this.dateS=d;
    }
    public double getBudget(){
        return this.budget;
    }
    public void setBudget(double k){
        this.budget=k;
    }

    public SignalementTermine(int i,int ii,Timestamp d,double b){
        this.id=i;
        this.idSignV=ii;
        this.dateS=d;
        this.budget=b;
    }
    public SignalementTermine(){
        
    }
    public void insert()
    {
       String req="INSERT INTO SignalementTermine(idSignV,dateS,budget) VALUES("+this.idSignV+",now(),"+this.budget+")";
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
