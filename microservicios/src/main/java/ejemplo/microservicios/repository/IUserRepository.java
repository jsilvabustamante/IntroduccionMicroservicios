package ejemplo.microservicios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ejemplo.microservicios.entity.Rol;
import ejemplo.microservicios.entity.Usuario;

@Repository
public interface IUserRepository extends CrudRepository<Usuario, Long> {

	public Usuario findByNombre(String nombre);
	
//	@Query(value = "SELECT roles FROM Usuario u where u.nombre = :nombre")
//	public List<Rol> buscaRolesdeUsuario(@Param("nombre")String nombre);
}
