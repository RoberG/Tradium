package es.urjc.code.daw.tablonanuncios;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Dashboard {
	
	//Si se abre la URL http://127.0.0.1:8080/h2-console y se configura
	//la URL JDBC con el valor jdbc:h2:mem:testdb se puede acceder a la 
	//base de datos de la aplicación

	@Autowired
	private ProductRepository ProductRepository;
	
	@Autowired
	private UserRepository UserRepository;
	
	@Autowired
	private ValorationRepository ValorationRepository;
	

	@PostConstruct
	public void init() {
		User u1 = new User("name", "location", "locationY");
		User u2 = new User("name", "location", "locationY");
		Product p1 = new Product("name", "desc", "tags", 90);
		Valoration v1 = new Valoration(u1, u2, 5);
	
		ProductRepository.save(p1);
		
		UserRepository.save(u1);
		UserRepository.save(u2);
		
		ValorationRepository.save(v1);
		
		//repository.save(new Product("Juan", "Hola caracola", "XXXX"));
	}
/*
	@RequestMapping("/")
	public String tablon(Model model) {

		model.addAttribute("anuncios", epository.findAll());

		return "tablon";
	}

	@RequestMapping("/anuncio/nuevo")
	public String nuevoAnuncio(Model model, Product anuncio) {

		repository.save(anuncio);

		return "anuncio_guardado";

	}

	@RequestMapping("/anuncio/{id}")
	public String verAnuncio(Model model, @PathVariable long id) {
		
		Product anuncio = repository.findOne(id);

		model.addAttribute("anuncio", anuncio);

		return "ver_anuncio";
	}*/
}