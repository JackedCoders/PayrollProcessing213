package pkg;

public class Employee {

    Profile employeeProfile;
    int payRate;

    public Employee(Profile employeeProfile, int payRate){

    }

    public Employee(){

    }

    @Override
    public String toString(){

        return null;
    }

    @Override
    public boolean equals(Object obj){
        Employee newEmployee;
        try {
            newEmployee = (Employee) obj;
        }catch(Exception e){
            return false;
        }

        if(!employeeProfile.equals(newEmployee)){
            return false;
        }
        return true;
    }
}
