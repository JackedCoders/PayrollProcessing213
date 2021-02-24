package pkg;

import java.util.Scanner;

public class PayrollProcessing {

    public void run(){

        Company newCompany = new Company();

        Scanner inputScanner = new Scanner(System.in);

        String input = "";
        while(!input.equals("Q")){
            input = inputScanner.nextLine();
            String [] tokens = input.split(" ");

            // Input is empty
            if(input.equals("") || input == null){
                invalidCommand(input);
                continue;
            }

            // Input is Add
            else if(tokens[0].equals("AM") || tokens[0].equals("AP") || tokens[0].equals("AF")){
                char type = tokens[0].charAt(0);
                String name = tokens[1];
                String department = tokens[2];
                Date date = new Date(tokens[3]);
                Double payRate = Double.parseDouble(tokens[4]);

                // Add a part time employee
                if(type == 'P'){

                }

                // Add a full time employee
                if(type == 'F'){

                }

                // Add a Manager
                else{
                    int managerType = Integer.parseInt(tokens[5]);

                }
            }
            
            // Input is Remove
            else if(tokens[0].equals("R")){
                String name = tokens[1];
                String department = tokens[2];
                String date = tokens[3];
            }
            
            // Input is Calculate
            else if(input.equals("C")){
                calculatePayments();
            }

            // Input is Set Hours
            else if(tokens[0].equals("S")){
                String name = tokens[0];
                String department = tokens[1];
                String date = tokens[2];

            }

            // Input is Print
            else if(input.equals("PA") || input.equals("PH") || input.equals("PD")){

                if(input.equals("PA")){
                    newCompany.print();
                }else if(input.equals("PH")){
                    newCompany.printByDate();
                }else if(input.equals("PD")){
                    newCompany.printByDepartment();
                }
            }

            // Input is Quit
            else if(input.equals("Q")){
                System.out.println("Payroll Processing completed.");
                break;
            }

            // Invalid input
            else{
                invalidCommand(input);
                continue;
            }
        }
    }

    private void addParttime(String name, String department, Date date, Double payRate){


    }

    private void addFulltime(String name, String department, Date date, Double payRate){


    }

    private void addManager(String name, String department, String date, Double payRate){

    }

    private void removeEmployee(){

    }

    private void calculatePayments(){

    }


    private void invalidCommand(String input){

        System.out.println("Command '"+input+"' not supported!");
    }

    private boolean validateName(String name){
        String [] names = name.split(",");
        if(names.length != 2){
            return false;
        }
        return true;
    }

    private boolean validateDepartment(String department){

        if(department.equals("CS") || department.equals("ECE") || department.equals("IT")){
            return true;
        }
        return false;
    }

    private boolean validateDate(Date date){
        if(date.isValid()) {
            return true;
        }
        return false;
    }
}
