package br.com.alura.listavip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.service.ConvidadoService;

@Controller
public class ConvidadoController {

	@Autowired
	ConvidadoService service;
	
	@RequestMapping(path = "/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(path = "/listaconvidados")
	public String listaConvidados(Model model) {
		model.addAttribute("convidados", service.obterTodos());
		model.addAttribute("convidado", new Convidado());
		return "listaconvidados";
	}
	
	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@ModelAttribute Convidado convidado, Model model) {
		service.salvar(convidado);
//		new EmailService().enviar(convidado.getNome(), convidado.getEmail());
		return listaConvidados(model);
	}
	
}
