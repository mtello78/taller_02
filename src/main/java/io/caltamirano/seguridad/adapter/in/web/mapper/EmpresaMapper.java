package io.caltamirano.seguridad.adapter.in.web.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.caltamirano.seguridad.adapter.in.web.dto.request.CrearEmpresaRequest;
import io.caltamirano.seguridad.adapter.in.web.dto.response.CrearEmpresaResponse;
import io.caltamirano.seguridad.adapter.in.web.dto.response.ListarEmpresaResponse;
import io.caltamirano.seguridad.domain.Empresa;

@Component
public class EmpresaMapper {

	@Autowired
	ModelMapper modelMapper;

	public Empresa toEmpresa(CrearEmpresaRequest request) {
		return modelMapper.map(request, Empresa.class);
	}

	public CrearEmpresaResponse toCrearEmpresaResponse(Empresa empresa) {
		return modelMapper.map(empresa, CrearEmpresaResponse.class);
	}

	public ListarEmpresaResponse toListarEmpresaResponse(Empresa empresa) {
		return modelMapper.map(empresa, ListarEmpresaResponse.class);
	}
	
	
}
