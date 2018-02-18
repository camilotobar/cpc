import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class allergies {
	public static void main(String[] args) throws IOException{
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		int casos=Integer.parseInt(lector.readLine());
		for (int i = 0; i < casos; i++) {
			String respuestaFinal ="";
			String alergias=lector.readLine();
			
			int comidas=Integer.parseInt(lector.readLine());
			boolean[] caso=new boolean[comidas];
			
			for (int j = 0; j <comidas; j++) {
				respuestaFinal+=lector.readLine()+" ";
			}
			
			String[] arregloComidas=respuestaFinal.split(" ");
			respuestaFinal=respuestaFinal.replaceAll(" ", "");
			String respuesta="";
			
			for (int p = 0; p < respuestaFinal.length(); p++) {
				boolean existe = false;
				for (int j = 0; j < respuesta.length(); j++) {
					if(respuestaFinal.charAt(p) == respuesta.charAt(j)){
						existe = true;
					}
				}
				if(existe == false){
					respuesta+=respuestaFinal.charAt(p);
				}
			}
			String[] alergenos=respuesta.split("");
			respuestaFinal="";
		
			for (int j = 0; j < arregloComidas.length; j++) {
				boolean es=true;
				for (int j2 = 0; j2 < alergias.length()&&es; j2++) {
					if(!(arregloComidas[j].contains(alergias.charAt(j2)+""))){
						es=false;
					}
				}
				caso[j]=es;
			}
			int salir=0;
			for (int j = 0; j < alergenos.length&&salir<2; j++) {
				boolean seguir=true;
				
				for (int j2 = 0; j2 < arregloComidas.length&&seguir; j2++) {
					boolean es=true;
					if(!(arregloComidas[j2].contains(alergenos[j]))){
						es=false;
					}
					if(caso[j2]!=es){
						seguir=false;
					}
				}
				
				
				if(seguir){
					respuestaFinal=alergenos[j];
					salir++;
				}
			}
			
			if(salir==1){
				System.out.println(respuestaFinal);
			}
			else{
				System.out.println("No Solution");
			}
		}
	}

}
