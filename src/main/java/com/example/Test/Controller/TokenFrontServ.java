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
public class TokenFrontServ {
    @Autowired
    private TokenFrontDAO repo;
    
    public ChefRegion verifToken(String token)
    {
        ChefRegion a=null;
        Timestamp t=new Timestamp(System.currentTimeMillis());
        Date dt=new Date(t.getTime());
        List<TokenFront> tk=repo.findByTokenAndDateExpireGreaterThan(token,dt);
        if(tk.size()>0)
        {
            TokenFront tkk=tk.get(0);
            System.out.println(tkk.getIdFront());
            Integer id=new Integer(tkk.getIdFront());
            ChefRegion ad=new ChefRegion(id.intValue(),tkk.getNom(),tkk.getMdp(),tkk.getMail(),tkk.getIdReg());
            a=ad;
        }
        return a;
    }
    public void deleteToken(String token)
    {
        this.repo.deleteByToken(token);
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
