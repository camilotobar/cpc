import java.io.*;
import java.util.*;

public class parenthesesBalance {

	static Stack<String> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int casos = Integer.parseInt(in.readLine());
		String linea = "";
		stack = new Stack<String>();

		for (int i = 0; i < casos; i++) {
			linea = in.readLine();
			if (linea.isEmpty())
				out.write("Yes\n");
			else {
				stack = new Stack<String>();
				char[] caracteres = linea.toCharArray();
				boolean accepted = true;
				for (int j = caracteres.length - 1; j >= 0 && accepted; j--)
					accepted = review(caracteres[j]);
				out.write((accepted && stack.isEmpty()) ? "Yes\n" : "No\n");
			}
		}

		out.close();
		in.close();
	}

	static boolean review(char caracter) {
		boolean accepted = true;
		if (caracter == '(' || caracter == ')') {
			if (caracter == ')')
				stack.push(caracter + "");
			else if (stack.isEmpty() || (!stack.isEmpty() && stack.peek().equals("]")))
				accepted = false;
			else
				stack.pop();
		} else {
			if (caracter == ']')
				stack.push(caracter + "");
			else if (stack.isEmpty() || (!stack.isEmpty() && stack.peek().equals(")")))
				accepted = false;
			else
				stack.pop();
		}
		return accepted;
	}
}

class Stack<T> {

	private StackElement topElement;

	public Stack() {

	}

	public void push(T item) {
		StackElement newElement = new StackElement(item);
		StackElement top = topElement;
		newElement.next = top;
		topElement = newElement;
	}

	public T peek() {
		return (!isEmpty()) ? topElement.value : null;
	}

	public T pop() {
		if (!isEmpty()) {
			StackElement current = topElement;
			topElement = current.next;
			return current.value;
		} else
			return null;
	}

	public boolean isEmpty() {
		return topElement == null;
	}

	class StackElement {

		T value;
		StackElement next;

		public StackElement(T value) {
			this.value = value;
		}
	}
}
