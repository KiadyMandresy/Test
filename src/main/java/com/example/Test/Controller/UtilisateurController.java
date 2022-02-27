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
@CrossOrigin(origins = "http://test-rojo.herokuapp.com")

public class UtilisateurController extends UtilisateurService{

    @PostMapping ("/utilisateurs/{nom}/{mdp}/{mail}")
    public String insert(@PathVariable("nom") String nom,@PathVariable("mdp") String mdp,@PathVariable("mail") String mail) {
        String test = "mety ny insertion";
        String non = "tsy tafiditra";
        HashMap<String,Object> hash=new HashMap();
        UtilisateurService us = new UtilisateurService();
        int verif=us.getVerifMdp(mdp);
        if(us.test_misyArobaze(mail)==true && verif==0){
            Utilisateur util = new Utilisateur(0, nom, mdp, mail);
            util.insert();
            hash.put("valide",0);
        }
        else if(us.test_misyArobaze(mail)==false && verif!=0)
        {
            hash.put("valide",1);
            hash.put("erreur","Mot de passe invalide et mail inexistant");
        }
        else if(verif!=0 && us.test_misyArobaze(mail)==true)
        {
            hash.put("valide",1);
            if(verif==1)
            {
                hash.put("erreur","Le mot de passe doit contenir 8 caracteres ");
            }
            else if(verif==-1)
            {
                hash.put("erreur","Le mot de passe doit contenir 8 caracteres et ne doit pas contenir des caracteres avec accents ");
            }
            else
            {
                hash.put("erreur","Le mot de passe ne doit pas contenir des caracteres avec accents ");
            }
           // hash.put("message"," ")
        }
        else if(us.test_misyArobaze(mail)==false && verif==0)
        {
            hash.put("erreur","Votre email est invalide");
        }
        Gson g=new Gson();
        return g.toJson(hash); 
        
    }
    @GetMapping ("/utilisateurs/{nom}/{mdp}")
    public String login(@PathVariable("nom") String nom,@PathVariable("mdp") String mdp)
    {
        Utilisateur u=getUtilisateur(nom, mdp);
        HashMap<String,Object> hash=new HashMap();
        if(u!=null)
        {
            hash.put("utilisateur",u);
            hash.put("valide",true);
            hash.put("token",token(nom,mdp));
        }
        else
        {
            hash.put("erreur", "mot de passe ou mail invalide");
            hash.put("valide",false);
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
            hash.put("token",false);
        }
        else
        {
            hash.put("token",true);
            hash.put("ut",chef);
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
