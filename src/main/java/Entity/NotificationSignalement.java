package Entity;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.Statement;

import java.sql.Timestamp;

public class NotificationSignalement {
    Timestamp dateDebut;
    Timestamp dateFin;
    int idNotification;
    int idSignalement;
    int statut;

    public int getStatut(){
        return statut;
    }
    public void setStatut(int s){
        this.statut=s;
    }
   public Timestamp getDateDebut() {
       return dateDebut;
   }
   public void setDateDebut(Timestamp dateDebut) {
       this.dateDebut = dateDebut;
   }

   public Timestamp getDateFin() {
       return dateFin;
   }
   public void setDateFin(Timestamp dateFin) {
       this.dateFin = dateFin;
   }

   public int getIdNotification() {
       return idNotification;
   }
   public void setIdNotification(int idNotification) {
       this.idNotification = idNotification;
   }

   public int getIdSignalement() {
       return idSignalement;
   }
   public void setIdSignalement(int idSignalement) {
       this.idSignalement = idSignalement;
   }

   public NotificationSignalement(){

   }
   public NotificationSignalement(Timestamp datedeb,Timestamp datefin,int idNotif, int idSigb,int s){
       this.dateDebut = datedeb;
       this.dateFin = datefin;
       this.idNotification = idNotif;
       this.idSignalement = idSigb;
       this.statut=s; 
}

   public List<NotificationSignalement> select(String req)
    {
        List<NotificationSignalement> liste=new ArrayList<>();
        try
        {
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                NotificationSignalement reg = new NotificationSignalement (res.getTimestamp("dateDebut"),res.getTimestamp("dateFin"),res.getInt("idNotification"),res.getInt("idSignTermine"),res.getInt("statut"));
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

    
}
