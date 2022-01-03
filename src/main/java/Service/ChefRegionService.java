package Service;
import Entity.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
public class ChefRegionService extends ChefRegion {
    
    public ChefRegionService(){

    }
    public void delete(String id)
    {
        Integer idd=new Integer(id);
        setId(idd.intValue());
        delete();
    }
    public int paginationChefRegion()
    {
        
        int n=0;
        String req="select count(id) as nb from chefRegion";
        try
        {
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                n=res.getInt("nb");
            }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        n=n/5;
        if(n%5!=0)
        {
            n=n+1;
        }
        return n;
    }
    public List<ChefRegionNom> getListeChef(String lim)
    {
        Integer lim1=new Integer(lim);
        lim1=(lim1-1)*5;
        ChefRegionNom chef=new ChefRegionNom();
        String req="select c.id,c.idReg,c.nom,c.mdp,c.mail,r.nom as region from chefRegion c join region r on r.id=c.idReg limit 5 offset "+lim1.toString();
        return chef.select(req);
    }
    public void updateChef(String id,String nom,String mdp,String mail,String idR)
    {
        Integer i=new Integer(id);
        Integer rg=new Integer(idR);
        ChefRegion chef=new ChefRegion(i.intValue(),nom,mdp,mail,rg.intValue());
        chef.update();
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
            con.close();
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
