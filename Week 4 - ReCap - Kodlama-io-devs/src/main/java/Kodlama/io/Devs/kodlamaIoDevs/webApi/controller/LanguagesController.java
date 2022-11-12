package Kodlama.io.Devs.kodlamaIoDevs.webApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.kodlamaIoDevs.business.abstracts.LanguageService;
import Kodlama.io.Devs.kodlamaIoDevs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public List<Language> getAll(){
        return languageService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Language getById(@PathVariable("id") int id){
        return languageService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Language language) throws Exception{
        languageService.add(language);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        languageService.delete(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Language language) throws Exception{
        languageService.update(id, language);
    }
}
