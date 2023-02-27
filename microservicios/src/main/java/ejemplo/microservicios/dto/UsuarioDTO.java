package ejemplo.microservicios.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = -6392524999583320193L;

	private String nombre;
    
    private String password;
    
    private List<RolDTO> roles = new ArrayList<>();
}
