/**
 * Sabiha Khan
 * Implements a simple login system with the help of two Hashmaps.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import static java.lang.System.*;
public class Exercise1 {
    public static void main(String [] args) throws FileNotFoundException {

        Scanner kb = new Scanner(in);

        //Intializing HashMap with key as-username and value as-password.
        HashMap<String, String> loginDetails = new HashMap<>();

        //Intializing HashMap with key as-username and value as- full name.
        HashMap<String, String> name = new HashMap<>();

        String username, password, filename;

        //Prompting user to enter the name of the input file.
        out.println("Enter the name of the input file: ");
        filename = kb.next();

        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        //Add the key-value to each HashMap from the input file.
        while(inputFile.hasNext()){
            //Each input row (full name,username and password) is split with a tab from the input file.
            String [] rows = inputFile.nextLine().split("\t");

            loginDetails.put(rows[1], rows[2]); //Add the username as key and password as value to the first HashMap.
            name.put(rows[1], rows[0]); //Add the username as key and full name as value to the second HashMap.
        }

        int attempts = 3; //Variable to keep track of the login attempts.
        int i = 0;

        //Looping through each attempt of the user entering the login details and printing the desired output.
        while(i >= 0){

            //Prompting the user to enter the login details(username and password).
            out.print("\nLogin: ");
            username = kb.next();
            out.print("Password: ");
            password = kb.next();

            //Checks if username (from user input) is present in HashMap and if  username matches the password in the HashMap.
            if(loginDetails.containsKey(username) && loginDetails.get(username).equals(password)){

                //Prints this if the above condition is true and breaks the loop.
                out.println("\nLogin successful" +"\n" + "Welcome " + name.get(username) + "\n");
                break;
            }
            //If username is not present and does not the match the login details in the HashMap then.
            else {
                attempts--;
                //After the first unsuccessful login.
                if (attempts == 2) {
                    out.println("\nEither the username or password is incorrect. You have " + attempts + " more attempts.");
                }
                //After the second unsuccessful login.
                else if (attempts == 1){
                    out.println("\nEither the username or password is incorrect. You have " + attempts + " more attempt.");
                }
                //After the third unsuccessful login.
                else {
                    out.println("\nSorry. Incorrect login. Please contact the system administrator.");
                    break;
                }
            }
            i++;
        }
    }
}

