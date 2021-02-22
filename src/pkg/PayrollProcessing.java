package pkg;

import java.util.Scanner;

public class PayrollProcessing {

    public void run(){

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

            else if(tokens[0].equals("AM") || tokens[0].equals("AP") || tokens.equals("AF")){

            }

            // Input is "Q"
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

    private void addEmployee(String input){


    }

    public void invalidCommand(String input){
        System.out.println("Command '"+input+"' not supported!");
    }
}
