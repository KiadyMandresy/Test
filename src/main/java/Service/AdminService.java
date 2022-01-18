package Service;
import Entity.*;
import java.util.ArrayList;
import java.util.List;
import java.security.MessageDigest;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends Admin{
    @Autowired
    private TokkenAdminDAO repo;
    public Admin getAdmin(String mail,String mdp)
    {
        String req="select * from Admin where (nom='"+mail+"' or mail='"+mail+"') and mdp='"+mdp+"'";
        System.out.println(req);
        Admin a=null;
        List<Admin> list=select(req);
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
    public Admin verifToken(String token)
    {
        Admin a=null;
        Timestamp t=new Timestamp(System.currentTimeMillis());
        Date dt=new Date(t.getTime());
        List<TokkenAdmin> tk=repo.findByTokkenAndDateExpireGreaterThan(token,dt);
        if(tk.size()>0)
        {
            TokkenAdmin tkk=tk.get(0);
            System.out.println(tkk.getIdAdmin());
            Integer id=new Integer(tkk.getIdAdmin());
            Admin ad=new Admin(id.intValue(),tkk.getNom(),tkk.getMdp(),tkk.getMail());
            a=ad;
        }
        return a;
    }
    public void deleteToken(String token)
    {
        this.repo.deleteByTokken(token);
    }
    public String authentif(Admin a)
    {
        String page="login";
        if(a==null)
        {
            page="templateAdmin";
        }
        return page;
    }
    public String token(String mail,String mdp) 
    {
        String sha1=null;
        Admin a=getAdmin(mail, mdp);
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
                TokkenAdmin tok=new TokkenAdmin(in.toString(),a.getNom(),a.getMail(),a.getMdp(),sha1,dt);
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
}
