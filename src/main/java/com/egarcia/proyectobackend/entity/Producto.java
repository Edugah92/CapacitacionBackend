package com.egarcia.proyectobackend.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "PBPRODUC")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Pro_IdProd;
	private String Pro_NomPro;
	private String Pro_DesPro;
	@ManyToOne
	@JoinColumn (name = "Cat_IdCate")
	private Categoria Pro_CatPro;
	private Float Pro_PrCoPr;
	private Float Pro_PrVePr;
	//Valores de control
	private String NumTransac;
	private String Transaccio;
	private String Usuario;
	private Date FechaSis;
	private String SucOrigen;
	private String SucDestino;
	public Long getPro_IdProd() {
		return Pro_IdProd;
	}
	public void setPro_IdProd(Long pro_IdProd) {
		Pro_IdProd = pro_IdProd;
	}
	public String getPro_NomPro() {
		return Pro_NomPro;
	}
	public void setPro_NomPro(String pro_NomPro) {
		Pro_NomPro = pro_NomPro;
	}
	public String getPro_DesPro() {
		return Pro_DesPro;
	}
	public void setPro_DesPro(String pro_DesPro) {
		Pro_DesPro = pro_DesPro;
	}
	public Categoria getPro_CatPro() {
		return Pro_CatPro;
	}
	public void setPro_CatPro(Categoria pro_CatPro) {
		Pro_CatPro = pro_CatPro;
	}
	public Float getPro_PrCoPr() {
		return Pro_PrCoPr;
	}
	public void setPro_PrCoPr(Float pro_PrCoPr) {
		Pro_PrCoPr = pro_PrCoPr;
	}
	public Float getPro_PrVePr() {
		return Pro_PrVePr;
	}
	public void setPro_PrVePr(Float pro_PrVePr) {
		Pro_PrVePr = pro_PrVePr;
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
	
	
	
	
}
