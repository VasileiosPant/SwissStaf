
package Basics;

public class City {
    private String name;
    private String id;
    private String xaxis;
    private String yaxis;
    public City(String startName, String startId, String startXaxis, String startYaxis){
        name = startName;
        id = startId;
        xaxis = startXaxis;
        yaxis = startYaxis;
    }
    public String getName(){
        return name;
    }
    public void setName(String newValue){
        name = newValue;
    }
    public String getId(){
        return id;
    }
    public void setId(String newValue){
        id = newValue;
    }
    public String getXaxis(){
        return xaxis;
    }
    public void setXaxis(String newValue){
        xaxis = newValue;
    }
    public String getYaxis(){
        return yaxis;
    }
    public void setYaxis(String newValue){
        yaxis = newValue;
    }
}
