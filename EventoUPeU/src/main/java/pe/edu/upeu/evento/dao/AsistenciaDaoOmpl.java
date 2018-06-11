package pe.edu.upeu.evento.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pe.edu.upeu.evento.SysDataAccess;
import pe.edu.upeu.evento.model.Asistencia;

@Repository("asistenciaDao")
public class AsistenciaDaoOmpl extends SysDataAccess<Integer, Asistencia> implements AsistenciaDao{

	 @SuppressWarnings("unchecked")
	    public List<Asistencia> listarAsistencia() { return getListAll();}
	    public Asistencia buscarAsistencia(int id) { return getById(id);}
	    public void guardarAsistencia(Asistencia asistencia) {savev(asistencia); }
	    public void eliminarAsistencia(int id) { delete(id);}
	    public void modificarAsistencia(Asistencia asistencia) { update(asistencia); }
	      
}
