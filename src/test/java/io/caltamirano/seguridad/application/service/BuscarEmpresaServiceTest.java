package io.caltamirano.seguridad.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import io.caltamirano.seguridad.application.port.out.BuscarEmpresaPort;
import io.caltamirano.seguridad.domain.Empresa;

@TestInstance(Lifecycle.PER_CLASS)
public class BuscarEmpresaServiceTest {

	private final BuscarEmpresaPort port = mock(BuscarEmpresaPort.class);
	
	private final BuscarEmpresaService service = new BuscarEmpresaService(port);
	
	@BeforeAll
	void configurarMock() {
		Empresa empresa = new Empresa("529ce8b5-c0e4-4194-b686-4cc2fa6299b4", "12345678901", "MI EMPRESA S.A.C.");
		when(port.buscarPorId(empresa.getId())).thenReturn(empresa);
	}
	
	@Test
	void buscarEmpresaPorId() {
		
		String empresaId = "529ce8b5-c0e4-4194-b686-4cc2fa6299b4";
		String rucEsperado = "12345678901";
		String razonSocialEsperado = "MI EMPRESA S.A.C.";
		Empresa empresa = service.buscarPorId(empresaId);
		
		assertThat(empresa).isNotNull();
		assertThat(empresa.getId()).isEqualTo(empresaId);
		assertThat(empresa.getRuc()).isEqualTo(rucEsperado);
		assertThat(empresa.getRazonSocial()).isEqualTo(razonSocialEsperado);
		
	}
	

}
