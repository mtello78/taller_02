package io.caltamirano.seguridad.adapter.out.persistence;

import java.util.NoSuchElementException;

import io.caltamirano.common.PersistenceAdapter;
import io.caltamirano.seguridad.application.port.out.BuscarEmpresaPort;
import io.caltamirano.seguridad.application.port.out.EliminarEmpresaPort;
import io.caltamirano.seguridad.application.port.out.GuardarEmpresaPort;
import io.caltamirano.seguridad.domain.Empresa;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class EmpresaPersistenceAdapter implements GuardarEmpresaPort, BuscarEmpresaPort, EliminarEmpresaPort {

	private final EmpresaMongoRepository repository;

	@Override
	public Empresa guardar(Empresa empresa) {
		return repository.save(empresa);
	}

	@Override
	public Empresa buscarPorId(String id) {
		return repository
					.findById(id)
					.orElseThrow(NoSuchElementException::new);
	}

	@Override
	public void eliminarPorId(String id) {
		repository.deleteById(id);
	}

}
