/**
 * 
 * 
 * @author Manveer Singh, Prasish Sriram
 */


package pkg;

public class Management extends Fulltime{

    private Double managerCompensation;

    /**
     * 
     */
    public Management(Profile managerProfile, Double payRate, int managerType) {

        

        super(managerProfile, payRate);

        int payPeriods = 26;
        int managerBonus = 5000;
        int departmentHeadBonus = 9500;
        int directorBonus = 12000;

        if(managerType == 1){
            this.managerCompensation = (double) managerBonus/payPeriods;
        }else if(managerType == 2){
            this.managerCompensation = (double) departmentHeadBonus/payPeriods;
        }else{
            this.managerCompensation = (double) directorBonus/payPeriods;
        }
    }

    public double getManagerCompensation(){
        return managerCompensation;
    }

    @Override
    public void calculatePayment(){

        super.setPayments( super.getPayRate()/26 + managerCompensation );
    }

    /**
     * 
     */
    @Override
    public String toString(){
        return super.toString() + "::Manager Compensation $" + managerCompensation;
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
        
        if(!super.getProfile().equals(newManagement.getProfile())){
            return false;
        }
        if(managerCompensation != newManagement.getManagerCompensation()){
            return false;
        }


        return true;
    }
}
