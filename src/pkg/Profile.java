/**
 * 
 * @author Manveer Singh, Prasish Sriram
 */
package pkg;

public class Profile {
    private String name; //employee’s name in the form “lastname,firstname” 
    private String department; //department code: CS, ECE, IT
    private Date dateHired;

    /**
     * 
     */
    public Profile(String name, String department, Date dateHired){
        this.name = name;
        this.department = department;
        this.dateHired = dateHired;
    }

    /**
     * 
     */
    public String getName(){
        return this.name;
    }

    /**
     * 
     */
    public String getDepartment(){
        return this.department;
    }

    /**
     * 
     */
    public Date getDateHired() { 
        return this.dateHired; 
    }

    /**
     * 
     */
    @Override
    public String toString() {

        return name + "::" + department + "::" + dateHired.toString() + "::";
    }

    /**
     * 
     */
    @Override
    public boolean equals(Object obj) { //compare name, department and dateHired
        Profile newProfile;
        try{
            newProfile = (Profile) obj;
        }catch(Exception e){
            return false;
        }
        if(!name.equals(newProfile.getName())){
            return false;
        }
        if(!department.equals(newProfile.getDepartment())){
            return false;
        }
        if(dateHired.compareTo(newProfile.getDateHired()) != 0){
            return false;
        }

        return true;
    }
}
