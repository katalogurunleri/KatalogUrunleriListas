package com.KatalogÜrünleri.Entidades;

/**
 *
 * @author Brayan Sosa
 */
public class Cliente {

    public String ideCliente;
    public String nombres;
    public String apellidos;
    public String clave;
    public String conclave;
    public String correo;
    public String telefono;
    public String direccion;
    public String estado;
    public String foto;
    public Cliente apuntador;

    public Cliente(String ideCliente, String nombres, String apellidos, String clave, String correo, String telefono, String direccion, String estado, String foto, Cliente apuntador) {
        this.ideCliente = ideCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.clave = clave;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
        this.foto = foto;
        this.apuntador = apuntador;
    }

    public Cliente() {
    }

    public String getIdeCliente() {
        return ideCliente;
    }

    public void setIdeCliente(String ideCliente) {
        this.ideCliente = ideCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Cliente getApuntador() {
        return apuntador;
    }

    public void setApuntador(Cliente apuntador) {
        this.apuntador = apuntador;
    }

}
