package ejemplo.microservicios.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ejemplo.microservicios.dto.FrutaDTO;
import ejemplo.microservicios.service.IFrutaService;

@RestController
@RequestMapping("/frutas")
public class FrutaController {

	@Autowired
	private IFrutaService iFrutaService;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> buscarFrutas(){
      ResponseEntity<Object> response = null;
      List<FrutaDTO> listResult = new ArrayList<FrutaDTO>();
      listResult = iFrutaService.buscaTodasLasFrutas();
      response = ResponseEntity.status(HttpStatus.OK).body(listResult);
      return response;
}

	@RequestMapping(value = "/guardar", method = RequestMethod.POST
			, produces = MediaType.APPLICATION_JSON_VALUE
			, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardarFrutas(@RequestBody FrutaDTO frutaDto) {
		ResponseEntity<Object> response = null;
		frutaDto = iFrutaService.guardaFruta(frutaDto);
		response = ResponseEntity.status(HttpStatus.CREATED).body(frutaDto);
		return response;
	}
	
	@RequestMapping("/saludo/{nombre}")
	public String greeting(@PathVariable("nombre") String nombre) {
    	return "Hola " + nombre+ ", bienvenido";
	}
}
