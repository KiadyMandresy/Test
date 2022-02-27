package Service;
import Entity.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
public class RegionService extends Region {
    public List<Region> getAll()
    {
        return select("select * from region");
    }

    public List<Region> getRegion(int indice){
        int rep1,rep2;
        rep1=((indice-1)*3);
        rep2=indice*3;
        List<Region> rep=new ArrayList<>();
        Region r=new Region();
        try{
            String req="select*from Region limit 3 offset "+rep1;
            System.out.println(req);
            rep=r.select(req);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rep;
    }

    public void updateRegion(String id,String nom){
        Integer i=new Integer(id);
        Region reg=new Region(i.intValue(),nom);
        reg.updateRegion();
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

    public void deleteRegion(String nom){
        int id=this.idRegion(nom);
        Region rr=new Region();
        Region r=new Region(id,nom);
        rr.delete(r.getId());
    }

    public int countRegion(){
        List<Region> rep=new ArrayList<>();
        Region r=new Region();
        try{
            String req="select*from Region";
            rep=r.select(req);
        }catch(Exception e){
            e.printStackTrace();
        }
        return rep.size();
    }

    public void insertRegion(String nom){
        Region reg=new Region(0,nom);
        reg.insert();
    }
    
    public List<SignalementRegion> getSignRegion(String nom,int ii){
        Region r=new Region();
        List<SignalementRegion> rep=r.getSignReg1(nom,ii);
        return rep;
    }

    public int countGetSignReg(String nom){
        int reps=0;
        List<SignalementRegion> rep=new ArrayList<>();
        /** */
        String req="select s.id,s.commentaire,s.dates,s.x,s.y,u.nom as utilisateur,u.mail,r.nom,ty.nom as TypeS from SignalementValide as sv join Signalement as s on sv.idSign=s.id join Region as r on r.id=sv.idReg join Utilisateur as u on u.id=s.idUtilisateur join TypeSignalement as ty on ty.id=s.idType";
        String req1=" where r.nom='"+nom+"'";
        try{
            System.out.println(req+req1);
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req+req1);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                SignalementRegion reg=new SignalementRegion(res.getInt("id"),res.getString("commentaire"),res.getTimestamp("dateS"), res.getDouble("x"),res.getDouble("y"),res.getString("utilisateur"),res.getString("mail"), res.getString("nom"),res.getString("typeS"));
                rep.add(reg);
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        reps=rep.size();
        return reps;
    }

}
