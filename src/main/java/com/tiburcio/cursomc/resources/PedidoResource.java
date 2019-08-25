package com.tiburcio.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tiburcio.cursomc.domain.Pedido;
import com.tiburcio.cursomc.services.PedidoService;
import com.tiburcio.cursomc.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService service;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> listarTodos() {
		return ResponseEntity.ok().body(service.buscaTodos());	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) throws ObjectNotFoundException {
		Pedido obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);	
	}
	
}
