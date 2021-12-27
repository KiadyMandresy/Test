package Entity;

public class Utilisateur {
    /* id int primary key not null AUTO_INCREMENT,
     nom varchar(50),
    mdp varchar(255),
    mail varchar(100) */

    int id;
    String nom;
    String mdp;
    String mail;

    public int getId(){
        return this.id;
    }
    public void setId(int i){
        this.id=i;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String n){
        this.nom=n;
    }
    public String getMdp(){
        return this.mdp;
    }
    public void setMdp(String m){
        this.mdp=m;
    }
    public String getMail(){
        return this.mail;
    }
    public void setMail(String m){
        this.mail=m;
    }
    public Utilisateur(int i,String n,String m,String ma){
        this.id=i;
        this.nom=n;
        this.mdp=m;
        this.mail=ma;
    }
    public Utilisateur(){
        
    }
}
