import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class complexity {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String linea = in.readLine();
		char[] chars = linea.toCharArray();
		int[] letras = new int[26];
		Arrays.fill(letras, 10000);
		int cont = 0;
		for (int i = 0; i < chars.length; i++) {
			int index = chars[i]-'a';
			if(letras[index] == 10000){
				letras[index] = 1;
				cont++;
			}
			else
				letras[index]++;
		}
		
		Arrays.sort(letras);
		int answer = 0;
		for (int i = 0; i < cont - 2; i++) {
			answer += letras[i];
		}
		System.out.println(answer);
	}
}
