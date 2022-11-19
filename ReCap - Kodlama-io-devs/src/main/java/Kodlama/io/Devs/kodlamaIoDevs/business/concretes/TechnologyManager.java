package Kodlama.io.Devs.kodlamaIoDevs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.kodlamaIoDevs.business.abstracts.TechologyService;
import Kodlama.io.Devs.kodlamaIoDevs.business.requests.technology.CreateTechnologyRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.requests.technology.DeleteTechnologyRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.requests.technology.UpdateTechnologyRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.responses.GetAllTechnologiesResponse;
import Kodlama.io.Devs.kodlamaIoDevs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.kodlamaIoDevs.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Devs.kodlamaIoDevs.entities.concretes.Language;
import Kodlama.io.Devs.kodlamaIoDevs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechologyService {
    private TechnologyRepository technologyRepository;
    private LanguageRepository languageRepository;

    @Autowired
    public TechnologyManager(TechnologyRepository technologyRepository, LanguageRepository languageRepository) {
        this.technologyRepository = technologyRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public List<GetAllTechnologiesResponse> getAll() {
        List<Technology> technologies = technologyRepository.findAll();
        List<GetAllTechnologiesResponse> technologiesResponses = new ArrayList<GetAllTechnologiesResponse>();

        for (Technology technology : technologies) {
            GetAllTechnologiesResponse responseItem = new GetAllTechnologiesResponse();
            responseItem.setId(technology.getId());
            responseItem.setTechnology(technology.getName());
            responseItem.setProgrammingLanguage(technology.getLanguage().getName());

            technologiesResponses.add(responseItem);
        }
        return technologiesResponses;
    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
        if(isUnique(createTechnologyRequest.getTechnology())) {
		    throw new Exception	("this language technology is in list already.");
		}

        Technology technology = new Technology();
        Language language = new Language();
        try {
            language = this.languageRepository.findById(createTechnologyRequest.getLanguageId()).get(); 
        } catch (Exception e) { 
            throw new Exception	("not found this id : " + createTechnologyRequest.getLanguageId() + "**********");
        }

        technology.setName(createTechnologyRequest.getTechnology());
	    technology.setLanguage(language);
        
	    technologyRepository.save(technology);
        
    }

    @Override
    public void update(UpdateTechnologyRequest updateTechnologyRequest, int id) throws Exception {
        Technology technology = this.technologyRepository.findById(id).get();

        if (updateTechnologyRequest.getName() == null || updateTechnologyRequest.getName().isEmpty()) {
            throw new Exception("Name cannot be empty!");
        }
        else if (isUnique(updateTechnologyRequest.getName())) {
            throw new Exception("Language registered!");
        }

        technology.setName(updateTechnologyRequest.getName());
        this.technologyRepository.save(technology);
    }

    @Override
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
        technologyRepository.deleteById(deleteTechnologyRequest.getId());
    }

    private boolean isUnique(String langName){
        List<Technology> technologies = technologyRepository.findAll();
        for (Technology techs : technologies) {
            if (techs.getName() == langName) {
                return true;
            }
        }
        return false;
    }
    
}
