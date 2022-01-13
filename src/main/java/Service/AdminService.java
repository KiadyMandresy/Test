package Service;
import Entity.*;
import java.util.ArrayList;
import java.util.List;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
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
                Integer in=new Integer(a.getId());
                System.out.println(now+"   "+late);
                TokkenAdmin tok=new TokkenAdmin(in.toString(),a.getNom(),a.getMail(),a.getMdp(),sha1,late);
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
