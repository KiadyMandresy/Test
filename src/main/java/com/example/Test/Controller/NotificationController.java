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
@CrossOrigin(origins = "http://https://test-rojo.herokuapp.com")
public class NotificationController extends NotificationsService{

    @GetMapping("/notifications/{idUtil}")
    public String Recherche(@PathVariable("idUtil") String idUtil)
    {
        HashMap rep=new HashMap<>();
        NotificationsService ser=new NotificationsService();
        Gson g=new Gson();
        rep.put("liste_notification",ser.getListNotification(idUtil));
        String r=g.toJson(rep);
        return r;
    }    

    @DeleteMapping("/notification/{id}")
    public void delete(@PathVariable("id") String id){
        String val = "delete mety tsara ";
        Notification not = new Notification();
        not.delete(id);
    }
}