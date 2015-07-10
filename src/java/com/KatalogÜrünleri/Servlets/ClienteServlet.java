package com.KatalogÜrünleri.Servlets;

import com.KatalogÜrünleri.Entidades.Cliente;
import com.KatalogÜrünleri.Negocio.ClienteN;
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
public class ClienteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Cliente entC = new Cliente();

    public void limpiar() {
        entC.setIdeCliente("");
        entC.setNombres("");
        entC.setApellidos("");
        entC.setCorreo("");
        entC.setTelefono("");
        entC.setDireccion("");
        entC.setEstado("...Seleccione...");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String modulo = "FCliente.jsp";// enviar respuesta
        String pagina = "./FPrincipal.jsp";
        request.setAttribute("targetModulo", modulo);
        // Traer par�metros de la petici�n
        // Hecha desde FUsuario.jsp
        String idecli = request.getParameter("txtidecliente");
        String nom = request.getParameter("txtnombre");
        String ape = request.getParameter("txtapellido");
        String cla = request.getParameter("txtclave");
        String ccla = request.getParameter("txtconclave");
        String corr = request.getParameter("txtcorreo");
        String tele = request.getParameter("txttelefono");
        String dire = request.getParameter("txtdireccion");
        String estado = request.getParameter("cboestado");
        String foto = request.getParameter("filefoto");

        String men = "";// para los mensajes
        ClienteN cn = new ClienteN();// Creamos un Objeto
        // de tipo UsuarioN();
        // Establecemos atributos e inicializamos en null
        request.setAttribute("listado", null);
        // m�todo vacio espera dos par�metros:
        // 1. String--> nombre del atributo
        // 2. Object --> Object a establecer 
        request.setAttribute("mensaje", null);
        // Creamos un atributo para recuperar
        // Un dato de consulta(de Un Usuario x)
        request.setAttribute("datocliente", null);
        // hay un bot�n con name = action y
        // con una propiedad value = buscar
        // si(buscar es igual a un par�metro de una petici�n)
        //llamada action   

        if ("nuevo".equals(request.getParameter("action"))) {
            try {
                limpiar();
                request.setAttribute("datocliente", entC);
            } catch (Exception er) {
                men = "" + er.getMessage();
            }
        }// fin Nuevo

        if ("guardar".equals(request.getParameter("action"))) {
            try {
                if (cla.equals(ccla)) {
                    String resp = "NO SIRVE";
                    char Caracter;
                    int ASCII;
                    int mayusc = 0;
                    int longi = 0;
                    int num = 0;
                    int minusc = 0;

                    for (int i = 0; i < cla.length(); i++) {
                        Caracter = cla.charAt(i);
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
                    if (cla.length() >= 8 && cla.length() <= 16) {
                        longi = 1;
                    }
                    if (mayusc != 0 && longi != 0 && num >= 3 && minusc >= 3) {
                        resp = "SIRVE";
                        Cliente aux = new Cliente();
                        aux.ideCliente = idecli;
                        aux.nombres = nom;
                        aux.apellidos = ape;
                        aux.clave = cla;
                        aux.conclave = ccla;
                        aux.correo = corr;
                        aux.telefono = tele;
                        aux.direccion = dire;
                        aux.estado = estado;
                        aux.foto = foto;
                        cn.insertarCliente(aux);

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

        if ("buscar".equals(request.getParameter("action"))) {
            try {
                // un.buscar(user);
                Cliente aux;
                aux = cn.buscar(idecli);
                if (!aux.ideCliente.equals("")){
                    request.setAttribute("datocliente", cn.buscar(idecli));
                    men += "Cliente encontrado";
                } else {
                    men += "Cliente no encontrado <BR>";

                }
            } catch (Exception e) {
                men += "Cliente no existe <BR>";
            }
        }//Fin buscar

        if ("editar".equals(request.getParameter("action"))) {
            try {
                Cliente aux = new Cliente();
                aux.ideCliente = idecli;
                aux.nombres = nom;
                aux.apellidos = ape;
                aux.clave = cla;
                aux.conclave = ccla;
                aux.correo = corr;
                aux.telefono = tele;
                aux.direccion = dire;
                aux.estado = estado;
                aux.foto = foto;
                if (cn.editarCliente(aux) == true) {
                    men += "Cliente actualizado";
                } else {
                    men += "Cliente no actualizado";
                }
                men += "Cliente actualizado";
            } catch (Exception e) {
                men += e.getMessage();
            }
        }//Fin editar

        if ("listar".equals(request.getParameter("action"))) {
            try {
                limpiar();
                request.setAttribute("datocliente", entC);
                cn.imprimir();
                if (cn.listar() != null) {
                    men = "Tabla de los usuarios existentes";
                    men += "<table class=\"tabla\">";
                    men += "<tr>";
                    men += "<td>Cédula</td>";
                    men += "<td>Nombres</td>";
                    men += "<td>Apellidos</td>";
                    //men += "<td>Correo</td>";
                    men += "<td>Teléfono</td>";
                    men += "<td>Dirección</td>";
                    men += "<td>Estado</td>";
                    men += "<td>Foto</td>";
                    men += "<td>Buscar</td>";
                    men += "</tr>";
                    Cliente aux = cn.listar();
                    while (aux != null) {
                        men += "<tr>";
                        men += "<td>" + aux.ideCliente + "</td>";
                        men += "<td>" + aux.nombres + "</td>";
                        men += "<td>" + aux.apellidos + "</td>";
                        //men += "<td>" + aux.correo + "</td>";
                        men += "<td>" + aux.telefono + "</td>";
                        men += "<td>" + aux.direccion + "</td>";
                        men += "<td>" + aux.estado + "</td>";
                        if (aux.foto == null) {
                            aux.foto = "";
                        }
                        if (aux.foto.equals("")) {
                            men += "<td><img id=\"perfil\" src=\"ImagePerfilCli/perfil.jpg\" width=\"50\" height=\"50\" />";
                        } else {
                            men += "<td> <img id=\"perfil\" src=\"ImagePerfilCli/" + aux.foto + "\" width=\"50\" height=\"50\"></td>";
                        }
                        men += "<td> <a href=\"./ClienteServlet?action=buscar&txtidecliente=" + aux.ideCliente + "\"> <img src=\"Imagenes/lupa.png\"> </a></td>";
                        men += "</tr>";
                        aux = aux.apuntador;
                    }
                    men += "</table>";
                } else {
                    men += "No hay clientes registrados";
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
