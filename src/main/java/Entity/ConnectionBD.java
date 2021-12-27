package Entity;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionBD {
    
    public Connection getConnection(){
        Connection con=null;
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost/rojoFinal", "root", "root");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return con;
    }

    public ConnectionBD(){

    }
}
