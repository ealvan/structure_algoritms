package lista_enlazada_generica;

public class Pila<T> extends Lista  {

	//nodo cabeza
	int longitud = 0;
	int cantidad = Integer.MAX_VALUE;
	public Pila(Nodo cabeza) {
		super(cabeza);
		this.longitud++;
	}
	public Pila(){super();}
	
	public Pila(Nodo cabeza, int cant){
		super(cabeza);
		this.cantidad = cant;
		this.longitud++;
	}
	public void push( T elemento){
		if( longitud < cantidad){
			Nodo nuevo = new Nodo(elemento);
			if(cabeza == null){
				cabeza = nuevo;
			}else{
				nuevo.siguiente = cabeza;
				cabeza = nuevo;
			}
			this.longitud++;
		}else{
			//System.err.print("No se pudo :(");
		}
	}
	public Nodo pop(){
		if(cabeza == null){
			//System.out.println("No se pudo :(");//esto hace que no se pueda accededer
			//asi que lo comente
			return null;
		}else{
			Nodo temp = cabeza;
			cabeza = cabeza.siguiente;
			temp.siguiente = null;
			return  temp ;
		}
	}
	public String mostrar(){
		String str = "";
		int i = 0;
		for(Nodo puntero = cabeza; puntero != null;puntero = puntero.siguiente ){
			str += "Item " +i+ " ==> "+puntero.elemento.toString()+" ";
			i++;
		}
		str+="\n";
		return str;
	}
	public static void voltear_pila(Pila izq, Pila dere){
		int cantidad = izq.longitud;
		for(int i = 0; i < cantidad; i++){
			if(izq.cabeza!=null){
				Nodo transporte =  izq.pop();
				dere.push(transporte.elemento);
			}
			
		}
 
		/*
		 * if(izq.cabeza != null){
			
		}else{
			System.err.print("hubo un error");
		}
		 * */
	}
	public static void main(String[] args) {
		 Pila<String> pila = new Pila<String>(new Nodo("cabeza"));
		 pila.push("c1");
		 pila.push("c2");
		 pila.push("c3");
		 pila.push("c4");
		 pila.push("c5");
		 System.out.print(pila.mostrar());
		 Pila<String> pila_statica = new Pila<String>(new Nodo("c"),10);
		 pila_statica.push("c1");
		 pila_statica.push("c2");
		 pila_statica.push("c3");
		 pila_statica.push("c4");
		 pila_statica.push("c5");
		 pila_statica.push("c6");
		 pila_statica.push("c7");
		 pila_statica.push("c8");
		 pila_statica.push("c9");
		 pila_statica.push("ccc___ccc");
		 System.out.print(pila_statica.mostrar());
		 System.out.println("longitud : "+ pila_statica.longitud);
		 
	}
}
