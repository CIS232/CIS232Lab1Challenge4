/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author Justin2
 */
public class Lab1VandC {

    /**
     * @param args the command line arguments
     */
    static Scanner keyboard = new Scanner(System.in);
    // Initilize Scanner, make static so can be refrenced from anywhere
    public static void main(String[] args) {
        
        getString();
    //   Run the GetString Method       
        
//        int Vowels = vowels(UserString);
//        int Consonant = consonants(UserString) - Vowels;
//        
//        System.out.println("There are " + Vowels + " Vowels and " + Consonant + " Consonants");
        
        
    }
    
    public static int vowels(String UserString) {
        // Takes the UserString that was from Menu and converts it to a lowercase string and stored in another variable
        String UserStringLC = UserString.toLowerCase();
        // initilize Variables
        int CountOfVowels = 0;
        
        int PosOfVowel = 0;
        
        int StartingPointOfIndexSearch = 0;
         
        int NumberOfLetterLoops = 0;
        // Array of all possible vowels
        String[] VowelLetters = {"a", "e", "i","o","u"};
        
        
        // begin do loop
        do {
            // adds one to the number of loops
            NumberOfLetterLoops++;
            // enhanced for loop, loops through all of the letters within the array
            for (String VowelLetter : VowelLetters) {
            // While loop, searches through whole string for current letter that was selected in the for loop, infinite loop until it breaks from the if statement
                while (true) {
                    // this loops and adds 1 to the count of vowels, because if there were no more vowels, the loop would terminate before adding 1 to the CountOfVowels Variable
                    PosOfVowel = UserStringLC.indexOf(VowelLetter, StartingPointOfIndexSearch);
                    // this moves the StartingPointOfIndexSearch up by the PosOfVowel, the posistion of the vowel found, 
                    // and adds 1 to start ahead of the last found vowel, otherwise it loops infinitly
                    StartingPointOfIndexSearch = PosOfVowel + 1;
                        // This breaks out of the while loop if the PosOfVowel returns anything below 0, so when it returns -1, it will break.
                        if (PosOfVowel < 0) {
                        break;
                        }
                    // adds one to the total number of vowels    
                    CountOfVowels++;
                }
        //System.out.println(PosOfVowel);
                // this resets the PosOfVowel after the while loop breaks, allowing the while loop to start back at the beginning of the statement
                // with the next vowel.
                PosOfVowel = 0;
           }
           // this keeps the do loop running until the length of the array
        } while (NumberOfLetterLoops == VowelLetters.length);
    
    //System.out.println("There are " + CountOfVowels + " Vowels");
    
    
    
        return CountOfVowels;
    }

    private static int consonants(String UserString) {
        //Sets input to lowercase of ease of usage
        String UserStringLC = UserString.toLowerCase();
        // intilize variables
        int NumberOfLetters = 0;
        //for loop runs until it reaches end of string
        for (int i = 0; i < UserStringLC.length(); i++){
//        System.out.println(NumberOfLetters);
                // This if statement adds one to the number of letters within the statement.
                if (Character.isLetter(UserStringLC.charAt(i))) {
                NumberOfLetters++;
            }
        
        }
        
       // takes the total number of letters, and subtracts all vowels from them, leaving only the consonants
        int NumberOfConsonants = NumberOfLetters - vowels(UserString);
        
        
        
        return NumberOfConsonants;
        
       
    }
    
    
    public static void menu(String UserString) {
       
       
       
       System.out.println("Welcome to the Vowels and Consonants Menu!");
       System.out.println("a. Count number of vowels in string");
       System.out.println("b. Count number of consonants in string");
       System.out.println("c. Count number of both consonants and vowels");
       System.out.println("d. Enter another String");
       System.out.println("e. Exit Program");
       System.out.println("Your current String is " + "\"" + UserString + "\"");
       // Menu printout displaying all options to the user
       
        
       System.out.println("What would you like to select? (A/B/C/D/E)");
       
       // Tell User what the possible choices are
       String UserSelection = keyboard.nextLine();
       // Captures the User's input
       
       
       // Converts user input to lowercase for ease of use in the switch
       // This switch accounts for all other inputs besides the ones listed, prompting the user to try again.
       switch (UserSelection.toLowerCase()) {
           
           case "a" : {
               //Adds a blank line for readablitiy
               System.out.println();
               // Prints out a ln with all relevent info, all methods are run within the print method. the original string is also put at the end.
               System.out.println("There are " + vowels(UserString) + " Vowels " + "in " + "\"" + UserString + "\"");
            
               break;
           }
           
           case "b" : {
               //Adds a blank line for readablitiy
               System.out.println();
               // Prints out a ln with all relevent info, all methods are run within the print method. the original string is also put at the end.
               System.out.println("There are " + (consonants(UserString)) + " Consonants " + "in " + "\"" + UserString + "\"");

               break;
           }
               
           case "c" :   {
               //Adds a blank line for readablitiy
               System.out.println();
               // Prints out a ln with all relevent info, all methods are run within the print method. the original string is also put at the end.
               System.out.println("There are " + vowels(UserString) + " Vowels" + " and there are " + (consonants(UserString)) + " Consonants " + "in " + "\"" + UserString + "\"");

               break;
           }
               
           case "d" :   {
            
               getString();
            
               break;
           }
               
           case "e" : {
            
               System.out.println("Thanks for Using My Program!");
            
               System.exit(0);
           break;
           }
           
           default : {
           
            
               System.out.println("That is not a valid choice, Please try again.");
            
               menu(UserString);
            
               break;
             
           }
       }
       
       System.out.println("Would you like to go back to the menu? (Y/N)");
       // Asks the User if they wish to return to the Main Menu after completing their request.
       UserSelection = keyboard.nextLine();
       // Takes User input
       // Converts Input to Lowercase for ease of usage in switch
       switch (UserSelection.toLowerCase()) {
       
           case "y" : {
           // This clears the console screen with 50 lines of blank lines, allowing for a cleaner look in the console.
               for (int i = 0; i < 50; ++i) System.out.println();
           // Reruns the menu with the orignal String inputted
               menu(UserString);
           
           }
           case "n" : {
           // Thanks user for using program and exits the program.
               System.out.println("Thanks for Using My Program!");
           
               System.exit(0);
           
           }
       
       
       }
       
       
       
    
    }
    
    public static void getString() {
    
    System.out.println("Enter a String.");
    // Asks for the User to enter a string    
    
    String UserString = keyboard.nextLine();
    // Capture the User Input and store it into UserString
    
    // This clears the console screen with 50 lines of blank lines, allowing for a cleaner look in the console.
    for (int i = 0; i < 50; ++i) System.out.println();
    
    // Send the UserString into the menu Method.
    menu(UserString);
    
    
    }
    
    
    
    
}