package Kodlama.io.Devs.kodlamaIoDevs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Devs.kodlamaIoDevs.entities.concretes.Technology;

public interface TechnologyRepository extends JpaRepository<Technology,Integer> {
    
}
