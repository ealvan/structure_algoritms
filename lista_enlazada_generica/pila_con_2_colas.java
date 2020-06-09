package lista_enlazada_generica;

public class pila_con_2_colas<T> {
	
	Cola<T> cola_left = new Cola<T>( );
	Cola<T> cola_right = new Cola<T>( );
	
	 
	public T pop(){
		if(cola_left.cabeza == null){
			return null; //esta vacia
		}else{
			return (T)cola_left.eliminar().elemento;
		}
	}
	public void push(T elemento){
		if(cola_left.cabeza == null){
			cola_left.encolar(elemento);
		}else{
			for(int i = cola_left.longitud; i > 0; i--){
				cola_right.encolar((T)cola_left.eliminar().elemento);
			}
			cola_left.encolar(elemento);
			for(int i = cola_right.longitud; i > 0; i--){
				cola_left.encolar((T)cola_right.eliminar().elemento);
			}
		}
	}
	public String mostrar(){
		//String str = "";
		return cola_left.mostrar();
	}
	 
	public static void main(String[] args) {
		pila_con_2_colas<String> pila = new pila_con_2_colas<String>();
		pila.push("c");
		pila.push("c1");
		pila.push("c2");
		pila.push("c3");
		pila.push("c4");
		pila.push("c5");
		System.out.print(pila.mostrar());
	}

}
