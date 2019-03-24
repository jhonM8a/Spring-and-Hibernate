package com.web.reserver.ereservation.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.reserver.ereservation.modelo.Cliente;

/**
 * Interface para definir las operaciones de base de datos ralacionadas 
 * con cliente
 * 
 * @author sumel
 * 
 * 
 * */
public interface ClienteRepository extends JpaRepository<Cliente, String>{ //JpaRepository<Entidad, Tipo de dato primario>

}
