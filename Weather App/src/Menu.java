import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    public void ListChoix() throws SQLException {
        int Choix;
        City city=new City();
        CityHistory hCity=new CityHistory();


        do{
            System.out.println("1--Ajouter une ville ");
            System.out.println("2--Afficher une ville ");
            System.out.println("3--Modifier une ville  ");
            System.out.println("4--Supprimer une ville ");
            System.out.println("5--Ajouter un historique d'une ville ");
            System.out.println("6--Afficher un historique d'une ville ");
            System.out.println("7--Modifier un historique d'une ville ");
            System.out.println("8--Supprimer un historique d'une ville ");
            System.out.println("9--Chercher une ville");
            System.out.println("10--Chercher Historique d'une ville");
            System.out.println("11--Quitter");
            Choix=new Scanner(System.in).nextInt();
            switch (Choix){
                case 1:
                    System.out.println("Entrez le nom de la ville :");
                    city.setCityName(new Scanner(System.in).nextLine());
                    System.out.println("Entrez la température actuelle");
                    city.setCurrentTemperature(new Scanner(System.in).nextInt());
                    System.out.println("Entrez le taux d'humidité actuelle");
                    city.setCurrentHumidity(new Scanner(System.in).nextInt());
                    System.out.println("Entrez la vitesse du vent actuelle");
                    city.setCurrentWindSpeed(new Scanner(System.in).nextInt());
                    City.AddCity(city);

                    break;
                case 2:
                    System.out.println("_________________Les villes_____________________ ");
                    for(City ct : City.ShowCity()){
                        System.out.println("                                                 ");
                        System.out.println("id Ville : "+ct.getCityId());
                        System.out.println("Nom ville : "+ct.getCityName());
                        System.out.println("Température actuelle : "+ct.getCurrentTemperature());
                        System.out.println("Taux d'humidité actuelle : "+ct.getCurrentHumidity());
                        System.out.println("Vitesse du vent actuelle : "+ct.getCurrentWindSpeed());
                        System.out.println("____________________________________________________");

                    }

                    break;
                case 3:
                    System.out.println("id");
                    city.setCityId(new Scanner(System.in).nextInt());
                    System.out.println("Entrez le nouveau nom de la ville :");
                    city.setCityName(new Scanner(System.in).nextLine());
                    System.out.println("Entrez la nouvelle température actuelle");
                    city.setCurrentTemperature(new Scanner(System.in).nextInt());
                    System.out.println("Entrez le nouveau taux d'humidité actuelle");
                    city.setCurrentHumidity(new Scanner(System.in).nextInt());
                    System.out.println("Entrez la nouvelle vitesse du vent actuelle");
                    city.setCurrentWindSpeed(new Scanner(System.in).nextInt());
                    City.UpdateCity(city);
                    break;
                case 4:
                    System.out.println("Entrez id du ville que vous voullez supprimer");
                    city.setCityId(new Scanner(System.in).nextInt());
                    City.DeleteCity(city);
                    break;
                case 5:
                    System.out.println("Entrez id du ville que vous voullez ajouter");
                    hCity.setCityId(new Scanner(System.in).nextInt());
                    System.out.println("Entrez la date de l'événement météorologique historique (AAAA-MM-JJ)");
                    String inputDate = new Scanner(System.in).next();
                    hCity.setEventDate(LocalDate.parse(inputDate));
                    System.out.println("Entrez la Température historique");
                    hCity.setTemperature(new Scanner(System.in).nextInt());
                    CityHistory.AddHistory(hCity);

                    break;
                 case 6:
                     CityHistory.ShowHistory();
                     break;
                 case 7:
                     CityHistory.UpdateHistory();
                     break;
                 case 8:
                     CityHistory.DeleteHistory();
                     break;
                 case 9:
                     System.out.println("by by");
                     break;
                 default:
                     System.out.println("Choix invalide ");

             }
        }while(Choix!=9);
    }
}
