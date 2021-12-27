package Service;
import Entity.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class SignalementService {
    
    public SignalementService(){

    }

    public List<SignalementGlobal> getSignalementGlobal(){
        List<SignalementGlobal> rep=new ArrayList<>();
        ConnectionBD con=new ConnectionBD();
        String req="select s.id,s.commentaire,s.dateS,s.x,s.y,st.nom,dt.photos,u.nom as Personne from Signalement as s join TypeSignalement as st on st.id=s.idType join DetailSignalement as dt on dt.idSign=s.id join Utilisateur as u on u.id=s.idUtilisateur";
        try{
            PreparedStatement st=con.getConnection().prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next()){
                int id=res.getInt("id");
                String com=res.getString("commentaire");
                Timestamp date=res.getTimestamp("dateS");
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

}
