package io.caltamirano.seguridad.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import io.caltamirano.seguridad.application.port.out.BuscarUsuarioPort;
import io.caltamirano.seguridad.domain.Usuario;

@TestInstance(Lifecycle.PER_CLASS)
public class BuscarUsuarioServiceTest {

	private final BuscarUsuarioPort port = mock(BuscarUsuarioPort.class);
	
	private final BuscarUsuarioService service = new BuscarUsuarioService(port);
	
	@BeforeAll
	void configurarMock() {
		Usuario usuario = new Usuario("529ce8b5-c0e4-4194-b686-4cc2fa6299b4", "Altamirano", "Carlos");
		when(port.buscarPorId(usuario.getId())).thenReturn(usuario);
	}
	
	@Test
	void buscarUsuarioPorId() {
		
		String usuarioId = "529ce8b5-c0e4-4194-b686-4cc2fa6299b4";
		String apellidosEsperado = "Altamirano";
		String nombresEsperado = "Carlos";
		Usuario usuario = service.buscarPorId(usuarioId);
		
		assertThat(usuario).isNotNull();
		assertThat(usuario.getId()).isEqualTo(usuarioId);
		assertThat(usuario.getApellidos()).isEqualTo(apellidosEsperado);
		assertThat(usuario.getNombres()).isEqualTo(nombresEsperado);
		
	}
	

}
