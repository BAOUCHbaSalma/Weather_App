import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CityHistory {


    public int getHistoricalDataId() {
        return historicalDataId;
    }

    public void setHistoricalDataId(int historicalDataId) {
        this.historicalDataId = historicalDataId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    private int historicalDataId;
    private int cityId;
    private LocalDate eventDate;
    private int temperature;

    public CityHistory(){}
    public CityHistory(int historicalDataId,int cityId,LocalDate eventDate,int temperature){
        this.historicalDataId=historicalDataId;
        this.eventDate=eventDate;
        this.temperature=temperature;
        this.cityId=cityId;

    }

    public static void AddHistory(CityHistory hCity)throws SQLException {
        String sql="INSERT INTO cityhistory (cityId,eventDate,temperature) values(?,?,?)";
        Connection connection=City.getConnection();
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setInt(1,hCity.getCityId());
        statement.setDate(2, Date.valueOf(hCity.getEventDate()));
        statement.setInt(3,hCity.getTemperature());
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("Historique est ajouter avec succes");





    }
    public static ArrayList<CityHistory> ShowHistory()throws SQLException{
        ArrayList<CityHistory> histoVilles=new ArrayList<>();
        String sql="SELECT * FROM cityhistory";
        Connection connection= City.getConnection();
        PreparedStatement statement=connection.prepareStatement(sql);
        ResultSet resultSet=statement.executeQuery();
        while (resultSet.next()){
            int historicalDataId =resultSet.getInt("historicalDataId");
            int cityId = resultSet.getInt("cityId");
            LocalDate eventDate = resultSet.getDate("eventDate").toLocalDate();
            int temperature = resultSet.getInt("temperature");
            histoVilles.add(new CityHistory(historicalDataId,cityId,eventDate,temperature));
        }
        connection.close();
        statement.close();

        return histoVilles;
    }
    public static void UpdateHistory(CityHistory hCity)throws SQLException{

        String sql="UPDATE  city SET cityId = ?, eventDate = ?, temperature =?  WHERE historicalDataId=?";
        Connection connection= City.getConnection();
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setInt(1,hCity.cityId);
        statement.setDate(2, Date.valueOf(hCity.eventDate));
        statement.setInt(3,hCity.temperature);
        statement.setInt(4,hCity.historicalDataId);
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("Ville mise a jour avec succes");
    }
    public static void DeleteHistory(CityHistory hCity)throws SQLException{
        String sql="DELETE FROM Ci WHERE cityId=?";
        Connection connection=City.getConnection();
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setInt(1,hCity.historicalDataId);
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("historique est suprimee avec succes");

    }
    public static void SearchCityHistory(int Id)throws SQLException{
        String sql = "SELECT ch.historicalDataId, ch.cityId, ch.eventDate, ch.temperature, c.cityName " +
                "FROM CityHistory ch " +
                "JOIN City c ON ch.cityId = c.cityId " +
                "WHERE ch.cityId = ?";
        Connection connection=City.getConnection();
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setInt(1,Id);
        ResultSet resultSet=statement.executeQuery();
        while (resultSet.next()){
            String name=resultSet.getString("cityName");

            int historicalDataId = resultSet.getInt("historicalDataId");

            int cityId = resultSet.getInt("cityId");

            int temperature = resultSet.getInt("temperature");

            LocalDate eventDate = resultSet.getDate("eventDate").toLocalDate();


            System.out.println("Historical Data ID: " + historicalDataId + "\n "+
                    "\n, City Name: " + name + "\n, Event Date: " + eventDate + "\n, Temperature: " + temperature);

        }


    }

}
