package com.alex.ejercicios.ejercicio6.persistencia;

import java.util.HashMap;

import com.alex.ejercicios.ejercicio6.excepciones.ProductoException;
import com.alex.ejercicios.ejercicio6.vo.producto.Producto;

public class ProductoDao implements IProductoDao {

	@Override
	public void insertarProducto(String codigo, String nombre, String descripcion, String numeroUnidades,
			HashMap<String, Producto> mapaProducto) throws ProductoException {

		try {
			if (this.bucarProducto(codigo, mapaProducto) != null) {
				throw new ProductoException("El producto ya existe");
			}
		} catch (ProductoException ex) {
			Producto producto = new Producto(codigo, nombre, descripcion, numeroUnidades);
			mapaProducto.put(codigo, producto);
		}

	}

	@Override
	public Producto bucarProducto(String codigo, HashMap<String, Producto> mapaProducto) throws ProductoException {
		Producto producto = mapaProducto.get(codigo);
		if (producto == null) {
			throw new ProductoException("Producto no encontrado");
		} else {
			return producto;
		}
	}

	@Override
	public void eliminarProducto(String codigo, HashMap<String, Producto> mapaProducto) throws ProductoException {
		bucarProducto(codigo, mapaProducto);
		mapaProducto.remove(codigo);
	}

	@Override
	public void modificarUnidadesProducto(Producto producto, String unidadesNuevas) {
		producto.setNumeroUnidades(unidadesNuevas);

	}

}
