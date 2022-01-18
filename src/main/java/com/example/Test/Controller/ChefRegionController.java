package com.example.Test.Controller;
import java.util.ArrayList;
import java.util.List;
import Service.*;
import Entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@Controller
public class ChefRegionController extends ChefRegionService{
    @Autowired
    private TokkenAdminController service;
    @RequestMapping(value={"/updatePageChefRegion"}, method = RequestMethod.GET)
    public String updateChef1(@RequestParam(name="id")String id,@RequestParam(name="nom")String nom,@RequestParam(name="mail")String mail,@RequestParam(name="mdp")String mdp,@RequestParam(name="token")String token,@RequestParam(name="region")String region,@RequestParam(name="lim")String lim,Model model)
    {
        Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            RegionService r=new RegionService();
            model.addAttribute("regions",r.getAll());     
            Integer idd=new Integer(id);
            ChefRegion chef=new ChefRegion(idd.intValue(),nom,mdp,mail,0);
            model.addAttribute("chef", chef);
            model.addAttribute("page","updateChef.jsp");
            model.addAttribute("lim", lim);
        }
        else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-conntez");
        }
        return service.authentif(admin);
    }
    @RequestMapping(value={"/updateChefRegion"}, method = RequestMethod.GET)
    public String updateChef(@RequestParam(name="token")String token,@RequestParam(name="id")String id,@RequestParam(name="nom")String nom,@RequestParam(name="mail")String mail,@RequestParam(name="mdp")String mdp,@RequestParam(name="region")String region,@RequestParam(name="lim")String lim,Model model)
    {
        Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            updateChef(id, nom, mdp, mail, region);
            model.addAttribute("page","chefRegions.jsp");
            model.addAttribute("listes", getListeChef(lim));
            model.addAttribute("pagination", paginationChefRegion());
            model.addAttribute("lim", lim);
        }
        else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-conntez");
        }
        return service.authentif(admin);
    }
    @RequestMapping(value={"/confirmationDeleteChefRegion"}, method = RequestMethod.GET)
    public String deleteChef1(@RequestParam(name="id")String id,@RequestParam(name="token")String token,@RequestParam(name="lim")String lim,Model model)
    {
        Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            model.addAttribute("page","confirmDeleteChef.jsp");
            model.addAttribute("lim", lim);
            model.addAttribute("id", id);
        }
        else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-conntez");
        }
        return service.authentif(admin);
    }
    @RequestMapping(value={"/deleteChefRegion"}, method = RequestMethod.GET)
    public String deleteChef(@RequestParam(name="id")String id,@RequestParam(name="lim")String lim,Model model,@RequestParam(name="token")String token)
    {
        Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            delete(id);
            model.addAttribute("page","chefRegions.jsp");
            model.addAttribute("listes", getListeChef(lim));
            model.addAttribute("pagination", paginationChefRegion());
            model.addAttribute("lim", lim);

        }
        else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-conntez");
        }
        return service.authentif(admin);
    }
    @RequestMapping(value={"/ChefRegions"}, method = RequestMethod.GET)
    public String listeChef(Model model,@RequestParam(name="lim")String lim,@RequestParam(name="token")String token)
    {
        Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            model.addAttribute("page","chefRegions.jsp");
            model.addAttribute("listes", getListeChef(lim));
            model.addAttribute("pagination", paginationChefRegion());
            model.addAttribute("lim", lim);
        }
        else
        {
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-conntez");
        }
        return service.authentif(admin);
    }
    @RequestMapping(value = { "/insertionChefRegion" }, method = RequestMethod.GET)
    public String insert(Model model,@RequestParam(name="token")String token) {
     
        Admin admin=service.verifToken(token); 
        if(admin!=null)
        {  
            String page="insertChefRegion.jsp";
            model.addAttribute("page",page);
            RegionService r=new RegionService();
            model.addAttribute("regions",r.getAll());
        }
        else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-conntez");
        }
        return service.authentif(admin);
    }
    @RequestMapping(value = { "/ajoutChef" }, method = RequestMethod.GET)
    public String insert2(@RequestParam(name="nom")String nom,@RequestParam(name="token")String token,@RequestParam(name="mail")String mail,@RequestParam(name="mdp")String mdp,@RequestParam(name="region")String region,Model model) {
     
        Admin admin=service.verifToken(token); 
        if(admin!=null)
        {
            String page="insertChefRegion.jsp";
            RegionService r=new RegionService();
            ChefRegionService chef=new ChefRegionService();
            chef.insertChefRegion(nom, mdp, mail, region);
            model.addAttribute("regions",r.getAll());
            model.addAttribute("page",page);
        }
        else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-conntez");
        }
        return service.authentif(admin);
    }
}
