package Entity;

import java.sql.Connection;
import java.sql.Statement;

import net.bytebuddy.agent.builder.AgentBuilder.RawMatcher.Conjunction;

public class ChefRegion{
    int id;
    String nom;
    String mdp;
    String mail;
    int idReg;

    public int getId(){
        return this.id;
    }
    public void setId(int i){
        this.id=i;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String n){
        this.nom=n;
    }
    public String getMdp(){
        return this.mdp;
    }
    public void setMdp(String m){
        this.mdp=m;
    }
    public String getMail(){
        return this.mail;
    }
    public void setMail(String m){
        this.mail=m;
    }
    public int getIdReg(){
        return this.idReg;
    }
    public void setIdReg(int i){
        this.idReg=i;
    }
    public ChefRegion(int i,String n,String m,String ma,int ii){
        this.id=i;
        this.nom=n;
        this.mdp=m;
        this.mail=ma;
        this.idReg=ii;
    }
    public ChefRegion(){
        
    }
    public void insert()
    {
        String req="INSERT INTO ChefRegion VALUES(null,'"+this.nom+"','"+this.mdp+"','"+this.mail+"',"+this.idReg+")";
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