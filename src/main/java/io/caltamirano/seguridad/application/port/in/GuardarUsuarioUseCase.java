package io.caltamirano.seguridad.application.port.in;

import io.caltamirano.seguridad.domain.Usuario;

public interface GuardarUsuarioUseCase {
	
	Usuario guardar(Usuario usuario);
	
}
