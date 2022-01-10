package com.example.Test.Controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Entity.*;
import Service.*;
import org.springframework.stereotype.Controller;
import com.google.gson.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RestController
@CrossOrigin(origins = "http://localhost:2004")

public class UtilisateurController {

    @PostMapping ("/utilisateur/{nom}/{mdp}/{mail}")
    public String insert(@PathVariable("nom") String nom,@PathVariable("mdp") String mdp,@PathVariable("mail") String mail) {
        String test = "tokony mety";
        Utilisateur util = new Utilisateur(0, nom, mdp, mail);
        util.insert();
        return test;
    }
}
