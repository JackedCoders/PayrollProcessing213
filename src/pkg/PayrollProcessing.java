/**
 * 
 * @author Manveer Singh, Prasish Sriram
 */
package pkg;

import java.util.Scanner;

public class PayrollProcessing {

    Company newCompany = new Company();

    /**
     * 
     */
    public void run() {

        Scanner inputScanner = new Scanner(System.in);

        String input = "";
        System.out.println("Payroll Processing starts.");
        while (!input.equals("Q")) {
            input = inputScanner.nextLine();
            String[] tokens = input.split(" ");

            // Input is empty
            if (input.equals("") || input == null) {
                invalidCommand(input);
                continue;
            }

            // Input is Add
            else if (tokens[0].equals("AM") || tokens[0].equals("AP") || tokens[0].equals("AF")) {

                if (tokens.length != 5 && tokens.length != 6) {
                    invalidCommand(input);
                    continue;
                }

                char type = tokens[0].charAt(1);
                String name = tokens[1];
                String department = tokens[2];
                if (!validateDepartment(department)) {
                    continue;
                }
                Date dateHired = validateDate(tokens[3]);
                if (dateHired == null) {
                    continue;
                }
                Double payRate = (double) -1;
                try {
                    payRate = Double.parseDouble(tokens[4]);
                } catch (Exception e) {
                    continue;
                }

                // Add a part time employee
                if (type == 'P') {
                    if(payRate < 0){
                        System.out.println("Pay rate cannot be negative.");
                        continue;
                    }
                    addParttime(name, department, dateHired, payRate);
                }

                // Add a full time employee
                else if (type == 'F') {
                    if(payRate < 0){
                        System.out.println("Salary cannot be negative.");
                        continue;
                    }
                    addFulltime(name, department, dateHired, payRate);
                }

                // Add a Manager
                else if (type == 'M') {
                    if(payRate < 0){
                        System.out.println("Salary cannot be negative.");
                        continue;
                    }

                    int managerType;
                    try {
                        managerType = Integer.parseInt(tokens[5]);
                    } catch (Exception e) {
                        System.out.println("Invalid management code.");
                        System.out.println("test1");
                        continue;
                    }

                    if (!validateManagementCode(managerType)) {
                        continue;
                    }
                    addManager(name, department, dateHired, payRate, managerType);
                }

                System.out.println("# OF EMPLOYEES " + newCompany.getNumEmployees());
            }

            // Input is Remove
            else if (tokens[0].equals("R")) {

                if (tokens.length != 4) {
                    invalidCommand(input);
                    continue;
                }

                String name = tokens[1];
                String department = tokens[2];
                if (!validateDepartment(department)) {
                    continue;
                }
                Date dateHired = validateDate(tokens[3]);
                if (dateHired == null) {
                    continue;
                }

                removeEmployee(name, department, dateHired);
            }

            // Input is Calculate
            else if (input.equals("C")) {
                calculatePayments();

            }

            // Input is Set Hours
            else if (tokens[0].equals("S")) {
                if (tokens.length != 5) {
                    invalidCommand(input);
                    continue;
                }

                String name = tokens[1];
                String department = tokens[2];
                if (!validateDepartment(department)) {
                    continue;
                }
                Date dateHired = validateDate(tokens[3]);
                if (dateHired == null) {
                    continue;
                }
                int hours = -1;

                try {
                    hours = Integer.parseInt(tokens[4]);
                } catch (Exception e) {
                    invalidCommand(input);
                    continue;
                }
                if (!validateHours(hours)) {
                    continue;
                }

                setHours(name, department, dateHired, hours);

            }

            // Input is Print
            else if (input.equals("PA") || input.equals("PH") || input.equals("PD")) {

                if (input.equals("PA")) {
                    newCompany.print();
                } else if (input.equals("PH")) {
                    newCompany.printByDate();
                } else if (input.equals("PD")) {
                    newCompany.printByDepartment();
                }
            }

            // Input is Quit
            else if (input.equals("Q")) {
                System.out.println("Payroll Processing completed.");
                break;
            }

            // Invalid input
            else {
                invalidCommand(input);
                continue;
            }
        }
        inputScanner.close();
    }

    /**
     * 
     */
    private void addParttime(String name, String department, Date date, Double payRate) {
        Profile parttimeProfile = new Profile(name, department, date);
        boolean added = newCompany.add(new Parttime(parttimeProfile, payRate));
        if (!added) {
            System.out.println("Employee is already in the list.");
        } else {
            System.out.println("Employee added.");
        }
    }

    /**
     * 
     */
    private void addFulltime(String name, String department, Date date, Double payRate) {

        Profile fulltimeProfile = new Profile(name, department, date);
        boolean added = newCompany.add(new Fulltime(fulltimeProfile, payRate));
        if (!added) {
            System.out.println("Employee is already in the list.");
        } else {
            System.out.println("Employee added.");
        }
    }

    /**
     * 
     */
    private void addManager(String name, String department, Date date, Double payRate, int managerType) {

        Profile managerProfile = new Profile(name, department, date);
        boolean added = newCompany.add(new Management(managerProfile, payRate, managerType));
        if (!added) {
            System.out.println("Employee is already in the list.");
        } else {
            System.out.println("Employee added.");
        }
    }

    /*
     *
     */
    private void setHours(String name, String department, Date date, int hours) {

        Profile setProfile = new Profile(name, department, date);
        Employee setEmployee = new Employee(setProfile, 0.0);

        boolean hoursSet = newCompany.setHours(setEmployee, hours);
        if (!hoursSet) {
            System.out.println("Employee does not exist.");
        } else {
            System.out.println("Working hours set.");
        }
    }

    /**
     * 
     */
    private void removeEmployee(String name, String department, Date date) {
        Profile removeProfile = new Profile(name, department, date);
        Employee removeEmployee = new Employee(removeProfile, 0.0);

        boolean removed = newCompany.remove(removeEmployee);
        if (!removed) {
            System.out.println("Employee does not exist.");
        } else {
            System.out.println("Employee removed.");
        }
    }

    /**
     * 
     */
    private void calculatePayments() {
        newCompany.processPayments();
        System.out.println("Calculation of employee payments is done.");
    }

    /**
    * 
    */
    private void invalidCommand(String input) {

        System.out.println("Command '" + input + "' not supported!");
    }

    /**
     * 
     */
    private boolean validateDepartment(String department) {

        if (department.equals("CS") || department.equals("ECE") || department.equals("IT")) {
            return true;
        }
        System.out.println("'" + department + "' is not a valid department code.");
        return false;

    }

    /**
     * 
     */
    private Date validateDate(String date) {
        Date newDate;
        try {
            newDate = new Date(date);
        } catch (Exception e) {
            System.out.println(date + " is not a valid date!");
            return null;
        }
        if (!newDate.isValid()) {
            System.out.println(date + " is not a valid date!");
            return null;
        }

        return newDate;
    }

    /**
     * 
     */
    private boolean validateManagementCode(int managementCode) {

        if (managementCode == 1 || managementCode == 2 || managementCode == 3) {
            return true;
        } else {
            System.out.println("Invalid management code.");
            System.out.println("test2");
            return false;
        }
    }

    /**
     * 
     */
    private boolean validateHours(int hours) {
        if (hours < 0) {
            System.out.println("Working hours cannot be negative.");
            return false;
        }
        if (hours > 100) {
            System.out.println("Invalid Hours: over 100.");
            return false;
        }
        return true;
    }
}
