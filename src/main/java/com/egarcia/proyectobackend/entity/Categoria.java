package com.egarcia.proyectobackend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/*
@Getter
@Setter*/
@ApiModel(description = "Categorias de productos")
@Entity
@Table (name = "PBCATEGO")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false, unique = true)
	private Long Cat_IdCate;
	
	@ApiModelProperty(value = "Nombre de Categoria")
	private String Cat_NomCat;
	
	private String Cat_DesCat;
	//Valores de control
	private String NumTransac;
	private String Transaccio;
	private String Usuario;
	private Date FechaSis;
	private String SucOrigen;
	private String SucDestino;
	public Long getCat_IdCate() {
		return Cat_IdCate;
	}
	public String getCat_NomCat() {
		return Cat_NomCat;
	}
	public void setCat_NomCat(String cat_NomCat) {
		Cat_NomCat = cat_NomCat;
	}
	public String getCat_DesCat() {
		return Cat_DesCat;
	}
	public void setCat_DesCat(String cat_DesCat) {
		Cat_DesCat = cat_DesCat;
	}
	public String getNumTransac() {
		return NumTransac;
	}
	public void setNumTransac(String numTransac) {
		NumTransac = numTransac;
	}
	public String getTransaccio() {
		return Transaccio;
	}
	public void setTransaccio(String transaccio) {
		Transaccio = transaccio;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public Date getFechaSis() {
		return FechaSis;
	}
	public void setFechaSis(Date fechaSis) {
		FechaSis = fechaSis;
	}
	public String getSucOrigen() {
		return SucOrigen;
	}
	public void setSucOrigen(String sucOrigen) {
		SucOrigen = sucOrigen;
	}
	public String getSucDestino() {
		return SucDestino;
	}
	public void setSucDestino(String sucDestino) {
		SucDestino = sucDestino;
	}
	public void setCat_IdCate(Long cat_IdCate) {
		Cat_IdCate = cat_IdCate;
	}
	
	
	
}
