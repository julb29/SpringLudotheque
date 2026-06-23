package fr.eni.springludotheque.exceptions;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ClientNotFoundException extends RuntimeException {

	@NonNull private Integer id;
	
	@Override
	public String getMessage() {
		
		return "Le client " + id + " n'a pas été trouvé";
	}
}
