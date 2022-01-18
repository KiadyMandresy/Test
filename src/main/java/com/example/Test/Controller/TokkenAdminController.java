package com.example.Test.Controller;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import Entity.*;
import Service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import com.google.gson.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@RestController
@EnableMongoRepositories(basePackageClasses =TokkenAdminDAO.class)
public class TokkenAdminController {
    
    @Autowired
    private TokkenAdminDAO repo;

    @GetMapping("/tokkenAdmin")
    public String getTokken() {
       /* HashMap rep=new HashMap<>();
        List<TokkenAdmin> employe = repo.findAll();
        rep.put("liste_Tokken",employe);
        Gson g=new Gson();
        String r=g.toJson(rep);*/
        return "hihi";
    }
    @GetMapping("/tokken/{token}")
    public Admin getToken(@PathVariable("token") String t) {
        AdminService ad=new AdminService();
        Admin a=verifToken(t);
        return a;
    }
    public Admin verifToken(String token)
    {
        Admin a=null;
        Timestamp t=new Timestamp(System.currentTimeMillis());
        Date dt=new Date(t.getTime());
        List<TokkenAdmin> tk=repo.findByTokkenAndDateExpireGreaterThan(token,dt);
        if(tk.size()>0)
        {
            TokkenAdmin tkk=tk.get(0);
            System.out.println(tkk.getIdAdmin());
            Integer id=new Integer(tkk.getIdAdmin());
            Admin ad=new Admin(id.intValue(),tkk.getNom(),tkk.getMdp(),tkk.getMail());
            a=ad;
        }
        return a;
    }
    public void deleteToken(String token)
    {
        this.repo.deleteByTokken(token);
    }
    public String authentif(Admin a)
    {
        String page="login";
        if(a!=null)
        {
            page="templateAdmin";
        }
        return page;
    }
}
