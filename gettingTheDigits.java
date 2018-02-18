import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class gettingTheDigits {

	public static void main(String[] args) throws IOException{
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(lector.readLine());
		
		for (int i = 0; i < casos; i++) {
			String linea = lector.readLine();
			String numeroTel = "";			
			int cont0 = 0, cont1 = 0, cont2 = 0, cont3 = 0, cont4 = 0, cont5 = 0, cont6 = 0, cont7 = 0, cont8 = 0, cont9 = 0;
			
			for (int j = 0; j < linea.length(); j++) {
				if(linea.charAt(j) == 'Z'){
					cont0++;
				}
			}
			
			for (int j = 0; j < cont0; j++) {
				linea = linea.replaceFirst("Z", "");
				linea = linea.replaceFirst("E", "");
				linea = linea.replaceFirst("R", "");
				linea = linea.replaceFirst("O", "");
			}
			
			for (int j = 0; j < linea.length(); j++) {
				if(linea.charAt(j) == 'W'){
					cont2++;
				}
			}
			
			for (int j = 0; j < cont2; j++) {
				linea = linea.replaceFirst("T", "");
				linea = linea.replaceFirst("W", "");
				linea = linea.replaceFirst("O", "");
			}
			
			for (int j = 0; j < linea.length(); j++) {
				if(linea.charAt(j) == 'U'){
					cont4++;
				}
			}
			
			for (int j = 0; j < cont4; j++) {
				linea = linea.replaceFirst("F", "");
				linea = linea.replaceFirst("O", "");
				linea = linea.replaceFirst("U", "");
				linea = linea.replaceFirst("R", "");
			}
			
			for (int j = 0; j < linea.length(); j++) {
				if(linea.charAt(j) == 'X'){
					cont6++;
				}
			}
			
			for (int j = 0; j < cont6; j++) {
				linea = linea.replaceFirst("S", "");
				linea = linea.replaceFirst("I", "");
				linea = linea.replaceFirst("X", "");
			}
			
			for (int j = 0; j < linea.length(); j++) {
				if(linea.charAt(j) == 'G'){
					cont8++;
				}
			}
			
			for (int j = 0; j < cont8; j++) {
				linea = linea.replaceFirst("E", "");
				linea = linea.replaceFirst("I", "");
				linea = linea.replaceFirst("G", "");
				linea = linea.replaceFirst("H", "");
				linea = linea.replaceFirst("T", "");
			}	
			
			for (int j = 0; j < linea.length(); j++) {
				if(linea.charAt(j) == 'T'){
					cont3++;
				}
			}
			
			for (int j = 0; j < cont3; j++) {
				linea = linea.replaceFirst("T", "");
				linea = linea.replaceFirst("H", "");
				linea = linea.replaceFirst("R", "");
				linea = linea.replaceFirst("E", "");
				linea = linea.replaceFirst("E",	"");
			}
			
			for (int j = 0; j < linea.length(); j++) {
				if(linea.charAt(j) == 'F'){
					cont5++;
				}
			}
			
			for (int j = 0; j < cont5; j++) {
				linea = linea.replaceFirst("F", "");
				linea = linea.replaceFirst("I", "");
				linea = linea.replaceFirst("V", "");
				linea = linea.replaceFirst("E", "");
			}
			
			for (int j = 0; j < linea.length(); j++) {
				if(linea.charAt(j) == 'S'){
					cont7++;
				}
			}
			
			for (int j = 0; j < cont7; j++) {
				linea = linea.replaceFirst("S", "");
				linea = linea.replaceFirst("E", "");
				linea = linea.replaceFirst("V", "");
				linea = linea.replaceFirst("E", "");
				linea = linea.replaceFirst("N",	"");
			}
			
			for (int j = 0; j < linea.length(); j++) {
				if(linea.charAt(j) == 'O'){
					cont1++;
				}
			}
			
			for (int j = 0; j < cont1; j++) {
				linea = linea.replaceFirst("O", "");
				linea = linea.replaceFirst("N", "");
				linea = linea.replaceFirst("E", "");
			}
			
			for (int j = 0; j < linea.length(); j++) {
				if(linea.charAt(j) == 'I'){
					cont9++;
				}
			}
			
			for (int j = 0; j < cont0; j++) {
				numeroTel += 0+"";
			}
			for (int j = 0; j < cont1; j++) {
				numeroTel += 1+"";
			}
			for (int j = 0; j < cont2; j++) {
				numeroTel += 2+"";
			}
			for (int j = 0; j < cont3; j++) {
				numeroTel += 3+"";
			}
			for (int j = 0; j < cont4; j++) {
				numeroTel += 4+"";
			}
			for (int j = 0; j < cont5; j++) {
				numeroTel += 5+"";
			}
			for (int j = 0; j < cont6; j++) {
				numeroTel += 6+"";
			}
			for (int j = 0; j < cont7; j++) {
				numeroTel += 7+"";
			}
			for (int j = 0; j < cont8; j++) {
				numeroTel += 8+"";
			}
			for (int j = 0; j < cont9; j++) {
				numeroTel += 9+"";
			}
			
			System.out.println("Case #"+(i+1)+": "+numeroTel);
		}
	}
}
