package com.example.Test.Controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Entity.*;
import Service.*;
import org.springframework.stereotype.Controller;
import com.google.gson.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:2004")

public class WebServiceSignRegion extends SignalementService{
    
    @GetMapping("/signalements/{type}/{date1}/{date2}/{statut}/{region}")
    public String RechercheAvance(@PathVariable("type") String type,@PathVariable("date1") String date1,@PathVariable("date2") String date2,@PathVariable("statut") String statut,@PathVariable("region") String region)
    {
        HashMap<String,Object> rep=new HashMap();
        rep.put("resultat",rechercheAvance(date1,date2,type,statut,region));
        Gson g=new Gson();
        return g.toJson(rep);

    }
    @GetMapping("/signalementRegion/{nom}/{lim}")
    public String Recherche(@PathVariable("nom") String nom,@PathVariable("lim") String lim)
    {
        HashMap rep=new HashMap<>();
        RegionService ser=new RegionService();
        int cc=ser.countGetSignReg(nom)/3;
        int count=ser.countGetSignReg(nom)%3;
        if(count!=0){
            cc=cc+1;
        }
        Integer i=new Integer(lim);
        int ii=i.intValue();
        rep.put("lim", cc);
        Gson g=new Gson();
        rep.put("lise_Region",ser.getSignRegion(nom,ii));
        String r=g.toJson(rep);
        return r;
    }
    @GetMapping("/signalements/{id}/{nb}")
    public String fiche(@PathVariable("id") String id,@PathVariable("nb") String photo)
    {
        SignalementService serv=new SignalementService();
        Integer idd=new Integer(id);
        Integer p=new Integer(photo);
        SignalementValideView st=signTermine(id);
        HashMap<String,Object> rep=new HashMap<>();
        int valide=0;
        if(st==null)
        {
            SignalementValideView sv=ifValide(idd.intValue());
            rep.put("serv",serv.getFicheSignalementNonValide(idd.intValue()));
        }
       else
       {
            rep.put("serv",st);
            valide=2;
       }
        RegionService chef=new RegionService();
        rep.put("valide", valide);
        rep.put("countPhoto", serv.countPhotoSignalement(idd.intValue()));
        rep.put("photo", serv.getPhoto(p.intValue(), idd.intValue()));
        Gson g=new Gson();
        String r=g.toJson(rep);
        return r;
    }
    @PostMapping("/signalementTermine/{id}/{budget}")
    public void signalementT(@PathVariable("id") String id,@PathVariable("budget") String budget)
    {
        signalementTermine(id,budget);
    }
}
