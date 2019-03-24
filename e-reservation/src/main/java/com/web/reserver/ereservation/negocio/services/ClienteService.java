/**
 * 
 */
package com.web.reserver.ereservation.negocio.services;

import org.springframework.stereotype.Service;

import com.web.reserver.ereservation.modelo.Cliente;
import com.web.reserver.ereservation.negocio.repository.ClienteRepository;

/**
 * Clase para definir los servicios de cliente
 * 
 * @author sumel
 *
 */
@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		// TODO Auto-generated constructor stub
		this.clienteRepository = clienteRepository;

	}
	
	/**
	 * 
	 * Metodo que expone el servicio de guardar cliente del repositorio.
	 * Este metodo no esta implementado en la clase {@link ClienteRepository}. Surge
	 * por la herencia de JpaRepository.
	 * @param cliente
	 * @return cliente
	 * @author sumel
	 * */
	public Cliente create(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	/**
	 * 
	 * Metodo que expone el servicio de actualizar cliente del repositorio.
	 * el {@code cliente} que llega, tiene como nulo su Id.
	 * Este metodo no esta implementado en la clase {@link ClienteRepository}. Surge
	 * por la herencia de JpaRepository.
	 * @param cliente
	 * @return cliente
	 * @author sumel
	 * */
	public Cliente update(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	/**
	 * Metodo par eliminar un cliente.
	 * 
	 * @param cliente
	 * @author sumel
	 * */
	public void delete(Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}
	/**
	 * Metódo que busca un cliente, dado su Id.
	 * 
	 * @param identificacionCli
	 * @return Cliente
	 * @author sumel
	 * 
	 * */
	
	public Cliente findByIdentification(String identificacionCli) {
		return this.clienteRepository.findByIdentification(identificacionCli);
	}
}
