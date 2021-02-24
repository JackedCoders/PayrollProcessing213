/**
 * 
 * @author Manveer Singh, Prasish Sriram
 */
package pkg;

public class Parttime extends Employee {

    private int hoursWorked; // Hours worked this period

    /**
     * 
     */
    public Parttime(Profile parttimeProfile, Double payRate) {
        super(parttimeProfile, payRate);
        this.hoursWorked = 0;
    }

    /**
     * 
     */
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    /**
     * 
     */
    @Override
    public void calculatePayment() {
        final int MAX_REGULAR_HOURS = 80;
        final double OVERTIME_COMPENSATION = 1.5;
        if (hoursWorked <= MAX_REGULAR_HOURS) {

            super.setPayments(hoursWorked * super.getPayRate());
        } else {
            int overtimeHours = hoursWorked - MAX_REGULAR_HOURS;
            hoursWorked -= MAX_REGULAR_HOURS;

            super.setPayments(
                    (hoursWorked * super.getPayRate()) + (overtimeHours * super.getPayRate() * OVERTIME_COMPENSATION));
        }
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return super.toString() + "PART TIME::Hourly Rate $" + super.getPayRate() + "::Hours worked this period: "
                + hoursWorked;
    }

    /**
     * 
     */
    @Override
    public boolean equals(Object obj) {
        Parttime newParttime;
        try {
            newParttime = (Parttime) obj;
        } catch (Exception e) {

            return false;
        }

        if (!super.getProfile().equals(newParttime.getProfile())) {
            return false;
        }
        return true;
    }
}
