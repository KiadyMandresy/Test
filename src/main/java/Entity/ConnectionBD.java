package Entity;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionBD {
    
    public Connection getConnection()
    {
        Connection con=null;
        try{
            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://ec2-34-255-225-151.eu-west-1.compute.amazonaws.com:5432/dbcncf16cfm072";
            String user = "ocvjbxjbojswhc";
            String pass="6ae926723aa756a690db2c0f40e82821527714e60f7cd067fced8872e74976ba";
            con = DriverManager.getConnection(dbURL, user, pass);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return con;
    }

    public ConnectionBD(){

    }
}
