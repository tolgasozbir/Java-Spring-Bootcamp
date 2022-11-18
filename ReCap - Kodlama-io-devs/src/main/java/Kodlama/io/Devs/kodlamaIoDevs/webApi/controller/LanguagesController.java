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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.kodlamaIoDevs.business.abstracts.LanguageService;
import Kodlama.io.Devs.kodlamaIoDevs.business.requests.language.CreateLanguageRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.requests.language.DeleteLanguageRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.requests.language.UpdateLanguageRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.responses.GetAllLanguagesResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public List<GetAllLanguagesResponse> getAll(){
        return this.languageService.getAll();
    }

    @GetMapping("/getById")
	public GetAllLanguagesResponse getById(@RequestParam int id) {
		return this.languageService.getById(id);
	}

    @PostMapping("/add")
    public void add(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception{
        this.languageService.add(createLanguageRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody() DeleteLanguageRequest deleteLanguageRequest) throws Exception {
        this.languageService.delete(deleteLanguageRequest);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") int id, @RequestBody UpdateLanguageRequest updateLanguageRequest) throws Exception{
        this.languageService.update(updateLanguageRequest, id);
    }
}
