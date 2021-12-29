package com.example.Test.Controller;
import java.util.ArrayList;
import java.util.List;
import Entity.*;
import Service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignalementController {
    
    @RequestMapping(value = { "/listeSignalement" }, method = RequestMethod.GET)
    public String view(Model model,@RequestParam(name="lim")String l) {
        String page="listeSignalement.jsp";
        //qsqs
        model.addAttribute("page",page);
        SignalementService ser=new SignalementService();
        int cc=ser.getCountSignalement()/3;
        int count=ser.getCountSignalement()%3;
        if(count!=0){
            cc=cc+1;
        }
        Integer i=new Integer(l);
        int ii=i.intValue();
        model.addAttribute("lim", cc);
        model.addAttribute("listeGlobale",ser.getSignalementGlobal(ii));
        return "templateAdmin";
    }
    @RequestMapping(value={"/signalement"},method=RequestMethod.GET)
    public String fiche1(Model model,@RequestParam("id") String id,@RequestParam(name="nb")String photo)
    {
        SignalementService serv=new SignalementService();
        Integer idd=new Integer(id);
        Integer p=new Integer(photo);
        model.addAttribute("countPhoto", serv.countPhotoSignalement(idd.intValue()));
        model.addAttribute("photo", serv.getPhoto(p.intValue(), idd.intValue()));
        model.addAttribute("serv",serv.getFicheSignalementNonValide(idd.intValue()));
        model.addAttribute("page", "fiche1.jsp");
        return "templateAdmin";
    }
    
}
