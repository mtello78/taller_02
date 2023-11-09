package io.caltamirano.seguridad.adapter.in.web.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.caltamirano.seguridad.adapter.in.web.dto.request.CrearUsuarioRequest;
import io.caltamirano.seguridad.adapter.in.web.dto.response.CrearUsuarioResponse;
import io.caltamirano.seguridad.adapter.in.web.dto.response.ListarUsuarioResponse;
import io.caltamirano.seguridad.domain.Usuario;

@Component
public class UsuarioMapper {

	@Autowired
	ModelMapper modelMapper;

	public Usuario toUsuario(CrearUsuarioRequest request) {
		return modelMapper.map(request, Usuario.class);
	}

	public CrearUsuarioResponse toCrearUsuarioResponse(Usuario Usuario) {
		return modelMapper.map(Usuario, CrearUsuarioResponse.class);
	}

	public ListarUsuarioResponse toListarUsuarioResponse(Usuario Usuario) {
		return modelMapper.map(Usuario, ListarUsuarioResponse.class);
	}
	
	
}
