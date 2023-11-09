package io.caltamirano.seguridad.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class UsuarioTest {

	@Test
	void crearUsuarioConId() {
		
		String usuarioId = UUID.randomUUID().toString();
		String apellidos = "Altamirano";
		String nombres = "Carlos";
		
		Usuario empresa = new Usuario(usuarioId, apellidos, nombres);
		assertThat(empresa).isNotNull();
		assertThat(empresa.getId()).isEqualTo(usuarioId);
		assertThat(empresa.getApellidos()).isEqualTo(apellidos);
		assertThat(empresa.getNombres()).isEqualTo(nombres);
		
	}
	
	@Test
	void crearUsuarioSinId() {
		
		String apellidos = "Altamirano";
		String nombres = "Carlos";
		
		Usuario usuario = new Usuario(apellidos, nombres);
		assertThat(usuario).isNotNull();
		assertThat(usuario.getId()).isNull();
		assertThat(usuario.getApellidos()).isEqualTo(apellidos);
		assertThat(usuario.getNombres()).isEqualTo(nombres);
		
	}
	
	@Test
	void validarMetodosGet() {
		
		String apellidos = "Altamirano";
		String nombres = "Carlos";
		
		Usuario empresa = new Usuario(apellidos, nombres);
		assertEquals(apellidos, empresa.getApellidos());
		assertEquals(nombres, empresa.getNombres());
		
	}
	
}
