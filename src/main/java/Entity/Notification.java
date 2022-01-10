package Entity;

public class Notification {
    
    int id;
    int idSignTermine;

    public int getId(){
        return this.id;
    }
    public void setId(int i){
        this.id=i;
    }
    public int getIdSignTermine(){
        return this.id;
    }
    public void setIdSignTermine(int i){
        this.idSignTermine=i;
    }
    public Notification(int i,int ii){
        this.id=i;
        this.idSignTermine=ii;
    }
    public Notification()
    {
        
    }
    
}
