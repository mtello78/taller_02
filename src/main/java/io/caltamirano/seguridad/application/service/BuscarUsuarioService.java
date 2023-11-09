package io.caltamirano.seguridad.application.service;

import io.caltamirano.common.UseCase;
import io.caltamirano.seguridad.application.port.in.BuscarUsuarioQuery;
import io.caltamirano.seguridad.application.port.out.BuscarUsuarioPort;
import io.caltamirano.seguridad.domain.Usuario;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class BuscarUsuarioService implements BuscarUsuarioQuery {

	private final BuscarUsuarioPort buscarUsuarioPort;
	
	@Override
	public Usuario buscarPorId(String id) {
		return buscarUsuarioPort.buscarPorId(id);
	}

}
