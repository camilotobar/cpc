import java.io.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class crossover {

	static double[] stma, ltma;
	static int[] prices;
	static DecimalFormat df;
	static List<String> answer;

	final static int PERIODS_STMA = 60;
	final static int PERIODS_LTMA = 300;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		df = new DecimalFormat("0.0#");
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		df.setDecimalFormatSymbols(dfs);

		int days = Integer.parseInt(in.readLine());
		answer = new ArrayList<String>();
		prices = new int[days];
		stma = new double[days - PERIODS_LTMA + 1];
		ltma = new double[days - PERIODS_LTMA + 1];

		StringTokenizer stk = new StringTokenizer(in.readLine());
		int i = 0;
		while (stk.hasMoreTokens()) {
			prices[i] = Integer.parseInt(stk.nextToken());
			i++;
		}

		calculateMA();

		for (int k = answer.size() - 1; k >= 0; k--)
			out.write(answer.get(k) + "\n");

		out.close();
		in.close();
	}

	static void calculateMA() throws IOException {
		for (int i = prices.length - 1, k = stma.length - 1; k >= 0; i--, k--) {
			double stmaValue = 0, ltmaValue = 0;

			for (int j = i; j > i - PERIODS_STMA; j--)
				stmaValue += prices[j];

			ltmaValue = stmaValue;

			for (int j = i - PERIODS_STMA; j > i - PERIODS_LTMA; j--)
				ltmaValue += prices[j];

			stmaValue /= PERIODS_STMA;
			ltmaValue /= PERIODS_LTMA;

			if (i < prices.length - 1)
				if ((stma[k + 1] != ltma[k + 1] && stmaValue == ltmaValue)
						|| (stma[k + 1] >= ltma[k + 1] && stmaValue < ltmaValue)
						|| (stma[k + 1] <= ltma[k + 1] && stmaValue > ltmaValue))
					answer.add((i + 2) + " " + df.format(stma[k + 1]) + " " + df.format(ltma[k + 1]));

			stma[k] = stmaValue;
			ltma[k] = ltmaValue;
		}
	}
}
