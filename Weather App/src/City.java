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
        statement.setString(1,city.getCityName());
        statement.setInt(2,city.getCurrentTemperature());
        statement.setInt(3,city.getCurrentHumidity());
        statement.setInt(4,city.getCurrentWindSpeed());
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






    public static void UpdateCity(City city)throws SQLException{
        String sql="UPDATE  city SET cityName = ?, currentTemperature = ?, currentHumidity =? , currentWindSpeed=? WHERE cityId=?";
        Connection connection=getConnection();
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,city.getCityName());
        statement.setInt(2,city.getCurrentTemperature());
        statement.setInt(3,city.getCurrentHumidity());
        statement.setInt(4,city.getCurrentWindSpeed());
        statement.setInt(5,city.getCityId());
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("Ville mise a jour avec succes");

    }

    public static void DeleteCity(City city)throws SQLException{
        String sql="DELETE FROM city WHERE cityId=?";
        Connection connection=getConnection();
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setInt(1,city.cityId);
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("ville est suprimee avec succes");



    }




    public static void SearchCity(String name)throws SQLException{
        ArrayList<City> search = new ArrayList<>();
        String sql="SELECT * FROM city WHERE cityName = ?";
        Connection connection=getConnection();
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,name);
        ResultSet resultSet= statement.executeQuery();
        while (resultSet.next()){
            int cityId= resultSet.getInt("cityId");
            String cityName=resultSet.getString("cityName");
            int currentTemperature=resultSet.getInt("currentTemperature");
            int currentHumidity=resultSet.getInt("currentHumidity");
            int currentWindSpeed=resultSet.getInt("currentWindSpeed");
            search.add(new City(cityId,cityName,currentTemperature,currentHumidity,currentWindSpeed));
            System.out.println("Id: "+cityId+"\n Name: "+cityName+"\n currentTemperature: "+currentTemperature+"\n currentHumidity: "+currentWindSpeed);
        }

        connection.close();
        statement.close();




    }


}













