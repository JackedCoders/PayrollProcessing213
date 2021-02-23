package pkg;

public class Company {
    private Employee [] emplist;
    private int numEmployee;
    private int find(Employee employee){
            return 0;
    }
    private void grow(){
        Employee [] newList = new Employee[emplist.length+4];
        for(int i =0; i< emplist.length; i++){
            newList[i] = emplist[i];
        }
        this.emplist = newList;
    }
    public boolean add(Employee employee){
        
        return true;
    }
    public boolean remove(Employee employee){
        return true;
    }
    public boolean setHours(Employee employee){return true;}
    public void processPayments(){
            
    }
    public void print(){}
    public void printByDepartment(){}
    public void printByDate(){

    }



}
