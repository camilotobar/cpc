import java.io.*;

public class rotations {

	static boolean[] datos;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			datos = new boolean[32];
			long xd = Long.parseLong(in.readLine());
			int actual = (int) xd;
			int mask = 31;

			for (int j = 0; j < 32; j++) {
				actual = Integer.rotateRight(actual, j);
				int dif = actual & mask;
				if (!datos[dif])
					datos[dif] = true;

			}
			boolean ok = true;
			for (int j = 0; j < datos.length; j++) {
				if (!datos[j]) {
					ok = false;
					break;
				}
			}

			out.write(ok ? "yes\n" : "no\n");
		}

		out.close();
		in.close();
	}
}
