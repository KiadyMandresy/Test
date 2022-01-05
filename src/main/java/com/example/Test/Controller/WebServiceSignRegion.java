package com.example.Test.Controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Entity.*;
import Service.*;
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
@CrossOrigin(origins = "http://localhost:2004")

public class WebServiceSignRegion {
    
    @GetMapping("/signalementRegion/{nom}")
    public String Recherche(@PathVariable("nom") String nom)
    {
        HashMap rep=new HashMap<>();
        RegionService ser=new RegionService();
        Gson g=new Gson();
        rep.put("lise_Region",ser.getSignRegion(nom));
        String r=g.toJson(rep);
        return r;
    }
}
