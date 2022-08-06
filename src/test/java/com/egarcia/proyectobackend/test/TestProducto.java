package com.egarcia.proyectobackend.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.egarcia.proyectobackend.entity.Categoria;
import com.egarcia.proyectobackend.entity.Producto;
import com.egarcia.proyectobackend.repository.ProductosRepository;
import com.egarcia.proyectobackend.services.CategoriasService;
import com.egarcia.proyectobackend.services.ProductosService;

public class TestProducto {

	@InjectMocks
	ProductosRepository productosRepository;

	@InjectMocks
	Producto producto;

	@Mock
	ProductosService productosService;
	CategoriasService categoriasService;

	private List<Producto> listProductos = new ArrayList<Producto>();
	private List<Producto> listProductos2 = new ArrayList<Producto>();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getAllProductos() {
		when(productosRepository.findAll()).thenReturn(listProductos);
		assertNotNull(productosService.findAll());
	}
	void saveProducto() {
		Producto product = new Producto();
		product.setPro_IdProd((long) 23);
		product.setPro_NomPro("Test Producto");
		product.setPro_DesPro("Descripcion de Test Producto");
		Categoria categoria =  categoriasService.getById((long) 1);
		product.setPro_CatPro(categoria);
		productosService.save(product);
		
		Producto product2 = productosService.getById((long) 23);
		
		when(productosRepository.findAll()).thenReturn(listProductos);
		assertEquals(product,product2);
	}
	void getProductoById() {
		Producto product = new Producto();
		product.setPro_IdProd((long) 23);
		product.setPro_NomPro("Test Producto Busqueda");
		product.setPro_DesPro("Descripcion de Test Producto Busqueda");
		Categoria categoria =  categoriasService.getById((long) 1);
		product.setPro_CatPro(categoria);
		
		Producto product2 = productosService.getById((long) 23);
		
		when(productosRepository.findById((long) 23)).thenReturn(Optional.ofNullable(producto));
		assertEquals(product,product2);
	}

}
