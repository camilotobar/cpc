import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class grid {

	public static void main(String[] args) throws IOException {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] matriz;
		StringTokenizer stk = new StringTokenizer(in.readLine());
		int rows, cols;
		rows = Integer.parseInt(stk.nextToken());
		cols = Integer.parseInt(stk.nextToken());
		matriz = new int[rows][cols];
		char[] linea;
		for (int i = 0; i < rows; i++) {
			linea = in.readLine().toCharArray();
			for (int j = 0; j < cols; j++) {
				matriz[i][j] = linea[j] - '0';
			}
		}
		int ans = bfs(matriz);
		out.write(((ans == -1)? "IMPOSSIBLE": String.valueOf(ans))+"\n");
		in.close();
		out.close();
	}

	static int bfs(int[][] matriz) {
		int actualI = 0, actualJ = 0;
		Posicion actual;
		int answer = -1;
		boolean[][] visitados = new boolean[matriz.length][matriz[0].length];
		Queue<Posicion> cola = new LinkedList<>();
		cola.add(new Posicion(actualI, actualJ, 0));
		visitados[0][0] = true;
		while (!cola.isEmpty()) {
			actual = cola.poll();
			if(actual.i == matriz.length - 1 && actual.j == matriz[0].length - 1)
				return actual.cont;
			int valor = matriz[actual.i][actual.j];
			if (actual.i - valor >= 0 && !visitados[actual.i - valor][actual.j]) {
				cola.add(new Posicion(actual.i - valor, actual.j, actual.cont + 1));
				visitados[actual.i - valor][actual.j] = true;
			}

			if (actual.j - valor >= 0 && !visitados[actual.i][actual.j - valor]) {
				cola.add(new Posicion(actual.i, actual.j - valor, actual.cont + 1));
				visitados[actual.i][actual.j - valor] = true;
			}

			if (valor + actual.i < matriz.length && !visitados[valor + actual.i][actual.j]) {
				cola.add(new Posicion(valor + actual.i, actual.j, actual.cont + 1));
				visitados[valor + actual.i][actual.j] = true;
			}

			if (valor + actual.j < matriz[0].length && !visitados[actual.i][actual.j + valor]) {
				cola.add(new Posicion(actual.i, actual.j + valor, actual.cont + 1));
				visitados[actual.i][actual.j + valor] = true;
			}
		}
		return answer;
	}

}

class Posicion {
	int i;
	int j;
	int cont;

	public Posicion(int i, int j, int cont) {
		this.i = i;
		this.j = j;
		this.cont = cont;
	}
}