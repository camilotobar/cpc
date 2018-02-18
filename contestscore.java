import java.io.*;
import java.util.*;

public class contestscore {
	static BufferedReader in;

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Problem> currentProblems = new PriorityQueue<>();

		String array[] = in.readLine().split(" ");
		int k = Integer.parseInt(array[1]);
		long counter = 0, submissionTime = 0;

		for (int i = 0; i < k; i++) {
			String time = in.readLine();
			int problemTime = Integer.parseInt(time);
			currentProblems.add(new Problem(problemTime));
		}

		while (!currentProblems.isEmpty()) {
			counter += currentProblems.poll().time;
			submissionTime += counter;

			String time = in.readLine();
			if (time != null && !time.equals("")) {
				int problemTime = Integer.parseInt(time);
				currentProblems.add(new Problem(problemTime));
			}
		}

		System.out.println(submissionTime);
	}
}

class Problem implements Comparable<Problem> {

	int time;

	Problem(int time) {
		this.time = time;
	}

	@Override
	public int compareTo(Problem anotherProblem) {
		return time - anotherProblem.time;
	}
}
