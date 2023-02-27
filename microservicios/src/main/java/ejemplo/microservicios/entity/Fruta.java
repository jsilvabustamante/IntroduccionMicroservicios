package ejemplo.microservicios.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "frutas")
@EntityScan
public class Fruta implements Serializable{

	private static final long serialVersionUID = -2192524999523620118L;

	@Id
	@Column(name = "id_fruta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    private String nombre;
    
    private String color;
}
