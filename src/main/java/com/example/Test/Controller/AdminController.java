package com.example.Test.Controller;
import java.util.ArrayList;
import java.util.List;
import Service.*;
import Entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@Controller
public class AdminController extends AdminService{
    @RequestMapping(value={"/","/loginBack"}, method = RequestMethod.GET)
    public String loginPage()
    {
        return "login";
    }
    @RequestMapping(value={"/erreurAuthentification"}, method = RequestMethod.GET)
    public String erreur(Model model)
    {
        model.addAttribute("erreur", "Erreur d'authentification");
        return "login";
    }
    @RequestMapping(value={"/login"}, method = RequestMethod.POST)
    public String login(Model model,@RequestParam(name="mdp")String mdp,@RequestParam(name="mail")String mail)
    {
        String admin=token(mail,mdp);
        String p="login";
        if(admin!=null)
        {
            String page="listeSignalement.jsp";
            model.addAttribute("page",page);
            SignalementService ser=new SignalementService();
            int cc=ser.getCountSignalement()/3;
            int count=ser.getCountSignalement()%3;
            if(count!=0){
                cc=cc+1;
            }
            model.addAttribute("token",admin);
            model.addAttribute("local",1);
            Integer i=new Integer(1);
            int ii=i.intValue();
            model.addAttribute("lim", cc);
            model.addAttribute("listeGlobale",ser.getSignalementGlobal(ii));
            p="templateAdmin";
        }
        else
        {
            model.addAttribute("erreur", "Mot de passe ou mail invalide");
        }
       
        return p;
    }
}
