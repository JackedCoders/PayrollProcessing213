/**
 * 
 * @author Manveer Singh, Prasish Sriram
 */
package pkg;

import java.util.Calendar;

public class Date implements Comparable<Date> {

    private int month;
    private int day;
    private int year;

    /**
     * 
     */
    public Date(String date) { // Creates date object from input String
        String[] tokens = date.split("/");
        this.month = Integer.valueOf(tokens[0]);
        this.day = Integer.valueOf(tokens[1]);
        this.year = Integer.valueOf(tokens[2]);
    }

    /**
     * 
     */
    public Date() { // return today’s date
        Calendar calendar = Calendar.getInstance();

        year = calendar.get(calendar.YEAR);
        month = calendar.get(calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 
     */
    public int getYear() {
        return year;
    }

    /**
     * 
     */
    public int getMonth() {
        return month;
    }

    /**
     * 
     */
    public int getDay() {
        return day;
    }

    /**
     * 
     */
    @Override
    public int compareTo(Date date) { // return 1, 0, or -1
        if (date.getYear() > this.year) {
            return -1;
        } else if (date.getYear() < this.year) {
            return 1;
        }

        if (date.getMonth() > this.month) {
            return -1;
        } else if (date.getMonth() < this.month) {
            return 1;
        }

        if (date.getDay() > this.day) {
            return -1;
        } else if (date.getDay() < this.day) {
            return 1;
        }

        return 0;
    }

    /**
     * 
     */
    public boolean isValid() {
        if (year < 1900 || year > 2021) {
            return false;
        }
        boolean isLeapYear = isLeapYear(year);
        Date today = new Date();
        if (this.compareTo(today) > 0) {
            return false;
        }

        if (month < 1 || month > 12) {
            return false;
        }
        if (month == 2) {
            if (isLeapYear) {
                if (day < 1 || day > 29) {
                    return false;
                }
            } else {
                if (day < 1 || day > 28) {
                    return false;
                }
            }
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            if (day < 1 || day > 31) {
                return false;
            }
        } else {
            if (day < 1 || day > 30) {
                return false;
            }
        }

        return true;
    }

    /**
     * 
     */
    private boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            return false;
        }
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj){
        Date other;
        try{
            other = (Date) obj;
        }catch(Exception e){
            return false;
        }

        if(this.compareTo(other) == 0){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){

        String mm = String.valueOf(month);
        String dd = String.valueOf(day);
        String yyyy = String.valueOf(year);
        
        return mm + "/" + dd + "/" + yyyy;
    }

    /**
     * 
     */
    public static void main(String[] args) {

        // Test bed for Date
        Date date1 = new Date("2/21/2021");
        System.out.println(date1.isValid());
    }

}
