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

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://test-rojo.herokuapp.com")
public class WebServiceMobile {
    
    @GetMapping("/signalementUtilisateurEnCours/{nom}")
    public String listeSingEnCours(@PathVariable("nom") String nom)
    {
        HashMap rep=new HashMap<>();
        SignalementService ser=new SignalementService();
        Gson g=new Gson();
        rep.put("lise_Signalement",ser.getSignPersonneEnCours(nom));
        String r=g.toJson(rep);
        return r;
    }
    
    @GetMapping("/signalementUtilsateurTermine/{nom}")
    public String ListeSignTermine(@PathVariable("nom") String nom)
    {
        HashMap rep=new HashMap<>();
        SignalementService ser=new SignalementService();
        Gson g=new Gson();
        rep.put("liste_Signalement",ser.getSignPersonneTerminer(nom));
        String r=g.toJson(rep);
        return r;
    }

    @GetMapping("/signalementUtilsateurNonValide/{nom}")
    public String ListeSignNonValide(@PathVariable("nom") String nom)
    {
        HashMap rep=new HashMap<>();
        SignalementService ser=new SignalementService();
        Gson g=new Gson();
        rep.put("liste_Signalement",ser.getSignPersonneNonValide(nom));
        String r=g.toJson(rep);
        return r;
    }
    @GetMapping("/signalement/details/{id}")
    public String ListeSign(@PathVariable("id") String nom)
    {
        Gson g=new Gson();
        SignalementService ser=new SignalementService();
        List<String> ph=ser.getPhotos(nom);
        return g.toJson(ph);
    }


}

