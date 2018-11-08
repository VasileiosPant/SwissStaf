
package gui;

import Basics.City;
import Basics.Connections;
import Basics.ControlCenter;
import Basics.DataBase;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author tasosnikolakop
 */
public class BasicFrame extends javax.swing.JFrame {

    /**
     * Creates new form BasicFrame
     */
    public BasicFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        checkcities = new javax.swing.JButton();
        citiesfromdb = new javax.swing.JButton();
        connecttodb = new javax.swing.JButton();
        deletedatatable = new javax.swing.JButton();
        infoforcity = new javax.swing.JButton();
        directlink = new javax.swing.JButton();
        droptable = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Area = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("You can choose one of the following:");

        checkcities.setText("Open the file you just created (or the premade one) and view the cities with their data.");
        checkcities.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkcitiesActionPerformed(evt);
            }
        });

        citiesfromdb.setText("Recover data from DataBase and print them on the screen.");
        citiesfromdb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                citiesfromdbActionPerformed(evt);
            }
        });

        connecttodb.setText("Connect with DataBase and pass the cities' data to a table.");
        connecttodb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connecttodbActionPerformed(evt);
            }
        });

        deletedatatable.setText("Delete data from table.");
        deletedatatable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletedatatableActionPerformed(evt);
            }
        });

        infoforcity.setText("Get info for a specific city");
        infoforcity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoforcityActionPerformed(evt);
            }
        });

        directlink.setText("Check if two specific cities are linked with a direct route");
        directlink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                directlinkActionPerformed(evt);
            }
        });

        droptable.setText("Drop table.");
        droptable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                droptableActionPerformed(evt);
            }
        });

        Area.setColumns(20);
        Area.setRows(5);
        jScrollPane1.setViewportView(Area);

        jLabel2.setText("Output Screen (Here you can view the output of the orders above)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(163, 163, 163))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(citiesfromdb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(connecttodb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(checkcities, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(deletedatatable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(directlink, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(infoforcity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(droptable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(2, 2, 2)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(checkcities, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(connecttodb, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(citiesfromdb, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(droptable, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deletedatatable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(directlink, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(infoforcity, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addContainerGap())
        );

        checkcities.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    static Connection connector = null;
    DataBase theBase = new DataBase();
    private void checkcitiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkcitiesActionPerformed
        // TODO add your handling code here:
        String name="citiesdata";
        Area.append("\n\n\n\n");
        System.out.println("\n\n\n\n");
        Area.append("\n" + "Here are the cities and their data:");
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
            onereader = new BufferedReader(new FileReader("" + name + ".txt"));
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
                Area.append("\n" + CityCity.get(b).getName());
                System.out.println(CityCity.get(b).getName());
                Area.append("\n" + "id: " + CityCity.get(b).getId());
                System.out.println("id: " + CityCity.get(b).getId());
                Area.append("\n" + "x: " + CityCity.get(b).getXaxis());
                System.out.println("\n" + "x: " + CityCity.get(b).getXaxis());
                Area.append("\n" + "y: " + CityCity.get(b).getYaxis());
                System.out.println("y: " + CityCity.get(b).getYaxis());
                b++;
            }
            onereader.close();
            cityfilereader.close();
        
        } catch (IOException ex) {
            Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_checkcitiesActionPerformed
    ControlCenter orders = new ControlCenter();
    private void directlinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_directlinkActionPerformed
        // TODO add your handling code here:
        String name="citiesdata";
        BasicFrame theb = new BasicFrame();
       // String firstcity = (String)JOptionPane.showInputDialog(theb, "So, type a name for the new file where the cities and their data will be stored.");
        try {
        URL GetTheConnection, helper;
        helper = new URL("http://www.google.gr");
        URLConnection ConConnector;
        ConConnector = helper.openConnection();
        BufferedReader ConnectionOutput = new BufferedReader(new InputStreamReader(ConConnector.getInputStream()));
        Scanner input = new Scanner(System.in);
        String theLine;
        BufferedReader reader;
        String cityLine;
        BufferedReader newReader;
        int counter, newHelper;
        String citydataLine;
        boolean exists = false;
        String firstcity = (String)JOptionPane.showInputDialog(theb, "Type the name of the first city you wish to connect.");
        while (exists == false){
            reader = new BufferedReader(new FileReader("citiesonly.txt"));
             while ((cityLine = reader.readLine()) != null) {
                 if(firstcity.equals(cityLine)){
                     exists = true;
                     break;
                 }
             }
             if(exists == false){
                 firstcity = (String)JOptionPane.showInputDialog(theb, "You did not type a correct city name. Please try again.");
             } else if(exists == true){
                 break;
             }
        }
        String idno1 = new String();
        Boolean id1 = false;
        counter = 0;
        newHelper = 0;
        newReader = new BufferedReader(new FileReader("" + name + ".txt"));
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
        String secondcity = (String)JOptionPane.showInputDialog(theb, "Very well. Now please type the name of the second city you want"
                + " to connect the first with.");
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
                 secondcity = (String)JOptionPane.showInputDialog(theb, "You did not type a correct city name. Please try again.");
             } else if(exists == true){
                 break;
             }
        }
        String idno2 = new String();
        citydataLine = new String();
        Boolean id2 = false;
        counter = 0;
        newHelper = 0;
        newReader = new BufferedReader(new FileReader("" + name + ".txt"));
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
            Area.append("\n" + "There is indeed a direct route (connection) from " + firstcity + " to " + secondcity + ".");
            System.out.println("There is indeed a direct route (connection) from " + firstcity + " to " + secondcity + ".");
        } else {
            Area.append("\n" + "There is not a direct route / connection between these two cities.");
            System.out.println("There is not a direct route / connection between these two cities.");
        } 
        } catch (UnknownHostException ef) {
            Area.append("\n" + "Internet connection error. Please check your internet availability. Exit the programme "
                    + "and use it once your connection is solid again.");
            System.out.println("Internet connection error. Please check your internet availability. Exit the programme "
                    + "and use it once your connection is solid again.");

        } catch (IOException ed) {
            Area.append("\n" + "The process could not be complete. Please try again.");
            System.out.println("The process could not be complete. Please try again.");
        } catch (ParseException ex) {
            Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_directlinkActionPerformed

    private void connecttodbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connecttodbActionPerformed
        // TODO add your handling code here:
        String name="citiesdata";
        if (connector == null) {
            Area.append("\n" + "Testing the JDBC Oracle Connection.");
            System.out.println("Testing the JDBC Oracle Connection.");
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                Area.append("\n" + "Where is your Oracle JDBC Driver?");
                System.out.println("Where is your Oracle JDBC Driver?");
                e.printStackTrace();
                return;
            }
            Area.append("\n" + "Oracle JDBC Driver Registered!");
            System.out.println("Oracle JDBC Driver Registered!");
            try {
                String url = "jdbc:oracle:thin:@10.100.51.123:1521:orcl";
                String user = "it21477";
                String pass = "it21477";
                connector = (Connection) DriverManager.getConnection(url, user, pass);
            } catch (SQLException e) {
                Area.append("\n" + "Connection Failed! Check output console.");
                System.out.println("Connection Failed! Check output console.");
                e.printStackTrace();
            }
        }
        if (connector != null) {
            Area.append("\n" + "Very well...");
            System.out.println("Very well...");
        } else {
            Area.append("\n" + "Failed to make connection.");
            System.out.println("Failed to make connection.");
        }
        try {
            PreparedStatement PStatement = null;
        String SQLCreator = "CREATE TABLE cities("
                + "NAME VARCHAR(100) NOT NULL, "
                + "ID VARCHAR(100) NOT NULL,"
                + "COORDINATEX VARCHAR(100) NOT NULL, "
                + "COORDINATEY VARCHAR(100) NOT NULL"
                + ")";
        PStatement = connector.prepareStatement(SQLCreator);
        PStatement.executeUpdate();
        System.out.println("Table created!");
        } catch (SQLException exep) {
            Area.append("\n" + "An error occurred. The table might be already created.");
            System.out.println("An error occurred. The table might be already created.");
        }
        try {
            PreparedStatement PStatement = null;
        String SQLCreator = "CREATE TABLE cities("
                + "NAME VARCHAR(100) NOT NULL, "
                + "ID VARCHAR(100) NOT NULL,"
                + "COORDINATEX VARCHAR(100) NOT NULL, "
                + "COORDINATEY VARCHAR(100) NOT NULL"
                + ")";
        PStatement = connector.prepareStatement(SQLCreator);
        PStatement.executeUpdate();
        System.out.println("Table created!");
        } catch (SQLException exep) {
            Area.append("\n" + "An error occurred. The table might be already created.");
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
        BufferedReader areader = null;
        String aline;
        try {
            areader = new BufferedReader(new FileReader("" + name + ".txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while ((aline = areader.readLine()) != null) {
                if (tt == nme) {
                    cname = "" + aline;
                } else if (tt == iid) {
                    cid = "" + aline;
                } else if (tt == xxx) {
                    cxaxis = "" + aline;
                } else if (tt == yyy) {
                    cyaxis = "" + aline;
                        try{   
        String insertDataSQL = "INSERT INTO cities"
                + "(NAME, ID, COORDINATEX, COORDINATEY) VALUES"
                + "(?,?,?,?)";
        PreparedStatement insertPStatement = connector.prepareStatement(insertDataSQL);
        insertPStatement.setString(1, cname);
        insertPStatement.setString(2, cid);
        insertPStatement.setString(3, cxaxis);
        insertPStatement.setString(4, cyaxis);
        insertPStatement.executeUpdate();
        Area.append("\n" + "You have successfully inserted data.");
        System.out.println("You have successfully inserted data.");
        } catch (SQLException ed){
            Area.append("\n" + "An error occurred. Drop the table and create it again by executing step 2). If the problem remains, "
                    + "restart the programme.");
            System.out.println("An error occurred. Drop the table and create it again by executing step 2). If the problem remains, "
                    + "restart the programme.");
        }
                   
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
        } catch (IOException ex) {
            Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_connecttodbActionPerformed

    private void citiesfromdbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citiesfromdbActionPerformed
               
                try {
                DataBase.init();
                DataBase myDB = new DataBase();
                ArrayList<City> citiesfromdb = new ArrayList<City>();
                citiesfromdb = myDB.readCitiesFromDB();
                
                    int i = 0;
                    BufferedReader cityreader;
                    String lineline;
                    cityreader = new BufferedReader(new FileReader("citiesonly.txt"));
                    while ((lineline = cityreader.readLine()) != null) {
                        Area.append("\n" + citiesfromdb.get(i).getName());
                        System.out.println(citiesfromdb.get(i).getName());
                        Area.append("\n" + citiesfromdb.get(i).getId());
                        System.out.println(citiesfromdb.get(i).getId());
                        Area.append("\n" + citiesfromdb.get(i).getXaxis());
                        System.out.println(citiesfromdb.get(i).getXaxis());
                        Area.append("\n" + citiesfromdb.get(i).getYaxis());
                        System.out.println(citiesfromdb.get(i).getYaxis());
                        i++;
                    }
                    cityreader.close();
                    
                } catch (IndexOutOfBoundsException lp) {
                    Area.append("\n" + "Create a table first please.");
                    System.out.println("Create a table first please.");
                } catch (IOException ex) { 
            Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BasicFrame.class.getName()).log(Level.SEVERE, null, ex);
        } 

        
    }//GEN-LAST:event_citiesfromdbActionPerformed

    private void droptableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_droptableActionPerformed

        if (connector == null) {
            Area.append("\n" + "Testing the JDBC Oracle Connection.");
            System.out.println("Testing the JDBC Oracle Connection.");
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                Area.append("\n" + "Where is your Oracle JDBC Driver?");
                System.out.println("Where is your Oracle JDBC Driver?");
                e.printStackTrace();
                return;
            }
            Area.append("\n" + "Oracle JDBC Driver Registered!");
            System.out.println("Oracle JDBC Driver Registered!");
            try {
                String url = "jdbc:oracle:thin:@10.100.51.123:1521:orcl";
                String user = "it21477";
                String pass = "it21477";
                connector = (Connection) DriverManager.getConnection(url, user, pass);
            } catch (SQLException e) {
                Area.append("\n" + "Connection Failed! Check output console.");
                System.out.println("Connection Failed! Check output console.");
                e.printStackTrace();
            }
        }
        if (connector != null) {
            Area.append("\n" + "Very well...");
            System.out.println("Very well...");
        } else {
            Area.append("\n" + "Failed to make connection.");
            System.out.println("Failed to make connection.");
        }
    
        try{ 
        PreparedStatement PStatement = null;
        String SQLTableDroper = "DROP TABLE cities";
        PStatement = connector.prepareStatement(SQLTableDroper);
        PStatement.executeUpdate();
        Area.append("\n" + "Table dropped.");
        System.out.println("Table dropped.");
        } catch (SQLSyntaxErrorException deg) {
            Area.append("\n" + "Table already droped." );
            System.out.println("Table probably already droped. Go to step 2) to connect with DB and creat a 'cities' table.");
        } catch (SQLException ew) {
            Area.append("\n" + "Table already droped." );
            System.out.println("Table probably already droped. Go to step 2) to connect with DB and creat a 'cities' table.");
        }
    }//GEN-LAST:event_droptableActionPerformed

    private void deletedatatableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletedatatableActionPerformed

        if (connector == null) {
            Area.append("\n" + "Testing the JDBC Oracle Connection.");
            System.out.println("Testing the JDBC Oracle Connection.");
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                Area.append("\n" + "Where is your Oracle JDBC Driver?");
                System.out.println("Where is your Oracle JDBC Driver?");
                e.printStackTrace();
                return;
            }
            Area.append("\n" + "Oracle JDBC Driver Registered!");
            System.out.println("Oracle JDBC Driver Registered!");
            try {
                String url = "jdbc:oracle:thin:@10.100.51.123:1521:orcl";
                String user = "it21477";
                String pass = "it21477";
                connector = (Connection) DriverManager.getConnection(url, user, pass);
            } catch (SQLException e) {
                Area.append("\n" + "Connection Failed! Check output console.");
                System.out.println("Connection Failed! Check output console.");
                e.printStackTrace();
            }
        }
        if (connector != null) {
            Area.append("\n" + "Very well...");
            System.out.println("Very well...");
        } else {
            Area.append("\n" + "Failed to make connection.");
            System.out.println("Failed to make connection.");
        }
        try{
        PreparedStatement PStatement = null;
        String SQLDataDelete = "DELETE FROM cities";
        PStatement = connector.prepareStatement(SQLDataDelete);
        PStatement.executeUpdate();
        Area.append("\n" + "Data deleted from table.");
        System.out.println("Data deleted from table.");
        } catch (SQLSyntaxErrorException deg) {
            Area.append("\n" + "Table probably does not exist");
            System.out.println("Table probably does not exist. Create one by going to step 2).");
        } catch (SQLException ew) {
            Area.append("\n" + "able probably does not exist");
            System.out.println("Table probably does not exist. Create one by going to step 2).");
        }
    }//GEN-LAST:event_deletedatatableActionPerformed

    private void infoforcityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoforcityActionPerformed

        try {
        Scanner input = new Scanner(System.in);
        String answeryrn = new String();
        BasicFrame itson = new BasicFrame();
        String answer = (String)JOptionPane.showInputDialog(itson, "Type the name (or part of the name) of a city that you want to get it's info.");
        DataBase work = new DataBase();
        work.init();
        ArrayList<String> cityresults = new ArrayList<String>();
        cityresults = work.findtheCity(answer);
        if (cityresults.size() == 0) {
            Area.append("\n" + "Unfortunately, what you typed gave no results. Please make sure "
                    + "that you have a correct name or a correct names' part.");
            System.out.println("Unfortunately, what you typed gave no results. Please make sure "
                    + "that you have a correct name or a correct names' part.");
        } else {
            Area.append("\n" + "Your input gave the following results:");
            System.out.println("Your input gave the following results:");
            int i;
            for (i = 0; i <= (cityresults.size() - 1); i++) {
                Area.append("\n" + i + ")" + cityresults.get(i));
                System.out.println(i + ")" + cityresults.get(i));
            }
            String cityanswer = (String)JOptionPane.showInputDialog(itson, "Type one of the above city names, so you can get it's info.");
            boolean ahelp = false;
            while (ahelp == false) {
                for (i = 0; i <= (cityresults.size() - 1); i++) {
                    if (cityanswer.equals(cityresults.get(i))) {
                        ahelp = true;
                        break;
                    }
                }
                if (ahelp == true) {
                    break;
                } else {
                   cityanswer = (String)JOptionPane.showInputDialog(itson, "I did not understand. Please type one of the above names correctly.");
                }
            }
            work.init();
            System.out.println();
            ArrayList<City> TheComCity = work.returnCorrectCitysInfo(cityanswer);
            Area.append("\n" + "Name: " + TheComCity.get(0).getName());
            System.out.println("Name: " + TheComCity.get(0).getName());
            Area.append("\n" + "Id: " + TheComCity.get(0).getId());
            System.out.println("Id: " + TheComCity.get(0).getId());
            Area.append("\n" + "Xaxis: " + TheComCity.get(0).getXaxis());
            System.out.println("Xaxis: " + TheComCity.get(0).getXaxis());
            Area.append("\n" + "Yaxis: " + TheComCity.get(0).getYaxis());
            System.out.println("Yaxis: " + TheComCity.get(0).getYaxis());
        }
    } catch (SQLException ef){
        Area.append("\n" + "An error occurred. Please try again or restart the programme.");
        System.out.println("An error occurred. Please try again or restart the programme.");
    }
        
    }//GEN-LAST:event_infoforcityActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.htcheckcities     */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BasicFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BasicFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BasicFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BasicFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BasicFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Area;
    private javax.swing.JButton checkcities;
    private javax.swing.JButton citiesfromdb;
    private javax.swing.JButton connecttodb;
    private javax.swing.JButton deletedatatable;
    private javax.swing.JButton directlink;
    private javax.swing.JButton droptable;
    private javax.swing.JButton infoforcity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}