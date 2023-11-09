package io.caltamirano.seguridad.application.port.in;

import io.caltamirano.seguridad.domain.Empresa;

public interface GuardarEmpresaUseCase {
	
	Empresa guardar(Empresa empresa);
	
}
