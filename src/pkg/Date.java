package pkg;

import java.util.Calendar;

public class Date implements Comparable<Date> {

    private int month;
    private int day;
    private int year;

    public Date(String date) { //Creates date object from input String
        /*
            String date - String with form mm/dd/yyyy
         */

        String [] tokens = date.split("/");
        this.month = Integer.valueOf(tokens[0]);
        this.day = Integer.valueOf(tokens[1]);
        this.year = Integer.valueOf(tokens[2]);
    }
    public Date() { //return today’s date
        Calendar calendar = Calendar.getInstance();

        year = calendar.get(calendar.YEAR);
        month = calendar.get(calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    //Getter method for year
    public int getYear() {
        return year;
    }

    //Getter method for month
    public int getMonth() {
        return month;
    }

    //Getter method for day
    public int getDay(){
        return day;
    }

    @Override
    public int compareTo(Date date) { //return 1, 0, or -1
        if(date.getYear() > this.year){
            return -1;
        }else if(date.getYear() < this.year){
            return 1;
        }

        if(date.getMonth() > this.month){
            return -1;
        }else if(date.getMonth() < this.month){
            return 1;
        }

        if(date.getDay() > this.day){
            return -1;
        }else if(date.getDay() < this.day){
            return 1;
        }

        return 0;
    }

    public static void main(String[] args){

        //Test bed for Date
        
    }

}
