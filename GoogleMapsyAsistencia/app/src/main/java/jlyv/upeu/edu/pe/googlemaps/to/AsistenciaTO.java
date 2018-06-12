package jlyv.upeu.edu.pe.googlemaps.to;

import android.os.CpuUsageInfo;

public class AsistenciaTO {

    int idAsistencia;
    int idEvento;
    int idUsuario;
    String codigo;
    String nombres;
    String companhia;
    String fechahora;
    String ofline;
    UsuarioTO nombreusuario;
    EventoTO nombreevento;


//    public String getNombreusuario() {
//        return nombreusuario;
//    }
//
//    public void setNombreusuario(String nombreusuario) {
//        this.nombreusuario = nombreusuario;
//    }
//
//    public String getNombreevento() {
//        return nombreevento;
//    }
//
//    public void setNombreevento(String nombreevento) {
//        this.nombreevento = nombreevento;
//    }



    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCompanhia() {
        return companhia;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }

    public String getFechahora() {
        return fechahora;
    }

    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

    public String getOfline() {
        return ofline;
    }

    public void setOfline(String ofline) {
        this.ofline = ofline;
    }

    public UsuarioTO getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(UsuarioTO nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public EventoTO getNombreevento() {
        return nombreevento;
    }

    public void setNombreevento(EventoTO nombreevento) {
        this.nombreevento = nombreevento;
    }
}
