package Entity;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionBD {
    
    public Connection getConnection()
    {
        Connection con=null;
        try{
            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://localhost:5432/final";
            String user = "postgres";
            String pass="kalisi61";
            con = DriverManager.getConnection(dbURL, user, pass);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return con;
    }

    public ConnectionBD(){

    }
}
