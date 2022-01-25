package com.example.Test.Controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Entity.*;
import Service.*;
import org.springframework.stereotype.Controller;
import com.google.gson.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RestController
@CrossOrigin(origins = "http://localhost:2004")

public class UtilisateurController extends UtilisateurService{

    @PostMapping ("/utilisateur/{nom}/{mdp}/{mail}")
    public String insert(@PathVariable("nom") String nom,@PathVariable("mdp") String mdp,@PathVariable("mail") String mail) {
        String test = "mety ny insertion";
        String non = "tsy tafiditra";
        UtilisateurService us = new UtilisateurService();
        int verif=us.getVerifMdp(mdp);
        if(us.test_misyArobaze(mail)==true && verif==1){
            Utilisateur util = new Utilisateur(0, nom, mdp, mail);
            util.insert();
            return test;
        }
        return non;   
        
    }
    @GetMapping ("/utilisateurs/{nom}/{mdp}")
    public String login(@PathVariable("nom") String nom,@PathVariable("mdp") String mdp)
    {
        Utilisateur u=getUtilisateur(nom, mdp);
        HashMap<String,Object> hash=new HashMap();
        if(u!=null)
        {
            hash.put("utilisateur",u);
            hash.put("token",token(nom, mdp));
        }
        else
        {
            hash.put("erreur", "mot de passe ou mail invalide");
        }
        Gson g=new Gson();
        return g.toJson(hash);
    }
    @GetMapping ("/tokenUtilisateur/{token}")
    public String token(@PathVariable(name="token")String token)
    {
        Utilisateur chef=verifToken(token);
        HashMap<String,Object> hash=new HashMap();
        if(chef==null)
        {
            hash.put("erreur",1);
        }
        else
        {
            hash.put("chef",chef);
        }
        Gson g=new Gson();
        return g.toJson(hash);
    }
    @DeleteMapping("/tokenUtilisateur/{token}")
    public String deco(@PathVariable(name="token")String token)
    {
        HashMap<String,Object> hash=new HashMap();
        hash.put("deco",0);
        Gson g=new Gson();
        deleteToken(token);
        return g.toJson(hash);
    }

    @GetMapping ("/utilisateurs/{mail}")
    public String login(@PathVariable("mail") String mail)
    {
        String lol = "test";
        UtilisateurService us = new UtilisateurService();
        System.out.println(us.test_misyArobaze(mail));
        return lol;
    }
}
