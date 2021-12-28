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

    public List<SignalementGlobal> getSignalementGlobal(int indice){
        int rep1,rep2;
        rep1=((indice-1)*3)+1;
        rep2=indice*3;
        List<SignalementGlobal> rep=new ArrayList<>();
        ConnectionBD con=new ConnectionBD();
        String req2=" limit "+rep1+",3";
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
        return rep;
    }

    public int getCountSignalement(){
        int va=0;
        List<SignalementGlobal> rep=new ArrayList<>();
        ConnectionBD con=new ConnectionBD();
        String req1="select s.id,s.commentaire,s.dateS,s.x,s.y,st.nom,dt.photos,u.nom as Personne from Signalement as s join TypeSignalement as st on st.id=s.idType join DetailSignalement as dt on dt.idSign=s.id join Utilisateur as u on u.id=s.idUtilisateur";
        try{
            PreparedStatement st=con.getConnection().prepareStatement(req1);
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
