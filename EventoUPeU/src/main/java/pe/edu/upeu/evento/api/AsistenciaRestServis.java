package pe.edu.upeu.evento.api;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.evento.model.Asistencia;
import pe.edu.upeu.evento.service.AsistenciaServis;
import pe.edu.upeu.evento.service.UsuarioServis;

@RestController
@RequestMapping("/asistencia")
public class AsistenciaRestServis {
	
	@Autowired
    public AsistenciaServis servis;
    
    private final static Logger log = Logger.getLogger("bitacora.subnivel.Control");
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Asistencia> listarAsistencia(){return servis.listarAsistencia(); }
    
    @RequestMapping(value = "/edit", method = {RequestMethod.GET, RequestMethod.POST})
    public void modificarAsistenciaId(@RequestBody Asistencia asistente) {
        servis.modificarAsistenciaId(asistente);
    }

    
    @RequestMapping(value = "remove/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public void eliminarAsistenciaId(@PathVariable String id) {
        int dato=Integer.parseInt(id);
        servis.eliminarAsistencia(dato);
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Asistencia buscarAsistenciaId(@PathVariable String id) {       
        int dato=Integer.parseInt(id);
        return servis.buscarAsistencia(dato);
    }
    

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public void guardarAsistencia(@RequestBody Asistencia asistencia) {
    	servis.guardarAsistencia(asistencia);
    }   
    


}
