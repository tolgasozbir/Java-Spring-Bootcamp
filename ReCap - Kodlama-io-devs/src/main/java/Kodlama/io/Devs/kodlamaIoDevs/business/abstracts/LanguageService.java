package Kodlama.io.Devs.kodlamaIoDevs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.kodlamaIoDevs.business.requests.language.CreateLanguageRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.requests.language.DeleteLanguageRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.requests.language.UpdateLanguageRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.responses.GetAllLanguagesResponse;

public interface LanguageService {
    List<GetAllLanguagesResponse> getAll();
    GetAllLanguagesResponse getById(int id);

    void add(CreateLanguageRequest createLanguageRequest) throws Exception;
    void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception;
    void update(UpdateLanguageRequest updateLanguageRequest, int id) throws Exception;
}
