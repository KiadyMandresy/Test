package Service;
import Entity.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.*;

public class SignalementService {
    
    public SignalementService(){

    }
    public int countPhotoSignalement(int id)
    {
        int i=0;
        ConnectionBD co=new ConnectionBD();
        try
        {
            Connection con=co.getConnection();
            String req="select count(id) as nb from detailSignalement where idSign="+id;
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                i=res.getInt("nb");
            }
            con.close();
        }
        catch(Exception e)
        {

        }
        return i;
    }
    public String getPhoto(int nb,int id)
    {
        nb=nb-1;
        String req="select * from detailSignalement where idSign="+id+" order by id  asc limit 1 offset "+nb;
        DetailSignalement dt=new DetailSignalement();
        List<DetailSignalement> list=dt.select(req);
        String photo=list.get(0).getPhotos();
        return photo;
    }
    public SignalementGlobal getFicheSignalementNonValide(int id)
    {
        String req="select s.id,s.commentaire,s.dateS,s.x,s.y,st.nom,dt.photos,u.nom as Personne from Signalement as s join TypeSignalement as st on st.id=s.idType join DetailSignalement as dt on dt.idSign=s.id join Utilisateur as u on u.id=s.idUtilisateur where s.id="+id;
        SignalementGlobal sign=new SignalementGlobal();
        List<SignalementGlobal> liste=sign.select(req);
        return liste.get(0);
    }
    public List<SignalementGlobal> getSignalementGlobal(int indice){
        int rep1,rep2;
        rep1=((indice-1)*3);
        rep2=indice*3;
        List<SignalementGlobal> rep=new ArrayList<>();
        ConnectionBD con=new ConnectionBD();
        String req2=" limit 3 offset "+rep1;
        String req3=" where s.id not in (select idSign from SignalementCorbeille)";
        String req1="select s.id,s.commentaire,s.dateS,s.x,s.y,st.nom,dt.photos,u.nom as Personne from Signalement as s join TypeSignalement as st on st.id=s.idType join DetailSignalement as dt on dt.idSign=s.id join Utilisateur as u on u.id=s.idUtilisateur";
        System.out.println(req1+req3+req2);
        try{
            PreparedStatement st=con.getConnection().prepareStatement(req1+req3+req2);
            ResultSet res=st.executeQuery();
            while(res.next()){
                int id=res.getInt("id");
                String com=res.getString("commentaire");
                Date d=res.getDate("dateS");
                Timestamp date=new Timestamp(d.getTime());
                double x=res.getDouble("x");
                double y=res.getDouble("y");
                String n=res.getString("nom");
                String photos=res.getString("photos");
                String idu=res.getString("Personne");
                SignalementGlobal sing=new SignalementGlobal(id,com,date,x,y,n,photos,idu);
                rep.add(sing);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }

    public int getCountSignalement(){
        int va=0;
        List<SignalementGlobal> rep=new ArrayList<>();
        ConnectionBD con=new ConnectionBD();
        String req2=" where s.id not in (select idSign from SignalementCorbeille)";
        String req1="select s.id,s.commentaire,s.dateS,s.x,s.y,st.nom,dt.photos,u.nom as Personne from Signalement as s join TypeSignalement as st on st.id=s.idType join DetailSignalement as dt on dt.idSign=s.id join Utilisateur as u on u.id=s.idUtilisateur";
        try{
            PreparedStatement st=con.getConnection().prepareStatement(req1+req2);
            ResultSet res=st.executeQuery();
            while(res.next()){
                int id=res.getInt("id");
                String com=res.getString("commentaire");
                Date d=res.getDate("dateS");
                Timestamp date=new Timestamp(d.getTime());
                double x=res.getDouble("x");
                double y=res.getDouble("y");
                String n=res.getString("nom");
                String photos=res.getString("photos");
                String idu=res.getString("Personne");
                SignalementGlobal sing=new SignalementGlobal(id,com,date,x,y,n,photos,idu);
                rep.add(sing);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        va=rep.size();
        return va;
    }

    public List<SignalementGlobal> getSignalementGlobalRecherche(String d1,String d2){
        int rep1,rep2;
        List<SignalementGlobal> rep=new ArrayList<>();
        ConnectionBD con=new ConnectionBD();
        String req3=" where s.id not in (select idSign from SignalementCorbeille) and s.dateS>'"+d1+"' and s.dateS<'"+d2+"'";
        String req1="select s.id,s.commentaire,s.dateS,s.x,s.y,st.nom,dt.photos,u.nom as Personne from Signalement as s join TypeSignalement as st on st.id=s.idType join DetailSignalement as dt on dt.idSign=s.id join Utilisateur as u on u.id=s.idUtilisateur";
        System.out.println(req1+req3);
        try{
            PreparedStatement st=con.getConnection().prepareStatement(req1+req3);
            ResultSet res=st.executeQuery();
            while(res.next()){
                int id=res.getInt("id");
                String com=res.getString("commentaire");
                Date d=res.getDate("dateS");
                Timestamp date=new Timestamp(d.getTime());
                double x=res.getDouble("x");
                double y=res.getDouble("y");
                String n=res.getString("nom");
                String photos=res.getString("photos");
                String idu=res.getString("Personne");
                SignalementGlobal sing=new SignalementGlobal(id,com,date,x,y,n,photos,idu);
                rep.add(sing);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }

    public int countSingalement(String d1,String d2){
        int va=0;
        List<SignalementGlobal> rep=new ArrayList<>();
        ConnectionBD con=new ConnectionBD();
        String req2=" where s.id not in (select idSign from SignalementCorbeille) and s.dateS>'"+d1+"' and s.dateS<'"+d2+"'";
        String req1="select s.id,s.commentaire,s.dateS,s.x,s.y,st.nom,dt.photos,u.nom as Personne from Signalement as s join TypeSignalement as st on st.id=s.idType join DetailSignalement as dt on dt.idSign=s.id join Utilisateur as u on u.id=s.idUtilisateur";
        try{
            PreparedStatement st=con.getConnection().prepareStatement(req1+req2);
            ResultSet res=st.executeQuery();
            while(res.next()){
                int id=res.getInt("id");
                String com=res.getString("commentaire");
                Date d=res.getDate("dateS");
                Timestamp date=new Timestamp(d.getTime());
                double x=res.getDouble("x");
                double y=res.getDouble("y");
                String n=res.getString("nom");
                String photos=res.getString("photos");
                String idu=res.getString("Personne");
                SignalementGlobal sing=new SignalementGlobal(id,com,date,x,y,n,photos,idu);
                rep.add(sing);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        va=rep.size();
        return va;
    }

}
