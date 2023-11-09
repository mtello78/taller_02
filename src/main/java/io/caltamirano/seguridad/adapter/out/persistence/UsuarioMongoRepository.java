package io.caltamirano.seguridad.adapter.out.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.caltamirano.seguridad.domain.Usuario;

public interface UsuarioMongoRepository extends MongoRepository<Usuario, String> {

}
