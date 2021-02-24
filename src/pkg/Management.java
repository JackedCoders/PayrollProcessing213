/**
 * 
 * 
 * @author Manveer Singh, Prasish Sriram
 */


package pkg;

public class Management extends Fulltime{

    int managerType;

    public Management(Profile managerProfile, Double payRate, int managerType) {

        super(managerProfile, payRate);
        this.managerType = managerType;
    }

    @Override
    public String toString(){
        return null;
    }

    @Override
    public boolean equals(Object obj){
        return false;
    }
}
