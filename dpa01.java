import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class dpa01 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String linea = br.readLine();

		int casos = Integer.parseInt(linea);

		int n;

		for (int i = 0; i < casos; i++) {

			linea = br.readLine();

			if (!linea.trim().isEmpty()) {

				n = Integer.parseInt(linea);

				bw.write(calcular(n));

			}
			
		}

		bw.close();
		br.close();

	}

	private static String calcular(int n) {

		String resp = "";

		int suma = 0;

		int raiz = (int) Math.sqrt(n);
		
		for (int i = 1; i < n; i++) {
			
			if (n % i == 0) {
				suma += i;
			}

		}

		if (suma > n) {
			resp = "abundant\n";
		} else if (suma < n) {
			resp = "deficient\n";
		} else if (suma == n) {
			resp = "perfect\n";
		}

		return resp;

	}

}
