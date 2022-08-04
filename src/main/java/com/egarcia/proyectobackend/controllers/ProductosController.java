package com.egarcia.proyectobackend.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.egarcia.proyectobackend.entity.Producto;
import com.egarcia.proyectobackend.services.ProductosService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v2")
public class ProductosController {

	@Autowired
	private ProductosService productoService;
	
	@ApiOperation(value = "Obtener Productos", notes = "Obtener lista de productos disponibles\n"
			+"No es necesario enviar algun parametro\n"
			+"regresa una lista con todos los campos\n "
			+ "disponibles para la producto")
	@GetMapping(value = "/productos")
	private ResponseEntity<List<Producto>> getAllProductos(){
		return ResponseEntity.ok(productoService.findAll());
	}
	
	@ApiOperation(value = "Obtener una producto", notes = "Obtener una producto espefsificada por el id de la producto\n, "
			+ "el cual sera el parametro que recibe,\n"
			+ "al ejecutarse correctamente devolvera un registro de la producto pedida" )
	@GetMapping (value = "/productos/{id}")
	private ResponseEntity<Optional<Producto>> getProducto(@PathVariable("id") Long idProducto){
		return ResponseEntity.ok(productoService.findById(idProducto));
	}
	
	@ApiOperation(value = "Crear producto", notes = "Crear una Nueva producto, recibe un objeto producto\n"
			+ "con los valores correspondientes para su creación,\n"
			+ "retorna el objeto creado dentro del body" )
	@PostMapping(value = "/productos")
	private ResponseEntity<Producto> saveProducto (@RequestBody Producto producto){
		try {
			Producto productoSave = productoService.save(producto);
			return ResponseEntity.created(new URI("/productos/"+ productoSave.getPro_IdProd())).body(productoSave);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@ApiOperation(value = "Actualizar producto", notes = "Actualiza una producto, recibe un objeto producto\n"
			+ "													con los valores correspondientes para su creación,\n"
																+ "ademas de el id de la producto a modificar"
			+ "													retorna el objeto actualizado dentro del body" )
	@PutMapping(value = "/productos/{id}")
	private ResponseEntity<Producto> updateProducto (@PathVariable("id") Long idProducto,@RequestBody Producto producto){
		try {
			Producto productoSave = productoService.save(producto);
			return ResponseEntity.created(new URI("/productos/"+ productoSave.getPro_IdProd())).body(productoSave);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@ApiOperation(value = "Eliminar producto", notes = "Elimina un objeto producto, recibe el id de la producto a eliminar\n"
			+ "se retorna la confirmacion de la eliminacion" )
	@DeleteMapping (value = "/productos/{id}")
	private ResponseEntity<Boolean> deleteProducto (@PathVariable("id") Long idproducto){
		productoService.deleteById(idproducto);
		return ResponseEntity.ok(!(productoService.findById(idproducto)!=null));
	}
}
