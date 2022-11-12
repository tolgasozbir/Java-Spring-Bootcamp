package Kodlama.io.Devs.kodlamaIoDevs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.kodlamaIoDevs.business.abstracts.LanguageService;
import Kodlama.io.Devs.kodlamaIoDevs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.kodlamaIoDevs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
    private LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public Language getById(int id) {
        return languageRepository.getById(id);
    }

    @Override
    public void add(Language language) throws Exception {
        if (language.getName() == null || language.getName().isEmpty()) {
            throw new Exception("Name cannot be empty!");
        } else if (isUnique(language.getName())) {
            throw new Exception("Language registered!");
        }
        languageRepository.add(language);
    }

    @Override
    public void delete(int id) {
        languageRepository.delete(id);
    }

    @Override
    public void update(int id, Language language) throws Exception {
        if (language.getName() == null || language.getName().isEmpty()) {
            throw new Exception("Name cannot be empty!");
        } else if (isUnique(language.getName())) {
            throw new Exception("Language registered!");
        }
        languageRepository.update(id, language);
    }
    
    private boolean isUnique(String langName){
        List<Language> languages = languageRepository.getAll();
        for (Language language : languages) {
            if (language.getName() == langName) {
                return true;
            }
        }
        return false;
    }

}
