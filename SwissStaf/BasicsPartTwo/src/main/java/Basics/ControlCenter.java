
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
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ControlCenter {

    public void GetCitiesFromWiki() throws IOException {
        BufferedWriter writer;
        DataBase.init();
        File NewFile = new File("citiesonly.txt");
        writer = new BufferedWriter(new FileWriter(NewFile));
        Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_cities_in_Switzerland").userAgent("Safari").get();
        Elements AllTheCities = doc.select("div#mw-content-text").select("table.wikitable").select("tbody").select("tr td:eq(0)").select("td").select("a");
        for (Element link : AllTheCities) {
            writer.write(link.text() + "\n");
        }
        writer.close();
    }

    public void WriteCitiesToFile(String filename) throws FileNotFoundException, MalformedURLException, IOException, ParseException, SQLException {

        try {
            ArrayList<City> Cities = new ArrayList<City>();
            BufferedReader reader;
            reader = new BufferedReader(new FileReader("citiesonly.txt"));
            String line;
            URL GetTheId, helper;
            helper = new URL("http://www.google.gr");
            URLConnection connector;
            connector = helper.openConnection();
            BufferedReader AllInfo = new BufferedReader(new InputStreamReader(connector.getInputStream()));
            String inputLine;
            System.out.println("Please wait a few moments, as download is in progress...");

            while ((line = reader.readLine()) != null) {
                System.out.print(line);
                GetTheId = new URL("http://transport.opendata.ch/v1/locations?query=" + line);
                connector = GetTheId.openConnection();
                AllInfo = new BufferedReader(new InputStreamReader(connector.getInputStream()));
                inputLine = AllInfo.readLine();
                JSONParser parser = new JSONParser();
                JSONObject obj = (JSONObject) parser.parse(inputLine);
                Object anotherobject = (Object) obj.get("stations");
                JSONArray anotherjarray = (JSONArray) anotherobject;
                JSONObject onemoreobject = (JSONObject) anotherjarray.get(0);
                Object name = (Object) onemoreobject.get("name");
                Object id = (Object) onemoreobject.get("id");
                JSONObject coordinates = (JSONObject) onemoreobject.get("coordinate");
                Object xe = (Object) coordinates.get("x");
                String xeaxis = (xe.toString());
                Object ye = (Object) coordinates.get("y");
                String yeaxis = (ye.toString());
                System.out.println(" " + id);
                System.out.println("x: " + xeaxis);
                System.out.println("y: " + yeaxis);
                String cityname = name.toString();
                String cityid;
                if (id != null) {
                    cityid = (id.toString());

                } else {
                    cityid = "No id found for this city";
                }
                City randomcity = new City(line, cityid, xeaxis, yeaxis);
                Cities.add(randomcity);
            }

            BufferedWriter ela;
            File newfile = new File("" + filename + ".txt");
            ela = new BufferedWriter(new FileWriter(newfile));
            int i = 0;
            BufferedReader newfilereader;
            String line3;
            newfilereader = new BufferedReader(new FileReader("citiesonly.txt"));
            while ((line3 = newfilereader.readLine()) != null) {
                ela.write(Cities.get(i).getName());
                ela.write("\n");
                ela.write(Cities.get(i).getId());
                ela.write("\n");
                ela.write(Cities.get(i).getXaxis());
                ela.write("\n");
                ela.write(Cities.get(i).getYaxis());
                ela.write("\n");             
                i++;
            }
            reader.close();
            AllInfo.close();
            ela.close();
            newfilereader.close();
        } catch (UnknownHostException ef) {
            System.out.println("Internet connection error. Please check your internet availability. Exit the programme "
                    + "and use it once your connection is solid again.");

        } catch (IOException ed) {
            System.out.println("Download of cities and their data could not be complete, due to potential connection problem. "
                    + "Please exit the programme, reopen and try again.");
        }
    }

    public void CitiesToDB(String filename) throws FileNotFoundException, IOException, SQLException {
        DataBase.init();
        try {
            DataBase.CreateTable();
        } catch (SQLException exep) {
            System.out.println("An error occurred. The table might be already created.");
        }
        try {
            DataBase.CreateTable();
        } catch (SQLException exep) {
            System.out.println("An error occurred. The table might be already created.");
        }
        ArrayList<City> Citiesss = new ArrayList<City>();
        City NewCity;
        String cname = "";
        String cid = "";
        String cxaxis = "";
        String cyaxis = "";
        int nme = 0;
        int iid = 1;
        int xxx = 2;
        int yyy = 3;
        int tt = 0;
        BufferedReader areader;
        String aline;
        areader = new BufferedReader(new FileReader("" + filename + ".txt"));
        while ((aline = areader.readLine()) != null) {
            if (tt == nme) {
                cname = "" + aline;
            } else if (tt == iid) {
                cid = "" + aline;
            } else if (tt == xxx) {
                cxaxis = "" + aline;
            } else if (tt == yyy) {
                cyaxis = "" + aline;
                DataBase.WriteCitiesToDB(cname, cid, cxaxis, cyaxis);
            }
            tt++;
            if (tt > nme) {
                nme = nme + 4;
            }
            if (tt > iid) {
                iid = iid + 4;
            }
            if (tt > xxx) {
                xxx = xxx + 4;
            }
            if (tt > yyy) {
                yyy = yyy + 4;
            }
        }
    }

    public ArrayList<City> readCitiesFromFile(String filename) throws IOException {
        System.out.println("\n\n\n\n");
        System.out.println("Here are the cities and their data:");
        ArrayList<City> CityCity = new ArrayList<City>();
        City Cityyy;
        String ccname = "";
        String ccid = "";
        String ccxaxis = "";
        String ccyaxis = "";
        int nm = 0;
        int iidd = 1;
        int xx = 2;
        int yy = 3;
        int t = 0;
        BufferedReader onereader;
        String oneline;
        try {
            onereader = new BufferedReader(new FileReader("" + filename + ".txt"));
            while ((oneline = onereader.readLine()) != null) {
                if (t == nm) {
                    ccname = "" + oneline;
                } else if (t == iidd) {
                    ccid = "" + oneline;
                } else if (t == xx) {
                    ccxaxis = "" + oneline;
                } else if (t == yy) {
                    ccyaxis = "" + oneline;
                    Cityyy = new City(ccname, ccid, ccxaxis, ccyaxis);
                    CityCity.add(Cityyy);
                }
                t++;
                if (t > nm) {
                    nm = nm + 4;
                }
                if (t > iidd) {
                    iidd = iidd + 4;
                }
                if (t > xx) {
                    xx = xx + 4;
                }
                if (t > yy) {
                    yy = yy + 4;
                }
            }
            BufferedReader cityfilereader;
            int b = 0;
            String linefileline;
            cityfilereader = new BufferedReader(new FileReader("citiesonly.txt"));
            while ((linefileline = cityfilereader.readLine()) != null) {
                System.out.println(CityCity.get(b).getName());
                System.out.println("id: " + CityCity.get(b).getId());
                System.out.println("x: " + CityCity.get(b).getXaxis());
                System.out.println("y: " + CityCity.get(b).getYaxis());
                b++;
            }
            onereader.close();
            cityfilereader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. The list is empty.");
            return CityCity;
        } catch (IOException ex) {
            System.out.println("Error. Something occured.");
            return CityCity;
        }
        return CityCity;
    }

    public ArrayList<City> CitiesFromDBToOutput() throws SQLException, FileNotFoundException, IOException {
        DataBase.init();
        DataBase myDB = new DataBase();
        ArrayList<City> citiesfromdb = myDB.readCitiesFromDB();

        try {
             int i = 0;
            BufferedReader cityreader;
            String lineline;
            cityreader = new BufferedReader(new FileReader("citiesonly.txt"));
            while ((lineline = cityreader.readLine()) != null) {
                System.out.println(citiesfromdb.get(i).getName());
                System.out.println(citiesfromdb.get(i).getId());
                System.out.println(citiesfromdb.get(i).getXaxis());
                System.out.println(citiesfromdb.get(i).getYaxis());
                i++;
            }
            cityreader.close();
            return citiesfromdb;
        } catch (IndexOutOfBoundsException lp) {
            System.out.println("Create a table first please.");
            return citiesfromdb;
        }

    }
}
