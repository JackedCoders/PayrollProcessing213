/**
 * 
 * 
 * @author Manveer Singh, Prasish Sriram
 */


package pkg;

public class Management extends Fulltime{

    private int managerType;
    private Double managerCompensation;

    /**
     * 
     */
    public Management(Profile managerProfile, Double payRate, int managerType) {

        super(managerProfile, payRate);
        this.managerType = managerType;

        if(managerType == 1){
            this.managerCompensation = (double) 5000/26;
        }else if(managerType == 2){
            this.managerCompensation = (double) 9500/26;
        }else{
            this.managerCompensation = (double) 12000/26;
        }
    }

    public void calculatePayments(){

        super.setPayments( super.getPayRate()/26 + managerCompensation );
    }

    /**
     * 
     */
    @Override
    public String toString(){
        return null;
    }

    /**
     * 
     */
    @Override
    public boolean equals(Object obj){
        Management newManagement;
        try{
            newManagement = (Management) obj;
        }catch(Exception e){
            return false;
        }


        return true;
    }
}
