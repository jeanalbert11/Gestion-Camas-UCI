package edu.ucentral.proyecto.uci.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ucentral.proyecto.models.Cama;
import edu.ucentral.proyecto.models.Ips;
import edu.ucentral.proyecto.models.Localidad;
import edu.ucentral.proyecto.uci.service.IIpsService;
import edu.ucentral.proyecto.uci.service.ILocalidadService;

@Controller
@RequestMapping(value = "/ipss") // Para diferenciar entres controladores ya que todos los metodos listar los
									// llamare "index"
//Ruta de primer nivel ipss
public class IpsController {

	// Inyeccion de independencia. Instanciar los obj sin crear un constructor
	@Autowired
	private IIpsService ipsService;

	@Autowired
	private ILocalidadService localidadService;

	
	@PutMapping(value = "/{id}/adicionar-camas")
	//@PathVariable: URl dinamicas
	//@RequestBody: 
	public String addCama(@RequestBody List<Cama> camas, @PathVariable(value = "id") Long id) {
		// Buscar la ips
		Ips ips = this.ipsService.findById(id);
		if (ips == null) {
			return null;
		}
		//Adicionamos las camas a la IPS
		camas.forEach(c->{
			ips.addCama(c);
		});
		return "";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String listar(Model model) {
		// List<Ips> list = ipsService.findAll();
		model.addAttribute("titulo", "Listado ipss");
		model.addAttribute("ipss", ipsService.findAll());
		return "ipss/listar";
	}

	// @PathVariable: URl dinamicas
	@RequestMapping(value = "/detalle/{id}", method = RequestMethod.GET)
	public String verDetalle(@PathVariable("id") Long idIps, Model model) {
		// Ips ips = ipsService.findById(idIps);
		model.addAttribute("titulo", "Detalle Ips");
		model.addAttribute("ips", ipsService.findById(idIps));
		return "ipss/detalle";
	}

	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") Long idIps, Model model) {
		// model.addAttribute("idIps", idIps);
		ipsService.delete(idIps);
		return "redirect:/ipss/index";
	}

	@GetMapping(value = "/create")
	public String crear(Model model) {// Boton: crear
		model.addAttribute("titulo", "Adicionar ips");
		return "ipss/formIps";
	}

	@PostMapping("save")
	public String guardar(Ips ips) {
		ipsService.save(ips);
		return "redirect:/ipss/index";
	}

	@ModelAttribute("localidades")
	public List<Localidad> localidades() {
		return localidadService.findAll();
	}

}
