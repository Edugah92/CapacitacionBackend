package com.egarcia.proyectobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egarcia.proyectobackend.entity.Producto;

@Repository
public interface ProductosRepository extends JpaRepository<Producto, Long> {

}
