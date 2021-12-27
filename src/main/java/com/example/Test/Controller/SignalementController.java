package com.example.Test.Controller;
import java.util.ArrayList;
import java.util.List;
import Entity.*;
import Service.SignalementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


@Controller
public class SignalementController {
    
    @RequestMapping(value = { "/listeSignalement" }, method = RequestMethod.GET)
    public String view(Model model) {
        String page="listeSignalement.jsp";
        //qsqs
        model.addAttribute("page",page);
        SignalementService ser=new SignalementService();
        model.addAttribute("listeGlobale",ser.getSignalementGlobal());
        return "templateAdmin";
    }
    
    
}
