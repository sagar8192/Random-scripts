import java.util.*;

class Node {
	public String value = null;
	public HashMap<String, Node> children = null;

	public Node(String value) {
		this.value = value;
		this.children = new HashMap<String, Node>();
	}
}

public class Trie {
	public static void main(String[] args) {
		Node root = new Node("*");
		addString(root, "Sagar Patwardhan");
		if (ifContains(root, "Sagarp ")) {
			System.out.println("It is true");
		} else {
			System.out.println("It is false :/");
		}
	}

	public static void insert(Node root, String str) {
		addString(root, str);
	}

	public static boolean ifContains(Node root, String str) {
		String firstChar = null;
		int i=0;
		for(; i<str.length(); ++i) {
			firstChar = Character.toString(str.charAt(i));
			root = root.children.get(firstChar);
			if (root==null) {
				break;
			}
		}
		if (i != str.length()) {
			return false;
		}
		return true;
		
	}

	public static void addString(Node root, String str) {
		if (str.length() == 0) return;
		String firstChar = Character.toString(str.charAt(0));
		Node n = root.children.get(firstChar);
		if (n==null) {
			// Create the new child node for the missing character
			n = new Node(firstChar);
			root.children.put(firstChar, n);	
		}
		if (str.length() > 0) {
			addString(n, str.substring(1));	
		} else {
			return;
		}
	}
}
