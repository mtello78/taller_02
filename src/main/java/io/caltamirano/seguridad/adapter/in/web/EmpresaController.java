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
import io.caltamirano.seguridad.adapter.in.web.dto.request.CrearEmpresaRequest;
import io.caltamirano.seguridad.adapter.in.web.dto.response.CrearEmpresaResponse;
import io.caltamirano.seguridad.adapter.in.web.dto.response.ListarEmpresaResponse;
import io.caltamirano.seguridad.adapter.in.web.mapper.EmpresaMapper;
import io.caltamirano.seguridad.application.port.in.BuscarEmpresaQuery;
import io.caltamirano.seguridad.application.port.in.GuardarEmpresaUseCase;
import io.caltamirano.seguridad.domain.Empresa;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequiredArgsConstructor
@Api(tags = {"Empresa"})
public class EmpresaController {
	
	private final GuardarEmpresaUseCase guardarEmpresaUseCase;
	
	private final BuscarEmpresaQuery buscarEmpresaQuery;
	
	@Autowired
	private EmpresaMapper empresaMapper;
	
	@ApiOperation(value = "Servicio para crear una empresa", response = CrearEmpresaResponse.class)
	@PostMapping("/empresa")
	public ResponseEntity<CrearEmpresaResponse> crear(@RequestBody final CrearEmpresaRequest request) {
		Empresa empresa = guardarEmpresaUseCase.guardar(empresaMapper.toEmpresa(request));
		CrearEmpresaResponse response = empresaMapper.toCrearEmpresaResponse(empresa);
		return new ResponseEntity<CrearEmpresaResponse>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Servicio para obtener una empresa por su identificador", response = ListarEmpresaResponse.class)
	@GetMapping("/empresa/{id}")
	public ResponseEntity<ListarEmpresaResponse> buscar(@PathVariable("id") String id) {
		ListarEmpresaResponse empresas = empresaMapper.toListarEmpresaResponse(buscarEmpresaQuery.buscarPorId(id)); 
		return new ResponseEntity<ListarEmpresaResponse>(empresas, HttpStatus.OK);
	}
	
}
