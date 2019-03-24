package com.web.reserver.ereservation.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.reserver.ereservation.modelo.Reserva;
/**
 * 
 *@author sumel
 * */

public interface ReservaRepository extends JpaRepository<Reserva, String>{

}
