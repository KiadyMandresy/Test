package Service;
import Entity.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.*;
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;

public class SignalementService {
    
    public SignalementService(){

    }
    public String[] statDepenseRegionDate(String date1,String date2)
    {
        String req="select sum(st.budget) as budget,r.nom as region from Signalement s join signalementValide sv on sv.idSign=s.id join region r on r.id=sv.idReg join detailSignalement ds on ds.idSign=s.id join utilisateur u on u.id=s.idUtilisateur join TypeSignalement t on t.id=s.idType join SignalementTermine st on st.idSignV=sv.id  where s.dateS>'"+date1+"' and s.dateS<'"+date2+"' group by r.nom";
        System.out.println(req);
        String[] retour=new String[2];
        retour[0]="";
        retour[1]="";
        Vector nomReg=new Vector();
        Vector budget=new Vector();
        ConnectionBD co=new ConnectionBD();
        try
        {
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                Double bg=res.getDouble("budget");
                String reg=res.getString("region");
                budget.addElement(bg);
                nomReg.addElement(reg);
            }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        if(budget.size()>0)
        {
            retour[0]=(String)nomReg.elementAt(0);
            Double bg=(Double)budget.elementAt(0);
            retour[1]=bg.toString();
            if(budget.size()>1)
            {
                retour[0]=retour[0]+"\",";
                retour[1]=retour[1]+"\",";
            }
            
            for(int i=1;i<budget.size()-1;i++)
            {
                retour[0]=retour[0]+"\""+(String)nomReg.elementAt(i)+"\",";
                Double bg1=(Double)budget.elementAt(i);
                retour[1]=retour[1]+"\""+bg1.toString()+"\",";
            }
            if(budget.size()>1)
            {
                retour[0]=retour[0]+"\""+(String)nomReg.elementAt(budget.size()-1);
                Double bg1=(Double)budget.elementAt(budget.size()-1);
                retour[1]=retour[1]+"\""+bg1.toString();
            }
        }
        return retour;
    }
    public String[] statDepenseRegion()
    {
        String req="select sum(st.budget) as budget,r.nom as region from Signalement s join signalementValide sv on sv.idSign=s.id join region r on r.id=sv.idReg join detailSignalement ds on ds.idSign=s.id join utilisateur u on u.id=s.idUtilisateur join TypeSignalement t on t.id=s.idType join SignalementTermine st on st.idSignV=sv.id group by r.nom";
        String[] retour=new String[2];
        System.out.println(req);
        retour[0]="";
        retour[1]="";
        Vector nomReg=new Vector();
        Vector budget=new Vector();
        ConnectionBD co=new ConnectionBD();
        try
        {
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                Double bg=res.getDouble("budget");
                String reg=res.getString("region");
                budget.addElement(bg);
                nomReg.addElement(reg);
            }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        if(budget.size()>0)
        {
            retour[0]=(String)nomReg.elementAt(0);
            Double bg=(Double)budget.elementAt(0);
            retour[1]=bg.toString();
            if(budget.size()>1)
            {
                retour[0]=retour[0]+"\",";
                retour[1]=retour[1]+"\",";
            }
            
            for(int i=1;i<budget.size()-1;i++)
            {
                retour[0]=retour[0]+"\""+(String)nomReg.elementAt(i)+"\",";
                Double bg1=(Double)budget.elementAt(i);
                retour[1]=retour[1]+"\""+bg1.toString()+"\",";
            }
            if(budget.size()>1)
            {
                retour[0]=retour[0]+"\""+(String)nomReg.elementAt(budget.size()-1);
                Double bg1=(Double)budget.elementAt(budget.size()-1);
                retour[1]=retour[1]+"\""+bg1.toString();
            }
        }
        return retour;
    }
    public SignalementValideView signTermine(String id)
    {
        SignalementValideView test=null;
        String req="select st.budget,st.dateS as termine,s.commentaire,ds.photos,s.id,r.nom as region,t.nom,u.nom as personne,s.x,s.y,s.dateS from Signalement s join signalementValide sv on sv.idSign=s.id join region r on r.id=sv.idReg join detailSignalement ds on ds.idSign=s.id join utilisateur u on u.id=s.idUtilisateur join TypeSignalement t on t.id=s.idType join SignalementTermine st on st.idSignV=sv.id where s.id="+id;
        ConnectionBD co=new ConnectionBD();
        try
        {
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                SignalementValideView s=new SignalementValideView(res.getInt("id"),res.getString("commentaire"),res.getTimestamp("dateS"),res.getDouble("x"),res.getDouble("y"),res.getString("nom"),res.getString("photos"),res.getString("personne"),res.getString("region"),res.getTimestamp("termine"),res.getDouble("budget"));
                test=s;
            }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return test;
    }
    public void deleteSignalement(String id)
    {
        Integer idd=new Integer(id);
        SignalementCorbeille sg=new SignalementCorbeille(0,idd.intValue(),null);
        sg.insert();
    }
    public void valideSignalement(String id,String reg)
    {
        Integer idd=new Integer(id);
        Integer rg=new Integer(reg);
        SignalementValide val=new SignalementValide(0,idd.intValue(),rg.intValue());
        val.insert();
    }
    public SignalementValideView ifValide(int id)
    {
       SignalementValideView test=null;
        String req="select s.commentaire,ds.photos,s.id,r.nom as region,t.nom,u.nom as personne,s.x,s.y,s.dateS from Signalement s join signalementValide sv on sv.idSign=s.id join region r on r.id=sv.idReg join detailSignalement ds on ds.idSign=s.id join utilisateur u on u.id=s.idUtilisateur join TypeSignalement t on t.id=s.idType where s.id="+id;
        ConnectionBD co=new ConnectionBD();
        try
        {
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                SignalementValideView s=new SignalementValideView(res.getInt("id"),res.getString("commentaire"),res.getTimestamp("dateS"),res.getDouble("x"),res.getDouble("y"),res.getString("nom"),res.getString("photos"),res.getString("personne"),res.getString("region"));
                test=s;
            }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return test;
    }
    public int countPhotoSignalement(int id)
    {
        int i=0;
        ConnectionBD co=new ConnectionBD();
        try
        {
            Connection con=co.getConnection();
            String req="select count(id) as nb from detailSignalement where idSign="+id;
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                i=res.getInt("nb");
            }
            con.close();
        }
        catch(Exception e)
        {

        }
        return i;
    }
    public String getPhoto(int nb,int id)
    {
        nb=nb-1;
        String req="select * from detailSignalement where idSign="+id+" order by id  asc limit 1 offset "+nb;
        DetailSignalement dt=new DetailSignalement();
        List<DetailSignalement> list=dt.select(req);
        String photo=list.get(0).getPhotos();
        return photo;
    }
    public SignalementGlobal getFicheSignalementNonValide(int id)
    {
        String req="select s.id,s.commentaire,s.dateS,s.x,s.y,st.nom,dt.photos,u.nom as Personne from Signalement as s join TypeSignalement as st on st.id=s.idType join DetailSignalement as dt on dt.idSign=s.id join Utilisateur as u on u.id=s.idUtilisateur where s.id="+id;
        SignalementGlobal sign=new SignalementGlobal();
        List<SignalementGlobal> liste=sign.select(req);
        return liste.get(0);
    }
    public List<SignalementGlobal> getSignalementGlobal(int indice){
        int rep1,rep2;
        rep1=((indice-1)*3);
        rep2=indice*3;
        List<SignalementGlobal> rep=new ArrayList<>();
        ConnectionBD con=new ConnectionBD();
        String req2=" limit 3 offset "+rep1;
        String req3=" where s.id not in (select idSign from SignalementCorbeille)";
        String req1="select s.id,s.commentaire,s.dateS,s.x,s.y,st.nom,dt.photos,u.nom as Personne from Signalement as s join TypeSignalement as st on st.id=s.idType join DetailSignalement as dt on dt.idSign=s.id join Utilisateur as u on u.id=s.idUtilisateur";
        System.out.println(req1+req3+req2);
        try{
            PreparedStatement st=con.getConnection().prepareStatement(req1+req3+req2);
            ResultSet res=st.executeQuery();
            while(res.next()){
                int id=res.getInt("id");
                String com=res.getString("commentaire");
                Date d=res.getDate("dateS");
                Timestamp date=new Timestamp(d.getTime());
                double x=res.getDouble("x");
                double y=res.getDouble("y");
                String n=res.getString("nom");
                String photos=res.getString("photos");
                String idu=res.getString("Personne");
                SignalementGlobal sing=new SignalementGlobal(id,com,date,x,y,n,photos,idu);
                rep.add(sing);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }

    public int getCountSignalement(){
        int va=0;
        List<SignalementGlobal> rep=new ArrayList<>();
        ConnectionBD con=new ConnectionBD();
        String req2=" where s.id not in (select idSign from SignalementCorbeille)";
        String req1="select s.id,s.commentaire,s.dateS,s.x,s.y,st.nom,dt.photos,u.nom as Personne from Signalement as s join TypeSignalement as st on st.id=s.idType join DetailSignalement as dt on dt.idSign=s.id join Utilisateur as u on u.id=s.idUtilisateur";
        try{
            PreparedStatement st=con.getConnection().prepareStatement(req1+req2);
            ResultSet res=st.executeQuery();
            while(res.next()){
                int id=res.getInt("id");
                String com=res.getString("commentaire");
                Date d=res.getDate("dateS");
                Timestamp date=new Timestamp(d.getTime());
                double x=res.getDouble("x");
                double y=res.getDouble("y");
                String n=res.getString("nom");
                String photos=res.getString("photos");
                String idu=res.getString("Personne");
                SignalementGlobal sing=new SignalementGlobal(id,com,date,x,y,n,photos,idu);
                rep.add(sing);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        va=rep.size();
        return va;
    }

    public List<SignalementGlobal> getSignalementGlobalRecherche(String d1,String d2){
        int rep1,rep2;
        List<SignalementGlobal> rep=new ArrayList<>();
        ConnectionBD con=new ConnectionBD();
        String req3=" where s.id not in (select idSign from SignalementCorbeille) and s.dateS>'"+d1+"' and s.dateS<'"+d2+"'";
        String req1="select s.id,s.commentaire,s.dateS,s.x,s.y,st.nom,dt.photos,u.nom as Personne from Signalement as s join TypeSignalement as st on st.id=s.idType join DetailSignalement as dt on dt.idSign=s.id join Utilisateur as u on u.id=s.idUtilisateur";
        System.out.println(req1+req3);
        try{
            PreparedStatement st=con.getConnection().prepareStatement(req1+req3);
            ResultSet res=st.executeQuery();
            while(res.next()){
                int id=res.getInt("id");
                String com=res.getString("commentaire");
                Date d=res.getDate("dateS");
                Timestamp date=new Timestamp(d.getTime());
                double x=res.getDouble("x");
                double y=res.getDouble("y");
                String n=res.getString("nom");
                String photos=res.getString("photos");
                String idu=res.getString("Personne");
                SignalementGlobal sing=new SignalementGlobal(id,com,date,x,y,n,photos,idu);
                rep.add(sing);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }

    public int countSingalement(String d1,String d2){
        int va=0;
        List<SignalementGlobal> rep=new ArrayList<>();
        ConnectionBD con=new ConnectionBD();
        String req2=" where s.id not in (select idSign from SignalementCorbeille) and s.dateS>'"+d1+"' and s.dateS<'"+d2+"'";
        String req1="select s.id,s.commentaire,s.dateS,s.x,s.y,st.nom,dt.photos,u.nom as Personne from Signalement as s join TypeSignalement as st on st.id=s.idType join DetailSignalement as dt on dt.idSign=s.id join Utilisateur as u on u.id=s.idUtilisateur";
        try{
            PreparedStatement st=con.getConnection().prepareStatement(req1+req2);
            ResultSet res=st.executeQuery();
            while(res.next()){
                int id=res.getInt("id");
                String com=res.getString("commentaire");
                Date d=res.getDate("dateS");
                Timestamp date=new Timestamp(d.getTime());
                double x=res.getDouble("x");
                double y=res.getDouble("y");
                String n=res.getString("nom");
                String photos=res.getString("photos");
                String idu=res.getString("Personne");
                SignalementGlobal sing=new SignalementGlobal(id,com,date,x,y,n,photos,idu);
                rep.add(sing);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        va=rep.size();
        return va;
    }

    public List<StatRegion> getStatRegion(){
        List<StatRegion> rep=new ArrayList<>();
        ConnectionBD con=new ConnectionBD();
        try{
            String req1="select count(s.id),r.nom from Signalement as s join SignalementValide as sv on sv.idSign=s.id join Region as r on r.id=sv.idReg";
            String req2=" group by r.id";
            System.out.println(req1+req2);
            PreparedStatement st=con.getConnection().prepareStatement(req1+req2);
            ResultSet res=st.executeQuery();
            while(res.next()){
                int id=res.getInt("count");
                String com=res.getString("nom");
                StatRegion reg=new StatRegion(id,com);
                rep.add(reg);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }

    public List<StatRegion> getStatRegionRecherche(String d1,String d2){
        List<StatRegion> rep=new ArrayList<>();
        ConnectionBD con=new ConnectionBD();
        try{
            String req1="select count(s.id),r.nom from Signalement as s join SignalementValide as sv on sv.idSign=s.id join Region as r on r.id=sv.idReg";
            String req2=" group by r.id";
            String req3=" where s.dateS>'"+d1+"' and s.dateS<'"+d2+"'";
            System.out.println(req1+req3+req2);
            System.out.println(req1+req2);
            PreparedStatement st=con.getConnection().prepareStatement(req1+req3+req2);
            ResultSet res=st.executeQuery();
            while(res.next()){
                int id=res.getInt("count");
                String com=res.getString("nom");
                StatRegion reg=new StatRegion(id,com);
                rep.add(reg);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }

}
