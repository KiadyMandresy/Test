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
public class WebServiceChefRegion extends ChefRegionService {
    @GetMapping ("/chefRegions/{nom}/{mdp}")
    public String login(@PathVariable("nom") String nom,@PathVariable("mdp") String mdp)
    {
        ChefRegion u=getChefRegion(nom, mdp);
        Gson g=new Gson();
        return g.toJson(u);
    }
}
