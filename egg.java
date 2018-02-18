import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class egg {

	public static void main(String[] args) throws IOException {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(in.readLine());
		int nEggs = Integer.parseInt(stk.nextToken());
		int floors = Integer.parseInt(stk.nextToken());
		int minBroken = floors;
		int maxSafe = 1;
		for (int i = 0; i < nEggs; i++) {
			stk = new StringTokenizer(in.readLine());
			int piso = Integer.parseInt(stk.nextToken());
			String linea = stk.nextToken();
			if (linea.equals("SAFE"))
				maxSafe = Math.max(maxSafe, piso);
			else
				minBroken = Math.min(minBroken, piso);
		}

		out.write((maxSafe + 1) + " " + (minBroken - 1) + "\n");
		out.close();
		in.close();
	}
}
