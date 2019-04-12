package com.alex.ejercicios.ejercicio6.controlador;

import com.alex.ejercicios.ejercicio6.excepciones.GestorFicheroException;

public interface IControler {

	/**
	 * 
	 * Metodo encargado de cargar y establecer los parametros iniciales que permita
	 * la correcta ejecucion de la aplicacion (inventario de productos)
	 * 
	 * @throws GestorFicheroException
	 * 
	 */
	public void init() throws GestorFicheroException;

	/**
	 * 
	 * Metodo que contine la logica de desarrollo de la aplicacion
	 * 
	 */
	public void body();
}
