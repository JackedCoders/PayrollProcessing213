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
     * 
     */
    public Company(){
        this.emplist = new Employee[4];
        this.numEmployees = 0;
    }

    /**
     * 
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
     * 
     * 
     */
    private void grow(){
        Employee [] newList = new Employee[emplist.length+4];
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
        return true;
    }

    /**
     * 
     * 
     */
    public void processPayments(){
            
    }

    /**
     * 
     * 
     */
    public void print(){
        for(int i=0; i<numEmployees; i++){
            System.out.println(emplist[i].toString());
        }
    }

    /**
     * 
     */
    public void printByDepartment(){

    }

    /**
     * 
     * 
     */
    public void printByDate(){
            
    }



}
