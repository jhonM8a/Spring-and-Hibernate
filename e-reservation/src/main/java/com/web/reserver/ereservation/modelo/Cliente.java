/**
 * 
 */
package com.web.reserver.ereservation.modelo;

import lombok.Data;

/**
 * Clase que representa la entidad de base de datos Cliente. Se usa lombok, espesificamentge {@code @Data} para
 * generar automaticamente setter y getters.
 * @author sumel
 *
 */
@Data
public class Cliente {

	int idCliente;
	String nombreCliente;
	String apellidoCliente;

	public Cliente() {}
}
