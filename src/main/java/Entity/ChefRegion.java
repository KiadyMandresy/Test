package Entity;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.Statement;

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
    public void delete ()
    {
        String req="delete from ChefRegion where id="+this.id;
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
    public void update()
    {
        String req="update ChefRegion set nom='"+this.nom+"',mdp='"+this.mdp+"',mail='"+this.mail+"',idReg="+this.idReg+" where id="+this.id;
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
    public List<ChefRegion> select(String req)
    {
        List<ChefRegion> liste=new ArrayList<>();
        try
        {
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                ChefRegion reg=new ChefRegion(res.getInt("id"),res.getString("nom"),res.getString("mdp"),res.getString("mail"),res.getInt("idReg"));
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
    public ChefRegion(){
        
    }
    public void insert()
    {
        String req="INSERT INTO ChefRegion(nom,mdp,mail,idReg) VALUES('"+this.nom+"','"+this.mdp+"','"+this.mail+"',"+this.idReg+")";
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