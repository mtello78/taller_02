package io.caltamirano.seguridad.adapter.in.web.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CrearUsuarioResponse {

	private String id;
	
	private String apellidos;
	
	private String nombres;
	
}
