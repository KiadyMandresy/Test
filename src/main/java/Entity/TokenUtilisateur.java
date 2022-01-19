package Entity;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.*;
@Document(collection="tokenUtilisateur")
public class TokenUtilisateur {
    String idUtilisateur;
    
    String nom;
    
    String mail;
    
    String mdp;
   
    String token;

    Date dateExpire;

    public void setDateExpire(Date dateExpire) {
        this.dateExpire = dateExpire;
    }
    public Date getDateExpire() {
        return dateExpire;
    }

    public String getNom() {
        return nom;
    }
    public String getMail() {
        return mail;
    }
    public String getMdp() {
        return mdp;
    }
    public String getToken() {
        return token;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getIdUtilisateur() {
        return idUtilisateur;
    }
    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
    public TokenUtilisateur(String i,String n,String m,String md,String t,Date d)
    {
        this.idUtilisateur=i;
        this.nom=n;
        this.mail=m;
        this.mdp=md;
        this.token=t;
        this.dateExpire=d;
    }
    public TokenUtilisateur()
    {
        
    }
}
