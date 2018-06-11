package pe.edu.upeu.evento.service;

import java.util.List;

import pe.edu.upeu.evento.model.Asistencia;

public interface AsistenciaServis {
	 public List<Asistencia> listarAsistencia();
	    public Asistencia buscarAsistencia(int id);
	    public void guardarAsistencia(Asistencia asistencia);
	    public void eliminarAsistencia(int id);
	    public void modificarAsistenciaId(Asistencia asistencia);
}
