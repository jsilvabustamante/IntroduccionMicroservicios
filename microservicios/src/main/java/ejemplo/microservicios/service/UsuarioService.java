package ejemplo.microservicios.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejemplo.microservicios.dto.UsuarioDTO;
import ejemplo.microservicios.entity.Rol;
import ejemplo.microservicios.entity.Usuario;
import ejemplo.microservicios.repository.IRolRepository;
import ejemplo.microservicios.repository.IUserRepository;
import ejemplo.microservicios.util.MapperUtil;

@Service
public class UsuarioService implements IUsuarioService {
	
	/** 
     * Variable LOGGER de tipo Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private IUserRepository iUserRepository;
	
	@Autowired
	private IRolRepository iRolRepository;
	
	/** 
     * Metodo para buscar todas las cuentas guardadas
     * @return Lista de objetos AccountDTO
     * @throws ServiceException En caso de presentarse
     */
    @Override
    public List<UsuarioDTO> buscaTodosLosUsuarios() {
          List<Usuario> usuarioList = (List<Usuario>) iUserRepository.findAll();
          UsuarioDTO usuarioDto = new UsuarioDTO();
          List<UsuarioDTO> accountDtoList = MapperUtil
                      .mapList(usuarioList, usuarioDto);
          LOGGER.info("-->> Usuarios localizados");
          return accountDtoList;
    }
    
    /** 
     * Metodo para guardar un objeto AccountDTO
     * @param accountDto objeto de transporte de datos
     * @return El objeto AccountDTO guardado
     * @throws ServiceException En caso de presentarse
     */
	@Override
    public UsuarioDTO guardaUsuario(UsuarioDTO usuarioDto) {
    	Usuario usuario = new Usuario();
    	List<Rol> rolList = new ArrayList<>();
    	
          //MAPEA DTO A ENTITY
    	usuario = MapperUtil.convertToEntity(usuarioDto, usuario);
        
    	//Busca el rol para agregar
//    	Rol rol = iRolRepository.findByNombre(usuario.getRoles().get(0).getNombre());

    	//Busca si el usuario ya existe
//    	Usuario userExist = iUserRepository.findByNombre(usuario.getNombre());
		
    	//Si ya existe
//    	if(userExist != null) {
//    		LOGGER.info("-->> Usuario "+ usuario.getNombre() +" ya existe");
////    		rolList = usuario.getRoles();
//    		rolList = (List<Rol>) iUserRepository.buscaRolesdeUsuario(usuario.getNombre());
//    		LOGGER.info("-->> Roles de Usuario "+ rolList.toString());
//    		usuario = userExist;
//    	}
//    	LOGGER.info("-->> Usuario encontrado: " + usuario.toString());
//    	rolList.add(rol);
//		usuario.setRoles(rolList);
//		LOGGER.info("-->> Usuario a guardar: " + usuario.toString());
    	//GUARDADO DE USUARIO
    	usuario = iUserRepository.save(usuario);
    	//MAPEA ENTITY A DTO
    	usuarioDto = MapperUtil.convertToDto(usuario, usuarioDto);
    	LOGGER.info("-->> Usuario guardado");
    	return usuarioDto;
    }
}
