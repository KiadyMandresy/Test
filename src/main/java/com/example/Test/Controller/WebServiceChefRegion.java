package com.example.Test.Controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Entity.*;
import Service.*;

import org.springframework.beans.factory.annotation.Autowired;
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
public class WebServiceChefRegion extends ChefRegionService {
    @Autowired
    private TokenFrontServ service;
    @GetMapping ("/chefRegions/{nom}/{mdp}")
    public String login(@PathVariable("nom") String nom,@PathVariable("mdp") String mdp)
    {
        ChefRegion u=getChefRegion(nom, mdp);
        HashMap<String,Object> hash=new HashMap();
        if(u!=null)
        {
            hash.put("valide",true);
            hash.put("token",token(nom, mdp));
            hash.put("chef",u);
        }
        else
        {
            hash.put("valide",false);
           
            hash.put("erreur", "mot de passe ou mail invalide");

        }
        Gson g=new Gson();
        return g.toJson(hash);
    }
    @GetMapping ("/token/{token}")
    public String token(@PathVariable(name="token")String token)
    {
        ChefRegion chef=service.verifToken(token);
        SignalementService sv=new SignalementService();
        HashMap<String,Object> hash=new HashMap();
        if(chef==null)
        {
            hash.put("erreur",1);
        }
        else
        {
            hash.put("region",sv.nomReg(chef.getIdReg()));
            hash.put("chef",chef);
            hash.put("erreur",0);
        }
        Gson g=new Gson();
        return g.toJson(hash);
    }
    @DeleteMapping("/tokenFront/{token}")
    public String deco(@PathVariable(name="token")String token)
    {
        HashMap<String,Object> hash=new HashMap();
        hash.put("deco",0);
        Gson g=new Gson();
        deleteToken(token);
        return g.toJson(hash);
    }
}
