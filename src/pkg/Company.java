package pkg;

public class Company {
    private Employee [] emplist;
    private int numEmployees;

    public Company(){
        this.emplist = new Employee[4];
        this.numEmployees = 0;
    }

    private int find(Employee employee){

        for(int i = 0; i<emplist.length; i++){
            if(emplist[i].equals(employee)){
                return i;
            }
        }
        return -1;
    }

    private void grow(){
        Employee [] newList = new Employee[emplist.length+4];
        for(int i =0; i< emplist.length; i++){
            newList[i] = emplist[i];
        }
        this.emplist = newList;
    }
    public void add(Employee employee){
        if(numEmployees == emplist.length){
            this.grow();
        }
        emplist[numEmployees+1] = employee;
        numEmployees++;

    }
    public boolean remove(Employee employee){
        int index = find(employee);
        if(index == -1){
            return false;
        }

        emplist[index] = null;
        numEmployees--;

        return true;
    }
    public boolean setHours(Employee employee){
        return true;
    }
    public void processPayments(){
            
    }
    public void print(){

    }
    public void printByDepartment(){

    }
    public void printByDate(){

    }



}
