package edu.ucentral.proyecto.uci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ucentral.proyecto.models.Cama;
import edu.ucentral.proyecto.uci.service.ICamaService;

@Controller
@RequestMapping(value = "/camas") // Para diferenciar entres controladores ya que todos los metodos listar los llamare "index"
//Ruta de primer nivel camas
public class CamaController {

	// Inyeccion de independencia. Instanciar los obj sin crear un constructor
	@Autowired	
	private ICamaService camaService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String listar(Model model) {
		// List<Cama> list = camaService.findAll();
		model.addAttribute("titulo", "Listado camas");
		model.addAttribute("camas", camaService.findAll());
		return "camas/listar";
	}

	//@PathVariable: URl dinamicas
	@RequestMapping(value = "/detalle/{id}", method = RequestMethod.GET)
	public String verDetalle(@PathVariable("id") Long idCama, Model model) {
		// Cama cama = camaService.findById(idCama);
		model.addAttribute("titulo", "Detalle Cama");
		model.addAttribute("cama", camaService.findById(idCama));
		return "camas/detalle";
	}

	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") Long idCama, Model model) {
		// model.addAttribute("idCama", idCama);
		camaService.delete(idCama);
		return "redirect:/camas/index";
	}

	@GetMapping(value = "/create")
	public String crear(Model model) {// Boton: crear
		model.addAttribute("titulo", "Adicionar cama");
		return "camas/formCama";
	}

	@PostMapping("save")
	public String guardar(Cama cama) {
		camaService.save(cama);
		return "redirect:/camas/index";
	}

}
