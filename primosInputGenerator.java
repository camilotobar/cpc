import java.io.*;
import java.util.*;

public class primosInputGenerator {

	public static final String INPUT_ROOT = "./docs/input2.txt";
	static PrintWriter printer;
	static Random rdm;
	static boolean[] ages;

	public static void main(String[] args) throws IOException {
		printer = new PrintWriter(new File(INPUT_ROOT));
		rdm = new Random();
		ages = new boolean[50];
		int casos = 100;
		printer.write(casos + "\n");

		while (casos > 0) {
			Arrays.fill(ages, false);
			int familyMembers = 10 + rdm.nextInt(30), aux = familyMembers;
			int kid = 10 + rdm.nextInt(8);
			printer.write(String.format("%d %d\n", familyMembers, kid));

			while (familyMembers > 0) {
				int possible = 10 + rdm.nextInt(50);
				if (!ages[possible - 10]) {
					ages[possible - 10] = true;
					printer.write(possible + " ");
					familyMembers--;
				}

				if (familyMembers <= aux / 2 && !ages[kid - 10]) {
					printer.write(kid + " ");
					ages[kid - 10] = true;
				}
			}

			printer.write("\n");
			casos--;
		}

		printer.close();
	}
}
