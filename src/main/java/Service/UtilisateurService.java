package Service;
import Entity.*;


import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;

public class UtilisateurService extends Utilisateur {
    @Autowired
    TokenUtilisateurDAO repo;
    public Utilisateur getUtilisateur(String mail,String mdp)
    {
        String req="select * from Utilisateur where (nom='"+mail+"' or mail='"+mail+"') and mdp='"+mdp+"'";
        System.out.println(req);
        Utilisateur a=null;
        List<Utilisateur> list=select(req);
        if(list.size()>0)
        {
            a=list.get(0);
        }
        return a;
    }
    public String byteToHex(byte[] b)
    {
        String result="";
        for(int i=0;i<b.length;i++)
        {
            result+=Integer.toString((b[i] & 0xff) + 0x100,16).substring(1);
        }
        return result;
    }
    public String token(String mail,String mdp)  
    {
        String sha1=null;
        Utilisateur a=getUtilisateur(mail, mdp);
        if(a!=null)
        {
            try{
                String idNom=a.getNom()+a.getMdp();
                MessageDigest msg=MessageDigest.getInstance("SHA-1");
                msg.reset();
                msg.update(idNom.getBytes("iso-8859-1"),0,idNom.length());
                sha1=byteToHex(msg.digest());
                Timestamp now=new Timestamp(System.currentTimeMillis());
                Timestamp late=new Timestamp(now.getTime()+(21600*1000));
                Date dt=new Date(late.getTime());
                Integer in=new Integer(a.getId());
                System.out.println(now+"   "+dt);
                TokenUtilisateur tok=new TokenUtilisateur(in.toString(),a.getNom(),a.getMail(),a.getMdp(),sha1,dt);
                repo.insert(tok);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        System.out.println(sha1);
        return sha1;
    }
    public void deleteToken(String token)
    {
        this.repo.deleteByToken(token);
    }
    public Utilisateur verifToken(String token)
    {
        Utilisateur a=null;
        Timestamp t=new Timestamp(System.currentTimeMillis());
        Date dt=new Date(t.getTime());
        List<TokenUtilisateur> tk=repo.findByTokenAndDateExpireGreaterThan(token,dt);
        if(tk.size()>0)
        {
            TokenUtilisateur tkk=tk.get(0);
            System.out.println(tkk.getIdUtilisateur());
            Integer id=new Integer(tkk.getIdUtilisateur());
            Utilisateur ad=new Utilisateur(id.intValue(),tkk.getNom(),tkk.getMdp(),tkk.getMail());
            a=ad;
        }
        return a;
    }

    public boolean test_misyArobaze(String mail){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
        "[a-zA-Z0-9_+&*-]+)*@" +
        "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
        "A-Z]{2,7}$";
          
        Pattern pat = Pattern.compile(emailRegex);
        if (mail == null)
            return false;
        return pat.matcher(mail).matches();
     }


     public boolean testMail(String mail){
        return true;
     }

    public String removeDiacriticalMarks(String string) {
        return Normalizer.normalize(string, Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    public int getVerifMdp(String mdp){
        int rep=0;
        String input =removeDiacriticalMarks(mdp);
        int count=mdp.length();
        if(mdp.equals(input) && count<8){
            System.out.println("Mdp1:"+mdp+" Mdp2:"+input);
            rep=1;
        }
        else if(mdp.equals(input)==false && count<8)
        {
            rep=-1;
        }
        else if(mdp.equals(input)==false && count>=8)
        {
            rep=2;
        }
        return rep;
    }


    
}
