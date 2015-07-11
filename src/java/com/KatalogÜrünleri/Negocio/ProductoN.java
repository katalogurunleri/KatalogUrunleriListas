package com.KatalogÜrünleri.Negocio;

import com.KatalogÜrünleri.Entidades.Producto;

/**
 *
 * @author Brayan Sosa
 */
public class ProductoN {

    public static Producto cabeza;

    public void insertarProducto(Producto datop) throws Exception {
        if (cabeza == null) {
            cabeza = new Producto();
            cabeza = datop;
        } else {
            Producto aux = cabeza;
            String mensajeError = "";
            while (aux.apuntador != null) {
                if (aux.codpro.equals(datop.codpro)) {
                    mensajeError = "Producto con código: " + aux.codpro + "... Ya existe <br>";
                    if (!"".equals(mensajeError)) {
                        throw new Exception(mensajeError);
                    }// fin si
                } else {
                    aux = aux.apuntador;
                }
            }
            String cpd = datop.codpro;
            String nom = datop.nombre;
            String des = datop.descripcion;
            String exi = datop.existencias;
            String val = datop.valor;
            String fot = datop.foto;
            String est = datop.estado;
            String cat = datop.catprin;

            if ("".equals(cpd) || null == cpd) {
                mensajeError += "<br>Debe ingresar el código";
            }// fin si

            if ("".equals(nom) || null == nom) {
                mensajeError += "<br>Debe ingresar el nombre";
            }// fin si
            if ("".equals(des) || null == des) {
                mensajeError += "<br>Debe ingresar la descripción";
            }// fin si
            if ("".equals(exi) || null == exi) {
                mensajeError += "<br>Debe ingresar las existencias";
            }// fin si
            if ("".equals(val) || null == val) {
                mensajeError += "<br>Debe ingresar el valor";
            }// fin si
            if ("".equals(fot) || null == fot) {
                mensajeError += "<br>Debe insertar la imagen";
            }// fin si
            if ("".equals(est) || null == est) {
                mensajeError += "<br>Debe ingresar el estado";
            }// fin si
            if ("".equals(cat) || null == cat) {
                mensajeError += "<br>Seleccione si desea que el producto aparezca en al catalogo principal";
            }// fin si

            if (!"".equals(mensajeError)) {
                throw new Exception(mensajeError);
            }// fin si
            else {
                mensajeError += "<br> Producto agregado";
                aux.apuntador = datop;
                throw new Exception(mensajeError);
            }

        }
    }

    public Producto buscar(String cod) {
        Producto aux = cabeza;
        String mensajeError = "";
        while (aux != null) {
            if (aux.codpro.equals(cod)) {
                return aux;
            } else {
                aux = aux.apuntador;
            }
        }
        return aux;
    }

    public boolean editarProducto(Producto datop) throws Exception {
        String mensajeError = "";
        if (cabeza == null) {
            mensajeError = "<br>No hay datos";
            if (!"".equals(mensajeError)) {
                throw new Exception(mensajeError);
            }// fin si
        } else {
            Producto aux = cabeza;
            while (aux != null) {
                if (datop.codpro.equals(aux.codpro)) {
                    aux.codpro = datop.codpro;
                    aux.nombre = datop.nombre;
                    aux.descripcion = datop.descripcion;
                    aux.existencias = datop.existencias;
                    aux.valor = datop.valor;
                    aux.foto = datop.foto;
                    aux.estado = datop.estado;
                    aux.catprin = datop.catprin;
                    mensajeError += "<br>Producto actualizado";
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
        Producto aux = cabeza;
        System.out.println("-----INICIO-----");
        System.out.println("Producto ... Nombre ... Estado");
        while (aux != null) {
            System.out.println(aux.codpro + " ... " + aux.nombre + " ... " + aux.estado);
            aux = aux.apuntador;
        }// fin mientras
        System.out.println("-----FIN-----");
    }// fin ListaUsuarios  

    public Producto listar() {
        return cabeza;
    }

}
