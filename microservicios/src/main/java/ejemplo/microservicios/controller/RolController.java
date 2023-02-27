package ejemplo.microservicios.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ejemplo.microservicios.dto.RolDTO;
import ejemplo.microservicios.service.IRolService;

@RestController
@RequestMapping("/roles")
public class RolController {

	@Autowired
	private IRolService iRolService;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> consultaRoles(){
      ResponseEntity<Object> response = null;
      List<RolDTO> listResult = new ArrayList<RolDTO>();
      listResult = iRolService.buscaTodosLosRoles();
      response = ResponseEntity.status(HttpStatus.OK).body(listResult);
      return response;
}

	@RequestMapping(value = "/guardar", method = RequestMethod.POST
			, produces = MediaType.APPLICATION_JSON_VALUE
			, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardarRoles(@RequestBody RolDTO rolDto) {
		ResponseEntity<Object> response = null;
		rolDto = iRolService.guardaRol(rolDto);
		response = ResponseEntity.status(HttpStatus.CREATED).body(rolDto);
		return response;
	}
}
