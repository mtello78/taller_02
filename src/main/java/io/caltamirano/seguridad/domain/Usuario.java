package io.caltamirano.seguridad.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Document("usuario")
public class Usuario {

	private String id;
	
	@NonNull
	private String apellidos;
	
	@NonNull
	private String nombres;
	
}
