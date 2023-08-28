package com.example.equida2023;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import database.InitConnexion;
import database.VenteDAO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Vente;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    Connection connection;

    public void init() {

        ServletContext servletContext=getServletContext();
        message = (String)servletContext.getAttribute("message");
        System.out.println("equida" + message);

        connection = (Connection)servletContext.getAttribute("connection");
        System.out.println("connection ====" + connection.getClass());
        /*
        try
        {

            //chargement du driver
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Pilote Mariadb JDBC servlet init");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("Erreur lors du chargemement du pilote " + e.getMessage());
        }

        try
        {
            //obtention de la connexion
            //connection = DriverManager.getConnection ("jdbc:mariadb://127.0.0.1:3306/equimaria","USR_MARIA","mpMaria");
            //connection = DriverManager.getConnection ("jdbc:mariadb://172.20.177.250:3306/equimaria","UEQUI","mpEqui");
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3307/equida", "root", "");
            //sauvegarder la connexion dans le context
            //servletContext.setAttribute("connection",connection);
            System.out.println("Connexion opérationnelle projet Equida" + "jdbc:mariadb//localhost:3306/equida");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Erreur lors de l’établissementde la connexion equimaria 4 avril" + e.getMessage());
        }*/

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        /*response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");*/


        ArrayList<Vente> lesVentes = VenteDAO.getLesVentes(connection);
       // request.setAttribute("pLesVentes", lesVentes);
        Vente laVente = (Vente)lesVentes.get(0);
        String nomVente = laVente.getNom();
        System.out.println("VENTE"+nomVente);


        out.println("<html><body>");
        out.println("<h1>" + nomVente + "</h1>");
        out.println("</body></html>");
        //getServletContext().getRequestDispatcher("/vues/vente/listerLesVentes.jsp").forward(request, response);
    }

    public void destroy() {
    }
}