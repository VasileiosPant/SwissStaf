
package Basics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Scanner;
import org.json.simple.parser.ParseException;


public class OutputInput {
    ControlCenter orders = new ControlCenter();
    Scanner input = new Scanner(System.in);
    String answer = new String();
    boolean end = false;
    

    public void TheProgramm(String newanswer) throws MalformedURLException, IOException, FileNotFoundException, ParseException, SQLException {
        while (end == false) {
            System.out.println();
            System.out.println("Now, choose what you want to do from the following, by typing it's number (1-8):");
            System.out.println("1) Open the file you just created (or the premade one) and view the cities with their data.");
            System.out.println("2) Connect with DataBase and pass the cities' data to a table.");
            System.out.println("3) Recover data from DataBase and print them on the screen.");
            System.out.println("4) Delete data from table.");
            System.out.println("5) Drop table.");
            System.out.println("6) Check if two specific cities are linked with a direct route.");
            System.out.println("7) Get info for a specific city.");
            System.out.println("8) Exit.");
            answer = input.nextLine();
            boolean helper = false;
            while (helper == false) {
                if ((answer.equals("1")) || (answer.equals("1)"))) {
                    helper = true;
                    orders.readCitiesFromFile(newanswer);
                } else if ((answer.equals("2")) || (answer.equals("2)"))) {                    
                    helper = true;                   
                    orders.CitiesToDB(newanswer);
                } else if ((answer.equals("3")) || (answer.equals("3)"))) {
                    helper = true;
                    orders.CitiesFromDBToOutput();
                } else if ((answer.equals("4")) || (answer.equals("4)"))) {
                    helper = true;
                    DataBase.init();
                    DataBase.resetDatabase();
                } else if ((answer.equals("5")) || (answer.equals("5)"))) {
                    helper = true;
                    DataBase.init();
                    DataBase.DropTable();
                } else if ((answer.equals("6")) || (answer.equals("6)"))) {
                    helper = true;
                    Connections TheConnections = new Connections();
                    TheConnections.CheckCityConnection(newanswer);
                } else if ((answer.equals("7")) || (answer.equals("7)"))) {
                    helper = true;
                    orders.findCityFromGivenStuff();
                } else if ((answer.equals("8")) || (answer.equals("8)"))) {
                    helper = true;
                    end = true;
                    break;
                } else {
                    System.out.println("You have not typed one of the numbers above. Please type again.");
                    answer = input.nextLine();
                }
            }
            if (end == true) {
                break;
            }
        }
    }
}
