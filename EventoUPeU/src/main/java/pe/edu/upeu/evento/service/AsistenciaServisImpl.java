package pe.edu.upeu.evento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upeu.evento.dao.AsistenciaDao;
import pe.edu.upeu.evento.dao.EventoDao;
import pe.edu.upeu.evento.model.Asistencia;
import pe.edu.upeu.evento.model.Evento;

@Service("asistenciaServis")
@Transactional
public class AsistenciaServisImpl implements AsistenciaServis {

	@Autowired
    public AsistenciaDao dao;

    @Override
    public List<Asistencia> listarAsistencia() {return dao.listarAsistencia();}

    @Override
    public Asistencia buscarAsistencia(int id) {return dao.buscarAsistencia(id);}

    @Override
    public void guardarAsistencia(Asistencia asistencia) {dao.guardarAsistencia(asistencia);}

    @Override
    public void eliminarAsistencia(int id) {dao.eliminarAsistencia(id);}

    @Override
    public void modificarAsistenciaId(Asistencia asistencia) {dao.modificarAsistencia(asistencia);}

}
