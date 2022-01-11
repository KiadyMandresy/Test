package Entity;

import java.sql.Timestamp;

public class SignalementRegion {
    
    int id;
    String commentaire;
    Timestamp dateS;
    double x;
    double y;
    String nom;
    String mail;
    String reg;

    public void setId(int id) {
        this.id = id;
    }
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    public void setDateS(Timestamp dateS) {
        this.dateS = dateS;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public void setReg(String reg) {
        this.reg = reg;
    }

    public int getId() {
        return id;
    }
    public String getCommentaire() {
        return commentaire;
    }
    public Timestamp getDateS() {
        return dateS;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public String getNom() {
        return nom;
    }
    public String getMail() {
        return mail;
    }
    public String getReg() {
        return reg;
    }

    public SignalementRegion(){

    }
    public SignalementRegion(int i,String c,Timestamp d,double xx,double yy,String n,String m,String re){
        this.id=i;
        this.commentaire=c;
        this.dateS=d;
        this.x=xx;
        this.y=yy;
        this.nom=n;
        this.mail=m;
        this.reg=re;
    }

}

