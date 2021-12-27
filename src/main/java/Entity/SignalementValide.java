package Entity;

public class SignalementValide {
    /*id int primary key not null AUTO_INCREMENT,
     idSign int,
     idReg int, */
    
    int id;
    int idSign;
    int idReg;

    public int getId(){
        return this.id;
    }
    public void setId(int i){
        this.id=i;
    }
    public int getIdSign(){
        return this.idSign;
    }
    public void setIdSing(int i){
        this.idSign=i;
    }
    public int getIdReg(){
        return this.idReg;
    }
    public void setIdReg(int i){
        this.idReg=i;
    }
    public SignalementValide(int i,int ii,int iii){
        this.id=i;
        this.idSign=ii;
        this.idReg=iii;
    }
    public SignalementValide(){
        
    }
}
