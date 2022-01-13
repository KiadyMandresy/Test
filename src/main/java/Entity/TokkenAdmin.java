package Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.*;

@Document(collection="tokkenAdmin")
public class TokkenAdmin {
    
    @Id
    String id;

    
    String nom;
    
    String mail;
    
    String mdp;
   
    String tokken;


    public String getId() {
        return id;
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
    public void setId(String id) {
        this.id = id;
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
    public TokkenAdmin(String i,String n,String m,String md,String t)
    {
        this.id=i;
        this.nom=n;
        this.mail=m;
        this.mdp=md;
        this.tokken=t;
    }
    public TokkenAdmin()
    {
        
    }
}
