package io.caltamirano.seguridad.application.port.in;

import io.caltamirano.seguridad.domain.Empresa;

public interface BuscarEmpresaQuery {

	Empresa buscarPorId(String id);
	
}
