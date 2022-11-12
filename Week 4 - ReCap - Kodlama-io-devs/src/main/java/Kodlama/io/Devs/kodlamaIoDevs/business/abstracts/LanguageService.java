package Kodlama.io.Devs.kodlamaIoDevs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.kodlamaIoDevs.entities.concretes.Language;

public interface LanguageService {
    List<Language> getAll();
    Language getById(int id);

    void add(Language language) throws Exception;
    void delete(int id);
    void update(int id, Language language) throws Exception;
}
