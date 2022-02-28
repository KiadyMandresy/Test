package Entity;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.Statement;

public class Notification {
    
    int id;
    int idSignTermine;
    int statut;

    public int getId(){
        return this.id;
    }
    public void setId(int i){
        this.id=i;
    }
    public int getIdSignTermine(){
        return this.id;
    }
    public void setIdSignTermine(int i){
        this.idSignTermine=i;
    }
    public int getStatut(){
        return this.statut;
    }
    public void setStatut(int i){
        this.statut=i;
    }
    public Notification(int i,int ii,int s){
        this.id=i;
        this.idSignTermine=ii;
        this.statut=s;
    }
    public Notification()
    {
        
    }
    public List<Notification> select(String req)
    {
        List<Notification> liste=new ArrayList<>();
        try
        {
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                Notification reg=new Notification(res.getInt("id"),res.getInt("idSignTermine"),res.getInt("statut"));
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

    public void delete(String id)
    {
        String req="delete from notification where id="+id;
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
