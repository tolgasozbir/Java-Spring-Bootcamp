package Kodlama.io.Devs.kodlamaIoDevs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.kodlamaIoDevs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.kodlamaIoDevs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

    private List<Language> languages;

    public InMemoryLanguageRepository() {
        languages = new ArrayList<Language>();
        languages.add(new Language(1, "C#"));
        languages.add(new Language(2, "Java"));
        languages.add(new Language(3, "Dart"));
    }

    @Override
    public List<Language> getAll() {
        return languages;
    }

    @Override
    public Language getById(int id) {
        for (Language language : languages) {
            if (language.getId() == id) {
                return language;
            }
        }
        return null;
    }

    @Override
    public void add(Language language) {
        this.languages.add(language);
    }

    @Override
    public void delete(int id) {
        for (Language language : languages) {
            if (language.getId() == id) {
                this.languages.remove(language);
            }
        }
    }

    @Override
    public void update(int id, Language language) {
        for (Language lng : languages) {
            if (lng.getId() == id) {
                lng.setName(language.getName());;
            }
        }
    }
    
}
