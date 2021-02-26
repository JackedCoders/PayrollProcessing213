/**
 * PayrollProcessing class is the main class that directly reads, writes and
 * constantly performs a lot of computations for this project. It is the user
 * interface class that calls different methods in Company to perform different
 * actions like adding parttime, fulltime employees along with their differnt
 * management roles. This class handles important methods like adding, removing,
 * printing earning statements etc.
 * 
 * @author Manveer Singh, Prasish Sriram
 */
package pkg;

import java.util.Scanner;

public class PayrollProcessing {

    Company newCompany = new Company();

    /**
     * method that reads from the console, performs calculations based on user input
     * along with handling all of the exceptions and invalid data entries that get
     * plugged in. Different integer codes are inputted, based on that, the method
     * is able to perform certain actions like add, remove etc.
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
                    if (payRate < 0) {
                        System.out.println("Pay rate cannot be negative.");
                        continue;
                    }
                    addParttime(name, department, dateHired, payRate);
                }

                // Add a full time employee
                else if (type == 'F') {
                    if (payRate < 0) {
                        System.out.println("Salary cannot be negative.");
                        continue;
                    }
                    addFulltime(name, department, dateHired, payRate);
                }

                // Add a Manager
                else if (type == 'M') {
                    if (payRate < 0) {
                        System.out.println("Salary cannot be negative.");
                        continue;
                    }

                    int managerType;
                    try {
                        managerType = Integer.parseInt(tokens[5]);
                    } catch (Exception e) {
                        System.out.println("Invalid management code.");
                        continue;
                    }

                    if (!validateManagementCode(managerType)) {
                        continue;
                    }
                    addManager(name, department, dateHired, payRate, managerType);
                }

                // System.out.println("# OF EMPLOYEES " + newCompany.getNumEmployees());
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
     * Method that adds part time employees to the database after retrieving their
     * name, department they work in, date and the payr rate. If an employee already
     * exists in database, prints a statement, otherwise "Emplooyee added."
     * 
     * @param name       of the partime employee we want to add
     * @param department they work in
     * @param date       date in MM/DD/YYYY format
     * @param payRate    how much the employee gets paid per pay period
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
     * Method that adds full time employees to the database after retrieving their
     * name, department they work in, date and the payr rate. If an employee already
     * exists in database, prints a statement, otherwise "Emplooyee added."
     * 
     * @param name       of the partime employee we want to add
     * @param department they work in
     * @param date       date in MM/DD/YYYY format
     * @param payRate    how much the employee gets paid per pay period
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
     * Method that adds manager level full time employees to the database after
     * retrieving their name, department they work in, date, payrate along with what
     * type of full time employee they are (manager, department head, director). If
     * an employee already exists in database, prints a statement, otherwise
     * "Emplooyee added."
     * 
     * @param name       of the partime employee we want to add
     * @param department they work in
     * @param date       date in MM/DD/YYYY format
     * @param payRate    how much the employee gets paid per pay period
     * @param managerTpe 1, 2 or 3 to correspond to manager, department head or
     *                   director
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

    /**
     * setter method that assigns hours based on name, department, date, and the
     * hours worked fields.
     * 
     * @param name       of the partime employee we want to add
     * @param department they work in
     * @param date       date in MM/DD/YYYY format
     * @param hours      hours the employee has worked
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
     * Method that removes employee from the database when given valid parameters
     * like their name, department and date
     * 
     * @param name       name of the employee to be removed
     * @param department department they work in
     * @param date       date
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
     * invokes processPayments from company class and calculates payments along with
     * displaying a message
     */
    private void calculatePayments() {
        newCompany.processPayments();
        System.out.println("Calculation of employee payments is done.");
    }

    /**
     * method that allows for printing a statement when the command is invalid from
     * the user on the console
     * 
     * @param input the input from the user that's unsupported
     */
    private void invalidCommand(String input) {

        System.out.println("Command '" + input + "' not supported!");
    }

    /**
     * Only three types of departments allows, CS, ECE and IT. This method checks to
     * see if the input from the user equals one of these, if not then it returns
     * false
     * 
     * @param department string type inputted by the user
     * @return true if input is one of these departments, false otherwise
     */
    private boolean validateDepartment(String department) {

        if (department.equals("CS") || department.equals("ECE") || department.equals("IT")) {
            return true;
        }
        System.out.println("'" + department + "' is not a valid department code.");
        return false;

    }

    /**
     * validates the input date read from the console.
     * 
     * @param date string type inputted by the user
     * @return returns the date that's valid, if not valid display a message
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
     * validates the code for management level full time employees. Input must be 1
     * for manager, 2 for department head, 3 for director
     * 
     * @param managementCode input from the console to be validated
     * @return true if valid input management code, false otherwise
     */
    private boolean validateManagementCode(int managementCode) {

        if (managementCode == 1 || managementCode == 2 || managementCode == 3) {
            return true;
        } else {
            System.out.println("Invalid management code.");
            return false;
        }
    }

    /**
     * validates the hours plugged in from the console.
     * 
     * @param hours int value to be tested
     * @return true if valid, false if < 0 or > 100 along with print statement.
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
