package ejemplo.microservicios.service;

import java.util.List;

import ejemplo.microservicios.dto.UsuarioDTO;

public interface IUsuarioService {

	List<UsuarioDTO> buscaTodosLosUsuarios();
//	UsuarioDTO buscaUsuarioPorId(UsuarioDTO usuarioDto);
	UsuarioDTO guardaUsuario(UsuarioDTO usuarioDto);
//	UsuarioDTO actualizaUsuario(UsuarioDTO usuarioDto);
//	UsuarioDTO borraUsuario(UsuarioDTO usuarioDto);
}
