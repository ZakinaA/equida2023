package servlet;

import database.VenteDAO;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Vente;


import jakarta.servlet.annotation.*;

//@WebServlet(name = "servletVente", value = "/servletVente")
public class ServletVente extends HttpServlet {

    Connection connection;

    @Override
    public void init() {
        ServletContext servletContext = getServletContext();
        connection = (Connection) servletContext.getAttribute("connection");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = request.getRequestURI();

        // Récup et affichage par date décroissante de toutes les ventes
        if (url.equals("/equida2023_war_exploded/ServletVente/listerLesVentes")) {
            ArrayList<Vente> lesVentes = VenteDAO.getLesVentes(connection);
            request.setAttribute("pLesVentes", lesVentes);
            getServletContext().getRequestDispatcher("/vues/vente/listerLesVentes.jsp").forward(request, response);

        }
    }
}