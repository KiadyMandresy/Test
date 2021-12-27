package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return liste;
    }
    public Region(){
        
    }
}
