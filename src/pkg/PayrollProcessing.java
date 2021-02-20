package pkg;

import java.util.Scanner;

public class PayrollProcessing {

    public void run(){

        Scanner inputScanner = new Scanner(System.in);

        String input = "";
        while(!input.equals("Q")){
            input = inputScanner.nextLine();

            //Check input
            if(input.equals("") || input == null){
                invalidCommand(input);
                continue;
            }
            else if(input.charAt(0) == 'A'){
                
            }
            else{
                invalidCommand(input);
                continue;
            }
        }
    }

    public void invalidCommand(String input){
        System.out.println("Command '"+input+"' not supported!");
    }
}
