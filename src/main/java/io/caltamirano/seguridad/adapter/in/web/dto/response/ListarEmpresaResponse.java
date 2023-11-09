package io.caltamirano.seguridad.adapter.in.web.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ListarEmpresaResponse {

	private String id;
	
	private String ruc;
	
	private String razonSocial;
	
}
