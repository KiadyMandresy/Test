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
public class RegionController {
    @Autowired
    TokkenAdminController service;
    @RequestMapping(value = { "/listeRegion" }, method = RequestMethod.GET)
    public String view(Model model,@RequestParam(name="lim")String l,@RequestParam(name="token")String token) {
        Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            RegionService rs=new RegionService();
            int cc=rs.countRegion()/3;
            int count=rs.countRegion()%3;
            if(count!=0){
                cc=cc+1;
            }
            System.out.println("dsdsd"+cc);
            Integer i=new Integer(l);
            int ii=i.intValue();
            model.addAttribute("lim", cc);
            String page="crudRegion.jsp";
            model.addAttribute("page",page);
            model.addAttribute("listeRegion",rs.getRegion(ii));
            model.addAttribute("admin",admin);
        }
          else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-connectez");
        }
        return service.authentif(admin);
    }

    @RequestMapping(value = { "/modificationRegion" }, method = RequestMethod.GET)
    public String view2(Model model,@RequestParam(name="id")String id,@RequestParam(name="nom")String nom,@RequestParam(name="lim")String l,@RequestParam(name="token")String token) {
          Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            String page="updateRegion.jsp";
            model.addAttribute("page",page);
            Integer i=new Integer(id);
            Region r=new Region(i.intValue(),nom);
            model.addAttribute("region1",r);
            model.addAttribute("lim",l);
            model.addAttribute("admin",admin);
        }
          else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-connectez");
        }
        return service.authentif(admin);
    }

    @RequestMapping(value = { "/modificationRegionVrai" }, method = RequestMethod.GET)
    public String view3(Model model,@RequestParam(name="id")String id,@RequestParam(name="nom")String nom,@RequestParam(name="lim")String l,@RequestParam(name="token")String token) {
          Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            String page="crudRegion.jsp";
            model.addAttribute("page",page);
            RegionService rs=new RegionService();
            rs.updateRegion(id, nom);
            int cc=rs.countRegion()/3;
            int count=rs.countRegion()%3;
            if(count!=0){
                cc=cc+1;
            }
            Integer i=new Integer(l);
            int ii=i.intValue();
            model.addAttribute("lim", cc);
            model.addAttribute("page",page);
            model.addAttribute("listeRegion",rs.getRegion(ii));
            model.addAttribute("admin",admin);
        }
          else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-connectez");
        }
        return service.authentif(admin);
    }

    @RequestMapping(value = { "/insertRegion" }, method = RequestMethod.GET)
    public String view4(Model model,@RequestParam(name="nom")String nom,@RequestParam(name="token")String token) {
          Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            String page="insertRegion.jsp";
            model.addAttribute("page",page);
            RegionService rs=new RegionService();
            rs.insertRegion(nom);
            model.addAttribute("page",page);
            model.addAttribute("admin",admin);
        }
          else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-connectez");
        }
        return service.authentif(admin);
    }

    @RequestMapping(value = { "/insertRegion1" }, method = RequestMethod.GET)
    public String view5(Model model,@RequestParam(name="token")String token) {
          Admin admin=service.verifToken(token);
        if(admin!=null)
        {
            String page="insertRegion.jsp";
            model.addAttribute("page",page);
            model.addAttribute("admin",admin);
        }
          else{
            model.addAttribute("erreur", "Erreur d'authentification, veuillez vous-connectez");
        }
        return service.authentif(admin);
    }
    
}
