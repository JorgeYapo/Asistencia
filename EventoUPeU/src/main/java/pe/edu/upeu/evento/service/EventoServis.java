/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.evento.service;

import java.util.List;
import pe.edu.upeu.evento.model.Evento;

/**
 *
 * @author davidmp
 */
public interface EventoServis {
    public List<Evento> listarEntidad();
    public Evento buscarEntidad(int id);
    public void guardarEntidad(Evento evento);
    public void eliminarEntidad(int id);
    public void modificarEntidadId(Evento evento);
    public List<Evento> listarPorNombre(String nombre);   
  
}
