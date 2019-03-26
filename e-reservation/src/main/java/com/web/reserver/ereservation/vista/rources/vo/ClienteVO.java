/**
 * 
 */
package com.web.reserver.ereservation.vista.rources.vo;

import lombok.Data;

/**
 * Clase vo(virtual object) de cliente, sirve para transportarse sin atarse a
 * ninguna tecnologia
 * 
 * @author sumel
 *
 */
@Data
public class ClienteVO
{


	private String identificacionCli;
	private String nombreCli;
	private String apellidoCli;
	private String direccionCli;
	private String telefonoCli;
	private String emailCli;

	public ClienteVO() {
	}

}
