package com.egarcia.proyectobackend.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.egarcia.proyectobackend.entity.Producto;

import io.swagger.annotations.ApiOperation;

@FeignClient(name="ventas", url="localhost:8080/api/v2")
public interface VentasRepository {
	
	@ApiOperation(value = "Obtener Productos", notes = "Obtener lista de productos disponibles\n"
			+"No es necesario enviar algun parametro\n"
			+"regresa una lista con todos los campos\n "
			+ "disponibles para la producto")
	
	@RequestMapping(method = RequestMethod.GET, value = "/productos")
    List<Producto> getAll();
}
