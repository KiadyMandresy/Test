package Entity;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
public class SignalementValideView {
    int id;
    String commentaire;
    Timestamp dateS;
    double x;
    double y;
    String nom;
    String photos;
    String idUtilisateur;
    String region;
    Timestamp termine;
    double budget;
    public void setBudget(double budget) {
        this.budget = budget;
    }
    public void setTermine(Timestamp termine) {
        this.termine = termine;
    }
    public double getBudget() {
        return budget;
    }
    public Timestamp getTermine() {
        return termine;
    }
    public void setRegion(String r)
    {
        region=r;
    }
    public String getRegion()
    {
        return region;
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
    public SignalementValideView(int i,String c,Timestamp d,double x,double y,String n,String p,String iii,String r){
        this.id=i;
        this.commentaire=c;
        this.dateS=d;
        this.x=x;
        this.y=y;
        this.nom=n;
        this.photos=p;
        this.idUtilisateur=iii;
        this.region=r;
        //
    }
    public SignalementValideView(int i,String c,Timestamp d,double x,double y,String n,String p,String iii,String r,Timestamp ter,double b){
        this.id=i;
        this.commentaire=c;
        this.dateS=d;
        this.x=x;
        this.y=y;
        this.nom=n;
        this.photos=p;
        this.idUtilisateur=iii;
        this.region=r;
        termine=ter;
        this.budget=b;
        //
    }
    public List<SignalementValideView> select(String req)
    {
        List<SignalementValideView> liste=new ArrayList<>();
        try
        {
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                SignalementValideView reg=new SignalementValideView(res.getInt("id"),res.getString("commentaire"),res.getTimestamp("dateS"),res.getDouble("x"),res.getDouble("y"),res.getString("nom"),res.getString("photos"),res.getString("personne"),res.getString("region"));
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
    public SignalementValideView(){

    }
}
