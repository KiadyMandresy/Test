package Entity;
import java.sql.Timestamp;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.Statement;

    
public class Utilisateur {
    /* id int primary key not null AUTO_INCREMENT,
     nom varchar(50),
    mdp varchar(255),
    mail varchar(100) */

    int id;
    String nom;
    String mdp;
    String mail;

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
    public Utilisateur(int i,String n,String m,String ma){
        this.id=i;
        this.nom=n;
        this.mdp=m;
        this.mail=ma;
    }
    public Utilisateur(){
        
    }
    public void update(){
        String req = "update utilisateur set nom='"+this.nom+"',mdp='"+this.mdp+"',mail='"+this.mail+"' where id="+this.id;
        try{
            System.out.println(req);
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            Statement st=con.createStatement();
            st.executeUpdate(req);
            con.setAutoCommit(false);
            con.commit();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
     }
     public void insert(){
        String req = "insert into utilisateur(nom,mdp,mail) values('"+this.getNom()+"','"+this.getMdp()+"','"+this.getMail()+"')";
        try{
            System.out.println(req);
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            Statement st=con.createStatement();
            st.executeUpdate(req);
            con.setAutoCommit(false);
            con.commit();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
     }
     public List<Utilisateur> select(String req)
     {
         List<Utilisateur> liste=new ArrayList<>();
         try
         {
             ConnectionBD co=new ConnectionBD();
             Connection con=co.getConnection();
             PreparedStatement st=con.prepareStatement(req);
             ResultSet res=st.executeQuery();
             while(res.next())
             {
                 Utilisateur reg=new Utilisateur(res.getInt("id"),res.getString("nom"),res.getString("mdp"),res.getString("mail"));
                 liste.add(reg);
             }
             con.close();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         return liste;
     }
}     
