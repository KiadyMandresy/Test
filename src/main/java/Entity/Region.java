package Entity;

public class Region {
    /*id int primary key not null AUTO_INCREMENT,
     nom varchar(50) */
    
    int id;
    String nom;

    public int getId(){
        return this.id;
    }
    public void setId(int i){
        this.id=i;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String n){
        this.nom=n;
    }
    
    public Region(int i,String n){
        this.id=i;
        this.nom=n;
    }
    public Region(){
        
    }
}
