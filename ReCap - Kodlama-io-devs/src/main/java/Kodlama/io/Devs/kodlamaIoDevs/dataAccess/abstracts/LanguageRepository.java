package Kodlama.io.Devs.kodlamaIoDevs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Devs.kodlamaIoDevs.entities.concretes.Language;

public interface LanguageRepository extends JpaRepository<Language,Integer> {
    
}
