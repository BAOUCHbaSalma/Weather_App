import java.sql.*;
import java.util.ArrayList;

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
    public City(){}
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

    public static void AddCity(City city)throws SQLException{

        String sql="INSERT INTO city (cityName,currentTemperature,currentHumidity,currentWindSpeed) values(?,?,?,?)";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,city.cityName);
        statement.setInt(2,city.currentTemperature);
        statement.setInt(3,city.currentHumidity);
        statement.setInt(4,city.currentWindSpeed);
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("Ville ajoute avec succes");


    }
    public static ArrayList<City> ShowCity()throws SQLException{
        ArrayList<City>villes=new ArrayList<>();
        String sql="SELECT*FROM city";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet=statement.executeQuery();
        while (resultSet.next()){
            int cityId= resultSet.getInt("cityId");
            String cityName=resultSet.getString("cityName");
            int currentTemperature=resultSet.getInt("currentTemperature");
            int currentHumidity=resultSet.getInt("currentHumidity");
            int currentWindSpeed=resultSet.getInt("currentWindSpeed");
            villes.add(new City(cityId,cityName,currentTemperature,currentHumidity,currentWindSpeed));

        }
        return villes;
    }






    public static void UpdateCity()throws SQLException{

    }

    public static void DeleteCity()throws SQLException{

    }


    }













