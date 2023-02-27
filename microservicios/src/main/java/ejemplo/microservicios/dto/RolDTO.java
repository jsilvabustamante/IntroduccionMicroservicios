package ejemplo.microservicios.dto;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EntityScan
public class RolDTO implements Serializable{

	private static final long serialVersionUID = -6392524999523620193L;
	
	private String nombre;
    private String descripcion;
}
