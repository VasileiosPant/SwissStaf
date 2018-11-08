package Basics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, SQLException, FileNotFoundException, MalformedURLException, ParseException, DataNotFoundException {

        ControlCenter orders = new ControlCenter();
        System.out.println("Hello. First of all, we are going to download the cities and write both them and their data into a file.");
        Scanner input = new Scanner(System.in);
        String answer = new String();
        String answeryrn = "No";
        System.out.println("So, type a name for the file where the cities and their data will be stored.");
        answer = input.nextLine();
        while (answeryrn.equals("No") || answeryrn.equals("NO") || answeryrn.equals("no")) {
            System.out.println("You have typed the following name: " + "" + answer + "."
                    + " Do you want to keep it for sure (Yes or No for answer)?");
            answeryrn = input.nextLine();
            while (!(answeryrn.equals("No")) && !(answeryrn.equals("NO")) && !(answeryrn.equals("no"))
                    && !(answeryrn.equals("Yes")) && !(answeryrn.equals("YES")) && !(answeryrn.equals("yes"))) {
                System.out.println("I did not understand. Type again, yes or no.");
                answeryrn = input.nextLine();
            }
            if (answeryrn.equals("No") || answeryrn.equals("NO") || answeryrn.equals("no")) {
                System.out.println("Type again a name for the file where the cities and their data will be stored.");
                answer = input.nextLine();
            } else if (answeryrn.equals("Yes") || answeryrn.equals("YES") || answeryrn.equals("yes")) {
                break;
            }
        }
            System.out.println("Very good.");
            orders.WriteCitiesToFile(answer);
            OutputInput stuff = new OutputInput();
            stuff.TheProgramm(answer);
            System.out.println("Goodbye.");
   
        }
    }
