import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.BitSet;

public class primesum {
	
	public static BitSet calcularPrimos(int limit){
		BitSet primos = new BitSet();
		primos.set(0, false);
		primos.set(1, false);
		primos.set(2, limit, true);
		
		for (int i = 0; i * i < limit; i++){
			if (primos.get(i)){
				for (int j = i * i; j < limit; j += i){
					primos.clear(j);
				}
			}
		}
		return primos;
	}
		
	public static int sumaDigs (String num) {
		int dig = 0;
		for (int i = 0; i < num.length(); i++) {
			int nm = Integer.parseInt(num.charAt(i)+"");
			dig += nm;
		}
		return dig;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String linea = "";
		BitSet pp = calcularPrimos(10000000);
		
		while(linea != null){
			linea = lector.readLine();
			if(linea != null){
				int cont =0;
				String[] lns = linea.split(" ");
				Long num1 = Long.parseLong(lns[0]);
				Long num2 = Long.parseLong(lns[1]);
								
				for (Long i = num1; i <= num2; i++) {
					String num = i+"";
					int sumaDig = sumaDigs(num);
						if(pp.get(sumaDig)){
							cont++;
						}
				}
				 System.out.println(cont);
			}
		}
		lector.close();
	}
}
