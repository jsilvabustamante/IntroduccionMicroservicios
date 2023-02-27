package ejemplo.microservicios.service;

import java.util.List;

import ejemplo.microservicios.dto.FrutaDTO;

public interface IFrutaService {

	List<FrutaDTO> buscaTodasLasFrutas();
	FrutaDTO guardaFruta(FrutaDTO frutaDto);
}
