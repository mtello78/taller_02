package io.caltamirano.seguridad.adapter.out.persistence;

import java.util.NoSuchElementException;

import io.caltamirano.common.PersistenceAdapter;
import io.caltamirano.seguridad.application.port.out.BuscarUsuarioPort;
import io.caltamirano.seguridad.application.port.out.EliminarUsuarioPort;
import io.caltamirano.seguridad.application.port.out.GuardarUsuarioPort;
import io.caltamirano.seguridad.domain.Usuario;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class UsuarioPersistenceAdapter implements GuardarUsuarioPort, BuscarUsuarioPort, EliminarUsuarioPort {

	private final UsuarioMongoRepository repository;

	@Override
	public Usuario guardar(Usuario Usuario) {
		return repository.save(Usuario);
	}

	@Override
	public Usuario buscarPorId(String id) {
		return repository
					.findById(id)
					.orElseThrow(NoSuchElementException::new);
	}

	@Override
	public void eliminarPorId(String id) {
		repository.deleteById(id);
	}

}
