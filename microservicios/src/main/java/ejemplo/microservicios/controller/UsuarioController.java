package ejemplo.microservicios.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ejemplo.microservicios.dto.RolDTO;
import ejemplo.microservicios.dto.UsuarioDTO;
import ejemplo.microservicios.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService iUserService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> consultaUsuarios(){
      ResponseEntity<Object> response = null;
      List<UsuarioDTO> listResult = new ArrayList<UsuarioDTO>();
      listResult = iUserService.buscaTodosLosUsuarios();
      response = ResponseEntity.status(HttpStatus.OK).body(listResult);
      return response;
}

	@RequestMapping(value = "/guardar", method = RequestMethod.POST
			, produces = MediaType.APPLICATION_JSON_VALUE
			, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardarUsuarios(@RequestBody UsuarioDTO usuarioDto) {
		ResponseEntity<Object> response = null;
		usuarioDto = iUserService.guardaUsuario(usuarioDto);
		response = ResponseEntity.status(HttpStatus.CREATED).body(usuarioDto);
		return response;
	}
}
