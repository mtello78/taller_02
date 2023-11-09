package io.caltamirano.seguridad.adapter.out.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.caltamirano.seguridad.domain.Usuario;

@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
//@ActiveProfiles("qa")
@SpringBootTest
public class UsuarioPersistenceAdapterLiveTest {

	@Autowired
	private UsuarioPersistenceAdapter persistence;
	
	private Usuario usuario;
	
	@Order(1)
	@Test
	void crearUsuario() {
		usuario = new Usuario(null, "Altamirano", "Carlos");
		usuario = persistence.guardar(usuario);
		
		assertThat(usuario).isNotNull();
		assertThat(usuario.getId()).isNotNull();
	}
	
	@Order(2)
	@Test
	void buscarPorIdExistente() {
		
		Usuario usuarioEncontrada = persistence.buscarPorId(usuario.getId());
		
		assertThat(usuarioEncontrada).isNotNull();
		assertThat(usuarioEncontrada.getId()).isEqualTo(usuario.getId());		
	}
	
	@Order(3)
	@Test
	void eliminarPorId() {
		
		Usuario usuarioEliminada = null;
		
		try {
			persistence.eliminarPorId(usuario.getId());
			usuarioEliminada = persistence.buscarPorId(usuario.getId());
		} catch (NoSuchElementException excepcion) {
			usuarioEliminada = null;
		}
		
		assertThat(usuarioEliminada).isNull();
	}
	
	@Test
	void buscarPorIdNoExiste() {
		
		Exception excepcion = assertThrows(NoSuchElementException.class, () -> {
			persistence.buscarPorId("id-no-existe");
		});
		
		assertThat(excepcion).isNotNull();
	}
	
	
}

