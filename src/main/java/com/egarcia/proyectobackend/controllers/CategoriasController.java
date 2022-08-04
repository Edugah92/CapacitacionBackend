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

import com.egarcia.proyectobackend.entity.Categoria;
import com.egarcia.proyectobackend.services.CategoriasService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v2")
public class CategoriasController {
	
	@Autowired
	private CategoriasService categoriaService;
	
	@ApiOperation(value = "Obtener Categorias", notes = "Obtener lista de categorias disponibles\n"
														+"No es necesario enviar algun parametro\n"
														+"regresa una lista con todos los campos\n "
														+ "disponibles para la categoria")
	@GetMapping(value = "/categorias")
	private ResponseEntity<List<Categoria>> getAllCategorias(){
		return ResponseEntity.ok(categoriaService.findAll());
	}
	
	@ApiOperation(value = "Obtener una categoria", notes = "Obtener una categoria espefsificada por el id de la categoria\n, "
															+ "el cual sera el parametro que recibe,\n"
															+ "al ejecutarse correctamente devolvera un registro de la categoria pedida" )
	@GetMapping (value = "/categorias/{id}")
	private ResponseEntity<Optional<Categoria>> getCategoria(@PathVariable("id") Long idCategoria){
		return ResponseEntity.ok(categoriaService.findById(idCategoria));
	}
	
	@ApiOperation(value = "Crear Categoria", notes = "Crear una Nueva Categoria, recibe un objeto categoria\n"
													+ "con los valores correspondientes para su creación,\n"
													+ "retorna el objeto creado dentro del body" )
	@PostMapping(value = "/categorias")
	private ResponseEntity<Categoria> saveCategoria (@RequestBody Categoria categoria){
		try {
			Categoria categoriaSave = categoriaService.save(categoria);
			return ResponseEntity.created(new URI("/categorias/"+ categoriaSave.getCat_IdCate())).body(categoriaSave);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@ApiOperation(value = "Actualizar Categoria", notes = "Actualiza una Categoria, recibe un objeto categoria\n"
			+ "													con los valores correspondientes para su creación,\n"
																+ "ademas de el id de la categoria a modificar"
			+ "													retorna el objeto actualizado dentro del body" )
	@PutMapping(value = "/categorias/{id}")
	private ResponseEntity<Categoria> updateCategoria (@PathVariable("id") Long idCategoria,@RequestBody Categoria categoria){
		try {
			Categoria categoriaSave = categoriaService.save(categoria);
			return ResponseEntity.created(new URI("/categorias/"+ categoriaSave.getCat_IdCate())).body(categoriaSave);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@ApiOperation(value = "Eliminar Categoria", notes = "Elimina un objeto categoria, recibe el id de la categoria a eliminar\n"
														+ "se retorna la confirmacion de la eliminacion" )
	@DeleteMapping (value = "/categorias/{id}")
	private ResponseEntity<Boolean> deleteCategoria (@PathVariable("id") Long idCategoria){
		categoriaService.deleteById(idCategoria);
		return ResponseEntity.ok(!(categoriaService.findById(idCategoria)!=null));
	}
}
