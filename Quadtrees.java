import java.io.*;
import java.util.*;

public class Quadtrees {

	static boolean[] image1, image2, ansImg;
	static String lineImg1, lineImg2;
	static BufferedWriter out;
	static BufferedReader in;

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		image1 = new boolean[16];
		image2 = new boolean[16];
		ansImg = new boolean[16];

		int cases = Integer.parseInt(in.readLine().trim());

		for (int i = 0; i < cases; i++) {
			Arrays.fill(image1, false);
			Arrays.fill(image2, false);
			Arrays.fill(ansImg, false);

			lineImg1 = in.readLine();
			lineImg2 = in.readLine();

			fillArray(lineImg1.substring(1), image1);
			fillArray(lineImg2.substring(1), image2);
			compareArrays();

			out.write("There are " + (blackPixels() * 64) + " black pixels.\n");
		}

		in.close();
		out.close();
	}

	static void fillArray(String line, boolean[] array) {

		int arrayIndex = 0;
		while (line != null && !line.equals("")) {
			try {
				if (line.charAt(0) == 'p') {
					for (int j = 1; j < 5; j++) {
						array[arrayIndex] = line.charAt(j) == 'f';
						arrayIndex++;
					}

					line = line.substring(5);
				} else {
					char all = line.charAt(0);
					for (int j = 1; j < 5; j++) {
						array[arrayIndex] = all == 'f';
						arrayIndex++;
					}

					line = line.substring(1);
				}
			} catch (StringIndexOutOfBoundsException e) {
				line = "";
			}
		}

	}

	static void compareArrays() {
		for (int i = 0; i < ansImg.length; i++)
			ansImg[i] = image1[i] || image2[i];
	}

	static int blackPixels() {
		int pixels = 0;
		for (boolean b : ansImg)
			if (b)
				pixels++;
		return pixels;
	}
}
