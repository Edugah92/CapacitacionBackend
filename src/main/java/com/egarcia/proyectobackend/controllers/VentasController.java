package com.egarcia.proyectobackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egarcia.proyectobackend.entity.Producto;
import com.egarcia.proyectobackend.repository.VentasRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v2")
public class VentasController {

	@Autowired
	private VentasRepository ventasRepository;
	
	@ApiOperation(value = "Obtener Productos", notes = "Obtener lista de productos disponibles\n"
			+"No es necesario enviar algun parametro\n"
			+"regresa una lista con todos los campos\n "
			+ "disponibles para la producto")
	@GetMapping(value = "/ventas")
	private ResponseEntity<List<Producto>> getAllProductos(){
		return ResponseEntity.ok(ventasRepository.getAll());
	}
}
