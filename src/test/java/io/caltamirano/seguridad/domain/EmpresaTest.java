package io.caltamirano.seguridad.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class EmpresaTest {

	@Test
	void crearEmpresaConId() {
		
		String empresaId = UUID.randomUUID().toString();
		String ruc = "12345678901";
		String razonSocial = "MI EMPRESA S.A.C.";
		
		Empresa empresa = new Empresa(empresaId, ruc, razonSocial);
		assertThat(empresa).isNotNull();
		assertThat(empresa.getId()).isEqualTo(empresaId);
		assertThat(empresa.getRuc()).isEqualTo(ruc);
		assertThat(empresa.getRazonSocial()).isEqualTo(razonSocial);
		
	}
	
	@Test
	void crearEmpresaSinId() {
		
		String ruc = "12345678901";
		String razonSocial = "MI EMPRESA S.A.C.";
		
		Empresa empresa = new Empresa(ruc, razonSocial);
		assertThat(empresa).isNotNull();
		assertThat(empresa.getId()).isNull();
		assertThat(empresa.getRuc()).isEqualTo(ruc);
		assertThat(empresa.getRazonSocial()).isEqualTo(razonSocial);
		
	}
	
	@Test
	void validarMetodosGet() {
		
		String ruc = "12345678901";
		String razonSocial = "MI EMPRESA S.A.C.";
		
		Empresa empresa = new Empresa(ruc, razonSocial);
		assertEquals(ruc, empresa.getRuc());
		assertEquals(razonSocial, empresa.getRazonSocial());
		
	}
	
}
