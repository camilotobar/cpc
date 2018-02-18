import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class acronyms {
	public static void main(String[] args) throws IOException{
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String linea=lector.readLine();
		while(linea!=null){
			String[] arreglo1=linea.split(" ");
			linea=lector.readLine();
			String[] arreglo2=linea.split(" ");
			boolean salir=true;
			for (int i = 0; i < arreglo1.length&&salir; i++) {
				if(arreglo1[i].charAt(0)!=arreglo2[i].charAt(0)){
					salir=false;
				}
			}
			if(salir){
				System.out.println("yes");
			}
			else{
				System.out.println("no");
			}
			linea=lector.readLine();
		}
		
		
		
		
	}
}
