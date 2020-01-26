/**
 * 
 */

class Lista{
	
	/**
	 * Inicializamos la clase Lista
	 * _tamMax --> elementos maximos que almacenara la lista
	 */
	constructor(_tamMax){
		this._tamMax = _tamMax;
		this._array = new Array();
	}
	
	/**
	 * Comprobamos si la lista esta vacia
	 */
	estaVacia(){
		var empty = false;
		if (this._array != null && this.tam() == 0) {
		    empty = true;
		}
		return empty;
	}
	
	/**
	 * Comprobamos si la lista esta completa
	 */
	estaCompleta(){
		var full = false;
		if (this._array != null && this.tam() == this._tamMax) {
			full = true;
		}
		return full;
	}
	
	/**
	 * Obtenemos el numero de elementos almacenados en la lista
	 */
	tam(){
		var cont = 0;
		if (this._array != null){			
			this._array.forEach(element => cont++);
		}
		return cont;
	}
	
	/**
	 * Obtenemos el numero de elementos maximos que podemos almacenar
	 */
	capacidad(){
		return this._tamMax;
	}
	
	/**
	 * Comprobamos cuantas posiciones nos quedan libres en la lista
	 */
	disponible(){
		return this._tamMax - this._array.length;
	}
	
	/**
	 * Agregamos un elemento a lita siempre que esta no este completa
	 * return numero elementos libres
	 */
	insertar(elem){
		
		// comprobamos si la lista esta llena
		if (this.estaCompleta()){
			throw "No se puede agregar ningun elemento a la lista, porque esta completa";
		}else{
			this._array.push(elem);
			return this.disponible();
		}
		
	}
	
	/**
	 * Insertamos un elemento en una posicion en concreto siempre que
	 * siempre que la lista no este completa y el indice este comprendido
	 * entre las posiciones validas de la lista
	 * 
	 * return numero elementos libres
	 */
	insertarElem (elem,index){
		
		// comprobamos si la lista esta llena
		if (this.estaCompleta()){
			throw "No se puede agregar ningun elemento a la lista, porque esta completa";
		}else{
			if (index => 0 && index <= this.capacidad()-1){
				// agregamos el elemento en la posicion indicada
				this._array.splice(index, 0,elem);
				return this.disponible();
			}else{
				// indicamos que se ha indicado una posicion que supera el numero la ultima posicion valida
				throw "No puede agregar el elemento en una posicion que exceda el limite de la lista";
			}
		}
		
	}
	
	/**
	 * Obtenemos el elemento de la posicion indicada
	 * siempre y cuando el indice este comprendido
	 * entre las posiciones validas de la lista
	 * 
	 * return elemento
	 */
	obtenerElem(index){
	
		if (index => 0 && index <= this.capacidad()-1){
			var elem = this._array[index];
			if (typeof elem == 'undefined') {
				throw "No hay datos para la posicion "+index+" que ha seleccionado";
			}else{
				return elem;
			}
		}else{
			// indicamos que se ha indicado una posicion que supera el numero la ultima posicion valida
			throw "No puede agregar el elemento en una posicion que exceda el limite de la lista";
		}
		
	}
	
	/**
	 * Eliminamos un elemento de la lista indicado por la posicion
	 * simpre que la lista no este vacia y 
	 * el indice este comprendido
	 * entre las posiciones validas de la lista
	 * 
	 * return elemento
	 */
	borrar(index){
		
		var element = "";
		if (this.estaVacia()){
			throw "La lista esta vacio, no se puede borrar ningun elemento";
		}else{
			if (index => 0 && index <= this.capacidad()-1){
				element = this.obtenerElem(index)
				this._array.splice(index, 1);
			}else{
				throw "la posicion seleccionada es incorrecta";
			}
		}
		return element;
	}
	
	/**
	 * Eliminamos un elemento de la lista 
	 * siempre que la lista no este vacia
	 * y dicho elemento indicado por parametro este registrado en la lista
	 * 
	 * return eliminado true/false
	 */
	borrarElemen(elem){
		
		var isDelete = false;
		if (this.estaVacia()){
			throw "La lista esta vacio, no se puede borrar ningun elemento";
		}else{
			var index = this.obtenerElem(elem);
			if (typeof index != 'undefined'){					
				this._array.splice(index, 1);
				isDelete = true;
			}
		}
		return isDelete;
		
	}
}