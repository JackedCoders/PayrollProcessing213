/**
 * 
 * @author Manveer Singh, Prasish Sriram
 */
package pkg;

public class Fulltime extends Employee{

    /**
     * 
     */
    public Fulltime(Profile fulltimeProfile, Double payRate) {

        super(fulltimeProfile, payRate);
    }

    @Override
    public void calculatePayment(){

        super.setPayments( super.getPayRate()/26 );
    }

    /**
     * 
     */
    @Override
    public String toString(){
        return super.toString() + "FULL TIME::Annual Salary $" + super.getPayRate();
    }

    /**
     * 
     */
    @Override
    public boolean equals(Object obj){
        Fulltime newFulltime;
        try{
            newFulltime = (Fulltime) obj;
        }catch(Exception e){
            return false;
        }

        if(!super.getProfile().equals(newFulltime.getProfile())){ 
            return false;
        }
        if(super.getPayRate() != newFulltime.getPayRate()){ 
            return false;
        }

        return true;
    }
}
