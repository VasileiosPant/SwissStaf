
package Basics;

import java.sql.SQLException;


public class DataNotFoundException extends Exception{
        public DataNotFoundException(){
    }
    
    public DataNotFoundException(String message){
        super(message);
    }

}
