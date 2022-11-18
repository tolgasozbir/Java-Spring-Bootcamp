package Kodlama.io.Devs.kodlamaIoDevs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.kodlamaIoDevs.business.abstracts.LanguageService;
import Kodlama.io.Devs.kodlamaIoDevs.business.requests.language.CreateLanguageRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.requests.language.DeleteLanguageRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.requests.language.UpdateLanguageRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.responses.GetAllLanguagesResponse;
import Kodlama.io.Devs.kodlamaIoDevs.business.responses.GetAllTechnologiesResponse;
import Kodlama.io.Devs.kodlamaIoDevs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.kodlamaIoDevs.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Devs.kodlamaIoDevs.entities.concretes.Language;
import Kodlama.io.Devs.kodlamaIoDevs.entities.concretes.Technology;

@Service
public class LanguageManager implements LanguageService {
    private LanguageRepository languageRepository;
    private TechnologyRepository technologyRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository, TechnologyRepository technologyRepository) {
        this.languageRepository = languageRepository;
        this.technologyRepository = technologyRepository;
    }
 
    @Override
    public List<GetAllLanguagesResponse> getAll() {
        List<Language> languages = this.languageRepository.findAll();
        List<Technology> technologies = technologyRepository.findAll();
        List<GetAllLanguagesResponse> languagesResponses = new ArrayList<GetAllLanguagesResponse>();

        for (Language language : languages) {
            GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
            List<GetAllTechnologiesResponse> technologyResponse = new ArrayList<GetAllTechnologiesResponse>();

            responseItem.setId(language.getId());
            responseItem.setName(language.getName());
            for (Technology technology : technologies) {
                GetAllTechnologiesResponse responseTech = new GetAllTechnologiesResponse();
                if (responseItem.getId() == technology.getLanguage().getId()) {
                    responseTech.setId(technology.getId()); 
                    responseTech.setTechnology(technology.getName());
                    responseTech.setProgrammingLanguage(technology.getLanguage().getName());
                    technologyResponse.add(responseTech);
                }
            }
            responseItem.setTechnologies(technologyResponse);
            languagesResponses.add(responseItem);
        }

        return languagesResponses;
    }

    @Override
    public GetAllLanguagesResponse getById(int id) {
        Language language = languageRepository.findById(id).get();
        GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
        List<Technology> technologies = technologyRepository.findAll();
        List<GetAllTechnologiesResponse> technologyResponse = new ArrayList<GetAllTechnologiesResponse>();

        responseItem.setId(language.getId());
        responseItem.setName(language.getName());
        for (Technology technology : technologies) {
            GetAllTechnologiesResponse responseTech = new GetAllTechnologiesResponse();
            if (responseItem.getId() == technology.getLanguage().getId()) {
                responseTech.setId(technology.getId()); 
                responseTech.setTechnology(technology.getName());
                responseTech.setProgrammingLanguage(technology.getLanguage().getName());
                technologyResponse.add(responseTech);
            }

            responseItem.setTechnologies(technologyResponse);
        }

        return responseItem;
    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) throws Exception {

        Language language = new Language();
        language.setName(createLanguageRequest.getName());

        if (isUnique(createLanguageRequest.getName())) {
            throw new Exception("this programming language is in list already.");
        }
        else if (createLanguageRequest.getName() == null || createLanguageRequest.getName().isEmpty()) {
            throw new Exception("this area cannot be blank");
        }

        this.languageRepository.save(language);
    }

    @Override
    public void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception {
        this.languageRepository.deleteById(deleteLanguageRequest.getId());
    }

    @Override
    public void update(UpdateLanguageRequest updateLanguageRequest, int id) throws Exception {
        Language language = languageRepository.findById(id).get();

        if (updateLanguageRequest.getName() == null || updateLanguageRequest.getName().isEmpty()) {
            throw new Exception("Name cannot be empty!");
        }
        else if (isUnique(updateLanguageRequest.getName())) {
            throw new Exception("Language registered!");
        }

        language.setName(updateLanguageRequest.getName());
        this.languageRepository.save(language);
    }

    private boolean isUnique(String langName){
        List<Language> languages = languageRepository.findAll();
        for (Language language : languages) {
            if (language.getName() == langName) {
                return true;
            }
        }
        return false;
    }
}
