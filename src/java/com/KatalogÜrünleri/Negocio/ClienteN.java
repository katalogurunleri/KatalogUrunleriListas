/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.KatalogÜrünleri.Negocio;

import com.KatalogÜrünleri.Entidades.Cliente;

/**
 *
 * @author Brayan Sosa
 */
public class ClienteN {

    public static Cliente cabeza;

    public Cliente validarIngreso(String user, String clave) throws Exception {
        String id = "yasmis";
        String pw = "Yasmis1234";
        Cliente c = new Cliente();
        c.ideCliente = "0";
        Cliente un = cabeza;
        while (un != null) {
            if (un.ideCliente.equals(user)) {
                return un;
            } else {
                un = un.apuntador;
            }
        }
        if (user.equals(id) && clave.equals(pw)) {

            c.ideCliente = "22956220";
            c.nombres = "Yasmis";
            c.apellidos = "Villalobos Mendez";
            c.clave = "Villalobos Mendez";
            c.correo = "yasmisv123@hotmail.com";
            c.telefono = "2228360";
            c.telefono = "Cll 55 G # 01 - 12";
            c.estado = "Activo";
            c.foto = "yasmi.jog";
            if (buscar(user) == null) {
                insertarCliente(c);
            }
        }
        return c;
    }

    public void insertarCliente(Cliente datoc) throws Exception {
        if (cabeza == null) {
            cabeza = new Cliente();
            cabeza = datoc;
        } else {
            Cliente aux = cabeza;
            String mensajeError = "";
            while (aux.apuntador != null) {
                if (aux.ideCliente.equals(datoc.ideCliente)) {
                    mensajeError = "Cliente: " + aux.ideCliente + "... Ya existe <br>";
                    if (!"".equals(mensajeError)) {
                        throw new Exception(mensajeError);
                    }// fin si
                } else {
                    aux = aux.apuntador;
                }
            }
            String ide = datoc.ideCliente;
            String nom = datoc.nombres;
            String ape = datoc.apellidos;
            String cla = datoc.clave;
            String ccla = datoc.conclave;
            String cor = datoc.correo;
            String tel = datoc.telefono;
            String dir = datoc.direccion;
            String est = datoc.estado;
            String fot = datoc.foto;

            if ("".equals(ide) || null == ide) {
                mensajeError += "<br>Debe ingresar la cédula";
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
            if ("".equals(cor) || null == cor) {
                mensajeError += "<br>Debe ingresar el correo";
            }// fin si
            if ("".equals(tel) || null == tel) {
                mensajeError += "<br>Debe ingresar el teléfono";
            }// fin si
            if ("".equals(dir) || null == dir) {
                mensajeError += "<br>Debe ingresar el teléfono";
            }// fin si
            if ("".equals(est) || null == est) {
                mensajeError += "<br>Debe ingresar el estado";
            }// fin si

            if (!"".equals(mensajeError)) {
                throw new Exception(mensajeError);
            }// fin si
            else {
                mensajeError += "<br> Cliente agregado";
                aux.apuntador = datoc;
                throw new Exception(mensajeError);
            }

        }
    }

    public Cliente buscar(String idecli) {
        Cliente aux = cabeza;
        String mensajeError = "";
        while (aux != null) {
            if (aux.ideCliente.equals(idecli)) {
                return aux;
            } else {
                aux = aux.apuntador;
            }
        }
        return aux;
    }

    public boolean editarCliente(Cliente datoc) throws Exception {
        String mensajeError = "";
        if (cabeza == null) {
            mensajeError = "<br>No hay datos";
            if (!"".equals(mensajeError)) {
                throw new Exception(mensajeError);
            }// fin si
        } else {
            Cliente aux = cabeza;
            while (aux != null) {
                if (datoc.ideCliente.equals(aux.ideCliente)) {
                    aux.nombres = datoc.nombres;
                    aux.apellidos = datoc.apellidos;
                    aux.clave = datoc.clave;
                    aux.correo = datoc.correo;
                    aux.telefono = datoc.telefono;
                    aux.direccion = datoc.direccion;
                    aux.estado = datoc.estado;
                    mensajeError += "<br>Cliente actualizado";
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

    public void imprimir() {
        Cliente aux = cabeza;
        System.out.println("-----INICIO-----");
        System.out.println("Cliente ... Nombre ... Estado");
        while (aux != null) {
            System.out.println(aux.ideCliente + " ... " + aux.nombres + " ... " + aux.estado);
            aux = aux.apuntador;
        }// fin mientras
        System.out.println("-----FIN-----");
    }// fin ListaUsuarios  

    public Cliente listar() {
        return cabeza;
    }

}
