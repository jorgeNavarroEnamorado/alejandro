package com.alex.ejercicios.ejercicio6.vo;

import java.util.HashMap;
import java.util.Map;

public enum EnumMenu {

	UNO("1", "Buscar producto"), DOS("2", "Buscar todos los producto"), TRES("3", "Agregar producto"),
	CUATRO("4","Modificar unidades producto"), CINCO("5","Borrar producto"), 
	SEIS("6", "Borrar todo"), SIETE("7", "Salir");

	private String codigo;
	private String descripcion;
	private static Map<String, EnumMenu> menu = null;

	static {
		menu = new HashMap<String, EnumMenu>();
		menu.put(UNO.getCodigo(), UNO);
		menu.put(DOS.getCodigo(), DOS);
		menu.put(TRES.getCodigo(), TRES);
		menu.put(CUATRO.getCodigo(), CUATRO);
		menu.put(CINCO.getCodigo(), CINCO);
		menu.put(SEIS.getCodigo(), SEIS);
		menu.put(SIETE.getCodigo(), SIETE);
	}

	EnumMenu(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public static EnumMenu getInstance(String codigo) {
		EnumMenu enumMenu = menu.get(codigo);
		return enumMenu;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
