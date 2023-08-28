package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
/**
 *
 * @author Zakina
 */
public class InitConnexion implements ServletContextListener {
    //parametres de connexion
    Connection connection=null;
    String pilotejdbc=null;
    String urlconnexionjdbc=null;
    String utilisateurjdbc=null;
    String motdepassejdbc=null;

    //action déclenchée lors du chargement du context
    public void contextInitialized(ServletContextEvent event)
    {
        ServletContext servletContext = event.getServletContext();

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur lors du chargemement du pilote " + e.getMessage());
            throw new RuntimeException(e);
        }


        try
        {
            //
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("chargement du driver Pilote Mariadb JDBC");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("Erreur lors du chargemement du pilote " + e.getMessage());
        }

        try
        {

            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3307/equida", "root", "");
            //sauvegarder la connexion dans le context
            servletContext.setAttribute("connection",connection);
            System.out.println("Connexion opérationnelle projet Equida" + "jdbc:mariadb//localhost:3306/equida");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Erreur lors de l’établissementde la connexion " + e.getMessage());
        }


    }

    //action qui permet de détruire le filtre
    public void contextDestroyed(ServletContextEvent event)
    {

        System.out.println("----------- Contexte détruit -----------");
        try
        {
            //fermeture
            Utilitaire.fermerConnexion(connection);
            System.out.println("Connexion fermée ");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            Utilitaire.fermerConnexion(connection);
        }
    }

}

