package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.*;
import java.security.Timestamp;
import java.sql.Statement;

public class Region {
    /*id int primary key not null AUTO_INCREMENT,
     nom varchar(50) */
    
    int id;
    String nom;

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
    
    public Region(int i,String n){
        this.id=i;
        this.nom=n;
    }
    public List<Region> select(String req)
    {
        List<Region> liste=new ArrayList<>();
        try
        {
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                Region reg=new Region(res.getInt("id"),res.getString("nom"));
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
    public Region(){
        
    }

    public void updateRegion(){
        String req="update Region set nom='"+this.nom+"' where id="+this.id;
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

    public void delete (int id)
    {
        String req="delete from Region where id="+id;
        try{
            ConnectionBD co=new ConnectionBD();
            System.out.println(req);
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

    public void insert()
    {
        String req="INSERT INTO Region(nom) VALUES('"+this.nom+"')";
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

    public List<SignalementRegion> getSignReg(String nom,int indice){
        int rep1,rep2;
        rep1=((indice-1)*3);
        rep2=indice*3;
        List<SignalementRegion> rep=new ArrayList<>();
        /** */
        String req="select s.id,s.commentaire,s.dates,s.x,s.y,u.nom as utilisateur,u.mail,r.nom from SignalementValide as sv join Signalement as s on sv.idSign=s.id join Region as r on r.id=sv.idReg join Utilisateur as u on u.id=s.idUtilisateur";
        String req1=" where r.nom='"+nom+"' limit 3 offset "+rep1;
        try{
            System.out.println(req+req1);
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req+req1);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                SignalementRegion reg=new SignalementRegion(res.getInt("id"),res.getString("commentaire"),res.getTimestamp("dateS"), res.getDouble("x"),res.getDouble("y"),res.getString("utilisateur"),res.getString("mail"), res.getString("nom"));
                rep.add(reg);
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }

    
    
}
