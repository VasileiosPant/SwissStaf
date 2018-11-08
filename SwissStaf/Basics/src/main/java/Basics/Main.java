/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basics;

import java.io.IOException;
import org.json.simple.parser.ParseException;
/**
 *
 * @author tasosnikolakop
 */
public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Connection ApiConnection = new Connection();
        Location CitiesWikipedia = new Location(); 
        CitiesWikipedia.GetCitiesFromWiki();
        ApiConnection.ConnectToApi();
        
    
    }
}
