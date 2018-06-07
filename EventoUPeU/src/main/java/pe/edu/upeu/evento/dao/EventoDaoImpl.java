/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.evento.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.evento.SysDataAccess;
import pe.edu.upeu.evento.model.Evento;

/**
 *
 * @author davidmp
 */
@Repository("eventoDao")
public class EventoDaoImpl extends SysDataAccess<Integer, Evento> implements EventoDao{
    
    
    @SuppressWarnings("unchecked")
    public List<Evento> listarEntidad() { return getListAll();}
    public Evento buscarEntidad(int id) { return getById(id);}
    public void guardarEntidad(Evento evento) {savev(evento); }
    public void eliminarEntidad(int id) { delete(id);}
    public void modificarEntidadId(Evento evento) { update(evento); }
    
    
    public List<Evento> listarPorNombre(String nombre) {
    return (List<Evento>)sessionFactory.getCurrentSession()
            .createQuery("select a from Evento a where a.nombreevento like ?")
            .setString(0, "%"+nombre+"%")
            .list();
    }    
}
