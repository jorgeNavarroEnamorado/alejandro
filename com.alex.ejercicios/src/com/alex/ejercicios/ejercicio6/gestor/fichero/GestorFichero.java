package com.alex.ejercicios.ejercicio6.gestor.fichero;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.alex.ejercicios.ejercicio6.excepciones.GestorFicheroException;
import com.alex.ejercicios.ejercicio6.vo.producto.Producto;

public class GestorFichero {

	File f = null;

	public GestorFichero() {

	}

	public GestorFichero(String nombreFichero) throws GestorFicheroException {
		validarRutaFichero(nombreFichero);
		f = new File(nombreFichero);
	}

	/**
	 * 
	 * Metodo encargado de validar el formato correcto del fichero
	 * 
	 * @param nombreFichero
	 * @throws GestorFicheroException
	 */
	private void validarRutaFichero(String nombreFichero) throws GestorFicheroException {

		if (nombreFichero == null || "".equals(nombreFichero)) {
			throw new GestorFicheroException("Error, indique ruta/nombreFichero");
		} else {
			// Separamos el nombre buscando la extension, como la version se indica con el
			// punto rompemos la cadena con ese caracter
			String[] split = nombreFichero.split("\\.");
			// Obtenemos el valor de la ultima posicion del array
			String extension = split[split.length - 1];

			// Lanzamos excepcion solo cuando la extension sea nula, vacia o no sea del tipo
			// especificado
			if (extension != null && !extension.isEmpty() && !extension.equalsIgnoreCase("dat")) {
				throw new GestorFicheroException("Error, extension del fichero incorrecta");
			}
		}
	}

	/**
	 * 
	 * Metodo encargado de comprobar si existe en el fichero especificado
	 * 
	 * @param nombreFichero
	 * @return
	 */
	public boolean existeFichero() {
		return f.exists();
	}

	/**
	 * 
	 * Metodo encargado de comprobar si existe o no contenido en un fichero
	 * 
	 * @return
	 */
	public boolean ficheroVacio() {
		boolean isVacio = true;

		long longitud = f.length();
		// Comprobamos si la longitud de caracteres del fichero es mayor que ZERO
		if (longitud > 0) {
			isVacio = false;
		}
		return isVacio;
	}

	/**
	 * 
	 * Metodo encargado de crear o borrar el fichero indicado
	 * 
	 * Si crear = true se creara el fichero; Si crear = false se borrar el fichero
	 * 
	 * @param crear
	 * @throws GestorFicheroException
	 */
	public void crearBorrarFichero(boolean crear) throws GestorFicheroException {

		try {
			if (crear == true) {
				// Como es verdadero creamos el fichero
				f.createNewFile();
			} else {
				// Como es falso borramos el fichero
				f.delete();
			}
		} catch (Exception ex) {
			throw new GestorFicheroException(ex);
		}
	}

	public void escribirFichero(HashMap<String, Producto> mapaProductos) throws GestorFicheroException {
		ObjectOutputStream salida = null;
		try {
			salida = new ObjectOutputStream(new FileOutputStream(f));
			salida.writeObject(mapaProductos);
			salida.close();
		} catch (Exception ex) {
			throw new GestorFicheroException(ex);
		} finally {
			try {
				if (salida != null) {
					salida.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public HashMap<String, Producto> leerFichero() throws GestorFicheroException {
		ObjectInputStream entrada = null;
		try {
			entrada = new ObjectInputStream(new FileInputStream(f));
			return (HashMap<String, Producto>) entrada.readObject();
		} catch (Exception ex) {
			throw new GestorFicheroException(ex);
		} finally {
			try {
				if (entrada != null) {
					entrada.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
