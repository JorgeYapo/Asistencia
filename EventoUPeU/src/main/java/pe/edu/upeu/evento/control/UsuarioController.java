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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pe.edu.upeu.evento.model.Usuario;
import pe.edu.upeu.evento.service.UsuarioServis;

/**
 *
 * @author David
 */
@Controller
@RequestMapping("/")
public class UsuarioController {
        @Autowired
        UsuarioServis service;	
        @Autowired
        MessageSource messageSource;     
        
	@RequestMapping(value = {"listUsuario"}, method = RequestMethod.GET)
	public ModelAndView listUsuario(ModelMap model) {
            List<Usuario> lista=service.listarEntidad();
            Map<String, Object> modelo=new HashMap<String, Object> ();
            modelo.put("ListaUsuario", lista);
            modelo.put("saludo", "Hola amigos");            
//            System.out.println("Holassssssssss");
            return new ModelAndView("usuario/mainUsuario", modelo);
	}

        @RequestMapping(value = "eliminarUsuario", method = RequestMethod.GET)
        public  ModelAndView eliminarUsuario(HttpServletRequest r) {
            int idEntidad=Integer.parseInt(r.getParameter("id"));
            service.eliminarEntidad(idEntidad);
//            System.out.println("si llego al metodo");
            return new ModelAndView(new RedirectView("listUsuario"));
        }


        @RequestMapping(value = "formUsuario", method = RequestMethod.GET)
        public ModelAndView irFormulario(@ModelAttribute("modeloUsuario") Usuario entidad,BindingResult result ){
            Map<String, Object> modelo=new HashMap<String, Object> ();
            modelo.put("listaTemporada", "Holasssssssssss");
            modelo.put("listaTemporadaX", service.listarEntidad());
            modelo.put("listaTemporada2", "");
            modelo.put("listaTemporada3", "");            
            return new ModelAndView("usuario/formUsuario",modelo);
        }


        @RequestMapping(value = "guardarUsuario", method = RequestMethod.POST)
        public ModelAndView guardarUsuarioXX(@ModelAttribute("modeloUsuario") Usuario entidad,
                                              BindingResult result ){            
                service.guardarEntidad(entidad);
            return new ModelAndView(new RedirectView("listUsuario"));
        }

        @RequestMapping(value = "modificarUsuario", method = RequestMethod.GET)
        public ModelAndView modificarUsuario(HttpServletRequest r ){
           int id=Integer.parseInt(r.getParameter("id"));
               Usuario entidad=null;
               entidad=service.buscarUsuario(id);
            return new ModelAndView("usuario/formXUsuario","ModeloUsuario",entidad);
        }

        @RequestMapping(value = "modificarUsuarioX", method = RequestMethod.GET)
        public String modificarUsuarioX(HttpServletRequest r, Model model ){
           int id=Integer.parseInt(r.getParameter("id"));
               Usuario usuario=null;
               usuario=service.buscarUsuario(id);
               model.addAttribute("ModeloUsuario", usuario);             
            return "usuario/formXUsuario";
        }

        @RequestMapping(value = "actualizarUsuario", method = RequestMethod.POST)
        public ModelAndView gactualizarUsuarioXX(@ModelAttribute("ModeloUsuario") Usuario entidad,
                                              BindingResult result ){
                service.modificarEntidadId(entidad);
            return new ModelAndView(new RedirectView("listUsuario"));
        }


        @RequestMapping(value = "buscarUsuariox", method = RequestMethod.POST)
        public  ModelAndView buscarUsuario(HttpServletRequest r) {
            String dato=r.getParameter("dato")==null ? "":r.getParameter("dato");
            List<Usuario> lista=service.listarPorNombre(dato);            
            Map<String, Object> modelo=new HashMap<String, Object> ();
            modelo.put("ListaUsuario", lista);
           return new ModelAndView("usuario/mainUsuario",modelo);
        }        
        
}
