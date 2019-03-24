/**
 * 
 */
package com.web.reserver.ereservation.modelo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la entidad de base de datos Cliente. Se usa lombok, espesificamentge {@code @Data} para
 * generar automaticamente setter y getters.
 * @author sumel
 *
 */
@Data
@Entity
@Table(name = "cliente")
@NamedQuery(name ="Cliente.findByIdentification",query="Select c from Cliente c where c.identificacionCli=?1")
public class Cliente {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idCli;
	private String identificacionCli;
	private String nombreCli;
	private String apellidoCli;
	private String direccionCli;
	private String telefonoCli;
	private String emailCli;
	//Un cliente puede tener muchas reservas. El mapeo de clases es bi direccional.
	@OneToMany(mappedBy = "cliente")
	private Set<Reserva> reservas;

	public Cliente() {}
}
