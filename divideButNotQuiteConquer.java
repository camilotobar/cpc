import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.io.IOException;
public class divideButNotQuiteConquer {
	
	static ArrayList<String> valores;
	static int m, cont;
	
	static boolean recursividad(int n){
		cont++;
		int value = n/m;
		if(value == 1){
			valores.add(value+"");
			return true;
		}else if(value%m != 0)
			return false;
		else{
			valores.add(value+"");
			return recursividad(value);
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String linea = in.readLine();
		while(linea != null && !linea.equals("")){
			cont = 0;
			valores = new ArrayList<String>();
			String[] nums = linea.split(" ");
			int n = Integer.parseInt(nums[0]);
			valores.add(n+"");
			m = Integer.parseInt(nums[1]);
			if(!recursividad(n))
				out.write("Boring!\n");
			else{
				for (String s: valores)
					out.write(s+" ");
				out.write("\n");
			}
			linea = in.readLine();
		}
		in.close();
		out.close();
	}

}
