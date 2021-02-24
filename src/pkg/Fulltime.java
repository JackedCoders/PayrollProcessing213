package pkg;

public class Fulltime extends Employee{

    public Fulltime(Profile fulltimeProfile, Double payRate) {

        super(fulltimeProfile, payRate);
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
