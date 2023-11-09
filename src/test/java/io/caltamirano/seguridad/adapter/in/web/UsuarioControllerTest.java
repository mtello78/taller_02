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

import io.caltamirano.seguridad.adapter.in.web.dto.request.CrearUsuarioRequest;
import io.caltamirano.seguridad.application.port.in.BuscarUsuarioQuery;
import io.caltamirano.seguridad.application.port.in.GuardarUsuarioUseCase;
import io.caltamirano.seguridad.domain.Usuario;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioControllerTest {
	
    @LocalServerPort
    private int port;

    private String uri;

    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }
    
	@MockBean
	private GuardarUsuarioUseCase guardarUsuarioUseCase;
	
	@MockBean
	private BuscarUsuarioQuery buscarUsuarioQuery;
	
	@Test
	void testCrearUsuario() throws Exception {

		Usuario usuario = new Usuario("Altamirano", "Carlos");
		Usuario usuarioConId = new Usuario(UUID.randomUUID().toString(), "Altamirano", "Carlos");
		
		when(guardarUsuarioUseCase.guardar(usuario)).thenReturn(usuarioConId);
		
		CrearUsuarioRequest request = new CrearUsuarioRequest(usuario.getApellidos(), usuario.getNombres());
		
		given()
			.contentType(ContentType.JSON)
			.body(request)
			.when()
				.post(uri + "/usuario")
			.then()
				.statusCode(200)
				.body("id", Matchers.equalTo(usuarioConId.getId()));
	}
	
	@Test
	void testBuscarUsuario() throws Exception {

		String usuarioId = UUID.randomUUID().toString();
		Usuario usuario = new Usuario(usuarioId, "Altamirano", "Briceño");
		
		when(buscarUsuarioQuery.buscarPorId(usuarioId)).thenReturn(usuario);
		
		given()
			.contentType(ContentType.JSON)
			.when()
				.get(uri + "/usuario/" + usuarioId)
			.then()
				.statusCode(200)
				.body("id", Matchers.equalTo(usuario.getId()))
				.body("apellidos", Matchers.equalTo(usuario.getApellidos()))
				.body("nombres", Matchers.equalTo(usuario.getNombres()));
				
	}

}
