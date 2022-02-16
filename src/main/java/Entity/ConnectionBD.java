package Entity;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionBD {
    
    public Connection getConnection()
    {
        Connection con=null;
        try{
            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://ec2-52-30-133-191.eu-west-1.compute.amazonaws.com:5432/d624m7uu66qipf";
            String user = "fqmwbfirynqsur";
            String pass="75b02377c3126d9941e16ec2a5b9d99daea9f6a95d11c734eca0059fdfd18d52";
            
            con = DriverManager.getConnection(dbURL, user, pass);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return con;
    }

    public ConnectionBD(){

    }
}
