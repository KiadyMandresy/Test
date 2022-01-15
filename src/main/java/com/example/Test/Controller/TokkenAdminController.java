package com.example.Test.Controller;
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
    private AdminService admin;

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
        Admin a=admin.verifToken(t);
        return a;
    }
   
}
