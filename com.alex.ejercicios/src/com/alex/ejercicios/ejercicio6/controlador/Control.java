package com.alex.ejercicios.ejercicio6.controlador;

import java.util.HashMap;
import java.util.Scanner;

import com.alex.ejercicios.ejercicio6.excepciones.GestorFicheroException;
import com.alex.ejercicios.ejercicio6.excepciones.ProductoException;
import com.alex.ejercicios.ejercicio6.gestor.fichero.GestorFichero;
import com.alex.ejercicios.ejercicio6.persistencia.ProductoDao;
import com.alex.ejercicios.ejercicio6.vo.EnumMenu;
import com.alex.ejercicios.ejercicio6.vo.producto.Producto;

public class Control implements IControler {

	Scanner sc = null;
	GestorFichero gestorFichero = null;
	HashMap<String, Producto> mapaProductos = null;
	ProductoDao productoDao = null;

	public Control() {

	}

	public Control(String nombreFichero) throws Exception {
		gestorFichero = new GestorFichero(nombreFichero);
		sc = new Scanner(System.in);
		productoDao = new ProductoDao();
		init();
		body();
		gestorFichero.escribirFichero(mapaProductos);
	}

	public void init() throws GestorFicheroException {

		// Comprobamos si existe el fichero serializado
		boolean existeFichero = gestorFichero.existeFichero();

		if (existeFichero) {
			// Como existe fichero comprobamos si esta vacio para no tener que leerlo
			if (!gestorFichero.ficheroVacio()) {
				// En este caso como no es vacio leemos el contenido del fichero
				mapaProductos = gestorFichero.leerFichero();

			} else {
				// En este caso como es vacio iniciamos vacio el mapa de productos
				mapaProductos = new HashMap<String, Producto>();
			}
		} else {
			// Como no existe, creamos el fichero
			gestorFichero.crearBorrarFichero(true);
			mapaProductos = new HashMap<String, Producto>();
		}
	}

	public void body() {

		boolean continuar = true;
		int numeroErresMenu = 0;

		while (continuar && numeroErresMenu < 3) {
			try {

				System.out.println("Menu App");
				for (EnumMenu opcionesMenu : EnumMenu.values()) {
					System.out.println(opcionesMenu.getCodigo() + " - " + opcionesMenu.getDescripcion());
				}

				EnumMenu opcion = this.seleccionMenu();
				if (opcion == null) {
					numeroErresMenu++;
				} else if (opcion == EnumMenu.SIETE) {
					continuar = false;
				} else if (opcion == EnumMenu.SEIS) {
					mapaProductos = null;
					gestorFichero.crearBorrarFichero(false);
					continuar = false;
				} else {
					numeroErresMenu = 0;
					semaforo(opcion.getCodigo());
				}
			} catch (ProductoException ex) {
				ex.printStackTrace();
			} catch (GestorFicheroException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * Metodo encargado de dirigir a la petcion que el usuario a seleccionado
	 * 
	 * @param opcion
	 * @throws ProductoException
	 */
	public void semaforo(String opcion) throws ProductoException {

		int opcionInteger = Integer.parseInt(opcion);

		String codigo, nombre, descripcion, numeroUnidades;

		switch (opcionInteger) {
		case 1:
			// Opcion que sirve para buscar producto
			System.out.print("Inserte el codigo del producto a buscar: ");
			codigo = sc.nextLine();
			System.out.println(productoDao.bucarProducto(codigo, mapaProductos).toString());

			break;
		case 2:
			// Opcion que sirve para buscar todos los productos
			for (Producto producto : mapaProductos.values()) {
				System.out.println(producto.toString());
			}
			break;
		case 3:
			// Opcion que sirve para agregar un nuevo producto al inventario
			System.out.print("Inserte el codigo del producto: ");
			codigo = sc.nextLine();
			System.out.print("Inserte el nombre del producto: ");
			nombre = sc.nextLine();
			System.out.print("Inserte la descripcion del producto: ");
			descripcion = sc.nextLine();
			System.out.print("Inserte el numero de unidades del producto: ");
			numeroUnidades = sc.nextLine();
			productoDao.insertarProducto(codigo, nombre, descripcion, numeroUnidades, mapaProductos);
			System.out.println(mapaProductos.get(codigo));
			break;
		case 4:
			// Modificamos las unidades del producto seleccionado
			System.out.print("Inserte el codigo del producto a modificar unidades: ");
			codigo = sc.nextLine();
			Producto producto = productoDao.bucarProducto(codigo, mapaProductos);
			System.out.print("Inserte el numero de unidades del producto a modificar: ");
			numeroUnidades = sc.nextLine();
			productoDao.modificarUnidadesProducto(producto, numeroUnidades);
			mapaProductos.put(codigo, producto);
			System.out.println("Unidades modificadas");
			System.out.println(producto.toString());
			break;
		case 5:
			// Borramos un producto
			System.out.print("Inserte el codigo del producto a borrar: ");
			codigo = sc.nextLine();
			productoDao.eliminarProducto(codigo, mapaProductos);
			System.out.println("Producto borrado");
			break;
		default:
			break;
		}
	}

	private EnumMenu seleccionMenu() {
		System.out.print("Seleccione una opcion de menu");
		String codigo = sc.nextLine();
		return EnumMenu.getInstance(codigo);
	}

}
