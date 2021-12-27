package Entity;

import java.sql.Timestamp;

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
    int idUtilisateur;

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
    public int getIdUtilisateur() {
        return idUtilisateur;
    }
    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Signalement(int i,int ii,String c,Timestamp d,double xx,double yy,int iii){
        this.id=i;
        this.idType=ii;
        this.commentaire=c;
        this.dateS=d;
        this.x=xx;
        this.y=yy;
        this.idUtilisateur=iii;
        //
    }
    
    public Signalement(){

    }
}
