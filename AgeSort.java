import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AgeSort {

	static int[] edades;
	static int[] temp;
	static String[] nums;
	static int casos;

	public static void main(String[] args) throws IOException {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String linea = in.readLine();
		String ans = "";
		casos = 0;
		while (!linea.equals("0")) {
			casos = Integer.parseInt(linea);
			nums = in.readLine().split(" ");
			converter(nums, casos);
			if (casos != 1)
				merge(0, casos - 1);
			ans = "";
			for (int i : edades)
				ans += i+" ";
			out.write(ans.substring(0, ans.length() -1)+ "\n");
			linea = in.readLine();
		}
		out.close();
		in.close();
	}

	static void merge(int inf, int sup) {
		if (inf < sup) {
			int mid = inf + (sup - inf) / 2;
			merge(inf, mid);
			merge(mid + 1, sup);
			sort(inf, mid, sup);
		}
	}

	static void sort(int inf, int mid, int sup) {
		for (int i = inf; i <= sup; i++) {
			temp[i] = edades[i];
		}
		int i = inf;
		int j = mid + 1;
		int k = inf;
		while (i <= mid && j <= sup) {
			if (temp[i] <= temp[j]) {
				edades[k] = temp[i];
				i++;
			} else {
				edades[k] = temp[j];
				j++;
			}
			k++;
		}
		while (i <= mid) {
			edades[k] = temp[i];
			k++;
			i++;
		}
	}

	static void converter(String[] array, int length) {
		edades = new int[length];
		temp = new int[length];
		int i = 0;
		for (String s : array) {
			edades[i] = Integer.parseInt(s);
			i++;
		}
	}
}
