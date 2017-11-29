
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/*****************************************************************
*Programmer:        Erika Tvaskis
*Class:             CS30S Section 007
*Assignment:        Implementing Arrays       
*Description:       Working with arrays                   
*Input:             Amount of random numbers generated, and the range of these numbers                                                                    
*Output:            Numbers with their frequencies, as well as ranges                                      
******************************************************************/

public class ProgramA {   
    public static int MAX;	
    public static int MAXRAND;   
    public static int MINRAND;

public static void main(String[] args) throws IOException{  
    //Begin main
        
//DECLARE VARIABLES
    Random r = new Random();                    //Create new random object
    Scanner Scanner = new Scanner(System.in);   //Declaring Scanner
    
    int[] ElementArray;     //Declaring array of ints called ElementArray
    int[] FrequencyArray;   //Declaring array of ints called frequencyaarayArray
    
    int MinimumofEnteredRange;  //Declaring MinimumofEnteredRange as int
    int MaximumofEnteredRange;  //Declaring MaximumofEnteredRange as int
    int SumofFrequencies;    //Declaring sumfreq as int
    int n = 0;      //Declaring n as int
    int a = 0;      //Declaring a as int
    int b = 0;      //Declaring b as int
    
    String nl = System.lineSeparator(); //New line character
    BufferedReader fin = null;  //Declaring fin as BufferedReader
    
//PRINT FOUT        
    PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("ProgramAOutputFile.txt")));
        
//BANNER
    ProgramInfo Banner = new ProgramInfo("Assignment 1", " Implementing Arrays"); 
    //Object that prints banner
    ProgramInfo EndOfProgram = new ProgramInfo();
    System.out.println(Banner.toString());  
    //Prints banner

//SETTING MAX FOR ARRAY
    System.out.println("Enter how many numbers you want to load");    
        try {
            MAX = Integer.parseInt(Scanner.nextLine());
        }   //Closing bracket for try statement
        catch (NumberFormatException e) {    
            System.out.println("Error, please enter a numeric value");
            System.out.println("The Error: " + e); 
            return; 
            //Stops the program if catch statement catches error
        }   //Closing bracket for catch statement 
    System.out.println("***************************************");
    
//SETTING MINRAND (Minimum generated number)
    System.out.println("Enter smallest possible generated number");
        try {
            MINRAND = Integer.parseInt(Scanner.nextLine());
        }   //Closing bracket for try statement
        catch (NumberFormatException e) {     
            System.out.println("Error, please enter a numeric value"); 
            System.out.println("The Error: " + e); 
            return; 
            //Stops the program if catch statement catches error
        }   //Closing bracket for catch statement 
    System.out.println("***************************************");
    
//SETTING MAXRAND (Maximum generated number) with try catch
    System.out.println("Enter largest possible generated number");
        try {
            MAXRAND = Integer.parseInt(Scanner.nextLine());
        }   //Closing bracket for try statement
     catch (NumberFormatException e) {        
            System.out.println("Error, please enter a numeric value");   
            System.out.println("The Error: " + e); 
            return; 
            //Stops the program if catch statement catches error
        }   //Closing bracket for catch statement 
    System.out.println("***************************************");
    
//REMOVING POSSIBLE ERROR THAT MIN IS GREATER THAN MAX
    if (MINRAND > MAXRAND) {
        System.out.println("Sorry, but your minimum is greater than your maximum, program terminates");
        System.exit(0);
    }   //Closing bracket for if statement
        
//PRINTS RANDOM NUMBERS TO FILE 
//using for loop
    System.out.println("Pre-Work:");
    int number=0;
    for (int i=0; i < MAX; i++) {
        int RandomNumber =numberInput(number);
            if ((i % 5 != 0) || (i == 0)) {
                fout.print(RandomNumber + " ");   
            }   //Closing bracket for if statement
            else {
                fout.print(nl);
                fout.print(RandomNumber + " ");
            }   //Closing bracket for else statement
    }   //Closing bracket for printing to file loop
   
//CLOSING FOUT STREAM   
    fout.close();  
    
//PRINTING FOR DESIGN
    System.out.println("The random numbers have been generated, and have been printed in the output file");

//ACCESSING FILE I HAVE CREATED
//Try catch statement to catch any errors   
    try{
        fin = new BufferedReader(new FileReader("C:\\Users\\Erika Tvaskis\\Desktop\\JavaInputs\\Assignment1ImplementingArrays\\ProgramAOutputFile.txt"));
    }   //Closing bracket for try statement
    catch(FileNotFoundException e){
        System.out.println("file not found");
    }   //Closing bracket for catch
    
//SETTING ARRAYS   
    ElementArray= new int[MAX+1];
    
//DECIDE WHETHER OR NOT TO READ THE FILE
    System.out.println("Do you want your numbers to be read from the file");
    System.out.println("Type -1 for NO, anything else for YES");
    b = Integer.parseInt(Scanner.nextLine());
        if (b == -1) {
            System.exit(0);
        } //Closing bracket for if statement
        
//WHILE AND FORR LOOP
//The file is read and parsed
//Array is loaded
    String info = fin.readLine();
    while (info != null) {
        String[] tokens = null;
        String delimit = "[ ]+";
        tokens = info.split(delimit);
        for (int i = 0; i < tokens.length; i++) {
            ElementArray[n] = Integer.parseInt(tokens[i]);
            n++;
        }   //Closing bracket for loop 
        info = fin.readLine(); 
    } //Closing bracket for while loop
       
