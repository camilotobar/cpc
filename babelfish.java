import java.io.*;
import java.util.*;

public class babelfish {

	static HashMap<String, String> hash;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String linea = in.readLine();
		hash = new HashMap<String, String>();
		while (!linea.equals("")) {
			String[] caso = linea.split(" ");
			hash.put(caso[1], caso[0]);
			linea = in.readLine();
		}

		linea = in.readLine();
		while (linea != null && !linea.equals("")) {
			System.out.println(linea);
			String ans = hash.get(linea);
			out.write((ans != null) ? "eh\n" : ans + "\n");
			linea = in.readLine();
		}

		out.close();
		in.close();
	}

}
