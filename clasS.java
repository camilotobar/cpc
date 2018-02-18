import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class clasS {

	public static void main(String[] args) throws IOException {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(in.readLine());
		String[] names = new String[casos];
		String[] apellidos = new String[casos];
		
		for (int i = 0; i < casos; i++){
			String[] cas = in.readLine().split(" ");
			names[i] = cas[1]+" "+cas[0];
		}
		
		Arrays.sort(names);
		for (int i = 0; i < names.length; i++) {
			String[] res = names[i].split(" ");
			System.out.println(res[1]+" "+res[0]);
		}
	}

}
