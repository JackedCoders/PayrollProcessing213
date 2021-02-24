package pkg;

public class Employee {

    private Profile employeeProfile;
    private Double payRate;
    private Double payments;

    public Profile getProfile() {
        return employeeProfile;
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
