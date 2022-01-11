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

public class WebServiceMobile {
    
    @GetMapping("/signalementUtilisateurEnCours/{nom}/{lim}")
    public String listeSingEnCours(@PathVariable("nom") String nom,@PathVariable("lim") String lim)
    {
        HashMap rep=new HashMap<>();
        SignalementService ser=new SignalementService();
        int cc=ser.countGetSignUtil(nom)/3;
        int count=ser.countGetSignUtil(nom)%3;
        if(count!=0){
            cc=cc+1;
        }
        Integer i=new Integer(lim);
        int ii=i.intValue();
        rep.put("lim", cc);
        Gson g=new Gson();
        rep.put("lise_Signalement",ser.getSignPersonneEnCours(nom,ii));
        String r=g.toJson(rep);
        return r;
    }

    @GetMapping("/signalementUtilsateurTermine/{nom}/{lim}")
    public String ListeSignTermine(@PathVariable("nom") String nom,@PathVariable("lim") String lim)
    {
        HashMap rep=new HashMap<>();
        SignalementService ser=new SignalementService();
        int cc=ser.countGetSignUtil2(nom)/3;
        int count=ser.countGetSignUtil2(nom)%3;
        if(count!=0){
            cc=cc+1;
        }
        Integer i=new Integer(lim);
        int ii=i.intValue();
        rep.put("lim", cc);
        Gson g=new Gson();
        rep.put("lise_Signalement",ser.getSignPersonneTerminer(nom,ii));
        String r=g.toJson(rep);
        return r;
    }
}
