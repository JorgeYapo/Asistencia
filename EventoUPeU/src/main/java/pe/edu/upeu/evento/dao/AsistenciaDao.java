package pe.edu.upeu.evento.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pe.edu.upeu.evento.SysDataAccess;
import pe.edu.upeu.evento.model.Asistencia;
import pe.edu.upeu.evento.model.Evento;


public interface  AsistenciaDao {
	 public List<Asistencia> listarAsistencia() ;
	    public Asistencia buscarAsistencia(int id);
	    public void guardarAsistencia(Asistencia asistencia) ;
	    public void eliminarAsistencia(int id);
	    public void modificarAsistencia(Asistencia asistencia) ;
}
