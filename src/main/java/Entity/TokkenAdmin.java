package Entity;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.*;

@Document(collection="tokkenAdmin")
public class TokkenAdmin {
    
    

    String idAdmin;
    
    String nom;
    
    String mail;
    
    String mdp;
   
    String tokken;

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
    public String getTokken() {
        return tokken;
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
    public void setTokken(String tokken) {
        this.tokken = tokken;
    }
    public String getIdAdmin() {
        return idAdmin;
    }
    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }
    public TokkenAdmin(String i,String n,String m,String md,String t,Date d)
    {
        this.idAdmin=i;
        this.nom=n;
        this.mail=m;
        this.mdp=md;
        this.tokken=t;
        this.dateExpire=d;
    }
    public TokkenAdmin()
    {
        
    }
}
