package Kodlama.io.Devs.kodlamaIoDevs.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTechnologiesResponse {
    private int id;
	private String technology;
	private String programmingLanguage;
}
