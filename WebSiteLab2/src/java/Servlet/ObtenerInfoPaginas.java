/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;
/*
 * Servlet que retorna una lista con las paginas que estan registradas en la DB.
 */

import CLIENTE.NewJerseyClient;
import DTO.FeedObjects;
import com.google.gson.Gson;
import com.google.gson.internal.StringMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joaquin David
 */
public class ObtenerInfoPaginas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String webJson = "";
       
             // Instanciamos el cliente del WS
            NewJerseyClient cliente = new NewJerseyClient();
        //Hacemos el llamado al WS mediante el metodo GET que nos retorna un objeto json que contiene las paginas
        webJson = cliente.feed();
        // Si esta vacio es porque ocurrio un error de conexion
        if("".equals(webJson)){
            request.setAttribute("paginas", null);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Paginas.jsp");
            dispatcher.forward(request, response);
            return;
        }
        Gson gson = new Gson();
        // convertimos el json a una lista utilizando la libreria GSON
        List paginas = gson.fromJson(webJson, List.class);
        List paginasFinal = new ArrayList();
        if(paginas == null ){
            request.setAttribute("paginas", null);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Paginas.jsp");
            dispatcher.forward(request, response);
            return;
        }
        // Recorremos la Lista para sacar la informacion de cada pagina
        for (int i = 0; i < paginas.size(); i++) {
            StringMap pagina = (StringMap) paginas.get(i);
            FeedObjects paginaActual = new FeedObjects();;
            paginaActual.setDescription((String) pagina.get("description"));
            paginaActual.setTitle((String) pagina.get("title"));
            paginaActual.setUrl((String) pagina.get("url"));
            paginasFinal.add(paginaActual);
        }
        // Enviamos la informacion al jsp para que la muestre al usuario
        request.setAttribute("paginas", paginasFinal);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Paginas.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
