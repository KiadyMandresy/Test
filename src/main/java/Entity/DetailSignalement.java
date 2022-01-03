package Entity;
import java.sql.Timestamp;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DetailSignalement {
    /*id int primary key not null AUTO_INCREMENT,
     idSign int,
     photos varchar(255),
     */

    int id;
    int idSign;
    String photos;

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
    public String getPhotos(){
        return photos;
    }
    public void setPhotos(String p){
        this.photos=p;
    }

    public DetailSignalement(int i,int ii,String p){
        this.id=i;
        this.idSign=ii;
        this.photos=p;
    }
    public List<DetailSignalement> select(String req)
    {
        List<DetailSignalement> liste=new ArrayList<>();
        try
        {
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                DetailSignalement reg=new DetailSignalement(res.getInt("id"),res.getInt("idSign"),res.getString("photos"));
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
    public DetailSignalement(){
        
    }

}
