package ejemplo.microservicios.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejemplo.microservicios.dto.RolDTO;
import ejemplo.microservicios.entity.Rol;
import ejemplo.microservicios.repository.IRolRepository;
import ejemplo.microservicios.util.MapperUtil;

@Service
public class RolService implements IRolService  {

	/** 
     * Variable LOGGER de tipo Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RolService.class);
	
	@Autowired
	private IRolRepository iRolRepository;
	
	/** 
     * Metodo para buscar todas las cuentas guardadas
     * @return Lista de objetos AccountDTO
     * @throws ServiceException En caso de presentarse
     */
    @Override
    public List<RolDTO> buscaTodosLosRoles() {
          List<Rol> rolList = (List<Rol>) iRolRepository.findAll();
          RolDTO rolDto = new RolDTO();
          List<RolDTO> rolDtoList = MapperUtil
                      .mapList(rolList, rolDto);
          LOGGER.info("-->> Roles localizados");
          return rolDtoList;
    }
    
    /** 
     * Metodo para guardar un objeto AccountDTO
     * @param accountDto objeto de transporte de datos
     * @return El objeto AccountDTO guardado
     * @throws ServiceException En caso de presentarse
     */
    @Override
    public RolDTO guardaRol(RolDTO rolDto) {
    	Rol rol = new Rol();
          //MAPEA DTO A ENTITY
    	rol = MapperUtil.convertToEntity(rolDto, rol);
    	//GUARDADO DE ROL
    	rol = iRolRepository.save(rol);
    	//MAPEA ENTITY A DTO
    	rolDto = MapperUtil.convertToDto(rol, rolDto);
    	LOGGER.info("-->> Rol guardado");
    	return rolDto;
    }
}
