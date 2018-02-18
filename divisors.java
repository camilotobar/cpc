import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class divisors {

	public static void main(String[] args) throws IOException{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int numeroCasos=Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < numeroCasos; i++) {
			String[] datos=in.readLine().trim().split(" ");
			int divisoresD=Integer.parseInt(datos[0]);
			int multiplosD=Integer.parseInt(datos[1]);
			int suma=0;
			for (int j = 1; j <= Math.sqrt(divisoresD); j++) {
				if(divisoresD%j==0){
					int Menor=j;
					int Mayor=divisoresD/j;
					if(Mayor==Menor){
						if(!(Menor%multiplosD==0)){
							suma+=Menor;
						}
					}
					else{
						if(!(Menor%multiplosD==0)){
							suma+=Menor;
						}
						if(!(Mayor%multiplosD==0)){
							suma+=Mayor;
						}
					}
					
					
					
				}
			}
			out.write(suma+"\n");
			
		}
		out.close();
		in.close();

	}

}
