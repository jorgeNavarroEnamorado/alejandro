package com.alex.ejercicios.ejercicio6.vo.producto;

import java.io.Serializable;

public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private String descripcion;
	private String numeroUnidades;

	public Producto() {

	}

	public Producto(String codigo, String nombre, String descripcion, String numeroUnidades) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.numeroUnidades = numeroUnidades;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNumeroUnidades() {
		return numeroUnidades;
	}

	public void setNumeroUnidades(String numeroUnidades) {
		this.numeroUnidades = numeroUnidades;
	}

	/**
	 *
	 * Metodo encargado de devolver toda la informacion de un producto en una cadena
	 * de caracteres
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("-- Informacion Producto --");
		sb.append("\n\t Codigo: " + codigo);
		sb.append("\n\t Nombre: " + nombre);
		sb.append("\n\t Descripcion: " + descripcion);
		sb.append("\n\t Numero de Unidades: " + numeroUnidades);

		return sb.toString();
	}

}
