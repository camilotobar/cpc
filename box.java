import java.io.*;

public class box {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = in.readLine();

		while (line != null && !line.equals("")) {

			int difference = Integer.parseInt(line);
			int ritaBox = Integer.parseInt(in.readLine()) - 4;
			int theoBox = Integer.parseInt(in.readLine()) - 3;
			int candles = 0;

			while ((theoBox * difference) != ritaBox) {
				theoBox++;
				ritaBox--;
				candles++;
			}

			out.write(candles + "\n");
			line = in.readLine();
		}

		out.close();
		in.close();
	}
}
