package io.caltamirano.seguridad.adapter.in.web.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.caltamirano.seguridad.adapter.in.web.dto.request.CrearUsuarioRequest;
import io.caltamirano.seguridad.domain.Usuario;

@SpringBootTest
public class UsuarioMapperTest {

	@Autowired
	UsuarioMapper mapper;
	
	@Test
	void testMetodoToUsuario() {
		
		CrearUsuarioRequest request = new CrearUsuarioRequest("Altamirano", "Carlos");
		Usuario usuario = mapper.toUsuario(request);
		
		assertThat(usuario).isNotNull();
		assertThat(usuario.getApellidos()).isNotBlank();
		assertThat(usuario.getNombres()).isNotBlank();
		
	}
	
}
