package Entity;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionBD {
    
    public Connection getConnection()
    {
        Connection con=null;
        try{

            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://ec2-99-81-177-233.eu-west-1.compute.amazonaws.com:5432/d4a3es05ub57g0";
            String user = "nacfitmmzmrucm";
            String pass="9411b1c0b57d1ef09301475487b2cdda41379866cfdec11a0b6f293972d3e2fa";
            
       
            con = DriverManager.getConnection(dbURL, user, pass);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return con;
    }

    public ConnectionBD(){

    }
}
