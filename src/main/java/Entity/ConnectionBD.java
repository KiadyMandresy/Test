package Entity;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionBD {
    
    public Connection getConnection()
    {
        Connection con=null;
        try{
            Class.forName("org.postgresql.Driver");
            String dbURL = "=postgres://eoachhsokrigti:72fda7a47790d34124da0be6e4d1f8efd31623feecbd327651dbf820c61b6a0e@ec2-54-220-243-77.eu-west-1.compute.amazonaws.com:5432/dcjcs7q252ejoq";
            String user = "eoachhsokrigti";
            String pass="72fda7a47790d34124da0be6e4d1f8efd31623feecbd327651dbf820c61b6a0e";
            
       
            con = DriverManager.getConnection(dbURL, user, pass);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return con;
    }

    public ConnectionBD(){

    }
}
