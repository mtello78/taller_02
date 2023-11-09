package io.caltamirano.seguridad.application.port.out;

import io.caltamirano.seguridad.domain.Empresa;

public interface BuscarEmpresaPort {

	Empresa buscarPorId(String id);
	
}
