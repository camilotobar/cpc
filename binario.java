import java.io.*;

public class binario {

	static BufferedReader in;
	static PrintWriter out;

	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new File("./docs/outputBinario.txt"));

		int cases = Integer.parseInt(in.readLine());

		while (cases > 0) {
			int number = Integer.parseInt(in.readLine().trim());
			out.write(Integer.toBinaryString(number) + "\n");
			cases--;
		}

		out.close();
		in.close();
	}
}
