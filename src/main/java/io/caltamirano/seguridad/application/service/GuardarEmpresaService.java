package io.caltamirano.seguridad.application.service;

import io.caltamirano.common.UseCase;
import io.caltamirano.seguridad.application.port.in.GuardarEmpresaUseCase;
import io.caltamirano.seguridad.application.port.out.GuardarEmpresaPort;
import io.caltamirano.seguridad.domain.Empresa;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class GuardarEmpresaService implements GuardarEmpresaUseCase {

	private final GuardarEmpresaPort guardarEmpresaPort;
	
	@Override
	public Empresa guardar(Empresa empresa) {
		return guardarEmpresaPort.guardar(empresa);
	}
	
	
}
