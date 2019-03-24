package com.web.reserver.ereservation.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Clase que representa la tabla Reserva.
 * Las notaciones que estan sobre el Id representan como generar llaves unicas. 
 *
 * 
 *@author sumel
 * */
@Entity
@Table(name = "reserva")
@Data
public class Reserva {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
		private String idRes;
		@Temporal(TemporalType.DATE)
		private Date fechaIngresoRes;
		@Temporal(TemporalType.DATE)
		private Date fechaSalidaRes;
		private int cantidadPersonasRes;
		private String descripcionRes;
		@ManyToOne
		@JoinColumn(name = "idCli")
		private Cliente cliente;
		
}
