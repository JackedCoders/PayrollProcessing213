package pkg;

public class Employee {

    Profile employeeProfile;

    public Employee(){

    }

    @Override
    public String toString(){

        return null;
    }

    @Override
    public boolean equals(Object obj){
        Employee newEmployee = (Employee) obj;

        if(!employeeProfile.equals(newEmployee)){
            return false;
        }
        return true;
    }
}
