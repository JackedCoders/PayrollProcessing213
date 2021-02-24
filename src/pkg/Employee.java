
/**
 * 
 * 
 * @author Manveer Singh, Prasish Sriram
 */

 package pkg;

public class Employee {

    private Profile employeeProfile;
    private Double payRate;
    private Double payments;

    /**
     * 
     */
    public Profile getProfile() {
        return this.employeeProfile;
    }
    
    /**
     * 
     */
    public void setProfile(Profile profile){
        this.employeeProfile = profile;
    }

    /**
     * 
     */
    public double getPayments(){
        return this.payments;
    }

    /**
     * 
     */
    public void setPayments(double payments){
        this.payments = payments;
    }

    /**
     * 
     */
    public double getPayRate(){
        return this.payRate;
    }

    /**
     * setter method that initializes the parameter payRate to the instance variable in Employee
     * class 
     * @param payRate value of type double that gets passed in as a parameter to this method and allows
     * us to initiaize it to instance variable payRate of this class
     */
    public void setPayRate(double payRate){
        this.payRate = payRate;
    }

    public void calculatePayment(){

    }

    /**
     * 
     */
    public Employee(Profile employeeProfile, Double payRate){
        this.employeeProfile = employeeProfile;
        this.payRate = payRate;
        this.payments = (double) 0;
    }

    /**
     * Default constructor
     */
    public Employee(){
        
    }

    /**
     * 
     */
    @Override
    public String toString(){

        return employeeProfile.toString() + "Payment $" + payments + "::";
    }

    /**
     * 
     */
    @Override
    public boolean equals(Object obj){
        Employee newEmployee;
        try {
            newEmployee = (Employee) obj;
        }catch(Exception e){
            return false;
        }

        if(!employeeProfile.equals(newEmployee.getProfile())){
            return false;
        }
        return true;
    }
}
