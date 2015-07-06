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

    public Usuario validarIngreso(String user, String clave) {
        String id = "sosa";
        String pw = "Sosa1234";
        Usuario u = new Usuario();
        u.usuario = "0";
        if (user.equals(id) && clave.equals(pw)) {
            u.usuario = "sosa";
            u.nombre = "Brayan Sosa";
            u.clave = "Sosa1234";
            u.conclave = "Sosa1234";
            u.perfil = "Administrador";
            u.estado = "Activo";
            u.correo = "brayan_sosa23151@elpoli.edu.co";
            u.foto = "sosa.jpg";
        }
        return u;
    }

    public void insertarUsuario(Usuario datou) throws Exception {
        if (cabeza == null) {
            cabeza = new Usuario();
            cabeza = datou;
        } else {
            String mensajeError = "";
            Usuario aux = cabeza;
            while (aux.apuntador != null) {
                if (datou.usuario.equals(aux.usuario)) {
                    mensajeError = "Usuario ya existe <br>";
                    if (!"".equals(mensajeError)) {
                        throw new Exception(mensajeError);
                    }// fin si
                    else {
                        aux.apuntador = datou;
                        throw new Exception(mensajeError);
                    }
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

}
