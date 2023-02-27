package ejemplo.microservicios.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ejemplo.microservicios.entity.Rol;

@Repository
public interface IRolRepository extends CrudRepository<Rol, Long> {

	public Rol findByNombre(String nombre);
}
