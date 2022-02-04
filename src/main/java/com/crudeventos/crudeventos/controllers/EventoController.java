package com.crudeventos.crudeventos.controllers;

import com.crudeventos.crudeventos.models.ConvidadoModel;
import com.crudeventos.crudeventos.models.ConvidadoRepository;
import com.crudeventos.crudeventos.models.EventoModel;
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
	
	@Autowired
	private ConvidadoRepository cr;
	
	@GetMapping("/cadastro")
	public String getCadastroEvento() {
		return "cadastroEvento";
	}
	
	@PostMapping("/cadastro")
	public String postEvento(EventoModel evento) {
		er.save(evento);
		return "redirect:lista";
	}
	
	@GetMapping("/cadastro/convidado")
	public ModelAndView getCadastroConvidado(@RequestParam long idEvento) {
		ModelAndView mv = new ModelAndView("cadastroConvidado");
		mv.addObject("idEvento", idEvento);
		return mv;
	}
	
	@PostMapping("/cadastro/convidado")
	public String postConvidado(long idEvento, ConvidadoModel convidado) {
		convidado.setEvento(er.findById(idEvento).get());
		cr.save(convidado);
		return "redirect:/evento?id=" + idEvento;
	}
	
	@GetMapping("/lista")
	public ModelAndView listaEventos(ConvidadoModel evento) {
		ModelAndView mv = new ModelAndView("listaEventos");
		mv.addObject("eventos", er.findAll());
		return mv;
	}
	
	@GetMapping("/evento")
	public ModelAndView getEvento(@RequestParam long id) {
		ModelAndView mv = new ModelAndView("infoEvento");
		EventoModel evento = er.findById(id).get();
		mv.addObject("evento", evento);
		mv.addObject("convidados", cr.findByEvento(evento));
		return mv;
	}
	
	@GetMapping("/boporort")
	public String getBopornort() {
		return "index";
	}
}
