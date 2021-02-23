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
                String date = tokens[3];
                Double payRate = Double.parseDouble(tokens[4]);

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

    private void addEmployee(String name, String department, String date, Double payRate){


    }

    private void addManager(){

    }

    private void removeEmployee(){

    }

    private void calculatePayments(){

    }


    private void invalidCommand(String input){

        System.out.println("Command '"+input+"' not supported!");
    }

    private boolean validDepartment(String department){

        if(department.equals("CS") || department.equals("ECE") || department.equals("IT")){
            return true;
        }
        return false;
    }

    private boolean validDate(Date date){
        if(date.isValid()) {
            return true;
        }
        return false;
    }
}
