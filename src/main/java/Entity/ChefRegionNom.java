package Entity;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.Statement;
public class ChefRegionNom {
    int id;
    String nom;
    String mdp;
    String mail;
    int idReg;
    String region;
    
    public void setRegion(String r)
    {
        region=r;
    }
    public String getRegion()
    {
        return region;
    }
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
    public ChefRegionNom(int i,String n,String m,String ma,int ii,String reg){
        this.id=i;
        this.nom=n;
        this.mdp=m;
        this.mail=ma;
        this.idReg=ii;
        this.region=reg;
    }
    public List<ChefRegionNom> select(String req)
    {
        List<ChefRegionNom> liste=new ArrayList<>();
        try
        {
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                ChefRegionNom reg=new ChefRegionNom(res.getInt("id"),res.getString("nom"),res.getString("mdp"),res.getString("mail"),res.getInt("idReg"),res.getString("region"));
                liste.add(reg);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return liste;
    }
    public ChefRegionNom(){
        
    }
}
