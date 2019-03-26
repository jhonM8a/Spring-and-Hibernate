package com.web.reserver.ereservation.vista.rources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.reserver.ereservation.modelo.Cliente;
import com.web.reserver.ereservation.negocio.services.ClienteService;
import com.web.reserver.ereservation.vista.rources.vo.ClienteVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
@Api(tags = "cliente") // Una etiqueta para la documentación del servicio web
public class ClienteResource {

	private final ClienteService clienteService;

	public ClienteResource(ClienteService clienteService) {
		// TODO Auto-generated constructor stub
		this.clienteService = clienteService;
	}

	@PostMapping
	@ApiOperation(value = "Crear Cliente", notes = "Servicio para crear un nuevo cliente") // Documenta la operacion del
																							// metodo(titulo,
																							// descripcion)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud invalida") }) // Documentar respuesta
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
	@ApiOperation(value = "Actualizar Cliente", notes = "Servicio para actualizar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado") }) 	
	public ResponseEntity<Cliente> updateCliente(@PathVariable("identificacion") String identificacion,
			ClienteVO clienteVO) {
		/*
		 * Se consulta el cliente por la identificacion que llega como parametro, y se
		 * da una respuesta o se mapea el clienteVO
		 */
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

	@DeleteMapping("/{identificacion}")
	@ApiOperation(value = "Eliminar Cliente", notes = "Servicio para eliminar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado") })
	public void removeCliente(@PathVariable("identificacion") String identificacion) {
		Cliente cliente = this.clienteService.findByIdentification(identificacion);
		if (cliente != null) {
			this.clienteService.delete(cliente);
		}
	}

	@GetMapping
	@ApiOperation(value = "Listar Clientes", notes = "Servicio para Listat todos los cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Clientes encontrados"),
			@ApiResponse(code = 404, message = "Clientes no encontrado") })
	public ResponseEntity<List<Cliente>> findAll() {
		return ResponseEntity.ok(this.clienteService.findAll());
	}

}
