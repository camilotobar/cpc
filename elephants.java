import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class elephants {

	public static void main(String[] args)throws IOException {
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(lector.readLine());
		
		for (int i = 0; i < casos; i++) {
			int respuesta =0;
			String[] datos = lector.readLine().split(" ");
			int numEps = Integer.parseInt(datos[0]);
			int maxPeso = Integer.parseInt(datos[1]);
			
			String[] pesos = lector.readLine().split(" ");
			int[] pesosPorE = new int[numEps];
			
			for (int j = 0; j < numEps; j++) {
				pesosPorE[j] = Integer.parseInt(pesos[j]);
			}
			
			Arrays.sort(pesosPorE);
			boolean noMas = false;
			
			for (int j = 0; j < pesosPorE.length && noMas == false; j++) {
				if(pesosPorE[j] < maxPeso){
					respuesta++;
					maxPeso -= pesosPorE[j];
				}else{
					noMas = true;
				}
			}
			
			System.out.println(respuesta);
		}
		
	}

}
