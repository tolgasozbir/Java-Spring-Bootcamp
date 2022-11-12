package Kodlama.io.Devs.kodlamaIoDevs.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.Devs.kodlamaIoDevs.entities.concretes.Language;

public interface LanguageRepository {
    List<Language> getAll();
    Language getById(int id);
    
    void add(Language language);
    void delete(int id);
    void update(int id, Language language);
}
