package Entity;

public class DetailSignalement {
    /*id int primary key not null AUTO_INCREMENT,
     idSign int,
     photos varchar(255),
     */

    int id;
    int idSign;
    String photos;

    public int getId(){
        return id;
    }
    public void setId(int i){
        this.id=i;
    }
    public int getIdSign(){
        return this.idSign;
    }
    public void setIdSign(int i){
        this.idSign=i;
    }
    public String getPhotos(){
        return photos;
    }
    public void setPhotos(String p){
        this.photos=p;
    }

    public DetailSignalement(int i,int ii,String p){
        this.id=i;
        this.idSign=ii;
        this.photos=p;
    }
    public DetailSignalement(){
        
    }

}
