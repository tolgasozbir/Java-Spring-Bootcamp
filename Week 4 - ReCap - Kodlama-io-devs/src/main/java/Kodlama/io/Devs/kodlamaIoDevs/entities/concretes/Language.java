package Kodlama.io.Devs.kodlamaIoDevs.entities.concretes;

public class Language {
    private int id;
    private String name;

    public Language(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Language() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }  
}
