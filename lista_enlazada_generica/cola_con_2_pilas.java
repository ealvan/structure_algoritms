package lista_enlazada_generica;

public class cola_con_2_pilas<T> {
	Nodo cabeza;
	Pila<T> pila_left = new Pila<T>();
	Pila<T> pila_right = new Pila<T>();
	int longitud = 0;
	public cola_con_2_pilas(Nodo cabeza) {
		this.cabeza = cabeza;
		pila_left.push((T)cabeza.elemento);
		longitud++;
	}
	public void encolar(T elemento){
		//Nodo nuevo = new Nodo(elemento);
		pila_left.push(elemento);
		longitud++;	
		/*
		if(pila_left.cabeza == null ){
			pila_left.cabeza = nuevo;
		}else{
			pila_left.push(elemento);
		}
		 * */
	}
	public T eliminar_dequeu(){
		this.longitud--;
		if( pila_right.cabeza == null ){
			Pila.voltear_pila(pila_left, pila_right);
			if(pila_right.cabeza != null){
				return (T)pila_right.pop().elemento;
			}else{
				return null;
			}
		}else{
			return (T)pila_right.pop().elemento;
		}
	}
	
	public 	String mostrar(){
		Pila.voltear_pila(pila_left, pila_right);
		if(pila_right.cabeza == null){
			return "esta_vacia";
		}
		return pila_right.mostrar();
	}
	public static void main(String[] args) {
	/*
	 * 	Pila<String> pila_left = new Pila<String>(new Nodo("cabeza"));
		pila_left.push("c1");
		pila_left.push("c2");
		System.out.print(pila_left.mostrar());
		
		Pila<String> pila_right = new Pila<String>();
		
		cola_con_2_pilas.voltear_pila(pila_left, pila_right);
		cola_con_2_pilas.voltear_pila(pila_left, pila_right);
		cola_con_2_pilas.voltear_pila(pila_left, pila_right);
		System.out.println("Longitud: "+pila_left.longitud);
		System.out.print(pila_right.mostrar());
	 * */
		cola_con_2_pilas<String> cola = new cola_con_2_pilas<String>(new Nodo("cabeza"));
		cola.encolar("raton y cola");
		cola.encolar("serpiente y cola");
		cola.encolar("aguila y mandragora");
		System.out.print(cola.pila_left.mostrar());
		System.out.print(cola.mostrar());
		System.out.println("Eliminado: " + cola.eliminar_dequeu());
		System.out.print(cola.mostrar());
		System.out.println("Eliminado: " + cola.eliminar_dequeu());
		System.out.print(cola.mostrar());
		System.out.println("Eliminado: " + cola.eliminar_dequeu());
		System.out.print(cola.mostrar());
		System.out.println("Eliminado: " + cola.eliminar_dequeu());
		System.out.print(cola.mostrar());
		
		///este ya se desbordo 
		System.out.println("Eliminado: " + cola.eliminar_dequeu());
		System.out.print(cola.mostrar());
		//System.out.print(cola.pila_right.mostrar());
	}
}
