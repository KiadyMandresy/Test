package Service;
import Entity.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
public class AdminService extends Admin{
    public Admin getAdmin(String mail,String mdp)
    {
        String req="select * from Admin where (nom='"+mail+"' or mail='"+mail+"') and mdp='"+mdp+"'";
        System.out.println(req);
        Admin a=null;
        List<Admin> list=select(req);
        if(list.size()>0)
        {
            a=list.get(0);
        }
        return a;
    }
}
