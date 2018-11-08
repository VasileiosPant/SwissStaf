package Basics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Connections {
    public void CheckCityConnection(String cityfilename) throws FileNotFoundException, MalformedURLException, UnsupportedEncodingException, IOException, ParseException{
        try {
        URL GetTheConnection, helper;
        helper = new URL("http://www.google.gr");
        URLConnection ConConnector;
        ConConnector = helper.openConnection();
        BufferedReader ConnectionOutput = new BufferedReader(new InputStreamReader(ConConnector.getInputStream()));
        Scanner input = new Scanner(System.in);
        String firstcity = new String();
        String secondcity = new String();
        String theLine;
        BufferedReader reader;
        String cityLine;
        BufferedReader newReader;
        int counter, newHelper;
        String citydataLine;
        boolean exists = false;
        System.out.println("Type the name of the first city you wish to connect.");
        firstcity = input.nextLine();
        while (exists == false){
            reader = new BufferedReader(new FileReader("citiesonly.txt"));
             while ((cityLine = reader.readLine()) != null) {
                 if(firstcity.equals(cityLine)){
                     exists = true;
                     break;
                 }
             }
             if(exists == false){
                 System.out.println("You did not type a correct city name. Please try again.");
                 firstcity = input.nextLine();
             } else if(exists == true){
                 break;
             }
        }
        String idno1 = new String();
        Boolean id1 = false;
        counter = 0;
        newHelper = 0;
        newReader = new BufferedReader(new FileReader("" + cityfilename + ".txt"));
        while ((citydataLine = newReader.readLine()) != null) {
                 counter++;
                 if(firstcity.equals(citydataLine)){
                     id1 = true;
                     newHelper=counter;
                 }
                 if((id1 == true) && (newHelper == (counter-1))){
                         idno1=citydataLine;
                         break;
                     }
                     
        }
        if(idno1.equals("No id found for this city")){
            idno1 = ("" + firstcity);
        }
        System.out.println("Very well. Now please type the name of the second city you want"
                + " to connect the first with.");
        secondcity = input.nextLine();
        exists=false;
        while (exists == false){
            reader = new BufferedReader(new FileReader("citiesonly.txt"));
             while ((cityLine = reader.readLine()) != null) {
                 if(secondcity.equals(cityLine)){
                     exists=true;
                     break;
                 }
             }
             if(exists == false){
                 System.out.println("You did not type a correct city name. Please try again.");
                 secondcity = input.nextLine();
             } else if(exists == true){
                 break;
             }
        }
        String idno2 = new String();
        citydataLine = new String();
        Boolean id2 = false;
        counter = 0;
        newHelper = 0;
        newReader = new BufferedReader(new FileReader("" + cityfilename + ".txt"));
        while ((citydataLine = newReader.readLine()) != null) {
                 counter++;
                 if(secondcity.equals(citydataLine)){
                     id2 = true;
                     newHelper=counter;
                 }
                 if((id2 == true) && (newHelper == (counter-1))){
                         idno2=citydataLine;
                         break;
                     }
                     
        }
        if(idno2.equals("No id found for this city")){
            idno2 = ("" + secondcity);
        }
        GetTheConnection = new URL("http://transport.opendata.ch/v1/connections?from=" 
                + idno1 + "&to=" + idno2 + "&direct=1");
        ConConnector = GetTheConnection.openConnection();
        ConnectionOutput = new BufferedReader(new InputStreamReader(ConConnector.getInputStream()));
        theLine = ConnectionOutput.readLine();
        JSONParser parser = new JSONParser();
        JSONObject helpObject = (JSONObject) parser.parse(theLine);
        Object anotherobject = (Object) helpObject.get("connections");
        String conconcon = (anotherobject.toString());
        if(conconcon.equals("[]")){
            System.out.println("There is indeed a direct route (connection) from " + firstcity + " to " + secondcity + ".");
        } else {
            System.out.println("There is not a direct route / connection between these two cities.");
        } 
        } catch (UnknownHostException ef) {
            System.out.println("Internet connection error. Please check your internet availability. Exit the programme "
                    + "and use it once your connection is solid again.");

        } catch (IOException ed) {
            System.out.println("The process could not be complete. Please try again.");
        }
    }
}
