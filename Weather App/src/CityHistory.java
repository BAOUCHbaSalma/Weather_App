import java.sql.SQLException;

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

    public int getEventDate() {
        return eventDate;
    }

    public void setEventDate(int eventDate) {
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
    private int eventDate;
    private int temperature;

    public CityHistory(int historicalDataId,int cityId,int eventDate,int temperature){
        this.historicalDataId=historicalDataId;
        this.eventDate=eventDate;
        this.temperature=temperature;
        this.cityId=cityId;

    }

    public static void AddHistory()throws SQLException {
        City.getConnection();


    }
    public static void ShowHistory(){

    }
    public static void UpdateHistory(){

    }
    public static void DeleteHistory(){

    }

}
