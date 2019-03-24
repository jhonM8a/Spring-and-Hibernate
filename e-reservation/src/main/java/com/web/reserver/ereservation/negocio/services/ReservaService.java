package com.web.reserver.ereservation.negocio.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.reserver.ereservation.modelo.Cliente;
import com.web.reserver.ereservation.modelo.Reserva;
import com.web.reserver.ereservation.negocio.repository.ReservaRepository;

/**
 * Clase para definir los servicios de Reserva
 * 
 * @author sumel
 *
 */
@Service
@Transactional(readOnly = true)
public class ReservaService {
	
	private final ReservaRepository reservaRepository;
	
	public ReservaService(ReservaRepository reservaRepository) {
		// TODO Auto-generated constructor stub
		this.reservaRepository = reservaRepository;
	}
	
	
	/**
	 * Metódo que crea una reserva
	 * 
	 *@param reserva
	 *@return reserva
	 *@author sumel
	 * */
	@Transactional
	public Reserva create(Reserva reserva) {
		return this.reservaRepository.save(reserva);
	}
	
	/**
	 * Metódo que actualiza una reserva. El id de la reserva debe ser
	 * nulo
	 * 
	 *@param reserva
	 *@return reserva
	 * @author sumel
	 * 
	 * */
	@Transactional
	public Reserva update(Reserva reserva) {
		return this.reservaRepository.save(reserva);
	}
	
	/**
	 * Metódo que elimina una reserva
	 * 
	 * @param reserva
	 * @author sumel
	 * */
	@Transactional
	public void delete(Reserva reserva) {
		this.reservaRepository.delete(reserva);
	}
	
	/**
	 * Metodo que busca una reserva por fecha de inicio y fin.
	 * @param fechaInicio
	 * @param fechaSalida
	 * @author sumel
	 * */
	 public List<Reserva> find(Date fechaInicio, Date fechaSalida){
		 return this.reservaRepository.find(fechaInicio, fechaSalida);
	 }
	 
	 /**
	  * Metódo para consultar las reservas de un cliente
	  * 
	  * @param cliente
	  * @return reserva
	  * @author sumel
	  * 
	  * 
	  * */
	 public List<Reserva> findByCliente(Cliente cliente){
		return this.reservaRepository.findByCliente(cliente); 
	 }
}
