package com.alex.ejercicios.ejercicio6.excepciones;

public class ProductoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductoException() {
		super();
	}

	public ProductoException(String arg0) {
		super(arg0);
	}

	public ProductoException(Throwable t) {
		super(t);
	}

	public ProductoException(String arg0, Throwable t) {
		super(arg0, t);
	}
}
