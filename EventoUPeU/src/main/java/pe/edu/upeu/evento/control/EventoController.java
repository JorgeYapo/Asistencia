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
import pe.edu.upeu.evento.model.Evento;
import pe.edu.upeu.evento.service.EventoServis;

/**
 *
 * @author davidmp
 */
@Controller
@RequestMapping("/")
public class EventoController {
        @Autowired
        EventoServis service;	
        @Autowired
        MessageSource messageSource;      
        
       
	@RequestMapping(value = {"listEvento"}, method = RequestMethod.GET)
	public ModelAndView listEvento(ModelMap model) {
            List<Evento> lista=service.listarEntidad();
            Map<String, Object> modelo=new HashMap<String, Object> ();
            modelo.put("ListaEvento", lista);
            modelo.put("saludo", "Hola amigos");            
//            System.out.println("Holassssssssss");
            return new ModelAndView("evento/mainEvento", modelo);
	}

        @RequestMapping(value = "eliminarEvento", method = RequestMethod.GET)
        public  ModelAndView eliminarEvento(HttpServletRequest r) {
            int idEntidad=Integer.parseInt(r.getParameter("id"));
            service.eliminarEntidad(idEntidad);
//            System.out.println("si llego al metodo");
            return new ModelAndView(new RedirectView("listUsuario"));
        }


        @RequestMapping(value = "formEvento", method = RequestMethod.GET )
        public ModelAndView irFormulario(@ModelAttribute("modeloEvento") Evento entidad,BindingResult result ){
            Map<String, Object> modelo=new HashMap<String, Object> ();
            modelo.put("listaTemporada", "Holasssssssssss");
            modelo.put("listaTemporadaX", service.listarEntidad());
            modelo.put("listaTemporada2", "");
            modelo.put("listaTemporada3", "");       
           
            return new ModelAndView("evento/formEvento",modelo);
        }


        @RequestMapping(value = "guardarEvento", method = RequestMethod.POST)
        public ModelAndView guardarEventoXX(@ModelAttribute("modeloEvento") Evento entidad,
                                              BindingResult result ){      
               
                entidad.setEstado("1");
                
//                System.out.println("Fecha: "+entidad.getFecha());
//                System.out.println("H. inició: "+entidad.getHorainicio());
//                System.out.println("H. Fin: "+entidad.getHorafin());
//                System.out.println("N.Evento: "+entidad.getNombreevento());
//                System.out.println("L.Evento: "+entidad.getLugarevento());
//                System.out.println("T.Tolerancia: "+entidad.getTiempotolerancia());
//                System.out.println("Estado: "+entidad.getEstado());
//                System.out.println("Latitud: "+entidad.getLatitud());
//                System.out.println("Longitud: "+entidad.getLongitud());
//                
                
                service.guardarEntidad(entidad);
            return new ModelAndView(new RedirectView("listEvento"));
        }

        @RequestMapping(value = "modificarEvento", method = RequestMethod.GET)
        public ModelAndView modificarEvento(HttpServletRequest r ){
           int id=Integer.parseInt(r.getParameter("id"));
               Evento entidad=null;
               entidad=service.buscarEntidad(id);
            return new ModelAndView("evento/formXEvento","ModeloEvento",entidad);
        }

        @RequestMapping(value = "modificarEventoX", method = RequestMethod.GET)
        public String modificarEventoX(HttpServletRequest r, Model model ){
           int id=Integer.parseInt(r.getParameter("id"));
               Evento evento=null;
               evento=service.buscarEntidad(id);
               model.addAttribute("ModeloEvento", evento);             
            return "evento/formXEvento";
        }

        @RequestMapping(value = "actualizarEvento", method = RequestMethod.POST)
        public ModelAndView gactualizarEventoXX(@ModelAttribute("ModeloEvento") Evento entidad,
                                              BindingResult result ){
                service.modificarEntidadId(entidad);
            return new ModelAndView(new RedirectView("listEvento"));
        }


        @RequestMapping(value = "buscarEventox", method = RequestMethod.POST)
        public  ModelAndView buscarEvento(HttpServletRequest r) {
            String dato=r.getParameter("dato")==null ? "":r.getParameter("dato");
            List<Evento> lista=service.listarPorNombre(dato);            
            Map<String, Object> modelo=new HashMap<String, Object> ();
            modelo.put("ListaEvento", lista);
           return new ModelAndView("evento/mainEvento",modelo);
        }           
}
