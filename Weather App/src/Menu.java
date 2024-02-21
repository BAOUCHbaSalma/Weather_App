import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public void ListChoix() throws SQLException {
        int Choix;
        City city=new City();

        do{
            System.out.println("1--Ajouter une ville ");
            System.out.println("2--Afficher une ville ");
            System.out.println("3--Modifier une ville  ");
            System.out.println("4--Supprimer une ville ");
            System.out.println("5--Ajouter un historique d'une ville ");
            System.out.println("6--Afficher un historique d'une ville ");
            System.out.println("7--Modifier un historique d'une ville ");
            System.out.println("8--Supprimer un historique d'une ville ");
            System.out.println("9--Quitter");
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
                     City.UpdateCity();
                     break;
                 case 4:
                     City.DeleteCity();
                     break;
                 case 5:
                     CityHistory.AddHistory();
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
