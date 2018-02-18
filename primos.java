import java.io.*;
import java.util.*;

public class primos {

	static BufferedReader in;
	static BufferedWriter out;
	static BinarySearchTree tree;

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		int cases = Integer.parseInt(in.readLine());

		while (cases > 0) {
			BinarySearchTree tree = new BinarySearchTree();
			StringTokenizer stk = new StringTokenizer(in.readLine());
			stk.nextToken();
			int ana = Integer.parseInt(stk.nextToken());
			String[] members = in.readLine().split(" ");

			for (String member : members)
				tree.addNode(Integer.parseInt(member));

			TNode maxCousin = tree.search(ana).eldestCousin();
			out.write((maxCousin != null) ? maxCousin.value + "\n" : "No puede salir :(\n");
			cases--;
		}

		out.close();
		in.close();
	}
}

class BinarySearchTree {

	TNode root;

	BinarySearchTree() {
	}

	void addNode(int newValue) {
		if (root != null)
			root.add(newValue);
		else
			root = new TNode(newValue);
	}

	TNode search(int toFind) {
		return (root != null) ? root.search(toFind) : null;
	}
}

class TNode {

	int value;
	TNode parent;
	TNode left;
	TNode right;

	TNode(int value) {
		this.value = value;
	}

	void add(int newValue) {
		if (value > newValue) {
			if (left != null)
				left.add(newValue);
			else {
				left = new TNode(newValue);
				left.parent = this;
			}
		} else if (right != null)
			right.add(newValue);
		else {
			right = new TNode(newValue);
			right.parent = this;
		}
	}

	TNode search(int toFind) {
		if (value == toFind)
			return this;
		if (value > toFind)
			return left.search(toFind);
		return right.search(toFind);
	}

	TNode eldestCousin() {
		TNode cousin = null, uncle = null, grandfather = null;

		if (parent != null && parent.parent != null) {
			grandfather = parent.parent;
			uncle = (parent.isLeftSon()) ? grandfather.right : grandfather.left;

			if (uncle != null)
				cousin = uncle.eldestSon();
		}

		return cousin;
	}

	boolean isLeftSon() {
		return parent.left != null && parent.left.equals(this);
	}

	TNode eldestSon() {
		if (right != null || left != null) {
			int rightValue = (right != null) ? right.value : Integer.MIN_VALUE,
					leftValue = (left != null) ? left.value : Integer.MIN_VALUE;

			int min = Math.max(rightValue, leftValue);
			return (min == rightValue) ? right : left;
		} else
			return null;
	}
}