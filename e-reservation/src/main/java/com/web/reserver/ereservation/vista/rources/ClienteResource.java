package com.web.reserver.ereservation.vista.rources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.reserver.ereservation.modelo.Cliente;
import com.web.reserver.ereservation.negocio.services.ClienteService;
import com.web.reserver.ereservation.vista.rources.vo.ClienteVO;

/**
 * Clase que represeta el servicio web de cliente. Las notaciones sobre la clase
 * indican que sera tratada como servicio web, y que respondera y recibira
 * peticiones por medio de la ruta "/api/cliente"
 * 
 * @author sumel
 *
 */
@RestController
@RequestMapping("/api/cliente")
public class ClienteResource {

	private final ClienteService clienteService;

	public ClienteResource(ClienteService clienteService) {
		// TODO Auto-generated constructor stub
		this.clienteService = clienteService;
	}

	@PostMapping
	public ResponseEntity<Cliente> createCliente(@RequestBody ClienteVO clienteVO) {
		/*
		 * Se mapea el objeto virtual a su correspondiente objeto real del negocio.
		 */
		Cliente cliente = new Cliente();
		cliente.setNombreCli(clienteVO.getNombreCli());
		cliente.setApellidoCli(clienteVO.getApellidoCli());
		cliente.setDireccionCli(clienteVO.getDireccionCli());
		cliente.setTelefonoCli(clienteVO.getTelefonoCli());
		cliente.setEmailCli(clienteVO.getEmailCli());

		return new ResponseEntity<Cliente>(this.clienteService.create(cliente), HttpStatus.CREATED);
	}

	@PutMapping("/{identificacion}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable("identificacion") String identificacion,
			ClienteVO clienteVO) {
		/*
		 * Se consulta el cliente por la identificacion que llega como parametro,
		 * y se da una respuesta o se mapea el clienteVO
		 * */
		Cliente cliente = this.clienteService.findByIdentification(identificacion);
		if (cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		} else {
			cliente.setNombreCli(clienteVO.getNombreCli());
			cliente.setApellidoCli(clienteVO.getApellidoCli());
			cliente.setDireccionCli(clienteVO.getDireccionCli());
			cliente.setTelefonoCli(clienteVO.getTelefonoCli());
			cliente.setEmailCli(clienteVO.getEmailCli());
		}

		return new ResponseEntity<Cliente>(this.clienteService.create(cliente), HttpStatus.OK);
	}

}
