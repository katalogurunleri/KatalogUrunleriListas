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
public class ProductoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Producto entP = new Producto();

    public void limpiar() {
        entP.setCodpro("");
        entP.setNombre("");
        entP.setDescripcion("");
        entP.setExistencias("");
        entP.setValor("");
        entP.setExistencias("");
        entP.setCatprin("...Seleccione...");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String modulo = "FProducto.jsp";// enviar respuesta
        String pagina = "./FPrincipal.jsp";
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
        String cat = request.getParameter("cbocatprin");

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
        if ("nuevo".equals(request.getParameter("action"))) {
            try {
                limpiar();
                request.setAttribute("datoproducto", entP);
            } catch (Exception er) {
                men = "" + er.getMessage();
            }
        }// fin Nuevo

        if ("guardar".equals(request.getParameter("action"))) {
            try {
                Producto aux = new Producto();
                aux.codpro = cod;
                aux.nombre = nom;
                aux.descripcion = des;
                aux.existencias = exi;
                aux.valor = val;
                aux.foto = fot;
                aux.estado = est;
                aux.catprin = cat;
                pn.insertarProducto(aux);
            } catch (Exception e) {
                men += e.getMessage();
            }

        }// Fin guardar
        if ("buscar".equals(request.getParameter("action"))) {
            try {
                // un.buscar(user);
                Producto aux;
                aux = pn.buscar(cod);
                if (!aux.codpro.equals("")) {
                    request.setAttribute("datoproducto", pn.buscar(cod));
                    men += "Producto encontrado";
                } else {
                    men += "Producto no encontrado <BR>";
                }
            } catch (Exception e) {
                men += "Producto no existe <BR>";
            }
        }//Fin buscar

        if ("editar".equals(request.getParameter("action"))) {
            try {
                Producto aux = new Producto();
                aux.codpro = cod;
                aux.nombre = nom;
                aux.descripcion = des;
                aux.existencias = exi;
                aux.valor = val;
                aux.foto = fot;
                aux.estado = est;
                aux.catprin = cat;
                if (pn.editarProducto(aux) == true) {
                    men += "Producto actualizado";
                } else {
                    men += "Producto no actualizado";
                }
                men += "Producto actualizado";
            } catch (Exception e) {
                men += e.getMessage();
            }
        }//Fin editar
        if ("listar".equals(request.getParameter("action"))) {
            try {
                limpiar();
                request.setAttribute("datoproducto", entP);
                if (pn.listar() != null) {
                    men = "Tabla de los productos existentes";
                    men += "<table class=\"tabla\">";
                    men += "<tr>";
                    men += "<td>Código</td>";
                    men += "<td>Nombre</td>";
                    men += "<td>Descripción</td>";
                    men += "<td>Existencias</td>";
                    men += "<td>Valor</td>";
                    men += "<td>Foto</td>";
                    men += "<td>Estado</td>";
                    men += "<td>Buscar</td>";
                    men += "</tr>";
                    Producto aux = pn.listar();
                    while (aux != null) {
                        men += "<tr>";
                        men += "<td>" + aux.codpro + "</td>";
                        men += "<td>" + aux.nombre + "</td>";
                        men += "<td>" + aux.descripcion + "</td>";
                        men += "<td>" + aux.existencias + "</td>";
                        men += "<td>" + aux.valor + "</td>";
                        if (aux.foto == null) {
                            aux.foto = "";
                        }
                        if (aux.foto.equals("")) {
                            men += "<td><img id=\"perfil\" src=\"ImaCatalogo/cat.jpg\" width=\"50\" height=\"50\" />";
                        } else {
                            men += "<td> <img id=\"perfil\" src=\"ImaCatalogo/" + aux.foto + "\" width=\"50\" height=\"50\"></td>";
                        }
                        men += "<td>" + aux.estado + "</td>";
                        men += "<td> <a href=\"./ProductoServlet?action=buscar&txtcodpro=" + aux.codpro + "\"> <img src=\"Imagenes/lupa.png\"> </a></td>";
                        men += "</tr>";
                        aux = aux.apuntador;
                    }
                    men += "</table>";
                } else {
                    men += "No hay productos registrados";
                }
            } catch (Exception e) {
                men = e.getMessage();
            }
        }// fin listar
        request.setAttribute("mensaje", men);
        request.getRequestDispatcher(pagina).forward(request, response);
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
