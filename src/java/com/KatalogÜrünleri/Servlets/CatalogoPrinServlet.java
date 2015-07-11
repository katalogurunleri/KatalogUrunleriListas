/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.KatalogÜrünleri.Servlets;

import com.KatalogÜrünleri.Entidades.Producto;
import com.KatalogÜrünleri.Negocio.ProductoN;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Brayan Sosa
 */
public class CatalogoPrinServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String modulo = "CatalogoPrin.jsp";// enviar respuesta
        request.setAttribute("targetModulo", modulo);
        // Traer par�metros de la petici�n
        // Hecha desde FUsuario.jsp
        String cod = request.getParameter("txtcodpro");
        String nom = request.getParameter("txtnombre");
        String des = request.getParameter("txtdescrip");
        String exi = request.getParameter("txtexis");
        String val = request.getParameter("txtvalor");
        String fot = request.getParameter("filefoto");
        String est = request.getParameter("cboestado");

        String men = "";// para los mensajes
        ProductoN pn = new ProductoN();// Creamos un Objeto
        // de tipo UsuarioN();
        // Establecemos atributos e inicializamos en null
        request.setAttribute("listado", null);
        // m�todo vacio espera dos par�metros:
        // 1. String--> nombre del atributo
        // 2. Object --> Object a establecer 
        request.setAttribute("mensaje", null);
        // Creamos un atributo para recuperar
        // Un dato de consulta(de Un Usuario x)
        request.setAttribute("datoproducto", null);
        // hay un bot�n con name = action y
        // con una propiedad value = buscar
        // si(buscar es igual a un par�metro de una petici�n)
        //llamada action   

        if ("listar".equals(request.getParameter("action"))) {
            try {
                if (pn.listar() != null) {
                    Producto aux = pn.listar();
                    if (aux.catprin.equals("Si")) {
                        while (aux != null) {
                            men += " <script>"
                                    + "$(function() {"
                                    + "$(\"#dialog\").dialog({"
                                    + "modal: true,"
                                    + "autoOpen: false,"
                                    + "show: {"
                                    + "effect: \"blind\","
                                    + "duration: 1000"
                                    + "},"
                                    + "hide: {"
                                    + "effect: \"explode\","
                                    + "duration: 1000"
                                    + " }"
                                    + "});"
                                    + "$(\"#" + aux.codpro + "\").click(function() {"
                                    + "$(\"." + aux.nombre + "\").dialog(\"open\");"
                                    + "});"
                                    + "$(\"#zoom\").elevateZoom({tint: true, tintColour: '#033', tintOpacity: 0.5});"
                                    + "});"
                                    + "</script>"
                                    + "<!--"
                                    + "<div id=\"dialog\" class=\"" + aux.codpro + "\"  title=\"" + aux.nombre + "\">"
                                    + "<center> <img id=\"zoom\" src=\"ImaCatalogo/" + aux.foto + "\" height=\"250\" width=\"250\"  id=\"opener\"/>  </center>"
                                    + "<p width=\"50%\"><b>Código:</b>" + aux.codpro + " <br> <b>Descripción:</b>" + aux.descripcion + "</p>"
                                    + "</div>"
                                    + "-->"
                                    + "<div class=\"menu\" id=\"menu\" >"
                                    + "<ul id=\"boton\">"
                                    + "<li id=\"letra\">"
                                    + "<center><img id=\"" + aux.codpro + "\" id=\"img\" src=\"ImaCatalogo/" + aux.foto + "\" width=\"80\" height=\"80\">"
                                    + "<br>"
                                    + "<p id=\"txtcat\"><b>" + aux.nombre + "</b></p></center>"
                                    + "</li> "
                                    + "</div>";
                            aux = aux.apuntador;
                        }
                    }

                } else {
                    men += "<center><h3 style=\"font-family: Arial;\">No hay productos agregados </h3></center>";
                }
            } catch (Exception er) {
                request.setAttribute(men, er.getMessage());
            }
        }// fin listar

        request.setAttribute("mensaje", men);
        request.getRequestDispatcher(modulo).forward(request, response);
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
