package io.caltamirano.seguridad.application.service;

import io.caltamirano.common.UseCase;
import io.caltamirano.seguridad.application.port.in.GuardarUsuarioUseCase;
import io.caltamirano.seguridad.application.port.out.GuardarUsuarioPort;
import io.caltamirano.seguridad.domain.Usuario;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class GuardarUsuarioService implements GuardarUsuarioUseCase {

	private final GuardarUsuarioPort guardarUsuarioPort;
	
	@Override
	public Usuario guardar(Usuario Usuario) {
		return guardarUsuarioPort.guardar(Usuario);
	}
	
	
}
