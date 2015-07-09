package com.KatalogÜrünleri.Servlets;

import com.KatalogÜrünleri.Entidades.Usuario;
import com.KatalogÜrünleri.Negocio.UsuarioN;
import static com.KatalogÜrünleri.Negocio.UsuarioN.cabeza;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class UsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Usuario entU = new Usuario();

    public void limpiar() {
        entU.setUsuario("");
        entU.setNombre("");
        entU.setEstado("");
        entU.setPerfil("");
        entU.setClave("");
        entU.setCorreo("");
        entU.setConclave("");

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String modulo = "FUsuario.jsp";// enviar respuesta
        String pagina = "./FPrincipal.jsp";
        request.setAttribute("targetModulo", modulo);
        // Traer par�metros de la petici�n
        // Hecha desde FUsuario.jsp
        String user = request.getParameter("txtusuario");
        String nombre = request.getParameter("txtnombre");
        String clave = request.getParameter("txtclave");
        String conclave = request.getParameter("txtconclave");
        String perfil = request.getParameter("cboperfil");

        String estado = request.getParameter("cboestado");
        String correo = request.getParameter("txtcorreo");
        String foto = request.getParameter("filefoto");

        String men = "";// para los mensajes
        UsuarioN un = new UsuarioN();// Creamos un Objeto
        // de tipo UsuarioN();
        // Establecemos atributos e inicializamos en null
        request.setAttribute("listado", null);
        // m�todo vacio espera dos par�metros:
        // 1. String--> nombre del atributo
        // 2. Object --> Object a establecer 
        request.setAttribute("mensaje", null);
        // Creamos un atributo para recuperar
        // Un dato de consulta(de Un Usuario x)
        request.setAttribute("datousuario", null);
        // hay un botón con name = action y
        // con una propiedad value = buscar
        // si(buscar es igual a un par�metro de una petici�n)
        //llamada action   

        if ("nuevo".equals(request.getParameter("action"))) {
            try {
                limpiar();
                request.setAttribute("datousuario", entU);
            } catch (Exception er) {
                men = "" + er.getMessage();
            }
        }// fin Nuevo

        if ("guardar".equals(request.getParameter("action"))) {
            try {
                if (clave.equals(conclave)) {
                    String resp = "NO SIRVE";
                    char Caracter;
                    int ASCII;
                    int mayusc = 0;
                    int longi = 0;
                    int num = 0;
                    int minusc = 0;

                    for (int i = 0; i < clave.length(); i++) {
                        Caracter = clave.charAt(i);
                        ASCII = Caracter;
                        if (ASCII >= 65 && ASCII <= 90) {
                            mayusc = mayusc + 1;
                        }
                        if (ASCII >= 48 && ASCII <= 59) {
                            num = num + 1;
                        }
                        if (ASCII >= 97 && ASCII <= 112) {
                            minusc = minusc + 1;
                        }
                    }
                    if (clave.length() >= 8 && clave.length() <= 16) {
                        longi = 1;
                    }
                    if (mayusc != 0 && longi != 0 && num >= 3 && minusc >= 3) {
                        resp = "SIRVE";
                        Usuario aux = new Usuario();
                        aux.usuario = user;
                        aux.nombre = nombre;
                        aux.clave = clave;
                        aux.conclave = conclave;
                        aux.perfil = perfil;
                        aux.estado = estado;
                        aux.correo = correo;
                        aux.foto = foto;
                        un.insertarUsuario(aux);

                    }
                    if (resp.equals("NO SIRVE")) {
                        men += "<br>La contraseña que usted ha digitado no cumple con los siguientes parámetros:\n"
                                + "Se debe agregar como mínimo: ";
                        if (mayusc == 0) {
                            men += "<br>• Una letra mayúscula";
                        }
                        if (minusc < 3) {
                            men += "<br>•Tres letras minúsculas";
                        }
                        if (minusc < 3) {
                            men += "<br>•Tres números";
                        }
                        if (longi == 0) {
                            men += "<br>•La cantidad de caracteres total debe estar entre 8 y 16";
                        }
                        men += "<br><br>Para evitar problemas de seguridad, porfavor cumpla con lo dicho anteriormente. ";
                    }

                } else {
                    men = "Las contraseñas no coinciden";
                }
            } catch (Exception er) {
                men = er.getMessage();
            }
        }// fin guardar

        if ("editar".equals(request.getParameter("action"))) {
            try {
                Usuario aux = new Usuario();
                aux.usuario = user;
                aux.nombre = nombre;
                aux.clave = clave;
                aux.conclave = conclave;
                aux.perfil = perfil;
                aux.estado = estado;
                aux.correo = correo;
                aux.foto = foto;
                if (un.editarUsuario(aux) == true) {
                    men += "Usuario actualizado";
                } else {
                    men += "Usuario no actualizado";
                }
                men += "Usuario actualizado";
            } catch (Exception e) {
                men += e.getMessage();
            }
        }
        if ("listar".equals(request.getParameter("action"))) {
            try {
                limpiar();
                request.setAttribute("datousuario", entU);
                un.imprimir();
                if (un.listar() != null) {
                    men = "Tabla de los usuarios existentes";
                    men += "<table class=\"tabla\">";
                    men += "<tr>";
                    men += "<td>Usuario</td>";
                    men += "<td>Nombre</td>";
                    men += "<td>Perfil</td>";
                    men += "<td>Estado</td>";
                    men += "<td>Correo</td>";
                    men += "<td>Foto</td>";
                    men += "<td>Buscar</td>";
                    men += "</tr>";
                    Usuario aux = un.listar();
                    while (aux != null) {
                        men += "<tr>";
                        men += "<td>" + aux.usuario + "</td>";
                        men += "<td>" + aux.nombre + "</td>";
                        men += "<td>" + aux.perfil + "</td>";
                        men += "<td>" + aux.estado + "</td>";
                        men += "<td>" + aux.correo + "</td>";
                        if (aux.foto == null) {
                            aux.foto = "";
                        }
                        if (aux.foto.equals("")) {
                            men += "<td><img id=\"perfil\" src=\"ImagePerfil/perfil.jpg\" width=\"50\" height=\"50\" />";
                        } else {
                            men += "<td> <img id=\"perfil\" src=\"ImagePerfil/" + aux.foto + "\" width=\"50\" height=\"50\"></td>";
                        }
                        men += "<td> <a href=\"./UsuarioServlet?action=buscar&txtusuario=" + aux.usuario + "\"> <img src=\"Imagenes/lupa.png\"> </a></td>";
                        men += "</tr>";
                        aux = aux.apuntador;
                    }
                    men += "</table>";
                } else {
                    men += "No hay usuarios registrados";
                }
            } catch (Exception e) {
                men = e.getMessage();
            }
        }

        if ("buscar".equals(request.getParameter("action"))) {
            try {
                // un.buscar(user);
                Usuario aux;
                aux = un.buscar(user);
                if (aux.usuario != "0") {
                    request.setAttribute("datousuario", un.buscar(user));
                    men += "Usuario encontrado";
                } else {
                    men += "Usuario no encontrado <BR>";

                }
            } catch (Exception e) {
                men += "Usuario no existe <BR>";
            }
        }

        if ("salir".equals(request.getParameter("action"))) {
            request.getSession().invalidate();
            request.getRequestDispatcher("./index.jsp").forward(request, response);
        }
        if ("inicio".equals(request.getParameter("action"))) {
            request.getRequestDispatcher(pagina).forward(request, response);

        }

        request.setAttribute("mensaje", men);
        request.getRequestDispatcher(pagina).forward(request, response);
    } // fin processrequest 

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
