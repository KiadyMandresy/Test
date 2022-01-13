package Entity;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
public class SignalementGlobal {
    
    int id;
    String commentaire;
    Timestamp dateS;
    double x;
    double y;
    String nom;
    String photos;
    String idUtilisateur;
    public String getType()
    {
        return nom;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCommentaire() {
        return commentaire;
    }
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    public Timestamp getDateS() {
        return dateS;
    }
    public void setDateS(Timestamp dateS) {
        this.dateS = dateS;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPhotos() {
        return photos;
    }
    public void setPhotos(String photos) {
        this.photos = photos;
    }
    public String getIdUtilisateur() {
        return idUtilisateur;
    }
    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
    public SignalementGlobal(int i,String c,Timestamp d,double x,double y,String n,String p,String iii){
        this.id=i;
        this.commentaire=c;
        this.dateS=d;
        this.x=x;
        this.y=y;
        this.nom=n;
        this.photos=p;
        this.idUtilisateur=iii;
        //
    }
    public List<SignalementGlobal> select(String req)
    {
        List<SignalementGlobal> liste=new ArrayList<>();
        try
        {
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                SignalementGlobal reg=new SignalementGlobal(res.getInt("id"),res.getString("commentaire"),res.getTimestamp("dateS"),res.getDouble("x"),res.getDouble("y"),res.getString("nom"),res.getString("photos"),res.getString("personne"));
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
    public SignalementGlobal(){

    }
}
