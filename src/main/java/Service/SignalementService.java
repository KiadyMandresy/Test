package Service;
import Entity.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Vector;

import org.apache.tomcat.util.codec.binary.Base64;

import java.util.List;
import java.util.ArrayList;

public class SignalementService {
    
    public SignalementService(){

    }
    public String nomReg(int id)
    {
        String reg="";
        try{
                ConnectionBD co=new ConnectionBD();
                String req="select nom from region where id="+id;
                Connection con=co.getConnection();
                PreparedStatement st=con.prepareStatement(req);
                ResultSet res=st.executeQuery();
                while(res.next())
                {
                    reg=res.getString("nom");
                }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return reg;
    }
    public List<SignalementValideView> rechercheAvance(String date1,String date2,String type,String statut,String region)
    {
        List<SignalementValideView> signs=new ArrayList<>();
        if(statut.toLowerCase().compareTo("termine")==0)
        {
            signs=rechercheAvanceTermine(date1,date2,type,region);
        }
        else if(statut.toLowerCase().compareTo("en cours")==0)
        {
            signs=rechercheAvanceNonTermine(date1,date2,type,region);
        }
        return signs;
    }
    public List<SignalementValideView> rechercheAvanceNonTermine(String date1,String date2,String type,String region)
    {
        SignalementValideView test=null;
        List<SignalementValideView> signs=new ArrayList<>();
        String condition=" t.nom='"+type+"' and sv.id not in(select stt.idSignV from SignalementTermine as stt) and sv.idReg="+region+" and ";
        if(date1.compareTo(" ")!=0 && date2.compareTo(" ")!=0)
        {
            condition=condition+"s.dateS>='"+date1+"' and s.dateS<='"+date2+"'";
        }
        else if(date1.compareTo(" ")==0 && date2.compareTo(" ")!=0)
        {
            condition=condition+" s.dateS<='"+date2+"'";
        }
        else if(date1.compareTo(" ")!=0 && date2.compareTo(" ")==0)
        {
            condition=condition+" s.dateS>='"+date1+"'";
        }
        String req="select t.nom as type,s.commentaire,ds.photos,s.id,r.nom as region,t.nom,u.nom as personne,s.x,s.y,s.dateS from Signalement s join signalementValide sv on sv.idSign=s.id join region r on r.id=sv.idReg join detailSignalement ds on ds.idSign=s.id join utilisateur u on u.id=s.idUtilisateur join TypeSignalement t on t.id=s.idType where "+condition;
        ConnectionBD co=new ConnectionBD();
        try
        {
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                SignalementValideView s=new SignalementValideView(res.getInt("id"),res.getString("commentaire"),res.getTimestamp("dateS"),res.getDouble("x"),res.getDouble("y"),res.getString("nom"),res.getString("photos"),res.getString("personne"),res.getString("region"),res.getString("type"));
                s.setStatut("probleme non resolu");
                signs.add(s);
            }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(req);
        return signs;
    }
    public List<SignalementValideView> rechercheAvanceTermine(String date1,String date2,String type,String region)
    {

        String condition=" t.nom='"+type+"' and sv.idReg="+region+" and ";
        if(date1.compareTo(" ")!=0 && date2.compareTo(" ")!=0)
        {
            condition=condition+"s.dateS>='"+date1+"' and s.dateS<='"+date2+"'";
        }
        else if(date1.compareTo(" ")==0 && date2.compareTo(" ")!=0)
        {
            condition=condition+" s.dateS<='"+date2+"'";
        }
        else if(date1.compareTo(" ")!=0 && date2.compareTo(" ")==0)
        {
            condition=condition+" s.dateS>='"+date1+"'";
        }
        SignalementValideView sign=new SignalementValideView();
        List<SignalementValideView> signs=new ArrayList<>();
        String req="select t.nom as type,st.budget,st.dateS as termine,s.commentaire,ds.photos,s.id,r.nom as region,t.nom,u.nom as personne,s.x,s.y,s.dateS from Signalement s join signalementValide sv on sv.idSign=s.id join region r on r.id=sv.idReg join detailSignalement ds on ds.idSign=s.id join utilisateur u on u.id=s.idUtilisateur join TypeSignalement t on t.id=s.idType join SignalementTermine st on st.idSignV=sv.id where "+condition;
        ConnectionBD co=new ConnectionBD();
        System.out.println(req);
        try
        {
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                SignalementValideView s=new SignalementValideView(res.getInt("id"),res.getString("commentaire"),res.getTimestamp("dateS"),res.getDouble("x"),res.getDouble("y"),res.getString("nom"),res.getString("photos"),res.getString("personne"),res.getString("region"),res.getTimestamp("termine"),res.getDouble("budget"),res.getString("type"));
                s.setStatut("probleme resolu");
                signs.add(s);            }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return signs;
    }

    public String[] statPerformance()
    {
        String req="select count(st.id) as budget,r.nom as region from Signalement s join signalementValide sv on sv.idSign=s.id join region r on r.id=sv.idReg join detailSignalement ds on ds.idSign=s.id join utilisateur u on u.id=s.idUtilisateur join TypeSignalement t on t.id=s.idType join SignalementTermine st on st.idSignV=sv.id group by r.nom";
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
    public String[] statPerformanceDate(String date1,String date2)
    {
        String req="select count(st.id),r.nom as region from Signalement s join signalementValide sv on sv.idSign=s.id join region r on r.id=sv.idReg join detailSignalement ds on ds.idSign=s.id join utilisateur u on u.id=s.idUtilisateur join TypeSignalement t on t.id=s.idType join SignalementTermine st on st.idSignV=sv.id  where s.dateS>'"+date1+"' and s.dateS<'"+date2+"' group by r.nom";
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
        String req="select st.budget,st.dateS as termine,t.nom as type,s.commentaire,s.id,r.nom as region,t.nom,u.nom as personne,s.x,s.y,s.dateS from Signalement s join signalementValide sv on sv.idSign=s.id join region r on r.id=sv.idReg join  utilisateur u on u.id=s.idUtilisateur join TypeSignalement t on t.id=s.idType join SignalementTermine st on st.idSignV=sv.id  where s.id="+id;
        ConnectionBD co=new ConnectionBD();
        try
        {
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                SignalementValideView s=new SignalementValideView(res.getInt("id"),res.getString("commentaire"),res.getTimestamp("dateS"),res.getDouble("x"),res.getDouble("y"),res.getString("nom"),"",res.getString("personne"),res.getString("region"),res.getTimestamp("termine"),res.getDouble("budget"),res.getString("type"));
                test=s;
                test.setStatut("probleme resolu");
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
        String req="select s.commentaire,t.nom as type,s.id,r.nom as region,t.nom,u.nom as personne,s.x,s.y,s.dateS from Signalement s join signalementValide sv on sv.idSign=s.id join region r on r.id=sv.idReg join utilisateur u on u.id=s.idUtilisateur join TypeSignalement t on t.id=s.idType where s.id="+id;
        ConnectionBD co=new ConnectionBD();
        try
        {
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                SignalementValideView s=new SignalementValideView(res.getInt("id"),res.getString("commentaire"),res.getTimestamp("dateS"),res.getDouble("x"),res.getDouble("y"),res.getString("nom"),"",res.getString("personne"),res.getString("region"),res.getString("type"));
                test=s;
                test.setStatut("probleme non resolu");
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
        String req="select s.id,s.commentaire as photos,s.commentaire,s.dateS,s.x,s.y,st.nom ,u.nom as Personne from Signalement as s join TypeSignalement as st on st.id=s.idType  join Utilisateur as u on u.id=s.idUtilisateur where s.id="+id;
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
        Connection co=con.getConnection();
        String req2=" limit 3 offset "+rep1;
        String req3=" where s.id not in (select idSign from SignalementCorbeille)";
        String req1="select s.id,s.commentaire,s.dateS,s.x,s.y,st.nom,u.nom as Personne from Signalement as s join TypeSignalement as st on st.id=s.idType join Utilisateur as u on u.id=s.idUtilisateur";
        System.out.println(req1+req3+req2);
        try{
            PreparedStatement st=co.prepareStatement(req1+req3+req2);
            ResultSet res=st.executeQuery();
            while(res.next()){
                int id=res.getInt("id");
                String com=res.getString("commentaire");
                Date d=res.getDate("dateS");
                Timestamp date=new Timestamp(d.getTime());
                double x=res.getDouble("x");
                double y=res.getDouble("y");
                String n=res.getString("nom");
                String photos="";
                String idu=res.getString("Personne");
                SignalementGlobal sing=new SignalementGlobal(id,com,date,x,y,n,photos,idu);
                rep.add(sing);
            }
            co.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }

    public int getCountSignalement(){
        int va=0;
        List<SignalementGlobal> rep=new ArrayList<>();
        ConnectionBD con=new ConnectionBD();
        Connection co=con.getConnection();
        String req2=" where s.id not in (select idSign from SignalementCorbeille)";
        String req1="select s.id,s.commentaire,s.dateS,s.x,s.y,st.nom,u.nom as Personne from Signalement as s join TypeSignalement as st on st.id=s.idType join Utilisateur as u on u.id=s.idUtilisateur";
        try{
            PreparedStatement st=co.prepareStatement(req1+req2);
            ResultSet res=st.executeQuery();
            while(res.next()){
                int id=res.getInt("id");
                String com=res.getString("commentaire");
                Date d=res.getDate("dateS");
                Timestamp date=new Timestamp(d.getTime());
                double x=res.getDouble("x");
                double y=res.getDouble("y");
                String n=res.getString("nom");
                String photos="";
                String idu=res.getString("Personne");
                SignalementGlobal sing=new SignalementGlobal(id,com,date,x,y,n,photos,idu);
                rep.add(sing);
            }
            co.close();
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
        Connection co=con.getConnection();
        String req3=" where s.id not in (select idSign from SignalementCorbeille) and s.dateS>'"+d1+"' and s.dateS<'"+d2+"'";
        String req1="select s.id,s.commentaire,s.dateS,s.x,s.y,st.nom,u.nom as Personne from Signalement as s join TypeSignalement as st on st.id=s.idType join Utilisateur as u on u.id=s.idUtilisateur";
        System.out.println(req1+req3);
        try{
            PreparedStatement st=co.prepareStatement(req1+req3);
            ResultSet res=st.executeQuery();
            while(res.next()){
                int id=res.getInt("id");
                String com=res.getString("commentaire");
                Date d=res.getDate("dateS");
                Timestamp date=new Timestamp(d.getTime());
                double x=res.getDouble("x");
                double y=res.getDouble("y");
                String n=res.getString("nom");
                String photos="";
                String idu=res.getString("Personne");
                SignalementGlobal sing=new SignalementGlobal(id,com,date,x,y,n,photos,idu);
                rep.add(sing);
            }
            co.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }

    public int countSingalement(String d1,String d2){
        int va=0;
        List<SignalementGlobal> rep=new ArrayList<>();
        ConnectionBD con=new ConnectionBD();
        Connection co=con.getConnection();
        String req2=" where s.id not in (select idSign from SignalementCorbeille) and s.dateS>'"+d1+"' and s.dateS<'"+d2+"'";
        String req1="select s.id,s.commentaire,s.dateS,s.x,s.y,st.nom,u.nom as Personne from Signalement as s join TypeSignalement as st on st.id=s.idType join Utilisateur as u on u.id=s.idUtilisateur";
        try{
            PreparedStatement st=co.prepareStatement(req1+req2);
            ResultSet res=st.executeQuery();
            while(res.next()){
                int id=res.getInt("id");
                String com=res.getString("commentaire");
                Date d=res.getDate("dateS");
                Timestamp date=new Timestamp(d.getTime());
                double x=res.getDouble("x");
                double y=res.getDouble("y");
                String n=res.getString("nom");
                String photos="";
                String idu=res.getString("Personne");
                SignalementGlobal sing=new SignalementGlobal(id,com,date,x,y,n,photos,idu);
                rep.add(sing);
            }
            co.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        va=rep.size();
        return va;
    }

    public List<StatRegion> getStatRegion(){
        List<StatRegion> rep=new ArrayList<>();
        ConnectionBD con=new ConnectionBD();
        Connection co=con.getConnection();
        try{
            String req1="select count(s.id),r.nom from Signalement as s join SignalementValide as sv on sv.idSign=s.id join Region as r on r.id=sv.idReg";
            String req2=" group by r.id";
            System.out.println(req1+req2);
            PreparedStatement st=co.prepareStatement(req1+req2);
            ResultSet res=st.executeQuery();
            while(res.next()){
                int id=res.getInt("count");
                String com=res.getString("nom");
                StatRegion reg=new StatRegion(id,com);
                rep.add(reg);
            }
            co.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }
    public List<StatRegion> getStatRegionRecherche(String d1,String d2){
        List<StatRegion> rep=new ArrayList<>();
        ConnectionBD con=new ConnectionBD();
        Connection co=con.getConnection();
        try{
            String req1="select count(s.id),r.nom from Signalement as s join SignalementValide as sv on sv.idSign=s.id join Region as r on r.id=sv.idReg";
            String req2=" group by r.id";
            String req3=" where s.dateS>'"+d1+"' and s.dateS<'"+d2+"'";
            System.out.println(req1+req3+req2);
            System.out.println(req1+req2);
            PreparedStatement st=co.prepareStatement(req1+req3+req2);
            ResultSet res=st.executeQuery();
            while(res.next()){
                int id=res.getInt("count");
                String com=res.getString("nom");
                StatRegion reg=new StatRegion(id,com);
                rep.add(reg);
            }
            co.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }
    public int insertSignalement(String id,String com,String x,String y,String ut)
    {
        Integer idd=new Integer(id);
        Double xx=new Double(x);
        Double yy=new Double(y);
        Signalement sign=new Signalement(0,idd.intValue(),com,null,xx.doubleValue(),yy.doubleValue(),ut);
        sign.insert();
        return this.idSign();
    }
    public int idSign()
    {
        int idV=0;
        String req="select max(id) as id from signalement";
        ConnectionBD co=new ConnectionBD();
        Connection con=co.getConnection();
        try{
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                idV=res.getInt("id");
            }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return idV;
    }
    public int idSignDetail()
    {
        int idV=0;
        String req="select idSign  from detailsignalement where id=(select max(id) from detailSignalement";
        ConnectionBD co=new ConnectionBD();
        Connection con=co.getConnection();
        try{
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                idV=res.getInt("idSign");
            }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return idV;
    }
    public void insertPhoto(String photo,String id)
    {
        Integer idd=new Integer(id);
        DetailSignalement dt=new DetailSignalement(0,idd.intValue(),photo);
        dt.insert();
    }
    public List<SignalementRegion> getSignPersonneEnCours(String nom){
        List<SignalementRegion> rep=new ArrayList<>();
        /** */
        String req="select s.id,s.commentaire,s.dates,s.x,s.y,u.nom as utilisateur,u.mail,r.nom,ty.nom as typeS from SignalementValide as sv join Signalement as s on sv.idSign=s.id join Region as r on r.id=sv.idReg join Utilisateur as u on u.id=s.idUtilisateur join TypeSignalement as ty on ty.id=s.idType";
        String req1=" where u.nom='"+nom+"' and  sv.id not in(select idSignV from SignalementTermine)";
        try{
            System.out.println(req+req1);
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req+req1);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                SignalementRegion reg=new SignalementRegion(res.getInt("id"),res.getString("commentaire"),res.getTimestamp("dateS"), res.getDouble("x"),res.getDouble("y"),res.getString("utilisateur"),res.getString("mail"), res.getString("nom"),res.getString("typeS"));
                rep.add(reg);
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }
    
    public int countGetSignUtil(String nom){
        int reps=0;
        List<SignalementRegion> rep=new ArrayList<>();
        /** */
        String req="select s.id,s.commentaire,s.dates,s.x,s.y,u.nom as utilisateur,u.mail,r.nom,ty.nom as typeS from SignalementValide as sv join Signalement as s on sv.idSign=s.id join Region as r on r.id=sv.idReg join Utilisateur as u on u.id=s.idUtilisateur join TypeSignalement as ty on ty.id=s.idType";
        String req1=" where u.nom='"+nom+"'";
        try{
            System.out.println(req+req1);
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req+req1);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                SignalementRegion reg=new SignalementRegion(res.getInt("id"),res.getString("commentaire"),res.getTimestamp("dateS"), res.getDouble("x"),res.getDouble("y"),res.getString("utilisateur"),res.getString("mail"), res.getString("nom"),res.getString("typeS"));
                rep.add(reg);
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        reps=rep.size();
        return reps;
    }

    public List<SignalementRegion> getSignPersonneTerminer(String nom){
        List<SignalementRegion> rep=new ArrayList<>();
        /** */
        String req="select s.id,s.commentaire,s.dates,s.x,s.y,u.nom as utilisateur,u.mail,r.nom,ty.nom as typeS from SignalementValide as sv join Signalement as s on sv.idSign=s.id join Region as r on r.id=sv.idReg join Utilisateur as u on u.id=s.idUtilisateur join SignalementTermine as st on sv.id=st.idSignV join TypeSignalement as ty on ty.id=s.idType";
        String req1=" where u.nom='"+nom+"'";
        try{
            System.out.println(req+req1);
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req+req1);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                SignalementRegion reg=new SignalementRegion(res.getInt("id"),res.getString("commentaire"),res.getTimestamp("dateS"), res.getDouble("x"),res.getDouble("y"),res.getString("utilisateur"),res.getString("mail"), res.getString("nom"),res.getString("typeS"));
                rep.add(reg);
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }

    public List<SignalementRegion> getSignPersonneNonValide(String nom){
        List<SignalementRegion> rep=new ArrayList<>();
        /** */
        String req="select s.id,s.commentaire,s.dates,s.x,s.y,u.nom as utilisateur,u.mail,ty.nom as typeS from Signalement as s join Utilisateur as u  on u.id=s.idUtilisateur join TypeSignalement as ty on ty.id=s.idType";
        String req1=" where u.nom='"+nom+"' and s.id not in(select idSign from SignalementValide)";
        try{
            System.out.println(req+req1);
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req+req1);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                SignalementRegion reg=new SignalementRegion(res.getInt("id"),res.getString("commentaire"),res.getTimestamp("dateS"), res.getDouble("x"),res.getDouble("y"),res.getString("utilisateur"),res.getString("mail"), res.getString("utilisateur"),res.getString("typeS"));
                rep.add(reg);
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }

    public int countGetSignUtil2(String nom){
        int reps=0;
        List<SignalementRegion> rep=new ArrayList<>();
        /** */
        String req="select s.id,s.commentaire,s.dates,s.x,s.y,u.nom as utilisateur,u.mail,r.nom,ty.nom as typeS from SignalementValide as sv join Signalement as s on sv.idSign=s.id join Region as r on r.id=sv.idReg join Utilisateur as u on u.id=s.idUtilisateur join SignalementTermine as st on sv.id=st.idSignV join TypeSignalment as ty on ty.id=s.idType";
        String req1=" where u.nom='"+nom+"'";
        try{
            System.out.println(req+req1);
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            PreparedStatement st=con.prepareStatement(req+req1);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                SignalementRegion reg=new SignalementRegion(res.getInt("id"),res.getString("commentaire"),res.getTimestamp("dateS"), res.getDouble("x"),res.getDouble("y"),res.getString("utilisateur"),res.getString("mail"), res.getString("nom"),res.getString("typeS"));
                rep.add(reg);
            }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        reps=rep.size();
        return reps;
    }
    public int idValide(String id)
    {
        int idV=0;
        String req="select id from signalementValide where idSign="+id;
        ConnectionBD co=new ConnectionBD();
        Connection con=co.getConnection();
        try{
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                idV=res.getInt("id");
            }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return idV;
    }
    public int idTermine(int id)
    {
        int idV=0;
        String req="select id from signalementTermine where idSignV="+id;
        ConnectionBD co=new ConnectionBD();
        Connection con=co.getConnection();
        try{
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                idV=res.getInt("id");
            }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return idV;
    }
    public void signalementTermine(String id,String budget)
    {
        Double doub=new Double(budget);
        SignalementTermine stt=new SignalementTermine(0,idValide(id),null,doub.doubleValue());
        stt.insert();
        int idT=idTermine(idValide(id));
        String req="insert into notification(idsigntermine) values ("+idT+")";
        try
        {
            ConnectionBD co=new ConnectionBD();
            Connection con=co.getConnection();
            Statement st=con.createStatement();
            st.executeUpdate(req);
            con.commit();
            con.close();
        }
        catch(Exception e)
        {
 
        }
    }
    public String getPhoto(String id,String nb)
    {
        String photos="";
        int nb1=Integer.parseInt(nb);
        String req="select photos from detailSignalement1 where idSign="+id+" order by id  asc limit 1 offset "+(nb1-1);
        System.out.println(req);
        ConnectionBD co=new ConnectionBD();
        Connection con=co.getConnection();
        try{
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                photos=res.getString("photos");
            }
           // System.out.println(photos);
            con.close();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return photos;
    }
    public List<String> getPhotos(String id)
    {
        List<String> photos=new ArrayList<>();
        String req="select photos from detailSignalement1 where idSign="+id;
        ConnectionBD co=new ConnectionBD();
        Connection con=co.getConnection();
        try{
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                photos.add(res.getString("photos"));
            }
            con.close();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return photos;
    }
    public String toBase64(File file)
    {
        String base="";
        try
        {
            FileInputStream file1=new FileInputStream(file);
            byte[] bytes=new byte[(int)file.length()];
            file1.read(bytes);
            String a=new String(Base64.encodeBase64(bytes));
          //  System.out.println(a);
            base=a;
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return base;
    }
    public List<TypeSignalement> type()
    {
        List<TypeSignalement> typ=new ArrayList<>();
        String req="select * from typeSignalement";
        ConnectionBD co=new ConnectionBD();
        Connection con=co.getConnection();
        try{
            PreparedStatement st=con.prepareStatement(req);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                TypeSignalement t=new TypeSignalement(res.getInt("id"),res.getString("nom"));
                typ.add(t);
            }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return typ;
    }
}

