import java.io.*; 
import java.util.*;

public class easyQueue {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		long queries = Long.parseLong(in.readLine());
		String query = "";
		ArrayList<String> fakeCola = new ArrayList<String>();
		String[] caracteres;

		for (int i = 0; i < queries; i++) {
			query = in.readLine();
			caracteres = query.split(" ");
			if (caracteres[0].equals("1"))
				fakeCola.add(caracteres[1]);
			else if (caracteres[0].equals("2") && !fakeCola.isEmpty())
				fakeCola.remove(0);
			else if (caracteres[0].equals("3"))
				out.write((fakeCola.isEmpty()) ? "Empty!\n" : fakeCola.get(0) + "\n");
		}

		out.close();
		in.close();
	}
}