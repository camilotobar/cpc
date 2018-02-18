import java.io.*;
import java.util.*;

public class MedianasAlgoDos {

	public static void main(String[] args) throws IOException {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		Random rdm = new Random();

		int tam = rdm.nextInt(50) + 2;
		int[] array1 = new int[tam];
		int[] array2 = new int[tam];
		int[] array3 = new int[tam * 2];

		for (int i = 0; i < array1.length; i++) {
			array1[i] = rdm.nextInt(50) + 1;
			array2[i] = rdm.nextInt(50) + 1;
		}

		for (int i = 0, j = 0; i < array1.length + 1 && j <= 1; i++)
			if (i == array1.length) {
				j++;
				i = -1;
			} else if (j == 0)
				array3[i] = array1[i];
			else
				array3[i + array1.length] = array2[i];

		Arrays.sort(array1);
		Arrays.sort(array2);
		Arrays.sort(array3);

		out.write("Arreglo 1:\n" + Arrays.toString(array1) + "\nArreglo 2:\n" + Arrays.toString(array2)
				+ "\nArreglo combinado:\n" + Arrays.toString(array3) + "\n\nMediana método:\n"
				+ getMedian(array1, array2, tam) + "\nMediana arreglo combinado:\n" + median(array3, tam * 2) + "\n");
		out.close();
	}

	static int getMedian(int array1[], int array2[], int n) {

		if (n == 1)
			return (array1[0] + array2[0]) / 2;
		if (n == 2)
			return (Math.max(array1[0], array2[0]) + Math.min(array1[1], array2[1])) / 2;

		int median1 = median(array1, n);
		int median2 = median(array2, n);

		if (median1 == median2)
			return median1;
		else if (median1 < median2)
			return getMedian(Arrays.copyOfRange(array1, (n % 2 == 0) ? (n / 2) - 1 : n / 2, n),
					Arrays.copyOfRange(array2, 0, (n / 2) + 1), (n / 2) + 1);
		else
			return getMedian(Arrays.copyOfRange(array2, (n % 2 == 0) ? (n / 2) - 1 : n / 2, n),
					Arrays.copyOfRange(array1, 0, (n / 2) + 1), (n / 2) + 1);
	}

	static int median(int array[], int n) {
		return (n % 2 == 0) ? (array[n / 2] + array[n / 2 - 1]) / 2 : array[n / 2];
	}
}
