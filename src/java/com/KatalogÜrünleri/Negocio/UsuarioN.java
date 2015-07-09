package com.KatalogÜrünleri.Negocio;

import com.KatalogÜrünleri.Entidades.Usuario;

/**
 * @since KatalogÜrünleri 1.0
 *
 * @version 1.0 25/06/2015
 *
 * @author Melany Arboleda
 * @author Michael Ramirez
 * @author Brayan Sosa
 */
public class UsuarioN {

    public static Usuario cabeza;

    public Usuario validarIngreso(String user, String clave) throws Exception {
        String id = "sosa";
        String pw = "Sosa1234";
        Usuario u = new Usuario();
        u.usuario = "0";
        Usuario un = cabeza;
        while (un != null) {
            if (un.usuario.equals(user)) {
                return un;
            } else {
                un = un.apuntador;
            }
        }
        if (user.equals(id) && clave.equals(pw)) {
            u.usuario = "sosa";
            u.nombre = "Brayan Sosa";
            u.clave = "Sosa1234";
            u.conclave = "Sosa1234";
            u.perfil = "Administrador";
            u.estado = "Activo";
            u.correo = "brayan_sosa23151@elpoli.edu.co";
            u.foto = "sosa.jpg";
            if (buscar(user) == null) {
                insertarUsuario(u);
            }
        }
        return u;
    }

    public void insertarUsuario(Usuario datou) throws Exception {
        if (cabeza == null) {
            cabeza = new Usuario();
            cabeza = datou;
        } else {
            Usuario aux = cabeza;
            String mensajeError = "";
            while (aux.apuntador != null) {
                if (aux.usuario.equals(datou.usuario)) {
                    mensajeError = "Usuario: " + aux.usuario + "... Ya existe <br>";
                    if (!"".equals(mensajeError)) {
                        throw new Exception(mensajeError);
                    }// fin si
                } else {
                    aux = aux.apuntador;
                }
            }
            String usu = datou.usuario;
            String nom = datou.nombre;
            String cla = datou.clave;
            String ccla = datou.conclave;
            String per = datou.perfil;
            String est = datou.estado;
            String cor = datou.correo;
            String fot = datou.foto;

            if ("".equals(usu) || null == usu) {
                mensajeError += "<br>Debe ingresar el usuario";
            }// fin si

            if ("".equals(nom) || null == nom) {
                mensajeError += "<br>Debe ingresar el nombre";
            }// fin si
            if ("".equals(cla) || null == cla) {
                mensajeError += "<br>Debe ingresar la contraseña";
            }// fin si
            if ("".equals(ccla) || null == ccla) {
                mensajeError += "<br>Debe ingresar la conformación de la contraseña";
            }// fin si
            if ("".equals(per) || null == per) {
                mensajeError += "<br>Debe ingresar el perfil";
            }// fin si
            if ("".equals(est) || null == est) {
                mensajeError += "<br>Debe ingresar el estado";
            }// fin si
            if ("".equals(cor) || null == cor) {
                mensajeError += "<br>Debe ingresar el correo";
            }// fin si

            if (!"".equals(mensajeError)) {
                throw new Exception(mensajeError);
            }// fin si
            else {
                mensajeError += "<br> Usuario agregado";
                aux.apuntador = datou;
                throw new Exception(mensajeError);
            }

        }
    }

    public void imprimir() {
        Usuario aux = cabeza;
        System.out.println("-----INICIO-----");
        System.out.println("Usuario ... Nombre ... Estado");
        while (aux != null) {
            System.out.println(aux.usuario + " ... " + aux.nombre + " ... " + aux.estado);
            aux = aux.apuntador;
        }// fin mientras
        System.out.println("-----FIN-----");
    }// fin ListaUsuarios  

    public Usuario buscar(String user) {
        Usuario aux = cabeza;
        String mensajeError = "";
        while (aux != null) {
            if (aux.usuario.equals(user)) {
                return aux;
            } else {
                aux = aux.apuntador;
            }
        }
        return aux;
    }

    public Usuario listar() {
        return cabeza;
    }

    public boolean editarUsuario(Usuario datou) throws Exception {
        String mensajeError = "";
        if (cabeza == null) {
            mensajeError = "<br>No hay datos";
            if (!"".equals(mensajeError)) {
                throw new Exception(mensajeError);
            }// fin si
        } else {
            Usuario aux = cabeza;
            while (aux != null) {
                if (datou.usuario.equals(aux.usuario)) {
                    aux.usuario = datou.usuario;
                    aux.nombre = datou.nombre;
                    aux.clave = datou.clave;
                    aux.conclave = datou.conclave;
                    aux.perfil = datou.perfil;
                    aux.estado = datou.estado;
                    aux.correo = datou.correo;
                    aux.foto = datou.foto;
                    mensajeError += "<br>Usuario actualizado";
                    if (!"".equals(mensajeError)) {
                        throw new Exception(mensajeError);
                    }// fin si
                    return true;
                } else {
                    aux = aux.apuntador;
                }
            }
        }
        return false;
    }

}
