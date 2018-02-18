import java.io.*;
import java.util.*;

public class bigChocolate {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = in.readLine();
		StringTokenizer size;
		int rows, columns;
		while (line != null && !line.equals("")) {
			size = new StringTokenizer(line);
			rows = Integer.parseInt(size.nextToken());
			columns = Integer.parseInt(size.nextToken());
			out.write((rows == 1 && columns == 1) ? 0 + "\n" : (rows * columns) - 1 + "\n");
			line = in.readLine();
		}
		out.close();
		in.close();
	}

	static int splitChocolate(int startRow, int endRow, int startColumn, int endColumn) {
		if (startRow != endRow) {
			int mitad = (startRow + endRow) / 2;
			return 1 + splitChocolate(startRow, mitad, startColumn, endColumn)
					+ splitChocolate(mitad + 1, endRow, startColumn, endColumn);
		} else if (startRow == endRow && startColumn != endColumn) {
			int mitad = (startColumn + endColumn) / 2;
			return 1 + splitChocolate(startRow, endRow, startColumn, mitad)
					+ splitChocolate(startRow, endRow, mitad + 1, endColumn);
		} else
			return 0;
	}
}
