package ejemplo.microservicios.util;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

public final class MapperUtil {

	/**
     * Constructor privado
     */
    private MapperUtil() {
          super();
    }
    
    /**
     * Obtiene una lista de objetos de transporte a partir de una lista
     * de objetos entidad con mapeo de campos uno-a-uno.
     * @param list es la lista de objetos de entidad.
     * @param dto es el objeto de transporte.
     * @return una lista de objetos de tipo {@link T}
     */
    public static <T, V> List<T> mapList(List<V> list, T dto) {
          List<T> dtoList = new ArrayList<>();
          for (V entity : list) {
                /* Map and add. */
                dtoList.add((T) convertToDto(entity, dto));
          }
          return dtoList;
    }
    
    /**
     * Obtiene un objeto de transporte a partir del objeto de entidad
     * usando mapeo de campos uno-a-uno.
     * @param entity es el objeto de entidad.
     * @param dto es el objeto de transporte.
     * @return un referencia al objeto entidad de tipo {@link T}
     */
    @SuppressWarnings("unchecked")
    public static <T, V> T convertToDto(V entity, T dto) {
          ModelMapper mapper = new ModelMapper();
          /* Map. */
          dto = (T) mapper.map(entity, dto.getClass());
          return dto;
    }

    /**
     * Obtiene un objeto de entidad a partir del objeto de transporte
     * usando mapeo de campos uno-a-uno.
     * @param dto es el objeto de transporte
     * @param entity es el objeto de entidad.
     * @return un referencia al objeto entidad de tipo {@link V}
     */
    @SuppressWarnings("unchecked")
    public static <V, T> V convertToEntity(T dto, V entity) {
          ModelMapper mapper = new ModelMapper();
          /* Map. */
          entity = (V) mapper.map(dto, entity.getClass());
          return entity;
    }
}
