package com.KatalogÜrünleri.Entidades;

/**
 * @author Melany Arboleda
 *
 */
public class Usuario {

    public String usuario;
    public String nombre;
    public String clave;
    public String conclave;
    public String perfil;
    public String estado;
    public String correo;
    public String foto;
    public Usuario apuntador;

    public Usuario(String usuario, String nombre, String clave, String conclave, String perfil, String estado, String correo, String foto, Usuario apuntador) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.clave = clave;
        this.conclave = conclave;
        this.perfil = perfil;
        this.estado = estado;
        this.correo = correo;
        this.foto = foto;
        this.apuntador = apuntador;
    }

    public Usuario() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getConclave() {
        return conclave;
    }

    public void setConclave(String conclave) {
        this.conclave = conclave;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Usuario getApuntador() {
        return apuntador;
    }

    public void setApuntador(Usuario apuntador) {
        this.apuntador = apuntador;
    }

}//Fin Clase Usuario
