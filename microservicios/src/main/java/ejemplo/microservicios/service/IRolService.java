package ejemplo.microservicios.service;

import java.util.List;

import ejemplo.microservicios.dto.RolDTO;

public interface IRolService {

	List<RolDTO> buscaTodosLosRoles();
//	UsuarioDTO buscaUsuarioPorId(UsuarioDTO usuarioDto);
	RolDTO guardaRol(RolDTO rolDto);
//	UsuarioDTO actualizaUsuario(UsuarioDTO usuarioDto);
//	UsuarioDTO borraUsuario(UsuarioDTO usuarioDto);
}
