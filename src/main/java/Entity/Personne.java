package Entity;

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;*/

public class Personne {
    
    String nom;
    int id;

    public Personne(int i,String n){
        this.id=i;
        this.nom=n;
    }
    public Personne(){

    }

    public int GetId(){
        return this.id;
    }
    public void SetId(int i){
        this.id=i;
    }
    public String GetNom(){
        return this.nom;
    }
    public void SetNom(String n){
        this.nom=n;
    }

    /*public List<Personne> getAll(){
        List<Personne> rep=new ArrayList<>();
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Nick", "root", "root");
            PreparedStatement st=con.prepareStatement("SELECT*FROM Personne");
            ResultSet res=st.executeQuery();
            while(res.next()){
                int id=res.getInt("id");
                String nom=res.getString("nom");
                Personne p=new Personne(id,nom);
                rep.add(p);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }*/
}
