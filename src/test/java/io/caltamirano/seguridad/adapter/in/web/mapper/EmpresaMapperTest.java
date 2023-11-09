package io.caltamirano.seguridad.adapter.in.web.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.caltamirano.seguridad.adapter.in.web.dto.request.CrearEmpresaRequest;
import io.caltamirano.seguridad.domain.Empresa;

@SpringBootTest
public class EmpresaMapperTest {

	@Autowired
	EmpresaMapper mapper;
	
	@Test
	void testMetodoToEmpresa() {
		
		CrearEmpresaRequest request = new CrearEmpresaRequest("20440273030", "MI EMPRESA S.A.C.");
		Empresa empresa = mapper.toEmpresa(request);
		
		assertThat(empresa).isNotNull();
		assertThat(empresa.getRuc()).isNotBlank();
		assertThat(empresa.getRazonSocial()).isNotBlank();
		
	}
	
}
