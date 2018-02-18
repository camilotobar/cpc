import java.io.*;

public class cadenas {

	static final char X = 'x';
	static final char P = '+';
	static final char T = '-';

	static BufferedReader in;
	static PrintWriter out;
	static char[] pattern;
	static char[] string;

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new File("./docs/output.txt"));
		int cases = Integer.parseInt(in.readLine());

		for (int i = 0; i < cases; i++) {
			string = in.readLine().toCharArray();
			pattern = in.readLine().toCharArray();
			crazyString();

			out.write(String.format("Cadena Loca %d: ", i));
			for (char character : string)
				out.write(character);
			out.write("\n");
		}

		out.close();
		in.close();
	}

	static void crazyString() {
		for (int i = 0, j = 0; i < string.length; i++, j++) {
			if (j == pattern.length)
				j = 0;

			if (pattern[j] != X)
				changeChar((pattern[j] == P) ? P : T, i);
		}
	}

	static void changeChar(char type, int index) {
		char character = string[index];
		character += (type == P) ? 1 : -1;

		if (character == 64)
			character = 'Z';
		else if (character == 91)
			character = 'A';
		string[index] = character;
	}
}
