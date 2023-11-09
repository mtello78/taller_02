package io.caltamirano.seguridad.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.caltamirano.seguridad.application.port.out.GuardarUsuarioPort;
import io.caltamirano.seguridad.domain.Usuario;

public class GuardarUsuarioServiceTest {

	private final GuardarUsuarioPort guardarUsuarioPort = mock(GuardarUsuarioPort.class);
	
	private final GuardarUsuarioService guardarUsuarioService =
						new GuardarUsuarioService(guardarUsuarioPort);
	
	
	@Test
	void guardarUsuarioSinId() {
		
		Usuario usuario = dadaUnaUsuarioSinId();
		
		guardarUsuarioService.guardar(usuario);
		
		assertThat(usuario).isNotNull();
		assertThat(usuario.getId()).isNotNull();
		
	}
	
	@Test
	void guardarUsuarioConId() {
		
		Usuario usuario = dadaUnaUsuarioConId(UUID.randomUUID().toString());
		
		guardarUsuarioService.guardar(usuario);
		
		assertThat(usuario).isNotNull();
		assertThat(usuario.getId()).isNotNull();
		
	}
	
	private Usuario dadaUnaUsuarioSinId() {
		
		Usuario usuario = Mockito.mock(Usuario.class);
		when(usuario.getId()).thenReturn(UUID.randomUUID().toString());
		when(usuario.getApellidos()).thenReturn("Altamirano");
		when(usuario.getNombres()).thenReturn("Carlos");
		when(guardarUsuarioPort.guardar(usuario)).thenReturn(usuario);
		
		return usuario;
	}
	
	private Usuario dadaUnaUsuarioConId(String id) {
		
		Usuario usuario = Mockito.mock(Usuario.class);
		when(usuario.getId()).thenReturn(id);
		when(usuario.getApellidos()).thenReturn("Altamirano");
		when(usuario.getNombres()).thenReturn("Carlos");
		when(guardarUsuarioPort.guardar(usuario)).thenReturn(usuario);
		
		return usuario;
	}

}
