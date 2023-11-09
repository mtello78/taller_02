package io.caltamirano.seguridad.application.port.out;

import io.caltamirano.seguridad.domain.Usuario;

public interface BuscarUsuarioPort {

	Usuario buscarPorId(String id);
	
}
