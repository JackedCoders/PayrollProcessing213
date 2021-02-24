/**
 * 
 * 
 * @author Manveer Singh, Prasish Sriram
 */
package pkg;

public class Company {
    private Employee [] emplist;
    private int numEmployees;

    /**
     * Constructor for Company class that initializes our private instances emplist of type Employee to 4
     * and numEmployee of type int to 0
     */
    public Company(){
        this.emplist = new Employee[4];
        this.numEmployees = 0;
    }

    /**
     * Returns the index of the employee that we are trying to find in the empList array of type Employee
     * acts as an helper method for other methods to identy certain employees
     * @param employee
     * @return returns the index of employee parameter if found, returns -1 otherwise
     */
    private int find(Employee employee){

        for(int i = 0; i<emplist.length; i++){
            if(emplist[i].equals(employee)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Automatically grows the capacity of array to hold empoyees by 
     * 4 using the method grow() below. Creating a new instance of type Employee
     * and growing the capacity by 4.
     */
    private void grow(){
        Employee [] newList = new Employee[emplist.length+ 4];
        for(int i =0; i< emplist.length; i++){
            newList[i] = emplist[i];
        }
        this.emplist = newList;
    }

    /**
    * removes a certain employee from the array empList based on user input
    * @param employee object of class Employee. 
    * @return returns true if 
    */
    public void add(Employee employee){
        if(numEmployees == emplist.length){
            this.grow();
        }
        emplist[numEmployees+1] = employee;
        numEmployees++;

    }

    /**
    * removes a certain employee from the array empList based on user input
    * @param employee object of class Employee. 
    * @return returns true if 
    */
    public boolean remove(Employee employee){
        int index = find(employee);
        if(index == -1){
            return false;
        }

        emplist[index] = null;
        for(int i = index; i < numEmployees; i++){
            emplist[i] = emplist[i+1];
        }
        numEmployees--;

        return true;
    }
   /**
    * Assigns working hours for a particular part-time employee
    * @param employee object of class Employee. hoursWorked field will be assigned here
    * @return false if setHours() fails, true if setHours() succeeds
    */
    public boolean setHours(Employee employee, int hoursWorked){
        int index = find(employee);
        if(index == -1){
            return false;
        }


        return true;
    }

    /**
     * 
     * 
     */
    public void processPayments(){
        for(int i = 0; i < numEmployees; i++){

            emplist[i].calculatePayment();
        }
    }

    /**
     * prints the contents (last name, firstname, department, earnings) 
     * of emplist array of type Employee using the .toString() method
     */
    public void print(){
        if(numEmployees == 0){
            System.out.println("Employee database is empty.");
        }

        for(int i=0; i<numEmployees; i++){
            System.out.println(emplist[i].toString());
        }
    }

    /**
     * 
     */
    public void printByDepartment(){
        if(numEmployees == 0){
            System.out.println("Employee database is empty.");
        }

    }

    /**
     * 
     */
    public void printByDate(){
        if(numEmployees == 0){
            System.out.println("Employee database is empty.");
        }
            

    }



}
