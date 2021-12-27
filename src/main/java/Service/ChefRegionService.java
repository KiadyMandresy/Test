package Service;
import Entity.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
public class ChefRegionService {
    
    public ChefRegionService(){

    }
    public int idRegion(String nom) {
        int id=0;
        String req="select id from Region where nom='"+nom+"'";
        try
        {
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                id=res.getInt("id");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return id;
    }
    public void insertChefRegion(String nom,String mdp,String mail,String reg)
    {
        ChefRegion chef=new ChefRegion(0,nom,mdp,mail,idRegion(reg));
        chef.insert();
    }

}
