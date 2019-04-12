package com.alex.ejercicios.ejercicio6.persistencia;

import java.util.HashMap;

import com.alex.ejercicios.ejercicio6.excepciones.ProductoException;
import com.alex.ejercicios.ejercicio6.vo.producto.Producto;

public interface IProductoDao {

	/**
	 * 
	 * Metodo encargado de registar la informacion de un nuevo producto
	 * 
	 * @param codigo
	 * @param nombre
	 * @param descripcion
	 * @param numeroUnidades
	 * @param mapaProducto
	 * @return
	 * @throws ProductoException
	 */
	public void insertarProducto(String codigo, String nombre, String descripcion, String numeroUnidades,
			HashMap<String, Producto> mapaProducto) throws ProductoException;

	/**
	 * 
	 * Metodo encargado de buscar un producto en concreto
	 * 
	 * @param codigo
	 * @param mapaProducto
	 * @return
	 * @throws ProductoException
	 */
	public Producto bucarProducto(String codigo, HashMap<String, Producto> mapaProducto) throws ProductoException;

	/**
	 * 
	 * Elimina el producto con ese codigo
	 * 
	 * @param codigo
	 * @param mapaProducto
	 * @throws ProductoException
	 */
	public void eliminarProducto(String codigo, HashMap<String, Producto> mapaProducto) throws ProductoException;

	/**
	 * 
	 * Modifica el numero de unidades del producto seleccionado
	 * 
	 * @param producto
	 * @param unidadesNuevas
	 */
	public void modificarUnidadesProducto(Producto producto, String unidadesNuevas);

}
