import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public void ListChoix() throws SQLException {
        int Choix;

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
                     City.AddCity();
                     break;
                 case 2:
                     City.ShowCity();
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
