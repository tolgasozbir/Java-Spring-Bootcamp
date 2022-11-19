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

import Kodlama.io.Devs.kodlamaIoDevs.business.abstracts.TechologyService;
import Kodlama.io.Devs.kodlamaIoDevs.business.requests.technology.CreateTechnologyRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.requests.technology.DeleteTechnologyRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.requests.technology.UpdateTechnologyRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.responses.GetAllTechnologiesResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {
    private TechologyService techologyService;

    @Autowired
    public TechnologyController(TechologyService techologyService) {
        this.techologyService = techologyService;
    }
    
    @GetMapping("/getall")
    public List<GetAllTechnologiesResponse> getAll(){
        return this.techologyService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateTechnologyRequest createTechnologyRequest) throws Exception{
        this.techologyService.add(createTechnologyRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody() DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {
        this.techologyService.delete(deleteTechnologyRequest);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") int id, @RequestBody UpdateTechnologyRequest updateTechnologyRequest) throws Exception{
        this.techologyService.update(updateTechnologyRequest, id);
    }


}
