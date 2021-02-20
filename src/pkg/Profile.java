package pkg;

public class Profile {
    private String name; //employee’s name in the form “lastname,firstname” private String department; //department code: CS, ECE, IT
    private Date dateHired;

    //Getter method for name of employee
    public String getName(){
        return this.name;
    }



    @Override
    public String toString() { return null; }

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


        return true;
    }
}
