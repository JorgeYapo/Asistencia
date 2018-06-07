/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.evento.api;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upeu.evento.model.Usuario;
import pe.edu.upeu.evento.service.UsuarioServis;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
@RestController
@RequestMapping("/user")
public class UsuarioRestController {
    
    @Autowired
    public UsuarioServis servis;
    
    private final static Logger log = Logger.getLogger("bitacora.subnivel.Control");
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Usuario> listarUsuarios(){return servis.listarEntidad(); }
    
    @RequestMapping(value = "/edit", method = {RequestMethod.GET, RequestMethod.POST})
    public void modificarEntidadId(@RequestBody Usuario diente) {
        servis.modificarEntidadId(diente);
    }

    
    @RequestMapping(value = "remove/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public void eliminarEntidadId(@PathVariable String id) {
//        System.out.println("Holas "+id);
        int dato=Integer.parseInt(id);
        servis.eliminarEntidad(dato);
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Usuario buscarEntidadId(@PathVariable String id) {
//        System.out.println("Holas  DMP------> "+id);        
        int dato=Integer.parseInt(id);
        return servis.buscarUsuario(dato);
    }
    @RequestMapping(value = "/findn/{nombre}", method = RequestMethod.GET)
    public List<Usuario> buscarEntidadNombre(@PathVariable String nombre) {
    	log.log(Level.INFO, " El parametro que paso es :::::: " + nombre);
        return servis.listarPorNombre(nombre);
    }
    

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public void guardarEntidad(@RequestBody Usuario usuario) {
    	servis.guardarEntidad(usuario);
    }   
    
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public Usuario login(@RequestBody Usuario usuario) {
   // public void guardarEntidad(@RequestBody HttpServletRequest request) {
        //System.out.println("Probar: "+request.getParameter("usuario"));
    	System.out.println("YAPO------>"+usuario.getUsuario());
    	System.out.println("YAPO------>"+usuario.getClave());
    	return servis.usuarioLogin(usuario.getUsuario(),usuario.getClave());
    }   
    
}
