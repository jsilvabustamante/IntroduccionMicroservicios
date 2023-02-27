package ejemplo.microservicios.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejemplo.microservicios.dto.FrutaDTO;
import ejemplo.microservicios.entity.Fruta;
import ejemplo.microservicios.repository.IFrutaRepository;
import ejemplo.microservicios.util.MapperUtil;

@Service
public class FrutaService implements IFrutaService {

	/** 
     * Variable LOGGER de tipo Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(FrutaService.class);
	
	@Autowired
	private IFrutaRepository iFrutaRepository;
	
    @Override
    public List<FrutaDTO> buscaTodasLasFrutas() {
          List<Fruta> frutaList = (List<Fruta>) iFrutaRepository.findAll();
          FrutaDTO frutaDto = new FrutaDTO();
          List<FrutaDTO> frutaDtoList = MapperUtil.mapList(frutaList, frutaDto);
          LOGGER.info("-->> Frutas localizadas");
          return frutaDtoList;
    }
    
    @Override
    public FrutaDTO guardaFruta(FrutaDTO frutaDto) {
    	Fruta fruta = new Fruta();
          //MAPEA DTO A ENTITY
    	fruta = MapperUtil.convertToEntity(frutaDto, fruta);
    	//GUARDADO DE FRUTA
    	fruta = iFrutaRepository.save(fruta);
    	//MAPEA ENTITY A DTO
    	frutaDto = MapperUtil.convertToDto(fruta, frutaDto);
    	LOGGER.info("-->> Fruta guardada");
    	return frutaDto;
    }
}
