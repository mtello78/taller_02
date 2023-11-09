package io.caltamirano.seguridad.adapter.in.web;

import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.when;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;

import io.caltamirano.seguridad.adapter.in.web.dto.request.CrearEmpresaRequest;
import io.caltamirano.seguridad.application.port.in.BuscarEmpresaQuery;
import io.caltamirano.seguridad.application.port.in.GuardarEmpresaUseCase;
import io.caltamirano.seguridad.domain.Empresa;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmpresaControllerTest {
	
    @LocalServerPort
    private int port;

    private String uri;

    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }
    
	@MockBean
	private GuardarEmpresaUseCase guardarEmpresaUseCase;
	
	@MockBean
	private BuscarEmpresaQuery buscarEmpresaQuery;
	
	@Test
	void testCrearEmpresa() throws Exception {

		Empresa empresa = new Empresa("20440273030", "EMPRESA S.A.C.");
		Empresa empresaConId = new Empresa(UUID.randomUUID().toString(), "20440273030", "EMPRESA S.A.C.");
		
		when(guardarEmpresaUseCase.guardar(empresa)).thenReturn(empresaConId);
		
		CrearEmpresaRequest request = new CrearEmpresaRequest(empresa.getRuc(), empresa.getRazonSocial());
		
		given()
			.contentType(ContentType.JSON)
			.body(request)
			.when()
				.post(uri + "/empresa")
			.then()
				.statusCode(200)
				.body("id", Matchers.equalTo(empresaConId.getId()));
	}
	
	@Test
	void testBuscarEmpresa() throws Exception {

		String empresaId = UUID.randomUUID().toString();
		Empresa empresa = new Empresa(empresaId, "20440273030", "EMPRESA S.A.C.");
		
		when(buscarEmpresaQuery.buscarPorId(empresaId)).thenReturn(empresa);
		
		given()
			.contentType(ContentType.JSON)
			.when()
				.get(uri + "/empresa/" + empresaId)
			.then()
				.statusCode(200)
				.body("id", Matchers.equalTo(empresa.getId()))
				.body("ruc", Matchers.equalTo(empresa.getRuc()))
				.body("razonSocial", Matchers.equalTo(empresa.getRazonSocial()));
				
	}

}
