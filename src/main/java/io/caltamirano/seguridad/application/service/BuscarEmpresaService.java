package io.caltamirano.seguridad.application.service;

import io.caltamirano.common.UseCase;
import io.caltamirano.seguridad.application.port.in.BuscarEmpresaQuery;
import io.caltamirano.seguridad.application.port.out.BuscarEmpresaPort;
import io.caltamirano.seguridad.domain.Empresa;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class BuscarEmpresaService implements BuscarEmpresaQuery {

	private final BuscarEmpresaPort buscarEmpresaPort;
	
	@Override
	public Empresa buscarPorId(String id) {
		return buscarEmpresaPort.buscarPorId(id);
	}

}
