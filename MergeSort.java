import java.util.Arrays;
import java.util.Random;

public class MergeSort {

	public static void main(String[] args) {
		Random r = new Random();

		int[] array = new int[Integer.parseInt(args[0])];
		for (int j = 0; j < array.length; j++)
			array[j] = r.nextInt(800);

		System.out.println("Tamaño: " + array.length + "\nArreglo antes de ordenarse\n" + Arrays.toString(array)
				+ "\nArreglo despues de ordenarse");

		mergeSort(array);
		System.out.println(Arrays.toString(array));
	}

	static void mergeSort(int[] array) {
		merge(array, 0, array.length);
	}

	static void merge(int[] array, int startIndex, int endIndex) {
		if (startIndex < endIndex - 1) {
			int middle = (startIndex + endIndex) / 2;
			int dif = endIndex - startIndex;

			merge(array, startIndex, middle);
			merge(array, middle, endIndex);

			int[] aux = new int[dif];
			for (int i = startIndex, j = middle, k = 0; k < dif; k++)
				if (i == middle)
					aux[k] = array[j++];
				else if (j == endIndex)
					aux[k] = array[i++];
				else if (array[j] < (array[i]))
					aux[k] = array[j++];
				else
					aux[k] = array[i++];

			for (int k = 0; k < dif; k++)
				array[startIndex + k] = aux[k];
		}
	}
}
