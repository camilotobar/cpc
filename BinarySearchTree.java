import java.io.*;
import java.util.*;

public class BinarySearchTree {

	static BST<Integer, Integer> tree;
	static BufferedWriter out;
	static BufferedReader in;

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = in.readLine();
		tree = new BST<Integer, Integer>();
		while (line != null && !line.equals("")) {
			int node = Integer.parseInt(line.trim());
			tree.add(node, node);
			line = in.readLine();
		}

		List<BSTNode<Integer, Integer>> preOrdenNodes = tree.postOrden();

		for (BSTNode<Integer, Integer> nd : preOrdenNodes)
			out.write(nd.getValue() + "\n");

		out.close();
		in.close();
	}
}

class BST<T, K extends Comparable<K>> {

	private BSTNode<T, K> root;

	public BST() {

	}

	public BSTNode<T, K> getRoot() {
		return root;
	}

	public void setRoot(BSTNode<T, K> root) {
		this.root = root;
	}

	public BSTNode<T, K> search(K key) {
		if (root == null)
			return null;
		return root.search(key);
	}

	public void add(T value, K key) {
		if (root == null)
			root = new BSTNode<T, K>(value, key);
		else
			root.add(new BSTNode<T, K>(value, key));
	}

	public List<BSTNode<T, K>> inOrden() {
		if (root != null)
			return root.inOrden();
		return new ArrayList<BSTNode<T, K>>();
	}

	public List<BSTNode<T, K>> preOrden() {
		if (root != null)
			return root.preOrden();
		return new ArrayList<BSTNode<T, K>>();
	}

	public List<BSTNode<T, K>> postOrden() {
		if (root != null)
			return root.postOrden();
		return new ArrayList<BSTNode<T, K>>();
	}

	public void printTree() {
		List<BSTNode<T, K>> nodos = inOrden();
		String[] array = new String[nodos.size()];
		for (int i = 0; i < nodos.size(); i++)
			array[i] = (String) nodos.get(i).getValue();

		System.out.println(Arrays.toString(array));
	}
}

class BSTNode<T, K extends Comparable<K>> implements Cloneable {

	private T value;
	private K key;
	private BSTNode<T, K> parent;
	private BSTNode<T, K> left;
	private BSTNode<T, K> right;

	public BSTNode(T value, K key) {
		this.value = value;
		this.key = key;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public BSTNode<T, K> getParent() {
		return parent;
	}

	public void setParent(BSTNode<T, K> parent) {
		this.parent = parent;
	}

	public BSTNode<T, K> getLeft() {
		return left;
	}

	public void setLeft(BSTNode<T, K> left) {
		this.left = left;
	}

	public BSTNode<T, K> getRight() {
		return right;
	}

	public void setRight(BSTNode<T, K> right) {
		this.right = right;
	}

	public boolean isLeaf() {
		return right == null && left == null;
	}

	public void add(BSTNode<T, K> newNode) throws YaExisteClaveException {
		if (key.compareTo(newNode.key) == 0)
			throw new YaExisteClaveException();
		else if (key.compareTo(newNode.key) < 0)
			if (right != null)
				right.add(newNode);
			else {
				newNode.setParent(this);
				right = newNode;
			}
		else if (left != null)
			left.add(newNode);
		else {
			newNode.setParent(this);
			left = newNode;
		}
	}

	public BSTNode<T, K> search(K toSearch) {
		if (key.compareTo(toSearch) == 0)
			return this;
		else if (key.compareTo(toSearch) < 0)
			return (right != null) ? right.search(toSearch) : null;
		else
			return (left != null) ? left.search(toSearch) : null;
	}

	public BSTNode<T, K> minimum() {
		if (left != null)
			return left.minimum();
		return this;
	}

	public BSTNode<T, K> maximum() {
		if (right != null)
			return right.maximum();
		return this;
	}

	public BSTNode<T, K> successor() {
		if (right != null)
			return right.minimum();
		if (parent.left != null && parent.left.getKey().compareTo(key) == 0)
			return parent;
		return successor(parent);
	}

	public BSTNode<T, K> successor(BSTNode<T, K> actual) {
		if (actual.parent != null && actual.parent.right != null && actual.parent.right.key.compareTo(actual.key) == 0)
			return successor(actual.parent);
		return actual.parent;
	}

	public BSTNode<T, K> predecessor() {
		if (left != null)
			return left.maximum();
		if (parent.right != null && parent.right.getKey().compareTo(key) == 0)
			return parent;
		return predecessor(parent);
	}

	public BSTNode<T, K> predecessor(BSTNode<T, K> actual) {
		if (actual.parent != null && actual.parent.left != null && actual.parent.left.key.compareTo(actual.key) == 0)
			return predecessor(actual.parent);
		return actual.parent;
	}

	public List<BSTNode<T, K>> inOrden() {
		List<BSTNode<T, K>> list = new ArrayList<BSTNode<T, K>>();
		if (left != null)
			list.addAll(left.inOrden());

		list.add(this);

		if (right != null)
			list.addAll(right.inOrden());
		return list;
	}

	public List<BSTNode<T, K>> preOrden() {
		List<BSTNode<T, K>> list = new ArrayList<BSTNode<T, K>>();
		list.add(this);

		if (left != null)
			list.addAll(left.inOrden());

		if (right != null)
			list.addAll(right.inOrden());
		return list;
	}

	public List<BSTNode<T, K>> postOrden() {
		List<BSTNode<T, K>> list = new ArrayList<BSTNode<T, K>>();
		if (left != null)
			list.addAll(left.postOrden());

		if (right != null)
			list.addAll(right.postOrden());

		list.add(this);
		return list;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class YaExisteClaveException extends RuntimeException {

	public YaExisteClaveException() {
		super();
	}

	public YaExisteClaveException(String mensaje) {
		super(mensaje);
	}
}
