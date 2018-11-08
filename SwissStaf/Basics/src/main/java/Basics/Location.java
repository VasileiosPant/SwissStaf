/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author tasosnikolakop
 */
public class Location {
    void GetCitiesFromWiki() throws IOException {
        BufferedWriter writer;
        File NewFile = new File("citiesonly.txt");
        writer = new BufferedWriter(new FileWriter(NewFile));
        Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_cities_in_Switzerland").userAgent("Safari").get();
        Elements AllTheCities = doc.select("div#mw-content-text").select("table.wikitable").select("tbody").select("tr td:eq(0)").select("td").select("a");  
        for( Element link : AllTheCities ){
            writer.write(link.text() + "\n");
        }
        writer.close();
    }
}
