package io.caltamirano.seguridad.adapter.in.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.caltamirano.common.WebAdapter;
import io.caltamirano.seguridad.adapter.in.web.dto.request.CrearUsuarioRequest;
import io.caltamirano.seguridad.adapter.in.web.dto.response.CrearUsuarioResponse;
import io.caltamirano.seguridad.adapter.in.web.dto.response.ListarUsuarioResponse;
import io.caltamirano.seguridad.adapter.in.web.mapper.UsuarioMapper;
import io.caltamirano.seguridad.application.port.in.BuscarUsuarioQuery;
import io.caltamirano.seguridad.application.port.in.GuardarUsuarioUseCase;
import io.caltamirano.seguridad.domain.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequiredArgsConstructor
@Api(tags = {"Usuario"})
public class UsuarioController {
	
	/* este comentario debe eliminarse */
	private final GuardarUsuarioUseCase guardarUsuarioUseCase;
	
	private final BuscarUsuarioQuery buscarUsuarioQuery;
	
	@Autowired
	private UsuarioMapper UsuarioMapper;
	
	@ApiOperation(value = "Servicio para crear una Usuario", response = CrearUsuarioResponse.class)
	@PostMapping("/usuario")
	public ResponseEntity<CrearUsuarioResponse> crear(@RequestBody final CrearUsuarioRequest request) {
		Usuario Usuario = guardarUsuarioUseCase.guardar(UsuarioMapper.toUsuario(request));
		CrearUsuarioResponse response = UsuarioMapper.toCrearUsuarioResponse(Usuario);
		return new ResponseEntity<CrearUsuarioResponse>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Servicio para obtener una Usuario por su identificador", response = ListarUsuarioResponse.class)
	@GetMapping("/usuario/{id}")
	public ResponseEntity<ListarUsuarioResponse> buscar(@PathVariable("id") String id) {
		/* se debe retornar directamnte */
		ListarUsuarioResponse Usuarios = UsuarioMapper.toListarUsuarioResponse(buscarUsuarioQuery.buscarPorId(id)); 
		return new ResponseEntity<ListarUsuarioResponse>(Usuarios, HttpStatus.OK);
	}
	
}
