import java.sql.*;

public class Mysql {
    public static void connectToDb(){ // A ajouter, des arguments supplémentaire pour l'insertion des données.
        try {
            Class.forName("com.mysql.jdbc.Driver"); //Aucune idée de ce que ça fait
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SAE", "root", null); //Etablit une connection avec le SGBD
            Statement stmt = con.createStatement(); //Création d'une variable statement utilisé plus tard pour faire les requêtes.
        }catch(Exception e){System.out.println(e);}
    }
}
