/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.evento.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.evento.dao.EventoDao;
import pe.edu.upeu.evento.model.Evento;

/**
 *
 * @author davidmp
 */
@Service("eventoServis")
@Transactional
public class EventoServisImpl implements EventoServis{
    
    @Autowired
    public EventoDao dao;

    @Override
    public List<Evento> listarEntidad() {return dao.listarEntidad();}

    @Override
    public Evento buscarEntidad(int id) {return dao.buscarEntidad(id);}

    @Override
    public void guardarEntidad(Evento evento) {dao.guardarEntidad(evento);}

    @Override
    public void eliminarEntidad(int id) {dao.eliminarEntidad(id);}

    @Override
    public void modificarEntidadId(Evento evento) {dao.modificarEntidadId(evento);}

    @Override
    public List<Evento> listarPorNombre(String nombre) {return dao.listarPorNombre(nombre);}    
}
