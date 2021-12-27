package com.example.Test.Controller;
import java.util.ArrayList;
import java.util.List;

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
public class PersonneController {
    
    public List<Personne> getAll(){
        List<Personne> rep=new ArrayList<>();
        ConnectionBD co=new ConnectionBD();
        try{
            
            PreparedStatement st=co.getConnection().prepareStatement("SELECT*FROM ChefRegion");
            ResultSet res=st.executeQuery();
            while(res.next()){
                int id=res.getInt("id");
                String nom=res.getString("nom");
                Personne p=new Personne(id,nom);
                rep.add(p);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        String message = "Hello Spring Boot + JSP";

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = { "/listePersonne" }, method = RequestMethod.GET)
    public String viewPersonList(Model model) {

        model.addAttribute("personnes", this.getAll());

        return "listePersonne";
    }
    @RequestMapping(value = { "/template" }, method = RequestMethod.GET)

    public String view(@RequestParam(name="page")String page,Model model) {
        page="essai.jsp";
        model.addAttribute("page",page);
        return "templateAdmin";
    }
    
}
