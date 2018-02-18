import java.io.*;

public class sequence {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(in.readLine());

		for (int i = 0; i < n; i++) {
			long s = Long.parseLong(in.readLine());
			long calculito = (s * s) + (2 * s);
			out.write(calculito + "\n");
		}
		in.close();
		out.close();
	}
}