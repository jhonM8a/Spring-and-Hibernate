package com.web.reserver.ereservation.negocio.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web.reserver.ereservation.modelo.Cliente;
import com.web.reserver.ereservation.modelo.Reserva;
/**
 * 
 *@author sumel
 * */

public interface ReservaRepository extends JpaRepository<Reserva, String>{
	/**
	 * Definición de método para consultar las reservas por la fecha de ingreso en
	 * base a un rango de fechas
	 * 
	 * @param fechaInicio
	 * @param fechaSalida
	 * @author sumel
	 */	
	@Query("Select r from Reserva r where r.fechaIngresoRes =:fechaInicio and r.fechaSalidaRes =:fechaSalida")
	public List<Reserva> find(@Param("fechaInicio") Date fechaInicio, @Param("fechaSalida")Date fechaSalida);	
	/**
	 * Método para consultar las reservas por cliente
	 * 
	 * @param cliente
	 * @author sumel
	 */
	@Query("Select r from Reserva r where r.cliente =:cliente")
	public List<Reserva> findByCliente(Cliente cliente);
}
