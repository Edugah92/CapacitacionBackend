package com.egarcia.proyectobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egarcia.proyectobackend.entity.Categoria;

@Repository
public interface CategoriasRepository extends JpaRepository<Categoria, Long> {

}
