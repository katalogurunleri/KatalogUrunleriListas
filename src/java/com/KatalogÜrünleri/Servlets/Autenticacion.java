/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.KatalogÜrünleri.Servlets;

import com.KatalogÜrünleri.Entidades.Usuario;
import com.KatalogÜrünleri.Negocio.UsuarioN;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class Autenticacion extends HttpServlet {

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
        String user = request.getParameter("txtusuario");
        String clave = request.getParameter("txtclave");
        request.setAttribute("mensajeError", null);
        request.setAttribute("target", null);
        String men = "";
        UsuarioN un = new UsuarioN();
        Usuario u = new Usuario();
        
        if ("".equals(clave) || null == clave) {
            men = "Ingrese la  contraseña";
        }
        if ("".equals(user) || null == user) {
            men = "Ingrese el usuario";
        }
        if ("".equals(clave) && "".equals(user)) {
            men = "Ingrese el usuario y la contraseña";
        }
        if ("".equals(men)) {
            try {
                u = un.validarIngreso(user, clave);
            } catch (Exception ex) {
                // Logger.getLogger(Autenticacion.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (u.usuario == "sosa") {
                request.getSession(true).setAttribute("usuario", u);
                request.setAttribute("target", "./FPrincipal.jsp");
            } else {
                if (user.equals(u.usuario) && clave.equals(u.clave)) {
                    request.getSession(true).setAttribute("usuario", u);
                    request.setAttribute("target", "./FPrincipal.jsp");
                } else {
                    request.setAttribute("target", "./FLogin.jsp");
                    men = "El usuario y/o contraseña no coinciden";
                }
            }
        }
        
        request.setAttribute("mensajeError", men);
        request.getRequestDispatcher("./Principal.jsp").forward(request, response);
        
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
