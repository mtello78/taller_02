package io.caltamirano.seguridad.adapter.in.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearEmpresaRequest {

	private String ruc;
	
	private String razonSocial;

}
