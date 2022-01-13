package com.crudeventos.crudeventos.controllers;

import com.crudeventos.crudeventos.models.ConvidadoModel;
import com.crudeventos.crudeventos.models.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventoController {
    
    @Autowired
    private EventoRepository er;
	
    @GetMapping("/cadastro")
    public String getEvento() {
        return "cadastroEvento";
    }
    
    @PostMapping("/cadastro")
    public String postEvento(ConvidadoModel evento) {
	er.save(evento);
        return "redirect:lista";
    }
    
    @GetMapping("/lista")
    public ModelAndView listaEventos(ConvidadoModel evento) {
	ModelAndView mv = new ModelAndView("listaEventos");
	mv.addObject("eventos", er.findAll());
        return mv;
    }
    
    @GetMapping("/evento")
    public ModelAndView lerEvento(@RequestParam long id) {
	ModelAndView mv = new ModelAndView("infoEvento");
	mv.addObject("evento", er.findById(id));
        return mv;
    }
    
    @GetMapping("/bopornort")
    public String getBopornort() {
        return "index";
    }
}
