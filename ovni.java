import java.io.*;
import java.util.*;

public class ovni {

	static final char COW = 'C';
	static final char NOTHING = '*';

	static final char VERTICAL = 'V';
	static final char DIAGONAL = 'D';
	static final char HORIZONTAL = 'H';
	static final char POINT = 'P';

	static BufferedReader in;
	static PrintWriter out;
	static boolean[][] barnyard;

	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new File("./docs/outputOvnis.txt"));

		String line = in.readLine();
		StringTokenizer data;

		while (line != null) {
			data = new StringTokenizer(line);
			int rows = Integer.parseInt(data.nextToken());
			int columns = Integer.parseInt(data.nextToken());
			int ovnis = Integer.parseInt(data.nextToken());

			barnyard = new boolean[rows][columns];
			for (int i = 0; i < rows; i++) {
				char[] state = in.readLine().toCharArray();
				for (int j = 0; j < columns; j++)
					barnyard[i][j] = state[j] == COW;
			}

			while (ovnis > 0) {
				data = new StringTokenizer(in.readLine());
				ovniPass(data.nextToken().charAt(0), Integer.parseInt(data.nextToken()),
						Integer.parseInt(data.nextToken()));
				ovnis--;
			}

			for (boolean[] row : barnyard) {
				for (boolean b : row)
					out.write((b) ? COW : NOTHING);
				out.write("\n");
			}

			line = in.readLine();
		}

		out.close();
		in.close();
	}

	static void ovniPass(char type, int rowIndex, int columnIndex) {
		switch (type) {
		case HORIZONTAL:
			Arrays.fill(barnyard[rowIndex], false);
			break;
		case POINT:
			barnyard[rowIndex][columnIndex] = false;
			break;
		case VERTICAL:
			for (int i = 0; i < barnyard.length; i++)
				barnyard[i][columnIndex] = false;
			break;
		default:
			barnyard[rowIndex][columnIndex] = false;
			// To up
			for (int i = rowIndex - 1, j = columnIndex - 1; i > 0 && j > 0; i--, j--)
				barnyard[i][j] = false;

			// To down
			for (int i = rowIndex + 1, j = columnIndex + 1; i < barnyard.length && j < barnyard[0].length; i++, j++)
				barnyard[i][j] = false;
			break;
		}
	}
}
