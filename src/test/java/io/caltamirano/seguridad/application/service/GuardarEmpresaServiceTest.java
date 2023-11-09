package io.caltamirano.seguridad.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.caltamirano.seguridad.application.port.out.GuardarEmpresaPort;
import io.caltamirano.seguridad.domain.Empresa;

public class GuardarEmpresaServiceTest {

	private final GuardarEmpresaPort guardarEmpresaPort = mock(GuardarEmpresaPort.class);
	
	private final GuardarEmpresaService guardarEmpresaService =
						new GuardarEmpresaService(guardarEmpresaPort);
	
	
	@Test
	void guardarEmpresaSinId() {
		
		Empresa empresa = dadaUnaEmpresaSinId();
		
		guardarEmpresaService.guardar(empresa);
		
		assertThat(empresa).isNotNull();
		assertThat(empresa.getId()).isNotNull();
		
	}
	
	@Test
	void guardarEmpresaConId() {
		
		Empresa empresa = dadaUnaEmpresaConId(UUID.randomUUID().toString());
		
		guardarEmpresaService.guardar(empresa);
		
		assertThat(empresa).isNotNull();
		assertThat(empresa.getId()).isNotNull();
		
	}
	
	private Empresa dadaUnaEmpresaSinId() {
		
		Empresa empresa = Mockito.mock(Empresa.class);
		when(empresa.getId()).thenReturn(UUID.randomUUID().toString());
		when(empresa.getRuc()).thenReturn("12345678901");
		when(empresa.getRazonSocial()).thenReturn("MI EMPRESA S.A.C.");
		when(guardarEmpresaPort.guardar(empresa)).thenReturn(empresa);
		
		return empresa;
	}
	
	private Empresa dadaUnaEmpresaConId(String id) {
		
		Empresa empresa = Mockito.mock(Empresa.class);
		when(empresa.getId()).thenReturn(id);
		when(empresa.getRuc()).thenReturn("12345678901");
		when(empresa.getRazonSocial()).thenReturn("MI EMPRESA S.A.C.");
		when(guardarEmpresaPort.guardar(empresa)).thenReturn(empresa);
		
		return empresa;
	}

}
