
package Basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;


public class DataBase {

    static Connection connector = null;

    public static void init() {
        if (connector == null) {
            System.out.println("Testing the JDBC Oracle Connection.");
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                System.out.println("Where is your Oracle JDBC Driver?");
                e.printStackTrace();
                return;
            }
            System.out.println("Oracle JDBC Driver Registered!");
            try {
                String url = "jdbc:oracle:thin:@10.100.51.123:1521:orcl";
                String user = "it21477";
                String pass = "it21477";
                connector = (Connection) DriverManager.getConnection(url, user, pass);
            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console.");
                e.printStackTrace();
            }
        }
        if (connector != null) {
            System.out.println("Very well...");
        } else {
            System.out.println("Failed to make connection.");
        }
    }
    
    public static void CreateTable() throws SQLException{
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
    }
    
    public static void WriteCitiesToDB(String citname, String citid, String citxaxis, String cityaxis) throws SQLException{
        try{
        String insertDataSQL = "INSERT INTO cities"
                + "(NAME, ID, COORDINATEX, COORDINATEY) VALUES"
                + "(?,?,?,?)";
        PreparedStatement insertPStatement = connector.prepareStatement(insertDataSQL);
        insertPStatement.setString(1, citname);
        insertPStatement.setString(2, citid);
        insertPStatement.setString(3, citxaxis);
        insertPStatement.setString(4, cityaxis);
        insertPStatement.executeUpdate();
        System.out.println("You have successfully inserted data.");
        } catch (SQLException ed){
            System.out.println("An error occurred. Drop the table and create it again by executing step 2). If the problem remains, "
                    + "restart the programme.");
        }
        
    }
    
    public static void CheckData() throws DataNotFoundException, SQLException {
        
        PreparedStatement preparedStatement = null;
        String query = "SELECT COUNT(NAME) FROM cities";
        preparedStatement = connector.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        String count = null;
        if(rs.next()) {
        count = rs.getString(1);
        }
        int countint = Integer.parseInt(count);
        int numberofcities = 225;
        if(numberofcities == countint){
            
           System.out.println("table has data.");
        }
        
    }
    
    
    public static void DropTable() throws SQLException{
        try{
        PreparedStatement PStatement = null;
        String SQLTableDroper = "DROP TABLE cities";
        PStatement = connector.prepareStatement(SQLTableDroper);
        PStatement.executeUpdate();
        System.out.println("Table droped.");
        } catch (SQLSyntaxErrorException deg) {
            System.out.println("Table probably already droped. Go to step 2) to connect with DB and creat a 'cities' table.");
        } catch (SQLException ew) {
            System.out.println("Table probably already droped. Go to step 2) to connect with DB and creat a 'cities' table.");
        }
    }
    
    public static void resetDatabase() throws SQLException{
        try{
        PreparedStatement PStatement = null;
        String SQLDataDelete = "DELETE FROM cities";
        PStatement = connector.prepareStatement(SQLDataDelete);
        PStatement.executeUpdate();
        System.out.println("Data deleted from table.");
        } catch (SQLSyntaxErrorException deg) {
            System.out.println("Table probably does not exist. Create one by going to step 2).");
        } catch (SQLException ew) {
            System.out.println("Table probably does not exist. Create one by going to step 2).");
        }
    }
    
    public ArrayList<City> readCitiesFromDB() throws SQLException{
        ArrayList<City> allCities = new ArrayList<City>();
       try{
        PreparedStatement PStatementName = null;
        PreparedStatement PStatementId = null;
        PreparedStatement PStatementCoox = null;
        PreparedStatement PStatementCooy = null;
        String namequery = "SELECT NAME FROM cities";
        String idquery = "SELECT ID FROM cities";
        String cooxquery = "SELECT COORDINATEX FROM cities";
        String cooyquery = "SELECT COORDINATEY FROM cities";
        PStatementName = connector.prepareStatement(namequery);
        PStatementId = connector.prepareStatement(idquery);
        PStatementCoox = connector.prepareStatement(cooxquery);
        PStatementCooy = connector.prepareStatement(cooyquery);
        ResultSet rsname = PStatementName.executeQuery();
        ResultSet rsid = PStatementId.executeQuery();
        ResultSet rscoox = PStatementCoox.executeQuery();
        ResultSet rscooy = PStatementCooy.executeQuery();
        
        City aCity;
        while((rsname.next() == true) && (rsid.next() == true) && (rscoox.next() == true) && (rscooy.next() == true))  {
         aCity = new City(rsname.getString(1), rsid.getString(1), rscoox.getString(1), rscooy.getString(1));
         allCities.add(aCity);
     }
        return allCities;
       } catch (SQLSyntaxErrorException ert) {
           System.out.println("There is a high chance that you've not created a table. Do so by executing step 2).");
           return allCities;
       } catch (SQLException etl) {
           System.out.println("There is a high chance that you've not created a table. Do so by executing step 2).");
           return allCities;
   } catch (IndexOutOfBoundsException lp){
       System.out.println("There is a high chance that you've not created a table. Do so by executing step 2).");
       return allCities;
   }
}
}
    

