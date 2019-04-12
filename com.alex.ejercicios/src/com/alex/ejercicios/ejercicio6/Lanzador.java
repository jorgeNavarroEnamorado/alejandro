package com.alex.ejercicios.ejercicio6;

import com.alex.ejercicios.ejercicio6.controlador.Control;

public class Lanzador {

	public static void main(String[] args) {
		try {
			new Control("C:\\temp\\productos.dat");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
