package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.entities.concrete.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguageController {
	
	private ProgrammingLanguageService languageService;

	@Autowired
	public ProgrammingLanguageController(ProgrammingLanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll() {
		return languageService.getAll();
	}

	@GetMapping("/getbyid")
	public ProgrammingLanguage getById(@RequestParam int id){
		return languageService.getById(id);
	}

	@DeleteMapping("/delete")
	public String delete(@RequestParam int id) {
		languageService.delete(id);
		return "Silme işlemi başarılı";
	}

	@PostMapping("/add")
	public String add(ProgrammingLanguage programmingLanguage) throws Exception {
		languageService.add(programmingLanguage);
		return "Ekleme işlemi başarılı";
	}

	@PutMapping("/update/{id}")
	public String update(ProgrammingLanguage programmingLanguage){
		languageService.update(programmingLanguage);
		return "Güncelleme işlemi başarılı";
	}
}
