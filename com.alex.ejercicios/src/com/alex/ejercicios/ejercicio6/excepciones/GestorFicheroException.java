package com.alex.ejercicios.ejercicio6.excepciones;

public class GestorFicheroException extends Exception {

	private static final long serialVersionUID = 1L;

	public GestorFicheroException() {
		super();
	}

	public GestorFicheroException(String arg0) {
		super(arg0);
	}

	public GestorFicheroException(Throwable t) {
		super(t);
	}

	public GestorFicheroException(String arg0, Throwable t) {
		super(arg0, t);
	}

}
