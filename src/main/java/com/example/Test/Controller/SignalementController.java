package com.example.Test.Controller;
import java.util.ArrayList;
import java.util.List;
import Entity.*;
import Service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignalementController extends SignalementService{
    @Autowired
    TokkenAdminController service;
    @RequestMapping(value = { "/listeSignalement" }, method = RequestMethod.GET)
    public String view(@RequestParam(name="token")String token,Model model,@RequestParam(name="lim")String l) {
         Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            String page="listeSignalement.jsp";
            model.addAttribute("page",page);
            SignalementService ser=new SignalementService();
            int cc=ser.getCountSignalement()/3;
            int count=ser.getCountSignalement()%3;
            if(count!=0){
                cc=cc+1;
            }
            Integer i=new Integer(l);
            int ii=i.intValue();
            model.addAttribute("lim", cc);
            model.addAttribute("listeGlobale",ser.getSignalementGlobal(ii));
            model.addAttribute("admin",admin);
        }
        else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-connectez");
        }
         return service.authentif(admin);
    }
    
    @RequestMapping(value={"/signalementValide"},method=RequestMethod.GET)
    public String valide(@RequestParam(name="token")String token,Model model,@RequestParam("id") String id,@RequestParam(name="region")String reg)
    {
       Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            valideSignalement(id, reg);
            SignalementService serv=new SignalementService();
            Integer idd=new Integer(id);
            Integer p=new Integer("1");
            SignalementValideView sv=ifValide(idd.intValue());
            int valide=1;
            model.addAttribute("serv",sv);
            RegionService chef=new RegionService();
            model.addAttribute("reg", chef.getAll());
            model.addAttribute("valide", valide);
            model.addAttribute("countPhoto", serv.countPhotoSignalement(idd.intValue()));
            model.addAttribute("photo", serv.getPhoto(p.intValue(), idd.intValue()));
            model.addAttribute("page", "fiche1.jsp");
            model.addAttribute("admin",admin);
        }
        else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-connectez");
        }
         return service.authentif(admin);
    }
    @RequestMapping(value={"/deleteSignalamentConf"},method=RequestMethod.GET)
    public String confDelete(@RequestParam(name="token")String token,Model model,@RequestParam("id") String id)
    {
        Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            model.addAttribute("id", id);
            model.addAttribute("page", "confirmDeleteSign.jsp");
            model.addAttribute("admin",admin);
        }
        else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-connectez");
        }
         return service.authentif(admin);
    }
    @RequestMapping(value={"/signalementCorbeille"},method=RequestMethod.GET)
    public String corbeille(@RequestParam(name="token")String token,Model model,@RequestParam("id") String id)
    {
        Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            deleteSignalement(id);
            model.addAttribute("page", "listeSignalement");
            SignalementService ser=new SignalementService();
            int cc=ser.getCountSignalement()/3;
            int count=ser.getCountSignalement()%3;
            if(count!=0){
                cc=cc+1;
            }
            model.addAttribute("lim", cc);
            model.addAttribute("listeGlobale",ser.getSignalementGlobal(1));
            model.addAttribute("admin",admin);
        }
        else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-connectez");
        }
         return service.authentif(admin);
    }
    @RequestMapping(value={"/signalement"},method=RequestMethod.GET)
    public String fiche1(@RequestParam(name="token")String token,Model model,@RequestParam("id") String id,@RequestParam(name="nb")String photo)
    {
        Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            SignalementService serv=new SignalementService();
            Integer idd=new Integer(id);
            Integer p=new Integer(photo);
            SignalementValideView st=signTermine(id);
            int valide=0;
            if(st==null)
            {
                SignalementValideView sv=ifValide(idd.intValue());
                if(sv==null)
                {
                    model.addAttribute("serv",serv.getFicheSignalementNonValide(idd.intValue()));
                }
                else
                {
                    model.addAttribute("serv",sv);
                    valide=1;
                }
            }
        else
        {
                model.addAttribute("serv",st);
                valide=2;
        }
            RegionService chef=new RegionService();
            model.addAttribute("reg", chef.getAll());
            model.addAttribute("valide", valide);
            List<String> photos=serv.getPhotos(id);
           model.addAttribute("nb",photos.size());
           System.out.println(photos.size());
            model.addAttribute("photo", serv.getPhoto(id,photo));
        
            model.addAttribute("page", "fiche1.jsp");
            model.addAttribute("admin",admin);
        }
        else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-connectez");
        }
         return service.authentif(admin);
    }

    @RequestMapping(value={"/signalementRecherche"},method=RequestMethod.GET)
    public String Recherche(@RequestParam(name="token")String token,Model model,@RequestParam("d1") String date1,@RequestParam(name="d2")String date2)
    {
        Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            String page="listeSignalement.jsp";
            model.addAttribute("page",page);
            SignalementService ser=new SignalementService();
            model.addAttribute("listeGlobale",ser.getSignalementGlobalRecherche( date1, date2));
            model.addAttribute("admin",admin);
        }
        else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-connectez");
        }
         return service.authentif(admin);
    }

    @RequestMapping(value = { "/stat_Probleme" }, method = RequestMethod.GET)
    public String stat(@RequestParam(name="token")String token,Model model) {
        Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            String page="statisticBeProbleme.jsp";
            SignalementService ser=new SignalementService();
            List<StatRegion> rep=ser.getStatRegion();
            String data="";
            String d="";
            if(rep.size()>0)
            {
                data=rep.get(0).getNom();
                Integer i2=new Integer(rep.get(0).getNbr());
                String data2=i2.toString();
                 d=data2;
                if(rep.size()>1){
                    data=data+"\",";
                    d=d+"\",";
                }
                for(int i=1;i<rep.size()-1;i++){  
                    data=data+"\""+rep.get(i).getNom()+"\",";
                    Integer f=new Integer(rep.get(rep.size()-1).getNbr());
                    d=d+"\""+f.toString(i)+"\",";
                }
                if(rep.size()>1){
                    data=data+"\""+rep.get(rep.size()-1).getNom();
                    Integer f=new Integer(rep.get(rep.size()-1).getNbr());
                    d=d+"\""+f.toString();
                }
            }
            System.out.println(data);
            System.out.println(d);
            model.addAttribute("stat",data);
            model.addAttribute("stat2",d);
            model.addAttribute("page",page);
            model.addAttribute("admin",admin);
        }
        else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-connectez");
        }
         return service.authentif(admin);
    }
    @RequestMapping(value = { "/statDepenseDate" }, method = RequestMethod.GET)
    public String statDepense(@RequestParam(name="token")String token,Model model,@RequestParam("d1") String date1,@RequestParam(name="d2")String date2)
    {
        Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            String[] donnee=statDepenseRegionDate(date1,date2);
            System.out.println(donnee[0]+"  ///   "+donnee[1]);
            model.addAttribute("x", donnee[0]);
            model.addAttribute("y", donnee[1]);
            model.addAttribute("page", "statDepenseGraph.jsp");
            model.addAttribute("admin",admin);
        }
        else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-connectez");
        }
         return service.authentif(admin);
    }
    @RequestMapping(value = { "/statDepense" }, method = RequestMethod.GET)
    public String statDepense(@RequestParam(name="token")String token,Model model)
    {
        Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            String[] donnee=statDepenseRegion();
            System.out.println(donnee[0]+"  ///   "+donnee[1]);
            model.addAttribute("x", donnee[0]);
            model.addAttribute("y", donnee[1]);
            model.addAttribute("page", "statDepenseGraph.jsp");
            model.addAttribute("admin",admin);
        }
        else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-connectez");
        }
         return service.authentif(admin);
    }
    @RequestMapping(value = { "/stat_ProblemeRecherche" }, method = RequestMethod.GET)
    public String stat2(@RequestParam(name="token")String token,Model model,@RequestParam("d1") String date1,@RequestParam(name="d2")String date2) {
        Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            String page="statisticBeProbleme.jsp";
            SignalementService ser=new SignalementService();
            List<StatRegion> rep=ser.getStatRegionRecherche(date1,date2);
            String data="";
            String d="";
            if(rep.size()>0)
            {
                data=rep.get(0).getNom();
                Integer i2=new Integer(rep.get(0).getNbr());
                String data2=i2.toString();
                d=data2;
                if(rep.size()>1)
                {
                    data=data+"\",";
                    d=d+"\",";
                }
                for(int i=1;i<rep.size()-1;i++)
                {  
                    data=data+"\""+rep.get(i).getNom()+"\",";
                    Integer f=new Integer(rep.get(rep.size()-1).getNbr());
                    d=d+"\""+f.toString(i)+"\",";
                }
                if(rep.size()>1)
                {
                    data=data+"\""+rep.get(rep.size()-1).getNom();
                    Integer f=new Integer(rep.get(rep.size()-1).getNbr());
                    d=d+"\""+f.toString();
                }
            }
            System.out.println(data);
            System.out.println(d);
            model.addAttribute("stat",data);
            model.addAttribute("stat2",d);
            model.addAttribute("page",page);
            model.addAttribute("admin",admin);
        }
        else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-connectez");
        }
         return service.authentif(admin);
    }
    @RequestMapping(value = { "/statPerformanceDate" }, method = RequestMethod.GET)
    public String statPerf(@RequestParam(name="token")String token,Model model,@RequestParam("d1") String date1,@RequestParam(name="d2")String date2)
    {
        Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            String[] donnee=statPerformanceDate(date1,date2);
            System.out.println(donnee[0]+"  ///   "+donnee[1]);
            model.addAttribute("x", donnee[0]);
            model.addAttribute("y", donnee[1]);
            model.addAttribute("page", "statPerformance.jsp");
            model.addAttribute("admin",admin);
        }
        else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-connectez");
        }
         return service.authentif(admin);
    }
    @RequestMapping(value = { "/statPerformance" }, method = RequestMethod.GET)
    public String statPerf(@RequestParam(name="token")String token,Model model)
    {
        Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            String[] donnee=statPerformance();
            System.out.println(donnee[0]+"  ///   "+donnee[1]);
            model.addAttribute("x", donnee[0]);
            model.addAttribute("y", donnee[1]);
            model.addAttribute("page", "statPerformance.jsp");
            
            model.addAttribute("admin",admin);
        }
        else
        {
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-connectez");
        }
         return service.authentif(admin);
    }
    
}
