package com.web.reserver.ereservation.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.reserver.ereservation.modelo.Cliente;

/**
 * Interface para definir las operaciones de base de datos ralacionadas 
 * con cliente. Ya la todos los metodos del CRUD los tiene la implemetación 
 * de JpaRepository
 * 
 * @author sumel
 * 
 * 
 * */
public interface ClienteRepository extends JpaRepository<Cliente, String>{ //JpaRepository<Entidad, Tipo de dato primario>

	/**
	 * Definición de metodo que busca clientes por su apellido
	 * @author sumel
	 * 
	 * */
	public List<Cliente> findByApellidoCli(String apellidoCli);
	
	public Cliente findByIdentification(String identificacionCli);
	
}
