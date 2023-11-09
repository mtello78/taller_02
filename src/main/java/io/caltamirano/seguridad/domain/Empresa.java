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
@Document("empresa")
public class Empresa {

	private String id;
	
	@NonNull
	private String ruc;
	
	@NonNull
	private String razonSocial;
	
}
