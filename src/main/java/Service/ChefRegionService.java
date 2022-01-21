package Service;
import Entity.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.security.MessageDigest;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
public class ChefRegionService extends ChefRegion {
    @Autowired
    TokenFrontDAO repo;
    public ChefRegionService(){

    }
    public void delete(String id)
    {
        Integer idd=new Integer(id);
        setId(idd.intValue());
        delete();
    }
    public int paginationChefRegion()
    {
        
        int n=0;
        String req="select count(id) as nb from chefRegion";
        try
        {
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                n=res.getInt("nb");
            }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        n=n/5;
        if(n%5!=0)
        {
            n=n+1;
        }
        return n;
    }
    public List<ChefRegionNom> getListeChef(String lim)
    {
        Integer lim1=new Integer(lim);
        lim1=(lim1-1)*5;
        ChefRegionNom chef=new ChefRegionNom();
        String req="select c.id,c.idReg,c.nom,c.mdp,c.mail,r.nom as region from chefRegion c join region r on r.id=c.idReg order by id asc limit 5 offset "+lim1.toString();
        System.out.println(req);
        return chef.select(req);
    }
    public void updateChef(String id,String nom,String mdp,String mail,String idR)
    {
        Integer i=new Integer(id);
        Integer rg=new Integer(idR);
        ChefRegion chef=new ChefRegion(i.intValue(),nom,mdp,mail,rg.intValue());
        chef.update();
    }
    public int idRegion(String nom) {
        int id=0;
        String req="select id from Region where nom='"+nom+"'";
        try
        {
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                id=res.getInt("id");
            }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return id;
    }
    public void insertChefRegion(String nom,String mdp,String mail,String reg)
    {
        ChefRegion chef=new ChefRegion(0,nom,mdp,mail,idRegion(reg));
        chef.insert();
    }
    public ChefRegion getChefRegion(String mail,String mdp)
    {
        String req="select * from ChefRegion where (nom='"+mail+"' or mail='"+mail+"') and mdp='"+mdp+"'";
        System.out.println(req);
        ChefRegion a=null;
        List<ChefRegion> list=select(req);
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
        ChefRegion a=getChefRegion(mail, mdp);
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
                TokenFront tok=new TokenFront(in.toString(),a.getNom(),a.getMail(),a.getMdp(),sha1,dt,a.getIdReg());
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
}
