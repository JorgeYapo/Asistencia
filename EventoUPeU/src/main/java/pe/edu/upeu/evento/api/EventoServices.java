/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.evento.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upeu.evento.model.Evento;
import pe.edu.upeu.evento.service.EventoServis;

/**
 *
 * @author Redes
 */

@RestController
@RequestMapping("/event")
public class EventoServices {
   
    @Autowired
    public EventoServis servis;
    
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Evento> listarEventos(){return servis.listarEntidad(); }
        
}
