package com.example.Test.Controller;
import java.util.ArrayList;
import java.util.List;

import Entity.Personne;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.*;

@Controller
public class PersonneController {
    
    public List<Personne> getAll(){
        List<Personne> rep=new ArrayList<>();
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/rojoFinal", "root", "root");
            PreparedStatement st=con.prepareStatement("SELECT*FROM Personne");
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
    public String view(Model model) {

        //model.addAttribute("personnes", this.getAll());

        return "templateAdmin";
    }
    @RequestMapping(value = { "assets/css/{page}" }, method = RequestMethod.GET)
    public String viewC(@PathVariable("page") String css,Model model) {

        //model.addAttribute("personnes", this.getAll());

        return "assets/js/"+css;
    }
     @RequestMapping(value = { "assets/js/{page}" }, method = RequestMethod.GET)
    public String viewJ(@PathVariable("page") String css,Model model) {

        //model.addAttribute("personnes", this.getAll());

        return "assets/js/"+css;
    }
}
