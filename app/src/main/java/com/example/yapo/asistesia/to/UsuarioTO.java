package com.example.yapo.asistesia.to;

/**
 * Update by Yapo on 05/06/2018.
 */

public class UsuarioTO {
    Integer idUsuario;
    String usuario;
    String clave;
    String nombres;
    String apellidos;
    String dnicodigo;
    String email;
    String estadousuario;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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

    public String getDnicodigo() {
        return dnicodigo;
    }

    public void setDnicodigo(String dnicodigo) {
        this.dnicodigo = dnicodigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadousuario() {
        return estadousuario;
    }

    public void setEstadousuario(String estadousuario) {
        this.estadousuario = estadousuario;
    }
}
