
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

    public Profile getProfile() {
        return this.employeeProfile;
    }
    
    public void setProfile(Profile profile){
        this.employeeProfile = profile;
    }

    public double getPayments(){
        return this.payments;
    }

    public void setPayments(double payments){
        this.payments = payments;
    }

    public double getPayRate(){
        return this.payRate;
    }

    public void setPayRate(double payRate){
        this.payRate = payRate;
    }

    public Employee(Profile employeeProfile, Double payRate){
        this.employeeProfile = employeeProfile;
        this.payRate = payRate;
        this.payments = (double) 0;
    }

    public Employee(){

    }

    @Override
    public String toString(){

        return employeeProfile.toString();
    }

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
