package Entity;

public class StatRegion {
    
    int nbr;
    String nom;

    public int getNbr() {
        return nbr;
    }
    public void setNbr(int nbr) {
        this.nbr = nbr;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public StatRegion(){

    }
    public StatRegion(int i,String n){
        this.nbr=i;
        this.nom=n;
    }
}
