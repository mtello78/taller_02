package io.caltamirano.seguridad.adapter.in.web.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CrearEmpresaResponse {

	private String id;
	
	private String ruc;
	
	private String razonSocial;
	
}
