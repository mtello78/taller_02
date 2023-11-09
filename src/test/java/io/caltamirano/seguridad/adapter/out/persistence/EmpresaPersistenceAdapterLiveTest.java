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

import io.caltamirano.seguridad.domain.Empresa;

@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
//@ActiveProfiles("qa")
@SpringBootTest
public class EmpresaPersistenceAdapterLiveTest {

	@Autowired
	private EmpresaPersistenceAdapter persistence;
	
	private Empresa empresa;
	
	@Order(1)
	@Test
	void crearEmpresa() {
		empresa = new Empresa(null, "12345678901", "MI EMPRESA");
		empresa = persistence.guardar(empresa);
		
		assertThat(empresa).isNotNull();
		assertThat(empresa.getId()).isNotNull();
	}
	
	@Order(2)
	@Test
	void buscarPorIdExistente() {
		
		Empresa empresaEncontrada = persistence.buscarPorId(empresa.getId());
		
		assertThat(empresaEncontrada).isNotNull();
		assertThat(empresaEncontrada.getId()).isEqualTo(empresa.getId());		
	}
	
	@Order(3)
	@Test
	void eliminarPorId() {
		
		Empresa empresaEliminada = null;
		
		try {
			persistence.eliminarPorId(empresa.getId());
			empresaEliminada = persistence.buscarPorId(empresa.getId());
		} catch (NoSuchElementException excepcion) {
			empresaEliminada = null;
		}
		
		assertThat(empresaEliminada).isNull();
	}
	
	@Test
	void buscarPorIdNoExiste() {
		
		Exception excepcion = assertThrows(NoSuchElementException.class, () -> {
			persistence.buscarPorId("id-no-existe");
		});
		
		assertThat(excepcion).isNotNull();
	}
	
	
}

