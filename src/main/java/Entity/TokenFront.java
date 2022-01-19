package Entity;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.*;

@Document(collection="tokenFront")
public class TokenFront {
    String idFront;
    
    String nom;
    
    String mail;
    
    String mdp;
   
    String token;

    Date dateExpire;
    
    int idReg;
    public void setIdReg(int idReg) {
        this.idReg = idReg;
    }
    public int getIdReg() {
        return idReg;
    }

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
    public String getIdFront() {
        return idFront;
    }
    public void setIdFront(String idFront) {
        this.idFront = idFront;
    }
    public TokenFront(String i,String n,String m,String md,String t,Date d,int re)
    {
        this.idFront=i;
        this.nom=n;
        this.mail=m;
        this.mdp=md;
        this.token=t;
        this.dateExpire=d;
        this.idReg=re;
    }
    public TokenFront()
    {
        
    }
}
