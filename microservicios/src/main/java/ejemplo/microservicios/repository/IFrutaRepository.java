package ejemplo.microservicios.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ejemplo.microservicios.entity.Fruta;

@Repository
public interface IFrutaRepository extends CrudRepository<Fruta, Long> {

}
