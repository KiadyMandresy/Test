package com.example.Test.Controller;
import java.util.ArrayList;
import java.util.List;
import Service.*;
import Entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@Controller
public class AdminController {
    @RequestMapping(value = { "/insertionChefRegion" }, method = RequestMethod.GET)
    public String insert(Model model) {
        String page="insertChefRegion.jsp";
        model.addAttribute("page",page);
        RegionService r=new RegionService();
        model.addAttribute("regions",r.getAll());
        return "templateAdmin";
    }
    @RequestMapping(value = { "/ajoutChef" }, method = RequestMethod.GET)
    public String insert2(@RequestParam(name="nom")String nom,@RequestParam(name="mail")String mail,@RequestParam(name="mdp")String mdp,@RequestParam(name="region")String region,Model model) {
        String page="insertChefRegion.jsp";
        RegionService r=new RegionService();
        ChefRegionService chef=new ChefRegionService();
        chef.insertChefRegion(nom, mdp, mail, region);
        model.addAttribute("regions",r.getAll());
        model.addAttribute("page",page);
        return "templateAdmin";
    }
}
