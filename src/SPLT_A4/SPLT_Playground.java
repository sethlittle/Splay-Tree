package SPLT_A4;

public class SPLT_Playground {
	public static void main(String[] args) {
		genTest();
	}

	public static void genTest() {
		SPLT tree = new SPLT();

		tree.insert("D");
		tree.insert("I");
		tree.insert("B");
		tree.insert("G");
		tree.insert("F");
		tree.insert("E");
		tree.insert("H");
		tree.insert("C");
		tree.insert("J");
		tree.insert("A");
		tree.remove("E");
		tree.remove("H");
		tree.remove("A");
		tree.remove("J");

		// System.out.println("size is " + tree.size());
		// System.out.println("height: " + tree.height());
		// tree.insert("hello");
		// System.out.println(tree.getRoot() == null);
		// System.out.println("size is " + tree.size());
		// tree.insert("world");
		// System.out.println("height: " + tree.height());
		// System.out.println(tree.getRoot() == null);
		// System.out.println("size is " + tree.size());
		// tree.insert("my");
		// System.out.println(tree.getRoot() == null);
		// System.out.println("size is " + tree.size());
		// tree.insert("name");
		// System.out.println(tree.getRoot() == null);
		// System.out.println("size is " + tree.size());
		// tree.insert("is");
		// System.out.println(tree.getRoot() == null);
		// System.out.println("size is " + tree.size());
		// tree.insert("blank");
		// System.out.println(tree.getRoot() == null);
		// System.out.println("size is " + tree.size());
		// System.out.println("height: " + tree.height());
		//
		// tree.remove("hello");
		// System.out.println(tree.getRoot() == null);
		// System.out.println("size is " + tree.size());
		// System.out.println("height: " + tree.height());

		printLevelOrder(tree);

		// tree.insert("B");
		// printLevelOrder(tree);
		// System.out.println(tree.getRoot() == null);
		// System.out.println(tree.getRoot().getData());
		// System.out.println("size: " + tree.size());
		// tree.insert("A");
		// printLevelOrder(tree);
		// System.out.println(tree.getRoot() == null);
		// System.out.println(tree.getRoot().getData());
		//
		// System.out.println("size: " + tree.size());
		// tree.insert("D");
		// // printLevelOrder(tree);
		// System.out.println(tree.getRoot() == null);
		// System.out.println(tree.getRoot().getData());
		//
		// System.out.println("size: " + tree.size());
		// tree.remove("A");
		// // printLevelOrder(tree);
		// System.out.println("size: " + tree.size());
		// // printLevelOrder(tree);
		// tree.remove("D");
		// System.out.println("size: " + tree.size());

		// tree.insert("E");
		// System.out.println("size: " + tree.size());
		// tree.remove("A");
		// System.out.println("size: " + tree.size());
		// tree.remove("B");
		// System.out.println("size: " + tree.size());
		// tree.remove("C");
		// System.out.println("size: " + tree.size());
		// tree.remove("D");
		// System.out.println("size: " + tree.size());
		// tree.remove("E");
		// System.out.println("size: " + tree.size());

		// tree.insert("A");
		// printLevelOrder(tree);
		//
		// System.out.println("size: " + tree.size());
		// tree.insert("B");
		// printLevelOrder(tree);
		//
		// System.out.println("size: " + tree.size());
		// tree.insert("C");
		// printLevelOrder(tree);

		// tree.insert("B");
		// // System.out.println(tree.getRoot().getData());
		// // System.out.println(tree.getRoot().getLeft() == null);
		// // System.out.println(tree.getRoot().getRight() == null);
		// System.out.println("size(1): " + tree.size());
		// printLevelOrder(tree);
		//
		// tree.insert("A");
		// // System.out.println(tree.getRoot().getData());
		// // System.out.println(tree.getRoot().getLeft() == null);
		// // System.out.println(tree.getRoot().getRight() == null);
		// // System.out.println(tree.getRoot().getRight().getLeft() == null);
		// // System.out.println(tree.getRoot().getRight().getRight() == null);
		//
		// System.out.println("size(2): " + tree.size());
		// int h = tree.height();
		// System.out.println("height(1): " + h);
		//
		// printLevelOrder(tree);
		//
		// // tree.insert("D");
		// // System.out.println(tree.getRoot().getData());
		// // System.out.println(tree.getRoot().getLeft() == null);
		// // System.out.println(tree.getRoot().getLeft().getLeft() == null);
		// // System.out.println(tree.getRoot().getLeft().getRight() == null);
		// // System.out.println("size: " + tree.size());
		//
		// tree.insert("C");
		// System.out.println("size(3): " + tree.size());
		// printLevelOrder(tree);
		//
		// // tree.remove("A");
		// // System.out.println("size: " + tree.size());
		// //
		// // tree.remove("B");
		// // System.out.println("size: " + tree.size());
		//
		// tree.remove("C");
		// System.out.println("size(2): " + tree.size());
		//
		// System.out.println("root(B): " + tree.getRoot().getData());
		// h = tree.height();
		// System.out.println("height(1): " + h);
		// printLevelOrder(tree);

		// tree.remove("E");
		// System.out.println("size: " + tree.size());

		//
		// tree.insert("C");
		// System.out.println(tree.getRoot().getData());
		// System.out.println(tree.getRoot().getLeft() == null);
		// System.out.println(tree.getRoot().getRight() == null);
		// System.out.println("size: " + tree.size());
		//
		// tree.insert("E");
		// System.out.println(tree.getRoot().getData());
		// System.out.println(tree.getRoot().getLeft() == null);
		// System.out.println(tree.getRoot().getRight() == null);
		// System.out.println("size: " + tree.size());

		// tree.insert("C");
		// tree.insert("D");
		// tree.insert("B");
		// tree.insert("F");
		// tree.insert("E");
		// System.out.println(tree.getRoot().getData());
		// System.out.println("size: " + tree.size());
		// int h = tree.height();
		// System.out.println("height(3): " + h);
		//
		// tree.remove("C");
		// System.out.println(tree.getRoot().getData());
		// System.out.println("size: " + tree.size());
		// h = tree.height();
		// System.out.println("height(2): " + h);
		// printLevelOrder(tree);
		// System.out.println(tree.getRoot().getRight().getRight() == null);

		// tree.insert("B");
		// tree.insert("A");
		// tree.insert("C");
		// System.out.println(tree.getRoot().getData());
		// System.out.println("size: " + tree.size());
		// int h = tree.height();
		// System.out.println("height(2): " + h);
		// printLevelOrder(tree);

		// tree.insert("B");
		// System.out.println("size: " + tree.size());
		//
		// tree.insert("A");
		// System.out.println("size: " + tree.size());
		//
		// tree.insert("D");
		// System.out.println("size: " + tree.size());
		//
		// tree.insert("C");
		// System.out.println("size: " + tree.size());
		//
		// tree.insert("E");
		// System.out.println("size: " + tree.size());
		//
		// tree.remove("B");
		// System.out.println("size: " + tree.size());
		//
		// tree.remove("A");
		// System.out.println("size: " + tree.size());
		//
		// tree.remove("D");
		// System.out.println("size: " + tree.size());
		//
		// tree.remove("C");
		// System.out.println("size: " + tree.size());
		//
		// tree.remove("E");
		// System.out.println("size: " + tree.size());

	}

	static void printLevelOrder(SPLT tree) {
		// will print your current tree in Level-Order...Requires a correct
		// height method
		// https://en.wikipedia.org/wiki/Tree_traversal
		int h = tree.height();
		for (int i = 0; i <= h; i++) {
			System.out.print("Level " + i + ":");
			printGivenLevel(tree.getRoot(), i);
			System.out.println();
		}

	}

	static void printGivenLevel(BST_Node root, int level) {
		if (root == null)
			return;
		if (level == 0)
			System.out.print(root.data + " ");
		else if (level > 0) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	static void printInOrder(BST_Node root) {
		if (root != null) {
			printInOrder(root.getLeft());
			System.out.print(root.getData() + " ");
			printInOrder(root.getRight());
		}
	}

}
