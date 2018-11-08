/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author tasosnikolakop
 */
public class Connection {
     void ConnectToApi() throws ParseException, FileNotFoundException, MalformedURLException, IOException {
    BufferedReader reader;
         reader = new BufferedReader(new FileReader("citiesonly.txt"));
         String line;
         URL GetTheId, helper;
         helper = new URL("http://www.google.gr");
         URLConnection connector;
         connector = helper.openConnection();
         BufferedReader AllInfo = new BufferedReader(new InputStreamReader(connector.getInputStream()));
         String inputLine;
         BufferedWriter ela;
         File xamos = new File("cities.txt");
         ela = new BufferedWriter(new FileWriter(xamos));
         while((line = reader.readLine()) != null) {
            System.out.print(line);
            GetTheId = new URL("http://transport.opendata.ch/v1/locations?query=" + line);
            connector = GetTheId.openConnection();
            AllInfo = new BufferedReader(new InputStreamReader(connector.getInputStream()));
            inputLine = AllInfo.readLine();
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(inputLine);
            Object opa = (Object) obj.get("stations");
            JSONArray johanna = (JSONArray) opa;
            JSONObject hey = (JSONObject) johanna.get(0);
            Object name = (Object) hey.get("name");
            Object id = (Object) hey.get("id");
            JSONObject coordinates = (JSONObject) hey.get("coordinate");
            Object xe = (Object) coordinates.get("x");
            String xeaxis = ("x: " + xe.toString());
            Object ye = (Object) coordinates.get("y");
            String yeaxis =("y: " + ye.toString());
            System.out.println(" " + id);
            System.out.println(" " + xeaxis);
            System.out.println(" " + yeaxis);
            String cityname = name.toString();
            String cityid;
            if (id != null) {
                cityid =("id: " + id.toString());
            } else {
                cityid = "No id found for this city";
            }
           ela.write(line);
           ela.write(" ");
           ela.write(cityid);
           ela.write(" ");
           ela.write(xeaxis);
           ela.write(" ");
           ela.write(yeaxis);
           ela.write("\n");
        }
        reader.close();
        AllInfo.close();
        ela.close();
    }
}
