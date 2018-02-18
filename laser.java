import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;

public class laser {
	
	public static BitSet generadorPrimos(int limite){
		BitSet primos = new BitSet();
		primos.set(0, false);
		primos.set(1, false);
		primos.set(2, limite, true);
		
		for (int i = 0; i*i < limite; i++) {
			if(primos.get(i)){
				for (int j = i*i; j < limite; j+=i) {
					primos.clear(j);
				}
			}
		}
		return primos;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		int numeroCasos=Integer.parseInt(in.readLine().trim());
		BitSet primos = generadorPrimos(100000);
		ArrayList<Integer> numPrimos=new ArrayList<>();
		for (int i = 0; i < primos.size(); i++) {
			if(primos.get(i)){
				numPrimos.add(i);
			}
		}
		for (int i = 0; i < numeroCasos; i++) {
			int numero=Integer.parseInt(in.readLine().trim());

			int resultado=1;
			
			boolean primo = primos.get(numero);
			if(primo)
				out.write((numero-1)+"\n");
			else if(numero==1){
				out.write(0+"\n");
			}
			else{
				int j=0;
				while(numero!=1){
					int divisor=numPrimos.get(j).intValue();
					int contador=0;
					while (numPrimos.get(j).intValue()==divisor){
						if (numero%divisor==0){
							contador++;
							numero/=divisor;
						}else{
							j++;
						}
					}
					if (contador!=0){
						resultado*=(divisor-1)*Math.pow(divisor, contador-1);
					}	
				}

				out.write(resultado+"\n");
			}
			
		}
		out.close();
		in.close();

	}

}
