package io.caltamirano.seguridad.adapter.out.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.caltamirano.seguridad.domain.Empresa;

public interface EmpresaMongoRepository extends MongoRepository<Empresa, String> {

}
