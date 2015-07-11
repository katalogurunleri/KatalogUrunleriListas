package com.KatalogÜrünleri.Entidades;

/**
 *
 * @author Brayan Sosa
 */
public class Producto {

    public String codpro;
    public String nombre;
    public String descripcion;
    public String existencias;
    public String valor;
    public String foto;
    public String estado;
    public String catprin;
    public Producto apuntador;

    public Producto() {
    }

    public Producto(String codpro, String nombre, String descripcion, String existencias, String valor, String foto, String estado, String catprin, Producto apuntador) {
        this.codpro = codpro;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.existencias = existencias;
        this.valor = valor;
        this.foto = foto;
        this.estado = estado;
        this.catprin = catprin;
        this.apuntador = apuntador;
    }

    public String getCodpro() {
        return codpro;
    }

    public void setCodpro(String codpro) {
        this.codpro = codpro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getExistencias() {
        return existencias;
    }

    public void setExistencias(String existencias) {
        this.existencias = existencias;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCatprin() {
        return catprin;
    }

    public void setCatprin(String catprin) {
        this.catprin = catprin;
    }

    public Producto getApuntador() {
        return apuntador;
    }

    public void setApuntador(Producto apuntador) {
        this.apuntador = apuntador;
    }

}
