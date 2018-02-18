import java.io.*;

public class granjaDeComputo {

	static char[] letras;
	static Pila<String> pila;
	static Cola<String> cola;
	static int ultimoTamanho;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		long casos = Long.parseLong(in.readLine());
		String linea = "";
		String[] nums;
		rellenarLetras();

		for (int i = 0; i < casos; i++) {
			linea = in.readLine();
			nums = linea.split(" ");

			pila = new Pila<String>();
			cola = new Cola<String>();
			int cantidadServidores = Integer.parseInt(nums[0]);

			// Ingresa todos los elementos
			for (int k = 0; k < cantidadServidores; k++)
				pila.apilar(letras[k] + "");

			linea = in.readLine();
			String[] ejecuciones = linea.split(" ");

			ultimoTamanho = 0;

			// Ejecuta las tandas de ejecución
			for (String s : ejecuciones) {
				int actualEjecucion = Integer.parseInt(s);
				ejecutar(actualEjecucion);
			}

			// Retorna todos los elementos
			while (!cola.estaVacia())
				pila.apilar(cola.desencolar());

			String[] ans = new String[cantidadServidores];
			for (int j = cantidadServidores - 1; j >= 0; j--)
				ans[j] = pila.desapilar();

			StringBuilder answer = new StringBuilder();
			for (String s : ans)
				answer.append(s + " ");

			out.write(answer.substring(0, answer.length() - 1) + "\n");
		}

		out.close();
		in.close();
	}

	static void ejecutar(int actualEjecucion) {
		int ultimoAux = actualEjecucion;

		if (ultimoTamanho == 0) {
			while (actualEjecucion > 0) {
				cola.encolar(pila.desapilar());
				actualEjecucion--;
			}
		} else {
			int diferencia = actualEjecucion - ultimoTamanho;
			if (diferencia > 0) {
				while (diferencia > 0) {
					cola.encolar(pila.desapilar());
					diferencia--;
				}
			} else if (diferencia < 0) {
				diferencia *= -1;
				while (diferencia > 0) {
					pila.apilar(cola.desencolar());
					diferencia--;
				}
			}
		}

		ultimoTamanho = ultimoAux;
	}

	static void rellenarLetras() {
		letras = new char[26];
		for (int i = 0; i < letras.length; i++) {
			int ascii = i + 65;
			letras[i] = (char) ascii;
		}
		// System.out.println(Arrays.toString(letras));
	}

}

class Cola<T> {

	private Nodo primero;
	private Nodo ultimo;

	public Cola() {

	}

	public void encolar(T item) {
		Nodo nuevo = new Nodo(item);
		if (!estaVacia()) {
			ultimo.setAnterior(nuevo);
			ultimo = nuevo;
		} else {
			primero = nuevo;
			ultimo = nuevo;
		}
	}

	public T desencolar() {
		if (!estaVacia()) {
			Nodo actual = primero;
			primero = primero.getAnterior();
			if (estaVacia())
				ultimo = null;
			return actual.getValor();
		} else
			return null;
	}

	public T consultar() {
		return (!estaVacia()) ? primero.getValor() : null;
	}

	public boolean estaVacia() {
		return (primero == null);
	}

	public Nodo getPrimero() {
		return primero;
	}

	public void setPrimero(Nodo primero) {
		this.primero = primero;
	}

	public Nodo getUltimo() {
		return ultimo;
	}

	public void setUltimo(Nodo ultimo) {
		this.ultimo = ultimo;
	}

	class Nodo {
		private T valor;
		private Nodo anterior;

		public Nodo(T valor) {
			this.valor = valor;
		}

		public Nodo getAnterior() {
			return anterior;
		}

		public void setAnterior(Nodo anterior) {
			this.anterior = anterior;
		}

		public T getValor() {
			return valor;
		}
	}
}

class Pila<T> {

	private Nodo tope;

	public Pila() {

	}

	public void apilar(T item) {
		if (!estaVacia()) {
			Nodo nuevo = new Nodo(item);
			nuevo.setSiguiente(tope);
			tope = nuevo;
		} else
			tope = new Nodo(item);
	}

	public Nodo getTope() {
		return tope;
	}

	public void setTope(Nodo tope) {
		this.tope = tope;
	}

	public T desapilar() {
		if (!estaVacia()) {
			Nodo actual = tope;
			tope = tope.getSiguiente();
			return actual.getValor();
		} else
			return null;
	}

	public T consultar() {
		return (!estaVacia()) ? tope.getValor() : null;
	}

	public boolean estaVacia() {
		return (tope == null);
	}

	class Nodo {
		private T valor;
		private Nodo siguiente;

		public Nodo(T valor) {
			this.valor = valor;
		}

		public Nodo getSiguiente() {
			return siguiente;
		}

		public void setSiguiente(Nodo siguiente) {
			this.siguiente = siguiente;
		}

		public T getValor() {
			return valor;
		}
	}
}
