package Entity;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectioBD {
    
    public Connection getConnection(){
        Connection con=null;
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost/Nick", "root", "root");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return con;
    }

    public ConnectioBD(){

    }
}
