package Entity;

import java.sql.Timestamp;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Signalement {
    /*id int primary key not null AUTO_INCREMENT,
     idType int,
     commentaire text,
     dateS DATETIME,
     x float,
     y float, */
    
    int id;
    int idType;
    String commentaire;
    Timestamp dateS;
    double x;
    double y;
    String idUtilisateur;

    public int getId(){
        return this.id;
    }
    public void setId(int i){
        this.id=i;
    }
    public int getIdType(){
        return this.idType;
    }
    public void setIdType(int i){
        this.idType=i;
    }
    public String getCommentaire(){
        return commentaire;
    }
    public void setCommentaire(String c){
        this.commentaire=c;
    }
    public Timestamp getDateS(){
        return this.dateS;
    }
    public void setDateS(Timestamp d){
        this.dateS=d;
    }
    public double getX(){
        return this.x;
    }
    public void setX(double k){
        this.x=k;
    }
    public double getY(){
        return this.y;
    }
    public void setY(double k){
        this.y=k;
    }
    public String getIdUtilisateur() {
        return idUtilisateur;
    }
    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Signalement(int i,int ii,String c,Timestamp d,double xx,double yy,String iii){
        this.id=i;
        this.idType=ii;
        this.commentaire=c;
        this.dateS=d;
        this.x=xx;
        this.y=yy;
        this.idUtilisateur=iii;
        
    }
    public void insert() 
    {
        String req="INSERT INTO Signalement(idtype,commentaire,dateS,x,y,idUtilisateur) VALUES("+this.idType+",'"+this.commentaire+"',now(),"+this.x+","+this.y+","+this.idUtilisateur+")";
        try{
            System.out.println(req);
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            Statement st=con.createStatement();
            st.executeUpdate(req);
            con.commit();
            con.close();
            
        }
        catch(Exception e)
        {

        }
    }
    public List<Signalement> select(String req)
    {
        List<Signalement> liste=new ArrayList<>();
        try
        {
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                Integer ut=res.getInt("idUtilisateur");
                Signalement reg=new Signalement(res.getInt("id"),res.getInt("idType"),res.getString("commentaire"),res.getTimestamp("dateS"),res.getDouble("x"),res.getDouble("y"),ut.toString());
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
    
    public Signalement(){

    }
}
