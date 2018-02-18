import java.io.*;
import java.util.*;

public class rockabye {

	public static void main(String[] args) throws IOException, CloneNotSupportedException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String[] arreglo = br.readLine().split(" ");
			int medicamentos = Integer.parseInt(arreglo[0]);
			int cantidad = Integer.parseInt(arreglo[1]);

			PriorityQueue<Medicamento> cola = new PriorityQueue<Medicamento>();

			for (int j = 0; j < medicamentos; j++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				String nombre = stk.nextToken();
				int frecuencia = Integer.parseInt(stk.nextToken());
				Medicamento nuevo = new Medicamento(nombre, (j + 1), frecuencia, frecuencia);
				cola.add(nuevo);
			}

			while (cantidad > 0) {
				Medicamento actual = cola.poll();
				bw.write(actual.proximaToma + " " + actual.nombre + "\n");
				Medicamento nuevo = new Medicamento(actual.nombre, actual.prioridad, actual.frecuencia,
						(actual.proximaToma + actual.frecuencia));
				cola.add(nuevo);
				cantidad--;
			}
		}

		br.close();
		bw.close();

	}

}

class Medicamento implements Comparable<Medicamento> {
	String nombre;
	int prioridad;
	int frecuencia;
	int proximaToma;

	public Medicamento(String nombre, int prioridad, int frecuencia, int proximaToma) {
		this.nombre = nombre;
		this.prioridad = prioridad;
		this.frecuencia = frecuencia;
		this.proximaToma = proximaToma;
	}

	@Override
	public int compareTo(Medicamento med2) {
		int dif = proximaToma - med2.proximaToma;
		if (dif != 0)
			return dif;
		return prioridad - med2.prioridad;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
