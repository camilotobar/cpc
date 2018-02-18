import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;

public class royale {

	public static void main(String[]args) throws IOException{
		
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String linea = lector.readLine();
		while (linea!=null){
			char[] letras = linea.toCharArray();
			String id = "1";
			int num = 1;
			char[] nums = new char[letras.length];
			nums[0] = letras[0];
			int cont = 1;
			for (int i = 1; i < letras.length; i++) {
				boolean repetida = false;
				for (int j = 0; j < cont&&!repetida; j++) {
					if (letras[i] == nums[j]){
						repetida = true;
						num = j+1;
					}
				}
				if (!repetida){
					nums[cont]=letras[i];
					cont ++;
					id += cont;
				}
				else{
					id += num;
				}
			}
			char[] temp = (id).toCharArray();
			id = "";
			for (int i = 0; i < temp.length; i++) {
				switch (temp[i]) {
				case '2':
					id += 5;
					break;
				case '5':
					id += 2;
					break;
				case '6':
					id += 9;
					break;
				case '9':
					id += 6;
					break;
				default:
					id += temp[i];
					break;
				}
			}
			System.out.println(id);
			linea = lector.readLine();
		}
	}
}
