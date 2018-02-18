import java.util.Arrays;
import java.util.Random;

public class SumaDeMatrices {

	public SumaDeMatrices() {

	}

	public static void main(String[] args) {
		Random rdm = new Random();
		int length = (int) Math.pow(2, rdm.nextInt(6) + 1);

		int[][] matrizA = new int[length][length];
		int[][] matrizB = new int[length][length];

		for (int i = 0; i < matrizA.length; i++)
			for (int j = 0; j < matrizA[0].length; j++) {
				matrizA[i][j] = rdm.nextInt(10);
				matrizB[i][j] = rdm.nextInt(10);
			}

		System.out.println("\nMatriz A");
		for (int i = 0; i < matrizA[0].length; i++)
			System.out.println(Arrays.toString(matrizA[i]));

		System.out.println("\nMatriz B");
		for (int i = 0; i < matrizB[0].length; i++)
			System.out.println(Arrays.toString(matrizB[i]));

		int[][] answer = sumar(matrizA, matrizB);

		System.out.println("\nSuma de Matrices");
		for (int i = 0; i < answer[0].length; i++)
			System.out.println(Arrays.toString(answer[i]));
	}

	/**
	 * Suma de las matrices A y B de orden 2
	 * 
	 * <pre>
	 *  Matrices inicializadas y de igual tamaño
	 * </pre>
	 * 
	 * @param matrizA
	 *            Primera matriz para adicionar
	 * @param matrizB
	 *            Segundo matriz para adicionar
	 * @return Matriz resultado de la suma de ambas matrices <post> Matriz
	 *         resultado de la suma de ambas </post>
	 */
	static int[][] sumar(int[][] matrizA, int[][] matrizB) {
		int[][] answer = new int[matrizA.length][matrizA[0].length];
		sumaMatrices(answer, matrizA, matrizB, 0, 0, matrizA.length - 1, matrizA[0].length - 1);
		return answer;
	}

	static void sumaMatrices(int[][] answer, int[][] matrizA, int[][] matrizB, int topRow, int leftColumn,
			int bottomRow, int rigthColumn) {
		
		//Caso Base y combinación
		if (topRow == bottomRow && leftColumn == rigthColumn)
			answer[topRow][leftColumn] = matrizA[topRow][leftColumn] + matrizB[topRow][leftColumn];
		else {
			int middleRow = (bottomRow - topRow) / 2;
			int middleColumn = (rigthColumn - leftColumn) / 2;

			//Dividir
			
			// Up-Left
			sumaMatrices(answer, matrizA, matrizB, topRow, leftColumn, topRow + middleRow, leftColumn + middleColumn);

			// Up-Right
			sumaMatrices(answer, matrizA, matrizB, topRow, leftColumn + middleColumn + 1, topRow + middleRow,
					rigthColumn);

			// Down-Left
			sumaMatrices(answer, matrizA, matrizB, topRow + middleRow + 1, leftColumn, bottomRow,
					leftColumn + middleColumn);

			// Down-Rigth
			sumaMatrices(answer, matrizA, matrizB, topRow + middleRow + 1, leftColumn + middleColumn + 1, bottomRow,
					rigthColumn);
		}
	}

}
