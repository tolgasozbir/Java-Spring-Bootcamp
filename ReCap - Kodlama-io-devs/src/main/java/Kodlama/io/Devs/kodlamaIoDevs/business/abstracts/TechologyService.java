package Kodlama.io.Devs.kodlamaIoDevs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.kodlamaIoDevs.business.requests.technology.CreateTechnologyRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.requests.technology.DeleteTechnologyRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.requests.technology.UpdateTechnologyRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.responses.GetAllTechnologiesResponse;

public interface TechologyService {
    List<GetAllTechnologiesResponse> getAll();
    void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
    void update(UpdateTechnologyRequest updateTechnologyRequest, int id) throws Exception;
    void delete(DeleteTechnologyRequest deleteTechnologyRequest);
}
