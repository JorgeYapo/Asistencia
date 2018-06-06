/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.evento.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pe.edu.upeu.evento.model.Usuario;
import pe.edu.upeu.evento.service.UsuarioServis;

/**
 *
 * @author Docente
 */

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    UsuarioServis service;	    
    @Autowired
    MessageSource mesagesource;
    
    @RequestMapping(value = {"/index"},method = RequestMethod.GET)
    public ModelAndView paginaPrincipal(ModelMap model){
            List<Usuario> lista=service.listarEntidad();
            Map<String, Object> modelo=new HashMap<String, Object> ();
            modelo.put("ListaUsuario", lista);        
        return  new ModelAndView("index",modelo);
    }
    
    @RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
    public ModelAndView principalLogin(ModelMap model) {                      
        return new ModelAndView("login");
    }    
    
    @RequestMapping(value = {"/validar" }, method = RequestMethod.POST)
    public ModelAndView principalPaginaValidar(ModelMap model, HttpServletRequest r) {
        Usuario lista=null;
        String usuario=r.getParameter("usuario");
        String clave=r.getParameter("clave");
        lista=service.usuarioLogin(usuario, clave);
        Map<String, Object> modelo=new HashMap<String, Object> ();
        modelo.put("ListaUsuario", lista);       
        if(lista!=null){
        return new ModelAndView(new RedirectView("listUsuario"));
        }else{
        return new ModelAndView("login", modelo);
        }                       
    }    
    
}