//PRINTING FOR THE PROGRAM'S DESIGN
    System.out.println("The random numbers have now been read from the file");
    System.out.println("***************************************");

//SETTING THE ARRAY (frequency)
    FrequencyArray = new int[(MAXRAND+1)];
    
//GETTING THE FREQUENCY OF EACH ELEMENT
    for (int i=0; i < n; i++) {
    FrequencyArray[ElementArray[i]]++;
    }  //Closing bracket for frequency of each element loop

//UNSORTED FREQUENCY LIST
    System.out.println("UNSORTED Frequency List: ");
    for (int i=MINRAND; i < (MAXRAND+1); i++) {;
        System.out.println("The number: " + i + " occured " + FrequencyArray[i] + " times");              
    }   //Closing bracket for unsorted frequency loop
    System.out.println("***************************************");

//SEE FREUQENCY OF ANY RANGE OF NUMBERS
    a = 0;
    System.out.println("Would you like to see the frequency of a range of numbers?");
    System.out.println("Type -1 for NO, anything else for YES");
    a = Integer.parseInt(Scanner.nextLine());
        if (a == -1) {
            System.exit(0);
        } //Closing bracket for if statement
    System.out.println("***************************************");
    System.out.println("Getting data to accomplish this:");
    System.out.println("Enter the minimum of the range");
    try {
        MinimumofEnteredRange = Integer.parseInt(Scanner.nextLine());
    }   //Closing bracket for try statement
    catch (NumberFormatException e) {    
        System.out.println("Error, please enter a numeric value");
        System.out.println("The Error: " + e); 
        return; 
        //Stops the program if catch statement catches error
    }   //Closing bracket for catch statement 
    System.out.println("***************************************");
    System.out.println("Enter the maximum of the range");
    try {
        MaximumofEnteredRange = Integer.parseInt(Scanner.nextLine());
    }   //Closing bracket for try statement
     catch (NumberFormatException e) {    
        System.out.println("Error, please enter a numeric value");
        System.out.println("The Error: " + e); 
        return; 
        //Stops the program if catch statement catches error
    }   //Closing bracket for catch statement 
    System.out.println("***************************************");
    //removing possible error that min is greater than max
    if (MinimumofEnteredRange > MaximumofEnteredRange) {
        System.out.println("Sorry, but your minimum is greater than your maximum, program terminates");
        System.exit(0);
    }   //Closing bracket for if statement
    SumofFrequencies=0;
    System.out.println("Answers:");
        for (int i=MinimumofEnteredRange; i <= MaximumofEnteredRange; i++) {
            System.out.println("The number: " + i + " occured: "+ FrequencyArray[i] + " time/s");
            SumofFrequencies = SumofFrequencies + FrequencyArray[i];
            } //Closing bracket for for loop
    System.out.println("The sum of frequencies in your range is: " + SumofFrequencies);
    System.out.println("***************************************");

//SEE RANGE OF NUMBERS BASED ON FREQUENCY
//Avoiding extra work that question four could have given me
//If want n times, simply set min and max to same number
    a = 0;
    System.out.println("Would you like to see any range of numbers based on frequency?");
    System.out.println("Type -1 for NO, anything else for YES");
    a = Integer.parseInt(Scanner.nextLine());
        if (a == -1) {
            System.exit(0);
        } //Closing bracket for if statement
    System.out.println("***************************************");
    System.out.println("Getting data to accomplish this");
    System.out.println("Enter the minimum of the frequency");
    try {
        MinimumofEnteredRange = Integer.parseInt(Scanner.nextLine());
    }   //Closing bracket for try statement
    catch (NumberFormatException e) {    
        System.out.println("Error, please enter a numeric value");
        System.out.println("The Error: " + e); 
        return; 
        //Stops the program if catch statement catches error
    }   //Closing bracket for catch statement 
    System.out.println("***************************************");
    System.out.println("Enter the maximum of the frequency");
    try {
        MaximumofEnteredRange = Integer.parseInt(Scanner.nextLine());
    }   //Closing bracket for try statement
    catch (NumberFormatException e) {    
        System.out.println("Error, please enter a numeric value");
        System.out.println("The Error: " + e); 
        return; 
        //Stops the program if catch statement catches error
    }   //Closing bracket for catch statement 
    System.out.println("***************************************");
    //removing possible error that min is greater than max
    if (MinimumofEnteredRange > MaximumofEnteredRange) {
        System.out.println("Sorry, but your minimum is greater than your maximum, program terminates");
        System.exit(0);
    }   //Closing bracket for if statement
    System.out.println("Answers:");
        for (int i=MINRAND; i < (MAXRAND+1); i++) {
            if ((FrequencyArray[i] >=MinimumofEnteredRange) && (FrequencyArray[i] <= MaximumofEnteredRange)) {
                System.out.println("The number: " + i + " appeared: "+ FrequencyArray[i] + " times");
            } //Closing bracket for if statement
    }   //Closing bracket for for loop
    System.out.println("***************************************");
            
//CLOSING FIN STREAM
    fin.close();                                                              
 
//CLOSING MESSAGE
    System.out.println("That is the end of my program, have a good evening!");
    
} //End main
    
    /****************************************************************************
    * Purpose:    Generates random numbers
    * Interface:  In:  none       
    * Out:  int number (this is the randomly generated)
    *****************************************************************************/
    public static int numberInput(int number) {
        Random randomNumber = new Random();
        number = randomNumber.nextInt(MAXRAND + 1 - MINRAND) + MINRAND;
        return number;
    }

} //End public class
