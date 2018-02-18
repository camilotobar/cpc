import java.io.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;

public class mass {

	static final double CARBON = 12.01;
	static final double HYDROGEN = 1.008;
	static final double OXYGEN = 16.00;
	static final double NITROGEN = 14.01;
	static double[] atoms;
	static DecimalFormat df;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		atoms = new double[4];
		df = new DecimalFormat("0.000");
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		df.setDecimalFormatSymbols(dfs);

		int cases = Integer.parseInt(in.readLine());

		for (int i = 0; i < cases; i++) {

			Arrays.fill(atoms, 0);
			char[] formula = in.readLine().toCharArray();

			for (int j = 0; j < formula.length; j++) {
				String num = "";
				switch (formula[j]) {
				case 'C':
					if (((j + 1) <= formula.length - 1) && formula[j + 1] != 'C' && formula[j + 1] != 'H'
							&& formula[j + 1] != 'O' && formula[j + 1] != 'N')
						num = formula[j + 1] + "";
					if (!(num.equals("")) && ((j + 2) <= formula.length - 1) && formula[j + 2] != 'C'
							&& formula[j + 2] != 'H' && formula[j + 2] != 'O' && formula[j + 2] != 'N')
						num += formula[j + 2] + "";

					atoms[0] += (!num.equals("")) ? Integer.parseInt(num) : 1;
					break;
				case 'H':
					if (((j + 1) <= formula.length - 1) && formula[j + 1] != 'C' && formula[j + 1] != 'H'
							&& formula[j + 1] != 'O' && formula[j + 1] != 'N')
						num = formula[j + 1] + "";
					if (!(num.equals("")) && ((j + 2) <= formula.length - 1) && formula[j + 2] != 'C'
							&& formula[j + 2] != 'H' && formula[j + 2] != 'O' && formula[j + 2] != 'N')
						num += formula[j + 2] + "";
					atoms[1] += (!num.equals("")) ? Integer.parseInt(num) : 1;
					break;
				case 'O':
					if (((j + 1) <= formula.length - 1) && formula[j + 1] != 'C' && formula[j + 1] != 'H'
							&& formula[j + 1] != 'O' && formula[j + 1] != 'N')
						num = formula[j + 1] + "";
					if (!(num.equals("")) && ((j + 2) <= formula.length - 1) && formula[j + 2] != 'C'
							&& formula[j + 2] != 'H' && formula[j + 2] != 'O' && formula[j + 2] != 'N')
						num += formula[j + 2] + "";
					atoms[2] += (!num.equals("")) ? Integer.parseInt(num) : 1;
					break;
				case 'N':
					if (((j + 1) <= formula.length - 1) && formula[j + 1] != 'C' && formula[j + 1] != 'H'
							&& formula[j + 1] != 'O' && formula[j + 1] != 'N')
						num = formula[j + 1] + "";
					if (!(num.equals("")) && ((j + 2) <= formula.length - 1) && formula[j + 2] != 'C'
							&& formula[j + 2] != 'H' && formula[j + 2] != 'O' && formula[j + 2] != 'N')
						num += formula[j + 2] + "";

					atoms[3] += (!num.equals("")) ? Integer.parseInt(num) : 1;
					break;
				}
			}

			double molarMass = (atoms[0] * CARBON) + (atoms[1] * HYDROGEN) + (atoms[2] * OXYGEN)
					+ (atoms[3] * NITROGEN);
			out.write(df.format(molarMass) + "\n");
		}

		out.close();
		in.close();
	}
}
