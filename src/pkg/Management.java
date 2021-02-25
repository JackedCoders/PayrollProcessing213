/**
 * 
 * 
 * @author Manveer Singh, Prasish Sriram
 */

package pkg;

public class Management extends Fulltime {

    private int managementCode;
    private Double managerCompensation;

    /**
     * 
     */
    public Management(Profile managerProfile, Double payRate, int managerType) {

        super(managerProfile, payRate);
        this.managementCode = managerType;

        int payPeriods = 26; // # of biweekly payment periods per year
        int managerBonus = 5000;
        int departmentHeadBonus = 9500;
        int directorBonus = 12000;

        if (managerType == 1) {
            this.managerCompensation = (double) managerBonus / payPeriods;
        } else if (managerType == 2) {
            this.managerCompensation = (double) departmentHeadBonus / payPeriods;
        } else {
            this.managerCompensation = (double) directorBonus / payPeriods;
        }
    }

    /**
     * 
     * @return
     */
    public double getManagerCompensation() {
        return managerCompensation;
    }

    /**
     * 
     */
    @Override
    public void calculatePayment() {
        final int PAY_PERIODS = 26; // # of biweekly payment periods per year
        super.calculatePayment(super.getPayRate() / PAY_PERIODS + managerCompensation);
    }

    /**
     * 
     */
    @Override
    public String toString() {
        if (managementCode == 1) {
            return super.toString() + "::Manager Compensation $" + managerCompensation;
        }
        if (managementCode == 2) {
            return super.toString() + "::DepartmentHead Compensation $" + managerCompensation;
        }
        if (managementCode == 3) {
            return super.toString() + "::Director Compensation $" + managerCompensation;
        }
        return null; // return for compilation purposes
    }

    /**
     * 
     */
    @Override
    public boolean equals(Object obj) {
        Management newManagement;
        try {
            newManagement = (Management) obj;
        } catch (Exception e) {
            return false;
        }

        if (!super.getProfile().equals(newManagement.getProfile())) {
            return false;
        }

        return true;
    }
}
