import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class blur {

	public static void main(String[] args) throws IOException {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(in.readLine());

		int cols = Integer.parseInt(stk.nextToken());
		int rows = Integer.parseInt(stk.nextToken());
		int times = Integer.parseInt(stk.nextToken());

		int[][] imagen = new int[rows][cols];

		StringTokenizer st;

		for (int i = 0; i < rows; i++) {
			st = new StringTokenizer(in.readLine());

			for (int j = 0; j < cols; j++)
				imagen[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < times; i++) {
			int[][] exImagen = expand(imagen);
			int[][] parcial = blurr(exImagen);
			imagen = parcial;
		}
		
		//System.out.println(Arrays.deepToString(imagen));

		int cont = 0;
		boolean[] repetidos = new boolean[((int) Math.pow(9, times))+1];
		for (int i = 0; i < imagen.length; i++)
			for (int j = 0; j < imagen[0].length; j++)
				if (!repetidos[imagen[i][j]]) {
					cont++;
					repetidos[imagen[i][j]] = true;
				}
		out.write(cont + "\n");
		in.close();
		out.close();
	}

	static int[][] blurr(int[][] exImagen) {
		int[][] parcial = new int[exImagen.length - 2][exImagen[0].length - 2];
		for (int i = 0; i < parcial.length; i++)
			for (int j = 0; j < parcial[0].length; j++)
				parcial[i][j] = contador(exImagen, i+1, j+1);
		return parcial;
	}

	static int contador(int[][] exImagen, int i, int j) {
		int contador = 0;
		for (int k = i - 1; k < i + 2; k++)
			for (int l = j - 1; l < j + 2; l++)
				contador += exImagen[k][l];

		return contador;
	}

	static int[][] expand(int[][] image) {

		int rows = image.length;
		int cols = image[0].length;

		int[][] exImage = new int[rows + 2][cols + 2];

		for (int i = 1; i < exImage.length - 1; i++)
			for (int j = 1; j < exImage[0].length - 1; j++)
				exImage[i][j] = image[i - 1][j - 1];

		rows += 2;
		cols += 2;

		exImage[0] = exImage[rows - 2].clone();
		exImage[rows - 1] = exImage[1].clone();

		for (int i = 0; i < exImage.length; i++) {

			exImage[i][0] = exImage[i][cols - 2];
			exImage[i][cols - 1] = exImage[i][1];
		}

		// Superior Izq
		exImage[0][0] = exImage[rows - 2][cols - 2];

		// Sup Der
		exImage[0][cols - 1] = exImage[rows - 2][1];

		// Inferior Izq
		exImage[rows - 1][0] = exImage[1][cols - 2];

		// Inferior Der
		exImage[rows - 1][cols - 1] = exImage[1][1];

		return exImage;
	}

}
