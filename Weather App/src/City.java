import java.sql.*;
import java.sql.ResultSetMetaData;

public class City {


    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(int currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public int getCurrentHumidity() {
        return currentHumidity;
    }

    public void setCurrentHumidity(int currentHumidity) {
        this.currentHumidity = currentHumidity;
    }

    public int getCurrentWindSpeed() {
        return currentWindSpeed;
    }

    public void setCurrentWindSpeed(int currentWindSpeed) {
        this.currentWindSpeed = currentWindSpeed;
    }
    private int cityId;
    private String cityName;
    private int currentTemperature;
    private int currentHumidity;
    private int currentWindSpeed;
    public City(int cityId,String cityName,int currentTemperature,int currentHumidity,int currentWindSpeed){
          this.cityId=cityId;
          this.cityName=cityName;
          this.currentTemperature=currentTemperature;
          this.currentHumidity=currentHumidity;
          this.currentWindSpeed=currentWindSpeed;
    }
    private static final String URL = "jdbc:mysql://localhost/weather_app?serverTimeZone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return java.sql.DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void AddCity()throws SQLException{

        String sql="INSERT INTO weather_app(cityId,cityName,currentTemperature,currentHumidity,currentWindSpeed) values(?,?,?,?,?)";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        System.out.println("Ville ajoute avec succes");


    }

    public static void ShowCity()throws SQLException{

    }

    public static void UpdateCity()throws SQLException{

    }

    public static void DeleteCity()throws SQLException{

    }


    }













