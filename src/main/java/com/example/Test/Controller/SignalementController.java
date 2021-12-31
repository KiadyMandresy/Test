package com.example.Test.Controller;
import java.util.ArrayList;
import java.util.List;
import Entity.*;
import Service.*;
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
    
    @RequestMapping(value = { "/listeSignalement" }, method = RequestMethod.GET)
    public String view(Model model,@RequestParam(name="lim")String l) {
        String page="listeSignalement.jsp";
        //qsqs
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
        return "templateAdmin";
    }
    
    @RequestMapping(value={"/signalementValide"},method=RequestMethod.GET)
    public String valide(Model model,@RequestParam("id") String id,@RequestParam(name="region")String reg)
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
        return "templateAdmin";
    }
    @RequestMapping(value={"/deleteSignalamentConf"},method=RequestMethod.GET)
    public String confDelete(Model model,@RequestParam("id") String id)
    {
        model.addAttribute("id", id);
        model.addAttribute("page", "confirmDeleteSign.jsp");
        return "templateAdmin";
    }
    @RequestMapping(value={"/signalementCorbeille"},method=RequestMethod.GET)
    public String corbeille(Model model,@RequestParam("id") String id)
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
        return "templateAdmin";
    }
    @RequestMapping(value={"/signalement"},method=RequestMethod.GET)
    public String fiche1(Model model,@RequestParam("id") String id,@RequestParam(name="nb")String photo)
    {
        SignalementService serv=new SignalementService();
        Integer idd=new Integer(id);
        Integer p=new Integer(photo);
        SignalementValideView sv=ifValide(idd.intValue());
        int valide=0;
        if(sv==null)
        {
            model.addAttribute("serv",serv.getFicheSignalementNonValide(idd.intValue()));
        }
        else
        {
            model.addAttribute("serv",sv);
            valide=1;
        }
        RegionService chef=new RegionService();
        model.addAttribute("reg", chef.getAll());
        model.addAttribute("valide", valide);
        model.addAttribute("countPhoto", serv.countPhotoSignalement(idd.intValue()));
        model.addAttribute("photo", serv.getPhoto(p.intValue(), idd.intValue()));
      
        model.addAttribute("page", "fiche1.jsp");
        return "templateAdmin";
    }

    @RequestMapping(value={"/signalementRecherche"},method=RequestMethod.GET)
    public String Recherche(Model model,@RequestParam("d1") String date1,@RequestParam(name="d2")String date2)
    {
        String page="listeSignalement.jsp";
        model.addAttribute("page",page);
        SignalementService ser=new SignalementService();
        model.addAttribute("listeGlobale",ser.getSignalementGlobalRecherche( date1, date2));
        return "templateAdmin";
    }

    @RequestMapping(value = { "/stat_Probleme" }, method = RequestMethod.GET)
    public String stat(Model model) {
        String page="statisticBeProbleme.jsp";
        SignalementService ser=new SignalementService();
        List<StatRegion> rep=ser.getStatRegion();
        String data=rep.get(0).getNom();
        Integer i2=new Integer(rep.get(0).getNbr());
        String data2=i2.toString();
        String d=data2;
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
        System.out.println(data);
        System.out.println(d);
        model.addAttribute("stat",data);
        model.addAttribute("stat2",d);
        model.addAttribute("page",page);
        return "templateAdmin";
    }
    @RequestMapping(value = { "/statDepenseDate" }, method = RequestMethod.GET)
    public String statDepense(Model model,@RequestParam("d1") String date1,@RequestParam(name="d2")String date2)
    {
        String[] donnee=statDepenseRegionDate(date1,date2);
        model.addAttribute("x", donnee[0]);
        model.addAttribute("y", donnee[1]);
        model.addAttribute("page", "statDepenseGraph");
        return "templateAdmin";
    }
    @RequestMapping(value = { "/statDepense" }, method = RequestMethod.GET)
    public String statDepense(Model model)
    {
        String[] donnee=statDepenseRegion();
        model.addAttribute("x", donnee[0]);
        model.addAttribute("y", donnee[1]);
        model.addAttribute("page", "statDepenseGraph");
        return "templateAdmin";
    }
    @RequestMapping(value = { "/stat_ProblemeRecherche" }, method = RequestMethod.GET)
    public String stat2(Model model,@RequestParam("d1") String date1,@RequestParam(name="d2")String date2) {
        String page="statisticBeProbleme.jsp";
        SignalementService ser=new SignalementService();
        List<StatRegion> rep=ser.getStatRegionRecherche(date1,date2);
        String data=rep.get(0).getNom();
        Integer i2=new Integer(rep.get(0).getNbr());
        String data2=i2.toString();
        String d=data2;
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
        System.out.println(data);
        System.out.println(d);
        model.addAttribute("stat",data);
        model.addAttribute("stat2",d);
        model.addAttribute("page",page);
        return "templateAdmin";
    }

    
}
